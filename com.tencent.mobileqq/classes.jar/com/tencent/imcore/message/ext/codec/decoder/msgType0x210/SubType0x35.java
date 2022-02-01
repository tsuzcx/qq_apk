package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;

public class SubType0x35
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    try
    {
      int i = ((Submsgtype0x35.MsgBody)new Submsgtype0x35.MsgBody().mergeFrom(paramMsgType0x210.vProtobuf)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("bubble push timestamp=");
        paramMsgType0x210.append(i);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
        return;
      }
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramMsgType0x210);
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x35
 * JD-Core Version:    0.7.0.1
 */