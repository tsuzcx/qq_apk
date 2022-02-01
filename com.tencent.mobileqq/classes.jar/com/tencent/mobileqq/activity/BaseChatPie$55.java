package com.tencent.mobileqq.activity;

import bcwd;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$55
  implements Runnable
{
  BaseChatPie$55(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.Q)
    {
      bcwd.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(bcwd.b) });
      this.this$0.aN();
      BaseChatPie.Q = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.55
 * JD-Core Version:    0.7.0.1
 */