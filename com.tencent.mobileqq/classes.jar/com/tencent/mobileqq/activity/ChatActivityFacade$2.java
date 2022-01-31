package com.tencent.mobileqq.activity;

import aanz;
import aaof;
import axci;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqu;

public final class ChatActivityFacade$2
  implements Runnable
{
  public ChatActivityFacade$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    aanz.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    long l;
    NewIntent localNewIntent;
    if ((aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true)))
    {
      l = aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded    last publish time:" + l);
      }
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), axci.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    }
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { mqu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      if (this.jdField_a_of_type_Boolean)
      {
        localNewIntent.putExtra("src", i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          aaof localaaof2 = (aaof)aanz.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          aaof localaaof1 = localaaof2;
          if (localaaof2 == null)
          {
            localaaof1 = new aaof();
            aanz.a().put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localaaof1);
          }
          localaaof1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localaaof1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          localaaof1.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(localaaof1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        }
        aanz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_feeds_time");
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