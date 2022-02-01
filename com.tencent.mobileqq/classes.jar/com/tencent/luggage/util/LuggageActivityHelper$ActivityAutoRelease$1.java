package com.tencent.luggage.util;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

final class LuggageActivityHelper$ActivityAutoRelease$1
  implements Runnable
{
  LuggageActivityHelper$ActivityAutoRelease$1(Activity paramActivity, LuggageActivityHelper paramLuggageActivityHelper) {}
  
  public void run()
  {
    if ((!this.a.isFinishing()) && (!this.a.isDestroyed()))
    {
      ((AppCompatActivity)this.a).getLifecycle().addObserver(new LuggageActivityHelper.ActivityAutoRelease.1.1(this));
      return;
    }
    this.b.cleanUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.1
 * JD-Core Version:    0.7.0.1
 */