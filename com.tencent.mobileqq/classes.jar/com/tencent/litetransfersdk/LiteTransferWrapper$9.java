package com.tencent.litetransfersdk;

class LiteTransferWrapper$9
  implements Runnable
{
  LiteTransferWrapper$9(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, MsgSCBody paramMsgSCBody) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L) {
      this.this$0.DoPbMsgReplyToJNI(LiteTransferWrapper.access$200(this.this$0), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentLitetransfersdkMsgSCBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.9
 * JD-Core Version:    0.7.0.1
 */