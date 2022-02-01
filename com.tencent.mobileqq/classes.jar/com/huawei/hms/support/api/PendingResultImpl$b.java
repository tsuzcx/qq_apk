package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class PendingResultImpl$b
  implements DatagramTransport.a
{
  PendingResultImpl$b(PendingResultImpl paramPendingResultImpl, AtomicBoolean paramAtomicBoolean) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    if (!this.a.get()) {
      PendingResultImpl.access$000(this.b, paramInt, paramIMessageEntity);
    }
    PendingResultImpl.access$100(this.b).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.b
 * JD-Core Version:    0.7.0.1
 */