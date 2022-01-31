package com.tencent.mobileqq.app.proxy;

import aken;
import akes;
import atmo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import eu;

public class DataLineMsgProxy$2
  implements Runnable
{
  public DataLineMsgProxy$2(aken paramaken, atmo paramatmo, akes paramakes, eu parameu) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgRecord)this.jdField_a_of_type_Atmo).clone();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, this.this$0.jdField_a_of_type_JavaLangString, localDataLineMsgRecord, 0, this.jdField_a_of_type_Akes);
    this.jdField_a_of_type_Eu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
 * JD-Core Version:    0.7.0.1
 */