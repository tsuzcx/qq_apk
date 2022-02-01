package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;

public class SubType0xae
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    SubMsgType0xae.MsgBody localMsgBody = new SubMsgType0xae.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      if ((!localMsgBody.uint32_type.has()) || (localMsgBody.uint32_type.get() != 2)) {
        break label650;
      }
      long l = localMsgBody.msg_persons_may_know.fixed32_timestamp.get();
      if (QLog.isColorLevel())
      {
        paramMsgType0x210 = new StringBuilder();
        paramMsgType0x210.append("handlePushRecommend receive push time=");
        paramMsgType0x210.append(l);
        QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
      }
      Object localObject = localMsgBody.msg_persons_may_know.rpt_msg_friend_list.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMsgType0x210 = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xae.PersonMayKnow localPersonMayKnow = (SubMsgType0xae.PersonMayKnow)((Iterator)localObject).next();
          PushRecommend localPushRecommend = new PushRecommend();
          if (localPersonMayKnow.uint64_uin.has()) {
            localPushRecommend.uin = Long.toString(localPersonMayKnow.uint64_uin.get());
          }
          if (localPersonMayKnow.bytes_name.has()) {
            localPushRecommend.nick = new String(localPersonMayKnow.bytes_name.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_age.has()) {
            localPushRecommend.age = ((short)localPersonMayKnow.uint32_age.get());
          }
          if (localPersonMayKnow.uint32_sex.has()) {
            localPushRecommend.gender = ((short)localPersonMayKnow.uint32_sex.get());
          }
          if (localPersonMayKnow.bytes_main_reason.has()) {
            localPushRecommend.recommendReason = new String(localPersonMayKnow.bytes_main_reason.get().toByteArray());
          }
          if (localPersonMayKnow.bytes_alghrithm.has()) {
            localPushRecommend.algBuffer = localPersonMayKnow.bytes_alghrithm.get().toByteArray();
          }
          if (localPersonMayKnow.bytes_soure_reason.has()) {
            localPushRecommend.sourceReason = new String(localPersonMayKnow.bytes_soure_reason.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_source.has()) {
            localPushRecommend.fromSource = localPersonMayKnow.uint32_source.get();
          }
          if (localPersonMayKnow.msg_android_source.has())
          {
            SubMsgType0xae.AddFriendSource localAddFriendSource = (SubMsgType0xae.AddFriendSource)localPersonMayKnow.msg_android_source.get();
            if (localAddFriendSource != null)
            {
              if (localAddFriendSource.uint32_source.has()) {
                localPushRecommend.sourceId = localAddFriendSource.uint32_source.get();
              }
              if (localAddFriendSource.uint32_sub_source.has()) {
                localPushRecommend.subSourceId = localAddFriendSource.uint32_sub_source.get();
              }
            }
          }
          if (localPersonMayKnow.bytes_msg.has()) {
            localPushRecommend.wzryVerifyStr = new String(localPersonMayKnow.bytes_msg.get().toByteArray());
          }
          if (localPersonMayKnow.uint32_game_source.has()) {
            localPushRecommend.wzrySourceId = localPersonMayKnow.uint32_game_source.get();
          }
          if (localPersonMayKnow.bytes_role_name.has()) {
            localPushRecommend.wzryGameNick = new String(localPersonMayKnow.bytes_role_name.get().toByteArray());
          }
          localPushRecommend.timestamp = l;
          paramMsgType0x210.add(localPushRecommend);
        }
      }
      if (!localMsgBody.msg_persons_may_know.bytes_role_name.has()) {
        break label650;
      }
      paramMsgType0x210 = localMsgBody.msg_persons_may_know.bytes_role_name.get().toStringUtf8();
      KplHelper.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), paramMsgType0x210);
    }
    catch (Exception paramQQAppInterface)
    {
      label634:
      break label634;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, "recv 0x210_0xae, prase msgBody error");
    }
    label650:
    MessageProtoCodec.a(paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType, paramMessageHandler.b());
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    a(paramOnLinePushMessageProcessor, paramOnLinePushMessageProcessor.getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xae
 * JD-Core Version:    0.7.0.1
 */