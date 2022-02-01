package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;

public class PicTypeSupplier
  implements MessageTypeSupplier
{
  public int get(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (((MessageForPic)paramChatMessage).isMixed) {
      return 24;
    }
    if (HotChatHelper.a(paramChatMessage)) {
      return 42;
    }
    if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage)) {
      return 66;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.PicTypeSupplier
 * JD-Core Version:    0.7.0.1
 */