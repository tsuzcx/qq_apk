package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.PstnUtils;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import vii;
import vij;
import vik;
import vim;
import vin;
import vio;

public class VideoItemBuilder
  extends BaseBubbleBuilder
{
  private static final int b;
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private View.OnClickListener a;
  private boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    jdField_b_of_type_Int = BaseChatItemLayout.g + BaseChatItemLayout.l;
  }
  
  public VideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vii(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      paramInt = j;
    }
    for (;;)
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.q);
      return;
      int k = localResources.getDimensionPixelSize(2131559758);
      int m = localResources.getDimensionPixelSize(2131559759);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt;
      paramInt = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int / paramInt + m;
      i += m;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt1 + "], isVideo[" + paramBoolean + "], closeType[" + paramInt2 + "], msgSelfUin[" + paramString + "], curType[" + paramSessionInfo.jdField_a_of_type_Int + "], curFriendUin[" + paramSessionInfo.jdField_a_of_type_JavaLangString + "], curFriendNick[" + paramSessionInfo.d + "], troopUin[" + paramSessionInfo.jdField_b_of_type_JavaLangString + "], isVideoActionSheetShown[" + VideoActionSheet.a() + "]");
    if (QAVGroupConfig.a(paramQQAppInterface, paramSessionInfo)) {
      b(paramQQAppInterface, paramContext, paramSessionInfo, true, paramInt1, paramBoolean, paramInt2);
    }
    while (VideoActionSheet.a()) {
      return;
    }
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a(paramContext);
    localVideoActionSheet.b(2131429496);
    localVideoActionSheet.b(2131429497);
    localVideoActionSheet.c(2131432998);
    localVideoActionSheet.a(new vij(paramBoolean, localVideoActionSheet));
    localVideoActionSheet.a(new vik(localVideoActionSheet, paramQQAppInterface, paramSessionInfo, paramString, paramContext, paramBoolean, paramInt1, paramInt2));
    QAVGroupConfig.Report.c(paramBoolean);
    localVideoActionSheet.show();
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int j = 0;
    Object localObject1 = "";
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->message is null");
      }
    }
    do
    {
      return;
      if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->uin is null");
    return;
    Object localObject2;
    label125:
    int k;
    int i;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      if (-2016 == paramMessageForVideo.msgtype) {
        localObject1 = "我";
      }
      localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramMessageForVideo.isVideo) {
          break label473;
        }
        localObject1 = "视频电话,";
        localObject2 = (String)localObject1;
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131428841))) {
        break label525;
      }
      localObject2 = paramMessageForVideo.text;
      paramContext = paramContext.getResources().getString(2131428841) + ",";
      localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
      if (localObject2.length != 3) {
        break label481;
      }
      k = Integer.valueOf(localObject2[0]).intValue();
      j = Integer.valueOf(localObject2[1]).intValue();
      i = Integer.valueOf(localObject2[2]).intValue();
    }
    for (;;)
    {
      label291:
      if ((k > 0) || (j > 0) || (i > 0)) {
        if (k <= 0) {
          break label651;
        }
      }
      label651:
      for (localObject1 = paramContext + k + "小时,";; localObject1 = paramContext)
      {
        paramContext = (Context)localObject1;
        if (j > 0) {
          paramContext = (String)localObject1 + j + "分,";
        }
        localObject1 = paramContext;
        if (i > 0) {
          localObject1 = paramContext + i + "秒";
        }
        if (paramMessageForVideo.isVideo)
        {
          paramMessageForVideo = "视频电话,";
          label419:
          localObject1 = paramMessageForVideo + (String)localObject1;
        }
        for (;;)
        {
          paramView.setContentDescription(((String)localObject1).replace("点击", "双击"));
          return;
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForVideo.senderuin, 0);
          break;
          label473:
          localObject1 = "QQ电话,";
          break label125;
          label481:
          if (localObject2.length != 2) {
            break label657;
          }
          j = Integer.valueOf(localObject2[0]).intValue();
          i = Integer.valueOf(localObject2[1]).intValue();
          k = 0;
          break label291;
          paramMessageForVideo = "QQ电话,";
          break label419;
          label525:
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131428845)))
          {
            paramContext = paramContext.getResources();
            if (paramMessageForVideo.isVideo) {}
            for (i = 2131428934;; i = 2131428872)
            {
              localObject1 = paramContext.getString(i);
              break;
            }
          }
          if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131428760))) {
            localObject1 = paramContext.getResources().getString(2131428767);
          } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131428766))) {
            localObject1 = paramContext.getResources().getString(2131428767);
          }
        }
      }
      label657:
      i = 0;
      k = 0;
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, VideoActionSheet paramVideoActionSheet)
  {
    paramVideoActionSheet.b(2131433812);
    PstnManager localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    PstnCardInfo localPstnCardInfo = localPstnManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i;
    if ((localPstnCardInfo != null) && (localPstnManager.a() == 1) && (localPstnManager.a().d == 1))
    {
      paramVideoActionSheet.a(2131438327);
      if (localPstnCardInfo.pstn_multi_call_time > 0)
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840353), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
        i = 3;
      }
    }
    for (;;)
    {
      paramVideoActionSheet.c(2131432998);
      paramVideoActionSheet.a(new vim(this, paramVideoActionSheet, paramMessageForVideo, i));
      paramVideoActionSheet.show();
      return;
      if ((localPstnManager.c() == 1) && (localPstnCardInfo.pstn_multi_try_status == 0))
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840352), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
        i = 4;
      }
      else
      {
        paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840351), 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
        i = 5;
        continue;
        i = 0;
      }
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, boolean paramBoolean, int paramInt)
  {
    if ((!VcSystemInfo.c()) || (!VcSystemInfo.d()) || (VideoActionSheet.a())) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      if (paramInt == 1)
      {
        paramInt = paramMessageForVideo.extInt;
        paramBoolean = paramMessageForVideo.isVideo;
        int i = paramMessageForVideo.type;
        paramMessageForVideo = paramMessageForVideo.selfuin;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, paramBoolean, i, paramMessageForVideo);
        return;
      }
    } while (paramInt != 3000);
    a(paramMessageForVideo, VideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext));
    return;
    b(paramMessageForVideo, VideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext));
  }
  
  private void a(boolean paramBoolean, MessageForVideo paramMessageForVideo)
  {
    int i = paramMessageForVideo.extInt;
    boolean bool = paramMessageForVideo.isVideo;
    int j = paramMessageForVideo.type;
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, i, bool, j);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideoEx, avType[" + paramInt1 + "], isVideo[" + paramBoolean2 + "], closeType[" + paramInt2 + "]");
    Object localObject;
    if (paramBoolean1)
    {
      long l;
      if (paramInt1 == 2)
      {
        localObject = new HashMap();
        ((Map)localObject).put("MultiAVType", String.valueOf(paramInt1));
        ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, (Map)localObject);
        l = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
          break label237;
        }
        if (paramQQAppInterface.a().b() != l) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      label237:
      while ((paramSessionInfo.jdField_a_of_type_Int != 1) || (paramQQAppInterface.a().b(1, l)))
      {
        return;
        paramBoolean1 = QAVGroupConfig.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("MultiAVType", paramInt1);
        ((Bundle)localObject).putBoolean("enableInvite", paramBoolean1);
        ((Bundle)localObject).putBoolean("isVideo", paramBoolean2);
        ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, (Bundle)localObject);
        break;
      }
      if (paramInt1 == 10)
      {
        if (paramQQAppInterface.a().b() == 0L)
        {
          paramContext = paramQQAppInterface.a().a(l, 10);
          if ((paramContext == null) || (paramContext.jdField_a_of_type_Int <= 0)) {
            break label328;
          }
        }
        for (;;)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label328:
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    String str1;
    String str2;
    if (!paramBoolean2)
    {
      str1 = "Two_call";
      str2 = "Two_call_launch";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        localObject = "0";
        label461:
        ReportController.b(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, (String)localObject, "", "", "");
        if (paramInt2 == 2)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
          label519:
          if (!paramBoolean2) {
            break label704;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
          label551:
          localObject = null;
          str1 = null;
          paramInt1 = paramSessionInfo.jdField_a_of_type_Int;
          str2 = paramSessionInfo.d;
          if (paramInt1 != 1006) {
            break label734;
          }
          str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
          label583:
          if (paramBoolean2) {
            break label743;
          }
        }
        break;
      }
    }
    label704:
    label734:
    label743:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramInt1, (String)localObject, str2, str1, paramBoolean1, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
      return;
      str1 = "Two_video_call";
      str2 = "Two_video_call_launch";
      break;
      localObject = "0";
      break label461;
      localObject = "1";
      break label461;
      localObject = "2";
      break label461;
      localObject = "3";
      break label461;
      localObject = "4";
      break label461;
      if (paramInt2 != 0) {
        break label519;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      break label519;
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
      break label551;
      localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
      break label583;
    }
  }
  
  private void b(MessageForVideo paramMessageForVideo, VideoActionSheet paramVideoActionSheet)
  {
    int i = 0;
    PstnSessionInfo localPstnSessionInfo = new PstnSessionInfo();
    PstnManager localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
    PstnCardInfo localPstnCardInfo = localPstnManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramMessageForVideo.isVideo) {
      paramVideoActionSheet.b(2131433808);
    }
    for (;;)
    {
      paramVideoActionSheet.c(2131432998);
      paramVideoActionSheet.a(new vin(this, paramVideoActionSheet, paramMessageForVideo, i, localPstnSessionInfo));
      paramVideoActionSheet.show();
      return;
      paramVideoActionSheet.b(2131433811);
      localPstnSessionInfo = PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPstnSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if ((localPstnSessionInfo.jdField_b_of_type_JavaLangString != null) && (localPstnSessionInfo.c != null))
      {
        localPstnSessionInfo.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        if ((localPstnCardInfo != null) && (localPstnManager.a() == 1) && (localPstnManager.a().jdField_a_of_type_Int == 1))
        {
          paramVideoActionSheet.a(2131438327);
          if (localPstnCardInfo.pstn_c2c_call_time > 0)
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840353), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            i = 1;
          }
          else if ((localPstnManager.b() == 1) && (localPstnCardInfo.pstn_c2c_try_status == 0))
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840352), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
            i = 2;
          }
          else
          {
            paramVideoActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438325), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840351), 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
            i = 5;
          }
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    vio localvio = (vio)paramViewHolder;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131363557);
      paramViewHolder.setTextColor(localResources.getColorStateList(2131494220));
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131558421));
      paramViewHolder.setGravity(16);
      localvio.a = paramViewHolder;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    a(localvio.a, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    localvio.a.setTextColor(localResources.getColor(i));
    localvio.a.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131428990).equals(paramView.text))) {
      ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.frienduin), "", "");
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (jdField_b_of_type_Boolean) {
      a(paramView, paramBaseChatItemLayout, paramViewHolder);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vio(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了视频";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131375336)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131375346)
    {
      super.c(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(e, jdField_b_of_type_Int, d, jdField_c_of_type_Int);
      return;
    }
    paramView.setPadding(d, jdField_b_of_type_Int, e, jdField_c_of_type_Int);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    vio localvio = (vio)paramViewHolder;
    localvio.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (localvio.a.getText().toString().contains(this.jdField_a_of_type_AndroidContentContext.getString(2131428839)))
      {
        paramViewHolder = paramView.getColorStateList(2131493564);
        localvio.a.setTextColor(paramViewHolder);
        return;
      }
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494223);
        localvio.a.setTextColor(paramViewHolder);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (paramViewHolder = paramView.getColorStateList(2131494222);; paramViewHolder = paramView.getColorStateList(2131494221))
      {
        localvio.a.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131494220);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
      localvio.a.setTextColor(-16777216);
    }
    while (paramBubbleInfo.jdField_c_of_type_Int == 0)
    {
      localvio.a.setLinkTextColor(paramView.getResources().getColorStateList(2131494221));
      return;
      localvio.a.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    localvio.a.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */