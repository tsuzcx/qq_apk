package com.tencent.mobileqq.app.proxy;

import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class DataLineMsgProxy$6
  implements Runnable
{
  DataLineMsgProxy$6(DataLineMsgProxy paramDataLineMsgProxy, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    DataLineMsgProxy.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, null);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.6
 * JD-Core Version:    0.7.0.1
 */