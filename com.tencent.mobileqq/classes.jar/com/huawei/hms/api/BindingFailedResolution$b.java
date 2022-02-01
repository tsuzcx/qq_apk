package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

class BindingFailedResolution$b
  implements Handler.Callback
{
  BindingFailedResolution$b(BindingFailedResolution paramBindingFailedResolution) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (paramMessage.what != 2) {
        return false;
      }
      HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
      BindingFailedResolution.a(this.a, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.b
 * JD-Core Version:    0.7.0.1
 */