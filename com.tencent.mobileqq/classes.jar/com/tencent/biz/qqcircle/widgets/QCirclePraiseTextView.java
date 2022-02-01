package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class QCirclePraiseTextView
  extends TextView
  implements SimpleEventReceiver
{
  static final ConcurrentHashMap<String, QCirclePolyPraiseUpdateEvent> a = new ConcurrentHashMap();
  private FeedCloudMeta.StFeed b = new FeedCloudMeta.StFeed();
  private String c;
  
  public QCirclePraiseTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePraiseTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePraiseTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (paramInt >= 1)
    {
      setVisibility(0);
      String str = QCirclePluginUtil.d(paramInt);
      RFWTypefaceUtil.a(this, false);
      setText(str);
      return;
    }
    if (TextUtils.isEmpty(this.c))
    {
      setVisibility(8);
      return;
    }
    setTypeface(Typeface.DEFAULT);
    setText(this.c);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
    if (a.containsKey(this.b.id.get())) {
      onReceiveEvent((SimpleBaseEvent)a.get(this.b.id.get()));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    a.remove(this.b.id.get());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    FeedCloudMeta.StFeed localStFeed = this.b;
    if ((localStFeed != null) && ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      if (localStFeed.id.get().equals(paramSimpleBaseEvent.mTargetFeedId))
      {
        int i = paramSimpleBaseEvent.mPraisedNum;
        this.b.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.b.likeInfo.count.set(i);
        a(i);
        return;
      }
      a.put(paramSimpleBaseEvent.mTargetFeedId, paramSimpleBaseEvent);
    }
  }
  
  public void setEmptyText(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.get() != null) && (paramStFeed.likeInfo.get() != null)) {}
    try
    {
      this.b.mergeFrom(paramStFeed.toByteArray());
      a(paramStFeed.likeInfo.count.get());
      return;
    }
    catch (Exception paramStFeed)
    {
      label48:
      break label48;
    }
    QLog.e("QCirclePraise_", 1, "QCirclePraiseTextView setFeedData error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView
 * JD-Core Version:    0.7.0.1
 */