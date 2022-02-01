package com.tencent.mobileqq.activity.guild;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageProcessorCallback;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.QLog;

public class GuildMsgProcessorTextMsgCallback
  extends AbsGuildMessageProcessorCallback
{
  private static String a = "GuildMsgProcessorTextMsgCallback";
  
  private static void b(AppInterface paramAppInterface, MessageInfo paramMessageInfo1, MessageInfo paramMessageInfo2, MessageRecord paramMessageRecord)
  {
    if (paramMessageInfo1 == null) {
      return;
    }
    paramMessageInfo2.c.b(13, paramMessageRecord.uniseq);
    paramMessageInfo2.c.b(24, paramMessageRecord.uniseq);
    paramAppInterface = ((IGuildMsgSeqTimeService)paramAppInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(String.valueOf(paramMessageRecord.frienduin));
    if ((paramMessageRecord.shmsgseq > paramAppInterface.a) && (paramMessageInfo2.e()))
    {
      paramMessageInfo1.a(paramMessageInfo2);
      paramMessageRecord.mMessageInfo = paramMessageInfo2;
    }
    if (QLog.isColorLevel())
    {
      paramMessageInfo1 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCurMsgInfo: mMessageInfo + ");
      localStringBuilder.append(paramMessageRecord.mMessageInfo);
      localStringBuilder.append(", messageRecord.shmsgseq = ");
      localStringBuilder.append(paramMessageRecord.shmsgseq);
      localStringBuilder.append(", readedMsgSeq.msgSeq = ");
      localStringBuilder.append(paramAppInterface.a);
      localStringBuilder.append(", curMsgInfo.hasFlag() = ");
      localStringBuilder.append(paramMessageInfo2.e());
      QLog.d(paramMessageInfo1, 2, localStringBuilder.toString());
    }
  }
  
  public void a(AppInterface paramAppInterface, MessageInfo paramMessageInfo1, MessageInfo paramMessageInfo2, MessageRecord paramMessageRecord)
  {
    b(paramAppInterface, paramMessageInfo1, paramMessageInfo2, paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (((paramMessageRecord1 instanceof MessageForText)) && ((paramMessageRecord2 instanceof MessageForText)))
    {
      if (paramMessageRecord1.getRepeatCount() > 0)
      {
        paramMessageRecord2.setRepeatCount(paramMessageRecord1.getRepeatCount());
        if (QLog.isColorLevel())
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onHandleSelfSendMsg ===> update findMr.repeatCount=");
          localStringBuilder.append(paramMessageRecord2.getRepeatCount());
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      paramMessageRecord2.saveExtInfoToExtStr("key_message_extra_info_flag", paramMessageRecord1.getExtInfoFromExtStr("key_message_extra_info_flag"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.guild.GuildMsgProcessorTextMsgCallback
 * JD-Core Version:    0.7.0.1
 */