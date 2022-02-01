package com.tencent.featuretoggle.strategy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.Utils;

public final class ActivityLifeCycleListener
{
  private volatile boolean a;
  private boolean b;
  
  public static ActivityLifeCycleListener a()
  {
    try
    {
      ActivityLifeCycleListener localActivityLifeCycleListener = ActivityLifeCycleListener.ToggleActivityLifeCycleListenerManagerHolder.a();
      return localActivityLifeCycleListener;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @TargetApi(14)
  public void a(Context paramContext)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    if (Utils.b(14))
    {
      this.b = false;
      return;
    }
    if ((paramContext instanceof Activity)) {
      paramContext = ((Activity)paramContext).getApplication();
    } else if ((paramContext instanceof Application)) {
      paramContext = (Application)paramContext;
    } else {
      paramContext = null;
    }
    if (paramContext == null)
    {
      this.b = false;
      return;
    }
    try
    {
      paramContext.registerActivityLifecycleCallbacks(new ActivityLifeCycleListener.ToggleActivityLifeCycleListener(this, null));
      this.b = true;
    }
    catch (Exception paramContext)
    {
      label93:
      break label93;
    }
    this.b = false;
    if (this.b) {
      LogUtils.c("[Strategy] ToggleActivityLifeCycleListener register success", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.strategy.ActivityLifeCycleListener
 * JD-Core Version:    0.7.0.1
 */