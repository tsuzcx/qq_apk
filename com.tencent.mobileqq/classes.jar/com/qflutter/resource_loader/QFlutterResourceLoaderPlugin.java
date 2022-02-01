package com.qflutter.resource_loader;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class QFlutterResourceLoaderPlugin
  implements MethodChannel.MethodCallHandler
{
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new MethodChannel(paramRegistrar.messenger(), "qflutter_resource_loader_plugin").setMethodCallHandler(new QFlutterResourceLoaderPlugin());
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("loadNativeThemeInfo"))
    {
      QFlutterResourceLoader.get().loadNativeThemeInfo(paramResult);
      return;
    }
    if (paramMethodCall.method.equals("getNativeImageInfo"))
    {
      paramMethodCall = (String)paramMethodCall.argument("nativeImageID");
      QFlutterResourceLoader.get().loadNativeImageInfo(paramMethodCall, paramResult);
      return;
    }
    if (paramMethodCall.method.equals("releaseNativeImageRef"))
    {
      paramMethodCall = (String)paramMethodCall.argument("nativeImageID");
      QFlutterResourceLoader.get().deCache(paramMethodCall);
      return;
    }
    if (paramMethodCall.method.equals("getNativeImageRawByteList"))
    {
      paramMethodCall = (String)paramMethodCall.argument("nativeImageID");
      QFlutterResourceLoader.get().getNativeImageRawByteList(paramMethodCall, paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.resource_loader.QFlutterResourceLoaderPlugin
 * JD-Core Version:    0.7.0.1
 */