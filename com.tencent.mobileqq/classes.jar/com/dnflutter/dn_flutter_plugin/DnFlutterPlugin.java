package com.dnflutter.dn_flutter_plugin;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class DnFlutterPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  static DnFlutterPlugin a;
  private MethodChannel b;
  private Map<String, DnFlutterPlugin.DecodeCompletion> c;
  private MethodChannel d;
  private IDNFlutterPluginDelegate e;
  
  public static DnFlutterPlugin a()
  {
    if (a == null) {
      a = new DnFlutterPlugin();
    }
    return a;
  }
  
  private String a(Map<String, Object> paramMap)
  {
    return (String)paramMap.get("zipUrl");
  }
  
  private Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.opt(str));
    }
    return localHashMap;
  }
  
  private void a(Map paramMap, Error paramError)
  {
    String str = a(paramMap);
    DnFlutterPlugin.DecodeCompletion localDecodeCompletion = (DnFlutterPlugin.DecodeCompletion)this.c.get(str);
    if (localDecodeCompletion != null)
    {
      localDecodeCompletion.a(paramMap, paramError);
      this.c.remove(str);
    }
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    DnFlutterPlugin localDnFlutterPlugin = a();
    localDnFlutterPlugin.b = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "dn_flutter_plugin", JSONMethodCodec.INSTANCE);
    localDnFlutterPlugin.b.setMethodCallHandler(localDnFlutterPlugin);
    localDnFlutterPlugin.d = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.dn_flutter/Method/decodeResource", JSONMethodCodec.INSTANCE);
    localDnFlutterPlugin.d.setMethodCallHandler(localDnFlutterPlugin);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    paramFlutterPluginBinding = this.b;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setMethodCallHandler(null);
    }
    paramFlutterPluginBinding = this.d;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setMethodCallHandler(null);
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
    if (paramMethodCall.method.equals("getBasicInfo"))
    {
      paramMethodCall = this.e;
      if (paramMethodCall != null)
      {
        paramMethodCall = paramMethodCall.a();
        if (paramMethodCall != null) {
          paramResult.success(paramMethodCall);
        }
      }
    }
    else if (paramMethodCall.method.equals("decodeResourceCompleted"))
    {
      String str = (String)paramMethodCall.argument("message");
      boolean bool = ((Boolean)paramMethodCall.argument("succeed")).booleanValue();
      Map localMap = a((JSONObject)paramMethodCall.argument("resource"));
      if (!bool)
      {
        if (str != null) {
          paramMethodCall = str;
        } else {
          paramMethodCall = "";
        }
        paramMethodCall = new Error(paramMethodCall);
      }
      else
      {
        paramMethodCall = null;
      }
      a(localMap, paramMethodCall);
      paramResult.success(null);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dnflutter.dn_flutter_plugin.DnFlutterPlugin
 * JD-Core Version:    0.7.0.1
 */