package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class SubType0x119
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x119, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      if (paramOnLinePushMessageProcessor.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog receive c2c" + localMsgBody.toString());
        if (!TeamWorkUtils.a(paramMsgInfo.shMsgSeq))
        {
          TeamWorkUtils.a(paramOnLinePushMessageProcessor.a(), localMsgBody);
          QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog isPushMessageDuplicated");
        }
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x115], errInfo->" + paramOnLinePushMessageProcessor.getMessage());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x119
 * JD-Core Version:    0.7.0.1
 */