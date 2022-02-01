package com.idlefish.flutterboost.containers;

import Override;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.XPlatformPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import io.flutter.Log;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.util.HashMap;
import java.util.Map;

public class BoostFlutterActivity
  extends Activity
  implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host
{
  protected static final String DEFAULT_BACKGROUND_MODE = BoostFlutterActivity.BackgroundMode.opaque.name();
  protected static final String EXTRA_BACKGROUND_MODE = "background_mode";
  protected static final String EXTRA_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
  protected static final String EXTRA_PARAMS = "params";
  protected static final String EXTRA_URL = "url";
  protected static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
  protected static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
  private static final String TAG = "NewBoostFlutterActivity";
  private FlutterActivityAndFragmentDelegate delegate;
  @NonNull
  private LifecycleRegistry lifecycle = new LifecycleRegistry(this);
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(0);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
  }
  
  private void configureWindowForTransparency()
  {
    if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.transparent)
    {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      getWindow().setFlags(512, 512);
    }
  }
  
  public static Intent createDefaultIntent(@NonNull Context paramContext)
  {
    return withNewEngine().build(paramContext);
  }
  
  @Nullable
  private Drawable getSplashScreenFromManifest()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 == null) {
          break label77;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21) {
            return getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return null;
      label77:
      Object localObject2 = null;
    }
  }
  
  private boolean isDebuggable()
  {
    return (getApplicationInfo().flags & 0x2) != 0;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if (localActivityInfo.metaData != null)
      {
        int i = localActivityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      else
      {
        Log.d("NewBoostFlutterActivity", "Using the launch theme as normal theme.");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("NewBoostFlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
    }
  }
  
  public static BoostFlutterActivity.NewEngineIntentBuilder withNewEngine()
  {
    return new BoostFlutterActivity.NewEngineIntentBuilder(BoostFlutterActivity.class);
  }
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  @NonNull
  protected View createFlutterView()
  {
    return this.delegate.onCreateView(null, null, null);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @NonNull
  public Activity getActivity()
  {
    return this;
  }
  
  @NonNull
  protected BoostFlutterActivity.BackgroundMode getBackgroundMode()
  {
    if (getIntent().hasExtra("background_mode")) {
      return BoostFlutterActivity.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
    }
    return BoostFlutterActivity.BackgroundMode.opaque;
  }
  
  public String getContainerUrl()
  {
    if (getIntent().hasExtra("url")) {
      return getIntent().getStringExtra("url");
    }
    return "";
  }
  
  public Map getContainerUrlParams()
  {
    if (getIntent().hasExtra("params")) {
      return ((BoostFlutterActivity.SerializableMap)getIntent().getSerializableExtra("params")).getMap();
    }
    return new HashMap();
  }
  
  @NonNull
  public Context getContext()
  {
    return this;
  }
  
  @Nullable
  protected FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    return FlutterShellArgs.fromIntent(getIntent());
  }
  
  protected XFlutterView getFlutterView()
  {
    return this.delegate.getFlutterView();
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
  
  @NonNull
  public FlutterView.RenderMode getRenderMode()
  {
    if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.opaque) {
      return FlutterView.RenderMode.surface;
    }
    return FlutterView.RenderMode.texture;
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    if (getBackgroundMode() == BoostFlutterActivity.BackgroundMode.opaque) {
      return FlutterView.TransparencyMode.opaque;
    }
    return FlutterView.TransparencyMode.transparent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this);
    configureWindowForTransparency();
    setContentView(createFlutterView());
    configureStatusBarForFullscreenFlutterExperience();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.delegate.onDestroyView();
    this.delegate.onDetach();
  }
  
  protected void onNewIntent(@NonNull Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.delegate.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.delegate.onPause();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.delegate.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.delegate.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.delegate.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.delegate.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.delegate.onTrimMemory(paramInt);
  }
  
  public void onUserLeaveHint()
  {
    this.delegate.onUserLeaveHint();
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
    return FlutterBoost.instance().engineProvider();
  }
  
  @Nullable
  public XPlatformPlugin providePlatformPlugin(@NonNull FlutterEngine paramFlutterEngine)
  {
    return new XPlatformPlugin(paramFlutterEngine.getPlatformChannel());
  }
  
  @Nullable
  public SplashScreen provideSplashScreen()
  {
    Drawable localDrawable = getSplashScreenFromManifest();
    if (localDrawable != null) {
      return new DrawableSplashScreen(localDrawable, ImageView.ScaleType.CENTER, 500L);
    }
    return null;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.BoostFlutterActivity
 * JD-Core Version:    0.7.0.1
 */