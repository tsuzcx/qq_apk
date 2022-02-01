package com.idlefish.flutterboost;

import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class FlutterBoostPlugin$BoostMethodHandler$1
  implements FlutterViewContainerManager.OnResult
{
  FlutterBoostPlugin$BoostMethodHandler$1(FlutterBoostPlugin.BoostMethodHandler paramBoostMethodHandler, MethodChannel.Result paramResult) {}
  
  public void onResult(Map<String, Object> paramMap)
  {
    if (this.val$result != null) {
      this.val$result.success(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler.1
 * JD-Core Version:    0.7.0.1
 */