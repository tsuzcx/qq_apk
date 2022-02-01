package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller.OnScrollerListener;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.BaseTroopMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.AttentionHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class BaseTroopChatPie
  extends BaseChatPie
  implements MoveToBottomScroller.OnScrollerListener
{
  protected boolean D = false;
  protected boolean E = false;
  protected boolean F = false;
  protected boolean G = false;
  protected long a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  public ProxyObserver a;
  protected TroopFeedsCenterLogic a;
  
  public BaseTroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new BaseTroopChatPie.2(this);
  }
  
  protected AIOContext a()
  {
    return new BaseTroopAIOContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseTroopMessageSender(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new BaseTroopScroller()).a(new BaseTroopListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public RecordParams.RecorderParam a()
  {
    boolean bool = ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).b();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)a(53);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if ((localUnreadBackBottomHelper != null) && (localAIOShortcutBarHelper != null) && (localAIOShortcutBarHelper.c() == 0) && (localUnreadBackBottomHelper.a()))
    {
      localAIOShortcutBarHelper.c(9);
      localAIOShortcutBarHelper.c(21);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.F)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377646).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(13);
      localAIOShortcutBarEvent.a().putBoolean("isJubaoMode", this.z);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      if (localAIOShortcutBarEvent.a().getBoolean("result")) {
        return;
      }
    }
    super.a(paramMotionEvent);
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopAioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleUpdateTroopAioAgentMessage: ");
        localStringBuilder.append(paramObject.jdField_a_of_type_Int);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramObject.jdField_a_of_type_Int == TroopAioAgent.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramObject.c, paramObject.a(), paramObject.d);
        return;
      }
      if (paramObject.jdField_a_of_type_Int == TroopAioAgent.b) {
        ((AudioPanelAioHelper)a(128)).j(paramObject.b);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
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
        e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(HardCodeUtil.a(2131701280));
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.4(this), 200L);
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.f.getVisibility() == 8))
    {
      this.f.setVisibility(0);
      this.e.setTextSize(1, 17.0F);
      this.d.setTextSize(1, 17.0F);
      return;
    }
    if ((!paramBoolean) && (this.f.getVisibility() == 0) && (!this.F))
    {
      this.f.setVisibility(8);
      this.e.setTextSize(1, 17.0F);
      this.d.setTextSize(1, 17.0F);
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((bool2) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = super.a(paramMotionEvent);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if ((localAIOShortcutBarHelper != null) && (localAIOShortcutBarHelper.a(paramMotionEvent))) {
      return false;
    }
    return bool;
  }
  
  protected void ao()
  {
    h(0);
  }
  
  public void ap()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719914));
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->current AIO info<--- onresume. troopUin:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(",curFriendUin:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",type:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  protected void aq()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    ar();
  }
  
  void ar()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleGrayTipsMsg");
    }
    Object localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "troopTipsMsgMgr == null");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "troopAIO has unread troopTipMsg");
      }
      localObject = new BaseTroopChatPie.3(this, (TroopTipsMsgMgr)localObject);
      ThreadManager.getSubThreadHandler().post((Runnable)localObject);
    }
  }
  
  public void as()
  {
    c(true);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    } else {
      n();
    }
    this.e.setText(new ColorNickText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 32).a());
    if (AppSetting.d)
    {
      paramIntent = this.e.getText().toString();
      this.e.setContentDescription(paramIntent);
      a().setTitle(this.e.getText());
    }
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.b(paramInt);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "BaseTroopChatPie";
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    super.c(paramBoolean);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.d();
  }
  
  protected void e()
  {
    super.e();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new BaseTroopChatPie.1(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.e.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
    this.f.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167053));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167050));
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(17);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void f(int paramInt)
  {
    super.f(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null)
    {
      localAIOShortcutBarHelper.c(21);
      localAIOShortcutBarHelper.c(9);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0) || (paramBoolean))
    {
      TroopFeedsCenterLogic localTroopFeedsCenterLogic = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic;
      if ((localTroopFeedsCenterLogic != null) && (localTroopFeedsCenterLogic.a())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a();
      }
    }
  }
  
  protected void m()
  {
    if ((!this.F) && (!this.G))
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850467, 2130850468);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843820);
  }
  
  protected void n()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
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
  
  @TargetApi(16)
  public void p()
  {
    if (this.B)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    TroopFeedsCenterLogic localTroopFeedsCenterLogic = this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic;
    if (localTroopFeedsCenterLogic != null)
    {
      localTroopFeedsCenterLogic.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    } else {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
    ao();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    super.p();
  }
  
  public boolean t()
  {
    return this.B;
  }
  
  public void u()
  {
    if (!this.B)
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
    super.u();
  }
  
  protected boolean u()
  {
    return false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null)
    {
      ((AttentionHeadMsgRefresher)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(17)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
      return;
    }
    if ((paramObject instanceof TroopAioAgent.Message)) {
      a(paramObject);
    }
  }
  
  public void v()
  {
    super.v();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
    }
  }
  
  public boolean v()
  {
    return this.F;
  }
  
  public void y()
  {
    super.y();
    ap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie
 * JD-Core Version:    0.7.0.1
 */