package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TroopAnnouncementDecoder;
import com.tencent.qphone.base.util.QLog;

public class SubType0x4e
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    TroopAnnouncementDecoder.a(paramQQAppInterface, paramMsgType0x210.vProtobuf);
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    MessageProtoCodec.a(paramQQAppInterface.getMsgHandler(), l1, i, l2, j);
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x4e
 * JD-Core Version:    0.7.0.1
 */