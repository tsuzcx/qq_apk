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
  private RobotChatTipLayout bC;
  private View bD;
  
  public RobotChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private boolean bD()
  {
    int i = this.n.getCurrentPanel();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0)
    {
      bool1 = bool2;
      if (!((AudioPanelProvider)this.ae.f(2)).g())
      {
        this.n.a(true);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkConsumeBackEvent, comsumed:");
      localStringBuilder.append(bool1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private void bE()
  {
    if (SharedPreUtils.x(this.e, this.d.getCurrentUin(), this.ah.b)) {
      return;
    }
    this.bC = new RobotChatTipLayout(this.e);
    this.bC.a(this);
    ((ViewGroup)this.k.d().c()).addView(this.bC, 0);
  }
  
  private void bF()
  {
    Object localObject = (ViewGroup)this.C.getParent();
    this.p.a();
    localObject = (ImageView)this.aZ.findViewById(2131447515);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageDrawable(RobotChatUtil.a(this.e));
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = (AIOShortcutBarHelper)q(52);
    if (localObject != null) {
      ((AIOShortcutBarHelper)localObject).d(17);
    }
  }
  
  public void B()
  {
    RobotUtils.a(this.e, null, this.ah.b);
    ReportController.b(null, "dc00898", "", "", "0X800A48B", "0X800A48B", 0, 0, "", "", "", "");
  }
  
  protected void E()
  {
    super.E();
    RobotChatTipLayout localRobotChatTipLayout = this.bC;
    if (localRobotChatTipLayout != null) {
      localRobotChatTipLayout.setRobotName(bC());
    }
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "doOnDestroy:");
    }
    if ((this.bC != null) && (this.k.d().c() != null))
    {
      ((ViewGroup)this.k.d().c()).removeView(this.bC);
      this.bC.a();
      this.bC = null;
    }
    View localView = this.bD;
    if ((localView != null) && (localView.getParent() != null))
    {
      ((ViewGroup)this.bD.getParent()).removeView(this.bD);
      this.bD = null;
    }
    super.K();
  }
  
  protected void Q()
  {
    super.Q();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
      localRobotChatUIHelper.a(this.s);
    }
  }
  
  public void S()
  {
    super.S();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
      localRobotChatUIHelper.a(T());
    }
  }
  
  public boolean V()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onBackEvent begin");
    }
    if (bD()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "no confirm dialog");
    }
    return super.V();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(13);
      localAIOShortcutBarEvent.a().putBoolean("isJubaoMode", this.aO);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      if (localAIOShortcutBarEvent.a().getBoolean("result")) {
        return;
      }
    }
    super.a(paramMotionEvent);
  }
  
  public void a(RobotChatTipLayout paramRobotChatTipLayout)
  {
    SharedPreUtils.f(this.e, this.d.getCurrentUin(), this.ah.b, true);
    if ((this.bC != null) && (this.k.d().c() != null))
    {
      ((ViewGroup)this.k.d().c()).removeView(this.bC);
      this.bC.a();
      this.bC = null;
    }
    ReportController.b(this.d, "dc00898", "", "", "0X800A486", "0X800A486", 0, 0, "", "", "", "");
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  public void ai()
  {
    super.ai();
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
      localRobotChatUIHelper.a(T());
    }
  }
  
  protected void ao()
  {
    super.ao();
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "onShow_otherThings:");
    }
  }
  
  protected HelperProvider b()
  {
    return new RobotHelperProvider(this.f);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
      localRobotChatUIHelper.a(paramInt1, paramInt2);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    bE();
    paramIntent = this.bC;
    if (paramIntent != null) {
      paramIntent.setRobotName(bC());
    }
    paramIntent = (AIOShortcutBarHelper)q(52);
    if (paramIntent != null) {
      paramIntent.d(19);
    }
  }
  
  public String bC()
  {
    if (this.ah != null)
    {
      if (!TextUtils.isEmpty(this.ah.e)) {
        return this.ah.e;
      }
      return this.ah.b;
    }
    return null;
  }
  
  public boolean bz()
  {
    return false;
  }
  
  protected void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.C.setOnClickListener(new RobotChatPie.1(this));
  }
  
  protected AIOContext d()
  {
    return new RobotContext();
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
    if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
      localRobotChatUIHelper.f();
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_invoke_troop_robot_function");
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.a(new AIOShortcutBarHelper.AIOShortcutBarEvent(20, paramIntent));
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("leftBackEvent begin:");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "no confirm dialog");
    }
    super.f(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "RobotChatPie";
  }
  
  protected void k(int paramInt)
  {
    super.k(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.d(21);
    }
  }
  
  protected void l()
  {
    super.l();
    bF();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433920)
    {
      RobotChatUIHelper localRobotChatUIHelper = (RobotChatUIHelper)q(36);
      if ((localRobotChatUIHelper != null) && (localRobotChatUIHelper.e())) {
        if (this.Y.getText().length() <= 0)
        {
          localRobotChatUIHelper.b(false);
          ReportController.b(this.d, "dc00898", "", "", "0X800A487", "0X800A487", 0, 0, "", "", "", "");
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
  
  protected void z()
  {
    if (this.A != null)
    {
      this.A.setVisibility(4);
      ThreadManager.post(new RobotChatPie.2(this), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie
 * JD-Core Version:    0.7.0.1
 */