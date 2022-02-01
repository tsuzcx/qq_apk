package com.tencent.mobileqq.activity;

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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOEnterInAni;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.ChatPieCreatorFactory;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.PutOrderCache;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ChatPieSubTypeCreatorFactory;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Collection;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ChatFragment
  extends ReportV4Fragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static SparseArray<Animation> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  public static volatile boolean a;
  private static boolean d;
  public Context a;
  public FragmentActivity a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ChatFragment.2(this);
  ChatFragment.InterceptTouchEventListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener;
  ChatFragment.MyDispatchDrawListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener;
  AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  public BaseChatPie a;
  private final PutOrderCache<Class<? extends BaseChatPie>, BaseChatPie> jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache = new PutOrderCache();
  public TopGestureLayout a;
  public QQAppInterface a;
  public SystemBarCompact a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  boolean b = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    d = false;
  }
  
  public ChatFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.setCapacity(2);
  }
  
  private int a(Intent paramIntent)
  {
    int i = 1043;
    int m = 1;
    int j = paramIntent.getIntExtra("uintype", -1);
    if (j == 1026)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
        i = 1;
        return i;
      }
    }
    else
    {
      String str;
      if (j == 0)
      {
        str = paramIntent.getStringExtra("uin");
        if ((CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, j)) || (QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
          }
          paramIntent.putExtra("uintype", 1024);
          i = 1024;
        }
      }
      for (;;)
      {
        return i;
        if (!RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))
        {
          if (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str))
          {
            i = 6000;
            continue;
            if (j == 1025)
            {
              str = paramIntent.getStringExtra("uin");
              i = j;
              if (TextUtils.isEmpty(str)) {
                break;
              }
              i = j;
              if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
                break;
              }
              paramIntent.putExtra("uintype", 0);
              label194:
              return 0;
            }
            if (j == 1024)
            {
              str = paramIntent.getStringExtra("uin");
              i = j;
              if (TextUtils.isEmpty(str)) {
                break;
              }
              int k = m;
              if (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, j)) {
                if (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
                  break label309;
                }
              }
              label309:
              for (k = m;; k = 0)
              {
                i = j;
                if (k != 0) {
                  break;
                }
                i = j;
                if (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
                }
                paramIntent.putExtra("uintype", 0);
                break label194;
              }
            }
            i = j;
            if (j != 1043) {
              break;
            }
            paramIntent.putExtra("uintype", 0);
            return j;
          }
          i = j;
        }
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
  
  private BaseChatPie a(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.putAndGetRemoved(paramBaseChatPie.getClass(), paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    return localBaseChatPie;
  }
  
  private void a(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public static void a(boolean paramBoolean)
  {
    if (d != paramBoolean) {
      d = paramBoolean;
    }
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1);
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
    a(a(new BaseChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext)), paramIntent);
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
      StartupTracker.a("AIO_preLoad_Cost", null);
      l = SystemClock.uptimeMillis() - AIOPreLoadEngine.a;
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10, l);
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
    if (this.b)
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
        QLog.d("Q.PerfTrace", 2, "aio drawComplete,duration:" + StartupTracker.a + ",from:" + str1);
      }
      if (!jdField_a_of_type_Boolean) {
        break label243;
      }
    }
    label243:
    for (int j = 0;; j = 1)
    {
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, StartupTracker.a);
      jdField_a_of_type_Boolean = true;
      PerformanceReportUtils.jdField_a_of_type_Boolean = true;
      this.b = false;
      ThreadManager.post(new ChatFragment.1(this, i, j), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "AIOTime aioOpenTimeReport end Cost " + StartupTracker.a + " AIOType: " + i + " firstOpenAIO: " + j);
      }
      return;
    }
  }
  
  protected Dialog a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt);
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
  
  @Nullable
  Boolean a(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    }
    IChatPieCreator localIChatPieCreator;
    do
    {
      return null;
      localIChatPieCreator = ChatPieSubTypeCreatorFactory.a().a(paramInt);
    } while (localIChatPieCreator == null);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.values().iterator();
    while (localIterator.hasNext())
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
      if (localIChatPieCreator.canReuse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie, paramIntent))
      {
        if (localIChatPieCreator.clearLastWhenReuse(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
          c();
        }
        a(localBaseChatPie);
        return Boolean.valueOf(false);
      }
    }
    c();
    a(a(localIChatPieCreator.create(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, paramIntent)), paramIntent);
    return Boolean.valueOf(true);
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
      int i = getResources().getColor(2131167091);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, i);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
        break label200;
      }
      localDrawable = QIMUserManager.a().b(4);
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
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846481));
      break;
      label200:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
      {
        localDrawable = TIMUserManager.a().b(4);
        if (localDrawable != null)
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(localDrawable);
          break;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846481));
        break;
      }
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846481));
      break;
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("systembar", 2, "mChatBarComp isStatusBarVisible=" + this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
      {
        localDrawable = QIMUserManager.a().b(4);
        if (QLog.isColorLevel()) {
          QLog.i("systembar", 2, "isQimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean + "drawable = " + localDrawable);
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
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
          break label806;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
        break;
        if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846481));
          continue;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
          {
            localDrawable = TIMUserManager.a().b(4);
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "isTimUserOnline=====" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b + "drawable = " + localDrawable);
            }
            if (localDrawable != null) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(localDrawable);
            } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846481));
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("systembar", 2, "333 isDefaultTheme =====" + ThemeUtil.isDefaultOrDIYTheme(false));
            }
            if (ThemeUtil.isDefaultOrDIYTheme(false))
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846481));
            }
            else
            {
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(null);
              this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167091));
            }
          }
        }
      }
      label804:
      continue;
      label806:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
      } else {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onBackEvent " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g();
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
      boolean bool3 = ForwardOptionUtils.a(paramIntent);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.I)
        {
          String str1 = paramIntent.getStringExtra("uin");
          String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString;
          bool1 = bool2;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = bool2;
            if (str1.equals(str2))
            {
              int i = paramIntent.getIntExtra("uintype", -1);
              bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int == i)
              {
                if (QFileAssistantUtils.a(str1)) {}
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  boolean a(Intent paramIntent, int paramInt)
  {
    IChatPieCreator localIChatPieCreator = ChatPieCreatorFactory.a().a(paramInt);
    if (localIChatPieCreator != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.values().iterator();
      while (localIterator.hasNext())
      {
        BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
        if (localIChatPieCreator.canReuse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie, paramIntent))
        {
          if (localIChatPieCreator.clearLastWhenReuse(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
            c();
          }
          a(localBaseChatPie);
          return false;
        }
      }
      c();
      a(a(localIChatPieCreator.create(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, paramIntent)), paramIntent);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
    }
    return !c(paramIntent);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.w) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.I)) {
        break label74;
      }
      QLog.i("Q.aio.ChatFragment", 1, "onShowFirst return|" + paramInt + " hasDestory:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.I);
    }
    for (;;)
    {
      g();
      return;
      label74:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.m(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.q(paramBoolean);
    }
  }
  
  protected boolean b(Intent paramIntent)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.S();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "getChatPie doOnNewIntent_clearBusinessData " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    Object localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "getChatPie uin=" + ((String)localObject).substring(((String)localObject).length() - 4));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getChatPie subType = ").append(i).append(" type = ").append(paramIntent.getIntExtra("uintype", -1)).append(" mRootView is null?: ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
        bool = true;
      }
      QLog.i("Q.aio.ChatFragment", 2, bool);
    }
    localObject = a(paramIntent, i);
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b();
      }
      return ((Boolean)localObject).booleanValue();
    }
    paramIntent = Boolean.valueOf(a(paramIntent, a(paramIntent)));
    if (paramIntent.booleanValue()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b();
    }
    return paramIntent.booleanValue();
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.values().iterator();
    while (localIterator.hasNext())
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie");
      }
      if ((localBaseChatPie.h() != 6) && (!localBaseChatPie.D())) {
        localBaseChatPie.N();
      }
      if (!localBaseChatPie.D()) {
        localBaseChatPie.J();
      } else {
        QLog.e("Q.aio.ChatFragment", 1, "chatpie life cycle illegal");
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (QLog.isColorLevel())) {
      QLog.i("Q.aio.ChatFragment", 2, "OnClearLastPie already cleared.");
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent())) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
        ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(7)).c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        a(false);
        this.b = true;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      return;
      if (!b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent())) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
        localObject1 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558891, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView((View)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.aio.ChatFragment", 2, "onNewIntent mRootView == null---created a new Pie");
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onNewIntent mBasePie.doOnCreate(false) reuse the pie. same session: ");
      if (localObject1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("Q.aio.ChatFragment", 2, bool);
      if (localObject1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558891, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView((View)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
      break;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131167091);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.Y();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.X();
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "flingLToR " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(true);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onAttach");
    }
    StartupTracker.a(null, "AIO_Super_onAttach");
    super.onAttach(paramActivity);
    StartupTracker.a("AIO_Super_onAttach", "AIO_onAttach");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter = new AIOTimeReporter();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener = new ChatFragment.MyDispatchDrawListener(this);
    StartupTracker.a("AIO_onAttach", null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "onCreate");
    }
    StartupTracker.a(null, "AIO_Super_onCreate");
    super.onCreate(paramBundle);
    StartupTracker.a("AIO_Super_onCreate", null);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772052)
      {
        localObject = new AIOEnterInAni();
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
    StartupTracker.a(null, "AIO_onCreateView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener = new ChatFragment.InterceptTouchEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new ChatFragmentTopGestureLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener);
      paramLayoutInflater = (View)paramViewGroup.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setBackgroundResource(2130850689);
      }
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131558891, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(paramLayoutInflater);
        a(false);
        this.b = true;
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
        }
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()) - 10, 0, 0);
        }
        StartupTracker.a("AIO_onCreateView", null);
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
    StartupTracker.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    StartupTracker.a("AIO_Super_onDestroy", "AIO_onDestroy");
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.J();
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
    StartupTracker.a("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    StartupTracker.a(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    ChatFragmentTopGestureLayout localChatFragmentTopGestureLayout = (ChatFragmentTopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localChatFragmentTopGestureLayout != null)
    {
      localChatFragmentTopGestureLayout.setOnFlingGesture(null);
      localChatFragmentTopGestureLayout.setMyDispatchDrawListener(null);
      localChatFragmentTopGestureLayout.setInterceptTouchEventListener(null);
    }
    StartupTracker.a("AIO_Super_onDestroyView", null);
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
      this.c = true;
      onPause();
      onStop();
      this.c = false;
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
    StartupTracker.a(null, "AIO_Super_onPause");
    super.onPause();
    StartupTracker.a("AIO_Super_onPause", "AIO_onPause");
    if ((c()) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.O();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    NewAIOTimeReporter.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter.a();
    }
    StartupTracker.a("AIO_onPause", null);
  }
  
  public void onResume()
  {
    StartupTracker.a(null, "AIO_Super_onResume");
    super.onResume();
    StartupTracker.a("AIO_Super_onResume", "AIO_onResume");
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.R();
    }
    getActivity().getWindow().setSoftInputMode(18);
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartChat, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    StartupTracker.a("AIO_onResume", "AIO_onDrawView");
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.M();
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onStart " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        }
      }
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null);
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    ReadinjoySPEventReport.a().a(1, null, str, i, -1);
  }
  
  public void onStop()
  {
    StartupTracker.a(null, "AIO_Super_onStop");
    super.onStop();
    StartupTracker.a("AIO_Super_onStop", "AIO_onStop");
    if ((c()) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.N();
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
      }
    }
    StartupTracker.a("AIO_onStop", null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    StartupTracker.a(null, "AIO_Super_onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    StartupTracker.a("AIO_Super_onViewCreated", "AIO_onViewCreated");
    StartupTracker.a(null, "AIO_onCreate_getPieCost");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    boolean bool = b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    QLog.d("Q.aio.ChatFragment", 1, "create new chat pie: " + bool);
    StartupTracker.a("AIO_onCreate_getPieCost", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (!c()) {
        break label169;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.f();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_onViewCreated", null);
      return;
      label169:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */