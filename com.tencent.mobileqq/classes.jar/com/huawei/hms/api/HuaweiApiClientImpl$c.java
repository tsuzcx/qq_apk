package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicInteger;

class HuaweiApiClientImpl$c
  implements Handler.Callback
{
  HuaweiApiClientImpl$c(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 3))
    {
      HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
      if (HuaweiApiClientImpl.b(this.a).get() == 2)
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
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.c
 * JD-Core Version:    0.7.0.1
 */