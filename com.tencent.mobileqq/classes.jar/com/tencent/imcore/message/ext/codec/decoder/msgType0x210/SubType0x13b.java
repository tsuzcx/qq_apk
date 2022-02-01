package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.FilterMsgDecoder;
import com.tencent.qphone.base.util.QLog;

public class SubType0x13b
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubType0x13b", 2, "SubType0x13b receive");
    }
    FilterMsgDecoder.a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x13b
 * JD-Core Version:    0.7.0.1
 */