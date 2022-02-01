package com.tencent.imcore.message.facade.send.sender;

import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class MsgSenderProvider$1
  extends ArrayList<IMessageSender<QQAppInterface>>
{
  MsgSenderProvider$1(MsgSenderProvider paramMsgSenderProvider)
  {
    add(new GuildMsgSender());
    add(new TextOrReplyTextMsgSender());
    add(new SpecialMsgSender());
    add(new MediaLightVideoMsgSender());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.MsgSenderProvider.1
 * JD-Core Version:    0.7.0.1
 */