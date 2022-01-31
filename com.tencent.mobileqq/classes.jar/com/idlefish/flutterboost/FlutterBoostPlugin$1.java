package com.idlefish.flutterboost;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;
import java.util.Set;

class FlutterBoostPlugin$1
  implements MethodChannel.MethodCallHandler
{
  FlutterBoostPlugin$1(FlutterBoostPlugin paramFlutterBoostPlugin) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int i = 0;
    Object localObject2;
    int j;
    if (paramMethodCall.method.equals("__event__"))
    {
      paramResult = (String)paramMethodCall.argument("name");
      localObject2 = (Map)paramMethodCall.argument("arguments");
      paramMethodCall = null;
      synchronized (FlutterBoostPlugin.access$000(this.this$0))
      {
        Set localSet = (Set)FlutterBoostPlugin.access$000(this.this$0).get(paramResult);
        if (localSet != null) {
          paramMethodCall = localSet.toArray();
        }
        if (paramMethodCall == null) {
          return;
        }
        j = paramMethodCall.length;
        if (i >= j) {
          return;
        }
        ((FlutterBoostPlugin.EventListener)paramMethodCall[i]).onEvent(paramResult, (Map)localObject2);
        i += 1;
      }
    }
    synchronized (FlutterBoostPlugin.access$100(this.this$0))
    {
      localObject2 = FlutterBoostPlugin.access$100(this.this$0).toArray();
      j = localObject2.length;
      i = 0;
      if (i < j)
      {
        ((MethodChannel.MethodCallHandler)localObject2[i]).onMethodCall(paramMethodCall, paramResult);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin.1
 * JD-Core Version:    0.7.0.1
 */