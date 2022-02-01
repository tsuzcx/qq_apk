package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class VipSpecialCareHandler$1$1
  extends Handler
{
  VipSpecialCareHandler$1$1(VipSpecialCareHandler.1 param1, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    VipSpecialCareHandler.a(this.a.this$0, "-->request timeout");
    VipSpecialCareHandler.a(this.a.this$0, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1.1
 * JD-Core Version:    0.7.0.1
 */