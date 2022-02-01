package com.tencent.litetransfersdk;

import java.util.ArrayList;

class LiteTransferWrapper$5
  implements Runnable
{
  LiteTransferWrapper$5(LiteTransferWrapper paramLiteTransferWrapper, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      this.this$0.SetProxyToJni();
      this.this$0.SendGroupToJNI(LiteTransferWrapper.access$200(this.this$0), (Session[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new Session[this.jdField_a_of_type_JavaUtilArrayList.size()]), this.jdField_a_of_type_Boolean, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.5
 * JD-Core Version:    0.7.0.1
 */