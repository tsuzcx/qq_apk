package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;

class BindingFailedResolution$1
  implements Handler.Callback
{
  BindingFailedResolution$1(BindingFailedResolution paramBindingFailedResolution) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 3)) {
      return false;
    }
    BindingFailedResolution.a(this.a, 8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.1
 * JD-Core Version:    0.7.0.1
 */