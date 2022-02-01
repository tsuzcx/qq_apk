package com.qflutter.qqcircle;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.qflutter.qqcircle.video.Messages.VideoPlayerApi._CC;
import com.qflutter.qqcircle.video.QCircleVideoPlayerApi;
import com.qflutter.qqcircle.video.QQCircleVideoProxy;
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
  private static Class<? extends QCircleVideoPlayerApi> videoPlayerApiImplClazz;
  private Activity activity;
  private QQCircleVideoProxy videoProxy;
  
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
    for (;;)
    {
      MethodChannel localMethodChannel;
      if (((Iterator)localObject).hasNext())
      {
        localMethodChannel = (MethodChannel)((Map.Entry)((Iterator)localObject).next()).getValue();
        if (localMethodChannel == null) {
          Log.e("TencentQQCirclePlugin", "[sendEvent] invalid methodChannel");
        }
      }
      else
      {
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
  
  public static void setVideoPlayerApi(Class<? extends QCircleVideoPlayerApi> paramClass)
  {
    videoPlayerApiImplClazz = paramClass;
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
    Object localObject;
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onAttachedToEngine] plugin=");
      ((StringBuilder)localObject).append(hashCode());
      PLog.d("TencentQQCirclePlugin", ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tencent_qqcircle");
      ((MethodChannel)localObject).setMethodCallHandler(this);
      methodChannelMap.put(Integer.valueOf(hashCode()), localObject);
      if (videoPlayerApiImplClazz == null)
      {
        PLog.w("TencentQQCirclePlugin", "[onAttachedToEngine] videoPlayerApiImplClazz can not be null");
        return;
      }
      this.videoProxy = new QQCircleVideoProxy(paramFlutterPluginBinding.getTextureRegistry(), paramFlutterPluginBinding.getBinaryMessenger());
      long l = System.currentTimeMillis();
      localObject = (QCircleVideoPlayerApi)videoPlayerApiImplClazz.newInstance();
      this.videoProxy.setVideoPlayerApi((QCircleVideoPlayerApi)localObject);
      Messages.VideoPlayerApi._CC.setup(paramFlutterPluginBinding.getBinaryMessenger(), this.videoProxy);
      if (PLog.isColorLevel())
      {
        paramFlutterPluginBinding = new StringBuilder();
        paramFlutterPluginBinding.append("[onAttachedToEngine] cost=");
        paramFlutterPluginBinding.append(System.currentTimeMillis() - l);
        PLog.d("TencentQQCirclePlugin", paramFlutterPluginBinding.toString());
        return;
      }
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
    if (this.videoProxy != null)
    {
      this.videoProxy.clean();
      this.videoProxy = null;
    }
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
      if (PLog.isColorLevel()) {
        PLog.d("TencentQQCirclePlugin", "[onMethodCall]");
      }
      localObject = null;
      if (this.activity != null) {
        localObject = this.activity.findViewById(16908290);
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