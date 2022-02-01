package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.ActivateFriendsDecoder;
import com.tencent.qphone.base.util.QLog;

public class SubType0x76
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    long l1 = paramMsgInfo.lFromUin;
    int i = paramMsgInfo.shMsgSeq;
    long l2 = paramMsgInfo.lMsgUid;
    int j = paramMsgInfo.shMsgType;
    int k = (int)paramMsgType0x210.uSubMsgType;
    if (((ActivateFriendsManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).b(paramMsgInfo.shMsgSeq))
    {
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("receive same message, seq = ");
        paramMsgType0x210.append(paramMsgInfo.shMsgSeq);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
      }
    }
    else if (ActivateFriendsDecoder.a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf, l1, paramLong, i, j, k)) {
      paramOnLinePushMessageProcessor.a("handleActivateFriendsPush", true, 1, true, false);
    }
    MessageProtoCodec.a(l1, i, l2, j, paramOnLinePushMessageProcessor.a());
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgInfo, paramLong, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x76
 * JD-Core Version:    0.7.0.1
 */