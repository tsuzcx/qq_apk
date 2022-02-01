package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.submsgtype0x136.Submsgtype0x136.MsgBody;

public class SubType0x136
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x136");
    }
    Submsgtype0x136.MsgBody localMsgBody = new Submsgtype0x136.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_msg_type.get() == 0)
      {
        ((ITroopRecommendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER)).a(String.valueOf(localMsgBody.uint64_group_id.get()), 1, 0, null, 0);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onLinePush receive 0x210_0x136 ");
        paramArrayOfByte.append(paramQQAppInterface);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramArrayOfByte.toString());
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x136
 * JD-Core Version:    0.7.0.1
 */