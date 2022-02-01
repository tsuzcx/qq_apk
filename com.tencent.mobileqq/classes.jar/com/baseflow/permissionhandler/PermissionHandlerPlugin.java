package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public final class PermissionHandlerPlugin
  implements FlutterPlugin, ActivityAware
{
  @Nullable
  private MethodCallHandlerImpl a;
  private MethodChannel b;
  
  private void a()
  {
    this.b.setMethodCallHandler(null);
    this.b = null;
    this.a = null;
  }
  
  private void a(Activity paramActivity, PermissionManager.ActivityRegistry paramActivityRegistry, PermissionManager.PermissionRegistry paramPermissionRegistry)
  {
    MethodCallHandlerImpl localMethodCallHandlerImpl = this.a;
    if (localMethodCallHandlerImpl != null)
    {
      localMethodCallHandlerImpl.a(paramActivity);
      this.a.a(paramActivityRegistry);
      this.a.a(paramPermissionRegistry);
    }
  }
  
  private void a(Context paramContext, BinaryMessenger paramBinaryMessenger)
  {
    this.b = new MethodChannel(paramBinaryMessenger, "flutter.baseflow.com/permissions/methods");
    this.a = new MethodCallHandlerImpl(paramContext, new AppSettingsManager(), new PermissionManager(), new ServiceManager());
    this.b.setMethodCallHandler(this.a);
  }
  
  private void b()
  {
    MethodCallHandlerImpl localMethodCallHandlerImpl = this.a;
    if (localMethodCallHandlerImpl != null)
    {
      localMethodCallHandlerImpl.a(null);
      this.a.a(null);
      this.a.a(null);
    }
  }
  
  public void onAttachedToActivity(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    Activity localActivity = paramActivityPluginBinding.getActivity();
    paramActivityPluginBinding.getClass();
    _..Lambda.sBX9xOXZL_IyslP1RzvV3CSTujA localsBX9xOXZL_IyslP1RzvV3CSTujA = new _..Lambda.sBX9xOXZL_IyslP1RzvV3CSTujA(paramActivityPluginBinding);
    paramActivityPluginBinding.getClass();
    a(localActivity, localsBX9xOXZL_IyslP1RzvV3CSTujA, new _..Lambda.rOyg1Wi6vWVUV2448_HhC4KsVuk(paramActivityPluginBinding));
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    a(paramFlutterPluginBinding.getApplicationContext(), paramFlutterPluginBinding.getBinaryMessenger());
  }
  
  public void onDetachedFromActivity()
  {
    b();
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    onDetachedFromActivity();
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    a();
  }
  
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    onAttachedToActivity(paramActivityPluginBinding);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionHandlerPlugin
 * JD-Core Version:    0.7.0.1
 */