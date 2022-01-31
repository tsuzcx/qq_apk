package com.tencent.mobileqq.ark;

import annc;
import anno;
import baub;
import baue;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;
import ndk;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(annc paramannc, QQAppInterface paramQQAppInterface, anno paramanno, baub parambaub) {}
  
  public void run()
  {
    if ((annc.a(this.this$0) == null) || (!ndk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      annc.a(this.this$0, this.jdField_a_of_type_Anno, false, null);
      return;
    }
    annc.a(this.this$0).a(this.jdField_a_of_type_Baub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */