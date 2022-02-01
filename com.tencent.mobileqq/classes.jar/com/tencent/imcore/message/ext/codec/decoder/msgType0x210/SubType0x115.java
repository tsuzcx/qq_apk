package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.inputstatus.InputStatusPushManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.NotifyItem;

public class SubType0x115
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x115, [S2C push for input status]");
    }
    try
    {
      SubMsgType0x115.MsgBody localMsgBody = new SubMsgType0x115.MsgBody();
      if (paramOnLinePushMessageProcessor.b(paramMsgType0x210))
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        long l1 = localMsgBody.uint64_from_uin.get();
        long l2 = localMsgBody.uint64_to_uin.get();
        paramMsgType0x210 = (SubMsgType0x115.NotifyItem)localMsgBody.msg_notify_item.get();
        int i = paramMsgType0x210.uint32_timeout_s.get();
        int j = paramMsgType0x210.uint32_event_type.get();
        int k = paramMsgType0x210.uint32_interval.get();
        long l3 = paramMsgType0x210.uint64_timestamp.get();
        paramMsgType0x210 = paramMsgType0x210.bytes_wording.get().toStringUtf8();
        paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.AIO_INPUT_STATUS_MANAGER);
        if ((paramOnLinePushMessageProcessor instanceof InputStatusPushManager))
        {
          ((InputStatusPushManager)paramOnLinePushMessageProcessor).a(l1, l2, l3, k, i, j, paramMsgType0x210);
          return;
        }
      }
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      paramMsgType0x210 = new StringBuilder();
      paramMsgType0x210.append("[msg0x210.uSubMsgType == 0x115], errInfo->");
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
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x115
 * JD-Core Version:    0.7.0.1
 */