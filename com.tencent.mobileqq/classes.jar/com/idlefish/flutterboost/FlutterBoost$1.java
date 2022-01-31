package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.HashMap;

class FlutterBoost$1
  implements Application.ActivityLifecycleCallbacks
{
  FlutterBoost$1(FlutterBoost paramFlutterBoost) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    FlutterBoost.access$002(this.this$0, paramActivity);
    if (FlutterBoost.access$100(this.this$0).whenEngineStart() == FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
    {
      this.this$0.doInitialFlutter();
      this.this$0.boostPluginRegistry();
    }
    if (FlutterBoost.access$100(this.this$0).whenEngineStart() == FlutterBoost.ConfigBuilder.IMMEDIATELY) {
      this.this$0.boostPluginRegistry();
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (FlutterBoost.access$000(this.this$0) == paramActivity)
    {
      Debuger.log("Application entry background");
      if (FlutterBoost.access$200(this.this$0) != null)
      {
        paramActivity = new HashMap();
        paramActivity.put("type", "background");
        this.this$0.channel().sendEvent("lifecycle", paramActivity);
      }
      FlutterBoost.access$002(this.this$0, null);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    FlutterBoost.access$002(this.this$0, paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (FlutterBoost.access$000(this.this$0) == null)
    {
      Debuger.log("Application entry foreground");
      if (FlutterBoost.access$200(this.this$0) != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("type", "foreground");
        this.this$0.channel().sendEvent("lifecycle", localHashMap);
      }
    }
    FlutterBoost.access$002(this.this$0, paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (FlutterBoost.access$000(this.this$0) == paramActivity)
    {
      Debuger.log("Application entry background");
      if (FlutterBoost.access$200(this.this$0) != null)
      {
        paramActivity = new HashMap();
        paramActivity.put("type", "background");
        this.this$0.channel().sendEvent("lifecycle", paramActivity);
      }
      FlutterBoost.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost.1
 * JD-Core Version:    0.7.0.1
 */