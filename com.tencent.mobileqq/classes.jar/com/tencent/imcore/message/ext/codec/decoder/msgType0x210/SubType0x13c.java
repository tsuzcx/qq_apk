package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.MsgType0x210_SubMsgType0x13c.MsgBody;

public class SubType0x13c
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    GdtLog.a("SubType0x13b", "SubType0x13c receive");
    paramOnLinePushMessageProcessor = new MsgType0x210_SubMsgType0x13c.MsgBody();
    try
    {
      paramOnLinePushMessageProcessor.mergeFrom(paramArrayOfByte);
      paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor.str_msg_id.get();
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("msg_id:");
      paramMsgType0x210.append(paramOnLinePushMessageProcessor);
      GdtLog.a("SubType0x13b", paramMsgType0x210.toString());
    }
    catch (InvalidProtocolBufferMicroException paramOnLinePushMessageProcessor)
    {
      paramOnLinePushMessageProcessor.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x13c
 * JD-Core Version:    0.7.0.1
 */