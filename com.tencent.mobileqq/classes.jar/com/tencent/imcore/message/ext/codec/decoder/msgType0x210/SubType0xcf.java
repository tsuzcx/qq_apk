package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf.MsgBody;

public class SubType0xcf
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAV.Random.push", 2, "[1v1] onLinePush receive 0x210_0xcf");
    }
    try
    {
      submsgtype0xcf.MsgBody localMsgBody = new submsgtype0xcf.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface.getGAudioHandler().a(localMsgBody);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QAV.Random.push", 2, "[1v1] onLinePush 0x210_0xcf push exception", paramQQAppInterface);
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcf
 * JD-Core Version:    0.7.0.1
 */