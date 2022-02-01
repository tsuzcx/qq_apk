package com.tencent.mobileqq.ark;

import apni;
import apnu;
import bdvs;
import bdvu;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import nmd;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(apni paramapni, QQAppInterface paramQQAppInterface, apnu paramapnu, bdvs parambdvs) {}
  
  public void run()
  {
    if ((apni.a(this.this$0) == null) || (!nmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      apni.a(this.this$0, this.jdField_a_of_type_Apnu, false, null);
      return;
    }
    apni.a(this.this$0).a(this.jdField_a_of_type_Bdvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */