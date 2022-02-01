package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class X5Interface$4
  implements MethodChannel.Result
{
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    paramString1 = new StringBuilder();
    paramString1.append("mxJSBridgeMethodChannelInvokeMethod:");
    paramString1.append(paramString2);
    MxLog.b("X5Interface", paramString1.toString());
  }
  
  public void notImplemented()
  {
    MxLog.a("X5Interface", "mxJSBridgeMethodChannelInvokeMethod notImplemented");
  }
  
  public void success(@Nullable Object paramObject)
  {
    if (paramObject == null)
    {
      this.a.a.a(this.b, null, false);
      return;
    }
    if ((paramObject instanceof Map))
    {
      this.a.a.a(this.b, (Map)paramObject);
      return;
    }
    throw new IllegalArgumentException("MethodChannel.Result Must be return Map object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Interface.4
 * JD-Core Version:    0.7.0.1
 */