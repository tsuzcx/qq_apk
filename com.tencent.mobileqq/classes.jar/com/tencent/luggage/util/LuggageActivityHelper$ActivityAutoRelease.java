package com.tencent.luggage.util;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.tencent.luggage.wxa.qz.t;
import java.util.HashSet;
import java.util.Set;

public final class LuggageActivityHelper$ActivityAutoRelease
{
  private static Set<Activity> a = new HashSet();
  private static boolean b;
  
  public static <T extends LuggageActivityHelper> void register(Activity paramActivity, T paramT)
  {
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        t.a(new LuggageActivityHelper.ActivityAutoRelease.1(paramActivity, paramT));
        return;
      }
      ((AppCompatActivity)paramActivity).getLifecycle().addObserver(new LuggageActivityHelper.ActivityAutoRelease.2(paramT));
      return;
    }
    a.add(paramActivity);
    if (!b)
    {
      paramActivity.getApplication().registerActivityLifecycleCallbacks(new LuggageActivityHelper.ActivityAutoRelease.ActivityLifecycleCallbacks(null));
      b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease
 * JD-Core Version:    0.7.0.1
 */