package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class TroopGameGuideHelper$2
  extends Handler
{
  TroopGameGuideHelper$2(TroopGameGuideHelper paramTroopGameGuideHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      TroopGameGuideHelper.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.2
 * JD-Core Version:    0.7.0.1
 */