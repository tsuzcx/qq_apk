package com.tencent.mobileqq.ark;

import aqay;
import aqbk;
import beum;
import beuo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import nny;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(aqay paramaqay, QQAppInterface paramQQAppInterface, aqbk paramaqbk, beum parambeum) {}
  
  public void run()
  {
    if ((aqay.a(this.this$0) == null) || (!nny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      aqay.a(this.this$0, this.jdField_a_of_type_Aqbk, false, null);
      return;
    }
    aqay.a(this.this$0).a(this.jdField_a_of_type_Beum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */