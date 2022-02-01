package com.idlefish.flutterboost;

import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel.Result;

class FlutterBoostPlugin$2
  implements MethodChannel.Result
{
  FlutterBoostPlugin$2(FlutterBoostPlugin paramFlutterBoostPlugin, String paramString) {}
  
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("invoke method ");
    paramObject.append(this.val$name);
    paramObject.append(" error:");
    paramObject.append(paramString1);
    paramObject.append(" | ");
    paramObject.append(paramString2);
    Debuger.log(paramObject.toString());
  }
  
  public void notImplemented()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke method ");
    localStringBuilder.append(this.val$name);
    localStringBuilder.append(" notImplemented");
    Debuger.log(localStringBuilder.toString());
  }
  
  public void success(@Nullable Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin.2
 * JD-Core Version:    0.7.0.1
 */