package com.tencent.biz.qcircleshadow.local.fragment;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.logincallback.TicketCheckDialogCallback;
import com.tencent.mobileqq.qcircle.api.event.QCircleHostCloseEnvEvent;

class QCircleHostTransLoginOutFragment$1
  implements TicketCheckDialogCallback
{
  QCircleHostTransLoginOutFragment$1(QCircleHostTransLoginOutFragment paramQCircleHostTransLoginOutFragment) {}
  
  public void a()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleHostCloseEnvEvent(0));
  }
  
  public void b()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleHostCloseEnvEvent(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransLoginOutFragment.1
 * JD-Core Version:    0.7.0.1
 */