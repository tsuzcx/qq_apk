package com.tencent.mobileqq.app.proxy;

import amjd;
import amji;
import awbv;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import ew;

public class DataLineMsgProxy$2
  implements Runnable
{
  public DataLineMsgProxy$2(amjd paramamjd, awbv paramawbv, amji paramamji, ew paramew) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_Awbv).clone();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, this.this$0.jdField_a_of_type_JavaLangString, localDataLineMsgRecord, 0, this.jdField_a_of_type_Amji);
    this.jdField_a_of_type_Ew.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */