package com.idlefish.flutterboost;

public abstract interface FlutterBoost$BoostLifecycleListener
{
  public abstract void beforeCreateEngine();
  
  public abstract void onEngineCreated();
  
  public abstract void onEngineDestroy();
  
  public abstract void onPluginsRegistered();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener
 * JD-Core Version:    0.7.0.1
 */