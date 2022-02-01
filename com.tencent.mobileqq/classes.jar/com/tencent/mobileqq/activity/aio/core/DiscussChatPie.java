package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Spanned;
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
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.DiscussListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class DiscussChatPie
  extends BaseChatPie
{
  GamePartyTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new DiscussChatPie.4(this);
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new DiscussChatPie.3(this);
  protected MessageObserver a;
  public ActionSheet a;
  private Observer jdField_a_of_type_JavaUtilObserver = new DiscussChatPie.5(this);
  private Dialog c;
  private TextView l;
  
  public DiscussChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new DiscussChatPie.8(this);
  }
  
  private void bi()
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localDiscussionInfo != null) && (localDiscussionInfo.discussionName != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localDiscussionInfo.discussionName;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localDiscussionInfo.uin, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    if (localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bj();
    }
  }
  
  private void bj()
  {
    if ((this.c != null) && (this.c.isShowing())) {}
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
          localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localDiscussionManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.b, 2, "DiscussionManager's discToTroopCache doesn't contain discussionUIN :" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130842654);
        localObject2 = localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject2 = ImageUtil.b((Bitmap)localObject1, 10.0F, 140, 140);
          this.c = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, (Bitmap)localObject2, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2) + HardCodeUtil.a(2131703367), HardCodeUtil.a(2131703366) + str1, this.jdField_a_of_type_AndroidContentContext.getString(2131719347), null, new DiscussChatPie.2(this, str1), null);
          if ((this.c != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
            this.c.show();
          }
          localDiscussionManager.a.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2;
          break label309;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject1 = null;
      }
      label309:
      if (QLog.isColorLevel())
      {
        QLog.d(this.b, 2, QLog.getStackTraceString(localOutOfMemoryError1));
        localObject2 = localObject1;
      }
    }
  }
  
  private void bk()
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
  
  private void bl()
  {
    Intent localIntent = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
    localIntent.putExtra("param_is_pop_up_style", true);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 6001);
    if (super.g() == 21) {
      localIntent.putExtra("param_troop_send_apollo_msg", true);
    }
  }
  
  private void h(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
      }
    }
  }
  
  private void i(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("result");; paramIntent = "")
    {
      if ((paramIntent != null) && (!paramIntent.equals("")))
      {
        if (NetworkUtil.d(a())) {
          ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), paramIntent);
        }
      }
      else {
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694510), 0).b(a());
      return;
    }
  }
  
  private void i(String paramString)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("input_text", this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString());
    localIntent.putExtra("input_panel_status", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
  }
  
  private void j(Intent paramIntent)
  {
    String str1 = paramIntent.getExtras().getString("member_uin");
    Object localObject = paramIntent.getExtras().getString("member_display_name");
    if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null))
    {
      if ("0".equals(str1)) {
        return;
      }
      paramIntent = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str1);
      if (!android.text.TextUtils.isEmpty(paramIntent)) {
        break label480;
      }
      paramIntent = (Intent)localObject;
    }
    label459:
    label480:
    for (;;)
    {
      paramIntent = new StringBuilder("@").append(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.peerUin = str1;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.atNickName = paramIntent.toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo);
      int i = 0;
      int j;
      String str2;
      String str3;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.inputText))
      {
        j = 2;
        i = j;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType == 0) {
            i = 6;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          str2 = "" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.actionId;
          str3 = "655_" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mPackageId;
          if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)) {
            break label459;
          }
        }
      }
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, str3, paramIntent, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
          break;
        }
        i = 7;
        break;
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText))
        {
          i = 3;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType == 0)
        {
          i = 4;
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
          break;
        }
        i = 5;
        break;
      }
      a(str1, (String)localObject, true);
      return;
    }
  }
  
  protected void B()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850541, 2130850542);
  }
  
  public void J()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
    }
    super.J();
  }
  
  public void N()
  {
    if (!this.I)
    {
      TroopAioNavigateBarManager localTroopAioNavigateBarManager = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localTroopAioNavigateBarManager != null) {
        localTroopAioNavigateBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
    super.N();
  }
  
  public void R()
  {
    super.R();
    bi();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new DiscussListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = super.s();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        return;
        j(paramIntent);
        return;
        i(paramIntent);
        return;
        h(paramIntent);
        return;
      } while (paramInt2 != 0);
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
    BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    }
    super.a(paramConfiguration);
  }
  
  public void a(View paramView)
  {
    bk();
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramSpanned = new ArrayList();
      paramSpanned = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramSpanned);
    }
    for (;;)
    {
      super.a(paramSessionInfo, paramDraftTextManager, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, null);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.b, 2, "genDiscussTitle, name == null");
      }
    }
    int i;
    do
    {
      return;
      i = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString1 = new QQText(paramString1, 1);
      if (i > 0) {
        break;
      }
      paramTextView.setText(paramString1);
    } while (!AppSetting.d);
    paramTextView.setContentDescription(paramTextView.getText().toString());
    a().setTitle(paramTextView.getText());
    return;
    if (this.l == null) {
      this.l = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365891));
    }
    this.l.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    if (this.l.getVisibility() != 0)
    {
      this.l.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.k) {
          break label236;
        }
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      paramString2.a(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramTextView.setText(paramString1);
      if (!AppSetting.d) {
        break;
      }
      paramTextView.setContentDescription(paramTextView.getText().toString());
      a().setTitle(paramTextView.getText());
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((android.text.TextUtils.isEmpty(paramString1)) || (android.text.TextUtils.isEmpty(paramString2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, "memUin:" + paramString1 + " displayName:" + MessageRecordUtil.a(paramString2) + " isRemoveOldAtFlag:" + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l)
    {
      if ("0".equals(paramString1))
      {
        BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.i = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(131077);
      g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(HardCodeUtil.a(2131703363));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.6(this), 200L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new DiscussChatPie.7(this, paramBoolean, paramString1, paramString2), 300L);
  }
  
  protected boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public void aO()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  protected void ae()
  {
    a();
    super.ae();
  }
  
  protected void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    ((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null) {
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
  }
  
  protected void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  protected void c()
  {
    this.b = "DiscussChatPie";
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aO();
  }
  
  protected void k()
  {
    super.k();
    DiscActiveTipsBar localDiscActiveTipsBar = new DiscActiveTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    DiscFreqPttGrayTips localDiscFreqPttGrayTips = new DiscFreqPttGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar = new GamePartyTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscActiveTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localDiscFreqPttGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar);
  }
  
  public void m(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "disscuss Uin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    AVNotifyCenter.VideoRoomInfo_tips localVideoRoomInfo_tips = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
    if (localVideoRoomInfo_tips != null)
    {
      if (!localVideoRoomInfo_tips.a) {
        break label139;
      }
      ReportController.b(null, "CliOper", "", "", "0X80066C0", "0X80066C0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 2);
      super.m(paramInt);
      return;
      label139:
      ReportController.b(null, "CliOper", "", "", "0X80066BD", "0X80066BD", 0, 0, "", "", "", "");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(0);
      }
      super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l = true;
      bl();
    }
    boolean bool;
    do
    {
      return;
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bool = false;
      if (localDiscussionInfo != null) {
        bool = localDiscussionInfo.isDiscussHrMeeting();
      }
    } while ((bool) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0) || (paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '@') && (paramCharSequence.charAt(paramInt1) != 65312)) || (this.o) || (((QWalletAIOLifeCycleHelper)a(27)).a));
    bl();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131370460) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().e();
    }
    return super.onTouch(paramView, paramMotionEvent);
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
        if ((paramObservable.jdField_a_of_type_Int == TroopAioAgent.b) && (this.jdField_e_of_type_AndroidViewView != null))
        {
          ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObservable.b);
          continue;
          if (!(paramObject instanceof Integer)) {}
        }
      }
    }
  }
  
  protected void v()
  {
    this.d.setOnClickListener(new DiscussChatPie.1(this));
    if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.d.setVisibility(0);
      this.d.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698538));
    }
    for (;;)
    {
      aO();
      return;
      this.d.setVisibility(8);
    }
  }
  
  protected void y()
  {
    aY();
  }
  
  public void z()
  {
    bk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie
 * JD-Core Version:    0.7.0.1
 */