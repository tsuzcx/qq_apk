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
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new FloatWindowController.7(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new FloatWindowController.8(this);
  private CommonGameFloatWindowLayout jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
  private FloatWindowParams jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams = new FloatWindowParams();
  Runnable jdField_a_of_type_JavaLangRunnable = new FloatWindowController.1(this);
  protected AppRuntime a;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new FloatWindowController.6(this);
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private int f;
  private int g = 0;
  
  public static FloatWindowController a()
  {
    return FloatWindowController.INNER.a;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCommonGameState and state:  ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mCommonGameFloatWindowLayout ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout);
      localStringBuilder.append(" mIsFloatWindowShowing ");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(" mFloatParams.isForeground ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Boolean);
      QLog.i("FloatWindowController", 1, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout != null) && (this.jdField_d_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Boolean) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c();
          }
        }
        else {
          this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b();
        }
      }
      else {
        this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
      }
      this.g = paramInt;
    }
  }
  
  private void a(String paramString, RoomInfo paramRoomInfo, GameRecordInfo paramGameRecordInfo)
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("enter_game_result", this.jdField_b_of_type_Boolean);
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
      localIntent.putExtra("key_from_survival", IGameEngine.a().f());
      RouteUtils.a((Context)localObject, localIntent, "/business/avgame/avgameactivity");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FloatWindowController", 2, "returnBackAvGameActivity roomId empty");
    }
    QQToast.a((Context)localObject, 2131690457, 0).a();
    c();
  }
  
  private boolean a()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout == null)
    {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout = new CommonGameFloatWindowLayout((Context)localObject);
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.setFloatPositionChangeCallback(this);
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.setOnFloatWindowClickListener(this);
    }
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Int = (this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2);
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2 + ViewUtils.a(115.0F));
    localObject = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
    ((CommonGameFloatWindowLayout)localObject).a(((CommonGameFloatWindowLayout)localObject).a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams), this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams));
    return this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
  }
  
  private void b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "showPermissionDialog in");
    }
    paramActivity = DialogUtil.a(paramActivity, 230).setMessage(2131690336).setNegativeButton(2131690499, new FloatWindowController.3(this, paramActivity)).setPositiveButton(2131690498, new FloatWindowController.2(this), false);
    paramActivity.setTitle(null);
    paramActivity.setCancelable(false);
    paramActivity.show();
    ReportController.b(null, "dc00898", "", "", "0X800B037", "0X800B037", 0, 0, "", "", "", "");
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "init()");
    }
    this.jdField_a_of_type_Int = ViewUtils.a();
    this.jdField_b_of_type_Int = ViewUtils.b();
    int i = ViewUtils.a(10.0F);
    this.jdField_e_of_type_Int = i;
    this.jdField_c_of_type_Int = i;
    i = ViewUtils.a(16.0F);
    this.f = i;
    this.jdField_d_of_type_Int = i;
    FloatWindowParams localFloatWindowParams = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams;
    localFloatWindowParams.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    localFloatWindowParams.jdField_a_of_type_Int = -1000;
    localFloatWindowParams.jdField_b_of_type_Int = -1000;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    n();
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localObject != null) && (((AppRuntime)localObject).getApp() != null))
    {
      boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(this.jdField_a_of_type_MqqAppAppRuntime.getApp());
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
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
    if (localObject != null) {
      ((CommonGameFloatWindowLayout)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void m()
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = MobileQQ.getContext();
    int i;
    int j;
    if (localObject != null)
    {
      i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      if (i != this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = i;
      }
      if (j != this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCommonGameFloatWindow mScreenWidth: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("  mScreenHeight: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" mIsFloatWindowShowing: ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
      QLog.d("FloatWindowController", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateCommonGameFloatWindow isForeground: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Boolean);
        QLog.d("FloatWindowController", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Boolean)
      {
        int k = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_b_of_type_Int;
        if (this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a() < this.jdField_a_of_type_Int / 2) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          j = this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2;
        } else {
          j = this.jdField_a_of_type_Int - this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b() / 2;
        }
        if (k < this.f + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2)
        {
          i = this.f + this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2;
        }
        else
        {
          i = k;
          if (k > this.jdField_b_of_type_Int - this.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2) {
            i = this.jdField_b_of_type_Int - this.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.c() / 2;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams;
        ((FloatWindowParams)localObject).jdField_a_of_type_Int = j;
        ((FloatWindowParams)localObject).jdField_b_of_type_Int = i;
        d();
      }
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams);
    }
  }
  
  private void n()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      MobileQQ.sMobileQQ.registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  private void p()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      MobileQQ.sMobileQQ.unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void q()
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
    if (!IGameEngine.k())
    {
      EngineData localEngineData = IGameEngine.a().a();
      if (paramPlayer.status != 2) {
        return 0;
      }
      if (localEngineData.a(paramPlayer.uin)) {
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
    if (!IGameEngine.k())
    {
      EngineData localEngineData = IGameEngine.a().a();
      long l = localEngineData.a();
      if ((localEngineData.f()) && (l == 0L))
      {
        q();
        return;
      }
      if (l == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FloatWindowController", 2, "onFloatWindowClick() roomId == 0, can not return AVGameActivity");
        }
        return;
      }
      a(String.valueOf(l), localEngineData.a(), localEngineData.a());
      ReportController.b(null, "dc00898", "", "", "0X800B036", "0X800B036", a(localEngineData.a()) + 1, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_b_of_type_Int;
      paramInt1 = i - paramInt1;
      int j = this.jdField_a_of_type_Int;
      i = 0;
      if (paramInt1 < 0) {
        paramInt1 = 0;
      } else if (paramInt1 > j) {
        paramInt1 = j;
      }
      paramInt2 = k - paramInt2;
      if (paramInt2 < 0)
      {
        paramInt2 = i;
      }
      else
      {
        i = this.jdField_b_of_type_Int;
        if (paramInt2 > i) {
          paramInt2 = i;
        }
      }
      FloatWindowParams localFloatWindowParams = this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams;
      localFloatWindowParams.jdField_a_of_type_Int = paramInt1;
      localFloatWindowParams.jdField_b_of_type_Int = paramInt2;
      CommonGameFloatWindowLayout localCommonGameFloatWindowLayout = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
      localCommonGameFloatWindowLayout.a(localCommonGameFloatWindowLayout.a(localFloatWindowParams), this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams));
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a();
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
    if (!b())
    {
      o();
      b(paramActivity);
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showFloatWindow called mIsFloatWindowShowing: ");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      QLog.i("FloatWindowController", 2, localStringBuilder.toString());
    }
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean2;
    if (!b())
    {
      if (!paramBoolean1) {
        a(paramActivity);
      }
      return;
    }
    o();
    if (a())
    {
      this.jdField_d_of_type_Boolean = true;
      e();
      if ((paramActivity != null) && (!paramActivity.isFinishing()) && (!paramBoolean1)) {
        paramActivity.finish();
      }
      IGameEngine.a().a(this);
      IGameEngine.a().a(this);
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
    e();
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
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_d_of_type_Boolean) {
      m();
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
    c();
    return false;
  }
  
  public void b()
  {
    m();
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "hideFloatWindow called");
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    l();
    this.jdField_d_of_type_Boolean = false;
    p();
    IGameEngine.a().b(this);
    IGameEngine.a().b(this);
  }
  
  public void c(EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGameStartSuc and engineData is ");
      localStringBuilder.append(paramEngineData);
      QLog.i("FloatWindowController", 2, localStringBuilder.toString());
    }
    e();
  }
  
  public void c(EngineData paramEngineData, int paramInt) {}
  
  public void c(String paramString, EngineData paramEngineData) {}
  
  public void d()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int i = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams);
    int j = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.b(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowParams);
    int k = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.d();
    int m = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.e();
    if ((Math.abs(k - i) < 10) && (Math.abs(m - j) < 10))
    {
      this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout.a(i, j);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(250L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FloatWindowController.4(this, k, i, m, j));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new FloatWindowController.5(this, i, j));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void d(EngineData paramEngineData) {}
  
  public void d(String paramString, EngineData paramEngineData) {}
  
  public void e()
  {
    Player localPlayer;
    if (!IGameEngine.k()) {
      localPlayer = IGameEngine.a().a().a();
    } else {
      localPlayer = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 1, String.format("updateState self= %s", new Object[] { localPlayer }));
    }
    a(a(localPlayer));
  }
  
  public void e(EngineData paramEngineData) {}
  
  public void e(String paramString, EngineData paramEngineData) {}
  
  public void f()
  {
    c();
    Object localObject = this.jdField_a_of_type_ComTencentAvgameFloatwindowCommonGameFloatWindowLayout;
    if (localObject != null) {
      ((CommonGameFloatWindowLayout)localObject).e();
    }
    localObject = MobileQQ.sMobileQQ;
    MobileQQ.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    p();
  }
  
  public void f(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onGameStartPush");
    }
    e();
  }
  
  public void g() {}
  
  public void g(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FloatWindowController", 2, "receive onPlayerChangePush");
    }
    e();
  }
  
  public void h() {}
  
  public void h(EngineData paramEngineData) {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController
 * JD-Core Version:    0.7.0.1
 */