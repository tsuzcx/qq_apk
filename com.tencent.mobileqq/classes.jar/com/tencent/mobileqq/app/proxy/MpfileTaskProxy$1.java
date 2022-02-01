package com.tencent.mobileqq.app.proxy;

import com.dataline.mpfile.MpfileTaskRecord;
import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.persistence.Entity;

class MpfileTaskProxy$1
  implements Runnable
{
  MpfileTaskProxy$1(MpfileTaskProxy paramMpfileTaskProxy, Entity paramEntity, ProxyListener paramProxyListener, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.this$0.proxyManager.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */