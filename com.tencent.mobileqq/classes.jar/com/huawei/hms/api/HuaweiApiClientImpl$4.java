package com.huawei.hms.api;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicInteger;

class HuaweiApiClientImpl$4
  implements Handler.Callback
{
  HuaweiApiClientImpl$4(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if ((paramMessage == null) || (paramMessage.what != 3)) {
      bool = false;
    }
    do
    {
      return bool;
      HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
    } while (HuaweiApiClientImpl.b(this.a).get() != 2);
    HuaweiApiClientImpl.b(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiApiClientImpl.4
 * JD-Core Version:    0.7.0.1
 */