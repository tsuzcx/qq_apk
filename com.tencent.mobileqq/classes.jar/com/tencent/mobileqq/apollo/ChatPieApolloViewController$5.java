package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$5
  implements IApolloPushManager.OnActionPushListener
{
  ChatPieApolloViewController$5(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, IApolloPushManager paramIApolloPushManager) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Int == paramInt) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloPushManager.triggerAction(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.5
 * JD-Core Version:    0.7.0.1
 */