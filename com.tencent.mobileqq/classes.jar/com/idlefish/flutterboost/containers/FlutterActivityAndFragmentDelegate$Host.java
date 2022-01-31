package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Map;

public abstract interface FlutterActivityAndFragmentDelegate$Host
  extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
{
  public abstract void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine);
  
  @Nullable
  public abstract Activity getActivity();
  
  public abstract String getContainerUrl();
  
  public abstract Map getContainerUrlParams();
  
  @NonNull
  public abstract Context getContext();
  
  @NonNull
  public abstract FlutterShellArgs getFlutterShellArgs();
  
  @NonNull
  public abstract Lifecycle getLifecycle();
  
  @NonNull
  public abstract FlutterView.RenderMode getRenderMode();
  
  @NonNull
  public abstract FlutterView.TransparencyMode getTransparencyMode();
  
  @Nullable
  public abstract FlutterEngine provideFlutterEngine(@NonNull Context paramContext);
  
  @Nullable
  public abstract PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine);
  
  @Nullable
  public abstract SplashScreen provideSplashScreen();
  
  public abstract boolean shouldAttachEngineToActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
 * JD-Core Version:    0.7.0.1
 */