package com.tencent.mobileqq.activity.aio.item.typesupplier;

import com.tencent.mobileqq.activity.aio.core.msglist.item.MessageTypeSupplier;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;

public class DeviceFileTypeSupplier
  implements MessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForDeviceFile)paramChatMessage;
    if (paramQQAppInterface.nFileMsgType == 2) {
      return 36;
    }
    if (paramQQAppInterface.nFileMsgType == 1) {
      return 37;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.typesupplier.DeviceFileTypeSupplier
 * JD-Core Version:    0.7.0.1
 */