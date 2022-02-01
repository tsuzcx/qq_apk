package com.tencent.mobileqq.activity.aio.drawer;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class BaseChatDrawer$1
  implements MessageQueue.IdleHandler
{
  BaseChatDrawer$1(BaseChatDrawer paramBaseChatDrawer) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (AIODrawerDpc.b()) {
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer.1
 * JD-Core Version:    0.7.0.1
 */