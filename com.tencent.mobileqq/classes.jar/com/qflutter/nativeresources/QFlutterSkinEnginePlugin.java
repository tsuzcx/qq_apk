package com.qflutter.nativeresources;

import android.text.TextUtils;
import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public class QFlutterSkinEnginePlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final String SKIN_PLUGIN_CHANNEL_NAME = "qflutter_skin_engine_plugin";
  public static final String TAG = "QFlutterSkinEngine";
  private static String mCurrentThemeId;
  private MethodChannel mMethodChannel;
  
  public static void initTheme() {}
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.mMethodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "qflutter_skin_engine_plugin");
    this.mMethodChannel.setMethodCallHandler(new QFlutterSkinEnginePlugin());
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult) {}
  
  public void updateTheme(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateTheme: ");
    localStringBuilder.append(paramString);
    Log.d("QFlutterSkinEngine", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(mCurrentThemeId)))
    {
      mCurrentThemeId = paramString;
      this.mMethodChannel.invokeMethod("onPostThemeChanged", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.nativeresources.QFlutterSkinEnginePlugin
 * JD-Core Version:    0.7.0.1
 */