package com.tencent.biz.qqcircle.fragments.feeddetail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleFeedDetailBodyPart$3
  implements View.OnClickListener
{
  QCircleFeedDetailBodyPart$3(QCircleFeedDetailBodyPart paramQCircleFeedDetailBodyPart) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleFeedDetailBodyPart.c(this.a) != null) && (QCircleFeedDetailBodyPart.d(this.a) != null))
    {
      QCircleFeedDetailBodyPart.c(this.a).onRefreshData();
      QCircleFeedDetailBodyPart.d(this.a).setVisibility(8);
      this.a.be_().getBlockMerger().a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailBodyPart.3
 * JD-Core Version:    0.7.0.1
 */