package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.widgets.QCirclePushBubbleView;

public class QCircleFeedItemBubblePresenter
  extends QCircleBaseFeedChildPresenter
{
  private static final String TAG = "QCircleFeedItemBubblePresenter";
  private QCirclePushBubbleView mBubbleView;
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if (!(this.mData instanceof FeedBlockData)) {
      return;
    }
    paramObject = this.mBubbleView;
    if (paramObject != null)
    {
      paramObject.setInteractor(this.mIntercator);
      this.mBubbleView.setFeed(((FeedBlockData)this.mData).b());
      this.mBubbleView.setPosition(paramInt);
      this.mBubbleView.setReportBean(getReportBean());
      this.mBubbleView.setExtraTypeInfo(this.mExtraTypeInfo);
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType != 1) && (this.mExtraTypeInfo.pageType != 10)) {
        this.mBubbleView.setPageType(4);
      } else {
        this.mBubbleView.setPageType(1);
      }
      this.mBubbleView.f();
    }
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemBubblePresenter";
  }
  
  public void initView(View paramView)
  {
    this.mContainer = LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440927));
    this.mBubbleView = ((QCirclePushBubbleView)this.mContainer.findViewById(2131440939));
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBubblePresenter
 * JD-Core Version:    0.7.0.1
 */