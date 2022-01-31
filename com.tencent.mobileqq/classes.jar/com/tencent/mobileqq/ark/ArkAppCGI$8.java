package com.tencent.mobileqq.ark;

import alsc;
import alsn;
import ayrv;
import ayry;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import nar;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(alsc paramalsc, QQAppInterface paramQQAppInterface, alsn paramalsn, ayrv paramayrv) {}
  
  public void run()
  {
    if ((alsc.a(this.this$0) == null) || (!nar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      alsc.a(this.this$0, this.jdField_a_of_type_Alsn, false, null);
      return;
    }
    alsc.a(this.this$0).a(this.jdField_a_of_type_Ayrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */