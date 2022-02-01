package com.tencent.mobileqq.app.proxy;

import aoxv;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.Entity;
import fb;

public class DataLineMsgProxy$2
  implements Runnable
{
  public DataLineMsgProxy$2(aoxv paramaoxv, Entity paramEntity, ProxyListener paramProxyListener, fb paramfb) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(String.valueOf(0), 0, this.this$0.jdField_a_of_type_JavaLangString, localDataLineMsgRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_Fb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */