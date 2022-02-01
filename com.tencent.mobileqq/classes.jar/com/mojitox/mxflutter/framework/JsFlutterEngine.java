package com.mojitox.mxflutter.framework;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StringCodec;
import java.util.Map;

public class JsFlutterEngine
{
  BasicMessageChannel<String> a;
  public MethodChannel a;
  
  public JsFlutterEngine()
  {
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(MXFlutterPlugin.a().a(), "js_flutter.flutter_main_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new JsFlutterEngine.1(this));
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(MXFlutterPlugin.a().a(), "mxflutter.mxflutter_common_basic_channel", StringCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.setMessageHandler(new JsFlutterEngine.2(this));
  }
  
  public void a()
  {
    if (MXFlutterPlugin.a().a() != null) {
      MXFlutterPlugin.a().a().a();
    }
  }
  
  public void a(String paramString, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    MXFlutterPlugin.a().a().a("mxfJSBridgeInvokeJSCommonChannel", paramString, paramInvokeJSValueCallback);
  }
  
  public void a(Map paramMap)
  {
    MXFlutterPlugin.a().a().a(paramMap);
  }
  
  @Keep
  public void callJSMethodCallHandler(String paramString, MethodCall paramMethodCall, ExecuteScriptCallback paramExecuteScriptCallback)
  {
    JsEngineLoader.a().a().a(paramString, paramMethodCall, paramExecuteScriptCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine
 * JD-Core Version:    0.7.0.1
 */