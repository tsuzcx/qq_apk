package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DarenAssistantHelper;
import com.tencent.qphone.base.util.QLog;

public class SubType0x100
  implements Msg0X210SubTypeDecoder
{
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x100");
    }
    return DarenAssistantHelper.a(paramQQAppInterface, paramMsgType0x210.vProtobuf, paramMsgInfo);
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a(paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x100
 * JD-Core Version:    0.7.0.1
 */