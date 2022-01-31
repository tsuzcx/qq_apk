package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;

public abstract class FlingHandler
{
  WeakReference<Activity> a;
  
  public FlingHandler(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  protected int a()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity != null) {
      return localActivity.getIntent().getIntExtra("fling_code_key", 0);
    }
    return 0;
  }
  
  protected abstract void a();
  
  protected boolean a()
  {
    return a() != 0;
  }
  
  protected abstract void b();
  
  protected abstract boolean b();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onStart()
  {
    a();
  }
  
  public void onStop()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHandler
 * JD-Core Version:    0.7.0.1
 */