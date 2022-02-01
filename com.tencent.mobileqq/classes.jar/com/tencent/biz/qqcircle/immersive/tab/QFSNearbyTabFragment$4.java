package com.tencent.biz.qqcircle.immersive.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSNearbyTabFragment$4
  implements View.OnClickListener
{
  QFSNearbyTabFragment$4(QFSNearbyTabFragment paramQFSNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.i != null) && (this.a.k != null))
    {
      this.a.i.onRefreshData();
      this.a.k.setVisibility(8);
      this.a.N();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment.4
 * JD-Core Version:    0.7.0.1
 */