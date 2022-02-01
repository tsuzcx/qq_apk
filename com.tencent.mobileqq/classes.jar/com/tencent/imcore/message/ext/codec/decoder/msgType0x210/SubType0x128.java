package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class SubType0x128
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive submsgtype0x128,or 0x137" + paramMsgType0x210.uSubMsgType);
    }
    try
    {
      submsgtype0x128.MsgBody localMsgBody = new submsgtype0x128.MsgBody();
      if (paramOnLinePushMessageProcessor.a(paramMsgType0x210))
      {
        ExpandFlutterIPCServer.a().a(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        ((ExtendFriendHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localMsgBody, paramMsgType0x210.uSubMsgType);
        QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
        return;
      }
      QLog.e("Q.msg.BaseMessageProcessor", 2, "submsgtype0x128 or 0x137 onLinePush vProto null   " + paramMsgType0x210.uSubMsgType);
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "troopFormLog onLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->" + paramOnLinePushMessageProcessor.getMessage());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x128
 * JD-Core Version:    0.7.0.1
 */