package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$21
  implements Runnable
{
  BaseChatPie$21(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.c, 2, "checkPESourceDowned onShow First");
    }
    PEPanelHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.21
 * JD-Core Version:    0.7.0.1
 */