package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.extendfriend.bean.ExpandFriendData;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$12$2
  implements Runnable
{
  LimitChatPie$12$2(LimitChatPie.12 param12) {}
  
  public void run()
  {
    try
    {
      LimitChatPie.a(this.a.a, ((Integer)ExpandFriendData.getAttribute(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0)).intValue());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("LimitChatPie", 1, "initData getHasEnterAIO error" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.12.2
 * JD-Core Version:    0.7.0.1
 */