package com.tencent.mobileqq.app.proxy;

import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.persistence.Entity;

class DataLineMsgProxy$2
  implements Runnable
{
  DataLineMsgProxy$2(DataLineMsgProxy paramDataLineMsgProxy, Entity paramEntity, ProxyListener paramProxyListener, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, this.this$0.a, localDataLineMsgRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */