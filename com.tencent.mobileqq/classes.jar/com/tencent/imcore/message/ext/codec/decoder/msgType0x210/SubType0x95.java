package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mqp.app.sec.d;

public class SubType0x95
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    try
    {
      d.e1(2, d.x(), paramMsgType0x210.vProtobuf);
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x95
 * JD-Core Version:    0.7.0.1
 */