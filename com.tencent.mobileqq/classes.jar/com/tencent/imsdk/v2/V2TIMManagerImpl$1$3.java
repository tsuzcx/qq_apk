package com.tencent.imsdk.v2;

class V2TIMManagerImpl$1$3
  implements Runnable
{
  V2TIMManagerImpl$1$3(V2TIMManagerImpl.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onConnectFailed(this.val$code, this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.1.3
 * JD-Core Version:    0.7.0.1
 */