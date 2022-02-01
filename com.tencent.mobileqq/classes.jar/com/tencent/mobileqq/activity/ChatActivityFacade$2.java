package com.tencent.mobileqq.activity;

import admh;
import admn;
import bcvq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mry;

public final class ChatActivityFacade$2
  implements Runnable
{
  public ChatActivityFacade$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    admh.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    long l;
    NewIntent localNewIntent;
    if ((admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true)))
    {
      l = admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded    last publish time:" + l);
      }
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bcvq.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    }
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { mry.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      if (this.jdField_a_of_type_Boolean)
      {
        localNewIntent.putExtra("src", i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          admn localadmn2 = (admn)admh.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          admn localadmn1 = localadmn2;
          if (localadmn2 == null)
          {
            localadmn1 = new admn();
            admh.a().put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localadmn1);
          }
          localadmn1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localadmn1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          localadmn1.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(localadmn1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        }
        admh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_feeds_time");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "Long.valueOf " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.2
 * JD-Core Version:    0.7.0.1
 */