package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

class PendingResultImpl$c
  implements DatagramTransport.a
{
  PendingResultImpl$c(PendingResultImpl paramPendingResultImpl, PendingResultImpl.d paramd, ResultCallback paramResultCallback) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    PendingResultImpl.access$000(this.c, paramInt, paramIMessageEntity);
    this.a.a(this.b, PendingResultImpl.access$200(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.c
 * JD-Core Version:    0.7.0.1
 */