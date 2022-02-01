package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class SubType0x119
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x119, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x119.MsgBody localMsgBody = new SubMsgType0x119.MsgBody();
      if (paramOnLinePushMessageProcessor.b(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("troopFormLog receive c2c");
        paramMsgType0x210.append(localMsgBody.toString());
        QLog.d("Q.msg.BaseMessageProcessor", 1, paramMsgType0x210.toString());
        if (!((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isPushMessageDuplicated(paramMsgInfo.shMsgSeq))
        {
          ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).insertTroopFormGrayTips(paramOnLinePushMessageProcessor.a(), localMsgBody);
          QLog.d("Q.msg.BaseMessageProcessor", 1, "troopFormLog isPushMessageDuplicated");
          return;
        }
      }
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      paramMsgInfo = new StringBuilder();
      paramMsgInfo.append("[msg0x210.uSubMsgType == 0x115], errInfo->");
      paramMsgInfo.append(paramOnLinePushMessageProcessor.getMessage());
      QLog.e("Q.msg.BaseMessageProcessor", 1, paramMsgInfo.toString());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x119
 * JD-Core Version:    0.7.0.1
 */