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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.eqq.CrmUtils;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Collection;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ChatFragment
  extends BaseFragment
  implements Handler.Callback, TopGestureLayout.OnGestureListener
{
  private static SparseArray<Animation> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  public static volatile boolean a = false;
  private static boolean d = false;
  public Context a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ChatFragment.2(this);
  ChatFragment.InterceptTouchEventListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener;
  ChatFragment.MyDispatchDrawListener jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener;
  AIOTimeReporter jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
  public BaseChatPie a;
  private final PutOrderCache<Class<? extends BaseChatPie>, BaseChatPie> jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache = new PutOrderCache();
  public TopGestureLayout a;
  public BaseActivity a;
  public QQAppInterface a;
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
  public SystemBarCompact a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  boolean b = false;
  private boolean c = false;
  
  public ChatFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.setCapacity(2);
  }
  
  private int a(Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("uintype", -1);
    int j = 1;
    if (k == 1026)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in create chat pie");
      }
      return 1;
    }
    String str;
    if (k == 0)
    {
      str = paramIntent.getStringExtra("uin");
      if ((!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, k)) && (!QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)))
      {
        if (RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
          return 1043;
        }
        if (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
          return 6000;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_FRIEND to UIN_TYPE_BUSINESS_CMR_TMP");
        }
        paramIntent.putExtra("uintype", 1024);
        return 1024;
      }
    }
    else if (k == 1025)
    {
      str = paramIntent.getStringExtra("uin");
      if ((!TextUtils.isEmpty(str)) && (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str))) {
        paramIntent.putExtra("uintype", 0);
      }
    }
    else
    {
      for (;;)
      {
        return 0;
        if (k != 1024) {
          break;
        }
        str = paramIntent.getStringExtra("uin");
        if (TextUtils.isEmpty(str)) {
          break label317;
        }
        int i = j;
        if (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, k)) {
          if (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str)) {
            i = j;
          } else {
            i = 0;
          }
        }
        if ((i != 0) || (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str))) {
          break label317;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "change uinType from UIN_TYPE_BUSINESS_CMR_TMP to UIN_TYPE_FRIEND");
        }
        paramIntent.putExtra("uintype", 0);
      }
      if (k == 1043) {
        paramIntent.putExtra("uintype", 0);
      }
    }
    label317:
    return k;
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
    return ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1);
  }
  
  private boolean c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof SplashActivity)) {
        c();
      }
      return true;
    }
    c();
    a(a(new BaseChatPie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidContentContext)), paramIntent);
    return false;
  }
  
  private void h()
  {
    if (isVisible())
    {
      Object localObject = getFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).hide(this);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      StartupTracker.a("AIO_preLoad_Cost", null);
      long l = SystemClock.uptimeMillis() - AIOPreLoadEngine.a;
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10, l);
      if (!QLog.isColorLevel()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIO preLoad cost:");
      ((StringBuilder)localObject).append(l);
      QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    if (this.b)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      int i = -1;
      if (localObject1 != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("KEY_FROM");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ComponentName localComponentName = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCallingActivity();
          localObject1 = localObject2;
          if (localComponentName != null) {
            localObject1 = localComponentName.getClassName();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("aio drawComplete,duration:");
        ((StringBuilder)localObject2).append(StartupTracker.a);
        ((StringBuilder)localObject2).append(",from:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Q.PerfTrace", 2, ((StringBuilder)localObject2).toString());
      }
      int j = jdField_a_of_type_Boolean ^ true;
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, StartupTracker.a);
      jdField_a_of_type_Boolean = true;
      PerformanceReportUtils.jdField_a_of_type_Boolean = true;
      this.b = false;
      ThreadManager.post(new ChatFragment.1(this, i, j), 5, null, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("AIOTime aioOpenTimeReport end Cost ");
        ((StringBuilder)localObject1).append(StartupTracker.a);
        ((StringBuilder)localObject1).append(" AIOType: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" firstOpenAIO: ");
        ((StringBuilder)localObject1).append(j);
        QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected Dialog a(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.a(paramInt);
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
    if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4))
    {
      IChatPieCreator localIChatPieCreator = ChatPieSubTypeCreatorFactory.a().a(paramInt);
      if (localIChatPieCreator != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorPutOrderCache.values().iterator();
        while (localIterator.hasNext())
        {
          BaseChatPie localBaseChatPie = (BaseChatPie)localIterator.next();
          if (localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie, paramIntent))
          {
            if (localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
              c();
            }
            a(localBaseChatPie);
            return Boolean.valueOf(false);
          }
        }
        c();
        a(a(localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, paramIntent)), paramIntent);
        return Boolean.valueOf(true);
      }
    }
    return null;
  }
  
  public void a()
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("systembar", 2, "mChatBarComp =null new compact");
        }
        int i = getResources().getColor(2131167114);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getBaseActivity(), true, i);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
        {
          localObject = QIMUserManager.a().b(4);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable((Drawable)localObject);
          } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846361));
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
        {
          localObject = TIMUserManager.a().b(4);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable((Drawable)localObject);
          } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846361));
          }
        }
        else if (ThemeUtil.isDefaultOrDIYTheme(false))
        {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130846361));
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mChatBarComp isStatusBarVisible=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible);
          QLog.d("systembar", 2, ((StringBuilder)localObject).toString());
        }
        StringBuilder localStringBuilder;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
        {
          localObject = QIMUserManager.a().b(4);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isQimUserOnline=====");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean);
            localStringBuilder.append("drawable = ");
            localStringBuilder.append(localObject);
            QLog.i("systembar", 2, localStringBuilder.toString());
          }
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable((Drawable)localObject);
          } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846361));
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c))
        {
          localObject = TIMUserManager.a().b(4);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("isTimUserOnline=====");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b);
            localStringBuilder.append("drawable = ");
            localStringBuilder.append(localObject);
            QLog.i("systembar", 2, localStringBuilder.toString());
          }
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable((Drawable)localObject);
          } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846361));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("333 isDefaultTheme =====");
            ((StringBuilder)localObject).append(ThemeUtil.isDefaultOrDIYTheme(false));
            QLog.i("systembar", 2, ((StringBuilder)localObject).toString());
          }
          if (ThemeUtil.isDefaultOrDIYTheme(false))
          {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(getResources().getDrawable(2130846361));
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarDrawable(null);
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167114));
          }
        }
        if ((!this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.isStatusBarVisible) && (getBaseActivity() != null)) {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.d) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
          } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.e) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.c)) {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 450);
          } else {
            this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
          }
        }
      }
    }
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("duration=====");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.i("systembar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.b(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d();
    }
    return false;
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool2 = false;
    boolean bool1;
    if (localObject == null)
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool3 = ForwardOptionUtils.a(paramIntent);
      if ((!bool1) && (!bool3))
      {
        bool1 = bool2;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B)
      {
        bool1 = bool2;
      }
      else
      {
        localObject = paramIntent.getStringExtra("uin");
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_JavaLangString;
        bool1 = bool2;
        if (!TextUtils.isEmpty(str)) {
          if (!((String)localObject).equals(str))
          {
            bool1 = bool2;
          }
          else
          {
            int i = paramIntent.getIntExtra("uintype", -1);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().jdField_a_of_type_Int != i)
            {
              bool1 = bool2;
            }
            else
            {
              QFileAssistantUtils.a((String)localObject);
              bool1 = true;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("canReuseChatPie: ");
      paramIntent.append(bool1);
      QLog.i("Q.aio.ChatFragment", 2, paramIntent.toString());
    }
    return bool1;
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
        if (localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie, paramIntent))
        {
          if (localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
            c();
          }
          a(localBaseChatPie);
          return false;
        }
      }
      c();
      a(a(localIChatPieCreator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, paramIntent)), paramIntent);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.ChatFragment", 2, "AIOTime getChatPie no Type at default");
    }
    return !c(paramIntent);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
  }
  
  protected void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if ((!((BaseChatPie)localObject).r) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(paramInt);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onShowFirst return|");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" hasDestory:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B);
        QLog.i("Q.aio.ChatFragment", 1, ((StringBuilder)localObject).toString());
      }
      g();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.j(paramBoolean);
    }
  }
  
  protected boolean b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool = false;
    if ((localObject != null) && (!paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.z();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getChatPie doOnNewIntent_clearBusinessData ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i = paramIntent.getIntExtra("chat_subType", 0);
    localObject = paramIntent.getStringExtra("uin");
    if ((localObject != null) && (((String)localObject).length() >= 4) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChatPie uin=");
      localStringBuilder.append(((String)localObject).substring(((String)localObject).length() - 4));
      QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChatPie subType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" type = ");
      ((StringBuilder)localObject).append(paramIntent.getIntExtra("uintype", -1));
      ((StringBuilder)localObject).append(" mRootView is null?: ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
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
      if ((localBaseChatPie.d() != 6) && (!localBaseChatPie.s())) {
        localBaseChatPie.u();
      }
      if (!localBaseChatPie.s()) {
        localBaseChatPie.p();
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
    Object localObject;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null) {
        ((SystemBarCompact)localObject).setStatusBarVisible(paramInt, 0);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fight doInMultiWindowModeStatusBarVisibilityChange  = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent()))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject1 != null) {
        ((PhotoListHelper)((BaseChatPie)localObject1).a(7)).c();
      }
    }
    else if (b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558789, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView((View)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("Q.aio.ChatFragment", 2, "onNewIntent mRootView == null---created a new Pie");
      }
    }
    else
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onNewIntent mBasePie.doOnCreate(false) reuse the pie. same session: ");
        boolean bool;
        if (localObject1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeAllViews();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558789, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView((View)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
    {
      a(false);
      this.b = true;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)
    {
      int i = getResources().getColor(2131167114);
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(i);
    }
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.F();
    }
  }
  
  public void f()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.E();
    }
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flingLToR ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null) {
      ((BaseChatPie)localObject).c(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flingRToL ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      QLog.d("Q.aio.ChatFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void g()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      BaseActivity localBaseActivity = getBaseActivity();
      int j = 0;
      int i;
      if ((localBaseActivity != null) && (getBaseActivity().isInMultiWindow()) && (getBaseActivity().isNeedStatusBarGone()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.aio.ChatFragment", 4, "fight onMulitWindowModePause isNeedStatusBarGone = true");
        }
        i = 0;
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        i = j;
      } else {
        i = 2;
      }
      c(i);
    }
  }
  
  public String getCIOPageName()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      return localBaseChatPie.getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      c();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramInt1, paramInt2, paramIntent);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 1026))
    {
      localIntent.putExtra("uintype", 1);
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "check UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramConfiguration);
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
      if (paramInt2 == 2130772074)
      {
        localObject = new AIOEnterInAni();
        ((Animation)localObject).setDuration(getBaseActivity().getResources().getInteger(2131427333));
        ((Animation)localObject).setInterpolator(getBaseActivity(), 17432580);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(getBaseActivity(), paramInt2);
      }
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
      return localObject;
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
    paramLayoutInflater = null;
    StartupTracker.a(null, "AIO_onCreateView");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener = new ChatFragment.InterceptTouchEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new ChatFragmentTopGestureLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$MyDispatchDrawListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatFragment$InterceptTouchEventListener);
      paramViewGroup = (View)paramViewGroup.getParent();
      if (paramViewGroup != null) {
        paramViewGroup.setBackgroundResource(2130850615);
      }
      paramViewGroup = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setLayoutParams(paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(this);
      try
      {
        paramViewGroup = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558789, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(paramViewGroup);
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = new DrawerFrame(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, true);
        paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.setLayoutParams(paramLayoutInflater);
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
        a(false);
        this.b = true;
        if (!QLog.isColorLevel()) {
          break label248;
        }
        QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
      }
      catch (Exception paramViewGroup)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramViewGroup);
        break label295;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.getParent() != null)
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame);
    }
    label248:
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()) - 10, 0, 0);
    }
    StartupTracker.a("AIO_onCreateView", null);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame;
    label295:
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    StartupTracker.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    StartupTracker.a("AIO_Super_onDestroy", "AIO_onDestroy");
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).p();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (localObject != null)
    {
      ((SystemBarCompact)localObject).setgetStatusBarVisible(false, 0);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHiddenChanged hidden = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      this.c = true;
      onPause();
      onStop();
      this.c = false;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 500L);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      if (((Intent)localObject).getBooleanExtra("isFromMainTab", false))
      {
        onStart();
        onResume();
      }
      else if (((Intent)localObject).getBooleanExtra("isFromContactTab", false))
      {
        onStart();
      }
    }
    super.onHiddenChanged(paramBoolean);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).v();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPause ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    NewAIOTimeReporter.a().a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTimeReporter;
    if (localObject != null) {
      ((AIOTimeReporter)localObject).a();
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
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
      }
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.y();
    }
    getBaseActivity().getWindow().setSoftInputMode(18);
    if (BaseApplicationImpl.appStartTime > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("actStartChat, cost=");
      localStringBuilder.append(SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime);
      Log.d("AutoMonitor", localStringBuilder.toString());
    }
    StartupTracker.a("AIO_onResume", "AIO_onDrawView");
  }
  
  public void onStart()
  {
    super.onStart();
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStart return");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).t();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStart ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
      int i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("uintype", -1);
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).addAioEnterAndOutInfo(1, null, (String)localObject, i, -1);
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).u();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStop ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
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
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((paramView != null) && (paramView.c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    }
    boolean bool = b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent());
    paramView = new StringBuilder();
    paramView.append("create new chat pie: ");
    paramView.append(bool);
    QLog.d("Q.aio.ChatFragment", 1, paramView.toString());
    StartupTracker.a("AIO_onCreate_getPieCost", null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      if (c())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(false);
      }
    }
    StartupTracker.a("AIO_onViewCreated", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */