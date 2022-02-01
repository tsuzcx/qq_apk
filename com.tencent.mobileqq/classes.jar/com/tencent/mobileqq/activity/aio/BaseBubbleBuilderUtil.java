package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;

public class BaseBubbleBuilderUtil
{
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    String str;
    if (paramChatMessage.isSend()) {
      str = paramChatMessage.selfuin;
    } else if ((paramChatMessage.istroop != 1000) && (paramChatMessage.istroop != 1020) && (paramChatMessage.istroop != 1004)) {
      str = paramChatMessage.senderuin;
    } else {
      str = paramChatMessage.frienduin;
    }
    ExtensionInfo localExtensionInfo = paramQQAppInterface.getExtensionInfo(str, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.faceIdUpdateTime < paramChatMessage.time))
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleHeadIcon: message id = ");
        localStringBuilder.append(paramChatMessage);
        QLog.d("BaseBubbleBuilderUtil", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramChatMessage)) && (Long.parseLong(paramChatMessage) != localExtensionInfo.faceId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilderUtil", 2, "handleHeadIcon: message id not equals local");
        }
        AvatarPendantUtil.a(str);
        AvatarPendantUtil.a(paramQQAppInterface);
      }
    }
    return str;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPoke)) {
      return true;
    }
    return (paramChatMessage instanceof MessageForPokeEmo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil
 * JD-Core Version:    0.7.0.1
 */