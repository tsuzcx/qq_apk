package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolymerizationBodyPart$7
  implements View.OnClickListener
{
  QCirclePolymerizationBodyPart$7(QCirclePolymerizationBodyPart paramQCirclePolymerizationBodyPart) {}
  
  public void onClick(View paramView)
  {
    if ((QCirclePolymerizationBodyPart.d(this.a) != null) && (QCirclePolymerizationBodyPart.e(this.a) != null))
    {
      QCirclePolymerizationBodyPart.d(this.a).onRefreshData();
      QCirclePolymerizationBodyPart.e(this.a).setVisibility(8);
      this.a.be_().getBlockMerger().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart.7
 * JD-Core Version:    0.7.0.1
 */