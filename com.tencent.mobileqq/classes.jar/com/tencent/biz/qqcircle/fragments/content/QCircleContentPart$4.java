package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleLayerStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentPart$4
  implements View.OnClickListener
{
  QCircleContentPart$4(QCircleContentPart paramQCircleContentPart) {}
  
  public void onClick(View paramView)
  {
    QCircleContentPart.g(this.a);
    if (QCircleContentPart.h(this.a) != null) {
      QCircleContentPart.h(this.a).setVisibility(8);
    }
    this.a.be_().getBlockMerger().a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.4
 * JD-Core Version:    0.7.0.1
 */