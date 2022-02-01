package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class X5InterfaceFallback$1
  implements BasicMessageChannel.Reply<String>
{
  public void a(@Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FlutterCommonChannelInvoker_reply:");
    ((StringBuilder)localObject).append(paramString);
    MxLog.a("X5InterfaceFallback", ((StringBuilder)localObject).toString());
    localObject = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    ((X5Executor)localObject).a(localStringBuilder.toString(), paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceFallback.1
 * JD-Core Version:    0.7.0.1
 */