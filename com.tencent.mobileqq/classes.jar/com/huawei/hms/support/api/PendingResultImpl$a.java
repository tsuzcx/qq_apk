package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import java.util.concurrent.CountDownLatch;

class PendingResultImpl$a
  implements DatagramTransport.a
{
  PendingResultImpl$a(PendingResultImpl paramPendingResultImpl) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    PendingResultImpl.access$000(this.a, paramInt, paramIMessageEntity);
    PendingResultImpl.access$100(this.a).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.a
 * JD-Core Version:    0.7.0.1
 */