package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleNewPolymerizeDetailBodyPart$5
  implements View.OnClickListener
{
  QCircleNewPolymerizeDetailBodyPart$5(QCircleNewPolymerizeDetailBodyPart paramQCircleNewPolymerizeDetailBodyPart) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleNewPolymerizeDetailBodyPart.d(this.a) != null) && (QCircleNewPolymerizeDetailBodyPart.e(this.a) != null))
    {
      QCircleNewPolymerizeDetailBodyPart.d(this.a).onRefreshData();
      QCircleNewPolymerizeDetailBodyPart.e(this.a).setVisibility(8);
      this.a.be_().getBlockMerger().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleNewPolymerizeDetailBodyPart.5
 * JD-Core Version:    0.7.0.1
 */