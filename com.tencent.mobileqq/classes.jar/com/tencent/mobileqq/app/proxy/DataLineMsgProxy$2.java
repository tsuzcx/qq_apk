package com.tencent.mobileqq.app.proxy;

import aksz;
import akte;
import aukm;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import gn;

public class DataLineMsgProxy$2
  implements Runnable
{
  public DataLineMsgProxy$2(aksz paramaksz, aukm paramaukm, akte paramakte, gn paramgn) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_Aukm).clone();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, this.this$0.jdField_a_of_type_JavaLangString, localDataLineMsgRecord, 0, this.jdField_a_of_type_Akte);
    this.jdField_a_of_type_Gn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */