package com.tencent.biz.qqstory.storyHome.proxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class BaseTransitionCode
  implements TransitionCode
{
  protected Activity a;
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.setResult(paramInt, paramIntent);
      return;
    }
    SLog.e(getClass().getSimpleName(), "finish can not access after detach");
  }
  
  public void a(@NonNull Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.a = null;
  }
  
  public void e()
  {
    Activity localActivity = this.a;
    if (localActivity != null)
    {
      localActivity.finish();
      return;
    }
    SLog.e(getClass().getSimpleName(), "finish can not access after detach");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.proxy.BaseTransitionCode
 * JD-Core Version:    0.7.0.1
 */