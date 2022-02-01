package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;

public class SubType0x144
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    if (paramOnLinePushMessageProcessor != null) {
      try
      {
        if (paramOnLinePushMessageProcessor.a() != null)
        {
          paramMsgType0x210 = (IGPSService)paramOnLinePushMessageProcessor.a().getRuntimeService(IGPSService.class, "");
          if (paramMsgType0x210 != null)
          {
            paramMsgInfo = new MsgRouttingHead("", "", "", "", "");
            paramOnLinePushMessageProcessor = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              paramOnLinePushMessageProcessor = new byte[0];
            }
            paramMsgType0x210.onSrvPushMsg(528, 324, paramMsgInfo, paramOnLinePushMessageProcessor);
          }
        }
      }
      catch (Exception paramOnLinePushMessageProcessor)
      {
        paramOnLinePushMessageProcessor.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x144
 * JD-Core Version:    0.7.0.1
 */