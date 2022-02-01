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
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SimpleModeHelper;
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
  protected boolean bi = false;
  protected TroopFeedsCenterLogic bj = null;
  protected ViewTreeObserver.OnGlobalLayoutListener bk;
  protected boolean bl = false;
  protected boolean bm = false;
  protected boolean bn = false;
  protected long bo;
  public TroopAioTips bp;
  public ProxyObserver bq = new BaseTroopChatPie.2(this);
  
  public BaseTroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  protected void D()
  {
    if ((!this.bm) && (!this.bn))
    {
      a(this.u, 2130852263, 2130852264);
      return;
    }
    this.u.setImageResource(2130844774);
  }
  
  protected void E()
  {
    String str = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
    this.ah.e = str;
  }
  
  @TargetApi(16)
  public void K()
  {
    if (this.aY)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "hasDestory = true return");
      }
      return;
    }
    Object localObject = this.bp;
    if (localObject != null) {
      ((TroopAioTips)localObject).v();
    }
    localObject = this.bj;
    if (localObject != null)
    {
      ((TroopFeedsCenterLogic)localObject).d();
      this.bj = null;
    }
    if (Build.VERSION.SDK_INT < 16) {
      this.Y.getViewTreeObserver().removeGlobalOnLayoutListener(this.bk);
    } else {
      this.Y.getViewTreeObserver().removeOnGlobalLayoutListener(this.bk);
    }
    this.bk = null;
    bz();
    this.j.d().a(false);
    super.K();
  }
  
  public void O()
  {
    if (!this.aY)
    {
      Object localObject = (TroopAioNavigateBarManager)this.d.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      if (localObject != null)
      {
        ((TroopAioNavigateBarManager)localObject).c(this.ah.b, 0);
        localObject = this.bp;
        if (localObject != null)
        {
          localObject = ((TroopAioTips)localObject).t();
          if (localObject != null) {
            ((TroopAioMsgNavigateBar)localObject).f.set(false);
          }
        }
      }
    }
    super.O();
  }
  
  public void P()
  {
    super.P();
    TroopAioTips localTroopAioTips = this.bp;
    if (localTroopAioTips != null) {
      localTroopAioTips.r();
    }
  }
  
  public void S()
  {
    super.S();
    bA();
  }
  
  public boolean V()
  {
    TroopAioTips localTroopAioTips = this.bp;
    if (localTroopAioTips != null) {
      localTroopAioTips.v();
    }
    return super.V();
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)q(53);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if ((localUnreadBackBottomHelper != null) && (localAIOShortcutBarHelper != null) && (localAIOShortcutBarHelper.v() == 0) && (localUnreadBackBottomHelper.c()))
    {
      localAIOShortcutBarHelper.d(9);
      localAIOShortcutBarHelper.d(21);
    }
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
  
  protected void a(Object paramObject)
  {
    paramObject = (AioAgent.Message)paramObject;
    if (paramObject != null)
    {
      if (QLog.isColorLevel())
      {
        String str = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleUpdateTroopAioAgentMessage: ");
        localStringBuilder.append(paramObject.a);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramObject.a == TroopAioAgent.a)
      {
        this.j.d().a(paramObject.e, paramObject.a(), paramObject.f);
        return;
      }
      if (paramObject.a == TroopAioAgent.b) {
        ((AudioPanelAioHelper)q(128)).k(paramObject.b);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (((TroopGagMgr)this.d.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.ah.b, true).b) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if ((this.n.getCurrentPanel() == 2) && (this.d.getApplication().getResources().getConfiguration().orientation == 2)) {
        this.n.b();
      }
      if (this.ah.z)
      {
        if ("0".equals(paramString1))
        {
          BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
          return;
        }
        this.ah.A = paramString1;
        this.j.f().b(131078);
        j(this.j.f().d());
        this.Z.setText(HardCodeUtil.a(2131899290));
        this.m.postDelayed(new BaseTroopChatPie.4(this), 200L);
        return;
      }
      this.m.postDelayed(new BaseTroopChatPie.5(this, paramBoolean, paramString1, paramString2, paramInt), 300L);
      return;
    }
    if (this.ah.z) {
      BaseChatpieHelper.a(this.ah, this.Y, this.Z, false);
    }
  }
  
  public RecordParams.RecorderParam aU()
  {
    boolean bool = ((AudioPanelProvider)this.ae.f(2)).e();
    return RecordParams.b(this.d, bool);
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    if (this.bm)
    {
      this.X.getBackground().setVisible(true, false);
      this.X.findViewById(2131446058).setVisibility(8);
    }
    int i = paramIntent.getIntExtra("input_panel_status", 0);
    if (i > 0) {
      this.n.a(i, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.I.getVisibility() == 8))
    {
      this.I.setVisibility(0);
      G();
      H();
      return;
    }
    if ((!paramBoolean) && (this.I.getVisibility() == 0) && (!this.bm))
    {
      this.I.setVisibility(8);
      G();
      H();
    }
  }
  
  public void bA()
  {
    this.bo = System.currentTimeMillis();
    this.u.setContentDescription(this.f.getString(2131917519));
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->current AIO info<--- onresume. troopUin:");
      localStringBuilder.append(this.ah.c);
      localStringBuilder.append(",curFriendUin:");
      localStringBuilder.append(this.ah.b);
      localStringBuilder.append(",type:");
      localStringBuilder.append(this.ah.a);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  protected void bB()
  {
    this.j.d().a(this, this.o, this.V);
    this.au = this.j.d().e;
    this.bp = ((TroopAioTips)this.j.d().e);
    bC();
  }
  
  void bC()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "handleGrayTipsMsg");
    }
    Object localObject = (TroopTipsMsgMgr)this.d.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "troopTipsMsgMgr == null");
      }
      return;
    }
    if ((this.ah.a == 1) && (((TroopTipsMsgMgr)localObject).a(this.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.c, 2, "troopAIO has unread troopTipMsg");
      }
      localObject = new BaseTroopChatPie.3(this, (TroopTipsMsgMgr)localObject);
      ThreadManager.getSubThreadHandler().post((Runnable)localObject);
    }
  }
  
  public void bD()
  {
    f(true);
  }
  
  public boolean bE()
  {
    return this.aY;
  }
  
  protected boolean bF()
  {
    return false;
  }
  
  public boolean bG()
  {
    return this.bm;
  }
  
  protected void bz()
  {
    m(0);
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new BaseTroopMessageSender(this.i)).a();
  }
  
  protected void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("uinname");
    if (paramIntent != null) {
      this.ah.e = paramIntent;
    } else {
      E();
    }
    this.C.setText(new ColorNickText(this.ah.e, 32).b());
    if (AppSetting.e)
    {
      paramIntent = this.C.getText().toString();
      this.C.setContentDescription(paramIntent);
      aX().setTitle(this.C.getText());
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool = super.c(paramMotionEvent);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if ((localAIOShortcutBarHelper != null) && (localAIOShortcutBarHelper.a(paramMotionEvent))) {
      return false;
    }
    return bool;
  }
  
  protected AIOContext d()
  {
    return new BaseTroopAIOContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new BaseTroopScroller()).a(new BaseTroopListUI(this.i)).a(new UnreadTask(this.i)).a();
  }
  
  public void f(boolean paramBoolean)
  {
    TroopAioTips localTroopAioTips = this.bp;
    if (localTroopAioTips != null) {
      localTroopAioTips.v();
    }
    super.f(paramBoolean);
  }
  
  public boolean f(int paramInt)
  {
    TroopAioTips localTroopAioTips = this.bp;
    if (localTroopAioTips != null) {
      localTroopAioTips.v();
    }
    return super.f(paramInt);
  }
  
  protected void h()
  {
    this.c = "BaseTroopChatPie";
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.ah.a != 1) {
      return;
    }
    if ((this.n.getCurrentPanel() == 0) || (paramBoolean))
    {
      TroopFeedsCenterLogic localTroopFeedsCenterLogic = this.bj;
      if ((localTroopFeedsCenterLogic != null) && (localTroopFeedsCenterLogic.a())) {
        this.bj.c();
      }
    }
  }
  
  protected void k(int paramInt)
  {
    super.k(paramInt);
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null)
    {
      localAIOShortcutBarHelper.d(21);
      localAIOShortcutBarHelper.d(9);
    }
  }
  
  protected void l()
  {
    super.l();
    if (this.bk != null)
    {
      this.bk = new BaseTroopChatPie.1(this);
      this.Y.getViewTreeObserver().addOnGlobalLayoutListener(this.bk);
    }
    this.C.setTextColor(this.f.getResources().getColor(2131167990));
    SimpleModeHelper.a(this.I, this.f);
    this.s.setTextColor(this.f.getResources().getColor(2131167987));
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.d(17);
    }
    this.j.d().a(true);
    this.j.d().g();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.U.getFooterViewsCount();
    int j = this.U.getHeaderViewsCount();
    TroopAioTips localTroopAioTips = this.bp;
    if (localTroopAioTips != null) {
      localTroopAioTips.a(paramInt1, paramInt2, paramInt3, i, j);
    }
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  protected void q()
  {
    super.q();
    this.P = false;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (paramObject == null)
    {
      ((AttentionHeadMsgRefresher)this.j.a().a(17)).a(this.i);
      return;
    }
    if ((paramObject instanceof AioAgent.Message)) {
      a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie
 * JD-Core Version:    0.7.0.1
 */