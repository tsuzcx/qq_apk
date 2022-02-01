package com.tencent.biz.subscribe.part;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public abstract class BasePartFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  protected View a;
  private PartManager jdField_a_of_type_ComTencentBizSubscribePartPartManager;
  
  private void a()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void b() {}
  
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
  
  public PartManager a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartPartManager;
  }
  
  protected abstract List<Part> a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartPartManager != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityCreated(getActivity(), paramBundle);
    }
    if ((b()) && (c())) {
      getActivity().getWindow().setFlags(1024, 1024);
    }
    c();
    b();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((SubscribeUtils.a()) && (a())) {
      a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizSubscribePartPartManager != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((a() != null) && (a().a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentBizSubscribePartPartManager != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartPartManager = new PartManager(this, getView());
    this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.a(a());
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
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityDestroyed(getActivity());
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
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityPaused(getActivity());
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
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityResumed(getActivity());
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
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityStarted(getActivity());
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
      this.jdField_a_of_type_ComTencentBizSubscribePartPartManager.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BasePartFragment
 * JD-Core Version:    0.7.0.1
 */