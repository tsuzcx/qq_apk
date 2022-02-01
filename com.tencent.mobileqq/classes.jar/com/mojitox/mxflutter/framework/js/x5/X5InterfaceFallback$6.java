package com.mojitox.mxflutter.framework.js.x5;

import android.util.Base64;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;

class X5InterfaceFallback$6
  implements BasicMessageChannel.Reply<ByteBuffer>
{
  public void a(@Nullable ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      paramByteBuffer = null;
    } else {
      paramByteBuffer = Base64.encodeToString(paramByteBuffer.array(), 2);
    }
    this.a.a.a(this.b, paramByteBuffer, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceFallback.6
 * JD-Core Version:    0.7.0.1
 */