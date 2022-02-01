package com.tencent.mobileqq.activity.aio.core;

import bcwh;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$55
  implements Runnable
{
  BaseChatPie$55(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.preloaded)
    {
      bcwh.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(bcwh.b) });
      this.this$0.doShowPtv();
      BaseChatPie.preloaded = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.55
 * JD-Core Version:    0.7.0.1
 */