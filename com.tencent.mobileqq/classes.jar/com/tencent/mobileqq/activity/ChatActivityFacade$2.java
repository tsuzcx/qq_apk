package com.tencent.mobileqq.activity;

import aean;
import aeat;
import bcvm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mrs;

public final class ChatActivityFacade$2
  implements Runnable
{
  public ChatActivityFacade$2(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 1;
    aean.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    long l;
    NewIntent localNewIntent;
    if ((aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true)))
    {
      l = aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded    last publish time:" + l);
      }
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), bcvm.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    }
    try
    {
      localNewIntent.putExtra("hostuin", new long[] { mrs.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "insertFriendNewestFeedIfNeeded   lastTime:" + l);
      }
      localNewIntent.putExtra("lasttime", l);
      if (this.jdField_a_of_type_Boolean)
      {
        localNewIntent.putExtra("src", i);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          aeat localaeat2 = (aeat)aean.a().get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          aeat localaeat1 = localaeat2;
          if (localaeat2 == null)
          {
            localaeat1 = new aeat();
            aean.a().put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localaeat1);
          }
          localaeat1.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localaeat1.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          localaeat1.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(localaeat1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        }
        aean.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_feeds_time");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.2
 * JD-Core Version:    0.7.0.1
 */