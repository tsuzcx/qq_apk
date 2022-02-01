package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class X5Interface$1
  implements BasicMessageChannel.Reply<String>
{
  public void a(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlutterCommonChannelInvoker_reply:");
    localStringBuilder.append(paramString);
    MxLog.a("X5Interface", localStringBuilder.toString());
    if (this.b != null) {
      this.a.a.a(this.b, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Interface.1
 * JD-Core Version:    0.7.0.1
 */