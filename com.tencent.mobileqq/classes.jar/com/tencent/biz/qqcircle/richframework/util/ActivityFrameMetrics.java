package com.tencent.biz.qqcircle.richframework.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.util.HashMap;
import java.util.Map;

public class ActivityFrameMetrics
  implements Application.ActivityLifecycleCallbacks
{
  private float a;
  private float b;
  private boolean c;
  private boolean d;
  private Map<String, Window.OnFrameMetricsAvailableListener> e = new HashMap();
  
  @TargetApi(24)
  public void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      String str = paramActivity.getClass().getSimpleName();
      ActivityFrameMetrics.1 local1 = new ActivityFrameMetrics.1(this, str);
      paramActivity.getWindow().addOnFrameMetricsAvailableListener(local1, new Handler());
      this.e.put(str, local1);
      return;
    }
    Log.w("FrameMetrics", "FrameMetrics can work only with Android SDK 24 (Nougat) and higher");
  }
  
  @TargetApi(24)
  public void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      String str = paramActivity.getClass().getName();
      Window.OnFrameMetricsAvailableListener localOnFrameMetricsAvailableListener = (Window.OnFrameMetricsAvailableListener)this.e.get(str);
      if (localOnFrameMetricsAvailableListener != null)
      {
        paramActivity.getWindow().removeOnFrameMetricsAvailableListener(localOnFrameMetricsAvailableListener);
        this.e.remove(str);
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.ActivityFrameMetrics
 * JD-Core Version:    0.7.0.1
 */