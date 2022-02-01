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
      paramResult.success(paramMethodCall.toString());
    }
    label149:
    do
    {
      return;
      if (str.equals("enableNativeImageDownloader"))
      {
        paramResult.success(Boolean.valueOf(true));
        return;
      }
      if (str.equals("getNetworkImage"))
      {
        str = (String)paramMethodCall.argument("url");
        Integer localInteger = (Integer)paramMethodCall.argument("decodeWidth");
        paramMethodCall = (Integer)paramMethodCall.argument("decodeHeight");
        int i;
        if (localInteger == null)
        {
          i = -1;
          if (paramMethodCall != null) {
            break label149;
          }
        }
        for (int j = -1;; j = paramMethodCall.intValue())
        {
          QFlutterNetworkImage.g().getNetworkImage(str, i, j, paramResult);
          return;
          i = localInteger.intValue();
          break;
        }
      }
    } while (!str.equals("releaseNetworkImage"));
    paramMethodCall = (String)paramMethodCall.argument("url");
    QFlutterNetworkImage.g().releaseNetworkImage(paramMethodCall, paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qflutter_network_image.QflutterNetworkImagePlugin
 * JD-Core Version:    0.7.0.1
 */