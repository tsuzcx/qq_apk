package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller.OnScrollerListener;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.AttentionHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class BaseTroopChatPie
  extends BaseChatPie
  implements MoveToBottomScroller.OnScrollerListener
{
  protected boolean N = false;
  protected boolean O = false;
  public boolean P = false;
  protected boolean Q = false;
  public boolean R;
  public boolean S;
  public boolean T = false;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public ProxyObserver a;
  public TroopFeedsCenterLogic a;
  public TroopAIORobotLayout a;
  protected long b;
  public String f;
  public String g;
  
  public BaseTroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new BaseTroopChatPie.2(this);
  }
  
  protected void B()
  {
    if ((this.P) || (this.Q))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843900);
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850541, 2130850542);
  }
  
  protected void C()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  public boolean E()
  {
    return this.I;
  }
  
  protected boolean F()
  {
    return false;
  }
  
  public boolean G()
  {
    return this.P;
  }
  
  @TargetApi(16)
  public void J()
  {
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      bi();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
      TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
      if (localTroopRobotHelper != null) {
        localTroopRobotHelper.b();
      }
      super.J();
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void N()
  {
    if (!this.I)
    {
      Object localObject = (TroopAioNavigateBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localObject != null)
      {
        ((TroopAioNavigateBarManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
          if (localObject != null) {
            ((TroopAioMsgNavigateBar)localObject).a.set(false);
          }
        }
      }
    }
    super.N();
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
    }
  }
  
  public void R()
  {
    super.R();
    bj();
  }
  
  public View a(int paramInt)
  {
    return super.a(paramInt);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseTroopScroller()).a(new BaseTroopListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = super.s();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)a(53);
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)a(52);
    if ((localUnreadBackBottomHelper != null) && (localShortcutBarAIOHelper != null) && (localShortcutBarAIOHelper.b()) && (localUnreadBackBottomHelper.a())) {
      localShortcutBarAIOHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.P)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localTroopRobotHelper != null) {
      localTroopRobotHelper.a(paramIntent);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if ((localTroopRobotHelper != null) && (localTroopRobotHelper.a(paramMotionEvent, this.G))) {
      return;
    }
    super.a(paramMotionEvent);
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      paramSpanned = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        paramString2 = AtTroopMemberSpan.a(localArrayList);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
          super.a(paramSessionInfo, paramDraftTextManager, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, paramString2);
        }
        return;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
    BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
    return;
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
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(HardCodeUtil.a(2131701139));
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  protected boolean a()
  {
    boolean bool = false;
    if ((this.D) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = super.a(paramMotionEvent);
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)a(52);
    if ((localShortcutBarAIOHelper != null) && (localShortcutBarAIOHelper.a(paramMotionEvent))) {
      return false;
    }
    return bool;
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new ColorNickText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, 32).a());
      if (AppSetting.d)
      {
        paramIntent = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      }
      return;
      C();
    }
  }
  
  protected void b(Object paramObject)
  {
    paramObject = (TroopAioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleUpdateTroopAioAgentMessage: " + paramObject.jdField_a_of_type_Int);
      }
      if (paramObject.jdField_a_of_type_Int != TroopAioAgent.jdField_a_of_type_Int) {
        break label74;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label74:
    while ((paramObject.jdField_a_of_type_Int != TroopAioAgent.b) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.f.getVisibility() == 8))
    {
      this.f.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.f.getVisibility() != 0) || (this.P)) {
      return;
    }
    this.f.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      super.b(paramBoolean1, paramBoolean2);
    }
    Object localObject;
    do
    {
      return;
      super.b(paramBoolean1, paramBoolean2);
      localObject = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
      if (localObject != null) {
        ((TroopRobotHelper)localObject).a(this.jdField_e_of_type_AndroidViewView);
      }
      localObject = (ShortcutBarAIOHelper)a(52);
    } while (localObject == null);
    ((ShortcutBarAIOHelper)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_e_of_type_AndroidViewView);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.b(paramInt);
  }
  
  protected void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  protected void bi()
  {
    n(0);
  }
  
  public void bj()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720181));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void bk()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    bl();
  }
  
  void bl()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new BaseTroopChatPie.3(this, (TroopTipsMsgMgr)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bm()
  {
    e(true);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "BaseTroopChatPie";
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    super.e(paramBoolean);
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new BaseTroopChatPie.1(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
    this.f.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167030));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167027));
    TroopRobotHelper localTroopRobotHelper = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localTroopRobotHelper != null) {
      localTroopRobotHelper.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.g();
  }
  
  protected void h(int paramInt)
  {
    super.h(paramInt);
    Object localObject = (TroopRobotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(23);
    if (localObject != null) {
      ((TroopRobotHelper)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = (ShortcutBarAIOHelper)a(52);
    if (localObject != null) {
      ((ShortcutBarAIOHelper)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a();
  }
  
  protected void j()
  {
    super.j();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramInt1, paramInt2, paramInt3, i, j);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      ((AttentionHeadMsgRefresher)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(17)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
    while (!(paramObject instanceof TroopAioAgent.Message)) {
      return;
    }
    b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie
 * JD-Core Version:    0.7.0.1
 */