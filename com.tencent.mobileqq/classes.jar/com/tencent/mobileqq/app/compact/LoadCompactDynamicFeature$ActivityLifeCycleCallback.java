package com.tencent.mobileqq.app.compact;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;

class LoadCompactDynamicFeature$ActivityLifeCycleCallback
  implements Application.ActivityLifecycleCallbacks
{
  private LoadCompactDynamicFeature$ActivityLifeCycleCallback(LoadCompactDynamicFeature paramLoadCompactDynamicFeature) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      boolean bool = paramActivity.getIntent().getBooleanExtra("extra_is_plugin", false);
      paramBundle = paramActivity.getIntent().getStringExtra("extra_plugin_id");
      if ((bool) && (!TextUtils.isEmpty(paramBundle)))
      {
        paramBundle = new File(PluginUtils.getPluginInstallDir(paramActivity), paramBundle).getAbsolutePath();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("inject resources before plugin aty onCreate! resources path: ");
        localStringBuilder.append(paramBundle);
        QLog.i("plugin_tag", 1, localStringBuilder.toString());
        this.a.a(paramActivity, Collections.singletonList(paramBundle));
        return;
      }
      paramBundle = LoadCompactDynamicFeature.a(this.a, paramActivity, paramActivity.getClass().getName());
      if (TextUtils.isEmpty(paramBundle)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inject resources before plugin aty onCreate! resources path: ");
      localStringBuilder.append(paramBundle);
      QLog.i("plugin_tag", 1, localStringBuilder.toString());
      this.a.a(paramActivity, Collections.singletonList(paramBundle));
      return;
    }
    catch (Exception paramActivity)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("inject resources before plugin aty error: ");
      paramBundle.append(paramActivity);
      QLog.e("plugin_tag", 1, paramBundle.toString());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature.ActivityLifeCycleCallback
 * JD-Core Version:    0.7.0.1
 */