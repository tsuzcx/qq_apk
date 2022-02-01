package com.tencent.biz.qqcircle.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleBaseTabFragment$3
  implements View.OnClickListener
{
  QCircleBaseTabFragment$3(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.m != null) && (this.a.p != null))
    {
      this.a.m.onRefreshData();
      this.a.p.setVisibility(8);
      this.a.X();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.3
 * JD-Core Version:    0.7.0.1
 */