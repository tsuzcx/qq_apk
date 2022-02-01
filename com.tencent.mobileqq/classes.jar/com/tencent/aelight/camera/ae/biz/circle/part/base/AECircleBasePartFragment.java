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
  private LifecycleRegistry jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidArchLifecycleViewModelStore;
  protected View a;
  private AECirclePartManager jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
  
  protected abstract int a();
  
  public AECirclePartManager a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
  }
  
  protected abstract List<AECircleBasePart> a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityCreated(getActivity(), paramBundle);
    }
  }
  
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (this.jdField_a_of_type_AndroidArchLifecycleViewModelStore == null) {
        this.jdField_a_of_type_AndroidArchLifecycleViewModelStore = new ViewModelStore();
      }
      return this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AECirclePartManager localAECirclePartManager = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
    if (localAECirclePartManager != null) {
      localAECirclePartManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    AECirclePartManager localAECirclePartManager = this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager;
    if (localAECirclePartManager != null) {
      localAECirclePartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry = new LifecycleRegistry(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager = new AECirclePartManager(this, getView());
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.a(a());
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
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
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, localThrowable, new Object[0]);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityDestroyed(getActivity());
    }
    catch (Throwable localThrowable)
    {
      label28:
      ViewModelStore localViewModelStore;
      break label28;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    localViewModelStore = this.jdField_a_of_type_AndroidArchLifecycleViewModelStore;
    if (localViewModelStore != null) {
      localViewModelStore.clear();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityPaused(getActivity());
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
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityResumed(getActivity());
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
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityStarted(getActivity());
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
      this.jdField_a_of_type_AndroidArchLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCirclePartBaseAECirclePartManager.onActivityStopped(getActivity());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePartFragment
 * JD-Core Version:    0.7.0.1
 */