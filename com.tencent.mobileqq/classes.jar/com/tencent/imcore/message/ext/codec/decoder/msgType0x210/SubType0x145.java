package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.olympic.OlympicMedalEventHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x145.SubMsgType0x145.MsgBody;

public class SubType0x145
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    paramMsgType0x210 = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    paramOnLinePushMessageProcessor = new SubMsgType0x145.MsgBody();
    for (;;)
    {
      try
      {
        paramOnLinePushMessageProcessor.mergeFrom(paramArrayOfByte);
        if (paramOnLinePushMessageProcessor.event_id.has())
        {
          i = paramOnLinePushMessageProcessor.event_id.get();
          boolean bool = paramOnLinePushMessageProcessor.start.has();
          long l = -1L;
          if (!bool) {
            break label263;
          }
          paramLong = paramOnLinePushMessageProcessor.start.get();
          if (paramOnLinePushMessageProcessor.end.has()) {
            l = paramOnLinePushMessageProcessor.end.get();
          }
          if (!paramOnLinePushMessageProcessor.msg.has()) {
            break label270;
          }
          paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor.msg.get();
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("SubType0x145 end=");
          paramArrayOfByte.append(l);
          paramArrayOfByte.append(" eventId=");
          paramArrayOfByte.append(i);
          paramArrayOfByte.append(" startTime=");
          paramArrayOfByte.append(paramLong);
          paramArrayOfByte.append(" msg=");
          paramArrayOfByte.append(paramOnLinePushMessageProcessor);
          QLog.e("SubType0x145", 1, paramArrayOfByte.toString());
          ((OlympicMedalEventHandler)paramMsgType0x210.getBusinessHandler(OlympicMedalEventHandler.class.getName())).a(new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), paramOnLinePushMessageProcessor });
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramOnLinePushMessageProcessor)
      {
        QLog.e("SubType0x145", 1, "C2C revoke OlympicMetalEvent push", paramOnLinePushMessageProcessor);
        return null;
      }
      int i = -1;
      continue;
      label263:
      paramLong = -1L;
      continue;
      label270:
      paramOnLinePushMessageProcessor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x145
 * JD-Core Version:    0.7.0.1
 */