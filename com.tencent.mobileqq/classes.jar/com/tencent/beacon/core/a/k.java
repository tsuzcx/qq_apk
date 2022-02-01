package com.tencent.beacon.core.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.beacon.upload.UploadStrategy;

public class k
  implements Application.ActivityLifecycleCallbacks
{
  private static int a = 0;
  private static boolean b = true;
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    a += 1;
    if (a == 1)
    {
      if (b) {
        break label54;
      }
      com.tencent.beacon.core.e.d.a("[lifecycle] App in the Foreground! ", new Object[0]);
      if (UploadStrategy.IS_STOP_BACKGROUND_TASK)
      {
        com.tencent.beacon.core.d.k.a(paramActivity.getApplicationContext()).a(true);
        d.a().b();
      }
    }
    return;
    label54:
    b = false;
    com.tencent.beacon.core.e.d.a("[lifecycle] Is App First Launch! ", new Object[0]);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a -= 1;
    if (a == 0)
    {
      com.tencent.beacon.core.e.d.a("[lifecycle] App in the Background! ", new Object[0]);
      if (UploadStrategy.IS_STOP_BACKGROUND_TASK)
      {
        d.a().b(false);
        com.tencent.beacon.core.d.k.a(paramActivity.getApplicationContext()).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.k
 * JD-Core Version:    0.7.0.1
 */