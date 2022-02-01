package com.tencent.biz.qqcircle.widgets;

import aaak;
import aaam;
import aadv;
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
import uzg;

public class QCirclePraiseTextView
  extends TextView
  implements aaam
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
      String str = uzg.d(paramInt);
      aadv.a(this, false);
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
      aaak.a().a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get().equals(paramSimpleBaseEvent.mTargetFeedId))
      {
        int i = paramSimpleBaseEvent.mPraisedNum;
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.count.set(i);
        a(i);
      }
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