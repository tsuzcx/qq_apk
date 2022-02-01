package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import mqq.os.MqqHandler;

class LimitChatPie$12$1
  implements Runnable
{
  LimitChatPie$12$1(LimitChatPie.12 param12, int paramInt, MatchInfo paramMatchInfo) {}
  
  public void run()
  {
    ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildLimitChatPie$12.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo);
    ThreadManager.getUIHandler().post(new LimitChatPie.12.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.12.1
 * JD-Core Version:    0.7.0.1
 */