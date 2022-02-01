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
import io.flutter.view.FlutterMain;

public class FlutterBoost
{
  private static boolean sInit;
  static FlutterBoost sInstance;
  private long FlutterPostFrameCallTime = 0L;
  private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
  private Activity mCurrentActiveActivity;
  private FlutterEngine mEngine;
  private boolean mEnterActivityCreate = false;
  private FlutterViewContainerManager mManager;
  private Platform mPlatform;
  
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
    this.mCurrentActiveActivity = null;
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
      if (this.mPlatform.lifecycleListener != null) {
        this.mPlatform.lifecycleListener.beforeCreateEngine();
      }
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
  
  public void init(Platform paramPlatform)
  {
    if (sInit)
    {
      Debuger.log("FlutterBoost is alread inited. Do not init twice");
      return;
    }
    this.mPlatform = paramPlatform;
    this.mManager = new FlutterViewContainerManager();
    this.mActivityLifecycleCallbacks = new FlutterBoost.1(this);
    paramPlatform.getApplication().registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    if (this.mPlatform.whenEngineStart() == FlutterBoost.ConfigBuilder.IMMEDIATELY) {
      doInitialFlutter();
    }
    sInit = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost
 * JD-Core Version:    0.7.0.1
 */