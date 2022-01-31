package com.idlefish.flutterboost;

import android.app.Application;
import android.support.annotation.NonNull;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView.RenderMode;

public class FlutterBoost$ConfigBuilder
{
  public static int ANY_ACTIVITY_CREATED = 1;
  public static int APP_EXit = 0;
  public static int All_FLUTTER_ACTIVITY_DESTROY = 1;
  public static final String DEFAULT_DART_ENTRYPOINT = "main";
  public static final String DEFAULT_INITIAL_ROUTE = "/";
  public static int FLUTTER_ACTIVITY_CREATED = 2;
  public static int IMMEDIATELY;
  private FlutterBoost.BoostPluginsRegister boostPluginsRegister;
  private String dartEntrypoint = "main";
  private String initialRoute = "/";
  private boolean isDebug = false;
  private FlutterBoost.BoostLifecycleListener lifecycleListener;
  private Application mApp;
  private FlutterView.RenderMode renderMode = FlutterView.RenderMode.texture;
  private INativeRouter router = null;
  private int whenEngineDestory = APP_EXit;
  private int whenEngineStart = ANY_ACTIVITY_CREATED;
  
  public FlutterBoost$ConfigBuilder(Application paramApplication, INativeRouter paramINativeRouter)
  {
    this.router = paramINativeRouter;
    this.mApp = paramApplication;
  }
  
  public Platform build()
  {
    FlutterBoost.ConfigBuilder.1 local1 = new FlutterBoost.ConfigBuilder.1(this);
    local1.lifecycleListener = this.lifecycleListener;
    local1.pluginsRegister = this.boostPluginsRegister;
    return local1;
  }
  
  public ConfigBuilder dartEntrypoint(@NonNull String paramString)
  {
    this.dartEntrypoint = paramString;
    return this;
  }
  
  public ConfigBuilder initialRoute(@NonNull String paramString)
  {
    this.initialRoute = paramString;
    return this;
  }
  
  public ConfigBuilder isDebug(boolean paramBoolean)
  {
    this.isDebug = paramBoolean;
    return this;
  }
  
  public ConfigBuilder lifecycleListener(FlutterBoost.BoostLifecycleListener paramBoostLifecycleListener)
  {
    this.lifecycleListener = paramBoostLifecycleListener;
    return this;
  }
  
  public ConfigBuilder pluginsRegister(FlutterBoost.BoostPluginsRegister paramBoostPluginsRegister)
  {
    this.boostPluginsRegister = paramBoostPluginsRegister;
    return this;
  }
  
  public ConfigBuilder renderMode(FlutterView.RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    return this;
  }
  
  public ConfigBuilder whenEngineStart(int paramInt)
  {
    this.whenEngineStart = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost.ConfigBuilder
 * JD-Core Version:    0.7.0.1
 */