package com.qflutter.qqface;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qflutter.qqface.data.QQFaceFlutterData;
import com.qflutter.qqface.data.QQFaceParam;
import com.qflutter.qqface.loader.QQFaceLoader;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class QQFacePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String CHANNEL_NAME = "QQ_FACE_CHANNEL";
  private static final String METHOD_CLEAR_CACHE = "clearCache";
  private static final String METHOD_GET_QQ_FACE = "getQQFace";
  public static final String METHOD_NOTIFY_NATIVE_UPDATE = "onNativeUpdate";
  private static final String METHOD_RELEASE_BITMAP = "releaseBitmap";
  private static final String PARAM_DATA_FORMAT = "data_format";
  private static final String PARAM_FACE_ID = "face_id";
  private static final String TAG = "QQFacePlugin";
  private MethodChannel mMethodChannel;
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.mMethodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "QQ_FACE_CHANNEL");
    this.mMethodChannel.setMethodCallHandler(new QQFacePlugin());
    QQFaceLoader.instance().onAttachedToEngine(this);
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    QQFaceLoader.instance().onDetachedFromEngine(this);
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("native onMethodCall: ");
    localStringBuilder.append(str);
    Log.d("QQFacePlugin", localStringBuilder.toString());
    if ("getQQFace".equals(str))
    {
      QQFaceLoader.instance().asyncLoadQQFace(new QQFaceParam(paramMethodCall), paramResult);
      return;
    }
    if ("releaseBitmap".equals(str))
    {
      str = (String)paramMethodCall.argument("face_id");
      paramMethodCall = (Integer)paramMethodCall.argument("data_format");
      if ((!TextUtils.isEmpty(str)) && (paramMethodCall != null)) {
        QQFaceLoader.instance().removeCache(str, paramMethodCall.intValue());
      }
    }
    else
    {
      if (!"clearCache".equals(str)) {
        break label141;
      }
      QQFaceLoader.instance().clearCache();
    }
    paramResult.success(null);
    return;
    label141:
    paramResult.notImplemented();
  }
  
  public void updateHead(QQFaceFlutterData paramQQFaceFlutterData)
  {
    MethodChannel localMethodChannel = this.mMethodChannel;
    if (localMethodChannel != null) {
      localMethodChannel.invokeMethod("onNativeUpdate", paramQQFaceFlutterData.toMap(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqface.QQFacePlugin
 * JD-Core Version:    0.7.0.1
 */