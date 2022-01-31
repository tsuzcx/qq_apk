package com.tencent.mobileqq.activity.aio.rebuild;

import aefv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class LimitChatPie$6
  implements Runnable
{
  public LimitChatPie$6(aefv paramaefv) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1044, null);
    if (localList != null) {
      aefv.a(this.this$0, localList.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "mAllMsgCount " + aefv.e(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6
 * JD-Core Version:    0.7.0.1
 */