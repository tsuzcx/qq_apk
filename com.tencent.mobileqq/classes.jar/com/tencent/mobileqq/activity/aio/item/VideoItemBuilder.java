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

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int jdField_a_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VideoItemBuilder.1(this);
  private boolean jdField_f_of_type_Boolean = true;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.j + BaseChatItemLayout.o;
  }
  
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
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int j = localDrawable.getIntrinsicWidth();
    int i = localDrawable.getIntrinsicHeight();
    paramInt = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = j;
    }
    else
    {
      int k = localResources.getDimensionPixelSize(2131297700);
      int m = localResources.getDimensionPixelSize(2131297701);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      j = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt + m;
      i = i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt + m;
      paramInt = j;
    }
    localDrawable.setBounds(0, 0, paramInt, i);
    paramTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
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
      GroupVideoChatAppInfo.startGroupVideoOrVoice(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject);
      long l = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
      {
        if (paramQQAppInterface.getAVNotifyCenter().b() != l) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      else if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (!paramQQAppInterface.getAVNotifyCenter().b(1, l)))
      {
        if (paramInt == 10)
        {
          if (paramQQAppInterface.getAVNotifyCenter().b() == 0L)
          {
            paramContext = paramQQAppInterface.getAVNotifyCenter().a(l, 10);
            if ((paramContext == null) || (paramContext.jdField_a_of_type_Int <= 0)) {
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
      boolean bool = QAVGroupConfig.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("MultiAVType", paramInt);
      ((Bundle)localObject).putBoolean("enableInvite", bool);
      ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Bundle)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = QQAudioHelper.b();
    int j = paramSessionInfo.jdField_a_of_type_Int;
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    long l2 = UinUtils.b(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showGroupQavActionSheet, avType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isVideo[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], msgSelfUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(j);
    localStringBuilder.append("], groupId[");
    localStringBuilder.append(str);
    localStringBuilder.append("], curFriendNick[");
    localStringBuilder.append(paramSessionInfo.d);
    localStringBuilder.append("], troopUin[");
    localStringBuilder.append(paramSessionInfo.jdField_b_of_type_JavaLangString);
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
      if ((paramString1 != null) && (paramString1.jdField_a_of_type_Int > 0))
      {
        i = 0;
        bool = false;
      }
      else
      {
        paramString1 = QAVGroupConfig.a(paramQQAppInterface, str);
        bool = paramString1.getBoolean("forceDisableInviteBox");
        i = paramString1.getInt("errId", 2131695638);
      }
      if (bool)
      {
        DialogUtil.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131695421, 2131720247, new VideoItemBuilder.2(), null).show();
        return;
      }
    }
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramBoolean)) {
      return;
    }
    if (QQAudioHelper.a(19) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      QQAudioHelper.a(HardCodeUtil.a(2131716045));
    }
    if ((!paramQQAppInterface.getAVNotifyCenter().a(l1, str)) && (i == 0))
    {
      paramString1 = paramQQAppInterface.getAVNotifyCenter().a(UinUtils.b(str));
      if ((paramString1 != null) && (paramString1.jdField_b_of_type_Int == paramInt))
      {
        if ((paramString1 != null) && (paramString1.jdField_b_of_type_Int == 2) && (paramString1.d == 2) && (paramString1.jdField_e_of_type_Int == 4)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean, paramString2);
        return;
      }
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.d, paramBoolean, paramString2);
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
    AIOUtils.o = true;
    if (VcSystemInfo.isSupportSharpAudio())
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    try
    {
      l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
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
    i = UITools.b(paramSessionInfo.jdField_a_of_type_Int);
    l = paramQQAppInterface.getAVNotifyCenter().a(i, l);
    localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    bool1 = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin());
    bool2 = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    bool3 = ((TroopGagMgr)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((TroopGagInfo)localObject).a > 0L))))
    {
      QQToast.a(paramQQAppInterface.getApp(), HardCodeUtil.a(2131716044), 0).b(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299168));
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
          String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(TroopUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString));
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
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
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
          localObject1 = HardCodeUtil.a(2131716038);
        } else {
          localObject1 = "";
        }
      }
      else {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
      }
      Object localObject2 = localObject1;
      int i;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = paramView.getResources();
        if (paramMessageForVideo.isVideo) {
          i = 2131719747;
        } else {
          i = 2131719733;
        }
        ((StringBuilder)localObject2).append(((Resources)localObject1).getString(i));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(paramMessageForVideo.text);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720243)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(a(paramMessageForVideo, paramContext, paramView));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131720232)))
      {
        paramContext = paramContext.getResources();
        if (paramMessageForVideo.isVideo) {
          i = 2131720252;
        } else {
          i = 2131690207;
        }
        localObject1 = paramContext.getString(i);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695960)))
      {
        localObject1 = paramContext.getResources().getString(2131718733);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695959)))
      {
        localObject1 = paramContext.getResources().getString(2131718223);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695378)))
      {
        localObject1 = paramContext.getResources().getString(2131718733);
      }
      else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131695377)))
      {
        localObject1 = paramContext.getResources().getString(2131718223);
      }
      paramView.setContentDescription(((String)localObject1).replace(HardCodeUtil.a(2131716046), HardCodeUtil.a(2131716037)));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->uin is null");
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
    int i = paramSessionInfo.jdField_a_of_type_Int;
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
    int i = paramSessionInfo.jdField_a_of_type_Int;
    String str = paramSessionInfo.d;
    Object localObject2;
    Object localObject3;
    if (i == 1006)
    {
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject2 = null;
      localObject3 = localObject1;
    }
    else
    {
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
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
    ChatActivityUtils.a(paramQQAppInterface, paramQQAppInterface.getApp(), i, localObject2, str, localObject3, paramBoolean ^ true, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = (VideoItemBuilder.Holder)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131364524);
      paramViewHolder.setTextColor(localResources.getColorStateList(2131167075));
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131296454));
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
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695577).equals(paramView.text)))
    {
      paramChatMessage = paramView.frienduin;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin));
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramChatMessage, ((StringBuilder)localObject).toString(), "", "");
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_e_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramViewHolder);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new VideoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131716043);
  }
  
  String a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    String str = paramMessageForVideo.text;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getResources().getString(2131720243));
    ((StringBuilder)localObject).append(",");
    localObject = ((StringBuilder)localObject).toString();
    paramContext = UITools.a(str);
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
      paramContext.append(HardCodeUtil.a(2131716040));
      paramContext = paramContext.toString();
    }
    localObject = paramContext;
    if (j > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131716042));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramContext = (Context)localObject;
    if (i > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append((String)localObject);
      paramContext.append(i);
      paramContext.append(HardCodeUtil.a(2131716041));
      paramContext = paramContext.toString();
    }
    paramView = paramView.getResources();
    if (paramMessageForVideo.isVideo) {
      i = 2131719747;
    } else {
      i = 2131719733;
    }
    paramMessageForVideo = paramView.getString(i);
    paramView = new StringBuilder();
    paramView.append(paramMessageForVideo);
    paramView.append(paramContext);
    return paramView.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365480)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, jdField_a_of_type_Int, jdField_e_of_type_Int, d);
      return;
    }
    paramView.setPadding(jdField_e_of_type_Int, jdField_a_of_type_Int, jdField_f_of_type_Int, d);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    VideoItemBuilder.Holder localHolder = (VideoItemBuilder.Holder)paramViewHolder;
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
        localHolder.a.setTextColor(-16777216);
      } else {
        localHolder.a.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      }
      if (paramBubbleInfo.c == 0)
      {
        localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167077));
        return;
      }
      localHolder.a.setLinkTextColor(paramBubbleInfo.c);
      return;
    }
    paramViewHolder = paramView.getResources();
    if (localHolder.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131720229)))
    {
      paramViewHolder = paramViewHolder.getColorStateList(2131165965);
      localHolder.a.setTextColor(paramViewHolder);
      return;
    }
    int i;
    if (paramChatMessage.isSend()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramView = paramViewHolder.getColorStateList(i);
    localHolder.a.setTextColor(paramView);
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramViewHolder.getColorStateList(2131167078);
    } else {
      paramViewHolder = paramViewHolder.getColorStateList(2131167077);
    }
    localHolder.a.setLinkTextColor(paramViewHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */