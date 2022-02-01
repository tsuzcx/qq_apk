package com.tencent.av.smallscreen;

import com.tencent.qphone.base.util.QLog;

class SmallScreenService$4
  implements Runnable
{
  SmallScreenService$4(SmallScreenService paramSmallScreenService, long paramLong) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SmallScreenService", 4, "hideStateRunnable, sCanSendStateDelayFlag[" + SmallScreenService.g + "]");
    }
    if (SmallScreenService.g) {
      this.this$0.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService.4
 * JD-Core Version:    0.7.0.1
 */