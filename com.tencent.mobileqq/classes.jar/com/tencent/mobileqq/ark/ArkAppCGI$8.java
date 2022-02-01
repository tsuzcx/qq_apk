package com.tencent.mobileqq.ark;

import aoul;
import aoux;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import mqq.app.MobileQQ;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(aoul paramaoul, QQAppInterface paramQQAppInterface, aoux paramaoux, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    if ((aoul.a(this.this$0) == null) || (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      aoul.a(this.this$0, this.jdField_a_of_type_Aoux, false, null);
      return;
    }
    aoul.a(this.this$0).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */