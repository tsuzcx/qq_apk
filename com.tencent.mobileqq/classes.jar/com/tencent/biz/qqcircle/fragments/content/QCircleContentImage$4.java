package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.widgets.multitouchimg.OnScaleBeginListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleContentImage$4
  implements OnScaleBeginListener
{
  QCircleContentImage$4(QCircleContentImage paramQCircleContentImage) {}
  
  public void a(float paramFloat)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleContentImmersiveEvent(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.4
 * JD-Core Version:    0.7.0.1
 */