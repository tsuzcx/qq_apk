package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class BoostRegistrar
  implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar
{
  private static final String TAG = "ShimRegistrar";
  private ActivityPluginBinding activityPluginBinding;
  private final Set<PluginRegistry.ActivityResultListener> activityResultListeners = new HashSet();
  private final Map<String, Object> globalRegistrarMap;
  private final Set<PluginRegistry.NewIntentListener> newIntentListeners = new HashSet();
  private FlutterPlugin.FlutterPluginBinding pluginBinding;
  private final String pluginId;
  private final Set<PluginRegistry.RequestPermissionsResultListener> requestPermissionsResultListeners = new HashSet();
  private final Set<PluginRegistry.UserLeaveHintListener> userLeaveHintListeners = new HashSet();
  private final Set<PluginRegistry.ViewDestroyListener> viewDestroyListeners = new HashSet();
  
  public BoostRegistrar(@NonNull String paramString, @NonNull Map<String, Object> paramMap)
  {
    this.pluginId = paramString;
    this.globalRegistrarMap = paramMap;
  }
  
  private void addExistingListenersToActivityPluginBinding()
  {
    Iterator localIterator = this.requestPermissionsResultListeners.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.RequestPermissionsResultListener)localIterator.next();
      this.activityPluginBinding.addRequestPermissionsResultListener((PluginRegistry.RequestPermissionsResultListener)localObject);
    }
    localIterator = this.activityResultListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.ActivityResultListener)localIterator.next();
      this.activityPluginBinding.addActivityResultListener((PluginRegistry.ActivityResultListener)localObject);
    }
    localIterator = this.newIntentListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.NewIntentListener)localIterator.next();
      this.activityPluginBinding.addOnNewIntentListener((PluginRegistry.NewIntentListener)localObject);
    }
    localIterator = this.userLeaveHintListeners.iterator();
    while (localIterator.hasNext())
    {
      localObject = (PluginRegistry.UserLeaveHintListener)localIterator.next();
      this.activityPluginBinding.addOnUserLeaveHintListener((PluginRegistry.UserLeaveHintListener)localObject);
    }
  }
  
  public Context activeContext()
  {
    if (this.activityPluginBinding == null) {
      return context();
    }
    return activity();
  }
  
  public Activity activity()
  {
    if (this.activityPluginBinding != null) {
      return this.activityPluginBinding.getActivity();
    }
    if (FlutterBoost.instance().currentActivity() != null) {
      return FlutterBoost.instance().currentActivity();
    }
    return null;
  }
  
  public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    this.activityResultListeners.add(paramActivityResultListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addActivityResultListener(paramActivityResultListener);
    }
    return this;
  }
  
  public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    this.newIntentListeners.add(paramNewIntentListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addOnNewIntentListener(paramNewIntentListener);
    }
    return this;
  }
  
  public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    this.requestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addRequestPermissionsResultListener(paramRequestPermissionsResultListener);
    }
    return this;
  }
  
  public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    this.userLeaveHintListeners.add(paramUserLeaveHintListener);
    if (this.activityPluginBinding != null) {
      this.activityPluginBinding.addOnUserLeaveHintListener(paramUserLeaveHintListener);
    }
    return this;
  }
  
  @NonNull
  public PluginRegistry.Registrar addViewDestroyListener(@NonNull PluginRegistry.ViewDestroyListener paramViewDestroyListener)
  {
    this.viewDestroyListeners.add(paramViewDestroyListener);
    return this;
  }
  
  public Context context()
  {
    if (this.pluginBinding != null) {
      return this.pluginBinding.getApplicationContext();
    }
    return null;
  }
  
  public String lookupKeyForAsset(String paramString)
  {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String lookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public BinaryMessenger messenger()
  {
    if (this.pluginBinding != null) {
      return this.pluginBinding.getFlutterEngine().getDartExecutor();
    }
    return null;
  }
  
  public void onAttachedToActivity(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    Log.v("ShimRegistrar", "Attached to an Activity.");
    this.activityPluginBinding = paramActivityPluginBinding;
    addExistingListenersToActivityPluginBinding();
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Log.v("ShimRegistrar", "Attached to FlutterEngine.");
    this.pluginBinding = paramFlutterPluginBinding;
  }
  
  public void onDetachedFromActivity()
  {
    Log.v("ShimRegistrar", "Detached from an Activity.");
    this.activityPluginBinding = null;
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    Log.v("ShimRegistrar", "Detached from an Activity for config changes.");
    this.activityPluginBinding = null;
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Log.v("ShimRegistrar", "Detached from FlutterEngine.");
    paramFlutterPluginBinding = this.viewDestroyListeners.iterator();
    while (paramFlutterPluginBinding.hasNext()) {
      ((PluginRegistry.ViewDestroyListener)paramFlutterPluginBinding.next()).onViewDestroy((FlutterNativeView)null);
    }
    this.pluginBinding = null;
  }
  
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    Log.v("ShimRegistrar", "Reconnected to an Activity after config changes.");
    this.activityPluginBinding = paramActivityPluginBinding;
    addExistingListenersToActivityPluginBinding();
  }
  
  public PlatformViewRegistry platformViewRegistry()
  {
    if (this.pluginBinding != null) {
      return this.pluginBinding.getFlutterEngine().getPlatformViewsController().getRegistry();
    }
    return null;
  }
  
  public PluginRegistry.Registrar publish(Object paramObject)
  {
    this.globalRegistrarMap.put(this.pluginId, paramObject);
    return this;
  }
  
  public TextureRegistry textures()
  {
    if (this.pluginBinding != null) {
      return this.pluginBinding.getFlutterEngine().getRenderer();
    }
    return null;
  }
  
  public FlutterView view()
  {
    throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.BoostRegistrar
 * JD-Core Version:    0.7.0.1
 */