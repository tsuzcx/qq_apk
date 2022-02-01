package com.mojitox.mxflutter.framework;

import com.mojitox.mxflutter.MXFlutterPlugin;
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
  private long jdField_a_of_type_Long;
  BasicMessageChannel<String> jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel;
  MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  private final ArrayList<MethodCall> jdField_a_of_type_JavaUtilArrayList;
  private volatile boolean jdField_a_of_type_Boolean;
  BasicMessageChannel<String> b;
  
  public JsFlutterApp()
  {
    a(MXFlutterPlugin.a().a());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  }
  
  private void a(long paramLong)
  {
    MxLog.a("JsFlutterApp", "on main js load success");
    this.jdField_a_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - paramLong);
    c();
    b();
  }
  
  private void a(BinaryMessenger paramBinaryMessenger)
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new JsFlutterApp.1(this));
    this.b = new BasicMessageChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel.rebuild", StringCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "js_flutter.js_flutter_app_channel.navigator_push", StringCodec.INSTANCE);
  }
  
  private void b()
  {
    UiThread.a(new JsFlutterApp.4(this));
  }
  
  private void b(Map paramMap)
  {
    c(paramMap);
    long l = System.currentTimeMillis();
    if (JsEngineLoader.a().b())
    {
      MxLog.a("JsFlutterApp", "load main js success");
      MXFlutterPlugin.a().a().a(JsConstant.a(), null);
      a(l);
      return;
    }
    paramMap = MxConfig.b();
    JsFlutterApp.3 local3 = new JsFlutterApp.3(this, l, paramMap);
    if (JsEngineLoader.a().a())
    {
      JsEngineLoader.a().a(local3);
      MxLog.a("JsFlutterApp", "is load main js");
      return;
    }
    MxLog.a("JsFlutterApp", "begin load main js");
    MXFlutterPlugin.a().a().a();
    MXFlutterPlugin.a().a().a(paramMap, local3);
  }
  
  private void c()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("method", "nativeCallInitProfileInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("mxNativeJSLoadCost", Long.valueOf(this.jdField_a_of_type_Long));
    ((Map)localObject).put("arguments", localHashMap);
    localObject = new MethodCall("nativeCall", new JSONObject((Map)localObject).toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return;
    }
    MXFlutterPlugin.a().a().a(JsObjectType.CURRENT_APP_OBJECT, ((MethodCall)localObject).method, ((MethodCall)localObject).arguments, null);
  }
  
  private void c(Map paramMap)
  {
    MXFlutterPlugin.a().a().a("mx_flutterAppEnvironmentInfo", paramMap);
    MXFlutterPlugin.a().a().a("isFlutterAppEngineSetup", Boolean.valueOf(true));
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MethodCall localMethodCall = (MethodCall)localIterator.next();
      MXFlutterPlugin.a().a().a(JsObjectType.CURRENT_APP_OBJECT, localMethodCall.method, localMethodCall.arguments, null);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public BasicMessageChannel<String> a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel;
  }
  
  public MethodChannel a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  }
  
  public void a()
  {
    JsEngineLoader.a().a();
  }
  
  public void a(Map paramMap)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      JsEngineLoader.a().a(new JsFlutterApp.2(this, paramMap));
      return;
    }
    b(paramMap);
  }
  
  public BasicMessageChannel<String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterApp
 * JD-Core Version:    0.7.0.1
 */