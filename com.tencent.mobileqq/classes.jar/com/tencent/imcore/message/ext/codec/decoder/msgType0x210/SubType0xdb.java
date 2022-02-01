package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xdb.submsgtype0xdb.MsgBody;

public class SubType0xdb
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAV.push", 2, "onLinePush receive 0x210_0xdb");
    }
    try
    {
      submsgtype0xdb.MsgBody localMsgBody = new submsgtype0xdb.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface.getGAudioHandler().a(localMsgBody);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QAV.push", 2, "onLinePush 0x210_0xdb push exception : ", paramQQAppInterface);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdb
 * JD-Core Version:    0.7.0.1
 */