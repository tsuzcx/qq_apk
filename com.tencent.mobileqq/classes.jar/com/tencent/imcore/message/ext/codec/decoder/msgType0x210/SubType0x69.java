package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class SubType0x69
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = TroopRedTouchHandler.a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    if (paramMsgType0x210 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "receive push");
      }
      paramOnLinePushMessageProcessor.a(105, true, paramMsgType0x210);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x69
 * JD-Core Version:    0.7.0.1
 */