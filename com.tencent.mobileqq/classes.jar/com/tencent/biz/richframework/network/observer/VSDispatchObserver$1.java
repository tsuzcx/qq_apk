package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.BaseRequest;

class VSDispatchObserver$1
  implements Runnable
{
  VSDispatchObserver$1(VSDispatchObserver paramVSDispatchObserver, int paramInt, boolean paramBoolean, BaseRequest paramBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    VSDispatchObserver.access$000(this.this$0, this.val$contextHashCode, this.val$isSuccess, this.val$request, this.val$responseBytes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.1
 * JD-Core Version:    0.7.0.1
 */