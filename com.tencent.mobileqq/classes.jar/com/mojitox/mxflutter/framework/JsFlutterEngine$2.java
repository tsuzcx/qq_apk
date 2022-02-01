package com.mojitox.mxflutter.framework;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class JsFlutterEngine$2
  implements BasicMessageChannel.MessageHandler<String>
{
  JsFlutterEngine$2(JsFlutterEngine paramJsFlutterEngine) {}
  
  public void a(String paramString, @NonNull BasicMessageChannel.Reply<String> paramReply)
  {
    this.a.a(paramString, new JsFlutterEngine.2.1(this, paramReply));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.2
 * JD-Core Version:    0.7.0.1
 */