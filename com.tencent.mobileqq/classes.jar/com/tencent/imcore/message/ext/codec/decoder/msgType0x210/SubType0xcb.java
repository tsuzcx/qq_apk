package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
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
  implements Msg0X210SubTypeDecoder
{
  private static void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool2 = true;
    Object localObject = new SubMsgType0xcb.MsgBody();
    label468:
    String str;
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
      if (((SubMsgType0xcb.MsgBody)localObject).uint32_anchor_status.get() == 1)
      {
        bool1 = true;
        paramArrayOfByte.isLiving = bool1;
        paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_jump_schema.get().toStringUtf8();
        paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_wording.get().toStringUtf8();
        paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_head_url.get().toStringUtf8();
        paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_nickname.get().toStringUtf8();
        paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_end_wording.get().toStringUtf8();
        paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_c2c_msg_wording.get().toStringUtf8();
        paramArrayOfByte.startLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get();
        paramArrayOfByte.endLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get();
        paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
        paramArrayOfByte.getBytes();
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get()).append("endLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get());
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        }
        if ((!MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) || (MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl))) {
          break label468;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + paramArrayOfByte.jumpingUrl);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + paramArrayOfByte.toString());
            continue;
            bool1 = false;
          }
        }
        paramMsgInfo = new ArrayList();
      } while (MessageHandlerUtils.a(paramOnLinePushMessageProcessor.a(), paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      boolean bool3 = paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + AppConstants.NOW_LIVE_TIP_UIN_BASE));
      if (bool3) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = MessageHandlerUtils.a(paramMsgInfo);
        int i = MsgProxyUtils.a(paramMsgInfo, paramOnLinePushMessageProcessor.a().getMsgCache());
        localObject = paramOnLinePushMessageProcessor.a().getMessageFacade();
        str = paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
        if ((bool2) && (paramOnLinePushMessageProcessor.a().isBackgroundStop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
          paramOnLinePushMessageProcessor.a().getMsgCache().a((int)paramArrayOfByte.time);
          if ((StudyModeManager.a()) || (!bool3)) {
            break;
          }
          paramOnLinePushMessageProcessor.a("handleGetBuddyMessageResp", true, i, paramOnLinePushMessageProcessor.a().getMsgHandler().a(bool2), false);
          return;
        }
      }
      localObject = paramOnLinePushMessageProcessor.a().getMessageFacade().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
      if (localObject != null)
      {
        paramOnLinePushMessageProcessor.a().getMessageFacade().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, ((MessageRecord)localObject).uniseq, paramArrayOfByte.msgData);
        paramOnLinePushMessageProcessor.a().getMessageFacade().a(localObject);
        return;
      }
      bool1 = MessageHandlerUtils.a(paramMsgInfo);
      localObject = paramOnLinePushMessageProcessor.a().getMessageFacade();
      str = paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
      if (!bool1) {
        break label783;
      }
    }
    if (paramOnLinePushMessageProcessor.a().isBackgroundStop) {}
    label783:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
      paramOnLinePushMessageProcessor.a().getMsgCache().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf, paramMsgInfo);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcb
 * JD-Core Version:    0.7.0.1
 */