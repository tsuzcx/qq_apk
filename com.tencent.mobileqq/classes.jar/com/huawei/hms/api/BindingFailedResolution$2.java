package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

class BindingFailedResolution$2
  implements Handler.Callback
{
  BindingFailedResolution$2(BindingFailedResolution paramBindingFailedResolution) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 2)) {
      return false;
    }
    HMSLog.e("BindingFailedResolution", "In connect, bind core try timeout");
    BindingFailedResolution.a(this.a, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.2
 * JD-Core Version:    0.7.0.1
 */