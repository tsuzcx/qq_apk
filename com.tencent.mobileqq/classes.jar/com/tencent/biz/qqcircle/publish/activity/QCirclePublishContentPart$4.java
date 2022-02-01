package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishContentPart$4
  implements View.OnClickListener
{
  QCirclePublishContentPart$4(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void onClick(View paramView)
  {
    HostUIHelper.openHostEnvironment(new QCirclePublishContentPart.4.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.4
 * JD-Core Version:    0.7.0.1
 */