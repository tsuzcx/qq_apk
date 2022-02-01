package com.qflutter.qqcircle;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TencentQQCirclePlugin
  implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler
{
  public static final String CHANNEL_NAME = "tencent_qqcircle";
  public static final String TAG = "TencentQQCirclePlugin";
  private static IQQCircleMethod methodBridge;
  private static Map<Integer, MethodChannel> methodChannelMap = new ConcurrentHashMap();
  private Activity activity;
  
  public static void sendEvent(String paramString, Map paramMap)
  {
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendEvent] map size=");
      ((StringBuilder)localObject).append(methodChannelMap.size());
      PLog.d("TencentQQCirclePlugin", ((StringBuilder)localObject).toString());
    }
    Object localObject = methodChannelMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MethodChannel localMethodChannel = (MethodChannel)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localMethodChannel == null)
      {
        Log.e("TencentQQCirclePlugin", "[sendEvent] invalid methodChannel");
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("name", paramString);
      localHashMap.put("arguments", paramMap);
      localMethodChannel.invokeMethod("__event__", localHashMap);
    }
  }
  
  public static void setQQCircleMethod(IQQCircleMethod paramIQQCircleMethod)
  {
    methodBridge = paramIQQCircleMethod;
  }
  
  public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToActivity] plugin=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    this.activity = paramActivityPluginBinding.getActivity();
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToEngine] plugin=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    try
    {
      paramFlutterPluginBinding = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tencent_qqcircle");
      paramFlutterPluginBinding.setMethodCallHandler(this);
      methodChannelMap.put(Integer.valueOf(hashCode()), paramFlutterPluginBinding);
      return;
    }
    catch (Throwable paramFlutterPluginBinding)
    {
      PLog.e("TencentQQCirclePlugin", "", paramFlutterPluginBinding);
    }
  }
  
  public void onDetachedFromActivity()
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDetachedFromActivity] plugin=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    this.activity = null;
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDetachedFromActivityForConfigChanges] plugin=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    this.activity = null;
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onDetachedFromEngine] plugin=");
      paramFlutterPluginBinding.append(hashCode());
      PLog.d("TencentQQCirclePlugin", paramFlutterPluginBinding.toString());
    }
    paramFlutterPluginBinding = (MethodChannel)methodChannelMap.remove(Integer.valueOf(hashCode()));
    if (PLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDetachedFromEngine] need remove channel=");
      localStringBuilder.append(paramFlutterPluginBinding);
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDetachedFromEngine] methodChannelMap size=");
    localStringBuilder.append(methodChannelMap.size());
    PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setMethodCallHandler(null);
    }
    this.activity = null;
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    Object localObject;
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onMethodCall] name=");
      ((StringBuilder)localObject).append(paramMethodCall.method);
      ((StringBuilder)localObject).append(", plugin=");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(", activity=");
      ((StringBuilder)localObject).append(this.activity);
      PLog.d("TencentQQCirclePlugin", ((StringBuilder)localObject).toString());
    }
    if (methodBridge != null)
    {
      if ("isInMultiWindowMode".equals(paramMethodCall.method))
      {
        if (Build.VERSION.SDK_INT >= 24)
        {
          paramMethodCall = this.activity;
          if (paramMethodCall != null)
          {
            bool = paramMethodCall.isInMultiWindowMode();
            break label173;
          }
        }
        paramMethodCall = new StringBuilder();
        paramMethodCall.append("[onMethodCall] SDK_INT=");
        paramMethodCall.append(Build.VERSION.SDK_INT);
        paramMethodCall.append(", activity=");
        paramMethodCall.append(this.activity);
        QLog.w("TencentQQCirclePlugin", 1, paramMethodCall.toString());
        boolean bool = false;
        label173:
        paramResult.success(Boolean.valueOf(bool));
        return;
      }
      localObject = null;
      Activity localActivity = this.activity;
      if (localActivity != null) {
        localObject = localActivity.findViewById(16908290);
      }
      methodBridge.onMethodCall(this.activity, (View)localObject, paramMethodCall, paramResult);
      return;
    }
    paramMethodCall = new StringBuilder();
    paramMethodCall.append("invalid methodBridge, plugin=");
    paramMethodCall.append(hashCode());
    PLog.e("TencentQQCirclePlugin", paramMethodCall.toString());
  }
  
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReattachedToActivityForConfigChanges] plugin=");
      localStringBuilder.append(hashCode());
      PLog.d("TencentQQCirclePlugin", localStringBuilder.toString());
    }
    this.activity = paramActivityPluginBinding.getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.TencentQQCirclePlugin
 * JD-Core Version:    0.7.0.1
 */