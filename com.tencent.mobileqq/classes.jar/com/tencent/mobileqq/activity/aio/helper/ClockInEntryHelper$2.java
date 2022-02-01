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
    boolean bool = true;
    ClockInEntryHelper localClockInEntryHelper;
    if (paramMessage.what == 1)
    {
      localClockInEntryHelper = this.a;
      if (paramMessage.arg1 == 0) {
        break label28;
      }
    }
    for (;;)
    {
      ClockInEntryHelper.a(localClockInEntryHelper, bool);
      return;
      label28:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper.2
 * JD-Core Version:    0.7.0.1
 */