package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xe9.SubMsgType0xe9.MsgBody;

public class SubType0xe9
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor runhw", 2, "onLinePush Audio Trans 0x210_0xe9");
    }
    try
    {
      SubMsgType0xe9.MsgBody localMsgBody = new SubMsgType0xe9.MsgBody();
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      paramQQAppInterface.getGAudioHandler().a(localMsgBody);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = localMsgBody.bytes_business.get().toByteArray();
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("onLinePush 0x210_0xe9 =");
        paramMsgType0x210.append(paramQQAppInterface.length);
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, paramMsgType0x210.toString());
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("onLinePush 0x210_0xe9 businessBytes = ");
        paramMsgType0x210.append(paramQQAppInterface.length);
        QLog.d("Q.msg.BaseMessageProcessor runhw", 2, paramMsgType0x210.toString());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("onLinePush 0x210_0xe9 push exception = ");
        paramMsgType0x210.append(paramQQAppInterface.getMessage());
        QLog.e("Q.msg.BaseMessageProcessor runhw", 2, paramMsgType0x210.toString());
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe9
 * JD-Core Version:    0.7.0.1
 */