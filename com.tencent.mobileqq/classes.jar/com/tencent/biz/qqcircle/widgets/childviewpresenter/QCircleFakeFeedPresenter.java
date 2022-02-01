package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;

public class QCircleFakeFeedPresenter
  extends QCircleBaseFeedChildPresenter
{
  private static final String TAG = "QCircleFakeFeedPresenter";
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if (isFakeFeed())
    {
      this.mContainer.setVisibility(0);
      return;
    }
    this.mContainer.setVisibility(8);
  }
  
  protected String getLogTag()
  {
    return "QCircleFakeFeedPresenter";
  }
  
  public void initView(View paramView)
  {
    this.mContainer = LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440923));
    this.mContainer.setOnClickListener(new QCircleFakeFeedPresenter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFakeFeedPresenter
 * JD-Core Version:    0.7.0.1
 */