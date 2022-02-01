package com.tencent.aelight.camera.aebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.IQIMCameraLifeCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class QIMCameraLifeCycleBaseUnit
  implements LifecycleOwner, ViewModelStoreOwner, IQIMCameraLifeCallback
{
  private LifecycleRegistry a = new LifecycleRegistry(this);
  private ViewModelStore b;
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  @CallSuper
  public void a(Bundle paramBundle)
  {
    this.a = new LifecycleRegistry(this);
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      label23:
      break label23;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return false;
  }
  
  @CallSuper
  public void ai()
  {
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
      return;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
  }
  
  @CallSuper
  public void aj()
  {
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      return;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
  }
  
  public boolean ak()
  {
    return false;
  }
  
  public void al() {}
  
  public void b(Bundle paramBundle) {}
  
  public void e(boolean paramBoolean) {}
  
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
  
  public View j()
  {
    return null;
  }
  
  @CallSuper
  public void k()
  {
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      return;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
  }
  
  @CallSuper
  public void l()
  {
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      return;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
  }
  
  @CallSuper
  public void m()
  {
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
    catch (Throwable localThrowable)
    {
      label13:
      ViewModelStore localViewModelStore;
      break label13;
    }
    QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    localViewModelStore = this.b;
    if (localViewModelStore != null) {
      localViewModelStore.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit
 * JD-Core Version:    0.7.0.1
 */