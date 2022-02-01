package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class SubType0x128
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLinePush receive submsgtype0x128,or 0x137");
      ((StringBuilder)localObject).append(paramMsgType0x210.uSubMsgType);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new submsgtype0x128.MsgBody();
      if (paramOnLinePushMessageProcessor.d(paramMsgType0x210))
      {
        ((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).notifyPushEvent(paramMsgType0x210.uSubMsgType, paramMsgType0x210.vProtobuf);
        ((submsgtype0x128.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        ((IExpandHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(localObject, paramMsgType0x210.uSubMsgType);
        QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
        return;
      }
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("submsgtype0x128 or 0x137 onLinePush vProto null   ");
      paramOnLinePushMessageProcessor.append(paramMsgType0x210.uSubMsgType);
      QLog.e("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("troopFormLog onLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->");
      paramMsgType0x210.append(paramOnLinePushMessageProcessor.getMessage());
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgType0x210.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x128
 * JD-Core Version:    0.7.0.1
 */