package com.tencent.biz.pubaccount.readinjoy.common;

import acex;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class ReadInJoyUtils$21
  implements Runnable
{
  public ReadInJoyUtils$21(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, 1008);
    QLog.d("ReadInJoyUtils", 2, "puin<" + this.jdField_a_of_type_JavaLangString + "> msg setRead !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.21
 * JD-Core Version:    0.7.0.1
 */