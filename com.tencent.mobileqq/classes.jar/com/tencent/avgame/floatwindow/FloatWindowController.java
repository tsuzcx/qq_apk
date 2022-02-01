package com.tencent.avgame.floatwindow;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.listener.GameRoomStatusListener;
import com.tencent.avgame.gamelogic.listener.GameStatusListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FloatWindowController
  implements CommonGameFloatWindowLayout.OnFloatWindowClickListener, FloatPositionChangeCallback, IGameFloatWindow.GameFloatWindowState, GameRoomStatusListener, GameStatusListener
{
  boolean a = true;
  boolean b = false;
  protected AppRuntime c;
  QQCustomDialog d;
  Runnable e = new FloatWindowController.1(this);
  boolean f = false;
  Application.ActivityLifecycleCallbacks g = new FloatWindowController.7(this);
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n = false;
  private int o = 0;
  private FloatWindowParams p = new FloatWindowParams();
  private CommonGameFloatWindowLayout q;
  private ValueAnimator r;
  private Runnable s = new FloatWindowController.6(this);
  private boolean t = false;
  private BroadcastReceiver u = new FloatWindowController.8(this);
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCommonGameState and state:  ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mCommonGameFloatWindowLayout ");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" mIsFloatWindowShowing ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" mFloatParams.isForeground ");
      localStringBuilder.append(this.p.a);
      QLog.i("FloatWindowController", 1, localStringBuilder.toString());
    }
    if ((this.q != null) && (this.n))
    {
      if (!this.p.a) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.q.c();
          }
        }
        else {
          this.q.b();
        }
      }
      else {
        this.q.a();
      }
      this.o = paramInt;
    }
  }
  
  private void a(String paramString, RoomInfo paramRoomInfo, GameRecordInfo paramGameRecordInfo)
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("enter_game_result", this.b);
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterAvGameActivity roomId ");
        localStringBuilder.append(paramString);
        QLog.d("FloatWindowController", 2, localStringBuilder.toString());
      }
      localIntent.putExtra("key_room_id", paramString);
      localIntent.putExtra("key_room_be_new_enter", false);
      if (paramRoomInfo != null)
      {
        paramString = new Bundle();
        paramString.putSerializable("key_room_info", paramRoomInfo);
        localIntent.putExtra("key_room_bundle", paramString);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("enterAvGameActivity roomInfo ");
          paramString.append(paramRoomInfo.toString());
          QLog.d("FloatWindowController", 2, paramString.toString());
        }
      }
      if (paramGameRecordInfo != null) {
        localIntent.putExtra("key_game_record_info", paramGameRecordInfo);
      }
      localIntent.putExtra("key_from_survival", IGameEngine.I().A());
      RouteUtils.a((Context)localObject, localIntent, "/business/avgame/avgameactivity");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FloatWindowController", 2, "returnBackAvGameActivity roomId empty");
    }
    QQToast.makeText((Context)localObject, 2131887368, 0).show();
    d();
  }
  
  private void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "showPermissionDialog in");
    }
    this.d = DialogUtil.a(paramActivity, 230).setMessage(2131887247).setNegativeButton(2131887410, new FloatWindowController.3(this, paramActivity)).setPositiveButton(2131887409, new FloatWindowController.2(this), false);
    this.d.setTitle(null);
    this.d.setCancelable(false);
    this.d.show();
    ReportController.b(null, "dc00898", "", "", "0X800B037", "0X800B037", 0, 0, "", "", "", "");
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "init()");
    }
    this.h = ViewUtils.getScreenWidth();
    this.i = ViewUtils.getScreenHeight();
    int i1 = ViewUtils.dip2px(10.0F);
    this.l = i1;
    this.j = i1;
    i1 = ViewUtils.dip2px(16.0F);
    this.m = i1;
    this.k = i1;
    FloatWindowParams localFloatWindowParams = this.p;
    localFloatWindowParams.a = true;
    this.n = false;
    localFloatWindowParams.b = -1000;
    localFloatWindowParams.c = -1000;
    this.c = paramAppRuntime;
    q();
  }
  
  public static FloatWindowController c()
  {
    return FloatWindowController.INNER.a;
  }
  
  private boolean m()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    if (this.q == null)
    {
      this.q = new CommonGameFloatWindowLayout((Context)localObject);
      this.q.setFloatPositionChangeCallback(this);
      this.q.setOnFloatWindowClickListener(this);
    }
    this.p.b = (this.l + this.q.getFloatWidth() / 2);
    this.p.c = (this.q.getFloatHeight() / 2 + ViewUtils.dip2px(115.0F));
    localObject = this.q;
    ((CommonGameFloatWindowLayout)localObject).a(((CommonGameFloatWindowLayout)localObject).a(this.p), this.q.b(this.p));
    return this.q.d();
  }
  
  private void n()
  {
    Object localObject = this.q;
    if (localObject != null) {
      ((CommonGameFloatWindowLayout)localObject).f();
    }
    localObject = this.r;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.r = null;
    }
  }
  
  private boolean o()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(this.c.getApp());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasFloatPermission, isOpEnable: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("FloatWindowController", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    return false;
  }
  
  private void p()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    int i1;
    int i2;
    if (localObject != null)
    {
      i1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      i2 = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      if (i1 != this.h) {
        this.h = i1;
      }
      if (i2 != this.i) {
        this.i = i2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCommonGameFloatWindow mScreenWidth: ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append("  mScreenHeight: ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(" mIsFloatWindowShowing: ");
      ((StringBuilder)localObject).append(this.n);
      QLog.d("FloatWindowController", 2, ((StringBuilder)localObject).toString());
    }
    if (this.n)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateCommonGameFloatWindow isForeground: ");
        ((StringBuilder)localObject).append(this.p.a);
        QLog.d("FloatWindowController", 2, ((StringBuilder)localObject).toString());
      }
      if (this.p.a)
      {
        int i3 = this.p.c;
        if (this.q.getFloatCenterX() < this.h / 2) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          i2 = this.l + this.q.getFloatWidth() / 2;
        } else {
          i2 = this.h - this.j - this.q.getFloatWidth() / 2;
        }
        if (i3 < this.m + this.q.getFloatHeight() / 2)
        {
          i1 = this.m + this.q.getFloatHeight() / 2;
        }
        else
        {
          i1 = i3;
          if (i3 > this.i - this.k - this.q.getFloatHeight() / 2) {
            i1 = this.i - this.k - this.q.getFloatHeight() / 2;
          }
        }
        localObject = this.p;
        ((FloatWindowParams)localObject).b = i2;
        ((FloatWindowParams)localObject).c = i1;
        e();
      }
      this.q.c(this.p);
    }
  }
  
  private void q()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      MobileQQ.getContext().registerReceiver(this.u, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    if (!this.f)
    {
      MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this.g);
      this.f = true;
    }
  }
  
  private void s()
  {
    if (this.f)
    {
      MobileQQ.sMobileQQ.unregisterActivityLifecycleCallbacks(this.g);
      this.f = false;
    }
  }
  
  private void t()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("key_from_survival", true);
    RouteUtils.a((Context)localObject, localIntent, "/business/avgame/avgameactivity");
  }
  
  public int a(Player paramPlayer)
  {
    if (paramPlayer == null) {
      return 0;
    }
    if (!IGameEngine.J())
    {
      EngineData localEngineData = IGameEngine.I().s();
      if (paramPlayer.status != 2) {
        return 0;
      }
      if (localEngineData.c(paramPlayer.uin)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onFloatWindowClick()");
    }
    if (!IGameEngine.J())
    {
      EngineData localEngineData = IGameEngine.I().s();
      long l1 = localEngineData.i();
      if ((localEngineData.M()) && (l1 == 0L))
      {
        t();
        return;
      }
      if (l1 == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FloatWindowController", 2, "onFloatWindowClick() roomId == 0, can not return AVGameActivity");
        }
        return;
      }
      a(String.valueOf(l1), localEngineData.e(), localEngineData.v());
      ReportController.b(null, "dc00898", "", "", "0X800B036", "0X800B036", a(localEngineData.q()) + 1, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.n)
    {
      int i1 = this.p.b;
      int i3 = this.p.c;
      paramInt1 = i1 - paramInt1;
      int i2 = this.h;
      i1 = 0;
      if (paramInt1 < 0) {
        paramInt1 = 0;
      } else if (paramInt1 > i2) {
        paramInt1 = i2;
      }
      paramInt2 = i3 - paramInt2;
      if (paramInt2 < 0)
      {
        paramInt2 = i1;
      }
      else
      {
        i1 = this.i;
        if (paramInt2 > i1) {
          paramInt2 = i1;
        }
      }
      FloatWindowParams localFloatWindowParams = this.p;
      localFloatWindowParams.b = paramInt1;
      localFloatWindowParams.c = paramInt2;
      CommonGameFloatWindowLayout localCommonGameFloatWindowLayout = this.q;
      localCommonGameFloatWindowLayout.a(localCommonGameFloatWindowLayout.a(localFloatWindowParams), this.q.b(this.p));
      this.q.d();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("onRoomOtherMemberExit exitType: ");
      paramEngineData.append(paramInt);
      paramEngineData.append(" kickUin:");
      paramEngineData.append(paramString1);
      paramEngineData.append(" exitRoomTip:");
      paramEngineData.append(paramString2);
      QLog.i("FloatWindowController", 2, paramEngineData.toString());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void a(long paramLong, String paramString1, String paramString2) {}
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(Activity paramActivity)
  {
    if (!o())
    {
      r();
      b(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFloatWindow called mIsFloatWindowShowing: ");
      localStringBuilder.append(this.n);
      QLog.i("FloatWindowController", 2, localStringBuilder.toString());
    }
    if (this.n) {
      return;
    }
    this.b = paramBoolean2;
    if (!o())
    {
      if (!paramBoolean1) {
        a(paramActivity);
      }
      return;
    }
    r();
    if (m())
    {
      this.n = true;
      f();
      if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramBoolean1)) {
        paramActivity.finish();
      }
      IGameEngine.I().a(this);
      IGameEngine.I().a(this);
      return;
    }
    QLog.e("FloatWindowController", 1, "showFloatWindowInner failed");
  }
  
  public void a(EngineData paramEngineData) {}
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onChangeUserStatusSuccess ");
    }
  }
  
  public void a(EngineData paramEngineData, String paramString) {}
  
  public void a(EngineData paramEngineData, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onGameOverPush");
    }
    f();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUserStatusFailed and errorMsg is ");
      localStringBuilder.append(paramString);
      QLog.i("FloatWindowController", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnChangeUserStatus");
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "onGameStartFail");
    }
  }
  
  public void a(String paramString, EngineData paramEngineData) {}
  
  public void a(HashMap<String, String> paramHashMap) {}
  
  public void a(AppRuntime paramAppRuntime)
  {
    b(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFloatParamsIsForeGround isForeground:");
      localStringBuilder.append(paramBoolean);
      QLog.d("FloatWindowController", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.s);
    if (paramBoolean)
    {
      ThreadManager.getUIHandlerV2().postDelayed(this.s, 500L);
      return;
    }
    this.p.a = paramBoolean;
    if (this.n) {
      p();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public boolean a(int paramInt, String paramString, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("receive onRoomSelfExit exitType:");
      paramEngineData.append(paramInt);
      paramEngineData.append(" exitRoomTip:");
      paramEngineData.append(paramString);
      QLog.i("FloatWindowController", 2, paramEngineData.toString());
    }
    d();
    return false;
  }
  
  public void b()
  {
    p();
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnGameChange");
    }
  }
  
  public void b(EngineData paramEngineData, int paramInt) {}
  
  public void b(String paramString, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive pushOnRoomEnter");
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void c(EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameStartSuc and engineData is ");
      localStringBuilder.append(paramEngineData);
      QLog.i("FloatWindowController", 2, localStringBuilder.toString());
    }
    f();
  }
  
  public void c(EngineData paramEngineData, int paramInt) {}
  
  public void c(String paramString, EngineData paramEngineData) {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "hideFloatWindow called");
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.e);
    n();
    this.n = false;
    s();
    IGameEngine.I().b(this);
    IGameEngine.I().b(this);
    QQCustomDialog localQQCustomDialog = this.d;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.d.dismiss();
      this.d = null;
    }
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void d(String paramString, EngineData paramEngineData) {}
  
  public void e()
  {
    ValueAnimator localValueAnimator = this.r;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.r = null;
    }
    int i1 = this.q.a(this.p);
    int i2 = this.q.b(this.p);
    int i3 = this.q.getCurrentX();
    int i4 = this.q.getCurrentY();
    if ((Math.abs(i3 - i1) < 10) && (Math.abs(i4 - i2) < 10))
    {
      this.q.a(i1, i2);
      return;
    }
    this.r = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.r.setInterpolator(new LinearInterpolator());
    this.r.setDuration(250L);
    this.r.addUpdateListener(new FloatWindowController.4(this, i3, i1, i4, i2));
    this.r.addListener(new FloatWindowController.5(this, i1, i2));
    this.r.start();
  }
  
  public void e(EngineData paramEngineData) {}
  
  public void e(String paramString, EngineData paramEngineData) {}
  
  public void f()
  {
    Player localPlayer;
    if (!IGameEngine.J()) {
      localPlayer = IGameEngine.I().s().q();
    } else {
      localPlayer = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 1, String.format("updateState self= %s", new Object[] { localPlayer }));
    }
    a(a(localPlayer));
  }
  
  public void f(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onGameStartPush");
    }
    f();
  }
  
  public void g()
  {
    d();
    Object localObject = this.q;
    if (localObject != null) {
      ((CommonGameFloatWindowLayout)localObject).g();
    }
    localObject = MobileQQ.sMobileQQ;
    MobileQQ.getContext().unregisterReceiver(this.u);
    s();
  }
  
  public void g(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onPlayerChangePush");
    }
    f();
  }
  
  public void h() {}
  
  public void h(EngineData paramEngineData) {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController
 * JD-Core Version:    0.7.0.1
 */