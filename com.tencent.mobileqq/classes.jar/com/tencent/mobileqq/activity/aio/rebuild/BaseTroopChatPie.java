package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller.OnScrollerListener;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager.UserActionStateInParallelPullPeriod;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.widget.TroopAIORobotPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vqv;
import vqw;
import vqx;
import vqy;

public class BaseTroopChatPie
  extends BaseChatPie
  implements MoveToBottomScroller.OnScrollerListener
{
  public boolean O;
  protected boolean P;
  public boolean Q;
  protected boolean R;
  public boolean S;
  protected boolean T;
  public boolean U;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  ProxyObserver a;
  public TroopFeedsCenterLogic a;
  protected TroopAIORobotPanel a;
  public String f;
  public String g;
  protected long h;
  
  public BaseTroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new vqw(this);
  }
  
  protected void D()
  {
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject != null)
    {
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
        if (localObject != null) {
          ((TroopAioMsgNavigateBar)localObject).a.set(false);
        }
      }
    }
    super.D();
  }
  
  protected void E()
  {
    super.E();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    }
  }
  
  protected void G()
  {
    super.G();
    aY();
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130968963, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = this.G;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e = this.G;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c = this.G;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight(), this.jdField_e_of_type_JavaLangString, this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      if (this.Q) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.Q);
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    if (paramInt == 27)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel;
    }
    return super.a(paramInt);
  }
  
  public QQRecorder.RecorderParam a()
  {
    boolean bool = super.p();
    return RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
  }
  
  public void a() {}
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if (this.Q)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground().setVisible(true, false);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363495).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(i, false);
    }
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
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
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int j = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a().a.get()))
    {
      if ((!TroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b())) || (paramInt2 <= 0)) {
        break label239;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      int k = localList.size();
      int m = paramInt1 + paramInt2 - j - i;
      if (QLog.isColorLevel()) {
        QLog.i("BaseTroopChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i + ",headerCnt = " + j + ", listSize = " + k);
      }
      if ((paramInt1 >= 0) && (paramInt1 <= m) && (m < k))
      {
        localList = localList.subList(paramInt1, m);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(localList);
      }
    }
    for (;;)
    {
      super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
      label239:
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b(0);
    }
  }
  
  public void a(Object paramObject)
  {
    switch (((Integer)paramObject).intValue())
    {
    }
    for (;;)
    {
      super.a(paramObject);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(27, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a();
      TroopRobotManager.a("panel", "exp", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel.a(), "", "");
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2)) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new vqy(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "troop chatPie listView onViewCompleteVisableAndReleased");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.a).a(this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.i();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      if (!this.P)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      this.P = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.f = true;
      if (!this.P)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      this.P = false;
      break;
      f(false);
    }
  }
  
  protected void aX()
  {
    k(0);
  }
  
  void aY()
  {
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433681));
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "--->current AIO info<--- onresume. troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b + ",curFriendUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + ",type:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  protected void aZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.g();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() != 9)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
    }
    ba();
  }
  
  public void b(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
    }
    for (;;)
    {
      this.d.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        paramIntent = this.d.getText().toString();
        this.d.setContentDescription(paramIntent);
        a().setTitle(this.d.getText());
      }
      return;
      v();
    }
  }
  
  protected void b(Object paramObject)
  {
    paramObject = (TroopAioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (paramObject.jdField_a_of_type_Int != TroopAioAgent.jdField_a_of_type_Int) {
        break label37;
      }
      a(paramObject.c, paramObject.a(), paramObject.d, null);
    }
    label37:
    while ((paramObject.jdField_a_of_type_Int != TroopAioAgent.b) || (this.g == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.g.getLayoutParams()).addRule(2, paramObject.b);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.d.setTextSize(1, 16.0F);
      this.c.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) || (this.Q)) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setTextSize(2, 19.0F);
    this.c.setTextSize(2, 19.0F);
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.b(paramInt);
  }
  
  void ba()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "handleGrayTipsMsg");
    }
    Object localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, "troopTipsMsgMgr == null");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (!((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPie", 2, "troopAIO has unread troopTipMsg");
    }
    localObject = new vqx(this, (TroopTipsMsgMgr)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void bb()
  {
    e(true);
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new vqv(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      this.d.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494212));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494212));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131494210));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotPanel = new TroopAIORobotPanel(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a(this);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    super.e(paramBoolean);
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    }
    return super.e();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {}
    while (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) && (!paramBoolean)) || (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.a();
  }
  
  protected void u()
  {
    if ((this.Q) || (this.R)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841260);
    }
    while (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130845894, 2130845895);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d == TroopMessageManager.UserActionStateInParallelPullPeriod.c) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a != null)) {
          a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.c, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.a(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.d, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseTroopChatPie.trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().deleteObservers();
      }
    }
    while (!(paramObject instanceof TroopAioAgent.Message)) {
      return;
    }
    b(paramObject);
  }
  
  protected void v()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
  }
  
  public boolean x()
  {
    return this.I;
  }
  
  public boolean y()
  {
    return false;
  }
  
  @TargetApi(16)
  protected void z()
  {
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, "hasDestory = true return");
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
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        break label115;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      aX();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(false);
      }
      super.z();
      return;
      label115:
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie
 * JD-Core Version:    0.7.0.1
 */