package com.tencent.mobileqq.ark;

import aldo;
import aldz;
import axro;
import axrr;
import com.tencent.mobileqq.app.QQAppInterface;
import mpq;
import mqq.app.MobileQQ;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(aldo paramaldo, QQAppInterface paramQQAppInterface, aldz paramaldz, axro paramaxro) {}
  
  public void run()
  {
    if ((aldo.a(this.this$0) == null) || (!mpq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      aldo.a(this.this$0, this.jdField_a_of_type_Aldz, false, null);
      return;
    }
    aldo.a(this.this$0).a(this.jdField_a_of_type_Axro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */