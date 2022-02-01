package com.tencent.biz.subscribe.part;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

public abstract class BasePartFragment
  extends PublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner
{
  protected View a;
  private LifecycleRegistry b = new LifecycleRegistry(this);
  private ViewModelStore c;
  private PartManager d;
  
  private void g()
  {
    View localView = new View(getBaseActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getBaseActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void h() {}
  
  private void i()
  {
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      long l = getBaseActivity().getIntent().getLongExtra("key_bundle_open_page_time", 0L);
      if (l != 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openPageTime = ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.i("BasePartFragment", 1, localStringBuilder.toString());
      }
    }
  }
  
  public PartManager a()
  {
    return this.d;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.d;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.a);
      this.d.onActivityCreated(getBaseActivity(), paramBundle);
    }
    if ((c()) && (d())) {
      getBaseActivity().getWindow().setFlags(1024, 1024);
    }
    i();
    h();
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected boolean d()
  {
    return false;
  }
  
  protected abstract int e();
  
  protected abstract List<Part> f();
  
  public Lifecycle getLifecycle()
  {
    return this.b;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (this.c == null) {
        this.c = new ViewModelStore();
      }
      return this.c;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((SubscribeUtils.a()) && (b())) {
      g();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PartManager localPartManager = this.d;
    if (localPartManager != null) {
      localPartManager.a(paramInt1, paramInt2, paramIntent);
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
    PartManager localPartManager = this.d;
    if (localPartManager != null) {
      localPartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new LifecycleRegistry(this);
    this.d = new PartManager(this, getView());
    this.d.a(f());
    try
    {
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
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
      this.a = paramLayoutInflater.inflate(e(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BasePartFragment", 1, localThrowable, new Object[0]);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
      this.d.onActivityDestroyed(getBaseActivity());
    }
    catch (Throwable localThrowable)
    {
      label28:
      ViewModelStore localViewModelStore;
      break label28;
    }
    QLog.e("BasePartFragment", 1, "mLifecycleRegistry 初始化失败");
    localViewModelStore = this.c;
    if (localViewModelStore != null) {
      localViewModelStore.clear();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
      this.d.onActivityPaused(getBaseActivity());
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
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
      this.d.onActivityResumed(getBaseActivity());
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
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_START);
      this.d.onActivityStarted(getBaseActivity());
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
      this.b.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
      this.d.onActivityStopped(getBaseActivity());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BasePartFragment
 * JD-Core Version:    0.7.0.1
 */