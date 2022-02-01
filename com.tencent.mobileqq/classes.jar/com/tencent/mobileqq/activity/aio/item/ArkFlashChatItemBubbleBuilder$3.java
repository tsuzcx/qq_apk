package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkFlashChatItemBubbleBuilder$3
  implements View.OnClickListener
{
  ArkFlashChatItemBubbleBuilder$3(ArkFlashChatItemBubbleBuilder paramArkFlashChatItemBubbleBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.getTag();
    if (localMessageForArkFlashChat != null)
    {
      FlashChatManager.GlobalConfig localGlobalConfig = ((FlashChatManager)this.a.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c;
      String str1 = localGlobalConfig.c;
      String str2 = localGlobalConfig.f;
      String str3 = localGlobalConfig.g;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mSourceOnClickListener clickAppMsg url = ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", actionData = ");
        localStringBuilder.append(str2);
        localStringBuilder.append(", actionDataA = ");
        localStringBuilder.append(str3);
        QLog.d("FlashChat", 2, localStringBuilder.toString());
      }
      if (!this.a.a(str1, str2, str3)) {
        this.a.a(str1, localGlobalConfig.b, localMessageForArkFlashChat);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder.3
 * JD-Core Version:    0.7.0.1
 */