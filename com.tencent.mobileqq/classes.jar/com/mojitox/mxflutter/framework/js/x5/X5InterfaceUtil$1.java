package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.JsFlutterApp;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MethodChannel;

final class X5InterfaceUtil$1
  implements Runnable
{
  public void run()
  {
    if (this.b.equals("rebuild")) {}
    for (BasicMessageChannel localBasicMessageChannel = MXFlutterPlugin.a().a().b();; localBasicMessageChannel = MXFlutterPlugin.a().a().a())
    {
      localBasicMessageChannel.send(this.a);
      return;
      if (!this.b.equals("navigatorPush")) {
        break;
      }
    }
    MXFlutterPlugin.a().a().a().invokeMethod(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceUtil.1
 * JD-Core Version:    0.7.0.1
 */