package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.util.QLog;

public class SubType0x51
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "recv msg0x210.Submsgtype0x51");
    }
    new SubMsgType0x51.MsgBody();
    try
    {
      localObject = new SubMsgType0x51.MsgBody();
      ((SubMsgType0x51.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      boolean bool = ((SubMsgType0x51.MsgBody)localObject).bytes_qrsig_url.has();
      arrayOfByte = null;
      if (!bool) {
        break label311;
      }
      paramMsgType0x210 = new String(((SubMsgType0x51.MsgBody)localObject).bytes_qrsig_url.get().toByteArray(), "utf-8");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        Object localObject;
        byte[] arrayOfByte;
        label283:
        continue;
        paramMsgType0x210 = null;
        continue;
        String str1 = null;
        continue;
        String str2 = null;
      }
    }
    if (((SubMsgType0x51.MsgBody)localObject).bytes_hint1.has())
    {
      str1 = new String(((SubMsgType0x51.MsgBody)localObject).bytes_hint1.get().toByteArray(), "utf-8");
      if (!((SubMsgType0x51.MsgBody)localObject).bytes_hint2.has()) {
        break label322;
      }
      str2 = new String(((SubMsgType0x51.MsgBody)localObject).bytes_hint2.get().toByteArray(), "utf-8");
      if (((SubMsgType0x51.MsgBody)localObject).bytes_login_conf.has()) {
        arrayOfByte = ((SubMsgType0x51.MsgBody)localObject).bytes_login_conf.get().toByteArray();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recv devlock quicklogin push qrcode=");
        ((StringBuilder)localObject).append(paramMsgType0x210);
        ((StringBuilder)localObject).append(" maintip=");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(" smalltip");
        ((StringBuilder)localObject).append(str2);
        QLog.d("DevLock", 2, ((StringBuilder)localObject).toString());
      }
      EquipmentLockImpl.a().a(paramQQAppInterface, paramMsgType0x210, str1, str2, arrayOfByte);
      break label283;
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      }
      MessageProtoCodec.a(paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType, paramMessageHandler.a());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    a(paramOnLinePushMessageProcessor, paramOnLinePushMessageProcessor.getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x51
 * JD-Core Version:    0.7.0.1
 */