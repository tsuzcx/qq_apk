package com.tencent.litetransfersdk;

class LiteTransferWrapper$4
  implements Runnable
{
  LiteTransferWrapper$4(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      localLiteTransferWrapper.SyncGroupToJNI(LiteTransferWrapper.access$200(localLiteTransferWrapper), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.4
 * JD-Core Version:    0.7.0.1
 */