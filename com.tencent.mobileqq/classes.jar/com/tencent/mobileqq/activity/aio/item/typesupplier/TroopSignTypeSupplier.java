package com.tencent.mobileqq.activity.aio.item.typesupplier;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;

public class TroopSignTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(((MessageForTroopSign)paramChatMessage).dynamicSource)) {
      return 71;
    }
    return 84;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.TroopSignTypeSupplier
 * JD-Core Version:    0.7.0.1
 */