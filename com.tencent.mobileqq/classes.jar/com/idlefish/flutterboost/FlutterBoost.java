package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterMain;

public class FlutterBoost
{
  static FlutterBoost sInstance;
  private long FlutterPostFrameCallTime = 0L;
  private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
  private Activity mCurrentActiveActivity;
  private FlutterEngine mEngine;
  private FlutterViewContainerManager mManager;
  private Platform mPlatform;
  private PluginRegistry mRegistry;
  
  private FlutterEngine createEngine()
  {
    if (this.mEngine == null)
    {
      FlutterMain.startInitialization(this.mPlatform.getApplication());
      FlutterShellArgs localFlutterShellArgs = new FlutterShellArgs(new String[0]);
      FlutterMain.ensureInitializationComplete(this.mPlatform.getApplication().getApplicationContext(), localFlutterShellArgs.toArray());
      this.mEngine = new FlutterEngine(this.mPlatform.getApplication().getApplicationContext());
    }
    return this.mEngine;
  }
  
  public static FlutterBoost instance()
  {
    if (sInstance == null) {
      sInstance = new FlutterBoost();
    }
    return sInstance;
  }
  
  public void boostDestroy()
  {
    if (this.mEngine != null) {
      this.mEngine.destroy();
    }
    if (this.mPlatform.lifecycleListener != null) {
      this.mPlatform.lifecycleListener.onEngineDestroy();
    }
    this.mEngine = null;
    this.mRegistry = null;
    this.mCurrentActiveActivity = null;
  }
  
  public void boostPluginRegistry()
  {
    if ((this.mRegistry != null) && (!this.mRegistry.hasPlugin("boostPluginRegistry")))
    {
      this.mPlatform.registerPlugins(this.mRegistry);
      this.mRegistry.registrarFor("boostPluginRegistry");
    }
  }
  
  public FlutterBoostPlugin channel()
  {
    return FlutterBoostPlugin.singleton();
  }
  
  public IContainerManager containerManager()
  {
    return sInstance.mManager;
  }
  
  public Activity currentActivity()
  {
    return sInstance.mCurrentActiveActivity;
  }
  
  public void doInitialFlutter()
  {
    if (this.mEngine != null) {}
    FlutterEngine localFlutterEngine;
    do
    {
      return;
      localFlutterEngine = createEngine();
      if (this.mPlatform.lifecycleListener != null) {
        this.mPlatform.lifecycleListener.onEngineCreated();
      }
    } while (localFlutterEngine.getDartExecutor().isExecutingDart());
    if (this.mPlatform.initialRoute() != null) {
      localFlutterEngine.getNavigationChannel().setInitialRoute(this.mPlatform.initialRoute());
    }
    DartExecutor.DartEntrypoint localDartEntrypoint = new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "main");
    localFlutterEngine.getDartExecutor().executeDartEntrypoint(localDartEntrypoint);
    this.mRegistry = new BoostPluginRegistry(createEngine());
  }
  
  public FlutterEngine engineProvider()
  {
    return this.mEngine;
  }
  
  public IFlutterViewContainer findContainerById(String paramString)
  {
    return this.mManager.findContainerById(paramString);
  }
  
  public long getFlutterPostFrameCallTime()
  {
    return this.FlutterPostFrameCallTime;
  }
  
  public PluginRegistry getPluginRegistry()
  {
    return this.mRegistry;
  }
  
  public void init(Platform paramPlatform)
  {
    this.mPlatform = paramPlatform;
    this.mManager = new FlutterViewContainerManager();
    this.mActivityLifecycleCallbacks = new FlutterBoost.1(this);
    paramPlatform.getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    if (this.mPlatform.whenEngineStart() == FlutterBoost.ConfigBuilder.IMMEDIATELY) {
      doInitialFlutter();
    }
  }
  
  public Platform platform()
  {
    return sInstance.mPlatform;
  }
  
  public void setFlutterPostFrameCallTime(long paramLong)
  {
    this.FlutterPostFrameCallTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost
 * JD-Core Version:    0.7.0.1
 */