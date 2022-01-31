package com.tencent.mobileqq.activity;

import aaqc;
import aaqd;
import aaqe;
import acta;
import actc;
import acym;
import aekp;
import aema;
import aemb;
import aemh;
import aemy;
import aenm;
import aent;
import aeoc;
import aeom;
import aepe;
import aeqb;
import aeqs;
import aeqz;
import aerj;
import aert;
import aetn;
import aetq;
import aexi;
import ajxl;
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
import aqdn;
import bail;
import bbfv;
import bbkj;
import bduf;
import bfnk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import naz;
import osx;

public class ChatFragment
  extends Fragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static SparseArray<Animation> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  private static boolean c;
  aaqd jdField_a_of_type_Aaqd;
  aaqe jdField_a_of_type_Aaqe;
  actc jdField_a_of_type_Actc;
  public Context a;
  public FragmentActivity a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aaqc(this);
  public BaseChatPie a;
  public TopGestureLayout a;
  public QQAppInterface a;
  public SystemBarCompact a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
  public boolean a;
  private boolean b;
  
  public ChatFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static ChatFragment a()
  {
    ChatFragment localChatFragment = new ChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localChatFragment.setArguments(localBundle);
    return localChatFragment;
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
    return ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1);
  }
  
  private void h()
  {
    long l;
    if (isVisible())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.hide(this);
      localFragmentTransaction.commitAllowingStateLoss();
      bbkj.a("AIO_preLoad_Cost", null);
      l = SystemClock.uptimeMillis() - acta.a;
      bbfv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10, l);
      if (QLog.isColorLevel()) {}
    }
    else
    {
      return;
    }
    QLog.d("Q.aio.ChatFragment", 2, "AIO preLoad cost:" + l);
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
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + bbkj.a + ",from:" + str1);
      }
      if (!QQAppInterface.b) {
        break label227;
      }
    }
    label227:
    for (int j = 0;; j = 1)
    {
      bbfv.a("actFPSAIO", SystemClock.uptimeMillis());
      bbfv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, bbkj.a);
      this.jdField_a_of_type_Boolean = false;
      ThreadManager.post(new ChatFragment.1(this, i, j), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "AIOTime aioOpenTimeReport end Cost " + bbkj.a + " AIOType: " + i + " firstOpenAIO: " + j);
      }
      return;
    }
  }
  
  protected Dialog a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt);
    }
    return null;
  }
  
  public BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
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
        break label317;
      }
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp =null new compact");
      }
      int i = getResources().getColor(2131166910);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
        break label198;
      }
      localDrawable = aekp.a().b(4);
      if (localDrawable == null) {
        break label171;
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
      label171:
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130845305));
      break;
      label198:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
      {
        localDrawable = aexi.a().b(4);
        if (localDrawable != null)
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
          break;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130845305));
        break;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130845305));
      break;
      label317:
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp isStatusBarVisible=" + this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
      {
        localDrawable = aekp.a().b(4);
        if (QLog.isColorLevel()) {
          QLog.i("systembar", 2, "isQimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean + "drawable = " + localDrawable);
        }
        if (localDrawable != null) {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible) || (getActivity() == null)) {
          break label798;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
          break label800;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
        break;
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130845305));
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c))
          {
            localDrawable = aexi.a().b(4);
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "isTimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b + "drawable = " + localDrawable);
            }
            if (localDrawable != null) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
            } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130845305));
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "333 isDefaultTheme =====" + ThemeUtil.isDefaultOrDIYTheme(false));
            }
            if (ThemeUtil.isDefaultOrDIYTheme(false))
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130845305));
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(null);
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131166910));
            }
          }
        }
      }
      label798:
      continue;
      label800:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
      } else {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onBackEvent " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i();
    }
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "canReuseChatPie: " + bool1);
      }
      return bool1;
      bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool3 = aqdn.a(paramIntent);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.N)
        {
          String str1 = paramIntent.getStringExtra("uin");
          String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = bool2;
            if (str1.equals(str2))
            {
              int i = paramIntent.getIntExtra("uintype", -1);
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int == i) {
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.A) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.N)) {
        break label74;
      }
      QLog.i("Q.aio.ChatFragment", 1, "onShowFirst return|" + paramInt + " hasDestory:" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.N);
    }
    for (;;)
    {
      g();
      return;
      label74:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.q(paramBoolean);
    }
  }
  
  protected boolean b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.P();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "getChatPie doOnNewIntent_clearBusinessData " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    Object localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "getChatPie uin=" + ((String)localObject).substring(((String)localObject).length() - 4));
    }
    boolean bool1;
    int j;
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
      switch (i)
      {
      case 2: 
      default: 
        j = paramIntent.getIntExtra("uintype", -1);
        if (j == 1026)
        {
          if (!QLog.isDevelopLevel()) {
            break label2133;
          }
          QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BaseChatPie)))
        {
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
            c();
          }
          do
          {
            do
            {
              return false;
              bool1 = false;
              break;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aemh))) {
                break label611;
              }
            } while (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity));
            c();
            return false;
            c();
            a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aemh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
            return true;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeqz))) {
              break label686;
            }
          } while (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity));
          c();
          return false;
          c();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aeqz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          return true;
          if (j == 0)
          {
            if ((naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"), j)) || (bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"))))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
              }
              paramIntent.putExtra("uintype", 1024);
              i = 1024;
              continue;
            }
            i = j;
            if (!bail.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("uin"))) {
              continue;
            }
            i = 1043;
            continue;
          }
          if (j == 1025)
          {
            localObject = paramIntent.getStringExtra("uin");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject))) {
              break label2128;
            }
            paramIntent.putExtra("uintype", 0);
          }
        }
      case 0: 
      case 1038: 
      case 1: 
      case 3000: 
      case 1024: 
      case 1008: 
      case 9501: 
      case 1000: 
      case 1003: 
      case 1004: 
      case 1005: 
      case 1006: 
      case 1020: 
      case 1021: 
      case 1022: 
      case 1023: 
      case 1025: 
      case 7400: 
      case 10004: 
      case 1001: 
      case 1009: 
      case 1010: 
      case 10002: 
      case 1031: 
      case 1033: 
      case 1034: 
      case 1037: 
      case 1044: 
      case 1043: 
      case 1036: 
        label570:
        label611:
        for (i = 0;; i = j)
        {
          break;
          if (j == 1024)
          {
            localObject = paramIntent.getStringExtra("uin");
            i = j;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            if ((naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, j)) || (bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject))) {}
            for (int k = 1;; k = 0)
            {
              i = j;
              if (k != 0) {
                break;
              }
              i = j;
              if (!((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
              }
              paramIntent.putExtra("uintype", 0);
              i = 0;
              break;
            }
          }
          i = j;
          if (j != 1043) {
            break;
          }
          paramIntent.putExtra("uintype", 0);
          i = j;
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeom)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aemh)) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aetn)))
          {
            if ((!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
              break label570;
            }
            c();
            return false;
          }
          c();
          a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aeom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
          for (;;)
          {
            return true;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aema)))
            {
              if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
                break;
              }
              c();
              return false;
            }
            c();
            a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aema(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
            continue;
            localObject = paramIntent.getStringExtra("uin");
            HotChatManager localHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
            bool1 = localHotChatManager.b((String)localObject);
            boolean bool2 = paramIntent.getBooleanExtra("isGameRoom", false);
            if ((bool1) || (bool2))
            {
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              paramIntent = localHotChatManager.a((String)localObject);
              if (((paramIntent != null) && (paramIntent.isGameRoom)) || (bool2)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aepe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              } else {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aeqb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().equals(TroopChatPie.class)))
              {
                if ((!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new TroopChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aeoc)))
              {
                if ((!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aeoc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aemh)))
              {
                if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aemh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aert)))
              {
                if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aert(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aent)))
              {
                if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aetq)))
              {
                if ((!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aetq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aerj)))
              {
                if (!(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) {
                  break;
                }
                c();
                return false;
              }
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aerj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aemb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aenm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aeqs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aetn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new aemy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
              continue;
              c();
              a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramIntent);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = new BaseChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext);
            }
          }
        }
        label686:
        label2128:
        label2133:
        i = 1;
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g() != 6) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G();
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aT();
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
          View localView = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558719, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(localView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131166910);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Z();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Y();
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingLToR " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingRToL " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getClass().getName();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onAttach");
    }
    bbkj.a(null, "AIO_Super_onAttach");
    super.onAttach(paramActivity);
    bbkj.a("AIO_Super_onAttach", "AIO_onAttach");
    this.jdField_a_of_type_Actc = new actc();
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
    this.jdField_a_of_type_Aaqe = new aaqe(this);
    bbkj.a("AIO_onAttach", null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreate");
    }
    bbkj.a(null, "AIO_Super_onCreate");
    super.onCreate(paramBundle);
    bbkj.a("AIO_Super_onCreate", null);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772045)
      {
        localObject = new acym();
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
    bbkj.a(null, "AIO_onCreateView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_Aaqd = new aaqd(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aaqe, this.jdField_a_of_type_Aaqd);
      paramLayoutInflater = (View)paramViewGroup.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setBackgroundResource(2130849176);
      }
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558719, null);
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
        bbkj.a("AIO_onCreateView", null);
        return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramLayoutInflater);
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      }
    }
  }
  
  public void onDestroy()
  {
    bbkj.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    bbkj.a("AIO_Super_onDestroy", "AIO_onDestroy");
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onDestroy " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
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
    bbkj.a("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    bbkj.a(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null)
    {
      localTopGestureLayout.setOnFlingGesture(null);
      localTopGestureLayout.setMyDispatchDrawListener(null);
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    bbkj.a("AIO_Super_onDestroyView", null);
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
    bbkj.a(null, "AIO_Super_onPause");
    super.onPause();
    bbkj.a("AIO_Super_onPause", "AIO_onPause");
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.L();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    if (this.jdField_a_of_type_Actc != null) {
      this.jdField_a_of_type_Actc.a();
    }
    bbkj.a("AIO_onPause", null);
  }
  
  public void onResume()
  {
    bbkj.a(null, "AIO_Super_onResume");
    super.onResume();
    bbkj.a("AIO_Super_onResume", "AIO_onResume");
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume return");
      }
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.O();
    }
    getActivity().getWindow().setSoftInputMode(18);
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartChat, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    bbkj.a("AIO_onResume", "AIO_onDrawView");
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J();
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onStart " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
        }
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null);
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    osx.a().a(1, null, str, i, -1);
  }
  
  public void onStop()
  {
    bbkj.a(null, "AIO_Super_onStop");
    super.onStop();
    bbkj.a("AIO_Super_onStop", "AIO_onStop");
    if ((c()) && (!this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.K();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
      }
    }
    bbkj.a("AIO_onStop", null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bbkj.a(null, "AIO_Super_onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    bbkj.a("AIO_Super_onViewCreated", "AIO_onViewCreated");
    bbkj.a(null, "AIO_onCreate_getPieCost");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    bbkj.a("AIO_onCreate_getPieCost", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (!c()) {
        break label143;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
      }
    }
    for (;;)
    {
      bbkj.a("AIO_onViewCreated", null);
      return;
      label143:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */