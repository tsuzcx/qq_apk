package com.tencent.mobileqq.ark;

import anit;
import anjf;
import baps;
import bapv;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import ndk;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(anit paramanit, QQAppInterface paramQQAppInterface, anjf paramanjf, baps parambaps) {}
  
  public void run()
  {
    if ((anit.a(this.this$0) == null) || (!ndk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      anit.a(this.this$0, this.jdField_a_of_type_Anjf, false, null);
      return;
    }
    anit.a(this.this$0).a(this.jdField_a_of_type_Baps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */