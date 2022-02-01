package com.tencent.mobileqq.activity;

import com.tencent.av.utils.CharacterUtil;
import com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;

final class ChatActivityFacade$4
  implements Runnable
{
  ChatActivityFacade$4(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Object localObject;
    if (ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true))
    {
      long l = ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastTime: ");
      ((StringBuilder)localObject).append(l);
      QLog.i("ChatActivityFacade.QZoneStoryFeeds", 1, ((StringBuilder)localObject).toString());
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QzoneAioStoryFeedServlet.class);
      ((NewIntent)localObject).putExtra("key_last_aio_story_create_time", l);
    }
    try
    {
      ((NewIntent)localObject).putExtra("key_friend_uid", CharacterUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    }
    catch (Exception localException)
    {
      label103:
      StringBuilder localStringBuilder;
      break label103;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Long.valueOf ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    QLog.e("ChatActivityFacade.QZoneStoryFeeds", 1, localStringBuilder.toString());
    ChatActivityFacade.a().jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatActivityFacade.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    ((NewIntent)localObject).setObserver(ChatActivityFacade.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_story_feed_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.4
 * JD-Core Version:    0.7.0.1
 */