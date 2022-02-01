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
  private MethodCallHandlerImpl jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl;
  private MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  
  private void a()
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(null);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = null;
    this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl = null;
  }
  
  private void a(Activity paramActivity, PermissionManager.ActivityRegistry paramActivityRegistry, PermissionManager.PermissionRegistry paramPermissionRegistry)
  {
    MethodCallHandlerImpl localMethodCallHandlerImpl = this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl;
    if (localMethodCallHandlerImpl != null)
    {
      localMethodCallHandlerImpl.a(paramActivity);
      this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl.a(paramActivityRegistry);
      this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl.a(paramPermissionRegistry);
    }
  }
  
  private void a(Context paramContext, BinaryMessenger paramBinaryMessenger)
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(paramBinaryMessenger, "flutter.baseflow.com/permissions/methods");
    this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl = new MethodCallHandlerImpl(paramContext, new AppSettingsManager(), new PermissionManager(), new ServiceManager());
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl);
  }
  
  private void b()
  {
    MethodCallHandlerImpl localMethodCallHandlerImpl = this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl;
    if (localMethodCallHandlerImpl != null)
    {
      localMethodCallHandlerImpl.a(null);
      this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl.a(null);
      this.jdField_a_of_type_ComBaseflowPermissionhandlerMethodCallHandlerImpl.a(null);
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