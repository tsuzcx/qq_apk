package com.idlefish.flutterboost.containers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.idlefish.flutterboost.BoostPluginRegistry;
import com.idlefish.flutterboost.BoostPluginRegistry.BoostRegistrarAggregate;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.idlefish.flutterboost.Platform;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.XFlutterView;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlutterActivityAndFragmentDelegate
  implements IFlutterViewContainer
{
  private static final String TAG = "FlutterActivityAndFragmentDelegate";
  @Nullable
  private FlutterEngine flutterEngine;
  @Nullable
  private FlutterSplashView flutterSplashView;
  @Nullable
  private XFlutterView flutterView;
  @NonNull
  private FlutterActivityAndFragmentDelegate.Host host;
  private boolean isFlutterEngineFromHost;
  protected IOperateSyncer mSyncer;
  @Nullable
  private PlatformPlugin platformPlugin;
  
  public FlutterActivityAndFragmentDelegate(@NonNull FlutterActivityAndFragmentDelegate.Host paramHost)
  {
    this.host = paramHost;
  }
  
  private void ensureAlive()
  {
    if (this.host != null) {
      return;
    }
    throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
  }
  
  private void setupFlutterEngine()
  {
    Log.d("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
    this.flutterEngine = this.host.provideFlutterEngine(this.host.getContext());
    if (this.flutterEngine != null)
    {
      this.isFlutterEngineFromHost = true;
      return;
    }
    Log.d("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this NewFlutterFragment.");
    this.isFlutterEngineFromHost = false;
  }
  
  public void finishContainer(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      setBoostResult(this.host.getActivity(), new HashMap(paramMap));
      this.host.getActivity().finish();
      return;
    }
    this.host.getActivity().finish();
  }
  
  public FlutterSplashView getBoostFlutterView()
  {
    return this.flutterSplashView;
  }
  
  public String getContainerUrl()
  {
    return this.host.getContainerUrl();
  }
  
  public Map getContainerUrlParams()
  {
    return this.host.getContainerUrlParams();
  }
  
  public Activity getContextActivity()
  {
    return this.host.getActivity();
  }
  
  @Nullable
  FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public XFlutterView getFlutterView()
  {
    return this.flutterView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mSyncer.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      localObject = paramIntent.getSerializableExtra("_flutter_result_");
      if (!(localObject instanceof Map)) {}
    }
    for (Object localObject = (Map)localObject;; localObject = null)
    {
      this.mSyncer.onContainerResult(paramInt1, paramInt2, (Map)localObject);
      ensureAlive();
      if (this.flutterEngine == null) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("\nresultCode: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("\ndata: ");
      ((StringBuilder)localObject).append(paramIntent);
      Log.v("FlutterActivityAndFragmentDelegate", ((StringBuilder)localObject).toString());
      this.flutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    ensureAlive();
    if (FlutterBoost.instance().platform().whenEngineStart() == FlutterBoost.ConfigBuilder.FLUTTER_ACTIVITY_CREATED)
    {
      FlutterBoost.instance().doInitialFlutter();
      FlutterBoost.instance().boostPluginRegistry();
    }
    if (this.flutterEngine == null) {
      setupFlutterEngine();
    }
    this.platformPlugin = this.host.providePlatformPlugin(this.host.getActivity(), this.flutterEngine);
    this.host.configureFlutterEngine(this.flutterEngine);
    this.host.getActivity().getWindow().setFormat(-3);
  }
  
  public void onBackPressed()
  {
    this.mSyncer.onBackPressed();
    ensureAlive();
  }
  
  public void onContainerHidden() {}
  
  public void onContainerShown() {}
  
  @SuppressLint({"ResourceType"})
  @NonNull
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
    this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
    this.mSyncer = FlutterBoost.instance().containerManager().generateSyncer(this);
    ensureAlive();
    this.flutterView = new XFlutterView(this.host.getActivity(), FlutterBoost.instance().platform().renderMode(), this.host.getTransparencyMode());
    this.flutterSplashView = new FlutterSplashView(this.host.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.flutterSplashView.setId(View.generateViewId());
    }
    for (;;)
    {
      this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
      this.mSyncer.onCreate();
      return this.flutterSplashView;
      this.flutterSplashView.setId(486947586);
    }
  }
  
  public void onDestroyView()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
    this.mSyncer.onDestroy();
    ensureAlive();
    BoostPluginRegistry localBoostPluginRegistry = (BoostPluginRegistry)FlutterBoost.instance().getPluginRegistry();
    if (localBoostPluginRegistry != null)
    {
      ActivityPluginBinding localActivityPluginBinding = localBoostPluginRegistry.getRegistrarAggregate().getActivityPluginBinding();
      if ((localActivityPluginBinding != null) && (localActivityPluginBinding.getActivity() == this.host.getActivity()))
      {
        localBoostPluginRegistry.getRegistrarAggregate().onDetachedFromActivityForConfigChanges();
        this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
      }
    }
    this.flutterView.release();
  }
  
  public void onDetach()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
    ensureAlive();
    if (this.platformPlugin != null)
    {
      this.platformPlugin.destroy();
      this.platformPlugin = null;
    }
    Utils.fixInputMethodManagerLeak(this.host.getActivity());
  }
  
  public void onLowMemory()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
    this.mSyncer.onLowMemory();
    ensureAlive();
    this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
  }
  
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    this.mSyncer.onNewIntent(paramIntent);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.");
      this.flutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void onPause()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
    ensureAlive();
    this.mSyncer.onDisappear();
    this.flutterEngine.getLifecycleChannel().appIsInactive();
  }
  
  public void onPostResume()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
    ensureAlive();
    Utils.setStatusBarLightMode(this.host.getActivity(), true);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.mSyncer.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("\npermissions: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      localStringBuilder.append("\ngrantResults: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfInt));
      Log.v("FlutterActivityAndFragmentDelegate", localStringBuilder.toString());
      this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void onResume()
  {
    this.mSyncer.onAppear();
    Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsResumed();
    ActivityPluginBinding localActivityPluginBinding = ((BoostPluginRegistry)FlutterBoost.instance().getPluginRegistry()).getRegistrarAggregate().getActivityPluginBinding();
    if ((localActivityPluginBinding != null) && (localActivityPluginBinding.getActivity() != this.host.getActivity())) {
      this.flutterEngine.getActivityControlSurface().attachToActivity(this.host.getActivity(), this.host.getLifecycle());
    }
  }
  
  public void onStart()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
    ensureAlive();
  }
  
  public void onStop()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
    ensureAlive();
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.mSyncer.onTrimMemory(paramInt);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      if (paramInt == 10)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Forwarding onTrimMemory() to FlutterEngine. Level: ");
        localStringBuilder.append(paramInt);
        Log.v("FlutterActivityAndFragmentDelegate", localStringBuilder.toString());
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
      }
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void onUserLeaveHint()
  {
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
      this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before NewFlutterFragment was attached to an Activity.");
  }
  
  public void release()
  {
    this.host = null;
    this.flutterEngine = null;
    this.flutterView = null;
    this.platformPlugin = null;
  }
  
  public void setBoostResult(Activity paramActivity, HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    if (paramHashMap != null) {
      localIntent.putExtra("_flutter_result_", paramHashMap);
    }
    paramActivity.setResult(-1, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */