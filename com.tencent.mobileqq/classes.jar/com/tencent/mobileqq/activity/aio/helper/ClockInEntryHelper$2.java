package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ClockInEntryHelper$2
  extends Handler
{
  ClockInEntryHelper$2(ClockInEntryHelper paramClockInEntryHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = true;
    if (i == 1)
    {
      ClockInEntryHelper localClockInEntryHelper = this.a;
      if (paramMessage.arg1 == 0) {
        bool = false;
      }
      ClockInEntryHelper.a(localClockInEntryHelper, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper.2
 * JD-Core Version:    0.7.0.1
 */