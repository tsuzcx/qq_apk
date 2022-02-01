package com.tencent.mobileqq.activity.guild;

import com.tencent.biz.pubaccount.util.ShareStructLongMessageManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.guild.message.base.AbsGuildSendMessageHandlerCallback;

public class GuildSendTextMsgCallback
  extends AbsGuildSendMessageHandlerCallback
{
  public void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    if ((paramMessageRecord instanceof MessageForText))
    {
      MessageForText localMessageForText = (MessageForText)paramMessageRecord;
      if (paramSendTextMsgParams.e != null) {
        localMessageForText.atInfoList = paramSendTextMsgParams.e;
      }
      ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
      localSendMsgParams.g = paramSendTextMsgParams.g;
      localSendMsgParams.w = paramSendTextMsgParams.h;
      localSendMsgParams.x = paramSendTextMsgParams.i;
      localMessageForText.setSendMsgParams(localSendMsgParams);
    }
    if (paramSendTextMsgParams.f) {
      ThreadManager.post(new GuildSendTextMsgCallback.1(this, paramAppInterface, paramMessageRecord), 8, null, true);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (localMessageForStructing.structingMsg != null)
      {
        bool = ShareStructLongMessageManager.b(localMessageForStructing.structingMsg);
        break label32;
      }
    }
    boolean bool = false;
    label32:
    if ((MessageForRichText.class.isInstance(paramMessageRecord)) && (!bool)) {
      ((MessageForRichText)paramMessageRecord).richText = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.guild.GuildSendTextMsgCallback
 * JD-Core Version:    0.7.0.1
 */