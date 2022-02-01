package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.constants.JsConstant;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.constants.MxConfig;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StringCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JsFlutterApp
{
  MethodChannel a;
  BasicMessageChannel<String> b;
  BasicMessageChannel<String> c;
  private final ArrayList<MethodCall> d;
  private volatile boolean e;
  private long f;
  
  public JsFlutterApp()
  {
    a(MXFlutterPlugin.a().b());
    this.d = new ArrayList(1);
  }
  
  private void a(long paramLong)
  {
    MxLog.a("JsFlutterApp", "#onMainJsLoadComplete: on main js load success");
    this.e = true;
    g();
    this.f = (System.currentTimeMillis() - paramLong);
    f();
    e();
  }
  
  private void a(BinaryMessenger paramBinaryMessenger)
  {
    this.a = new MethodChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel");
    this.a.setMethodCallHandler(new JsFlutterApp.1(this));
    this.c = new BasicMessageChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel.rebuild", StringCodec.INSTANCE);
    this.b = new BasicMessageChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel.navigator_push", StringCodec.INSTANCE);
  }
  
  private void b(Map paramMap)
  {
    MxLog.a("JsFlutterApp", "#realStartApp: begin");
    c(paramMap);
    long l = System.currentTimeMillis();
    if (JsEngineLoader.a().f())
    {
      MxLog.a("JsFlutterApp", "#realStartApp: load main js success");
      MXFlutterPlugin.a().e().a(JsConstant.a(), null);
      a(l);
      return;
    }
    paramMap = MxConfig.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#realStartApp: mainJsPath=");
    ((StringBuilder)localObject).append(paramMap);
    MxLog.a("JsFlutterApp", ((StringBuilder)localObject).toString());
    localObject = new JsFlutterApp.3(this, l, paramMap);
    if (JsEngineLoader.a().e())
    {
      JsEngineLoader.a().a((InvokeJSValueCallback)localObject);
      MxLog.a("JsFlutterApp", "#realStartApp: is loading main js");
      return;
    }
    MxLog.a("JsFlutterApp", "#realStartApp: begin load main js");
    MXFlutterPlugin.a().d().d();
    MXFlutterPlugin.a().d().a(paramMap, (InvokeJSValueCallback)localObject);
  }
  
  private void c(Map paramMap)
  {
    MXFlutterPlugin.a().d().b("mx_flutterAppEnvironmentInfo", paramMap);
    MXFlutterPlugin.a().d().b("isFlutterAppEngineSetup", Boolean.valueOf(true));
  }
  
  private void e()
  {
    UiThread.a(new JsFlutterApp.4(this));
  }
  
  private void f()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("method", "nativeCallInitProfileInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("mxNativeJSLoadCost", Long.valueOf(this.f));
    ((Map)localObject).put("arguments", localHashMap);
    localObject = new MethodCall("nativeCall", new JSONObject((Map)localObject).toString());
    if (!this.e)
    {
      this.d.add(localObject);
      return;
    }
    MXFlutterPlugin.a().d().a(JsObjectType.CURRENT_APP_OBJECT, ((MethodCall)localObject).method, ((MethodCall)localObject).arguments, null);
  }
  
  private void g()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      MethodCall localMethodCall = (MethodCall)localIterator.next();
      MXFlutterPlugin.a().d().a(JsObjectType.CURRENT_APP_OBJECT, localMethodCall.method, localMethodCall.arguments, null);
    }
    this.d.clear();
  }
  
  public void a()
  {
    JsEngineLoader.a().b();
  }
  
  public void a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#runApp: begin isJsAppRun=");
    localStringBuilder.append(this.e);
    MxLog.a("JsFlutterApp", localStringBuilder.toString());
    if (this.e)
    {
      this.e = false;
      MxLog.a("JsFlutterApp", "#runApp: hotreload");
      JsEngineLoader.a().a(new JsFlutterApp.2(this, paramMap));
      return;
    }
    b(paramMap);
  }
  
  public MethodChannel b()
  {
    return this.a;
  }
  
  public BasicMessageChannel<String> c()
  {
    return this.b;
  }
  
  public BasicMessageChannel<String> d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp
 * JD-Core Version:    0.7.0.1
 */