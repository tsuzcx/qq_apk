package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Map;

public class FlutterFragment
  extends Fragment
  implements FlutterActivityAndFragmentDelegate.Host
{
  protected static final String ARG_APP_BUNDLE_PATH = "app_bundle_path";
  protected static final String ARG_CACHED_ENGINE_ID = "cached_engine_id";
  protected static final String ARG_DART_ENTRYPOINT = "dart_entrypoint";
  protected static final String ARG_DESTROY_ENGINE_WITH_FRAGMENT = "destroy_engine_with_fragment";
  protected static final String ARG_FLUTTERVIEW_RENDER_MODE = "flutterview_render_mode";
  protected static final String ARG_FLUTTERVIEW_TRANSPARENCY_MODE = "flutterview_transparency_mode";
  protected static final String ARG_FLUTTER_INITIALIZATION_ARGS = "initialization_args";
  protected static final String ARG_INITIAL_ROUTE = "initial_route";
  protected static final String ARG_SHOULD_ATTACH_ENGINE_TO_ACTIVITY = "should_attach_engine_to_activity";
  protected static final String EXTRA_PARAMS = "params";
  protected static final String EXTRA_URL = "url";
  private static final String TAG = "NewFlutterFragment";
  private FlutterActivityAndFragmentDelegate delegate;
  
  public FlutterFragment()
  {
    setArguments(new Bundle());
  }
  
  @NonNull
  public static FlutterFragment createDefault()
  {
    return new FlutterFragment.NewEngineFragmentBuilder().build();
  }
  
  @NonNull
  private Context getContextCompat()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return getContext();
    }
    return getActivity();
  }
  
  @NonNull
  public static FlutterFragment.NewEngineFragmentBuilder withNewEngine()
  {
    return new FlutterFragment.NewEngineFragmentBuilder();
  }
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
  }
  
  public String getContainerUrl()
  {
    return getArguments().getString("url");
  }
  
  public Map getContainerUrlParams()
  {
    return ((BoostFlutterActivity.SerializableMap)getArguments().getSerializable("params")).getMap();
  }
  
  @Nullable
  public FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString != null) {}
    for (;;)
    {
      return new FlutterShellArgs(arrayOfString);
      arrayOfString = new String[0];
    }
  }
  
  protected XFlutterView getFlutterView()
  {
    return this.delegate.getFlutterView();
  }
  
  @NonNull
  public FlutterView.RenderMode getRenderMode()
  {
    return FlutterView.RenderMode.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.RenderMode.surface.name()));
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(paramContext);
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onBackPressed()
  {
    this.delegate.onBackPressed();
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return this.delegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.delegate.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.delegate.onLowMemory();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    this.delegate.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.delegate.onPause();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onPostResume()
  {
    this.delegate.onPostResume();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.delegate.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.delegate.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.delegate.onStop();
  }
  
  @FlutterFragment.ActivityCallThrough
  public void onTrimMemory(int paramInt)
  {
    this.delegate.onTrimMemory(paramInt);
  }
  
  @FlutterFragment.ActivityCallThrough
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
  public PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine)
  {
    if (paramActivity != null) {
      return new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel());
    }
    return null;
  }
  
  @Nullable
  public SplashScreen provideSplashScreen()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof SplashScreenProvider)) {
      return ((SplashScreenProvider)localFragmentActivity).provideSplashScreen();
    }
    return null;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */