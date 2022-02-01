package com.qflutter.video;

import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.platform.PlatformViewRegistry;

public class QflutterVideoviewPlugin
{
  public static final String TAG = "QFVideoView";
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    paramRegistrar.platformViewRegistry().registerViewFactory("plugins.flutter.io/qflutter_videoview", new QflutterVideoViewFactory(paramRegistrar.messenger(), paramRegistrar));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.video.QflutterVideoviewPlugin
 * JD-Core Version:    0.7.0.1
 */