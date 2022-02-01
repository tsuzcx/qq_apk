package com.tencent.aelight.camera.ae.biz.circle.part.base;

import android.app.Fragment;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
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
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class AECircleBasePartFragment
  extends Fragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry a = new LifecycleRegistry(this);
  private ViewModelStore b;
  private AECirclePartManager c;
  protected View j;
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.c;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.j);
      this.c.onActivityCreated(getActivity(), paramBundle);
    }
  }
  
  protected abstract List<AECircleBasePart> b();
  
  protected abstract int c();
  
  public Lifecycle getLifecycle()
  {
    return this.a;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (this.b == null) {
        this.b = new ViewModelStore();
      }
      return this.b;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public AECirclePartManager h()
  {
    return this.c;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AECirclePartManager localAECirclePartManager = this.c;
    if (localAECirclePartManager != null) {
      localAECirclePartManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    AECirclePartManager localAECirclePartManager = this.c;
    if (localAECirclePartManager != null) {
      localAECirclePartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new LifecycleRegistry(this);
    this.c = new AECirclePartManager(this, getView());
    this.c.a(b());
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      label55:
      break label55;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      this.j = paramLayoutInflater.inflate(c(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, localThrowable, new Object[0]);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.j;
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.c.onActivityDestroyed(getActivity());
    }
    catch (Throwable localThrowable)
    {
      label28:
      ViewModelStore localViewModelStore;
      break label28;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    localViewModelStore = this.b;
    if (localViewModelStore != null) {
      localViewModelStore.clear();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.c.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.c.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.c.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.c.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePartFragment
 * JD-Core Version:    0.7.0.1
 */