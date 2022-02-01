package com.tencent.biz.subscribe.part;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class Part
  implements Application.ActivityLifecycleCallbacks
{
  private PartManager a;
  private View b;
  public QQAppInterface c;
  private Activity d;
  private volatile boolean e = false;
  private BasePartFragment f;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  protected void a(View paramView)
  {
    paramView = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onInitView");
    QLog.d(paramView, 1, localStringBuilder.toString());
  }
  
  public void a(BasePartFragment paramBasePartFragment, View paramView, PartManager paramPartManager)
  {
    this.d = paramBasePartFragment.getBaseActivity();
    this.f = paramBasePartFragment;
    this.a = paramPartManager;
    this.c = paramBasePartFragment.getBaseActivity().app;
    this.b = paramView;
  }
  
  public abstract String b();
  
  public boolean c()
  {
    return false;
  }
  
  public BasePartFragment d()
  {
    return this.f;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.Part
 * JD-Core Version:    0.7.0.1
 */