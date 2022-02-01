package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelStore;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.RFThemeUtil;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

public abstract class BasePartFragment
  extends CompatPublicFragment
  implements IPartHost
{
  public static final int E = 2131446834;
  protected PartManager C;
  protected View D;
  private ViewModelStore a;
  private Activity b;
  
  public <T extends BaseViewModel> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends BaseViewModel> T a(String paramString, Class<T> paramClass)
  {
    return getViewModel(this, paramString, paramClass);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.C;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.D);
      this.C.onActivityCreated(getActivity(), paramBundle);
    }
    if (v())
    {
      if (bh_()) {
        ah();
      } else {
        ag();
      }
      af();
    }
  }
  
  protected void af()
  {
    if ((ImmersiveUtils.d() == 1) && (getActivity() != null)) {
      ImmersiveUtils.a(q(), getActivity().getWindow());
    }
  }
  
  protected void ag()
  {
    if (ImmersiveUtils.d() == 1)
    {
      if (ai()) {
        RFThemeUtil.a(getActivity(), j());
      }
      if (s())
      {
        View localView = this.D;
        if (localView != null) {
          localView.setFitsSystemWindows(true);
        }
      }
    }
  }
  
  protected void ah()
  {
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      ImmersiveUtils.a(getActivity().getWindow());
    }
  }
  
  protected boolean ai()
  {
    return true;
  }
  
  public abstract String b();
  
  public void beforeFinish()
  {
    PartManager localPartManager = this.C;
    if (localPartManager != null) {
      localPartManager.c();
    }
  }
  
  protected boolean bh_()
  {
    return false;
  }
  
  protected abstract int c();
  
  protected abstract List<Part> d();
  
  public Activity getHostActivity()
  {
    if (getActivity() != null) {
      return getActivity();
    }
    return this.b;
  }
  
  public <T extends BaseViewModel> T getViewModel(IPartHost paramIPartHost, String paramString, Class<T> paramClass)
  {
    ViewModelProvider localViewModelProvider = new ViewModelProvider(paramIPartHost, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()));
    if (paramString == null)
    {
      paramIPartHost = paramClass.getCanonicalName();
    }
    else
    {
      paramIPartHost = new StringBuilder();
      paramIPartHost.append(paramString);
      paramIPartHost.append(paramClass.getCanonicalName());
      paramIPartHost = paramIPartHost.toString();
    }
    paramIPartHost = (BaseViewModel)localViewModelProvider.get(paramIPartHost, paramClass);
    if (getHostActivity() != null) {
      paramIPartHost.b(getHostActivity().hashCode());
    }
    return paramIPartHost;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (getActivity().getApplication() != null)
    {
      if (this.a == null) {
        this.a = new ViewModelStore();
      }
      return this.a;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public Object getViewTagData()
  {
    View localView = this.D;
    if (localView != null) {
      return localView.getTag(E);
    }
    return null;
  }
  
  protected abstract int j();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PartManager localPartManager = this.C;
    if (localPartManager != null) {
      localPartManager.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAttach(@NonNull Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = paramActivity;
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if ((paramContext instanceof Activity)) {
      this.b = ((Activity)paramContext);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((p() != null) && (p().a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    PartManager localPartManager = this.C;
    if (localPartManager != null) {
      localPartManager.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.C = p();
    this.C.a(d());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.D = paramLayoutInflater.inflate(c(), paramViewGroup, false);
    this.D.setTag(E, r());
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = this.D;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  @CallSuper
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.C.onActivityDestroyed(getActivity());
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    ViewModelStore localViewModelStore = this.a;
    if (localViewModelStore != null) {
      localViewModelStore.clear();
    }
  }
  
  public void onFinish()
  {
    PartManager localPartManager = this.C;
    if (localPartManager != null) {
      localPartManager.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.C.onActivityPaused(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.C.onActivityResumed(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (RFApplication.isDebug())
    {
      this.C.onActivityStarted(getActivity());
      return;
    }
    try
    {
      this.C.onActivityStarted(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.C.onActivityStopped(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public PartManager p()
  {
    if (this.C == null) {
      this.C = new PartManager(this, this.D);
    }
    return this.C;
  }
  
  protected boolean q()
  {
    return false;
  }
  
  protected Object r()
  {
    return new Object();
  }
  
  protected boolean s()
  {
    return true;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    PartManager localPartManager = this.C;
    if (localPartManager != null) {
      localPartManager.a(paramBoolean);
    }
  }
  
  protected boolean v()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.BasePartFragment
 * JD-Core Version:    0.7.0.1
 */