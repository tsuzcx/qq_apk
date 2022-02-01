package com.tencent.mobileqq.apollo.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class ChatPieApolloViewController$3
  implements IApolloPushManager.OnActionPushListener
{
  ChatPieApolloViewController$3(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, IApolloPushManager paramIApolloPushManager) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((this.a.ah != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onActionPush], aioType:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(";pushData:");
        localStringBuilder.append(paramApolloActionPush.toString());
        QLog.d("[cmshow]ChatPieApolloViewController", 2, localStringBuilder.toString());
      }
      if ((this.a.ah.a == paramInt) && (!TextUtils.isEmpty(this.a.ah.b)) && (this.a.ah.b.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.b.triggerAction(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */