package com.idlefish.flutterboost;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BoostPluginRegistry$BoostRegistrarAggregate
  implements FlutterPlugin, ActivityAware
{
  private ActivityPluginBinding activityPluginBinding;
  private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
  private final Set<BoostRegistrar> shimRegistrars = new HashSet();
  
  public void addPlugin(BoostRegistrar paramBoostRegistrar)
  {
    this.shimRegistrars.add(paramBoostRegistrar);
    if (this.flutterPluginBinding != null) {
      paramBoostRegistrar.onAttachedToEngine(this.flutterPluginBinding);
    }
    if (this.activityPluginBinding != null) {
      paramBoostRegistrar.onAttachedToActivity(this.activityPluginBinding);
    }
  }
  
  public ActivityPluginBinding getActivityPluginBinding()
  {
    return this.activityPluginBinding;
  }
  
  public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    this.activityPluginBinding = paramActivityPluginBinding;
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onAttachedToActivity(paramActivityPluginBinding);
    }
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.flutterPluginBinding = paramFlutterPluginBinding;
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onAttachedToEngine(paramFlutterPluginBinding);
    }
  }
  
  public void onDetachedFromActivity()
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onDetachedFromActivity();
    }
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onDetachedFromActivity();
    }
    this.activityPluginBinding = null;
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onDetachedFromEngine(paramFlutterPluginBinding);
    }
    this.flutterPluginBinding = null;
  }
  
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((BoostRegistrar)localIterator.next()).onReattachedToActivityForConfigChanges(paramActivityPluginBinding);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.BoostPluginRegistry.BoostRegistrarAggregate
 * JD-Core Version:    0.7.0.1
 */