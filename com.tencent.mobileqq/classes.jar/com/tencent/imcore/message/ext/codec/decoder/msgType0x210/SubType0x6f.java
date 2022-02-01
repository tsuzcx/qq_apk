package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.RewardInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;

public class SubType0x6f
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("msg0x210.SubMsgType0x6f", 2, "get notice from handleC2COnlinePushMsg0x210Resp");
    }
    for (;;)
    {
      try
      {
        SubMsgType0x6f.MsgBody localMsgBody = new SubMsgType0x6f.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        int i = 0;
        if (i < localMsgBody.rpt_msg_mod_infos.size())
        {
          paramMsgType0x210 = (SubMsgType0x6f.ForwardBody)localMsgBody.rpt_msg_mod_infos.get().get(i);
          boolean bool = paramMsgType0x210.uint32_op_type.has();
          j = -1;
          if (bool)
          {
            k = paramMsgType0x210.uint32_op_type.get();
            Object localObject1;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("get notice from handleC2COnlinePushMsg0x210Resp ");
              ((StringBuilder)localObject1).append(k);
              QLog.d("msg0x210.SubMsgType0x6f", 2, ((StringBuilder)localObject1).toString());
            }
            long l = 0L;
            Object localObject2;
            if ((k == 2001) && (paramMsgType0x210.msg_mcard_notification_like.has()))
            {
              localObject1 = (SubMsgType0x6f.MCardNotificationLike)paramMsgType0x210.msg_mcard_notification_like.get();
              paramMsgType0x210 = "";
              if (((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.has()) {
                paramMsgType0x210 = ((SubMsgType0x6f.MCardNotificationLike)localObject1).str_wording.get();
              }
              if (!((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.has()) {
                break label1690;
              }
              j = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_new.get();
              if (((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.has()) {
                l = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint64_from_uin.get();
              }
              if (!((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.has()) {
                break label1696;
              }
              k = ((SubMsgType0x6f.MCardNotificationLike)localObject1).uint32_counter_total.get();
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("card_notification_like : wording: ");
                ((StringBuilder)localObject2).append(paramMsgType0x210);
                ((StringBuilder)localObject2).append(" totalCount: ");
                ((StringBuilder)localObject2).append(k);
                ((StringBuilder)localObject2).append(" newCount: ");
                ((StringBuilder)localObject2).append(j);
                ((StringBuilder)localObject2).append(" fromUin: ");
                ((StringBuilder)localObject2).append(l);
                QLog.d("msg0x210.SubMsgType0x6f", 2, ((StringBuilder)localObject2).toString());
              }
              paramMsgType0x210 = (DatingProxyManager)paramQQAppInterface.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
              if (paramMsgType0x210 != null) {
                paramMsgType0x210.a().a((SubMsgType0x6f.MCardNotificationLike)localObject1);
              }
            }
            else if ((k == 2002) && (paramMsgType0x210.msg_vip_info_notify.has()))
            {
              localObject1 = (SubMsgType0x6f.VipInfoNotify)paramMsgType0x210.msg_vip_info_notify.get();
              if (QLog.isColorLevel())
              {
                paramMsgType0x210 = new StringBuilder();
                paramMsgType0x210.append("vip info notify: ");
                paramMsgType0x210.append(localObject1.toString());
                QLog.d("Q.msg.BaseMessageProcessor", 2, paramMsgType0x210.toString());
              }
              if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.has()) {
                l = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint64_uin.get();
              }
              paramMsgType0x210 = Long.toString(l);
              if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.has()) {
                break label1702;
              }
              k = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_identify.get();
              if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_level.has()) {
                break label1708;
              }
              m = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_vip_level.get();
              if (!((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_red_flag.has()) {
                break label1714;
              }
              n = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_red_flag.get();
              if (((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_disable_red_envelope.has()) {
                j = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_disable_red_envelope.get();
              }
              int i1 = ((SubMsgType0x6f.VipInfoNotify)localObject1).uint32_redpack_id.get();
              localObject1 = ((SubMsgType0x6f.VipInfoNotify)localObject1).str_redpack_name.get();
              if (!QLog.isColorLevel()) {
                break label1720;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("iRedPacketId = ");
              ((StringBuilder)localObject2).append(i1);
              ((StringBuilder)localObject2).append(";redText = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject2).toString());
              break label1720;
              localObject2 = (IndividualRedPacketManager)paramQQAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
              ((IndividualRedPacketManager)localObject2).a(n, j, true);
              ((IndividualRedPacketManager)localObject2).a(i1, (String)localObject1);
              if (!QLog.isColorLevel()) {
                break label1733;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("UIN ");
              ((StringBuilder)localObject1).append(paramMsgType0x210);
              ((StringBuilder)localObject1).append(" vip info changed.");
              QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject1).toString());
              break label1733;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("need pull vip info from svr. vipIdentiy=");
                ((StringBuilder)localObject1).append(k);
                ((StringBuilder)localObject1).append("; vipLevel=");
                ((StringBuilder)localObject1).append(m);
                QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject1).toString());
              }
              localObject1 = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramMsgType0x210);
              ((VipInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject1, paramMsgType0x210);
              TroopKeywordManager.a(paramQQAppInterface).c();
            }
            else if ((k == 2003) && (paramMsgType0x210.msg_push_lost_dev_found.has()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QFindBLE", 2, "onlinePush receive ...");
              }
              paramMsgType0x210 = (SubMsgType0x6f.PushLostDevFound)paramMsgType0x210.msg_push_lost_dev_found.get();
              localObject1 = new Bundle();
              if (paramMsgType0x210.uint32_msg_type.has()) {
                ((Bundle)localObject1).putInt("msgtype", paramMsgType0x210.uint32_msg_type.get());
              }
              if (paramMsgType0x210.uint32_dev_time.has()) {
                ((Bundle)localObject1).putInt("devtime", paramMsgType0x210.uint32_dev_time.get());
              }
              if (paramMsgType0x210.uint64_din.has()) {
                ((Bundle)localObject1).putLong("din", paramMsgType0x210.uint64_din.get());
              }
              ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(111, (Bundle)localObject1);
            }
            else if ((k == 2007) && (paramMsgType0x210.msg_babyq_reward_info.has()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg_babyq_reward_info...");
              }
              ((BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(paramMsgType0x210);
            }
            else if ((k == 2011) && (paramMsgType0x210.msg_mod_qim_friend_to_qq.has()))
            {
              paramMsgType0x210 = (SubMsgType0x6f.QimFriendNotifyToQQ)paramMsgType0x210.msg_mod_qim_friend_to_qq.get();
              if (paramMsgType0x210.uint32_notify_type.has()) {
                j = paramMsgType0x210.uint32_notify_type.get();
              }
              bool = QLog.isColorLevel();
              if (bool)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("receive msg_add_notify_to_qq... ");
                ((StringBuilder)localObject1).append(j);
                QLog.d("QIMNewNotifyPush", 2, ((StringBuilder)localObject1).toString());
              }
              if (j != 1) {
                break label1746;
              }
              if (paramMsgType0x210.msg_add_notify_to_qq.has())
              {
                paramMsgType0x210 = paramMsgType0x210.msg_add_notify_to_qq;
                localObject1 = new QIMFollwerAdd();
                ((QIMFollwerAdd)localObject1).uin = paramMsgType0x210.uint64_uin.get();
                ((QIMFollwerAdd)localObject1).gender = paramMsgType0x210.uint32_gender.get();
                ((QIMFollwerAdd)localObject1).careSCount = paramMsgType0x210.uint64_cares_count.get();
                ((QIMFollwerAdd)localObject1).totalNum = paramMsgType0x210.uint64_storys_total_num.get();
                ((QIMFollwerAdd)localObject1).smartRemark = paramMsgType0x210.bytes_smart_remark.get().toStringUtf8();
                ((QIMFollwerAdd)localObject1).opType = paramMsgType0x210.uint32_op_type.get();
                ((QIMFollwerAdd)localObject1).fansCount = paramMsgType0x210.uint64_fans_count.get();
                ((QIMFollwerAdd)localObject1).longNick = RichStatus.parseStatus(paramMsgType0x210.bytes_longnick.get().toByteArray()).getPlainText();
                ((QIMFollwerAdd)localObject1).upTime = MessageCache.c();
                ((QIMFollwerAdd)localObject1).source = paramMsgType0x210.bytes_src_wording.get().toStringUtf8();
                ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).handleQIMNewFollower((QIMFollwerAdd)localObject1);
                continue;
                if ((j == 3) && (paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.has()))
                {
                  localObject1 = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.get();
                  paramMsgType0x210 = new QIMNotifyAddFriend();
                  paramMsgType0x210.uin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).uint64_uin.get();
                  paramMsgType0x210.qqUin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).uint64_qq_uin.get();
                  paramMsgType0x210.nickName = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).bytes_nick.get().toStringUtf8();
                  paramMsgType0x210.gender = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).uint32_gender.get();
                  paramMsgType0x210.age = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).uint32_age.get();
                  paramMsgType0x210.coverStory = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).bytes_coverstory.get().toStringUtf8();
                  paramMsgType0x210.storyTotalNum = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).uint64_storys_total_num.get();
                  paramMsgType0x210.wording = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).bytes_wording.get().toStringUtf8();
                  j = 0;
                  if (j < ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).rpt_msg_video_info.size())
                  {
                    localObject2 = (SubMsgType0x6f.VideoInfo)((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject1).rpt_msg_video_info.get(j);
                    QIMNotifyAddFriend.VideoInfo localVideoInfo = new QIMNotifyAddFriend.VideoInfo();
                    localVideoInfo.coverUrl = ((SubMsgType0x6f.VideoInfo)localObject2).bytes_video_cover_url.get().toStringUtf8();
                    localVideoInfo.videoVid = ((SubMsgType0x6f.VideoInfo)localObject2).bytes_vid.get().toStringUtf8();
                    paramMsgType0x210.videoInfos.add(localVideoInfo);
                    j += 1;
                    continue;
                  }
                  paramMsgType0x210.pushTime = MessageCache.c();
                  if (QLog.isColorLevel())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("receive data= ");
                    ((StringBuilder)localObject1).append(paramMsgType0x210.toString());
                    QLog.d("QIMNewNotifyPush", 2, ((StringBuilder)localObject1).toString());
                  }
                  ((QIMNewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramMsgType0x210);
                }
              }
            }
            MessageProtoCodec.a(paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType, paramMessageHandler.b());
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel())
        {
          paramMessageHandler = new StringBuilder();
          paramMessageHandler.append("exception : ");
          paramMessageHandler.append(paramQQAppInterface);
          QLog.d("msg0x210.SubMsgType0x6f", 2, paramMessageHandler.toString());
        }
      }
      int k = -1;
      continue;
      label1690:
      int j = 0;
      continue;
      label1696:
      k = 0;
      continue;
      label1702:
      k = 0;
      continue;
      label1708:
      int m = 0;
      continue;
      label1714:
      int n = -1;
      continue;
      label1720:
      if (n < 0) {
        if (j >= 0)
        {
          continue;
          label1733:
          if (k == 0) {
            if (m != 0)
            {
              continue;
              label1746:
              if (j != 2) {}
            }
          }
        }
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    a(paramOnLinePushMessageProcessor, paramOnLinePushMessageProcessor.getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6f
 * JD-Core Version:    0.7.0.1
 */