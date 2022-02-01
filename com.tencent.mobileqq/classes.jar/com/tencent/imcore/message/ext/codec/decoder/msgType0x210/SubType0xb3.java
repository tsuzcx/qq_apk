package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import friendlist.EAddFriendSourceID;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;

public class SubType0xb3
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  public static String a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    Object localObject = null;
    try
    {
      paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
      }
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
      }
      return null;
    }
    if (!paramArrayOfByte.msg_add_frd_notify.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
      }
      return null;
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
    int i = localPushAddFrdNotify.uint32_source_id.get();
    int j = localPushAddFrdNotify.uint32_subsource_id.get();
    long l1;
    if (localPushAddFrdNotify.uint64_req_uin.has()) {
      l1 = localPushAddFrdNotify.uint64_req_uin.get();
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("decodeC2CMsgPkgSubMsgType0xb3, sourceid:");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append("|subSourceid:");
      paramArrayOfByte.append(j);
      paramArrayOfByte.append(" |reqUin: ");
      paramArrayOfByte.append(l1);
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, paramArrayOfByte.toString());
    }
    if ((i != 3076) && (i != 3077) && (i != 2076) && (i != 2077) && (i != 10012))
    {
      if (i == 10013) {
        return null;
      }
      boolean bool = EAddFriendSourceID.a(i);
      FriendListHandler localFriendListHandler = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (bool)
      {
        if (localPushAddFrdNotify.bytes_mobile.has()) {
          paramQQAppInterface = localPushAddFrdNotify.bytes_mobile.get().toStringUtf8();
        } else {
          paramQQAppInterface = null;
        }
      }
      else {
        paramQQAppInterface = null;
      }
      long l3 = localPushAddFrdNotify.uint64_fuin.get();
      long l2;
      if (localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {
        l2 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();
      } else {
        l2 = -1L;
      }
      paramArrayOfByte = localObject;
      if (localPushAddFrdNotify.bytes_wording.has()) {
        paramArrayOfByte = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
      }
      localFriendListHandler.addGreetingMsg(String.valueOf(l3), paramQQAppInterface, l2, paramArrayOfByte, localPushAddFrdNotify.fixed32_timestamp.get(), i, j, l1);
      return String.valueOf(localPushAddFrdNotify.uint64_fuin.get());
    }
    return null;
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3
 * JD-Core Version:    0.7.0.1
 */