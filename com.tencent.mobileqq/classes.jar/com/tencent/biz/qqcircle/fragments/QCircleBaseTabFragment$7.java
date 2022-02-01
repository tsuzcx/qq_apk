package com.tencent.biz.qqcircle.fragments;

import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleBaseTabFragment$7
  implements Runnable
{
  QCircleBaseTabFragment$7(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void run()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleLazyLoadTabEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment.7
 * JD-Core Version:    0.7.0.1
 */