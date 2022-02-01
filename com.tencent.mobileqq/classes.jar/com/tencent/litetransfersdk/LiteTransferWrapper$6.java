package com.tencent.litetransfersdk;

class LiteTransferWrapper$6
  implements Runnable
{
  LiteTransferWrapper$6(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      this.this$0.SetProxyToJni();
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      localLiteTransferWrapper.RecvGroupToJNI(LiteTransferWrapper.access$200(localLiteTransferWrapper), this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.6
 * JD-Core Version:    0.7.0.1
 */