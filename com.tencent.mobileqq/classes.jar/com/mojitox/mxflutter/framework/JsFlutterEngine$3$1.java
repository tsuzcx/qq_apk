package com.mojitox.mxflutter.framework;

import android.util.Base64;
import com.mojitox.mxflutter.framework.callback.InvokeJSValueCallback;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class JsFlutterEngine$3$1
  implements InvokeJSValueCallback
{
  JsFlutterEngine$3$1(JsFlutterEngine.3 param3, BasicMessageChannel.Reply paramReply) {}
  
  public void a(Error paramError)
  {
    MxLog.b("MXJSFlutterEngine", "#jsSendPlatformMessageChannel: error = ", paramError);
  }
  
  public void a(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#jsSendPlatformMessageChannel: result = ");
    localStringBuilder.append(paramObject);
    MxLog.a("MXJSFlutterEngine", localStringBuilder.toString());
    UiThread.a(new JsFlutterEngine.3.1.1(this, Base64.decode((String)paramObject, 2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.3.1
 * JD-Core Version:    0.7.0.1
 */