package com.tencent.litetransfersdk;

class LiteTransferWrapper$10
  implements Runnable
{
  LiteTransferWrapper$10(LiteTransferWrapper paramLiteTransferWrapper, MsgCSBody paramMsgCSBody) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      localLiteTransferWrapper.PbMsgReciveToJNI(LiteTransferWrapper.access$200(localLiteTransferWrapper), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.10
 * JD-Core Version:    0.7.0.1
 */