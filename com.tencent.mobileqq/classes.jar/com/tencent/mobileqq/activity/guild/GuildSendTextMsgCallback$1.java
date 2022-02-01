package com.tencent.mobileqq.activity.guild;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class GuildSendTextMsgCallback$1
  implements Runnable
{
  GuildSendTextMsgCallback$1(GuildSendTextMsgCallback paramGuildSendTextMsgCallback, AppInterface paramAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    AppInterface localAppInterface = this.a;
    if ((localAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)localAppInterface).getMessageFacade().s(this.b.frienduin, 10014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.guild.GuildSendTextMsgCallback.1
 * JD-Core Version:    0.7.0.1
 */