package com.tencent.mobileqq.activity.aio;

import agqd;
import com.tencent.mobileqq.app.QQAppInterface;

final class ForwardUtils$3
  implements Runnable
{
  ForwardUtils$3(String paramString, SessionInfo paramSessionInfo, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    agqd.a(new String[] { str }, i, false, true, j, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.3
 * JD-Core Version:    0.7.0.1
 */