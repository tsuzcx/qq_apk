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
import java.util.Map;

class LoadCompactDynamicFeature$ActivityLifeCycleCallback
  implements Application.ActivityLifecycleCallbacks
{
  private LoadCompactDynamicFeature$ActivityLifeCycleCallback(LoadCompactDynamicFeature paramLoadCompactDynamicFeature) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra_is_plugin", false);
    paramBundle = paramActivity.getIntent().getStringExtra("extra_plugin_id");
    StringBuilder localStringBuilder;
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
    if (LoadCompactDynamicFeature.a(this.a).containsKey(paramActivity.getClass().getName()))
    {
      paramBundle = (String)LoadCompactDynamicFeature.a(this.a).get(paramActivity.getClass().getName());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("inject resources before plugin aty onCreate! resources path: ");
      localStringBuilder.append(paramBundle);
      QLog.i("plugin_tag", 1, localStringBuilder.toString());
      this.a.a(paramActivity, Collections.singletonList(paramBundle));
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature.ActivityLifeCycleCallback
 * JD-Core Version:    0.7.0.1
 */