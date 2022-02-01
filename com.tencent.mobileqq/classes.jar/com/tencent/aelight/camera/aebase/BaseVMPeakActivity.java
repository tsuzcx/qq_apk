package com.tencent.aelight.camera.aebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseVMPeakActivity
  extends PeakActivity
  implements LifecycleOwner, ViewModelStoreOwner
{
  private LifecycleRegistry a = new LifecycleRegistry(this);
  private ViewModelStore b;
  
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new LifecycleRegistry(this);
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      return;
    }
    catch (Throwable paramBundle)
    {
      label28:
      break label28;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    if ((this.b != null) && (!isChangingConfigurations())) {
      this.b.clear();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      return;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      return;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
  }
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
      return;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
  }
  
  protected void onStop()
  {
    super.onStop();
    try
    {
      this.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      return;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.BaseVMPeakActivity
 * JD-Core Version:    0.7.0.1
 */