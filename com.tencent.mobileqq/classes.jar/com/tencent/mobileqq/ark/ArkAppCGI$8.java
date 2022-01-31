package com.tencent.mobileqq.ark;

import alsb;
import alsm;
import ayrx;
import aysa;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import nao;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(alsb paramalsb, QQAppInterface paramQQAppInterface, alsm paramalsm, ayrx paramayrx) {}
  
  public void run()
  {
    if ((alsb.a(this.this$0) == null) || (!nao.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      alsb.a(this.this$0, this.jdField_a_of_type_Alsm, false, null);
      return;
    }
    alsb.a(this.this$0).a(this.jdField_a_of_type_Ayrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */