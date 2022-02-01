package com.tencent.mobileqq.activity.miniaio;

import afrb;
import akfg;
import akfn;
import akfu;
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
import anui;
import azcl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniChatFragment
  extends PublicBaseFragment
{
  private static boolean jdField_a_of_type_Boolean;
  private float jdField_a_of_type_Float = 0.85F;
  int jdField_a_of_type_Int;
  protected akfg a;
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
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 28) {
      azcl.a("0X800AFCE", anui.a(getActivity().app).a(paramInt1));
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
      if (akfu.a())
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
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.r();
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramBundle = a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = paramBundle.getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = paramBundle.getIntExtra("uintype", -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramBundle.getStringExtra("uinname");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick)))
      {
        localObject = (TroopManager)getActivity().app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = ((TroopInfo)localObject).troopname;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isFromForward = paramBundle.getIntExtra("key_mini_from", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg = new afrb();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850048);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList = getResources().getColorStateList(2131165351);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.miniMsgUniseq = paramBundle.getLongExtra("key_mini_aio_msg_shmsgseq", 0L);
      int i = paramBundle.getIntExtra("key_mini_from", 0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i == 5) {}
      for (boolean bool = true;; bool = false)
      {
        ((SessionInfo)localObject).isBarrageMsg = bool;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.miniMsgBarrageTimeLocation = paramBundle.getLongExtra("key_mini_aio_barrage_time_location", 0L);
        i = paramBundle.getIntExtra("key_mini_msgtab_businame", 0);
        if (i > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.getExtras();
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = new Bundle();
          }
          paramBundle.putInt("key_mini_msgtab_businame", i);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.setExtras(paramBundle);
        }
        this.jdField_a_of_type_Akfg = akfn.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, getActivity().app);
        if (this.jdField_a_of_type_Akfg != null) {
          break label415;
        }
        getActivity().finish();
        paramLayoutInflater = null;
        break;
      }
      label415:
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, i);
      paramViewGroup = this.jdField_a_of_type_Akfg.a(paramLayoutInflater, null, paramViewGroup);
      this.jdField_a_of_type_Akfg.a();
      paramLayoutInflater = paramViewGroup;
      if (paramViewGroup == null)
      {
        getActivity().finish();
        paramLayoutInflater = null;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.p();
    }
  }
  
  public void onFinish()
  {
    if (a(getActivity()).getIntExtra("key_mini_exit_anim", 0) == 1) {
      getActivity().overridePendingTransition(0, 2130771995);
    }
    super.onFinish();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.m();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.k();
    }
  }
  
  public void onStart()
  {
    a(true);
    super.onStart();
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.n();
    }
  }
  
  public void onStop()
  {
    a(false);
    super.onStop();
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.o();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Akfg != null) {
      this.jdField_a_of_type_Akfg.c(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatFragment
 * JD-Core Version:    0.7.0.1
 */