package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x141.SubMsgType0x141.MsgBody;

public class SubType0x141
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    SubMsgType0x141.MsgBody localMsgBody = new SubMsgType0x141.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        boolean bool = localMsgBody.uint64_aio_uin.has();
        paramMsgInfo = "";
        if (!bool) {
          break label140;
        }
        paramMsgType0x210 = String.valueOf(localMsgBody.uint64_aio_uin.get());
        if (!localMsgBody.uint64_busi_id.has()) {
          break label146;
        }
        paramArrayOfByte = String.valueOf(localMsgBody.uint64_busi_id.get());
        if (localMsgBody.uint64_tips_seq_id.has()) {
          paramMsgInfo = String.valueOf(localMsgBody.uint64_tips_seq_id.get());
        }
        ((QQAppInterface)paramOnLinePushMessageProcessor.a()).getMessageFacade().a().a(paramMsgType0x210, paramArrayOfByte, paramMsgInfo, 0, true);
      }
      catch (InvalidProtocolBufferMicroException paramOnLinePushMessageProcessor)
      {
        QLog.e("SubType0x141", 1, "C2C revoke PaiYiPai push", paramOnLinePushMessageProcessor);
      }
      return null;
      label140:
      paramMsgType0x210 = "";
      continue;
      label146:
      paramArrayOfByte = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x141
 * JD-Core Version:    0.7.0.1
 */