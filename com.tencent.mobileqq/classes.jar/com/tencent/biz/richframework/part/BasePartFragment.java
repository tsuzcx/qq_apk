package com.tencent.biz.richframework.part;

import aabb;
import aabe;
import aabf;
import aaek;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import uzg;
import vuc;

public abstract class BasePartFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private aabf jdField_a_of_type_Aabf;
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  public View a;
  protected TopGestureLayout a;
  
  private void a()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void b()
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "small_world_base");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new vuc().a(c()).a());
  }
  
  private void c()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      long l = getActivity().getIntent().getLongExtra("key_bundle_open_page_time", 0L);
      if (l != 0L) {
        QLog.i("BasePartFragment", 1, "openPageTime = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  protected abstract int a();
  
  public <T extends aabb> T a(BasePartFragment paramBasePartFragment, String paramString, Class<T> paramClass)
  {
    ViewModelProvider localViewModelProvider = new ViewModelProvider(paramBasePartFragment, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
    if (paramString == null) {}
    for (paramString = "android.arch.lifecycle.ViewModelProvider.DefaultKey";; paramString = paramString + paramClass.getCanonicalName())
    {
      paramString = (aabb)localViewModelProvider.get(paramString, paramClass);
      paramString.a(paramBasePartFragment.getActivity().hashCode());
      return paramString;
    }
  }
  
  public <T extends aabb> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends aabb> T a(String paramString, Class<T> paramClass)
  {
    return a(this, paramString, paramClass);
  }
  
  public aabf a()
  {
    return this.jdField_a_of_type_Aabf;
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  protected abstract List<aabe> a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aabf != null)
    {
      this.jdField_a_of_type_Aabf.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Aabf.onActivityCreated(getActivity(), paramBundle);
    }
    if (f_())
    {
      paramLayoutInflater = getActivity().mSystemBarComp;
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater.init();
        paramLayoutInflater.setStatusBarVisible(2, 0);
      }
      if (!e_()) {
        break label91;
      }
      getActivity().getWindow().setFlags(1024, 1024);
    }
    for (;;)
    {
      c();
      b();
      return;
      label91:
      if (((getActivity() instanceof QCircleFragmentActivity)) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        uzg.a(getActivity(), b());
        ImmersiveUtils.a(true, getActivity().getWindow());
      }
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected abstract int b();
  
  public abstract String c();
  
  public void c(boolean paramBoolean)
  {
    try
    {
      TopGestureLayout localTopGestureLayout = a();
      if (localTopGestureLayout != null) {
        localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BasePartFragment", 2, "enableFlingRight->enable:" + paramBoolean);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("BasePartFragment", 2, "enableFlingRight exception" + localException.toString());
    }
  }
  
  protected boolean e_()
  {
    return false;
  }
  
  protected boolean f_()
  {
    return true;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore == null) {
      this.jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
    }
    return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((aaek.a()) && (a())) {
      a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Aabf != null) {
      this.jdField_a_of_type_Aabf.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (a().a()) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Aabf != null) {
      this.jdField_a_of_type_Aabf.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_Aabf = new aabf(this, getView());
    this.jdField_a_of_type_Aabf.a(a());
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
      a(paramLayoutInflater, paramViewGroup, paramBundle);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BasePartFragment", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.jdField_a_of_type_Aabf.onActivityDestroyed(getActivity());
      if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.jdField_a_of_type_Aabf.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.jdField_a_of_type_Aabf.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.jdField_a_of_type_Aabf.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.jdField_a_of_type_Aabf.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.BasePartFragment
 * JD-Core Version:    0.7.0.1
 */