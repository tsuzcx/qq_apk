package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;

public class SubType0xcb
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    Object localObject2 = new SubMsgType0xcb.MsgBody();
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodeNearbyLiveTipMsg decode failed");
        ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
        QLog.i("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramArrayOfByte = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
    int i = ((SubMsgType0xcb.MsgBody)localObject2).uint32_anchor_status.get();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramArrayOfByte.isLiving = bool1;
    paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject2).bytes_jump_schema.get().toStringUtf8();
    paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject2).bytes_live_wording.get().toStringUtf8();
    paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject2).bytes_anchor_head_url.get().toStringUtf8();
    paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject2).bytes_anchor_nickname.get().toStringUtf8();
    paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject2).bytes_live_end_wording.get().toStringUtf8();
    paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject2).bytes_c2c_msg_wording.get().toStringUtf8();
    paramArrayOfByte.startLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject2).uint32_live_wording_type.get();
    paramArrayOfByte.endLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject2).uint32_end_wording_type.get();
    paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
    paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
    paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
    paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
    Object localObject1 = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    paramArrayOfByte.selfuin = ((QQAppInterface)localObject1).getCurrentAccountUin();
    paramArrayOfByte.istroop = 1001;
    paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
    paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
    paramArrayOfByte.getBytes();
    if (QLog.isColorLevel())
    {
      paramMsgInfo = new StringBuilder();
      paramMsgInfo.append("status=");
      paramMsgInfo.append(paramArrayOfByte.isLiving);
      paramMsgInfo.append("jumpingUrl=");
      paramMsgInfo.append(paramArrayOfByte.jumpingUrl);
      paramMsgInfo.append("liveWording=");
      paramMsgInfo.append(paramArrayOfByte.msg);
      paramMsgInfo.append("headUrl");
      paramMsgInfo.append(paramArrayOfByte.headUrl);
      paramMsgInfo.append("nickName");
      paramMsgInfo.append(paramArrayOfByte.nickName);
      paramMsgInfo.append("startLiveWordingType=");
      paramMsgInfo.append(((SubMsgType0xcb.MsgBody)localObject2).uint32_live_wording_type.get());
      paramMsgInfo.append("endLiveWordingType=");
      paramMsgInfo.append(((SubMsgType0xcb.MsgBody)localObject2).uint32_end_wording_type.get());
      QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
    }
    if ((MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl)))
    {
      if (QLog.isColorLevel())
      {
        paramOnLinePushMessageProcessor = new StringBuilder();
        paramOnLinePushMessageProcessor.append("decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=");
        paramOnLinePushMessageProcessor.append(paramArrayOfByte.jumpingUrl);
        QLog.i("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
      }
      return;
    }
    paramMsgInfo = new ArrayList();
    if (!MessageHandlerUtils.a((AppInterface)localObject1, paramArrayOfByte, true))
    {
      paramMsgInfo.add(paramArrayOfByte);
      boolean bool4 = paramArrayOfByte.senderuin.equals(String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + 1822701914L));
      if (bool4) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool3 = MessageHandlerUtils.a(paramMsgInfo);
        i = MsgProxyUtils.a(paramMsgInfo, ((QQAppInterface)localObject1).getMsgCache());
        localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
        String str = ((QQAppInterface)localObject1).getCurrentAccountUin();
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (((QQAppInterface)localObject1).isBackgroundStop) {
            bool1 = true;
          }
        }
        ((QQMessageFacade)localObject2).a(paramMsgInfo, str, bool1);
        ((QQAppInterface)localObject1).getMsgCache().a((int)paramArrayOfByte.time);
        if (StudyModeManager.a()) {
          return;
        }
        if (bool4) {
          paramOnLinePushMessageProcessor.a("handleGetBuddyMessageResp", true, i, ((QQAppInterface)localObject1).getMsgHandler().a(bool3), false);
        }
      }
      else
      {
        paramOnLinePushMessageProcessor = ((QQAppInterface)localObject1).getMessageFacade().getLastMessage(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
        if (paramOnLinePushMessageProcessor != null)
        {
          ((QQAppInterface)localObject1).getMessageFacade().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, paramOnLinePushMessageProcessor.uniseq, paramArrayOfByte.msgData);
          ((QQAppInterface)localObject1).getMessageFacade().a(paramOnLinePushMessageProcessor);
          return;
        }
        bool2 = MessageHandlerUtils.a(paramMsgInfo);
        paramOnLinePushMessageProcessor = ((QQAppInterface)localObject1).getMessageFacade();
        localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        bool1 = bool3;
        if (bool2)
        {
          bool1 = bool3;
          if (((QQAppInterface)localObject1).isBackgroundStop) {
            bool1 = true;
          }
        }
        paramOnLinePushMessageProcessor.a(paramMsgInfo, (String)localObject2, bool1);
        ((QQAppInterface)localObject1).getMsgCache().a((int)paramArrayOfByte.time);
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf, paramMsgInfo);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcb
 * JD-Core Version:    0.7.0.1
 */