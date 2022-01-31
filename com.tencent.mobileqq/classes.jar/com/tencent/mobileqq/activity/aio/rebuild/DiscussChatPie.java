package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vsg;
import vsh;
import vsi;
import vsj;
import vsl;
import vsm;
import vsn;

public class DiscussChatPie
  extends BaseChatPie
{
  public GamePartyTipsBar a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vsj(this);
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new vsi(this);
  protected MessageObserver a;
  public ActionSheet a;
  private Observer jdField_a_of_type_JavaUtilObserver = new vsl(this);
  private final String f = "DiscussChatPie";
  private Dialog g;
  private TextView j;
  
  public DiscussChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vsn(this);
  }
  
  private void aY()
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_d_of_type_AndroidWidgetTextView);
    }
    if (localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      aZ();
    }
  }
  
  private void aZ()
  {
    if ((this.jdField_g_of_type_AndroidAppDialog != null) && (this.jdField_g_of_type_AndroidAppDialog.isShowing())) {}
    DiscussionManager localDiscussionManager;
    Object localObject1;
    String str1;
    String str2;
    do
    {
      do
      {
        do
        {
          return;
          localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("DiscussChatPie", 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
        localObject1 = (String[])localDiscussionManager.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((localObject1 == null) || (localObject1.length < 2));
      str1 = localObject1[0];
      str2 = localObject1[1];
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    for (;;)
    {
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840512);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = ImageUtil.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.jdField_g_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, (Bitmap)localObject2, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2) + "已将多人聊天升级为群", "群号：" + str1, this.jdField_a_of_type_AndroidContentContext.getString(2131435269), null, new vsh(this, str1), null);
          if ((this.jdField_g_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
            this.jdField_g_of_type_AndroidAppDialog.show();
          }
          localDiscussionManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2;
          break label300;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      label300:
      if (QLog.isColorLevel())
      {
        QLog.d("DiscussChatPie", 2, QLog.getStackTraceString(localOutOfMemoryError1));
        localObject2 = localObject1;
      }
    }
  }
  
  private void e(String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  protected void D()
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localTroopInfoManager != null) {
      localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
    }
    super.D();
  }
  
  protected void G()
  {
    super.G();
    aY();
  }
  
  protected void X()
  {
    aX();
    super.X();
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.p();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    String str1;
    Object localObject;
    switch (paramInt1)
    {
    default: 
    case 6001: 
      do
      {
        return;
        str1 = paramIntent.getExtras().getString("member_uin");
        localObject = paramIntent.getExtras().getString("member_display_name");
        if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null)) {
          break;
        }
      } while ("0".equals(str1));
      paramIntent = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1);
      if (android.text.TextUtils.isEmpty(paramIntent)) {
        paramIntent = (Intent)localObject;
      }
      break;
    }
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.peerUin = str1;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.atNickName = paramIntent.toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.inputText = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
      paramInt1 = 0;
      String str2;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.inputText))
      {
        paramInt2 = 2;
        paramInt1 = paramInt2;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d == 0) {
            paramInt1 = 6;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          paramInt2 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          str2 = "" + this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.actionId;
          if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)) {
            break label463;
          }
        }
      }
      label463:
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, paramInt1, paramInt2, new String[] { str2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
          break;
        }
        paramInt1 = 7;
        break;
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.b))
        {
          paramInt1 = 3;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d == 0)
        {
          paramInt1 = 4;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.d != 1) {
          break;
        }
        paramInt1 = 5;
        break;
      }
      a(str1, (String)localObject, true);
      return;
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("result"); (paramIntent != null) && (!paramIntent.equals("")); paramIntent = "")
      {
        if (NetworkUtil.d(a()))
        {
          ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131434613), 0).b(a());
        return;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
        if (localObject == null) {
          break;
        }
        ((TroopGiftPanel)localObject).b(paramIntent.getStringExtra("member_uin"));
        return;
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_AndroidWidgetTextView);
    }
    super.a(paramConfiguration);
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramCharSequence = new ArrayList();
      paramCharSequence = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramCharSequence);
    }
    for (;;)
    {
      super.a(paramSessionInfo, paramDraftTextManager, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo);
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(0);
    }
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussChatPie", 2, "genDiscussTitle, name == null");
      }
    }
    do
    {
      int i;
      do
      {
        return;
        i = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramString1 = new QQText(paramString1, 1);
        if (i > 0) {
          break;
        }
        paramTextView.setText(paramString1);
      } while (!AppSetting.jdField_b_of_type_Boolean);
      paramTextView.setContentDescription(paramTextView.getText().toString());
      a().setTitle(paramTextView.getText());
      return;
      if (this.j == null) {
        this.j = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363997));
      }
      this.j.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
      if (this.j.getVisibility() != 0) {
        this.j.setVisibility(0);
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.jdField_b_of_type_Boolean);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + Utils.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vsm(this, paramBoolean, paramString1, paramString2), 300L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussChatPie", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    f(false);
    return true;
  }
  
  protected void aX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 9)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
    }
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_AndroidWidgetTextView);
  }
  
  protected void h()
  {
    super.h();
    DiscActiveTipsBar localDiscActiveTipsBar = new DiscActiveTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    DiscFreqPttGrayTips localDiscFreqPttGrayTips = new DiscFreqPttGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscActiveTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscFreqPttGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  protected void j(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussChatPie", 2, "disscuss Uin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (localVideoRoomInfo_tips != null)
    {
      if (!localVideoRoomInfo_tips.a) {
        break label137;
      }
      ReportController.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      super.j(paramInt);
      return;
      label137:
      ReportController.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    boolean bool = false;
    if (localDiscussionInfo != null) {
      bool = localDiscussionInfo.isDiscussHrMeeting();
    }
    if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() != 0) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == '@') || (paramCharSequence.charAt(paramInt1) == 65312)) && (!this.o) && (!this.M))
    {
      paramCharSequence = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
      paramCharSequence.putExtra("param_is_pop_up_style", true);
      paramCharSequence.setFlags(603979776);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramCharSequence, 6001);
      if (super.f() == 21) {
        paramCharSequence.putExtra("param_troop_send_apollo_msg", true);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131363507) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void p()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new vsg(this));
    if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131433382));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void s()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, DiscussionInfoCardActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void u()
  {
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130845894, 2130845895);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {}
    label173:
    for (;;)
    {
      return;
      if ((paramObject instanceof TroopAioAgent.Message))
      {
        paramObservable = (TroopAioAgent.Message)paramObject;
        if (paramObservable != null)
        {
          if (paramObservable.jdField_a_of_type_Int != TroopAioAgent.jdField_a_of_type_Int) {
            break label127;
          }
          a(paramObservable.c, paramObservable.a(), paramObservable.d, null);
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label173;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in DiscussChatPie.update()");
        }
        AioVipKeywordHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label127:
        if ((paramObservable.jdField_a_of_type_Int == TroopAioAgent.b) && (this.jdField_g_of_type_AndroidViewView != null))
        {
          ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObservable.b);
          continue;
          if (!(paramObject instanceof Integer)) {}
        }
      }
    }
  }
  
  protected void z()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie
 * JD-Core Version:    0.7.0.1
 */