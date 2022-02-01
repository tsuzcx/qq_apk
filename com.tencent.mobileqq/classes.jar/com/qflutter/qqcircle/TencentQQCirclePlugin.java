package com.qflutter.qqcircle;

import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;

public class TencentQQCirclePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String CHANNEL_NAME = "tencent_qqcircle";
  public static final String TAG = "TencentQQCirclePlugin";
  private static MethodChannel methodChannel;
  
  public static MethodChannel getMethodChannel()
  {
    return methodChannel;
  }
  
  public static void sendEvent(String paramString, Map paramMap)
  {
    if (methodChannel == null)
    {
      Log.e("TencentQQCirclePlugin", "[sendEvent] invalid methodChannel");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString);
    localHashMap.put("arguments", paramMap);
    methodChannel.invokeMethod("__event__", localHashMap);
  }
  
  public static void setQQCircleMethod(IQQCircleMethod paramIQQCircleMethod)
  {
    MethodDispatcher.getInstance().setMethodBridge(paramIQQCircleMethod);
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    paramFlutterPluginBinding = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tencent_qqcircle");
    paramFlutterPluginBinding.setMethodCallHandler(new TencentQQCirclePlugin());
    methodChannel = paramFlutterPluginBinding;
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
    MethodDispatcher.getInstance().setMethodBridge(null);
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    MethodDispatcher.getInstance().dispatch(paramMethodCall, paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqcircle.TencentQQCirclePlugin
 * JD-Core Version:    0.7.0.1
 */