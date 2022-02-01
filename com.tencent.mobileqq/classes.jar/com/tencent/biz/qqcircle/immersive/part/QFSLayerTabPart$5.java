package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QFSLayerTabPart$5
  implements Runnable
{
  QFSLayerTabPart$5(QFSLayerTabPart paramQFSLayerTabPart) {}
  
  public void run()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleLazyLoadTabEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerTabPart.5
 * JD-Core Version:    0.7.0.1
 */