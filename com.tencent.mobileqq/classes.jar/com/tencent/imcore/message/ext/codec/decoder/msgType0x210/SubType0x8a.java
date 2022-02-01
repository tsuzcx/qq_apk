package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;

public class SubType0x8a
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b onlinepush");
    }
    Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
    try
    {
      localReqBody.mergeFrom(paramMsgType0x210.vProtobuf);
      MsgType0x210Decoder.a(paramQQAppInterface, localReqBody, 0L, false);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b online msg, prase reqBody error");
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x8a
 * JD-Core Version:    0.7.0.1
 */