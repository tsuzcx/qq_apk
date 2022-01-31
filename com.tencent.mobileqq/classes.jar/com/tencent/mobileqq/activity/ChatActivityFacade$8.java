package com.tencent.mobileqq.activity;

import NS_QQ_STORY_META.META.StStoryFeed;
import acjm;
import aeqn;
import android.util.Base64;
import ayzl;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$8
  implements Runnable
{
  public ChatActivityFacade$8(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, META.StStoryFeed paramStStoryFeed) {}
  
  public void run()
  {
    aeqn localaeqn;
    BeancurdMsg localBeancurdMsg;
    if (acjm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      localaeqn = (aeqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      localBeancurdMsg = new BeancurdMsg();
    }
    try
    {
      localBeancurdMsg.buffer = Base64.encodeToString(this.jdField_a_of_type_NS_QQ_STORY_METAMETA$StStoryFeed.toByteArray(), 0);
      localBeancurdMsg.busiid = 7;
      localBeancurdMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      localBeancurdMsg.isNeedDelHistory = true;
      localBeancurdMsg.ispush = true;
      localBeancurdMsg.startTime = ayzl.a();
      localBeancurdMsg.validTime = 604800L;
      localaeqn.a(localBeancurdMsg);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ChatActivityFacade.byte encode to String", 2, "encode error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.8
 * JD-Core Version:    0.7.0.1
 */