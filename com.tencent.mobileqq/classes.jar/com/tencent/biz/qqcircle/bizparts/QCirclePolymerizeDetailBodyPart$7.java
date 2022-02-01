package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePolymerizeDetailBodyPart$7
  implements View.OnClickListener
{
  QCirclePolymerizeDetailBodyPart$7(QCirclePolymerizeDetailBodyPart paramQCirclePolymerizeDetailBodyPart) {}
  
  public void onClick(View paramView)
  {
    if ((QCirclePolymerizeDetailBodyPart.g(this.a) != null) && (QCirclePolymerizeDetailBodyPart.h(this.a) != null))
    {
      QCirclePolymerizeDetailBodyPart.g(this.a).onRefreshData();
      QCirclePolymerizeDetailBodyPart.h(this.a).setVisibility(8);
      this.a.be_().getBlockMerger().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart.7
 * JD-Core Version:    0.7.0.1
 */