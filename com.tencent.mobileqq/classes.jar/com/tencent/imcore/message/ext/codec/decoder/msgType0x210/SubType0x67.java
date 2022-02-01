package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;

public class SubType0x67
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 group recmd push: " + paramOnLinePushMessageProcessor.a(paramMsgType0x210));
    }
    submsgtype0x67.MsgBody localMsgBody = new submsgtype0x67.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.rpt_msg_grpinfo.has())
      {
        paramMsgType0x210 = localMsgBody.rpt_msg_grpinfo.get();
        paramOnLinePushMessageProcessor = (LBSHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
        if (paramOnLinePushMessageProcessor != null) {
          paramOnLinePushMessageProcessor.a(paramMsgType0x210);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearbyTroopPush", 2, "receive msgtype0x210.submsgtype0x67 mergeFrom exception: " + paramMsgType0x210.toString());
        }
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x67
 * JD-Core Version:    0.7.0.1
 */