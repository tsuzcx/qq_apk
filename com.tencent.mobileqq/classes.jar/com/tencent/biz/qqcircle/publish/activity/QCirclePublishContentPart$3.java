package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePublishContentPart$3
  implements View.OnClickListener
{
  QCirclePublishContentPart$3(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void onClick(View paramView)
  {
    if (QCirclePublishContentPart.c(this.a) != null) {
      if (!this.a.j)
      {
        this.a.n();
      }
      else
      {
        this.a.q();
        this.a.o();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.3
 * JD-Core Version:    0.7.0.1
 */