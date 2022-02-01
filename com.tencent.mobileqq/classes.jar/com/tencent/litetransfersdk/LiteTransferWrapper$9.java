package com.tencent.litetransfersdk;

class LiteTransferWrapper$9
  implements Runnable
{
  LiteTransferWrapper$9(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, MsgSCBody paramMsgSCBody) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      localLiteTransferWrapper.DoPbMsgReplyToJNI(LiteTransferWrapper.access$200(localLiteTransferWrapper), this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.9
 * JD-Core Version:    0.7.0.1
 */