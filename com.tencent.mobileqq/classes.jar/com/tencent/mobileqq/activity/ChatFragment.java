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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.activity.aio.NewAIOTimeReporter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOEnterInAni;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.ChatPieCache;
import com.tencent.mobileqq.activity.aio.core.IChatPieCacheService;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChatFragment
  extends BaseFragment
  implements TopGestureLayout.OnGestureListener
{
  public static volatile boolean a = false;
  private static boolean n = false;
  private static SparseArray<Animation> o = new SparseArray(2);
  protected ChatPieCache b;
  public BaseChatPie c;
  public QQAppInterface d;
  public Context e;
  public BaseActivity f;
  protected DrawerFrame g;
  public TopGestureLayout h;
  protected boolean i = false;
  protected AIOTimeReporter j;
  protected ChatFragment.MyDispatchDrawListener k;
  protected ChatFragment.InterceptTouchEventListener l;
  protected boolean m = false;
  private Animation.AnimationListener p = new ChatFragment.2(this);
  
  public static ChatFragment a()
  {
    ChatFragment localChatFragment = new ChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localChatFragment.setArguments(localBundle);
    return localChatFragment;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (n != paramBoolean) {
      n = paramBoolean;
    }
  }
  
  private void s()
  {
    if (this.i)
    {
      Object localObject1 = this.f.getIntent();
      int i1 = -1;
      if (localObject1 != null) {
        i1 = this.f.getIntent().getIntExtra("uintype", -1);
      }
      if (QLog.isColorLevel())
      {
        Object localObject2 = this.f.getIntent().getStringExtra("KEY_FROM");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ComponentName localComponentName = this.f.getCallingActivity();
          localObject1 = localObject2;
          if (localComponentName != null) {
            localObject1 = localComponentName.getClassName();
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("aio drawComplete,duration:");
        ((StringBuilder)localObject2).append(StartupTracker.b);
        ((StringBuilder)localObject2).append(",from:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Q.PerfTrace", 2, ((StringBuilder)localObject2).toString());
      }
      int i2 = a ^ true;
      PerformanceReportUtils.a("actFPSAIO", SystemClock.uptimeMillis());
      PerformanceReportUtils.a(this.e, this.d.getCurrentAccountUin(), i1, StartupTracker.b);
      a = true;
      this.i = false;
      ThreadManager.post(new ChatFragment.1(this, i1, i2), 5, null, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("AIOTime aioOpenTimeReport end Cost ");
        ((StringBuilder)localObject1).append(StartupTracker.b);
        ((StringBuilder)localObject1).append(" AIOType: ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(" firstOpenAIO: ");
        ((StringBuilder)localObject1).append(i2);
        QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      localBaseChatPie.f(paramInt);
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      localBaseChatPie.a(paramInt, paramDialog);
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject = this.c;
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
      else if (this.c.aY)
      {
        bool1 = bool2;
      }
      else
      {
        localObject = paramIntent.getStringExtra("uin");
        String str = this.c.aE().b;
        bool1 = bool2;
        if (!TextUtils.isEmpty(str)) {
          if (!((String)localObject).equals(str))
          {
            bool1 = bool2;
          }
          else
          {
            int i1 = paramIntent.getIntExtra("uintype", -1);
            if (this.c.aE().a != i1)
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
  
  protected Dialog b(int paramInt)
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      return localBaseChatPie.h(paramInt);
    }
    return null;
  }
  
  protected void b()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      TopGestureLayout localTopGestureLayout = this.h;
      if ((localTopGestureLayout instanceof ChatFragmentTopGestureLayout))
      {
        localTopGestureLayout.setFitsSystemWindows(true);
        ((ChatFragmentTopGestureLayout)this.h).disableTopInset();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      localBaseChatPie.m(paramBoolean);
    }
  }
  
  public boolean b(Intent paramIntent)
  {
    if (a(paramIntent))
    {
      paramIntent = this.c;
      if (paramIntent != null) {
        ((PhotoListHelper)paramIntent.q(7)).c();
      }
      return true;
    }
    return false;
  }
  
  protected void c(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if ((!((BaseChatPie)localObject).aD) && (!this.c.aY))
      {
        this.c.l(paramInt);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onShowFirst return|");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" hasDestory:");
        ((StringBuilder)localObject).append(this.c.aY);
        QLog.i("Q.aio.ChatFragment", 1, ((StringBuilder)localObject).toString());
      }
      p();
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public void d()
  {
    this.f.setChatFragmentType(BaseActivity.CHAT_FRAGMENT_TYPE);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fight doInMultiWindowModeStatusBarVisibilityChange  = ");
      localStringBuilder.append(paramInt);
      QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    Object localObject = (ImmersiveTitleBar2)this.h.findViewById(2131447582);
    if (localObject == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      Drawable localDrawable;
      if ((this.c.ah.i) && (this.c.ah.l) && (!this.c.ah.k))
      {
        localDrawable = QIMUserManager.b().b(4);
        if (localDrawable != null) {
          ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(localDrawable);
        } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(getResources().getDrawable(2130847834));
        }
      }
      else if ((this.c.ah.j) && (this.c.ah.m) && (!this.c.ah.k))
      {
        localDrawable = TIMUserManager.b().b(4);
        if (localDrawable != null) {
          ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(localDrawable);
        } else if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(getResources().getDrawable(2130847834));
        }
      }
      else if ((QQTheme.isSimpleWhite()) && (BlurUtil.a()))
      {
        ((ImmersiveTitleBar2)localObject).setBackgroundColor(0);
      }
      else if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        ((ImmersiveTitleBar2)localObject).setBackgroundDrawable(getResources().getDrawable(2130847834));
      }
      else
      {
        ((ImmersiveTitleBar2)localObject).setBackgroundColor(getResources().getColor(2131168092));
      }
    }
    SimpleUIUtil.a((ImmersiveTitleBar2)localObject, getActivity().getWindow());
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("duration=====");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.i("systembar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean f()
  {
    return ((this.f instanceof SplashActivity)) && (SplashActivity.currentFragment == 1);
  }
  
  public void flingLToR()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flingLToR ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((BaseChatPie)localObject).f(true);
    }
  }
  
  public void flingRToL()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flingRToL ");
      localStringBuilder.append(this.c);
      QLog.d("Q.aio.ChatFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void g()
  {
    if (isVisible())
    {
      Object localObject = getFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).hide(this);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      StartupTracker.a("AIO_preLoad_Cost", null);
      long l1 = SystemClock.uptimeMillis() - AIOPreLoadEngine.c;
      PerformanceReportUtils.a(this.e, this.d.getCurrentAccountUin(), 10, l1);
      if (!QLog.isColorLevel()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AIO preLoad cost:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public String getCIOPageName()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      return localBaseChatPie.getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  protected void h()
  {
    this.d = getBaseActivity().app;
  }
  
  protected boolean i()
  {
    if (this.c != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent ");
        localStringBuilder.append(this.c.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
      }
      return this.c.V();
    }
    return false;
  }
  
  public QQAppInterface j()
  {
    return this.d;
  }
  
  public BaseChatPie k()
  {
    return this.c;
  }
  
  public void l()
  {
    if (this.b == null) {
      return;
    }
    d();
    Object localObject1 = this.b.c();
    if (!b(this.f.getIntent()))
    {
      boolean bool = this.b.a(this.f.getIntent(), this.h);
      this.c = this.b.c();
      if (bool)
      {
        if (this.h != null)
        {
          if ((localObject1 != null) && (((BaseChatPie)localObject1).aW() != null) && (((BaseChatPie)localObject1).aW() != this.h)) {
            ((BaseChatPie)localObject1).aW().removeAllViews();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.aio.ChatFragment", 2, "onNewIntent mRootView != null---created a new Pie");
          }
          this.h.removeAllViews();
          localObject1 = View.inflate(this.f, 2131624409, null);
          this.h.addView((View)localObject1);
          this.c.a(false);
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
          if (localObject1 == this.c) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject2).append(bool);
          QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (localObject1 != this.c)
        {
          if ((localObject1 != null) && (((BaseChatPie)localObject1).aW() != null) && (((BaseChatPie)localObject1).aW() != this.h)) {
            ((BaseChatPie)localObject1).aW().removeAllViews();
          }
          this.h.removeAllViews();
          localObject2 = this.c.ba;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = View.inflate(this.f, 2131624409, null);
          }
          this.h.addView((View)localObject1);
        }
        this.c.a(false);
      }
    }
    if (this.h != null)
    {
      a(false);
      this.i = true;
    }
    this.b.a();
  }
  
  protected boolean m()
  {
    return true;
  }
  
  public void n()
  {
    e();
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      localBaseChatPie.ai();
    }
  }
  
  public void o()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null) {
      localBaseChatPie.ah();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseChatPie localBaseChatPie = this.c;
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
    this.j = new AIOTimeReporter();
    this.f = ((BaseActivity)paramActivity);
    Intent localIntent = this.f.getIntent();
    if ((localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 1026))
    {
      localIntent.putExtra("uintype", 1);
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "check UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    this.d = this.f.app;
    this.e = paramActivity;
    this.k = new ChatFragment.MyDispatchDrawListener(this);
    if ((this.f instanceof SplashActivity)) {
      this.b = ((IChatPieCacheService)this.d.getRuntimeService(IChatPieCacheService.class, "")).getChatPieCache();
    } else {
      this.b = new ChatPieCache();
    }
    this.b.a(this.f);
    StartupTracker.a("AIO_onAttach", null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.ChatFragment", 2, "onConfigurationChanged");
    }
    BaseChatPie localBaseChatPie = this.c;
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
    Object localObject = (Animation)o.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772104)
      {
        localObject = new AIOEnterInAni();
        ((Animation)localObject).setDuration(getBaseActivity().getResources().getInteger(2131492874));
        ((Animation)localObject).setInterpolator(getBaseActivity(), 17432580);
        ((Animation)localObject).setAnimationListener(this.p);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(getBaseActivity(), paramInt2);
      }
      o.put(paramInt2, localObject);
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
    if (this.h == null)
    {
      this.l = new ChatFragment.InterceptTouchEventListener(this);
      this.h = new ChatFragmentTopGestureLayout(this.f, this.k, this.l);
      paramViewGroup = (View)paramViewGroup.getParent();
      if (paramViewGroup != null) {
        paramViewGroup.setBackgroundResource(2130852413);
      }
      paramViewGroup = new ViewGroup.LayoutParams(-1, -1);
      this.h.setLayoutParams(paramViewGroup);
      this.h.setOnFlingGesture(this);
      try
      {
        paramViewGroup = View.inflate(this.f, 2131624409, null);
        this.h.addView(paramViewGroup);
        this.g = new DrawerFrame(this.f, this.h, true);
        paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
        this.g.setLayoutParams(paramLayoutInflater);
        this.g.addView(this.h);
        a(false);
        this.i = true;
        if (!QLog.isColorLevel()) {
          break label248;
        }
        QLog.i("Q.aio.ChatFragment", 2, "onCreateView mRootView == null");
      }
      catch (Exception paramViewGroup)
      {
        QLog.i("Q.aio.ChatFragment", 1, "onCreateView:", paramViewGroup);
        break label264;
      }
    }
    else if (this.g.getParent() != null)
    {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    }
    label248:
    b();
    StartupTracker.a("AIO_onCreateView", null);
    paramLayoutInflater = this.g;
    label264:
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    StartupTracker.a(null, "AIO_Super_onDestroy");
    super.onDestroy();
    StartupTracker.a("AIO_Super_onDestroy", "AIO_onDestroy");
    o.clear();
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).K();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDestroy ");
        ((StringBuilder)localObject).append(this.c.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    StartupTracker.a("AIO_onDestroy", null);
  }
  
  public void onDestroyView()
  {
    StartupTracker.a(null, "AIO_Super_onDestroyView");
    super.onDestroyView();
    Object localObject = this.h;
    if ((localObject instanceof ChatFragmentTopGestureLayout))
    {
      localObject = (ChatFragmentTopGestureLayout)localObject;
      if (localObject != null)
      {
        ((ChatFragmentTopGestureLayout)localObject).setOnFlingGesture(null);
        ((ChatFragmentTopGestureLayout)localObject).setMyDispatchDrawListener(null);
        ((ChatFragmentTopGestureLayout)localObject).setInterceptTouchEventListener(null);
      }
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
    if (!m())
    {
      super.onHiddenChanged(paramBoolean);
      return;
    }
    if (paramBoolean)
    {
      this.m = true;
      onPause();
      onStop();
      this.m = false;
      localObject = this.b;
      if (localObject != null) {
        ((ChatPieCache)localObject).b();
      }
    }
    else
    {
      localObject = this.f.getIntent();
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
    if ((f()) && (!this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onPause return");
      }
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).P();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPause ");
        ((StringBuilder)localObject).append(this.c.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    NewAIOTimeReporter.b().c();
    localObject = this.j;
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
    if ((f()) && (!this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onResume return");
      }
      g();
      return;
    }
    StringBuilder localStringBuilder;
    if (this.c != null)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResume ");
        localStringBuilder.append(this.c.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, localStringBuilder.toString());
      }
      e();
      this.c.S();
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
    if ((f()) && (!this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStart return");
      }
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).N();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStart ");
        ((StringBuilder)localObject).append(this.c.hashCode());
        QLog.i("Q.aio.ChatFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.f.getIntent() != null)
    {
      localObject = this.f.getIntent().getStringExtra("uin");
      int i1 = this.f.getIntent().getIntExtra("uintype", -1);
      ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).addAioEnterAndOutInfo(1, null, (String)localObject, i1, -1);
    }
  }
  
  public void onStop()
  {
    StartupTracker.a(null, "AIO_Super_onStop");
    super.onStop();
    StartupTracker.a("AIO_Super_onStop", "AIO_onStop");
    if ((f()) && (!this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.ChatFragment", 2, "onStop return");
      }
      return;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((BaseChatPie)localObject).O();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStop ");
        ((StringBuilder)localObject).append(this.c.hashCode());
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
    paramView = this.c;
    if ((paramView != null) && (paramView.aZ == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.ChatFragment", 2, "onViewCreated mBasePie is not null and mAIORootView is null, is fail");
      }
      this.c.aZ = this.h;
    }
    paramView = this.b.c();
    if ((paramView != null) && (paramView.aW() != null) && (paramView.aW() != this.h)) {
      paramView.aW().removeAllViews();
    }
    d();
    boolean bool = this.b.a(this.f.getIntent(), this.h);
    this.c = this.b.c();
    paramView = new StringBuilder();
    paramView.append("create new chat pie: ");
    paramView.append(bool);
    QLog.d("Q.aio.ChatFragment", 1, paramView.toString());
    StartupTracker.a("AIO_onCreate_getPieCost", null);
    if (this.c != null) {
      if ((f()) && (c()))
      {
        this.h.setVisibility(4);
        this.c.k();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.ChatFragment", 2, "BaseChatPie pre-start.");
        }
      }
      else
      {
        this.c.a(false);
      }
    }
    StartupTracker.a("AIO_onViewCreated", null);
  }
  
  public void p()
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      BaseActivity localBaseActivity = getBaseActivity();
      int i2 = 0;
      int i1;
      if ((localBaseActivity != null) && (getBaseActivity().isInMultiWindow()) && (getBaseActivity().isNeedStatusBarGone()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.aio.ChatFragment", 4, "fight onMulitWindowModePause isNeedStatusBarGone = true");
        }
        i1 = 0;
      }
      else
      {
        i1 = 1;
      }
      if (i1 != 0) {
        i1 = i2;
      } else {
        i1 = 2;
      }
      d(i1);
    }
  }
  
  public ImmersiveTitleBar2 q()
  {
    return (ImmersiveTitleBar2)this.h.findViewById(2131447582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatFragment
 * JD-Core Version:    0.7.0.1
 */