package com.tencent.biz.qqcircle.richframework.sender.iml.fake;

import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCirclePraiseFakeInterceptor$2
  implements Runnable
{
  QCirclePraiseFakeInterceptor$2(QCirclePraiseFakeInterceptor paramQCirclePraiseFakeInterceptor, QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent) {}
  
  public void run()
  {
    SimpleEventBus.getInstance().dispatchEvent(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor.2
 * JD-Core Version:    0.7.0.1
 */