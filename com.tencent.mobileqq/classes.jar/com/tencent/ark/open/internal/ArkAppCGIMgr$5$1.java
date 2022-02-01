package com.tencent.ark.open.internal;

import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;

class ArkAppCGIMgr$5$1
  implements IArkDelegateHTTPCallback
{
  ArkAppCGIMgr$5$1(ArkAppCGIMgr.5 param5) {}
  
  public void onComplete(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      ArkAppCGIMgr.access$300(this.this$1.this$0, this.this$1.val$task, true, paramArrayOfByte);
      return;
    }
    ArkAppCGIMgr.access$300(this.this$1.this$0, this.this$1.val$task, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.5.1
 * JD-Core Version:    0.7.0.1
 */