package com.idlefish.flutterboost;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FlutterBoostPlugin
{
  private static final Set<FlutterBoostPlugin.ActionAfterRegistered> sActions = new HashSet();
  private static FlutterBoostPlugin sInstance;
  private final Map<String, Set<FlutterBoostPlugin.EventListener>> mEventListeners = new HashMap();
  private final Set<MethodChannel.MethodCallHandler> mMethodCallHandlers = new HashSet();
  private final MethodChannel mMethodChannel;
  
  private FlutterBoostPlugin(PluginRegistry.Registrar paramRegistrar)
  {
    this.mMethodChannel = new MethodChannel(paramRegistrar.messenger(), "flutter_boost");
    this.mMethodChannel.setMethodCallHandler(new FlutterBoostPlugin.1(this));
    addMethodCallHandler(new FlutterBoostPlugin.BoostMethodHandler(this));
  }
  
  public static void addActionAfterRegistered(FlutterBoostPlugin.ActionAfterRegistered paramActionAfterRegistered)
  {
    if (paramActionAfterRegistered == null) {
      return;
    }
    if (sInstance == null)
    {
      sActions.add(paramActionAfterRegistered);
      return;
    }
    paramActionAfterRegistered.onChannelRegistered(sInstance);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    sInstance = new FlutterBoostPlugin(paramRegistrar);
    paramRegistrar = sActions.iterator();
    while (paramRegistrar.hasNext()) {
      ((FlutterBoostPlugin.ActionAfterRegistered)paramRegistrar.next()).onChannelRegistered(sInstance);
    }
    sActions.clear();
  }
  
  public static FlutterBoostPlugin singleton()
  {
    if (sInstance != null) {
      return sInstance;
    }
    throw new RuntimeException("FlutterBoostPlugin not register yet");
  }
  
  public void addEventListener(String paramString, FlutterBoostPlugin.EventListener paramEventListener)
  {
    synchronized (this.mEventListeners)
    {
      Set localSet = (Set)this.mEventListeners.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramEventListener);
      this.mEventListeners.put(paramString, localObject);
      return;
    }
  }
  
  public void addMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    synchronized (this.mMethodCallHandlers)
    {
      this.mMethodCallHandlers.add(paramMethodCallHandler);
      return;
    }
  }
  
  public void invokeMethod(String paramString, Serializable paramSerializable)
  {
    invokeMethod(paramString, paramSerializable, new FlutterBoostPlugin.3(this, paramString));
  }
  
  public void invokeMethod(String paramString, Serializable paramSerializable, MethodChannel.Result paramResult)
  {
    if ("__event__".equals(paramString)) {
      Debuger.exception("method name should not be __event__");
    }
    this.mMethodChannel.invokeMethod(paramString, paramSerializable, paramResult);
  }
  
  public void invokeMethodUnsafe(String paramString, Serializable paramSerializable)
  {
    invokeMethod(paramString, paramSerializable, new FlutterBoostPlugin.2(this, paramString));
  }
  
  public void removeEventListener(FlutterBoostPlugin.EventListener paramEventListener)
  {
    synchronized (this.mEventListeners)
    {
      Iterator localIterator = this.mEventListeners.values().iterator();
      if (localIterator.hasNext()) {
        ((Set)localIterator.next()).remove(paramEventListener);
      }
    }
  }
  
  public void removeMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    synchronized (this.mMethodCallHandlers)
    {
      this.mMethodCallHandlers.remove(paramMethodCallHandler);
      return;
    }
  }
  
  public void sendEvent(String paramString, Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString);
    localHashMap.put("arguments", paramMap);
    this.mMethodChannel.invokeMethod("__event__", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin
 * JD-Core Version:    0.7.0.1
 */