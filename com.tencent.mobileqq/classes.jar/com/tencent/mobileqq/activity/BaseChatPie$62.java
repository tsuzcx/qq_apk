package com.tencent.mobileqq.activity;

import axcz;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$62
  implements Runnable
{
  BaseChatPie$62(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.R)
    {
      axcz.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(axcz.b) });
      this.this$0.aO();
      BaseChatPie.R = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.62
 * JD-Core Version:    0.7.0.1
 */