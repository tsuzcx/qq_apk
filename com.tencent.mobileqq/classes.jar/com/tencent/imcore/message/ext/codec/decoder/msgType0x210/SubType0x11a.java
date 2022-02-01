package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupPushHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.MsgBody;

public class SubType0x11a
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11a");
    }
    try
    {
      submsgtype0x11a.MsgBody localMsgBody = new submsgtype0x11a.MsgBody();
      if (paramOnLinePushMessageProcessor.b(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        MsgBackupPushHandler.a().a(localMsgBody);
        return;
      }
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0x11a], errInfo->");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11a
 * JD-Core Version:    0.7.0.1
 */