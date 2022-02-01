package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;

public class SubType0xdc
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xdc push message");
    }
    IApolloManagerService localIApolloManagerService = null;
    if (paramQQAppInterface != null) {
      localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    }
    if (localIApolloManagerService != null) {
      localIApolloManagerService.decodeApolloBubblePushData(paramMsgType0x210.vProtobuf);
    }
    MessageProtoCodec.a(paramMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramOnLinePushMessageProcessor.a().getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdc
 * JD-Core Version:    0.7.0.1
 */