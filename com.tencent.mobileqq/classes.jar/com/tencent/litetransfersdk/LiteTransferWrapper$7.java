package com.tencent.litetransfersdk;

class LiteTransferWrapper$7
  implements Runnable
{
  LiteTransferWrapper$7(LiteTransferWrapper paramLiteTransferWrapper, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      localLiteTransferWrapper.CancelGroupToJNI(LiteTransferWrapper.access$200(localLiteTransferWrapper), this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.7
 * JD-Core Version:    0.7.0.1
 */