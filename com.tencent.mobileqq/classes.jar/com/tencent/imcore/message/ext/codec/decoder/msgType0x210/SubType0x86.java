package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x86.SubMsgType0x86.MsgBody;

public class SubType0x86
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnLinePushMessageProcessor receive 0x86 push message, seq = ");
      localStringBuilder.append(paramMsgInfo.shMsgSeq);
      localStringBuilder.append("submsgtype:");
      localStringBuilder.append(paramMsgInfo.shMsgType);
      QLog.d("Q.msg.BaseMessageProcessor", 4, localStringBuilder.toString());
    }
    paramMsgInfo = new SubMsgType0x86.MsgBody();
    for (;;)
    {
      try
      {
        paramMsgInfo.mergeFrom(paramMsgType0x210.vProtobuf);
        if (paramMsgInfo.uint32_notify_flag.get() != 1) {
          break label153;
        }
        bool = true;
        if (bool == true)
        {
          paramMsgInfo = new String(paramMsgInfo.bytes_notify_wording.get().toByteArray(), "utf-8");
          QCallFacade.a(paramQQAppInterface, bool, paramMsgInfo);
          paramQQAppInterface.getAVNotifyCenter().a(bool, paramMsgInfo);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "parse 0x86 push msg error", paramQQAppInterface);
        }
      }
      return;
      label153:
      boolean bool = false;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x86
 * JD-Core Version:    0.7.0.1
 */