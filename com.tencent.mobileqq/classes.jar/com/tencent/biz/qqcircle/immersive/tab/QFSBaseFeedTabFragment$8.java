package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QFSBaseFeedTabFragment$8
  implements Runnable
{
  QFSBaseFeedTabFragment$8(QFSBaseFeedTabFragment paramQFSBaseFeedTabFragment) {}
  
  public void run()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleLazyLoadTabEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment.8
 * JD-Core Version:    0.7.0.1
 */