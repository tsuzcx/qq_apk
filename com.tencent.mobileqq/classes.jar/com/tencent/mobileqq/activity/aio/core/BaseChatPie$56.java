package com.tencent.mobileqq.activity.aio.core;

import bbpn;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$56
  implements Runnable
{
  BaseChatPie$56(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.preloaded)
    {
      bbpn.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(bbpn.b) });
      this.this$0.doShowPtv();
      BaseChatPie.preloaded = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.56
 * JD-Core Version:    0.7.0.1
 */