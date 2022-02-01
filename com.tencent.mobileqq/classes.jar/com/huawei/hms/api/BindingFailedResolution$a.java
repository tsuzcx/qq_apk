package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;

class BindingFailedResolution$a
  implements Handler.Callback
{
  BindingFailedResolution$a(BindingFailedResolution paramBindingFailedResolution) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 3))
    {
      BindingFailedResolution.a(this.a, 8);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.a
 * JD-Core Version:    0.7.0.1
 */