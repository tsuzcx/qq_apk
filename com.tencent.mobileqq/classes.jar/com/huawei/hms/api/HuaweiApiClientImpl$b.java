package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicInteger;

class HuaweiApiClientImpl$b
  implements Handler.Callback
{
  HuaweiApiClientImpl$b(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 2))
    {
      HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
      if (HuaweiApiClientImpl.b(this.a).get() == 5)
      {
        HuaweiApiClientImpl.a(this.a, 1);
        HuaweiApiClientImpl.c(this.a);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.b
 * JD-Core Version:    0.7.0.1
 */