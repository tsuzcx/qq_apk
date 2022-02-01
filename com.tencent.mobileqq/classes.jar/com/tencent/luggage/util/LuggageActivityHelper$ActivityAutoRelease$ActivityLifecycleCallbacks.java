package com.tencent.luggage.util;

import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.wxa.pc.a;
import java.util.Set;

class LuggageActivityHelper$ActivityAutoRelease$ActivityLifecycleCallbacks
  extends a
{
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (LuggageActivityHelper.ActivityAutoRelease.a().remove(paramActivity))
    {
      LuggageActivityHelper.access$300(paramActivity);
      if (LuggageActivityHelper.ActivityAutoRelease.a().isEmpty())
      {
        paramActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
        LuggageActivityHelper.ActivityAutoRelease.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.LuggageActivityHelper.ActivityAutoRelease.ActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */