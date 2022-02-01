package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.BasicMessageChannel.Reply;

class X5InterfaceFallback$1
  implements BasicMessageChannel.Reply<String>
{
  public void a(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlutterCommonChannelInvoker_reply:");
    localStringBuilder.append(paramString);
    MxLog.b("X5InterfaceFallback", localStringBuilder.toString());
    X5InterfaceFallback.a(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5X5InterfaceFallback).a(this.jdField_a_of_type_JavaLangString, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceFallback.1
 * JD-Core Version:    0.7.0.1
 */