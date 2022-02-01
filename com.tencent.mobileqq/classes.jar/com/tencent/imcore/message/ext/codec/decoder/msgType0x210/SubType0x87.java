package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;

public class SubType0x87
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0x87.MsgBody localMsgBody = new SubMsgType0x87.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if (localMsgBody.uint64_friend_msg_type_flag.has())
      {
        int i;
        if (localMsgBody.uint64_friend_msg_type_flag.get() == 1L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          paramMessageHandler.a().a(2);
        }
      }
      if (localMsgBody.rpt_msg_msg_notify.has()) {
        CloneFriendPushHelper.a(paramQQAppInterface, localMsgBody);
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "", paramQQAppInterface);
      }
      throw new RuntimeException(paramQQAppInterface);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    a(paramOnLinePushMessageProcessor, paramOnLinePushMessageProcessor.getMsgHandler(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x87
 * JD-Core Version:    0.7.0.1
 */