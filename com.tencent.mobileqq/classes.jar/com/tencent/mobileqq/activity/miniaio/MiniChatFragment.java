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
  private static boolean jdField_a_of_type_Boolean = false;
  private float jdField_a_of_type_Float = 0.85F;
  int jdField_a_of_type_Int;
  protected SessionInfo a;
  protected MiniPie a;
  
  public MiniChatFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  }
  
  private Window a(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private WindowManager a(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 28) {
      ReportHelperKt.a("0X800AFCE", ForegroundNotifyManager.a(getBaseActivity().app).a(paramInt1));
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  protected Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = a(getBaseActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = localDisplay.getWidth();
    float f4 = this.jdField_a_of_type_Float;
    f3 = (f1 - f3 * (1.0F - f4) / 2.0F) / f4;
    f4 = localDisplay.getHeight();
    float f5 = this.jdField_a_of_type_Float;
    paramMotionEvent.offsetLocation(f3 - f1, (f2 - f4 * (1.0F - f5) / 2.0F) / f5 - f2);
    if ((!super.dispatchTouchEvent(paramMotionEvent)) && (f2 > this.jdField_a_of_type_Int))
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
      Object localObject = a(paramActivity);
      ((Window)localObject).setFormat(-3);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      Display localDisplay = a(paramActivity).getDefaultDisplay();
      float f = a(paramActivity).getFloatExtra("minaio_height_ration", 0.56F);
      localLayoutParams.height = ((int)(localDisplay.getHeight() * f));
      this.jdField_a_of_type_Int = localLayoutParams.height;
      int i = a(paramActivity).getIntExtra("key_mini_from", 0);
      if ((i == 2) || (i == 5))
      {
        localLayoutParams.gravity = 49;
        localLayoutParams.y = ImmersiveUtils.getStatusBarHeight(paramActivity);
      }
      ((Window)localObject).setAttributes(localLayoutParams);
      localObject = ((Window)localObject).getDecorView();
      if (MiniPieHelper.a())
      {
        this.jdField_a_of_type_Float = a(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
        ((View)localObject).setScaleX(this.jdField_a_of_type_Float);
        ((View)localObject).setScaleY(this.jdField_a_of_type_Float);
        QLog.i("MiniChatFragment", 2, "surport scale ");
        return;
      }
      this.jdField_a_of_type_Float = 1.0F;
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
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.r();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramBundle.getIntExtra("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramBundle.getStringExtra("uinname");
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      boolean bool = true;
      if ((i == 1) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)))
      {
        localObject2 = (TroopManager)getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((TroopManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject2 != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((TroopInfo)localObject2).troopname;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = paramBundle.getIntExtra("key_mini_from", 0);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850373);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131165321);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Long = paramBundle.getLongExtra("key_mini_aio_msg_shmsgseq", 0L);
      i = paramBundle.getIntExtra("key_mini_from", 0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i != 5) {
        bool = false;
      }
      ((SessionInfo)localObject2).m = bool;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramBundle.getLongExtra("key_mini_aio_barrage_time_location", 0L);
      i = paramBundle.getIntExtra("key_mini_msgtab_businame", 0);
      if (i > 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null) {
          paramBundle = new Bundle();
        }
        paramBundle.putInt("key_mini_msgtab_businame", i);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(paramBundle);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie = MiniPieFactory.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, getBaseActivity().app);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie == null)
      {
        getBaseActivity().finish();
        paramLayoutInflater = localObject1;
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, i);
        paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a(paramLayoutInflater, null, paramViewGroup);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.a();
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
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.p();
    }
  }
  
  public void onFinish()
  {
    if (a(getBaseActivity()).getIntExtra("key_mini_exit_anim", 0) == 1) {
      getBaseActivity().overridePendingTransition(0, 2130772009);
    }
    super.onFinish();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (paramIntent != null) {
      paramIntent.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.m();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.k();
    }
  }
  
  public void onStart()
  {
    a(true);
    super.onStart();
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.n();
    }
  }
  
  public void onStop()
  {
    a(false);
    super.onStop();
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.o();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniPie localMiniPie = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
    if (localMiniPie != null) {
      localMiniPie.c(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragment
 * JD-Core Version:    0.7.0.1
 */