package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120.MsgBody;

public class SubType0x120
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x120,");
    }
    try
    {
      SubMsgType0x120.MsgBody localMsgBody = new SubMsgType0x120.MsgBody();
      if (paramOnLinePushMessageProcessor.a(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        VipUtils.a(paramOnLinePushMessageProcessor.a(), localMsgBody);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x120, handle0x210_0x120push");
        }
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x120], errInfo->" + paramOnLinePushMessageProcessor.getMessage());
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x120
 * JD-Core Version:    0.7.0.1
 */