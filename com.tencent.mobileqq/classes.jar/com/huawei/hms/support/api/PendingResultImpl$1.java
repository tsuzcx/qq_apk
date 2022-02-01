package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import java.util.concurrent.CountDownLatch;

class PendingResultImpl$1
  implements DatagramTransport.a
{
  PendingResultImpl$1(PendingResultImpl paramPendingResultImpl) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    PendingResultImpl.a(this.a, paramInt, paramIMessageEntity);
    PendingResultImpl.a(this.a).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.1
 * JD-Core Version:    0.7.0.1
 */