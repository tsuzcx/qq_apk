package com.tencent.imcore.message.facade.send.sender;

import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildMsgSender
  implements IMessageSender<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ((IGuildSendMessageHandler)paramQQAppInterface.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a(paramMessageRecord, paramBusinessObserver, paramBoolean);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.istroop == 10014;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.GuildMsgSender
 * JD-Core Version:    0.7.0.1
 */