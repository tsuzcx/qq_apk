package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.service.message.MessageProtoCodec;

public class SubType0xf9
  implements Msg0X210SubTypeDecoder
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((ImaxAdVideoPreloadManager)paramQQAppInterface.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER)).a(paramArrayOfByte, paramInt, paramMsgInfo);
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf, 1, paramMsgInfo);
    MessageProtoCodec.a(paramOnLinePushMessageProcessor.a().getMsgHandler(), paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xf9
 * JD-Core Version:    0.7.0.1
 */