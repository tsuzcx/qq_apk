package com.tencent.mobileqq.apollo.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$2
  implements IApolloPushManager.OnActionPushListener
{
  ChatPieApolloViewController$2(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, IApolloPushManager paramIApolloPushManager) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onActionPush], aioType:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(";pushData:");
        localStringBuilder.append(paramApolloActionPush.toString());
        QLog.d("[cmshow]sava_ChatPieApolloViewController", 2, localStringBuilder.toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Int == paramInt) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloPushManager.triggerAction(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.2
 * JD-Core Version:    0.7.0.1
 */