package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniChatFragment
  extends PublicBaseFragment
{
  private static boolean e = false;
  protected SessionInfo a = new SessionInfo();
  protected MiniPie b;
  int c;
  private float d = 0.85F;
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 28) {
      ReportHelperKt.a("0X800AFCE", ForegroundNotifyManager.a(getBaseActivity().app).b(paramInt1));
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return e;
  }
  
  private Window b(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private WindowManager c(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  protected Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  public SessionInfo b()
  {
    return this.a;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = c(getBaseActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = localDisplay.getWidth();
    float f4 = this.d;
    f3 = (f1 - f3 * (1.0F - f4) / 2.0F) / f4;
    f4 = localDisplay.getHeight();
    float f5 = this.d;
    paramMotionEvent.offsetLocation(f3 - f1, (f2 - f4 * (1.0F - f5) / 2.0F) / f5 - f2);
    if ((!super.dispatchTouchEvent(paramMotionEvent)) && (f2 > this.c))
    {
      getBaseActivity().finish();
      return true;
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    try
    {
      Object localObject = b(paramActivity);
      ((Window)localObject).setFormat(-3);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      Display localDisplay = c(paramActivity).getDefaultDisplay();
      float f = a(paramActivity).getFloatExtra("minaio_height_ration", 0.56F);
      localLayoutParams.height = ((int)(localDisplay.getHeight() * f));
      this.c = localLayoutParams.height;
      int i = a(paramActivity).getIntExtra("key_mini_from", 0);
      if ((i == 2) || (i == 5))
      {
        localLayoutParams.gravity = 49;
        localLayoutParams.y = ImmersiveUtils.getStatusBarHeight(paramActivity);
      }
      ((Window)localObject).setAttributes(localLayoutParams);
      localObject = ((Window)localObject).getDecorView();
      if (MiniPieHelper.e())
      {
        this.d = a(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
        ((View)localObject).setScaleX(this.d);
        ((View)localObject).setScaleY(this.d);
        QLog.i("MiniChatFragment", 2, "surport scale ");
        return;
      }
      this.d = 1.0F;
      QLog.i("MiniChatFragment", 2, "not surport scale ");
      return;
    }
    catch (Throwable paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MiniChatFragment", 1, "initWindowStyleAndAnimation ", paramActivity);
      }
    }
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.t();
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramBundle = getBaseActivity().app;
    Object localObject1 = null;
    if (paramBundle == null)
    {
      paramLayoutInflater = localObject1;
    }
    else
    {
      paramBundle = a(getBaseActivity());
      this.a.b = paramBundle.getStringExtra("uin");
      this.a.a = paramBundle.getIntExtra("uintype", -1);
      this.a.e = paramBundle.getStringExtra("uinname");
      int i = this.a.a;
      boolean bool = true;
      if ((i == 1) && (TextUtils.isEmpty(this.a.e)))
      {
        localObject2 = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((TroopManager)localObject2).g(this.a.b);
          if (localObject2 != null) {
            this.a.e = ((TroopInfo)localObject2).troopname;
          }
        }
      }
      this.a.B = paramBundle.getIntExtra("key_mini_from", 0);
      Object localObject2 = this.a;
      ((SessionInfo)localObject2).c = ((SessionInfo)localObject2).b;
      this.a.H = new ChatBackground();
      this.a.H.c = getResources().getDrawable(2130852164);
      this.a.H.b = getResources().getColorStateList(2131165558);
      this.a.r = ChatTextSizeSettingActivity.a(getBaseActivity());
      this.a.D = paramBundle.getLongExtra("key_mini_aio_msg_shmsgseq", 0L);
      i = paramBundle.getIntExtra("key_mini_from", 0);
      localObject2 = this.a;
      if (i != 5) {
        bool = false;
      }
      ((SessionInfo)localObject2).F = bool;
      this.a.E = paramBundle.getLongExtra("key_mini_aio_barrage_time_location", 0L);
      i = paramBundle.getIntExtra("key_mini_msgtab_businame", 0);
      if (i > 0)
      {
        localObject2 = this.a.b();
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null) {
          paramBundle = new Bundle();
        }
        paramBundle.putInt("key_mini_msgtab_businame", i);
        this.a.a(paramBundle);
      }
      this.b = MiniPieFactory.a(getBaseActivity(), this.a, getBaseActivity().app);
      if (this.b == null)
      {
        getBaseActivity().finish();
        paramLayoutInflater = localObject1;
      }
      else
      {
        a(this.a.a, i);
        paramLayoutInflater = this.b.a(paramLayoutInflater, null, paramViewGroup);
        this.b.a();
        if (paramLayoutInflater == null)
        {
          getBaseActivity().finish();
          paramLayoutInflater = localObject1;
        }
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.r();
    }
  }
  
  public void onFinish()
  {
    if (a(getBaseActivity()).getIntExtra("key_mini_exit_anim", 0) == 1) {
      getBaseActivity().overridePendingTransition(0, 2130772012);
    }
    super.onFinish();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.b;
    if (paramIntent != null) {
      paramIntent.l();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.o();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.m();
    }
  }
  
  public void onStart()
  {
    a(true);
    super.onStart();
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.p();
    }
  }
  
  public void onStop()
  {
    a(false);
    super.onStop();
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.q();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniPie localMiniPie = this.b;
    if (localMiniPie != null) {
      localMiniPie.c(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragment
 * JD-Core Version:    0.7.0.1
 */