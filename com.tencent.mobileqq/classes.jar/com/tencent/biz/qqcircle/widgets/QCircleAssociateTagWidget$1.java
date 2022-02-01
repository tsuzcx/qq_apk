package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishAssociateTagEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleAssociateTagWidget$1
  implements View.OnClickListener
{
  QCircleAssociateTagWidget$1(QCircleAssociateTagWidget paramQCircleAssociateTagWidget) {}
  
  public void onClick(View paramView)
  {
    QCirclePublishAssociateTagEvent localQCirclePublishAssociateTagEvent = new QCirclePublishAssociateTagEvent(this.a.a.getText().toString());
    SimpleEventBus.getInstance().dispatchEvent(localQCirclePublishAssociateTagEvent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAssociateTagWidget.1
 * JD-Core Version:    0.7.0.1
 */