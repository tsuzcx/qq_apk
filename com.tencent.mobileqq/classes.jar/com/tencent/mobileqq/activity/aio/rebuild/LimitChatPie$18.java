package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

class LimitChatPie$18
  implements Runnable
{
  LimitChatPie$18(LimitChatPie paramLimitChatPie, int paramInt, MatchInfo paramMatchInfo) {}
  
  public void run()
  {
    ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).handleUnLimitMatchUserInfo(this.this$0.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo);
    ThreadManager.getUIHandler().post(new LimitChatPie.18.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.18
 * JD-Core Version:    0.7.0.1
 */