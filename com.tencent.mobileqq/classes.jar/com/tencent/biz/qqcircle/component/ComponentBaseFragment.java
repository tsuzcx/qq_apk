package com.tencent.biz.qqcircle.component;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tvg;
import tvn;
import tyz;

public abstract class ComponentBaseFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  public static final String a;
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  public View a;
  private tvn jdField_a_of_type_Tvn;
  
  static
  {
    jdField_a_of_type_JavaLangString = ComponentBaseFragment.class.getSimpleName();
  }
  
  protected abstract int a();
  
  protected abstract List<tvg> a();
  
  public tvn a()
  {
    return this.jdField_a_of_type_Tvn;
  }
  
  public <T extends tyz> T a(ComponentBaseFragment paramComponentBaseFragment, String paramString, Class<T> paramClass)
  {
    ViewModelProvider localViewModelProvider = new ViewModelProvider(paramComponentBaseFragment, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
    if (paramString == null) {}
    for (paramString = "android.arch.lifecycle.ViewModelProvider.DefaultKey";; paramString = paramString + paramClass.getCanonicalName())
    {
      paramString = (tyz)localViewModelProvider.get(paramString, paramClass);
      paramString.a(paramComponentBaseFragment.getActivity().hashCode());
      return paramString;
    }
  }
  
  public <T extends tyz> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends tyz> T a(String paramString, Class<T> paramClass)
  {
    return a(this, paramString, paramClass);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Tvn != null)
    {
      this.jdField_a_of_type_Tvn.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Tvn.onActivityCreated(getActivity(), paramBundle);
    }
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Tvn != null) {
      this.jdField_a_of_type_Tvn.a(paramInt1, paramInt2, paramIntent);
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
    if (this.jdField_a_of_type_Tvn != null) {
      this.jdField_a_of_type_Tvn.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_Tvn = new tvn(this, getView());
    this.jdField_a_of_type_Tvn.a(a());
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
      a(paramLayoutInflater, paramViewGroup, paramBundle);
      return this.jdField_a_of_type_AndroidViewView;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
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
      this.jdField_a_of_type_Tvn.onActivityDestroyed(getActivity());
      if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore != null) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.jdField_a_of_type_Tvn.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.jdField_a_of_type_Tvn.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.jdField_a_of_type_Tvn.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.jdField_a_of_type_Tvn.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.component.ComponentBaseFragment
 * JD-Core Version:    0.7.0.1
 */