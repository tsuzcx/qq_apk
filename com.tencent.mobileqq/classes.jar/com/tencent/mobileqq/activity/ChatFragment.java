package com.tencent.mobileqq.activity;

import adno;
import adnp;
import adnq;
import afof;
import afoh;
import afuq;
import afzr;
import agab;
import agje;
import ahwv;
import ahyi;
import ahyj;
import ahyl;
import ahzc;
import ahzq;
import ahzx;
import aiag;
import aiah;
import aiav;
import aibs;
import aici;
import aict;
import aidd;
import aido;
import aifl;
import aifq;
import aift;
import aifz;
import aijq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import anvk;
import ausd;
import bghs;
import bhfr;
import bhhy;
import bjxa;
import bkyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import nwu;
import org.jetbrains.annotations.Nullable;
import pwb;

public class ChatFragment
  extends ReportV4Fragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static SparseArray<Animation> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  private static boolean c;
  adnp jdField_a_of_type_Adnp;
  adnq jdField_a_of_type_Adnq;
  afoh jdField_a_of_type_Afoh;
  public Context a;
  public FragmentActivity a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new adno(this);
  public BaseChatPie a;
  public TopGestureLayout a;
  public QQAppInterface a;
  public SystemBarCompact a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  public boolean a;
  private boolean b;
  
  public ChatFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private int a(Intent paramIntent)
  {
    int m = 1;
    int i = paramIntent.getIntExtra("uintype", -1);
    int j;
    if (i == 1026)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
        j = 1;
      }
    }
    else
    {
      do
      {
        return j;
        if (i != 0) {
          break;
        }
        if ((nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"), i)) || (bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
          }
          paramIntent.putExtra("uintype", 1024);
          return 1024;
        }
        j = i;
      } while (!bghs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin")));
      return 1043;
      String str;
      if (i == 1025)
      {
        str = paramIntent.getStringExtra("uin");
        if ((TextUtils.isEmpty(str)) || (!((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str))) {
          break label316;
        }
        paramIntent.putExtra("uintype", 0);
        i = 0;
      }
      label291:
      label316:
      for (;;)
      {
        return i;
        if (i == 1024)
        {
          str = paramIntent.getStringExtra("uin");
          j = i;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          int k = m;
          if (!nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, i)) {
            if (!bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
              break label291;
            }
          }
          for (k = m;; k = 0)
          {
            j = i;
            if (k != 0) {
              break;
            }
            j = i;
            if (!((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
            }
            paramIntent.putExtra("uintype", 0);
            return 0;
          }
        }
        j = i;
        if (i != 1043) {
          break;
        }
        paramIntent.putExtra("uintype", 0);
        return i;
      }
    }
    return 1;
  }
  
  public static ChatFragment a()
  {
    ChatFragment localChatFragment = new ChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localChatFragment.setArguments(localBundle);
    return localChatFragment;
  }
  
  @Nullable
  private Boolean a(Intent paramIntent, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 2: 
    default: 
      return null;
    case 1: 
      if (!h(paramIntent)) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    case 3: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aict)))
      {
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
          c();
        }
        return Boolean.valueOf(false);
      }
      c();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aict(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
      return Boolean.valueOf(true);
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aifz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return Boolean.valueOf(true);
  }
  
  private void a(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public static void a(boolean paramBoolean)
  {
    if (c != paramBoolean) {
      c = paramBoolean;
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (SplashActivity.a == 1);
  }
  
  private boolean c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new BaseChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean d(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aidd)))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aidd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean e(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aift)))
    {
      if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aift(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean f(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahzx)))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahzx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean g(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aido)))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aido(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private void h()
  {
    long l;
    if (isVisible())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.hide(this);
      localFragmentTransaction.commitAllowingStateLoss();
      bhhy.a("AIO_preLoad_Cost", null);
      l = SystemClock.uptimeMillis() - afof.a;
      bhfr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10, l);
      if (QLog.isColorLevel()) {}
    }
    else
    {
      return;
    }
    QLog.d("Q.aio.ChatFragment", 2, "AIO preLoad cost:" + l);
  }
  
  private boolean h(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahyl)))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahyl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private void i()
  {
    int i = -1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("KEY_FROM");
        String str1 = str2;
        if (str2 == null)
        {
          ComponentName localComponentName = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCallingActivity();
          str1 = str2;
          if (localComponentName != null) {
            str1 = localComponentName.getClassName();
          }
        }
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + bhhy.a + ",from:" + str1);
      }
      if (!QQAppInterface.AIO_HAD_OPEN) {
        break label235;
      }
    }
    label235:
    for (int j = 0;; j = 1)
    {
      bhfr.a("actFPSAIO", SystemClock.uptimeMillis());
      bhfr.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, bhhy.a);
      this.jdField_a_of_type_Boolean = false;
      ThreadManager.post(new ChatFragment.1(this, i, j), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "AIOTime aioOpenTimeReport end Cost " + bhhy.a + " AIOType: " + i + " firstOpenAIO: " + j);
      }
      return;
    }
  }
  
  private boolean i(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof afzr)))
    {
      if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new afzr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean j(Intent paramIntent)
  {
    boolean bool1 = true;
    String str = paramIntent.getStringExtra("uin");
    HotChatManager localHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
    boolean bool2 = localHotChatManager.b(str);
    boolean bool3 = paramIntent.getBooleanExtra("isGameRoom", false);
    if ((bool2) || (bool3))
    {
      c();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
      paramIntent = localHotChatManager.a(str);
      if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool3)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aiav(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    for (;;)
    {
      bool1 = false;
      do
      {
        return bool1;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aibs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getClass().equals(TroopChatPie.class))) {
          break label194;
        }
      } while ((!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)));
      c();
      return true;
      label194:
      c();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new TroopChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private boolean k(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahyi)))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahyi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  private boolean l(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahyl)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aifq)))
    {
      if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
        c();
      }
      return true;
    }
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new agab(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
    return false;
  }
  
  protected Dialog a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onCreateDialog(paramInt);
    }
    return null;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp =null new compact");
      }
      int i = getResources().getColor(2131167084);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserOnline) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserTitleForm) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode)) {
        break label200;
      }
      localDrawable = ahwv.a().b(4);
      if (localDrawable == null) {
        break label173;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("systembar", 2, "duration=====" + (l2 - l1));
      }
      return;
      label173:
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846157));
      break;
      label200:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode))
      {
        localDrawable = aijq.a().b(4);
        if (localDrawable != null)
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
          break;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846157));
        break;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846157));
      break;
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp isStatusBarVisible=" + this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode))
      {
        localDrawable = ahwv.a().b(4);
        if (QLog.isColorLevel()) {
          QLog.i("systembar", 2, "isQimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserOnline + "drawable = " + localDrawable);
        }
        if (localDrawable != null) {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible) || (getActivity() == null)) {
          break label804;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserOnline) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isQimUserTitleForm) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode)) {
          break label806;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
        break;
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846157));
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode))
          {
            localDrawable = aijq.a().b(4);
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "isTimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserOnline + "drawable = " + localDrawable);
            }
            if (localDrawable != null) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
            } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846157));
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "333 isDefaultTheme =====" + ThemeUtil.isDefaultOrDIYTheme(false));
            }
            if (ThemeUtil.isDefaultOrDIYTheme(false))
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846157));
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(null);
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167084));
            }
          }
        }
      }
      label804:
      continue;
      label806:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isTimUserTitleForm) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.isNightMode)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
      } else {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.finish(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPrepareDialog(paramInt, paramDialog);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onBackEvent " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onBackEvent();
    }
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "canReuseChatPie: " + bool1);
      }
      return bool1;
      bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool3 = ausd.a(paramIntent);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasDestory)
        {
          String str1 = paramIntent.getStringExtra("uin");
          String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo().curFriendUin;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = bool2;
            if (str1.equals(str2))
            {
              int i = paramIntent.getIntExtra("uintype", -1);
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo().curType == i) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onShowDone) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasDestory)) {
        break label74;
      }
      QLog.i("Q.aio.ChatFragment", 1, "onShowFirst return|" + paramInt + " hasDestory:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasDestory);
    }
    for (;;)
    {
      g();
      return;
      label74:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onShowFirst(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setIsInMultiWindow(paramBoolean);
    }
  }
  
  protected boolean b(Intent paramIntent)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnNewIntent_clearBusinessData();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "getChatPie doOnNewIntent_clearBusinessData " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    Object localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "getChatPie uin=" + ((String)localObject).substring(((String)localObject).length() - 4));
    }
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getChatPie subType = ").append(i).append(" type = ").append(paramIntent.getIntExtra("uintype", -1)).append(" mRootView is null?: ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
      {
        bool1 = true;
        QLog.i("Q.aio.ChatFragment", 2, bool1);
      }
    }
    else
    {
      localObject = a(paramIntent, i);
      if (localObject == null) {
        break label237;
      }
      bool1 = ((Boolean)localObject).booleanValue();
    }
    label237:
    do
    {
      return bool1;
      bool1 = false;
      break;
      switch (a(paramIntent))
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
        }
        bool1 = bool2;
      }
    } while (c(paramIntent));
    for (;;)
    {
      return true;
      if (l(paramIntent))
      {
        return false;
        if (k(paramIntent))
        {
          return false;
          if (j(paramIntent))
          {
            return false;
            if (i(paramIntent))
            {
              return false;
              if (h(paramIntent))
              {
                return false;
                if (g(paramIntent))
                {
                  return false;
                  if (f(paramIntent))
                  {
                    return false;
                    if (e(paramIntent))
                    {
                      return false;
                      if (d(paramIntent))
                      {
                        return false;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahyj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahzq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aici(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aifq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new ahzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aiah(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aiag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                        continue;
                        c();
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = new aifl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentAIOState() != 6) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnStop();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnDestroy();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie already cleared.");
  }
  
  public void c(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(paramInt, 0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "fight doInMultiWindowModeStatusBarVisibilityChange  = " + paramInt);
    }
  }
  
  public void d()
  {
    if (a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent())) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        ((agje)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(7)).c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        a(false);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      return;
      if (b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
          View localView = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558851, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(localView);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnCreate(false);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.aio.ChatFragment", 2, "onNewIntent mRootView == null---created a new Pie");
        }
      }
      else
      {
        boolean bool = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mBasePie.doOnCreate(false) reuse the pie.");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnCreate(false);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131167084);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPostThemeChanged();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onPreThemeChanged();
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingLToR " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.leftBackEvent(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingRToL " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
  
  public void g()
  {
    int j = 0;
    int k = 1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = k;
      if (getActivity() != null)
      {
        i = k;
        if (getActivity().isInMultiWindow())
        {
          i = k;
          if (getActivity().isNeedStatusBarGone())
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.aio.ChatFragment", 4, "fight onMulitWindowModePause isNeedStatusBarGone = true");
            }
            i = 0;
          }
        }
      }
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (int i = j;; i = 2)
    {
      c(i);
      return;
    }
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onAttach");
    }
    bhhy.a(null, "AIO_Super_onAttach");
    super.onAttach(paramActivity);
    bhhy.a("AIO_Super_onAttach", "AIO_onAttach");
    this.jdField_a_of_type_Afoh = new afoh();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 1026))
    {
      localIntent.putExtra("uintype", 1);
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "check UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Adnq = new adnq(this);
    bhhy.a("AIO_onAttach", null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreate");
    }
    bhhy.a(null, "AIO_Super_onCreate");
    super.onCreate(paramBundle);
    bhhy.a("AIO_Super_onCreate", null);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772048)
      {
        localObject = new afuq();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131427330));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      }
      for (;;)
      {
        jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
        return localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  @TargetApi(14)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreateView");
    }
    bhhy.a(null, "AIO_onCreateView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_Adnp = new adnp(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Adnq, this.jdField_a_of_type_Adnp);
      paramLayoutInflater = (View)paramViewGroup.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setBackgroundResource(2130850291);
      }
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558851, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(paramLayoutInflater);
        a(false);
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()) - 10, 0, 0);
        }
        bhhy.a("AIO_onCreateView", null);
        paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramLayoutInflater);
        paramLayoutInflater = null;
        continue;
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      }
    }
  }
  
  public void onDestroy()
  {
    bhhy.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    bhhy.a("AIO_Super_onDestroy", "AIO_onDestroy");
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onDestroy " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = null;
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp destroy");
      }
    }
    bhhy.a("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    bhhy.a(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null)
    {
      localTopGestureLayout.setOnFlingGesture(null);
      localTopGestureLayout.setMyDispatchDrawListener(null);
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    bhhy.a("AIO_Super_onDestroyView", null);
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onHiddenChanged hidden = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.b = true;
      onPause();
      onStop();
      this.b = false;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 500L);
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      if (localIntent.getBooleanExtra("isFromMainTab", false))
      {
        onStart();
        onResume();
      }
      else if (localIntent.getBooleanExtra("isFromContactTab", false))
      {
        onStart();
      }
    }
  }
  
  public void onPause()
  {
    bhhy.a(null, "AIO_Super_onPause");
    super.onPause();
    bhhy.a("AIO_Super_onPause", "AIO_onPause");
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnPause();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_Afoh != null) {
      this.jdField_a_of_type_Afoh.a();
    }
    bhhy.a("AIO_onPause", null);
  }
  
  public void onResume()
  {
    bhhy.a(null, "AIO_Super_onResume");
    super.onResume();
    bhhy.a("AIO_Super_onResume", "AIO_onResume");
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume return");
      }
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnResume();
    }
    getActivity().getWindow().setSoftInputMode(18);
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartChat, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    bhhy.a("AIO_onResume", "AIO_onDrawView");
  }
  
  public void onStart()
  {
    super.onStart();
    if (c()) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnStart();
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onStart " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        }
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null);
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    pwb.a().a(1, null, str, i, -1);
  }
  
  public void onStop()
  {
    bhhy.a(null, "AIO_Super_onStop");
    super.onStop();
    bhhy.a("AIO_Super_onStop", "AIO_onStop");
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnStop();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    bhhy.a("AIO_onStop", null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bhhy.a(null, "AIO_Super_onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    bhhy.a("AIO_Super_onViewCreated", "AIO_onViewCreated");
    bhhy.a(null, "AIO_onCreate_getPieCost");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bhhy.a("AIO_onCreate_getPieCost", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (!c()) {
        break label143;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.preStartBaseAIO();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
      }
    }
    for (;;)
    {
      bhhy.a("AIO_onViewCreated", null);
      return;
      label143:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.doOnCreate(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */