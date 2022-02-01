package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.ui.IChatPieApolloViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ILeftAppShortBarDataUI;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.LeftAppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.IAppShortcutBarDataUI;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopAppShortcutBarHelper
{
  public AppShortcutBarScrollView a;
  public View b;
  protected boolean c;
  protected IAIOShortcutBarLogic d;
  protected AIOShortcutBarContext e;
  protected Context f;
  protected AppRuntime g;
  protected Activity h;
  protected SessionInfo i;
  protected boolean j = false;
  private boolean k;
  private boolean l = false;
  private long m;
  private String n;
  private ILeftAppShortBarDataUI o;
  private IAppShortcutBarDataUI p;
  private IShortcutBarDataProvider q;
  private DrawerFrame.TouchEventConsumer r = new TroopAppShortcutBarHelper.2(this);
  
  public TroopAppShortcutBarHelper(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    this.d = paramIAIOShortcutBarLogic;
    this.e = paramIAIOShortcutBarLogic.a();
    paramIAIOShortcutBarLogic = this.e;
    if (paramIAIOShortcutBarLogic != null)
    {
      this.f = paramIAIOShortcutBarLogic.e();
      this.g = this.e.c();
      this.h = this.e.f();
      this.i = this.e.d();
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "resetBlurViewTopMargin");
    }
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((AIOShortcutBarContext)localObject).i();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.e.a((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic is null");
      }
      return;
    }
    this.e = ((IAIOShortcutBarLogic)localObject).a();
    localObject = this.e;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic getAIOShortcutBarContext is null");
      }
      return;
    }
    if (((AIOShortcutBarContext)localObject).c() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init logic AppRuntime is null");
      }
      return;
    }
    this.m = t();
    this.n = String.valueOf(this.m);
    if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShortcutBarAioHelper.init mTroopUinStr: ");
      ((StringBuilder)localObject).append(this.n);
      QLog.e("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      this.a = ((AppShortcutBarScrollView)View.inflate(this.f, 2131624074, null));
      if (this.a != null) {
        this.b = this.a.findViewById(2131439811);
      }
      localObject = this.a;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.init mAppShortcutBarView is null");
        }
        return;
      }
      this.o = new LeftAppShortcutBarPanel(this.e, (AppShortcutBarScrollView)localObject, this);
      this.p = new AppShortcutBarPanel(this.e, this.a, this);
      this.q = new ShortBarDataProvider(this.e, this);
      this.a.setOnScrollChangedListener(new TroopAppShortcutBarHelper.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "initData.");
      }
      this.a.setMove(true);
      return;
    }
    catch (InflateException localInflateException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortcutBarAioHelper.init got InflateException, e:");
        localStringBuilder.append(localInflateException.getMessage());
        QLog.e("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
      }
      this.a = null;
      System.gc();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShortcutBarAioHelper.init got OOM, e:");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.e("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
      }
      this.a = null;
      System.gc();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      if (paramBundle != null) {
        this.j = paramBundle.getBoolean("InputJump", this.j);
      }
      m();
      return;
    case 10: 
      r();
      return;
    case 9: 
      q();
      return;
    case 8: 
      h();
      return;
    case 7: 
      a(false);
      return;
    case 6: 
      a(true);
      return;
    case 5: 
    case 11: 
      if (paramBundle != null) {
        this.j = paramBundle.getBoolean("InputJump", this.j);
      }
      o();
      return;
    case 4: 
      g();
      return;
    case 3: 
      e();
      return;
    case 2: 
      d();
      return;
    }
    f();
  }
  
  public void a(int paramInt, ArrayList<ShortcutBarInfo> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdatePanel from: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("bShowManageBtn");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a != null) && (this.o != null) && (this.p != null) && (this.b != null))
    {
      if (paramInt == 0)
      {
        if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.o.e())) {
          this.b.setVisibility(0);
        } else {
          this.b.setVisibility(8);
        }
      }
      else if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.p.f())) {
        this.b.setVisibility(0);
      } else {
        this.b.setVisibility(8);
      }
      if (paramInt == 0)
      {
        localObject = this.p;
        if (localObject != null) {
          ((IAppShortcutBarDataUI)localObject).a(paramArrayList, paramBoolean);
        }
      }
      else if (paramInt == 1)
      {
        localObject = this.o;
        if (localObject != null) {
          ((ILeftAppShortBarDataUI)localObject).a(paramArrayList);
        }
      }
    }
    else
    {
      paramArrayList = this.b;
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      IShortcutBarDataProvider localIShortcutBarDataProvider = this.q;
      if (localIShortcutBarDataProvider == null) {
        return;
      }
      localIShortcutBarDataProvider.b(paramView.getTag());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAIOIceBreakViewShowingStatus isShow = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
    }
    this.c = paramBoolean;
    if (paramBoolean)
    {
      o();
      return;
    }
    m();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((u()) && (this.a != null))
    {
      if (paramMotionEvent == null) {
        return false;
      }
      int i1 = (int)(paramMotionEvent.getX() + 0.5F);
      int i2 = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      this.a.getLocationOnScreen(paramMotionEvent);
      if (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + this.a.getWidth(), paramMotionEvent[1] + this.a.getHeight()).contains(i1, i2)) {
        return true;
      }
    }
    return false;
  }
  
  public View b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public ViewGroup.LayoutParams c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(2, 2131435809);
    return localLayoutParams;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieShowFirstBegin");
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).d();
    }
    localObject = this.p;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).d();
    }
    localObject = this.q;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).d();
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieResume");
    }
    if (this.l) {
      this.l = false;
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).c();
    }
    localObject = this.p;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).c();
    }
    localObject = this.q;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).c();
    }
  }
  
  void f()
  {
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieCreate");
    }
    a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("robot: init Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l1);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    long l2 = SystemClock.uptimeMillis();
    localObject = this.e;
    if (localObject != null) {
      ((AIOShortcutBarContext)localObject).a(this.r);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: addTouchEventConsumer Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.o;
    if (localObject != null) {
      ((ILeftAppShortBarDataUI)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mLeftAppPanel Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.p;
    if (localObject != null) {
      ((IAppShortcutBarDataUI)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mAppPanel Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = this.q;
    if (localObject != null) {
      ((IShortcutBarDataProvider)localObject).b();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: mProvider Time = ");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l2);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    l2 = SystemClock.uptimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopApp: AllTime = ");
    ((StringBuilder)localObject).append(l2 - l1);
    ((StringBuilder)localObject).append("ms");
    QLog.i("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.onChatPieDestroy");
    }
    Object localObject = this.o;
    if (localObject != null)
    {
      ((ILeftAppShortBarDataUI)localObject).a();
      this.o = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((IAppShortcutBarDataUI)localObject).a();
      this.p = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((IShortcutBarDataProvider)localObject).a();
      this.q = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "onChatPieDestroy. ");
    }
    o();
    x();
    localObject = this.a;
    if (localObject != null)
    {
      ((AppShortcutBarScrollView)localObject).fullScroll(17);
      this.a.removeAllViews();
      if ((this.a.getParent() != null) && ((this.a.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.a.getParent()).removeView(this.a);
      }
      this.a = null;
    }
    localObject = this.e;
    if (localObject != null) {
      ((AIOShortcutBarContext)localObject).b(this.r);
    }
    this.b = null;
    this.l = false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.setBlurViewLayout");
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.i();
    Object localObject = i();
    int i2 = 0;
    int i1;
    if ((localObject != null) && (i().isShown()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with scroll_panel_app_shorts");
      }
      i1 = ViewUtils.dip2px(39.0F);
      boolean bool = AnonymousChatHelper.a().a(this.n);
      if ((!ThemeUtil.isSimpleDayTheme(false)) && (!bool))
      {
        if (ThemeUtil.isInNightMode(this.g)) {
          i().setBackgroundColor(-16777216);
        } else {
          i().setBackgroundResource(0);
        }
      }
      else if (SimpleModeHelper.a())
      {
        i().setBackgroundResource(2130851968);
        i1 = i2;
      }
      else
      {
        localObject = this.e.j();
        i1 = i2;
        if (localObject != null)
        {
          localObject = ((Drawable)localObject).getConstantState().newDrawable();
          i().setBackgroundDrawable((Drawable)localObject);
          i1 = i2;
        }
      }
    }
    else
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.mBottomBlurView algin with inputBar");
        i1 = i2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShortcutBarAioHelper.setBlurViewLayout marginTop = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("TroopAppShortcutBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (localLayoutParams != null)
    {
      localLayoutParams.topMargin = (i1 * -1);
      this.e.a(localLayoutParams);
    }
  }
  
  protected View i()
  {
    return this.a;
  }
  
  protected int j()
  {
    return 0;
  }
  
  protected int k()
  {
    return 0;
  }
  
  protected int l()
  {
    return 0;
  }
  
  public void m()
  {
    if (i() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar getShortCutBarContainerView is null");
      }
      return;
    }
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "ShortcutBarAioHelper.resumeAppShorcutBar return for AIOIceBreakViewShowing");
      }
      return;
    }
    if (this.d == null) {
      return;
    }
    if (this.j) {
      return;
    }
    Object localObject = (AIOShortcutBarHelper)this.e.a(52);
    if ((localObject != null) && (((AIOShortcutBarHelper)localObject).w())) {
      return;
    }
    localObject = (AIOLongShotHelper)this.e.a(15);
    if ((localObject != null) && (((AIOLongShotHelper)localObject).c())) {
      return;
    }
    localObject = (StickerRecHelper)this.e.a(14);
    if ((localObject != null) && (((StickerRecHelper)localObject).c())) {
      return;
    }
    if (n())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAppShortcutBarHelper", 2, "resumeAppShorcutBar");
      }
      i().setPadding(j(), l(), k(), 0);
      localObject = ((IApolloAIOHelper)QRoute.api(IApolloAIOHelper.class)).getChatPieApolloViewController();
      if (localObject != null) {
        ((IChatPieApolloViewController)localObject).b(2131445368);
      }
      h();
      b(true);
      this.e.g();
      this.e.h();
    }
  }
  
  protected boolean n()
  {
    return (u()) && (this.d.b(2));
  }
  
  public void o()
  {
    if (i() == null) {
      return;
    }
    if (i().getVisibility() == 8) {
      return;
    }
    if (this.d == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutBarHelper", 2, "hideAppShortcutBar");
    }
    boolean bool = i().isShown();
    if (p())
    {
      i().setPadding(j(), l(), k(), 0);
      h();
      if (bool) {
        b(true);
      }
      this.e.g();
      this.e.h();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      IShortcutBarDataProvider localIShortcutBarDataProvider = this.q;
      if (localIShortcutBarDataProvider == null) {
        return;
      }
      localIShortcutBarDataProvider.a(paramView.getTag());
    }
  }
  
  protected boolean p()
  {
    return this.d.a(2);
  }
  
  public void q()
  {
    if ((i() != null) && (i().getVisibility() == 0))
    {
      AIOShortcutBarContext localAIOShortcutBarContext = this.e;
      if (localAIOShortcutBarContext != null) {
        localAIOShortcutBarContext.p();
      }
    }
  }
  
  public void r()
  {
    if (i() == null) {
      return;
    }
    this.e.q();
  }
  
  public boolean s()
  {
    boolean bool = this.k;
    this.k = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triggerSyncOnce() syncOnce = ");
      localStringBuilder.append(bool);
      QLog.d("TroopAppShortcutBarHelper", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public long t()
  {
    SessionInfo localSessionInfo;
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie is null");
      }
    }
    else
    {
      localSessionInfo = this.e.d();
      if (localSessionInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo is null");
        }
      }
      else if (localSessionInfo.b == null)
      {
        if (!QLog.isColorLevel()) {
          break label105;
        }
        QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty mChatPie.sessionInfo.curFriendUin is null");
      }
    }
    try
    {
      long l1 = Long.parseLong(localSessionInfo.b);
      return l1;
    }
    catch (Exception localException)
    {
      label90:
      label105:
      break label90;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutBarHelper", 2, "getTroopUinNoEmpty is Exception");
    }
    return 0L;
  }
  
  public boolean u()
  {
    boolean bool1 = this.c;
    boolean bool2 = false;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAppShortcutBarHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
      return false;
    }
    ILeftAppShortBarDataUI localILeftAppShortBarDataUI = this.o;
    bool1 = bool2;
    if (localILeftAppShortBarDataUI != null)
    {
      bool1 = bool2;
      if (this.p != null) {
        if (!localILeftAppShortBarDataUI.e())
        {
          bool1 = bool2;
          if (!this.p.f()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String v()
  {
    return this.n;
  }
  
  public long w()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */