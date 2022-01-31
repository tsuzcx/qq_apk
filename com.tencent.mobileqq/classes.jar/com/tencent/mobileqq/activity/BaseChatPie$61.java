package com.tencent.mobileqq.activity;

import ayyd;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$61
  implements Runnable
{
  BaseChatPie$61(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.R)
    {
      ayyd.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(ayyd.b) });
      this.this$0.aQ();
      BaseChatPie.R = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.61
 * JD-Core Version:    0.7.0.1
 */