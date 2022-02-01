package com.qflutter.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.Map;

public class QflutterVideoView
  implements MethodChannel.MethodCallHandler, PlatformView
{
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  private final MethodChannel methodChannel;
  private final IQflutterVideoView videoView;
  
  public QflutterVideoView(Context paramContext, BinaryMessenger paramBinaryMessenger, int paramInt, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, Map<String, Object> paramMap)
  {
    Log.d("QFVideoView", "init video View");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("plugins.flutter.io/qflutter_videoview_");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel Name: ");
    localStringBuilder.append((String)localObject);
    Log.d("QFVideoView", localStringBuilder.toString());
    this.methodChannel = new MethodChannel(paramBinaryMessenger, (String)localObject);
    this.methodChannel.setMethodCallHandler(this);
    this.videoView = ((IQflutterVideoView)QflutterVideoViewSource.getVideoView(paramContext, paramInt, new Surface(paramSurfaceTextureEntry.surfaceTexture()), paramMap));
    this.videoView.onStatus(new QflutterVideoView.1(this));
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(paramMap.get("videoUrl"));
    paramContext = paramContext.toString();
    paramBinaryMessenger = new StringBuilder();
    paramBinaryMessenger.append("videoUrl: ");
    paramBinaryMessenger.append(paramContext);
    Log.d("QFVideoView", paramBinaryMessenger.toString());
    if (!"null".equals(paramContext))
    {
      paramContext = new QflutterVideoView.2(this, paramContext);
      paramBinaryMessenger = paramMap.get("initialTime");
      if ((paramBinaryMessenger instanceof Number)) {
        paramContext.put("initialTime", paramBinaryMessenger);
      }
      paramBinaryMessenger = paramMap.get("autoplay");
      if ((paramBinaryMessenger instanceof Boolean)) {
        paramContext.put("autoplay", paramBinaryMessenger);
      }
      this.videoView.update(paramContext);
    }
  }
  
  private String statusToEventName(int paramInt, Map<String, ?> paramMap)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 16: 
      paramMap = paramMap.get("fullScreen");
      if (((paramMap instanceof Boolean)) && (((Boolean)paramMap).booleanValue() == true)) {
        return "requestFullScreen";
      }
      return "exitFullScreen";
    case 14: 
    case 15: 
      return "";
    case 13: 
      return "bindloadedmetadata";
    case 10: 
    case 11: 
    case 12: 
      return "";
    case 9: 
      return "binderror";
    case 8: 
      return "bindended";
    case 7: 
      return "bindtimeupdate";
    case 6: 
      return "";
    case 5: 
      return "seek";
    case 4: 
      return "stop";
    case 3: 
      return "bindpause";
    case 2: 
      return "bindplay";
    }
    return "bindwaiting";
  }
  
  public void dispose() {}
  
  public View getView()
  {
    return (View)this.videoView;
  }
  
  public void onInputConnectionLocked() {}
  
  public void onInputConnectionUnlocked() {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMethodCall ");
    ((StringBuilder)localObject).append(paramMethodCall.method);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(paramMethodCall.arguments);
    Log.d("QFVideoView", ((StringBuilder)localObject).toString());
    localObject = ArgumentUtil.transFlutterArguments(paramMethodCall.arguments());
    if (!"operate".equals(paramMethodCall.method))
    {
      if (("seek".equals(paramMethodCall.method)) && (((Map)localObject).containsKey("time"))) {
        ((Map)localObject).put("data", new QflutterVideoView.3(this, (Map)localObject));
      }
      ((Map)localObject).put("type", paramMethodCall.method);
    }
    this.videoView.operate((Map)localObject);
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.video.QflutterVideoView
 * JD-Core Version:    0.7.0.1
 */