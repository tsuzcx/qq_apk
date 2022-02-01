package com.tencent.mobileqq.activity;

import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneFeedsServlet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

final class ChatActivityFacade$2
  implements Runnable
{
  ChatActivityFacade$2(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatActivityFacade.insertFriendNewestFeedIfNeeded", 2, "insertFriendNewestFeedIfNeeded:sessionInfo == null");
      }
    }
    do
    {
      return;
      ChatActivityFacade.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    } while ((!ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true)));
    long l = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded    last publish time:" + l);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneFeedsServlet.class);
    localNewIntent.putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { CharacterUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      if (this.jdField_a_of_type_Boolean)
      {
        localNewIntent.putExtra("src", i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          ChatActivityFacade.QZoneNewestFeedObserver localQZoneNewestFeedObserver2 = (ChatActivityFacade.QZoneNewestFeedObserver)ChatActivityFacade.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          ChatActivityFacade.QZoneNewestFeedObserver localQZoneNewestFeedObserver1 = localQZoneNewestFeedObserver2;
          if (localQZoneNewestFeedObserver2 == null)
          {
            localQZoneNewestFeedObserver1 = new ChatActivityFacade.QZoneNewestFeedObserver();
            ChatActivityFacade.a().put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localQZoneNewestFeedObserver1);
          }
          localQZoneNewestFeedObserver1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localQZoneNewestFeedObserver1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          localQZoneNewestFeedObserver1.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(localQZoneNewestFeedObserver1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        }
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_feeds_time");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "Long.valueOf " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.2
 * JD-Core Version:    0.7.0.1
 */