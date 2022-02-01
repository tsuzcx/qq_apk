package com.tencent.biz.qqstory.storyHome.proxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class BaseTransitionCode
  implements TransitionCode
{
  protected Activity d;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Activity localActivity = this.d;
    if (localActivity != null)
    {
      localActivity.setContentView(paramInt);
      return;
    }
    SLog.e(getClass().getSimpleName(), "setContentView can not access after detach");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.d;
    if (localActivity != null)
    {
      localActivity.setResult(paramInt, paramIntent);
      return;
    }
    SLog.e(getClass().getSimpleName(), "finish can not access after detach");
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public View b(int paramInt)
  {
    Activity localActivity = this.d;
    if (localActivity != null) {
      return localActivity.findViewById(paramInt);
    }
    SLog.e(getClass().getSimpleName(), "findViewById can not access after detach");
    return null;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.d = null;
  }
  
  public Activity e()
  {
    return this.d;
  }
  
  public void f()
  {
    Activity localActivity = this.d;
    if (localActivity != null)
    {
      localActivity.finish();
      return;
    }
    SLog.e(getClass().getSimpleName(), "finish can not access after detach");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.proxy.BaseTransitionCode
 * JD-Core Version:    0.7.0.1
 */