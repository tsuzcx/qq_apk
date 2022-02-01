package com.tencent.biz.qqcircle.list.bizblocks;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleBlackListBlock$1
  implements View.OnClickListener
{
  QCircleBlackListBlock$1(QCircleBlackListBlock paramQCircleBlackListBlock, QCircleFullScreenStatusView paramQCircleFullScreenStatusView) {}
  
  public void onClick(View paramView)
  {
    this.b.onRefreshData();
    QCircleFullScreenStatusView localQCircleFullScreenStatusView = this.a;
    if (localQCircleFullScreenStatusView != null) {
      localQCircleFullScreenStatusView.setVisibility(8);
    }
    if ((this.b.getBlockMerger() instanceof QCircleBlockMerger)) {
      ((QCircleBlockMerger)this.b.getBlockMerger()).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlackListBlock.1
 * JD-Core Version:    0.7.0.1
 */