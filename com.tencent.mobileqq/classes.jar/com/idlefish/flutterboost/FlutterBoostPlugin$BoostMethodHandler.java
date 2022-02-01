package com.idlefish.flutterboost;

import android.util.Log;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class FlutterBoostPlugin$BoostMethodHandler
  implements MethodChannel.MethodCallHandler
{
  FlutterBoostPlugin$BoostMethodHandler(FlutterBoostPlugin paramFlutterBoostPlugin) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int i = 1;
    FlutterViewContainerManager localFlutterViewContainerManager = (FlutterViewContainerManager)FlutterBoost.instance().containerManager();
    Object localObject = paramMethodCall.method;
    int j = ((String)localObject).hashCode();
    if (j != -1037220475) {
      if (j != -504772615) {
        if (j != -482608985) {
          if (j != 1791664180) {
            label54:
            i = -1;
          }
        }
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        return;
        if (!((String)localObject).equals("pageOnStart")) {
          break label54;
        }
        i = 0;
        continue;
        if (!((String)localObject).equals("closePage")) {
          break label54;
        }
        i = 2;
        continue;
        if (!((String)localObject).equals("openPage")) {
          break label54;
        }
        continue;
        if (!((String)localObject).equals("onShownContainerChanged")) {
          break label54;
        }
        i = 3;
      }
    }
    try
    {
      localFlutterViewContainerManager.onShownContainerChanged((String)paramMethodCall.argument("newName"), (String)paramMethodCall.argument("oldName"));
      paramResult.success(Boolean.valueOf(true));
      return;
    }
    catch (Throwable paramMethodCall)
    {
      paramResult.error("onShownContainerChanged", paramMethodCall.getMessage(), Log.getStackTraceString(paramMethodCall));
      return;
    }
    try
    {
      localFlutterViewContainerManager.closeContainer((String)paramMethodCall.argument("uniqueId"), (Map)paramMethodCall.argument("result"), (Map)paramMethodCall.argument("exts"));
      paramResult.success(Boolean.valueOf(true));
      return;
    }
    catch (Throwable paramMethodCall)
    {
      paramResult.error("close page error", paramMethodCall.getMessage(), Log.getStackTraceString(paramMethodCall));
      return;
    }
    try
    {
      localObject = (Map)paramMethodCall.argument("urlParams");
      Map localMap = (Map)paramMethodCall.argument("exts");
      localFlutterViewContainerManager.openContainer((String)paramMethodCall.argument("url"), (Map)localObject, localMap, new FlutterBoostPlugin.BoostMethodHandler.1(this, paramResult));
      return;
    }
    catch (Throwable paramMethodCall)
    {
      paramResult.error("open page error", paramMethodCall.getMessage(), Log.getStackTraceString(paramMethodCall));
      return;
    }
    localObject = new HashMap();
    for (;;)
    {
      try
      {
        paramMethodCall = localFlutterViewContainerManager.getCurrentTopRecord();
        if (paramMethodCall == null)
        {
          paramMethodCall = localFlutterViewContainerManager.getLastGenerateRecord();
          if (paramMethodCall != null)
          {
            ((Map)localObject).put("name", paramMethodCall.getContainer().getContainerUrl());
            ((Map)localObject).put("params", paramMethodCall.getContainer().getContainerUrlParams());
            ((Map)localObject).put("uniqueId", paramMethodCall.uniqueId());
          }
          paramResult.success(localObject);
          FlutterBoost.instance().setFlutterPostFrameCallTime(new Date().getTime());
          return;
        }
      }
      catch (Throwable paramMethodCall)
      {
        paramResult.error("no flutter page found!", paramMethodCall.getMessage(), Log.getStackTraceString(paramMethodCall));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoostPlugin.BoostMethodHandler
 * JD-Core Version:    0.7.0.1
 */