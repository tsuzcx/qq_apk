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
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      PushNotificationManager localPushNotificationManager = (PushNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER);
      if (localPushNotificationManager != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if (i != 0)
        {
          if ((i != 1) && (i != 3000)) {
            return;
          }
          localPushNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, PushNotificationManager.c);
          return;
        }
        localPushNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, PushNotificationManager.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UnreadCountHelper", 2, "PushNotificationManager is null");
      }
    }
  }
  
  public Runnable a()
  {
    return new UnreadCountHelper.1(this);
  }
  
  public String getTag()
  {
    return "UnreadCountHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8) {
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.UnreadCountHelper
 * JD-Core Version:    0.7.0.1
 */