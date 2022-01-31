package com.tencent.biz.qqcircle.widgets;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import ues;
import yiw;
import yiy;

public class QCirclePraiseImageView
  extends ImageView
  implements View.OnClickListener, yiy
{
  private int jdField_a_of_type_Int = 2130843591;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 2130843592;
  
  public QCirclePraiseImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCirclePraiseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCirclePraiseImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void b()
  {
    try
    {
      setBackgroundDrawable(getResources().getDrawable(this.b));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePraise_", 1, "showLikeView setBackgroundDrawable error");
    }
  }
  
  private void c()
  {
    try
    {
      setBackgroundDrawable(getResources().getDrawable(this.jdField_a_of_type_Int));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCirclePraise_", 1, "showUnLikeView setBackgroundDrawable error");
    }
  }
  
  protected void a()
  {
    setOnClickListener(this);
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.set(paramInt);
    }
    if (paramInt == 1)
    {
      b();
      return;
    }
    c();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yiw.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (!this.jdField_a_of_type_Boolean) {
      QQToast.a(getContext(), alud.a(2131702558), 0).a();
    }
    while ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.get() == null)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.get() == 0) {
      i = 1;
    }
    VSNetworkHelper.a().a(new QCircleDoLikeRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, i, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo, null), new ues(this, i));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i = 1;
    int j;
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && ((paramSimpleBaseEvent instanceof QCirclePraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePraiseUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get().equals(paramSimpleBaseEvent.mTargetFeedId))
      {
        a(paramSimpleBaseEvent.mPraisedStatus);
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.get() != paramSimpleBaseEvent.mPraisedStatus)
        {
          this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
          j = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.count.get();
          if (paramSimpleBaseEvent.mPraisedStatus != 1) {
            break label125;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.likeInfo.count.set(i + j);
      return;
      label125:
      i = -1;
    }
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.likeInfo.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      a(paramStFeed.likeInfo.status.get());
    }
  }
  
  public void setPraisedDrawable(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setUnPraiseDrawable(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePraiseImageView
 * JD-Core Version:    0.7.0.1
 */