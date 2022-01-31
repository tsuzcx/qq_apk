package com.tencent.mobileqq.activity.miniaio;

import aemb;
import aifb;
import aifi;
import aifp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniChatFragment
  extends PublicBaseFragment
{
  private float jdField_a_of_type_Float = 0.85F;
  int jdField_a_of_type_Int;
  protected aifb a;
  protected SessionInfo a;
  
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
    Display localDisplay = a(getActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent.offsetLocation((f1 - localDisplay.getWidth() * (1.0F - this.jdField_a_of_type_Float) / 2.0F) / this.jdField_a_of_type_Float - f1, (f2 - localDisplay.getHeight() * (1.0F - this.jdField_a_of_type_Float) / 2.0F) / this.jdField_a_of_type_Float - f2);
    if ((!super.dispatchTouchEvent(paramMotionEvent)) && (f2 > this.jdField_a_of_type_Int))
    {
      getActivity().finish();
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
      if (aifp.a())
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
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.r();
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {
      paramLayoutInflater = null;
    }
    do
    {
      return paramLayoutInflater;
      paramBundle = a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramBundle.getIntExtra("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramBundle.getStringExtra("uinname");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)))
      {
        localObject = (TroopManager)getActivity().app.getManager(52);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((TroopInfo)localObject).troopname;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = paramBundle.getIntExtra("key_mini_from", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb = new aemb();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849402);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131165304);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Long = paramBundle.getLongExtra("key_mini_aio_msg_shmsgseq", 0L);
      int i = paramBundle.getIntExtra("key_mini_from", 0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i == 5) {}
      for (boolean bool = true;; bool = false)
      {
        ((SessionInfo)localObject).m = bool;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c = paramBundle.getLongExtra("key_mini_aio_barrage_time_location", 0L);
        i = paramBundle.getIntExtra("key_mini_msgtab_businame", 0);
        if (i > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = new Bundle();
          }
          paramBundle.putInt("key_mini_msgtab_businame", i);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(paramBundle);
        }
        this.jdField_a_of_type_Aifb = aifi.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, getActivity().app);
        if (this.jdField_a_of_type_Aifb != null) {
          break;
        }
        getActivity().finish();
        return null;
      }
      paramViewGroup = this.jdField_a_of_type_Aifb.a(paramLayoutInflater, null, paramViewGroup);
      this.jdField_a_of_type_Aifb.a();
      paramLayoutInflater = paramViewGroup;
    } while (paramViewGroup != null);
    getActivity().finish();
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.p();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.m();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.k();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.n();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.o();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Aifb != null) {
      this.jdField_a_of_type_Aifb.c(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragment
 * JD-Core Version:    0.7.0.1
 */