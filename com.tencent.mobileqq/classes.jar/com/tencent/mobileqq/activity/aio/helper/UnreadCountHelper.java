package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.qphone.base.util.QLog;

public class UnreadCountHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public UnreadCountHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a()
  {
    PushNotificationManager localPushNotificationManager;
    if (this.jdField_a_of_type_Int > 0)
    {
      localPushNotificationManager = (PushNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER);
      if (localPushNotificationManager == null) {
        break label93;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    label93:
    while (!QLog.isColorLevel())
    {
      return;
      localPushNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, PushNotificationManager.b);
      return;
      localPushNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, PushNotificationManager.c);
      return;
    }
    QLog.d("UnreadCountHelper", 2, "PushNotificationManager is null");
  }
  
  public String getTag()
  {
    return "UnreadCountHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper
 * JD-Core Version:    0.7.0.1
 */