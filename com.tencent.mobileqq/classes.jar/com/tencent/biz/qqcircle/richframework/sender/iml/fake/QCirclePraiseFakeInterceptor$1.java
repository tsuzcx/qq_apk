package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCirclePraiseFakeInterceptor$1
  implements Runnable
{
  QCirclePraiseFakeInterceptor$1(QCirclePraiseFakeInterceptor paramQCirclePraiseFakeInterceptor, QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent) {}
  
  public void run()
  {
    SimpleEventBus.getInstance().dispatchEvent(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor.1
 * JD-Core Version:    0.7.0.1
 */