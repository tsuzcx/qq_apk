package com.tencent.imsdk.v2;

class V2TIMMessageManagerImpl$2$1
  implements Runnable
{
  V2TIMMessageManagerImpl$2$1(V2TIMMessageManagerImpl.2 param2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$1.val$sendCallback != null)
    {
      int i = 0;
      int j = this.val$totalSize;
      if (j > 0) {
        i = (int)(this.val$currentSize / j * 100.0F);
      }
      this.this$1.val$sendCallback.onProgress(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */