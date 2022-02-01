package com.qflutter.audio;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.qflutter.audio.log.ILog;
import com.qflutter.audio.log.LogUtils;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TencentQflutterAudioPlugin
  implements IPlayerStatusListener, FlutterPlugin, EventChannel.StreamHandler, MethodChannel.MethodCallHandler
{
  public static final String[] EVENT_CHANNEL_EVENTS = { "onAudioStartPlay", "onAudioFinishPlay", "onAudioPlayFailed" };
  public static final String EVENT_CHANNEL_NAME_PREFIX = "com.tencent.qflutter/audio_event";
  private static final String TAG = "TencentQflutterAudioPlugin";
  private final List<EventChannel> mEventChannels = new ArrayList();
  private final Map<Object, EventChannel.EventSink> mSinkMap = new HashMap();
  
  public TencentQflutterAudioPlugin() {}
  
  public TencentQflutterAudioPlugin(PluginRegistry.Registrar paramRegistrar)
  {
    initChannel(paramRegistrar.messenger());
  }
  
  private void initChannel(BinaryMessenger paramBinaryMessenger)
  {
    new MethodChannel(paramBinaryMessenger, "com.tencent.qflutter/audio_method").setMethodCallHandler(this);
    String[] arrayOfString = EVENT_CHANNEL_EVENTS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.tencent.qflutter/audio_event.");
      localStringBuilder.append((String)localObject);
      localObject = new EventChannel(paramBinaryMessenger, localStringBuilder.toString());
      ((EventChannel)localObject).setStreamHandler(this);
      this.mEventChannels.add(localObject);
      i += 1;
    }
  }
  
  private void notify2Flutter(String paramString, Map<String, Object> paramMap)
  {
    LogUtils.i("TencentQflutterAudioPlugin", "notify2Flutter");
    paramString = (EventChannel.EventSink)this.mSinkMap.get(paramString);
    if (paramString != null) {
      paramString.success(paramMap);
    }
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new TencentQflutterAudioPlugin(paramRegistrar);
  }
  
  public static void setLog(ILog paramILog)
  {
    LogUtils.setLog(paramILog);
  }
  
  public static void setPlayer(BasePlayer paramBasePlayer)
  {
    PlayerManager.setPlayer(paramBasePlayer);
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    initChannel(paramFlutterPluginBinding.getBinaryMessenger());
  }
  
  @UiThread
  public void onAudioFinishPlay(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAudioFinishPlay：");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.i("TencentQflutterAudioPlugin", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("url", paramString);
    notify2Flutter(EVENT_CHANNEL_EVENTS[1], (Map)localObject);
  }
  
  @UiThread
  public void onAudioPlayFailed(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAudioPlayFailed：");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    LogUtils.i("TencentQflutterAudioPlugin", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("url", paramString1);
    ((Map)localObject).put("errorCode", Integer.valueOf(paramInt));
    ((Map)localObject).put("errorMsg", paramString2);
    notify2Flutter(EVENT_CHANNEL_EVENTS[2], (Map)localObject);
  }
  
  @UiThread
  public void onAudioStartPlay(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAudioStartPlay：");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.i("TencentQflutterAudioPlugin", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((Map)localObject).put("url", paramString);
    notify2Flutter(EVENT_CHANNEL_EVENTS[0], (Map)localObject);
  }
  
  public void onCancel(Object paramObject)
  {
    LogUtils.i("TencentQflutterAudioPlugin", "onCancel");
    this.mSinkMap.remove(paramObject);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    LogUtils.i("TencentQflutterAudioPlugin", "onDetachedFromEngine");
    PlayerManager.dispose();
    paramFlutterPluginBinding = this.mEventChannels.iterator();
    while (paramFlutterPluginBinding.hasNext()) {
      ((EventChannel)paramFlutterPluginBinding.next()).setStreamHandler(null);
    }
    this.mSinkMap.clear();
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (!this.mSinkMap.containsKey(paramObject)) {
      this.mSinkMap.put(paramObject, paramEventSink);
    }
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMethodCall：");
    ((StringBuilder)localObject).append(paramMethodCall.method);
    LogUtils.i("TencentQflutterAudioPlugin", ((StringBuilder)localObject).toString());
    localObject = paramMethodCall.method;
    switch (((String)localObject).hashCode())
    {
    default: 
      break;
    case 2067533524: 
      if (((String)localObject).equals("pauseAudioPlay")) {
        i = 2;
      }
      break;
    case 369519285: 
      if (((String)localObject).equals("audioPreDownLoad")) {
        i = 0;
      }
      break;
    case 116457283: 
      if (((String)localObject).equals("continueAudioPlay")) {
        i = 4;
      }
      break;
    case -166270488: 
      if (((String)localObject).equals("startAudioPlay")) {
        i = 1;
      }
      break;
    case -1823622584: 
      if (((String)localObject).equals("stopAudioPlay")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              paramResult.notImplemented();
              return;
            }
            PlayerManager.continueAudioPlay(paramResult);
            return;
          }
          PlayerManager.stopAudioPlay(paramResult);
          return;
        }
        PlayerManager.pauseAudioPlay(paramResult);
        return;
      }
      paramMethodCall = (String)paramMethodCall.argument("url");
      PlayerManager.setAudioPlayerListener(this);
      PlayerManager.startAudioPlay(paramMethodCall, paramResult);
      return;
    }
    PlayerManager.audioPreDownLoad((String)paramMethodCall.argument("url"), paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.audio.TencentQflutterAudioPlugin
 * JD-Core Version:    0.7.0.1
 */