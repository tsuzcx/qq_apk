package com.tencent.livesdk.servicefactory.builder.chatmessage;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.messageservice.MessageService;
import com.tencent.ilivesdk.messageservice_interface.MessageServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ChatMessageServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    MessageService localMessageService = new MessageService();
    localMessageService.init(new ChatMessageServiceBuilder.1(this, paramServiceAccessor));
    return localMessageService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.chatmessage.ChatMessageServiceBuilder
 * JD-Core Version:    0.7.0.1
 */