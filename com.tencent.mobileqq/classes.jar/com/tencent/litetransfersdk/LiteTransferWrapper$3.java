package com.tencent.litetransfersdk;

class LiteTransferWrapper$3
  implements Runnable
{
  LiteTransferWrapper$3(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L) {
      this.this$0.CancelAllToJNI(LiteTransferWrapper.access$200(this.this$0), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.3
 * JD-Core Version:    0.7.0.1
 */