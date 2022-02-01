package com.qflutter.qflutter_network_image;

import android.os.Build.VERSION;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class QflutterNetworkImagePlugin
  implements MethodChannel.MethodCallHandler
{
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "com.tencent.qflutter/qflutter_network_image").setMethodCallHandler(new QflutterNetworkImagePlugin());
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    if (str.equals("getPlatformVersion"))
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("Android ");
      paramMethodCall.append(Build.VERSION.RELEASE);
    }
    for (paramMethodCall = paramMethodCall.toString();; paramMethodCall = Boolean.valueOf(true))
    {
      paramResult.success(paramMethodCall);
      return;
      if (!str.equals("enableNativeImageDownloader")) {
        break;
      }
    }
    if (str.equals("getNetworkImage"))
    {
      str = (String)paramMethodCall.argument("url");
      Integer localInteger = (Integer)paramMethodCall.argument("decodeWidth");
      paramMethodCall = (Integer)paramMethodCall.argument("decodeHeight");
      int j = -1;
      int i;
      if (localInteger == null) {
        i = -1;
      } else {
        i = localInteger.intValue();
      }
      if (paramMethodCall != null) {
        j = paramMethodCall.intValue();
      }
      QFlutterNetworkImage.g().getNetworkImage(str, i, j, paramResult);
      return;
    }
    if (str.equals("releaseNetworkImage"))
    {
      paramMethodCall = (String)paramMethodCall.argument("url");
      QFlutterNetworkImage.g().releaseNetworkImage(paramMethodCall, paramResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin
 * JD-Core Version:    0.7.0.1
 */