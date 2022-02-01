package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class SubType0x67
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive msgtype0x210.submsgtype0x67 group recmd push: ");
      ((StringBuilder)localObject).append(paramOnLinePushMessageProcessor.b(paramMsgType0x210));
      QLog.d("nearbyTroopPush", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new submsgtype0x67.MsgBody();
    try
    {
      ((submsgtype0x67.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive msgtype0x210.submsgtype0x67 mergeFrom exception: ");
        localStringBuilder.append(paramMsgType0x210.toString());
        QLog.d("nearbyTroopPush", 2, localStringBuilder.toString());
      }
    }
    if (((submsgtype0x67.MsgBody)localObject).rpt_msg_grpinfo.has())
    {
      paramMsgType0x210 = ((submsgtype0x67.MsgBody)localObject).rpt_msg_grpinfo.get();
      paramOnLinePushMessageProcessor = (LBSHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
      if (paramOnLinePushMessageProcessor != null) {
        paramOnLinePushMessageProcessor.a(paramMsgType0x210);
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x67
 * JD-Core Version:    0.7.0.1
 */