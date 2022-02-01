package com.huawei.hms.adapter;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;

class BinderAdapter$1
  implements Handler.Callback
{
  BinderAdapter$1(BinderAdapter paramBinderAdapter) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1001)) {
      return false;
    }
    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
    BinderAdapter.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.adapter.BinderAdapter.1
 * JD-Core Version:    0.7.0.1
 */