import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;

public class bctv
  implements bctr
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
    }
    if (paramMsgType0x210.msg_content == null) {
      if (QLog.isColorLevel()) {
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
      }
    }
    int i;
    long l;
    int j;
    do
    {
      do
      {
        return;
        paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
        if (paramMsgType0x210 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
      return;
      try
      {
        paramList = new SubMsgType0x6f.MsgBody();
        paramList.mergeFrom(paramMsgType0x210);
        paramMsgType0x210 = (SubMsgType0x6f.ForwardBody)paramList.rpt_msg_mod_infos.get().get(0);
        i = -1;
        if (paramMsgType0x210.uint32_op_type.has()) {
          i = paramMsgType0x210.uint32_op_type.get();
        }
        if ((i != 2001) || (!paramMsgType0x210.msg_mcard_notification_like.has())) {
          break;
        }
        paramList = (SubMsgType0x6f.MCardNotificationLike)paramMsgType0x210.msg_mcard_notification_like.get();
        paramMsgType0x210 = "";
        l = 0L;
        j = 0;
        i = 0;
        if (paramList.str_wording.has()) {
          paramMsgType0x210 = paramList.str_wording.get();
        }
        if (paramList.uint32_counter_new.has()) {
          i = paramList.uint32_counter_new.get();
        }
        if (paramList.uint64_from_uin.has()) {
          l = paramList.uint64_from_uin.get();
        }
        if (paramList.uint32_counter_total.has()) {
          j = paramList.uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + paramMsgType0x210 + " totalCount: " + j + " newCount: " + i + " fromUin: " + l);
        }
        paramMsgType0x210 = (asak)paramMessageHandler.app.getManager(71);
        if (paramMsgType0x210 != null) {
          paramMsgType0x210.a().a(paramList);
        }
        bcrw.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMsgType0x210) {}
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMsgType0x210);
    return;
    if ((i == 2002) && (paramMsgType0x210.msg_vip_info_notify.has()))
    {
      paramList = (SubMsgType0x6f.VipInfoNotify)paramMsgType0x210.msg_vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandTipsDecoder", 2, "vip info notify: " + paramList.toString());
      }
      l = 0L;
      i = 0;
      if (paramList.uint64_uin.has()) {
        l = paramList.uint64_uin.get();
      }
      paramMsgType0x210 = Long.toString(l);
      if (paramList.uint32_vip_identify.has()) {
        i = paramList.uint32_vip_identify.get();
      }
      if (!paramList.uint32_vip_level.has()) {
        break label1333;
      }
      j = paramList.uint32_vip_level.get();
      label517:
      if (!QLog.isColorLevel()) {
        break label1339;
      }
      QLog.d("TurnBrandTipsDecoder", 2, "UIN " + paramMsgType0x210 + " vip info changed.");
      break label1339;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandTipsDecoder", 2, "need pull vip info from svr. vipIdentiy=" + i + "; vipLevel=" + j);
      }
      paramList = ((TicketManager)paramMessageHandler.app.getManager(2)).getSkey(paramMsgType0x210);
      ((aokv)paramMessageHandler.app.a(27)).a(paramList, paramMsgType0x210);
      break;
      if ((i == 2003) && (paramMsgType0x210.msg_push_lost_dev_found.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QFindBLE", 2, "offlinePush receive ...");
        }
        paramMsgType0x210 = (SubMsgType0x6f.PushLostDevFound)paramMsgType0x210.msg_push_lost_dev_found.get();
        paramList = new Bundle();
        if (paramMsgType0x210.uint32_msg_type.has()) {
          paramList.putInt("msgtype", paramMsgType0x210.uint32_msg_type.get());
        }
        if (paramMsgType0x210.uint32_dev_time.has()) {
          paramList.putInt("devtime", paramMsgType0x210.uint32_dev_time.get());
        }
        if (paramMsgType0x210.uint64_din.has()) {
          paramList.putLong("din", paramMsgType0x210.uint64_din.get());
        }
        ((abur)paramMessageHandler.app.a(51)).a(111, paramList);
        break;
      }
      if ((i != 2011) || (!paramMsgType0x210.msg_mod_qim_friend_to_qq.has())) {
        break;
      }
      paramMsgType0x210 = (SubMsgType0x6f.QimFriendNotifyToQQ)paramMsgType0x210.msg_mod_qim_friend_to_qq.get();
      i = -1;
      if (paramMsgType0x210.uint32_notify_type.has()) {
        i = paramMsgType0x210.uint32_notify_type.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewNotifyPush_offLine", 2, "receive msg_add_notify_to_qq... " + i);
      }
      if (i == 1)
      {
        if (!paramMsgType0x210.msg_add_notify_to_qq.has()) {
          break;
        }
        paramMsgType0x210 = paramMsgType0x210.msg_add_notify_to_qq;
        paramList = new QIMFollwerAdd();
        paramList.uin = paramMsgType0x210.uint64_uin.get();
        paramList.gender = paramMsgType0x210.uint32_gender.get();
        paramList.careSCount = paramMsgType0x210.uint64_cares_count.get();
        paramList.totalNum = paramMsgType0x210.uint64_storys_total_num.get();
        paramList.smartRemark = paramMsgType0x210.bytes_smart_remark.get().toStringUtf8();
        paramList.opType = paramMsgType0x210.uint32_op_type.get();
        paramList.fansCount = paramMsgType0x210.uint64_fans_count.get();
        paramList.longNick = RichStatus.parseStatus(paramMsgType0x210.bytes_longnick.get().toByteArray()).getPlainText();
        paramList.upTime = bcrg.a();
        paramList.source = paramMsgType0x210.bytes_src_wording.get().toStringUtf8();
        ((ajka)paramMessageHandler.app.getManager(34)).b(paramList);
        break;
      }
      if ((i == 2) || (i != 3) || (!paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.has())) {
        break;
      }
      paramMsgType0x210 = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)paramMsgType0x210.msg_add_not_login_frd_notify_to_qq.get();
      paramList = new QIMNotifyAddFriend();
      paramList.uin = paramMsgType0x210.uint64_uin.get();
      paramList.qqUin = paramMsgType0x210.uint64_qq_uin.get();
      paramList.nickName = paramMsgType0x210.bytes_nick.get().toStringUtf8();
      paramList.gender = paramMsgType0x210.uint32_gender.get();
      paramList.age = paramMsgType0x210.uint32_age.get();
      paramList.coverStory = paramMsgType0x210.bytes_coverstory.get().toStringUtf8();
      paramList.storyTotalNum = paramMsgType0x210.uint64_storys_total_num.get();
      paramList.wording = paramMsgType0x210.bytes_wording.get().toStringUtf8();
      i = 0;
      while (i < paramMsgType0x210.rpt_msg_video_info.size())
      {
        parambcre = (SubMsgType0x6f.VideoInfo)paramMsgType0x210.rpt_msg_video_info.get(i);
        QIMNotifyAddFriend.VideoInfo localVideoInfo = new QIMNotifyAddFriend.VideoInfo();
        localVideoInfo.coverUrl = parambcre.bytes_video_cover_url.get().toStringUtf8();
        localVideoInfo.videoVid = parambcre.bytes_vid.get().toStringUtf8();
        paramList.videoInfos.add(localVideoInfo);
        i += 1;
      }
      paramList.pushTime = bcrg.a();
      if (QLog.isColorLevel()) {
        QLog.d("QIMNewNotifyPush_offLine", 2, "receive data= " + paramList.toString());
      }
      ((aoej)paramMessageHandler.app.getManager(257)).a(paramList);
      break;
      label1333:
      j = 0;
      break label517;
      label1339:
      if (i == 0) {
        if (j == 0) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctv
 * JD-Core Version:    0.7.0.1
 */