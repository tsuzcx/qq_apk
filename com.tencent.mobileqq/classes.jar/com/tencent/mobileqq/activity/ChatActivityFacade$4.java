package com.tencent.mobileqq.activity;

import admh;
import com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mry;

public final class ChatActivityFacade$4
  implements Runnable
{
  public ChatActivityFacade$4(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    NewIntent localNewIntent;
    if (admh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true))
    {
      long l = admh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      QLog.i("ChatActivityFacade.QZoneStoryFeeds", 1, "lastTime: " + l);
      localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QzoneAioStoryFeedServlet.class);
      localNewIntent.putExtra("key_last_aio_story_create_time", l);
    }
    try
    {
      localNewIntent.putExtra("key_friend_uid", mry.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin));
      admh.a().jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      admh.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      localNewIntent.setObserver(admh.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      admh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_story_feed_time");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ChatActivityFacade.QZoneStoryFeeds", 1, "Long.valueOf " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.4
 * JD-Core Version:    0.7.0.1
 */