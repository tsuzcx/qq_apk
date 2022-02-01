package com.tencent.mobileqq.app;

import amqd;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;

public class DataLineHandler$11
  implements Runnable
{
  public DataLineHandler$11(amqd paramamqd, Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo) {}
  
  public void run()
  {
    amqd.a(this.this$0, this.jdField_a_of_type_ComTencentLitetransfersdkSession, this.jdField_a_of_type_ComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ComTencentLitetransfersdkFTNInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.11
 * JD-Core Version:    0.7.0.1
 */