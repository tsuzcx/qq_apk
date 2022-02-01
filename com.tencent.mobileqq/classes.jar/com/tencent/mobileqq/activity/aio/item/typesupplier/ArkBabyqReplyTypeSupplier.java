package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import java.util.ArrayList;

public class ArkBabyqReplyTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForArkBabyqReply)paramChatMessage;
    if ((paramQQAppInterface.mArkBabyqReplyCardList != null) && (paramQQAppInterface.mArkBabyqReplyCardList.size() > 0)) {
      return 82;
    }
    return 83;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.ArkBabyqReplyTypeSupplier
 * JD-Core Version:    0.7.0.1
 */