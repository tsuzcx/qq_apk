package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFakeFeedPresenter$1
  implements View.OnClickListener
{
  QCircleFakeFeedPresenter$1(QCircleFakeFeedPresenter paramQCircleFakeFeedPresenter) {}
  
  public void onClick(View paramView)
  {
    this.a.interceptFakeClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFakeFeedPresenter.1
 * JD-Core Version:    0.7.0.1
 */