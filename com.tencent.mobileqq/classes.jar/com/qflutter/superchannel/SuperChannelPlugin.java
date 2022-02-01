package com.qflutter.superchannel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SuperChannelPlugin
  implements IEventCallback, ITaskCallback, FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String TAG = "SuperChannelPlugin";
  private static Stack<IEventCallback> pluginStack = new Stack();
  private MethodChannel channel;
  
  private List<SuperChannelTask> fromMap(List<Map> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      SuperChannelLog.w("SuperChannelPlugin", "[fromMap] invalid taskList");
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = SuperChannelTask.fromMap((Map)paramList.get(i));
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[fromMap] invalid task, ");
        ((StringBuilder)localObject).append(paramList.get(i));
        SuperChannelLog.w("SuperChannelPlugin", ((StringBuilder)localObject).toString());
      }
      else
      {
        ((SuperChannelTask)localObject).attachCallback(this);
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void sendEvent(@NonNull String paramString, @Nullable Map paramMap)
  {
    if (SuperChannelLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[sendEvent] eventName=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params=");
      ((StringBuilder)localObject).append(paramMap);
      SuperChannelLog.d("SuperChannelPlugin", ((StringBuilder)localObject).toString());
    }
    if (pluginStack.isEmpty())
    {
      SuperChannelLog.d("SuperChannelPlugin", "[sendEvent] no attached plugin");
      return;
    }
    IEventCallback localIEventCallback = (IEventCallback)pluginStack.peek();
    if (TextUtils.isEmpty(paramString))
    {
      SuperChannelLog.w("SuperChannelPlugin", "[sendEvent] invalid eventName");
      return;
    }
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    localIEventCallback.onSendEvent(paramString, (Map)localObject);
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (SuperChannelLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAttachedToEngine] hashCode=");
      localStringBuilder.append(hashCode());
      SuperChannelLog.d("SuperChannelPlugin", localStringBuilder.toString());
    }
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "__super_channel__");
    this.channel.setMethodCallHandler(this);
    pluginStack.push(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    if (SuperChannelLog.isColorLevel())
    {
      paramFlutterPluginBinding = new StringBuilder();
      paramFlutterPluginBinding.append("[onDetachedFromEngine] hashCode=");
      paramFlutterPluginBinding.append(hashCode());
      SuperChannelLog.d("SuperChannelPlugin", paramFlutterPluginBinding.toString());
    }
    this.channel.setMethodCallHandler(null);
    pluginStack.pop();
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (SuperChannelLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onMethodCall] method=");
      localStringBuilder.append(paramMethodCall.method);
      localStringBuilder.append(", hashCode=");
      localStringBuilder.append(hashCode());
      SuperChannelLog.d("SuperChannelPlugin", localStringBuilder.toString());
    }
    if (paramMethodCall.method.equals("batchTasks"))
    {
      paramMethodCall = fromMap((List)paramMethodCall.argument("tasks"));
      SuperChannelDispatcher.getInstance().dispatch(paramMethodCall, paramResult);
      return;
    }
    paramResult = new StringBuilder();
    paramResult.append("[onMethodCall] not implemented method: ");
    paramResult.append(paramMethodCall.method);
    SuperChannelLog.w("SuperChannelPlugin", paramResult.toString());
  }
  
  public void onSendEvent(String paramString, Map paramMap)
  {
    if (this.channel == null)
    {
      SuperChannelLog.w("SuperChannelPlugin", "[onSendEvent] invalid channel");
      return;
    }
    paramString = SuperChannelUtils.encodeEventResults(paramString, paramMap);
    this.channel.invokeMethod("__super_channel_event__", paramString);
  }
  
  public void sendTask(Map paramMap)
  {
    MethodChannel localMethodChannel = this.channel;
    if (localMethodChannel == null)
    {
      SuperChannelLog.w("SuperChannelPlugin", "[sendEvent] invalid channel");
      return;
    }
    localMethodChannel.invokeMethod("__super_channel_task__", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelPlugin
 * JD-Core Version:    0.7.0.1
 */