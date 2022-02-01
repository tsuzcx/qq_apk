package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$41
  implements Runnable
{
  BaseChatPie$41(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (!BaseChatPie.M)
    {
      AIOShortVideoUtil.b = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_CLICK_CAMERA ", Long.valueOf(AIOShortVideoUtil.b) });
      this.this$0.aH();
      BaseChatPie.M = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.41
 * JD-Core Version:    0.7.0.1
 */