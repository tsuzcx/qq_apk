package com.tencent.mobileqq.activity;

import NS_QQ_STORY_META.META.StStoryFeed;
import admh;
import afqy;
import android.util.Base64;
import bcrg;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$9
  implements Runnable
{
  public ChatActivityFacade$9(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, META.StStoryFeed paramStStoryFeed) {}
  
  public void run()
  {
    afqy localafqy;
    BeancurdMsg localBeancurdMsg;
    if (admh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false))
    {
      localafqy = (afqy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
      localBeancurdMsg = new BeancurdMsg();
    }
    try
    {
      localBeancurdMsg.buffer = Base64.encodeToString(this.jdField_a_of_type_NS_QQ_STORY_METAMETA$StStoryFeed.toByteArray(), 0);
      localBeancurdMsg.busiid = 7;
      localBeancurdMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      localBeancurdMsg.isNeedDelHistory = true;
      localBeancurdMsg.ispush = true;
      localBeancurdMsg.startTime = bcrg.a();
      localBeancurdMsg.validTime = 604800L;
      localafqy.a(localBeancurdMsg);
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
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.9
 * JD-Core Version:    0.7.0.1
 */