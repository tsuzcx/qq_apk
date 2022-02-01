package com.mojitox.mxflutter.framework;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StringCodec;
import java.nio.ByteBuffer;
import java.util.Map;

public class JsFlutterEngine
{
  BasicMessageChannel<String> a;
  public MethodChannel b;
  BasicMessageChannel<ByteBuffer> c;
  
  public JsFlutterEngine()
  {
    b();
  }
  
  private void b()
  {
    this.b = new MethodChannel(MXFlutterPlugin.a().b(), "js_flutter.flutter_main_channel");
    this.b.setMethodCallHandler(new JsFlutterEngine.1(this));
    this.a = new BasicMessageChannel(MXFlutterPlugin.a().b(), "mxflutter.mxflutter_common_basic_channel", StringCodec.INSTANCE);
    this.a.setMessageHandler(new JsFlutterEngine.2(this));
    this.c = new BasicMessageChannel(MXFlutterPlugin.a().b(), "mxflutter.jsSendPlatformMessageChannel", BinaryCodec.INSTANCE);
    this.c.setMessageHandler(new JsFlutterEngine.3(this));
  }
  
  public void a()
  {
    if (MXFlutterPlugin.a().c() != null) {
      MXFlutterPlugin.a().c().a();
    }
  }
  
  public void a(String paramString, @Nullable InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    MXFlutterPlugin.a().d().a("mxfJSBridgeInvokeJSCommonChannel", paramString, paramInvokeJSValueCallback);
  }
  
  public void a(String paramString1, String paramString2, InvokeJSValueCallback paramInvokeJSValueCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#invokeJsPlatformMessageChannel: method = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", message=");
    localStringBuilder.append(paramString2);
    MxLog.a("MXJSFlutterEngine", localStringBuilder.toString());
    MXFlutterPlugin.a().d().a(JsObjectType.APP_OBJECT, "mxfJSBridgeInvokeJSHandlePlatformMessage", paramInvokeJSValueCallback, new Object[] { paramString1, paramString2 });
  }
  
  public void a(Map paramMap)
  {
    MXFlutterPlugin.a().c().a(paramMap);
  }
  
  @Keep
  public void callJSMethodCallHandler(String paramString, MethodCall paramMethodCall, ExecuteScriptCallback paramExecuteScriptCallback)
  {
    JsEngineLoader.a().d().a(paramString, paramMethodCall, paramExecuteScriptCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine
 * JD-Core Version:    0.7.0.1
 */