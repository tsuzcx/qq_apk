package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obz;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.AccountInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ContextInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ControlInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.ExtraInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.NotifyInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.OrangeControlInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.OrdinaryPushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.PictureInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.SocialPushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StatisticsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StyleSheet;
import tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.UGCPushInfo;

public class Kandian210Msg0xeeInfo
  implements Serializable
{
  public static final int APP_IN_PUSH_FOR_KANDIAN_ARTICLE = 2000002;
  public static final int APP_IN_PUSH_FOR_KANDIAN_ARTICLE_2 = 1000001;
  public static final int APP_IN_PUSH_FOR_KANDIAN_VIDEO = 2000001;
  public static final int BUBBLE_TYPE = 1;
  public static final int DEFAULT_ARK_ENABLE = 0;
  public static final int DEFAULT_TYPE = 0;
  public static final int DIALOG_TYPE = 2;
  public static final String KANDIAN_0x210_EE = "kandian_push_0x210_ee";
  public static final String TAG = "Kandian210Msg0xeeInfo";
  public int bid;
  public String msgId;
  public long msgSeq;
  public ArrayList<Kandian210Msg0xeeInfo.NotifyInfo> notifyInfos;
  
  public static Kandian210Msg0xeeInfo decodeFromPbBytes(byte[] paramArrayOfByte)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = new Kandian210Msg0xeeInfo();
    for (;;)
    {
      submsgtype0xee.NotifyInfo localNotifyInfo1;
      Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
      Object localObject2;
      try
      {
        Object localObject1 = new submsgtype0xee.MsgBody();
        ((submsgtype0xee.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        localKandian210Msg0xeeInfo.bid = ((submsgtype0xee.MsgBody)localObject1).uint32_bid.get();
        localKandian210Msg0xeeInfo.msgSeq = ((submsgtype0xee.MsgBody)localObject1).uint64_seq.get();
        if (QLog.isColorLevel())
        {
          QLog.d("Kandian210Msg0xeeInfo", 2, "receive push 0xee, bid = " + localKandian210Msg0xeeInfo.bid);
          QLog.d("Kandian210Msg0xeeInfo", 2, "receive push 0xee msgSeq = " + localKandian210Msg0xeeInfo.msgSeq);
        }
        if ((((submsgtype0xee.MsgBody)localObject1).bytes_id.has()) && (((submsgtype0xee.MsgBody)localObject1).bytes_id.get() != null)) {
          localKandian210Msg0xeeInfo.msgId = ((submsgtype0xee.MsgBody)localObject1).bytes_id.get().toStringUtf8();
        }
        if ((!((submsgtype0xee.MsgBody)localObject1).rpt_msg_notify_list.has()) || (((submsgtype0xee.MsgBody)localObject1).rpt_msg_notify_list.get() == null)) {
          break label1622;
        }
        if (localKandian210Msg0xeeInfo.notifyInfos == null) {
          localKandian210Msg0xeeInfo.notifyInfos = new ArrayList();
        }
        localObject1 = ((submsgtype0xee.MsgBody)localObject1).rpt_msg_notify_list.get().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label1616;
        }
        localNotifyInfo1 = (submsgtype0xee.NotifyInfo)((Iterator)localObject1).next();
        localNotifyInfo = new Kandian210Msg0xeeInfo.NotifyInfo();
        if ((localNotifyInfo1.msg_style_sheet.has()) && (localNotifyInfo1.msg_style_sheet.get() != null))
        {
          paramArrayOfByte = (submsgtype0xee.StyleSheet)localNotifyInfo1.msg_style_sheet.get();
          if (paramArrayOfByte.enum_style_type.has())
          {
            i = paramArrayOfByte.enum_style_type.get();
            localNotifyInfo.styleType = i;
            if (!paramArrayOfByte.uint32_ark_enable.has()) {
              break label1098;
            }
            i = paramArrayOfByte.uint32_ark_enable.get();
            localNotifyInfo.arkEnable = i;
            localNotifyInfo.sceneType = paramArrayOfByte.uint64_scene.get();
            localNotifyInfo.duration = paramArrayOfByte.uint32_duration.get();
            localNotifyInfo.endTime = paramArrayOfByte.uint64_end_time.get();
          }
        }
        else
        {
          if (!localNotifyInfo1.enum_apppush_type.has()) {
            break label1103;
          }
          i = localNotifyInfo1.enum_apppush_type.get();
          localNotifyInfo.appPushType = i;
          if ((localNotifyInfo1.msg_ordinary_push_info.has()) && (localNotifyInfo1.msg_ordinary_push_info.get() != null))
          {
            localNotifyInfo.ordinaryPushInfo = new Kandian210Msg0xeeInfo.OrdinaryPushInfo();
            paramArrayOfByte = (submsgtype0xee.OrdinaryPushInfo)localNotifyInfo1.msg_ordinary_push_info.get();
            if ((paramArrayOfByte.msg_label_control_info.has()) && (paramArrayOfByte.msg_label_control_info.get() != null))
            {
              localNotifyInfo.ordinaryPushInfo.orangeControlInfo = new Kandian210Msg0xeeInfo.OrangeControlInfo();
              localObject2 = (submsgtype0xee.OrangeControlInfo)paramArrayOfByte.msg_label_control_info.get();
              localObject3 = localNotifyInfo.ordinaryPushInfo.orangeControlInfo;
              if (!((submsgtype0xee.OrangeControlInfo)localObject2).bytes_color.has()) {
                break label1108;
              }
              paramArrayOfByte = ((submsgtype0xee.OrangeControlInfo)localObject2).bytes_color.get().toStringUtf8();
              ((Kandian210Msg0xeeInfo.OrangeControlInfo)localObject3).color = paramArrayOfByte;
              ((Kandian210Msg0xeeInfo.OrangeControlInfo)localObject3).fontSize = ((submsgtype0xee.OrangeControlInfo)localObject2).uint32_font_size.get();
            }
          }
          if ((localNotifyInfo1.msg_social_push_info.has()) && (localNotifyInfo1.msg_social_push_info.get() != null))
          {
            localNotifyInfo.socialPushInfo = new Kandian210Msg0xeeInfo.SocialPushInfo();
            localObject2 = (submsgtype0xee.SocialPushInfo)localNotifyInfo1.msg_social_push_info.get();
            localNotifyInfo.socialPushInfo.feedsId = ((submsgtype0xee.SocialPushInfo)localObject2).uint64_feeds_id.get();
            localObject3 = localNotifyInfo.socialPushInfo;
            if (!((submsgtype0xee.SocialPushInfo)localObject2).string_biu_reason.has()) {
              break label1113;
            }
            paramArrayOfByte = ((submsgtype0xee.SocialPushInfo)localObject2).string_biu_reason.get().toStringUtf8();
            ((Kandian210Msg0xeeInfo.SocialPushInfo)localObject3).biuReason = paramArrayOfByte;
            localObject3 = localNotifyInfo.socialPushInfo;
            if (!((submsgtype0xee.SocialPushInfo)localObject2).string_biu_comment.has()) {
              break label1118;
            }
            paramArrayOfByte = ((submsgtype0xee.SocialPushInfo)localObject2).string_biu_comment.get().toStringUtf8();
            ((Kandian210Msg0xeeInfo.SocialPushInfo)localObject3).biuComment = paramArrayOfByte;
          }
          if ((localNotifyInfo1.msg_ugc_push_info.has()) && (localNotifyInfo1.msg_ugc_push_info.get() != null))
          {
            localNotifyInfo.ugcPushInfo = new Kandian210Msg0xeeInfo.UGCPushInfo();
            paramArrayOfByte = (submsgtype0xee.UGCPushInfo)localNotifyInfo1.msg_ugc_push_info.get();
            localNotifyInfo.ugcPushInfo.feedsId = paramArrayOfByte.uint64_feeds_id.get();
            localObject2 = localNotifyInfo.ugcPushInfo;
            if (!paramArrayOfByte.string_ugc_reason.has()) {
              break label1123;
            }
            paramArrayOfByte = paramArrayOfByte.string_ugc_reason.get().toStringUtf8();
            ((Kandian210Msg0xeeInfo.UGCPushInfo)localObject2).ugcReason = paramArrayOfByte;
          }
          if ((!localNotifyInfo1.msg_context_info.has()) || (localNotifyInfo1.msg_context_info.get() == null)) {
            break label1203;
          }
          localObject2 = (submsgtype0xee.ContextInfo)localNotifyInfo1.msg_context_info.get();
          localNotifyInfo.contextId = ((submsgtype0xee.ContextInfo)localObject2).uint64_id.get();
          if (!((submsgtype0xee.ContextInfo)localObject2).bytes_brief.has()) {
            break label1128;
          }
          paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).bytes_brief.get().toStringUtf8();
          localNotifyInfo.contextBrief = paramArrayOfByte;
          if (!((submsgtype0xee.ContextInfo)localObject2).bytes_jump_url.has()) {
            break label1133;
          }
          paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).bytes_jump_url.get().toStringUtf8();
          localNotifyInfo.pictureJumpURL = paramArrayOfByte;
          if (!((submsgtype0xee.ContextInfo)localObject2).bytes_orange_word.has()) {
            break label1138;
          }
          paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).bytes_orange_word.get().toStringUtf8();
          localNotifyInfo.orangeWord = paramArrayOfByte;
          if (!((submsgtype0xee.ContextInfo)localObject2).bytes_title.has()) {
            break label1143;
          }
          paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).bytes_title.get().toStringUtf8();
          localNotifyInfo.contextTitle = paramArrayOfByte;
          if (localNotifyInfo.picturesURLList == null) {
            localNotifyInfo.picturesURLList = new ArrayList();
          }
          if ((!((submsgtype0xee.ContextInfo)localObject2).rpt_msg_pic_list.has()) || (((submsgtype0xee.ContextInfo)localObject2).rpt_msg_pic_list.get() == null)) {
            break label1148;
          }
          paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).rpt_msg_pic_list.get().iterator();
          if (!paramArrayOfByte.hasNext()) {
            break label1148;
          }
          Object localObject3 = (submsgtype0xee.PictureInfo)paramArrayOfByte.next();
          if ((!((submsgtype0xee.PictureInfo)localObject3).has()) || (((submsgtype0xee.PictureInfo)localObject3).get() == null) || (!((submsgtype0xee.PictureInfo)((submsgtype0xee.PictureInfo)localObject3).get()).bytes_url.has()) || (((submsgtype0xee.PictureInfo)((submsgtype0xee.PictureInfo)localObject3).get()).bytes_url.get() == null)) {
            continue;
          }
          localNotifyInfo.picturesURLList.add(((submsgtype0xee.PictureInfo)((submsgtype0xee.PictureInfo)localObject3).get()).bytes_url.get().toStringUtf8());
          continue;
        }
        i = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Kandian210Msg0xeeInfo", 2, "receive push 0xee, parse msgBody err,", paramArrayOfByte);
        }
        return null;
      }
      continue;
      label1098:
      int i = 0;
      continue;
      label1103:
      i = -1;
      continue;
      label1108:
      paramArrayOfByte = null;
      continue;
      label1113:
      paramArrayOfByte = null;
      continue;
      label1118:
      paramArrayOfByte = null;
      continue;
      label1123:
      paramArrayOfByte = null;
      continue;
      label1128:
      paramArrayOfByte = null;
      continue;
      label1133:
      paramArrayOfByte = null;
      continue;
      label1138:
      paramArrayOfByte = null;
      continue;
      label1143:
      paramArrayOfByte = null;
      continue;
      label1148:
      if (((submsgtype0xee.ContextInfo)localObject2).enum_context_type.has())
      {
        i = ((submsgtype0xee.ContextInfo)localObject2).enum_context_type.get();
        localNotifyInfo.contextType = i;
        if (!((submsgtype0xee.ContextInfo)localObject2).bytes_video_brief.has()) {
          break label1591;
        }
        paramArrayOfByte = ((submsgtype0xee.ContextInfo)localObject2).bytes_video_brief.get().toStringUtf8();
        localNotifyInfo.videoBrief = paramArrayOfByte;
        if ((localNotifyInfo1.msg_account_info.has()) && (localNotifyInfo1.msg_account_info.get() != null))
        {
          localObject2 = (submsgtype0xee.AccountInfo)localNotifyInfo1.msg_account_info.get();
          localNotifyInfo.uin = ((submsgtype0xee.AccountInfo)localObject2).uint64_id.get();
          if (!((submsgtype0xee.AccountInfo)localObject2).bytes_name.has()) {
            break label1596;
          }
          paramArrayOfByte = ((submsgtype0xee.AccountInfo)localObject2).bytes_name.get().toStringUtf8();
          localNotifyInfo.username = paramArrayOfByte;
          if (!((submsgtype0xee.AccountInfo)localObject2).bytes_icon_url.has()) {
            break label1601;
          }
          paramArrayOfByte = ((submsgtype0xee.AccountInfo)localObject2).bytes_icon_url.get().toStringUtf8();
          localNotifyInfo.userIconURL = paramArrayOfByte;
        }
        if ((localNotifyInfo1.msg_extra_info.has()) && (localNotifyInfo1.msg_extra_info.get() != null))
        {
          localObject2 = (submsgtype0xee.ExtraInfo)localNotifyInfo1.msg_extra_info.get();
          if (!((submsgtype0xee.ExtraInfo)localObject2).bytes_ext.has()) {
            break label1606;
          }
          paramArrayOfByte = ((submsgtype0xee.ExtraInfo)localObject2).bytes_ext.get().toStringUtf8();
          localNotifyInfo.extInfo = paramArrayOfByte;
          if (!((submsgtype0xee.ExtraInfo)localObject2).bytes_cookie.has()) {
            break label1611;
          }
          paramArrayOfByte = ((submsgtype0xee.ExtraInfo)localObject2).bytes_cookie.get().toStringUtf8();
          localNotifyInfo.extCookie = paramArrayOfByte;
          boolean bool = TextUtils.isEmpty(localNotifyInfo.extCookie);
          if (bool) {}
        }
      }
      try
      {
        label1168:
        label1197:
        label1203:
        label1274:
        localNotifyInfo.folderStatus = Long.valueOf(new JSONObject(localNotifyInfo.extCookie).getString("folder_status")).longValue();
        label1303:
        label1367:
        label1396:
        if (localNotifyInfo1.msg_statistics_info.has())
        {
          paramArrayOfByte = (submsgtype0xee.StatisticsInfo)localNotifyInfo1.msg_statistics_info.get();
          localNotifyInfo.strategyID = paramArrayOfByte.uint64_strategy_id.get();
          localNotifyInfo.algorithmID = paramArrayOfByte.uint64_algorithm_id.get();
          localNotifyInfo.folderStatus = paramArrayOfByte.uint64_folder_status.get();
        }
        label1444:
        if ((localNotifyInfo1.msg_control_info.has()) && (localNotifyInfo1.msg_control_info.get() != null))
        {
          paramArrayOfByte = (submsgtype0xee.ControlInfo)localNotifyInfo1.msg_control_info.get();
          localNotifyInfo.commentLength = paramArrayOfByte.uint32_comment_length.get();
          localNotifyInfo.showLine = paramArrayOfByte.uint32_show_line.get();
          localNotifyInfo.fontSize = paramArrayOfByte.uint32_font_size.get();
        }
        localKandian210Msg0xeeInfo.notifyInfos.add(localNotifyInfo);
        continue;
        i = 0;
        break label1168;
        label1591:
        paramArrayOfByte = null;
        break label1197;
        label1596:
        paramArrayOfByte = null;
        break label1274;
        label1601:
        paramArrayOfByte = null;
        break label1303;
        label1606:
        paramArrayOfByte = null;
        break label1367;
        label1611:
        paramArrayOfByte = null;
        break label1396;
        label1616:
        return localKandian210Msg0xeeInfo;
      }
      catch (Exception paramArrayOfByte)
      {
        break label1444;
      }
    }
    label1622:
    return null;
  }
  
  public static Kandian210Msg0xeeInfo getKandian210Msg0xeeInfoFromSp(QQAppInterface paramQQAppInterface)
  {
    return (Kandian210Msg0xeeInfo)obz.a(paramQQAppInterface, "kandian_push_0x210_ee", true);
  }
  
  public static void removeKandian210Msg0xeeInfoFromSp()
  {
    obz.a("kandian_push_0x210_ee", true);
  }
  
  public static void writeToSpAsync(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    obz.a("kandian_push_0x210_ee", paramKandian210Msg0xeeInfo, true);
  }
  
  public boolean isArticleAppInPush()
  {
    return (this.bid == 2000002) || (this.bid == 1000001);
  }
  
  public boolean isVideoAppInPush()
  {
    return this.bid == 2000001;
  }
  
  public String toString()
  {
    return "Kandian210Msg0xeeInfo{msgId='" + this.msgId + '\'' + ", msgSeq=" + this.msgSeq + ", bid=" + this.bid + ", notifyInfos=" + this.notifyInfos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo
 * JD-Core Version:    0.7.0.1
 */