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
import org.json.JSONObject;
import prd;
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
  public static final String KANDIAN_0X210_EE = "kandian_push_0x210_ee";
  public static final String TAG = "Kandian210Msg0xeeInfo";
  public int bid;
  public String msgId;
  public long msgSeq;
  public ArrayList<Kandian210Msg0xeeInfo.NotifyInfo> notifyInfos;
  
  private static void a(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    int j = 0;
    if ((paramNotifyInfo.msg_style_sheet.has()) && (paramNotifyInfo.msg_style_sheet.get() != null))
    {
      paramNotifyInfo = (submsgtype0xee.StyleSheet)paramNotifyInfo.msg_style_sheet.get();
      if (!paramNotifyInfo.enum_style_type.has()) {
        break label115;
      }
    }
    label115:
    for (int i = paramNotifyInfo.enum_style_type.get();; i = 0)
    {
      paramNotifyInfo1.styleType = i;
      i = j;
      if (paramNotifyInfo.uint32_ark_enable.has()) {
        i = paramNotifyInfo.uint32_ark_enable.get();
      }
      paramNotifyInfo1.arkEnable = i;
      paramNotifyInfo1.sceneType = paramNotifyInfo.uint64_scene.get();
      paramNotifyInfo1.duration = paramNotifyInfo.uint32_duration.get();
      paramNotifyInfo1.endTime = paramNotifyInfo.uint64_end_time.get();
      return;
    }
  }
  
  private static void b(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    submsgtype0xee.OrangeControlInfo localOrangeControlInfo;
    if ((paramNotifyInfo.msg_ordinary_push_info.has()) && (paramNotifyInfo.msg_ordinary_push_info.get() != null))
    {
      paramNotifyInfo1.ordinaryPushInfo = new Kandian210Msg0xeeInfo.OrdinaryPushInfo();
      paramNotifyInfo = (submsgtype0xee.OrdinaryPushInfo)paramNotifyInfo.msg_ordinary_push_info.get();
      if ((paramNotifyInfo.msg_label_control_info.has()) && (paramNotifyInfo.msg_label_control_info.get() != null))
      {
        paramNotifyInfo1.ordinaryPushInfo.orangeControlInfo = new Kandian210Msg0xeeInfo.OrangeControlInfo();
        localOrangeControlInfo = (submsgtype0xee.OrangeControlInfo)paramNotifyInfo.msg_label_control_info.get();
        paramNotifyInfo1 = paramNotifyInfo1.ordinaryPushInfo.orangeControlInfo;
        if (!localOrangeControlInfo.bytes_color.has()) {
          break label133;
        }
      }
    }
    label133:
    for (paramNotifyInfo = localOrangeControlInfo.bytes_color.get().toStringUtf8();; paramNotifyInfo = null)
    {
      paramNotifyInfo1.color = paramNotifyInfo;
      paramNotifyInfo1.fontSize = localOrangeControlInfo.uint32_font_size.get();
      return;
    }
  }
  
  private static void c(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    Object localObject = null;
    submsgtype0xee.SocialPushInfo localSocialPushInfo;
    Kandian210Msg0xeeInfo.SocialPushInfo localSocialPushInfo1;
    if ((paramNotifyInfo.msg_social_push_info.has()) && (paramNotifyInfo.msg_social_push_info.get() != null))
    {
      paramNotifyInfo1.socialPushInfo = new Kandian210Msg0xeeInfo.SocialPushInfo();
      localSocialPushInfo = (submsgtype0xee.SocialPushInfo)paramNotifyInfo.msg_social_push_info.get();
      paramNotifyInfo1.socialPushInfo.feedsId = localSocialPushInfo.uint64_feeds_id.get();
      localSocialPushInfo1 = paramNotifyInfo1.socialPushInfo;
      if (!localSocialPushInfo.string_biu_reason.has()) {
        break label125;
      }
    }
    label125:
    for (paramNotifyInfo = localSocialPushInfo.string_biu_reason.get().toStringUtf8();; paramNotifyInfo = null)
    {
      localSocialPushInfo1.biuReason = paramNotifyInfo;
      paramNotifyInfo1 = paramNotifyInfo1.socialPushInfo;
      paramNotifyInfo = localObject;
      if (localSocialPushInfo.string_biu_comment.has()) {
        paramNotifyInfo = localSocialPushInfo.string_biu_comment.get().toStringUtf8();
      }
      paramNotifyInfo1.biuComment = paramNotifyInfo;
      return;
    }
  }
  
  private static void d(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_ugc_push_info.has()) && (paramNotifyInfo.msg_ugc_push_info.get() != null))
    {
      paramNotifyInfo1.ugcPushInfo = new Kandian210Msg0xeeInfo.UGCPushInfo();
      paramNotifyInfo = (submsgtype0xee.UGCPushInfo)paramNotifyInfo.msg_ugc_push_info.get();
      paramNotifyInfo1.ugcPushInfo.feedsId = paramNotifyInfo.uint64_feeds_id.get();
      paramNotifyInfo1 = paramNotifyInfo1.ugcPushInfo;
      if (!paramNotifyInfo.string_ugc_reason.has()) {
        break label88;
      }
    }
    label88:
    for (paramNotifyInfo = paramNotifyInfo.string_ugc_reason.get().toStringUtf8();; paramNotifyInfo = null)
    {
      paramNotifyInfo1.ugcReason = paramNotifyInfo;
      return;
    }
  }
  
  public static Kandian210Msg0xeeInfo decodeFromPbBytes(byte[] paramArrayOfByte)
  {
    Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = new Kandian210Msg0xeeInfo();
    for (;;)
    {
      try
      {
        Object localObject = new submsgtype0xee.MsgBody();
        ((submsgtype0xee.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localKandian210Msg0xeeInfo.bid = ((submsgtype0xee.MsgBody)localObject).uint32_bid.get();
        localKandian210Msg0xeeInfo.msgSeq = ((submsgtype0xee.MsgBody)localObject).uint64_seq.get();
        if (QLog.isColorLevel()) {
          QLog.d("Kandian210Msg0xeeInfo", 2, "receive push 0xee, bid = " + localKandian210Msg0xeeInfo.bid + " msgSeq=" + localKandian210Msg0xeeInfo.msgSeq);
        }
        if ((((submsgtype0xee.MsgBody)localObject).bytes_id.has()) && (((submsgtype0xee.MsgBody)localObject).bytes_id.get() != null)) {
          localKandian210Msg0xeeInfo.msgId = ((submsgtype0xee.MsgBody)localObject).bytes_id.get().toStringUtf8();
        }
        if ((!((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.has()) || (((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.get() == null)) {
          break label318;
        }
        if (localKandian210Msg0xeeInfo.notifyInfos == null) {
          localKandian210Msg0xeeInfo.notifyInfos = new ArrayList();
        }
        paramArrayOfByte = ((submsgtype0xee.MsgBody)localObject).rpt_msg_notify_list.get().iterator();
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject = (submsgtype0xee.NotifyInfo)paramArrayOfByte.next();
        Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo = new Kandian210Msg0xeeInfo.NotifyInfo();
        a((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
        int i;
        if (((submsgtype0xee.NotifyInfo)localObject).enum_apppush_type.has())
        {
          i = ((submsgtype0xee.NotifyInfo)localObject).enum_apppush_type.get();
          localNotifyInfo.appPushType = i;
          b((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          c((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          d((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          e((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          f((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          g((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          h((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          i((submsgtype0xee.NotifyInfo)localObject, localNotifyInfo);
          localKandian210Msg0xeeInfo.notifyInfos.add(localNotifyInfo);
        }
        else
        {
          i = -1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.w("Kandian210Msg0xeeInfo", 1, "receive push 0xee, parse msgBody err,", paramArrayOfByte);
        return null;
      }
    }
    return localKandian210Msg0xeeInfo;
    label318:
    return null;
  }
  
  private static void e(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    Object localObject = null;
    submsgtype0xee.ContextInfo localContextInfo;
    if ((paramNotifyInfo.msg_context_info.has()) && (paramNotifyInfo.msg_context_info.get() != null))
    {
      localContextInfo = (submsgtype0xee.ContextInfo)paramNotifyInfo.msg_context_info.get();
      paramNotifyInfo1.contextId = localContextInfo.uint64_id.get();
      if (localContextInfo.bytes_brief.has())
      {
        paramNotifyInfo = localContextInfo.bytes_brief.get().toStringUtf8();
        paramNotifyInfo1.contextBrief = paramNotifyInfo;
        if (!localContextInfo.bytes_jump_url.has()) {
          break label315;
        }
        paramNotifyInfo = localContextInfo.bytes_jump_url.get().toStringUtf8();
        label97:
        paramNotifyInfo1.pictureJumpURL = paramNotifyInfo;
        if (!localContextInfo.bytes_orange_word.has()) {
          break label320;
        }
        paramNotifyInfo = localContextInfo.bytes_orange_word.get().toStringUtf8();
        label125:
        paramNotifyInfo1.orangeWord = paramNotifyInfo;
        if (!localContextInfo.bytes_title.has()) {
          break label325;
        }
      }
      label315:
      label320:
      label325:
      for (paramNotifyInfo = localContextInfo.bytes_title.get().toStringUtf8();; paramNotifyInfo = null)
      {
        paramNotifyInfo1.contextTitle = paramNotifyInfo;
        if (paramNotifyInfo1.picturesURLList == null) {
          paramNotifyInfo1.picturesURLList = new ArrayList();
        }
        if ((!localContextInfo.rpt_msg_pic_list.has()) || (localContextInfo.rpt_msg_pic_list.get() == null)) {
          break label330;
        }
        paramNotifyInfo = localContextInfo.rpt_msg_pic_list.get().iterator();
        while (paramNotifyInfo.hasNext())
        {
          submsgtype0xee.PictureInfo localPictureInfo = (submsgtype0xee.PictureInfo)paramNotifyInfo.next();
          if ((localPictureInfo.has()) && (localPictureInfo.get() != null) && (((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.has()) && (((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.get() != null)) {
            paramNotifyInfo1.picturesURLList.add(((submsgtype0xee.PictureInfo)localPictureInfo.get()).bytes_url.get().toStringUtf8());
          }
        }
        paramNotifyInfo = null;
        break;
        paramNotifyInfo = null;
        break label97;
        paramNotifyInfo = null;
        break label125;
      }
      label330:
      if (!localContextInfo.enum_context_type.has()) {
        break label386;
      }
    }
    label386:
    for (int i = localContextInfo.enum_context_type.get();; i = 0)
    {
      paramNotifyInfo1.contextType = i;
      paramNotifyInfo = localObject;
      if (localContextInfo.bytes_video_brief.has()) {
        paramNotifyInfo = localContextInfo.bytes_video_brief.get().toStringUtf8();
      }
      paramNotifyInfo1.videoBrief = paramNotifyInfo;
      return;
    }
  }
  
  private static void f(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    Object localObject = null;
    submsgtype0xee.AccountInfo localAccountInfo;
    if ((paramNotifyInfo.msg_account_info.has()) && (paramNotifyInfo.msg_account_info.get() != null))
    {
      localAccountInfo = (submsgtype0xee.AccountInfo)paramNotifyInfo.msg_account_info.get();
      paramNotifyInfo1.uin = localAccountInfo.uint64_id.get();
      if (!localAccountInfo.bytes_name.has()) {
        break label99;
      }
    }
    label99:
    for (paramNotifyInfo = localAccountInfo.bytes_name.get().toStringUtf8();; paramNotifyInfo = null)
    {
      paramNotifyInfo1.username = paramNotifyInfo;
      paramNotifyInfo = localObject;
      if (localAccountInfo.bytes_icon_url.has()) {
        paramNotifyInfo = localAccountInfo.bytes_icon_url.get().toStringUtf8();
      }
      paramNotifyInfo1.userIconURL = paramNotifyInfo;
      return;
    }
  }
  
  private static void g(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    Object localObject = null;
    submsgtype0xee.ExtraInfo localExtraInfo;
    if ((paramNotifyInfo.msg_extra_info.has()) && (paramNotifyInfo.msg_extra_info.get() != null))
    {
      localExtraInfo = (submsgtype0xee.ExtraInfo)paramNotifyInfo.msg_extra_info.get();
      if (!localExtraInfo.bytes_ext.has()) {
        break label125;
      }
    }
    for (paramNotifyInfo = localExtraInfo.bytes_ext.get().toStringUtf8();; paramNotifyInfo = null)
    {
      paramNotifyInfo1.extInfo = paramNotifyInfo;
      paramNotifyInfo = localObject;
      if (localExtraInfo.bytes_cookie.has()) {
        paramNotifyInfo = localExtraInfo.bytes_cookie.get().toStringUtf8();
      }
      paramNotifyInfo1.extCookie = paramNotifyInfo;
      if (!TextUtils.isEmpty(paramNotifyInfo1.extCookie)) {}
      try
      {
        paramNotifyInfo1.folderStatus = Long.valueOf(new JSONObject(paramNotifyInfo1.extCookie).getString("folder_status")).longValue();
        return;
      }
      catch (Exception paramNotifyInfo)
      {
        label125:
        QLog.d("Kandian210Msg0xeeInfo", 1, "handleExtraInfo error!  msg=" + paramNotifyInfo);
      }
    }
  }
  
  public static Kandian210Msg0xeeInfo getKandian210Msg0xeeInfoFromSp(QQAppInterface paramQQAppInterface)
  {
    return (Kandian210Msg0xeeInfo)prd.a(paramQQAppInterface, "kandian_push_0x210_ee", true);
  }
  
  private static void h(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if (paramNotifyInfo.msg_statistics_info.has())
    {
      paramNotifyInfo = (submsgtype0xee.StatisticsInfo)paramNotifyInfo.msg_statistics_info.get();
      paramNotifyInfo1.strategyID = paramNotifyInfo.uint64_strategy_id.get();
      paramNotifyInfo1.algorithmID = paramNotifyInfo.uint64_algorithm_id.get();
      paramNotifyInfo1.folderStatus = paramNotifyInfo.uint64_folder_status.get();
    }
  }
  
  private static void i(submsgtype0xee.NotifyInfo paramNotifyInfo, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo1)
  {
    if ((paramNotifyInfo.msg_control_info.has()) && (paramNotifyInfo.msg_control_info.get() != null))
    {
      paramNotifyInfo = (submsgtype0xee.ControlInfo)paramNotifyInfo.msg_control_info.get();
      paramNotifyInfo1.commentLength = paramNotifyInfo.uint32_comment_length.get();
      paramNotifyInfo1.showLine = paramNotifyInfo.uint32_show_line.get();
      paramNotifyInfo1.fontSize = paramNotifyInfo.uint32_font_size.get();
    }
  }
  
  public static void removeKandian210Msg0xeeInfoFromSp()
  {
    prd.a("kandian_push_0x210_ee", true);
  }
  
  public static void writeToSpAsync(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    prd.a("kandian_push_0x210_ee", paramKandian210Msg0xeeInfo, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo
 * JD-Core Version:    0.7.0.1
 */