package com.mojitox.mxflutter.framework;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.executor.UiThread;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class JsFlutterEngine$2$1
  implements InvokeJSValueCallback
{
  JsFlutterEngine$2$1(JsFlutterEngine.2 param2, BasicMessageChannel.Reply paramReply) {}
  
  public void a(Error paramError) {}
  
  public void a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    } else {
      paramObject = paramObject.toString();
    }
    UiThread.b(new JsFlutterEngine.2.1.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.2.1
 * JD-Core Version:    0.7.0.1
 */