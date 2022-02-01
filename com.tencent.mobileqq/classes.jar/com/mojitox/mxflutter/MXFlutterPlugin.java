package com.mojitox.mxflutter;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.JsFlutterApp;
import com.mojitox.mxflutter.framework.JsFlutterEngine;
import com.mojitox.mxflutter.framework.ffi.MxFlutterFfi;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class MXFlutterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private static boolean a;
  private static MXFlutterPlugin b;
  private BinaryMessenger c;
  private JsFlutterApp d;
  private JsFlutterEngine e;
  private MxFlutterFfi f;
  
  public static MXFlutterPlugin a()
  {
    return b;
  }
  
  private void f()
  {
    if (e() != null) {
      e().a();
    }
    MxFlutterFfi localMxFlutterFfi = this.f;
    if (localMxFlutterFfi != null) {
      localMxFlutterFfi.a();
    }
  }
  
  private void g()
  {
    if (a)
    {
      JsEngineLoader.a().d();
      this.f = new MxFlutterFfi();
    }
  }
  
  public BinaryMessenger b()
  {
    return this.c;
  }
  
  public JsFlutterApp c()
  {
    return this.d;
  }
  
  public BaseJsExecutor d()
  {
    return JsEngineLoader.a().d().b();
  }
  
  public JsFlutterEngine e()
  {
    return this.e;
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    MxLog.a("MXFlutterPlugin", "#onAttachedToEngine: begin");
    MXFlutterPlugin localMXFlutterPlugin = b;
    if (localMXFlutterPlugin != null) {
      localMXFlutterPlugin.f();
    }
    b = this;
    this.c = paramFlutterPluginBinding.getBinaryMessenger();
    JsEngineLoader.a().a(paramFlutterPluginBinding.getApplicationContext());
    g();
    this.d = new JsFlutterApp();
    this.e = new JsFlutterEngine();
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    MxLog.a("MXFlutterPlugin", "#onDetachedFromEngine: begin");
    paramFlutterPluginBinding = b;
    if (paramFlutterPluginBinding != null)
    {
      paramFlutterPluginBinding.f();
      b = null;
    }
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
      paramResult.success(paramMethodCall.toString());
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.MXFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */