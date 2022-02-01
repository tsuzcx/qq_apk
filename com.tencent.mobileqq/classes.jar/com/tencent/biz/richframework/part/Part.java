package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qphone.base.util.QLog;

public abstract class Part
  implements Application.ActivityLifecycleCallbacks
{
  private PartManager a;
  private View b;
  private Activity c;
  private volatile boolean d = false;
  private IPartHost e;
  private Handler f;
  
  public IPartHost C()
  {
    return this.e;
  }
  
  public Object D()
  {
    Object localObject1 = this.e;
    if (localObject1 == null)
    {
      if (!RFApplication.isDebug()) {
        return null;
      }
      throw new RuntimeException("getViewTagData but fragment is null");
    }
    Object localObject2 = ((IPartHost)localObject1).getViewTagData();
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      View localView = this.b;
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView.getTag(BasePartFragment.E);
      }
    }
    return localObject1;
  }
  
  public PartManager E()
  {
    return this.a;
  }
  
  public View F()
  {
    View localView = this.b;
    if (localView != null) {
      return localView;
    }
    return E().c;
  }
  
  public Handler G()
  {
    if (this.f == null) {
      this.f = new Handler(Looper.getMainLooper());
    }
    return this.f;
  }
  
  public <T extends BaseViewModel> T a(IPartHost paramIPartHost, String paramString, Class<T> paramClass)
  {
    IPartHost localIPartHost = this.e;
    if (localIPartHost != null) {
      return localIPartHost.getViewModel(paramIPartHost, paramString, paramClass);
    }
    return null;
  }
  
  public <T extends BaseViewModel> T a(Class<T> paramClass)
  {
    return a(null, paramClass);
  }
  
  public <T extends BaseViewModel> T a(String paramString, Class<T> paramClass)
  {
    IPartHost localIPartHost = this.e;
    if (localIPartHost != null) {
      return a(localIPartHost, paramString, paramClass);
    }
    return null;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView)
  {
    paramView = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("->onInitView");
    QLog.d(paramView, 1, localStringBuilder.toString());
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView != null)
    {
      if (paramObject == null) {
        return;
      }
      paramView.setTag(BasePartFragment.E, paramObject);
    }
  }
  
  public void a(IPartHost paramIPartHost, View paramView, PartManager paramPartManager)
  {
    if (paramIPartHost != null)
    {
      this.c = paramIPartHost.getHostActivity();
      this.e = paramIPartHost;
    }
    this.a = paramPartManager;
    this.b = paramView;
  }
  
  public void a(String paramString, Object paramObject) {}
  
  public boolean ah_()
  {
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return null;
  }
  
  public void b(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public Activity c()
  {
    return this.c;
  }
  
  protected void c(View paramView) {}
  
  public void c(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
  }
  
  public Object d(String paramString, Object paramObject)
  {
    return this.a.b(paramString, paramObject);
  }
  
  public void e_(boolean paramBoolean) {}
  
  public Context g()
  {
    Activity localActivity = this.c;
    if (localActivity != null) {
      return localActivity;
    }
    return null;
  }
  
  public void h() {}
  
  public BasePartFragment j()
  {
    IPartHost localIPartHost = this.e;
    if ((localIPartHost instanceof BasePartFragment)) {
      return (BasePartFragment)localIPartHost;
    }
    return null;
  }
  
  public void k() {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    G().removeCallbacksAndMessages(null);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.Part
 * JD-Core Version:    0.7.0.1
 */