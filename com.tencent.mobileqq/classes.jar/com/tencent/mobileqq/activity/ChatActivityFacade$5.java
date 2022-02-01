package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityFacade$5
  implements Runnable
{
  ChatActivityFacade$5(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    long l1;
    long l2;
    label39:
    long l3;
    if (localExtensionInfo == null)
    {
      l1 = 0L;
      if (localExtensionInfo != null) {
        break label187;
      }
      l2 = 0L;
      if (localExtensionInfo != null) {
        break label196;
      }
      l3 = 0L;
      label47:
      long l4 = MessageCache.a();
      if ((l4 <= 0L) || (l4 - l1 <= 604800L)) {
        break label206;
      }
    }
    label187:
    label196:
    label206:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade", 2, String.format("insertFriendPLNewsIfNeeded latest:%d last:%d pull:%d overWeek:%b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool) }));
      }
      if ((l1 > l2) && (!bool) && (System.currentTimeMillis() / 1000L - l3 >= 86400L)) {
        ((PersonalityLabelHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, l2, l1);
      }
      return;
      l1 = localExtensionInfo.latestPLUpdateTimestamp;
      break;
      l2 = localExtensionInfo.lastPLNewsTimestamp;
      break label39;
      l3 = localExtensionInfo.lastPullPLNewsTimestamp;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.5
 * JD-Core Version:    0.7.0.1
 */