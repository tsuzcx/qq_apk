package com.tencent.mobileqq.app.proxy;

import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class DataLineMsgProxy$5
  implements Runnable
{
  DataLineMsgProxy$5(DataLineMsgProxy paramDataLineMsgProxy, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    DataLineMsgProxy.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
    this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.5
 * JD-Core Version:    0.7.0.1
 */