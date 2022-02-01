package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.LogUtil;

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int a = BaseChatItemLayout.k + BaseChatItemLayout.n;
  private static final int w = BaseChatItemLayout.l + BaseChatItemLayout.o;
  private boolean x = true;
  private View.OnClickListener y = new VideoItemBuilder.1(this);
  
  public VideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramInt <= 0)
    {
      paramTextView.setCompoundDrawables(null, null, null, null);
      return;
    }
    Resources localResources = this.e.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int j = localDrawable.getIntrinsicWidth();
    int i = localDrawable.getIntrinsicHeight();
    paramInt = this.e.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = j;
    }
    else
    {
      int k = localResources.getDimensionPixelSize(2131298365);
      int m = localResources.getDimensionPixelSize(2131298366);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      j = j * this.f.r / paramInt + m;
      i = i * this.f.r / paramInt + m;
      paramInt = j;
    }
    localDrawable.setBounds(0, 0, paramInt, i);
    paramTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.q);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qqVideo_group, avType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], isVideo[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.w("ChatItemBuilder", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 2)
    {
      localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(paramInt));
      ((Map)localObject).put("from", "itemBuilder");
      GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramSessionInfo.a, paramSessionInfo.b, (Map)localObject);
      long l = Long.valueOf(paramSessionInfo.b).longValue();
      if (paramSessionInfo.a == 3000)
      {
        if (paramQQAppInterface.getAVNotifyCenter().g() != l) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      else if ((paramSessionInfo.a == 1) && (!paramQQAppInterface.getAVNotifyCenter().f(1, l)))
      {
        if (paramInt == 10)
        {
          if (paramQQAppInterface.getAVNotifyCenter().g() == 0L)
          {
            paramContext = paramQQAppInterface.getAVNotifyCenter().a(l, 10);
            if ((paramContext == null) || (paramContext.c <= 0)) {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
            }
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      }
    }
    else
    {
      boolean bool = QAVGroupConfig.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.b);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MultiAVType", paramInt);
      ((Bundle)localObject).putBoolean("enableInvite", bool);
      ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.a, paramSessionInfo.b, true, true, null, (Bundle)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = QQAudioHelper.d();
    int j = paramSessionInfo.a;
    String str = paramSessionInfo.b;
    long l2 = UinUtils.b(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showGroupQavActionSheet, avType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isVideo[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], msgSelfUin[");
    localStringBuilder.append(LogUtil.getSafePrintUin(paramString1));
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(j);
    localStringBuilder.append("], groupId[");
    localStringBuilder.append(str);
    localStringBuilder.append("], curFriendNick[");
    localStringBuilder.append(paramSessionInfo.e);
    localStringBuilder.append("], troopUin[");
    localStringBuilder.append(paramSessionInfo.c);
    localStringBuilder.append("], fromWhere[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], isVideoActionSheetShown[");
    localStringBuilder.append(VideoActionSheet.a());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w("ChatItemBuilder", 1, localStringBuilder.toString());
    int i;
    if (10 == paramInt)
    {
      paramString1 = paramQQAppInterface.getAVNotifyCenter().a(l2, paramInt);
      boolean bool;
      if ((paramString1 != null) && (paramString1.c > 0))
      {
        i = 0;
        bool = false;
      }
      else
      {
        paramString1 = QAVGroupConfig.b(paramQQAppInterface, str);
        bool = paramString1.getBoolean("forceDisableInviteBox");
        i = paramString1.getInt("errId", 2131893397);
      }
      if (bool)
      {
        DialogUtil.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131893167, 2131917882, new VideoItemBuilder.2(), null).show();
        return;
      }
    }
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.a, paramSessionInfo.b)) {
      return;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramSessionInfo.a, paramSessionInfo.b, paramBoolean)) {
      return;
    }
    if (QQAudioHelper.b(19) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      QQAudioHelper.a(HardCodeUtil.a(2131913496));
    }
    if ((!paramQQAppInterface.getAVNotifyCenter().a(l1, str)) && (i == 0))
    {
      paramString1 = paramQQAppInterface.getAVNotifyCenter().f(UinUtils.b(str));
      if ((paramString1 != null) && (paramString1.d == paramInt))
      {
        if ((paramString1 != null) && (paramString1.d == 2) && (paramString1.f == 2) && (paramString1.g == 4)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean, paramString2);
        return;
      }
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.e, paramBoolean, paramString2);
      return;
    }
    paramSessionInfo = new Bundle();
    paramSessionInfo.putInt("MultiAVType", UITools.a(j));
    if (paramBoolean) {
      paramSessionInfo.putBoolean("isVideo", true);
    }
    if (j == 1) {
      paramSessionInfo.putBoolean("enableInvite", QAVGroupConfig.a("showGroupQavActionSheet", paramQQAppInterface, str));
    }
    paramSessionInfo.putString("Fromwhere", paramString2);
    ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForVideo paramMessageForVideo)
  {
    if (VcSystemInfo.isSupportSharpAudio())
    {
      if (VideoActionSheet.a()) {
        return;
      }
      int i;
      if (paramMessageForVideo.type == 13) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = paramMessageForVideo.istroop;
        if ((i == 1) || (i == 3000)) {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo, paramMessageForVideo.selfuin, "");
        }
      }
      else
      {
        c(paramQQAppInterface, paramSessionInfo, paramMessageForVideo.isVideo, paramMessageForVideo.type);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
        {
          paramContext = new StringBuilder();
          paramContext.append("[qqVideo_double] content: ");
          paramContext.append(paramMessageForVideo.getDebugInfo());
          QLog.d("ChatItemBuilder", 0, paramContext.toString());
        }
        if (paramMessageForVideo.isVideo)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    AIOUtils.q = true;
    if (VcSystemInfo.isSupportSharpAudio())
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.a != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    try
    {
      l = Long.parseLong(paramSessionInfo.b);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label45:
      int i;
      Object localObject;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      break label45;
    }
    l = 0L;
    i = UITools.b(paramSessionInfo.a);
    l = paramQQAppInterface.getAVNotifyCenter().c(i, l);
    localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    bool1 = ((TroopGagMgr)localObject).a(paramSessionInfo.b, paramQQAppInterface.getCurrentAccountUin());
    bool2 = ((TroopGagMgr)localObject).c(paramSessionInfo.b);
    bool3 = ((TroopGagMgr)localObject).d(paramSessionInfo.b);
    localObject = ((TroopGagMgr)localObject).b(paramSessionInfo.b);
    if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((TroopGagInfo)localObject).b > 0L))))
    {
      QQToast.makeText(paramQQAppInterface.getApp(), HardCodeUtil.a(2131913495), 0).show(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo);
    return;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo);
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13) {
      if (i == 3000) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
      } else if (i == 1) {
        if (paramMessageForVideo.extInt == 10)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        }
        else
        {
          String str = paramSessionInfo.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopUtils.a(paramQQAppInterface, paramSessionInfo.b));
          ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, str, localStringBuilder.toString(), "0", "");
        }
      }
    }
    if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
    }
    if (paramMessageForVideo.type == 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    String str1;
    String str2;
    if (!paramBoolean)
    {
      str1 = "Two_call";
      str2 = "Two_call_launch";
    }
    else
    {
      str1 = "Two_video_call";
      str2 = "Two_video_call_launch";
    }
    int i = paramSessionInfo.a;
    if (i != 0)
    {
      if (i == 1004) {
        break label98;
      }
      if (i == 1006) {
        break label91;
      }
      if (i == 1000) {
        break label84;
      }
      if (i == 1001) {}
    }
    else
    {
      paramSessionInfo = "0";
      break label105;
    }
    paramSessionInfo = "4";
    break label88;
    label84:
    paramSessionInfo = "2";
    for (;;)
    {
      label88:
      break;
      label91:
      paramSessionInfo = "3";
      continue;
      label98:
      paramSessionInfo = "1";
    }
    label105:
    ReportController.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
    if (paramInt == 2) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
    } else if (paramInt == 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
    }
    if (paramBoolean)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  private void b(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    if (paramMessageForVideo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->message is null");
      }
      return;
    }
    if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null))
    {
      if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
      {
        if (-2016 == paramMessageForVideo.msgtype) {
          localObject1 = HardCodeUtil.a(2131913489);
        } else {
          localObject1 = "";
        }
      }
      else {
        localObject1 = ContactUtils.a(this.d, paramMessageForVideo.senderuin, 0);
      }
      Object localObject2 = localObject1;
      int i;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = paramView.getResources();
        if (paramMessageForVideo.isVideo) {
          i = 2131917350;
        } else {
          i = 2131917336;
        }
        ((StringBuilder)localObject2).append(((Resources)localObject1).getString(i));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramMessageForVideo.text);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131917877)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(a(paramMessageForVideo, paramContext, paramView));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131917866)))
      {
        paramContext = paramContext.getResources();
        if (paramMessageForVideo.isVideo) {
          i = 2131917887;
        } else {
          i = 2131887107;
        }
        localObject1 = paramContext.getString(i);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131893722)))
      {
        localObject1 = paramContext.getResources().getString(2131916236);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131893721)))
      {
        localObject1 = paramContext.getResources().getString(2131915705);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131893119)))
      {
        localObject1 = paramContext.getResources().getString(2131916236);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131893118)))
      {
        localObject1 = paramContext.getResources().getString(2131915705);
      }
      paramView.setContentDescription(((String)localObject1).replace(HardCodeUtil.a(2131913497), HardCodeUtil.a(2131913488)));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->uin is null");
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("qqVideoEx, isVideo[");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append("], closeType[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("]");
    QLog.w("ChatItemBuilder", 1, ((StringBuilder)localObject1).toString());
    b(paramQQAppInterface, paramSessionInfo, paramBoolean, paramInt);
    int i = paramSessionInfo.a;
    String str = paramSessionInfo.e;
    Object localObject2;
    Object localObject3;
    if (i == 1006)
    {
      localObject1 = paramSessionInfo.b;
      localObject2 = null;
      localObject3 = localObject1;
    }
    else
    {
      localObject1 = paramSessionInfo.b;
      localObject3 = null;
      localObject2 = localObject1;
    }
    if (paramBoolean) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramQQAppInterface.getApp(), paramInt, i, localObject2)) {
      return;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramQQAppInterface.getApp(), i, localObject2, str, localObject3, paramBoolean ^ true, paramSessionInfo.c, true, true, null, "from_internal");
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = (VideoItemBuilder.Holder)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.e.getResources();
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.e);
      paramViewHolder.setId(2131430581);
      paramViewHolder.setTextColor(localResources.getColorStateList(2131168016));
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131296688));
      paramViewHolder.setGravity(16);
      ((VideoItemBuilder.Holder)localObject).a = paramViewHolder;
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = (MessageForVideo)paramChatMessage;
    boolean bool;
    if (paramView.isFromServer()) {
      bool = TextUtils.equals(paramView.selfuin, paramView.senderuin);
    } else {
      bool = false;
    }
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal(), bool);
    a(((VideoItemBuilder.Holder)localObject).a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    ((VideoItemBuilder.Holder)localObject).a.setTextColor(localResources.getColor(i));
    ((VideoItemBuilder.Holder)localObject).a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.e.getResources().getString(2131893336).equals(paramView.text)))
    {
      paramChatMessage = paramView.frienduin;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(TroopUtils.a(this.d, paramView.frienduin));
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramChatMessage, ((StringBuilder)localObject).toString(), "", "");
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.y);
    if (v) {
      b(paramView, paramBaseChatItemLayout, paramViewHolder);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new VideoItemBuilder.Holder(this);
  }
  
  String a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    String str = paramMessageForVideo.text;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getResources().getString(2131917877));
    ((StringBuilder)localObject).append(",");
    localObject = ((StringBuilder)localObject).toString();
    paramContext = UITools.b(str);
    int k = 0;
    int j;
    int i;
    if ((paramContext != null) && (paramContext.length == 3))
    {
      k = Integer.valueOf(paramContext[0]).intValue();
      j = Integer.valueOf(paramContext[1]).intValue();
      i = Integer.valueOf(paramContext[2]).intValue();
    }
    else if ((paramContext != null) && (paramContext.length == 2))
    {
      j = Integer.valueOf(paramContext[0]).intValue();
      i = Integer.valueOf(paramContext[1]).intValue();
    }
    else
    {
      i = 0;
      j = 0;
    }
    if ((k <= 0) && (j <= 0) && (i <= 0)) {
      return "";
    }
    paramContext = (Context)localObject;
    if (k > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append(k);
      paramContext.append(HardCodeUtil.a(2131913491));
      paramContext = paramContext.toString();
    }
    localObject = paramContext;
    if (j > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913493));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramContext = (Context)localObject;
    if (i > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append(i);
      paramContext.append(HardCodeUtil.a(2131913492));
      paramContext = paramContext.toString();
    }
    paramView = paramView.getResources();
    if (paramMessageForVideo.isVideo) {
      i = 2131917350;
    } else {
      i = 2131917336;
    }
    paramMessageForVideo = paramView.getString(i);
    paramView = new StringBuilder();
    paramView.append(paramMessageForVideo);
    paramView.append(paramContext);
    return paramView.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131431695)
    {
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), a, BaseChatItemLayout.getTextBubblePaddingAlignHead(), w);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), a, BaseChatItemLayout.getTextBubblePaddingAlignError(), w);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    VideoItemBuilder.Holder localHolder = (VideoItemBuilder.Holder)paramViewHolder;
    localHolder.a.setTextSize(0, this.f.r);
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()))
    {
      if (paramBubbleInfo.l == 0) {
        localHolder.a.setTextColor(-16777216);
      } else {
        localHolder.a.setTextColor(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m == 0)
      {
        localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131168018));
        return;
      }
      localHolder.a.setLinkTextColor(paramBubbleInfo.m);
      return;
    }
    paramViewHolder = paramView.getResources();
    if (localHolder.a.getText().toString().contains(this.e.getString(2131917863)))
    {
      paramViewHolder = paramViewHolder.getColorStateList(2131166686);
      localHolder.a.setTextColor(paramViewHolder);
      return;
    }
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131168020;
    } else {
      i = 2131168016;
    }
    paramView = paramViewHolder.getColorStateList(i);
    localHolder.a.setTextColor(paramView);
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131168019);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131168018);
    }
    localHolder.a.setLinkTextColor(paramViewHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131913494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */