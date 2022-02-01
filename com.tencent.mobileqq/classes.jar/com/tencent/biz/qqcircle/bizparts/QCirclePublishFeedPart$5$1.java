package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishFeedPart$5$1
  implements View.OnClickListener
{
  QCirclePublishFeedPart$5$1(QCirclePublishFeedPart.5 param5) {}
  
  public void onClick(View paramView)
  {
    QCircleHostLauncher.doJumpAction(this.a.b.g(), this.a.a.g);
    QCirclePublishFeedPart.d(this.a.b).i();
    QCirclePublishFeedPart.d(this.a.b).a(Boolean.valueOf(true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.5.1
 * JD-Core Version:    0.7.0.1
 */