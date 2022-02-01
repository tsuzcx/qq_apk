package com.mojitox.mxflutter;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.JsFlutterApp;
import com.mojitox.mxflutter.framework.JsFlutterEngine;
import com.mojitox.mxflutter.framework.ffi.MxFlutterFfi;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class MXFlutterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private static MXFlutterPlugin jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin;
  private JsFlutterApp jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterApp;
  private JsFlutterEngine jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterEngine;
  private MxFlutterFfi jdField_a_of_type_ComMojitoxMxflutterFrameworkFfiMxFlutterFfi;
  private BinaryMessenger jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  
  public static MXFlutterPlugin a()
  {
    return jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin;
  }
  
  private void a()
  {
    if (a() != null) {
      a().a();
    }
    MxFlutterFfi localMxFlutterFfi = this.jdField_a_of_type_ComMojitoxMxflutterFrameworkFfiMxFlutterFfi;
    if (localMxFlutterFfi != null) {
      localMxFlutterFfi.a();
    }
  }
  
  private void b() {}
  
  public JsFlutterApp a()
  {
    return this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterApp;
  }
  
  public JsFlutterEngine a()
  {
    return this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterEngine;
  }
  
  public BaseJsExecutor a()
  {
    return JsEngineLoader.a().a().b();
  }
  
  public BinaryMessenger a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger;
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    MXFlutterPlugin localMXFlutterPlugin = jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin;
    if (localMXFlutterPlugin != null) {
      localMXFlutterPlugin.a();
    }
    jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin = this;
    this.jdField_a_of_type_IoFlutterPluginCommonBinaryMessenger = paramFlutterPluginBinding.getBinaryMessenger();
    JsEngineLoader.a().a(paramFlutterPluginBinding.getApplicationContext());
    b();
    this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterApp = new JsFlutterApp();
    this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsFlutterEngine = new JsFlutterEngine();
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    paramFlutterPluginBinding = jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin;
    if (paramFlutterPluginBinding != null)
    {
      paramFlutterPluginBinding.a();
      jdField_a_of_type_ComMojitoxMxflutterMXFlutterPlugin = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.MXFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */