package com.tencent.biz.qqcircle.fragments.main;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFolderNearbyTabFragment$5
  implements View.OnClickListener
{
  QCircleFolderNearbyTabFragment$5(QCircleFolderNearbyTabFragment paramQCircleFolderNearbyTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleFolderNearbyTabFragment.h(this.a) != null) && (QCircleFolderNearbyTabFragment.i(this.a) != null))
    {
      QCircleFolderNearbyTabFragment.j(this.a).onRefreshData();
      QCircleFolderNearbyTabFragment.k(this.a).setVisibility(8);
      this.a.X();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment.5
 * JD-Core Version:    0.7.0.1
 */