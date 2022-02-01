package com.qflutter.video;

import android.content.Context;
import android.view.ViewGroup;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;

public class QflutterVideoViewFactory
  extends PlatformViewFactory
{
  private final BinaryMessenger messenger;
  private final PluginRegistry.Registrar registrar;
  
  public QflutterVideoViewFactory(BinaryMessenger paramBinaryMessenger, PluginRegistry.Registrar paramRegistrar)
  {
    super(StandardMessageCodec.INSTANCE);
    this.messenger = paramBinaryMessenger;
    this.registrar = paramRegistrar;
  }
  
  public PlatformView create(Context paramContext, int paramInt, Object paramObject)
  {
    return new QflutterVideoView(((ViewGroup)this.registrar.view().getParent()).getContext(), this.messenger, paramInt, this.registrar.textures().createSurfaceTexture(), ArgumentUtil.transFlutterArguments(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.video.QflutterVideoViewFactory
 * JD-Core Version:    0.7.0.1
 */