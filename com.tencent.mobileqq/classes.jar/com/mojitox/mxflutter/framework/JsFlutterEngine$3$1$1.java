package com.mojitox.mxflutter.framework;

import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.StandardMessageCodec;

class JsFlutterEngine$3$1$1
  implements Runnable
{
  JsFlutterEngine$3$1$1(JsFlutterEngine.3.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    this.a.b.reply(StandardMessageCodec.INSTANCE.encodeMessage(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.3.1.1
 * JD-Core Version:    0.7.0.1
 */