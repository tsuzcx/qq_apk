package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;

public abstract class FlingHandler
{
  WeakReference<Activity> mWrappedActivity;
  
  public FlingHandler(Activity paramActivity)
  {
    this.mWrappedActivity = new WeakReference(paramActivity);
  }
  
  protected boolean canWrapContent()
  {
    return getFlingCode() != 0;
  }
  
  protected int getFlingCode()
  {
    Activity localActivity = (Activity)this.mWrappedActivity.get();
    int i = 0;
    if (localActivity != null) {
      i = localActivity.getIntent().getIntExtra("fling_code_key", 0);
    }
    return i;
  }
  
  protected abstract boolean isWrapped();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onStart()
  {
    wrap();
  }
  
  public void onStop()
  {
    unwrap();
  }
  
  protected abstract void unwrap();
  
  protected abstract void wrap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHandler
 * JD-Core Version:    0.7.0.1
 */