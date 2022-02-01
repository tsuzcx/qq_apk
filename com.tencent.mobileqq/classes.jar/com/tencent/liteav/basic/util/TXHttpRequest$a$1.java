package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.log.TXCLog;

class TXHttpRequest$a$1
  implements Runnable
{
  TXHttpRequest$a$1(TXHttpRequest.a parama, TXHttpRequest.b paramb, TXHttpRequest paramTXHttpRequest) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TXPostRequest->recvMsg: ");
    ((StringBuilder)localObject).append(this.a.a);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.a.b);
    TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
    localObject = this.b;
    TXHttpRequest.access$100((TXHttpRequest)localObject, TXHttpRequest.access$000((TXHttpRequest)localObject), this.a.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest.a.1
 * JD-Core Version:    0.7.0.1
 */