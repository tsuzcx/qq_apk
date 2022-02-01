package com.mojitox.mxflutter.framework;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;

class JsFlutterEngine$3
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  JsFlutterEngine$3(JsFlutterEngine paramJsFlutterEngine) {}
  
  public void a(@Nullable ByteBuffer paramByteBuffer, @NonNull BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    MethodCall localMethodCall = StandardMethodCodec.INSTANCE.decodeMethodCall(paramByteBuffer);
    paramByteBuffer = (byte[])localMethodCall.arguments;
    if (paramByteBuffer != null) {
      paramByteBuffer = Base64.encodeToString(paramByteBuffer, 2);
    } else {
      paramByteBuffer = null;
    }
    if (localMethodCall.method == null) {
      return;
    }
    Object localObject = paramByteBuffer;
    if (paramByteBuffer == null) {
      localObject = "";
    }
    this.a.a(localMethodCall.method, (String)localObject, new JsFlutterEngine.3.1(this, paramReply));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.JsFlutterEngine.3
 * JD-Core Version:    0.7.0.1
 */