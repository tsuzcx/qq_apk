package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.RobotChatUIHelper;
import com.tencent.mobileqq.activity.aio.helper.RobotHelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout;
import com.tencent.mobileqq.robotchat.RobotChatTipLayout.RobotChatTipLayoutListener;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class RobotChatPie
  extends FriendChatPie
  implements Handler.Callback, RobotChatTipLayout.RobotChatTipLayoutListener
{
  private RobotChatTipLayout a;
  private View h;
  
  public RobotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void aq()
  {
    if (SharedPreUtils.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = new RobotChatTipLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a(this);
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a()).addView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout, 0);
  }
  
  private void ar()
  {
    Object localObject = (ViewGroup)this.e.getParent();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a();
    localObject = (ImageView)this.c.findViewById(2131378831);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(RobotChatUtil.a(this.jdField_a_of_type_AndroidContentContext));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (AIOShortcutBarHelper)a(52);
    if (localObject != null) {
      ((AIOShortcutBarHelper)localObject).c(17);
    }
  }
  
  private boolean u()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(2)).d())
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public void F()
  {
    super.F();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(a());
    }
  }
  
  protected void J()
  {
    super.J();
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onShow_otherThings:");
    }
  }
  
  protected AIOContext a()
  {
    return new RobotContext();
  }
  
  protected HelperProvider a()
  {
    return new RobotHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    aq();
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout;
    if (paramIntent != null) {
      paramIntent.setRobotName(e());
    }
    paramIntent = (AIOShortcutBarHelper)a(52);
    if (paramIntent != null) {
      paramIntent.c(19);
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
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    SharedPreUtils.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a() != null))
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a()).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.d();
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(paramInt1, paramInt2);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new RobotChatPie.1(this));
  }
  
  protected void c()
  {
    this.b = "RobotChatPie";
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.a(new AIOShortcutBarHelper.AIOShortcutBarEvent(20, paramIntent));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leftBackEvent begin:");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "no confirm dialog");
    }
    super.c(paramBoolean);
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "onBackEvent begin");
    }
    if (u()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "no confirm dialog");
    }
    return super.d();
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    }
    return null;
  }
  
  protected void e()
  {
    super.e();
    ar();
  }
  
  protected void f(int paramInt)
  {
    super.f(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(21);
    }
  }
  
  protected void j()
  {
    if (this.d != null)
    {
      this.d.setVisibility(4);
      ThreadManager.post(new RobotChatPie.2(this), 5, null, false);
    }
  }
  
  public void k()
  {
    RobotUtils.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ReportController.b(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
  
  protected void n()
  {
    super.n();
    RobotChatTipLayout localRobotChatTipLayout = this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout;
    if (localRobotChatTipLayout != null) {
      localRobotChatTipLayout.setRobotName(e());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131367417)
    {
      RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
      if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0)
        {
          localRobotChatUIHelper.b(false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
        }
        else
        {
          localRobotChatUIHelper.b(true);
        }
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b, 2, "doOnDestroy:");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a() != null))
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a()).removeView(this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout);
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqRobotchatRobotChatTipLayout = null;
    }
    View localView = this.h;
    if ((localView != null) && (localView.getParent() != null))
    {
      ((ViewGroup)this.h.getParent()).removeView(this.h);
      this.h = null;
    }
    super.p();
  }
  
  public boolean t()
  {
    return false;
  }
  
  protected void w()
  {
    super.w();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void y()
  {
    super.y();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)a(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.b())) {
      localRobotChatUIHelper.a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie
 * JD-Core Version:    0.7.0.1
 */