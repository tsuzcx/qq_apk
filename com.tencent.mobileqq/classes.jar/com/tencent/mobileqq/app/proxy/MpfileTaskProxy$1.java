package com.tencent.mobileqq.app.proxy;

import apav;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.persistence.Entity;
import fb;

public class MpfileTaskProxy$1
  implements Runnable
{
  public MpfileTaskProxy$1(apav paramapav, Entity paramEntity, ProxyListener paramProxyListener, fb paramfb) {}
  
  public void run()
  {
    MpfileTaskRecord localMpfileTaskRecord = ((MpfileTaskRecord)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).clone();
    this.this$0.a.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), localMpfileTaskRecord, 0, this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyListener);
    this.jdField_a_of_type_Fb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1
 * JD-Core Version:    0.7.0.1
 */