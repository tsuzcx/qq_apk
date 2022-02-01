package com.tencent.mobileqq.ark;

import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import mqq.app.MobileQQ;

class ArkAppCGI$8
  implements Runnable
{
  ArkAppCGI$8(ArkAppCGI paramArkAppCGI, QQAppInterface paramQQAppInterface, ArkAppCGI.QueryTask paramQueryTask, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    if ((ArkAppCGI.a(this.this$0) == null) || (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      ArkAppCGI.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryTask, false, null);
      return;
    }
    ArkAppCGI.a(this.this$0).sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */