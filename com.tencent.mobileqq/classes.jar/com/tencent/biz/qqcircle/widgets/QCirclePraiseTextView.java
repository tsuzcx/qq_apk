package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import uxx;
import zwp;
import zwr;
import zzr;

public class QCirclePraiseTextView
  extends TextView
  implements zwr
{
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private String jdField_a_of_type_JavaLangString;
  
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
      String str = uxx.d(paramInt);
      zzr.a(this, false);
      setText(str);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      setVisibility(8);
      return;
    }
    setTypeface(Typeface.DEFAULT);
    setText(this.jdField_a_of_type_JavaLangString);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePraiseUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      zwp.a().a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int j = 1;
    int k;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get().equals(paramSimpleBaseEvent.mTargetFeedId)) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.get() != paramSimpleBaseEvent.mPraisedStatus))
      {
        k = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.count.get();
        i = j;
        if (paramSimpleBaseEvent.mPraisedStatus != 1) {
          if (paramSimpleBaseEvent.mPraisedStatus != 21) {
            break label139;
          }
        }
      }
    }
    label139:
    for (int i = j;; i = -1)
    {
      i += k;
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.count.set(i);
      a(i);
      return;
    }
  }
  
  public void setEmptyText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.get() != null) && (paramStFeed.likeInfo.get() != null)) {}
    try
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.mergeFrom(paramStFeed.toByteArray());
      a(paramStFeed.likeInfo.count.get());
      return;
    }
    catch (Exception paramStFeed)
    {
      QLog.e("QCirclePraise_", 1, "QCirclePraiseTextView setFeedData error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView
 * JD-Core Version:    0.7.0.1
 */