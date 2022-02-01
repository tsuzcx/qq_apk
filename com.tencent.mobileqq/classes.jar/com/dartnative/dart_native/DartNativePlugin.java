package com.dartnative.dart_native;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class DartNativePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String TAG = "DartNativePlugin";
  public static String sSoPath = "libdart_native.so";
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "dart_native").setMethodCallHandler(new DartNativePlugin());
  }
  
  public static void setSoPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("so path : ");
    localStringBuilder.append(paramString);
    Log.d("DartNativePlugin", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      sSoPath = paramString;
      System.load(paramString);
      return;
    }
    System.loadLibrary("dart_native");
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "dart_native").setMethodCallHandler(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("getDylibPath"))
    {
      paramResult.success(sSoPath);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dartnative.dart_native.DartNativePlugin
 * JD-Core Version:    0.7.0.1
 */