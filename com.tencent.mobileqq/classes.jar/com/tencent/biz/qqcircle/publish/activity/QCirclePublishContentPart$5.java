package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.widget.ImageView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCirclePublishContentPart$5
  implements Runnable
{
  QCirclePublishContentPart$5(QCirclePublishContentPart paramQCirclePublishContentPart) {}
  
  public void run()
  {
    QCirclePublishContentPart.c(this.this$0).setVisibility(0);
    this.this$0.g.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845367));
    QCirclePublishContentPart localQCirclePublishContentPart = this.this$0;
    localQCirclePublishContentPart.j = true;
    localQCirclePublishContentPart.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.5
 * JD-Core Version:    0.7.0.1
 */