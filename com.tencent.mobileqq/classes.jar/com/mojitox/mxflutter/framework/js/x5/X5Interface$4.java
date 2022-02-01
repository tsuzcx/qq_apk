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
    MxLog.b("X5Interface", "mxJSBridgeMethodChannelInvokeMethod notImplemented");
  }
  
  public void success(@Nullable Object paramObject)
  {
    if (paramObject == null)
    {
      X5Interface.a(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5X5Interface).a(this.jdField_a_of_type_ComTencentSmttSdkJsValue, null, false);
      return;
    }
    if ((paramObject instanceof Map))
    {
      X5Interface.a(this.jdField_a_of_type_ComMojitoxMxflutterFrameworkJsX5X5Interface).a(this.jdField_a_of_type_ComTencentSmttSdkJsValue, (Map)paramObject);
      return;
    }
    throw new IllegalArgumentException("MethodChannel.Result Must be return Map object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Interface.4
 * JD-Core Version:    0.7.0.1
 */