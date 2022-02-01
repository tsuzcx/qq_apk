package com.mojitox.mxflutter.framework.ffi;

import androidx.annotation.Keep;
import com.mojitox.mxflutter.framework.constants.JsObjectType;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.js.BaseJsEngine;
import com.mojitox.mxflutter.framework.js.BaseJsExecutor;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import com.mojitox.mxflutter.framework.utils.SafelyLibraryLoader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MxFlutterFfi
{
  private final boolean a = SafelyLibraryLoader.a(JsEngineLoader.a().c(), "mxflutter");
  
  public MxFlutterFfi()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#constructor: isSoLoadSuccess=");
    localStringBuilder.append(this.a);
    MxLog.a("MxFlutterFfi", localStringBuilder.toString());
    if (this.a) {
      init(this);
    }
  }
  
  private native void init(MxFlutterFfi paramMxFlutterFfi);
  
  private native String nativeCallFlutterFunctionSync(String paramString);
  
  private native void release();
  
  public void a()
  {
    if (this.a) {
      release();
    }
  }
  
  @Keep
  public String syncPropsCallback(String paramString)
  {
    if ((this.a) && (JsEngineLoader.a().d().b().a(JsObjectType.CURRENT_APP_OBJECT)))
    {
      Object[] arrayOfObject = new Object[1];
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      UiThread.a(new MxFlutterFfi.1(this, paramString, arrayOfObject, localCountDownLatch));
      try
      {
        localCountDownLatch.await(3L, TimeUnit.SECONDS);
        return arrayOfObject[0].toString();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "syncPropsCallback exception";
      }
    }
    paramString = new StringBuilder();
    paramString.append("call java syncPropsCallback null:");
    paramString.append(this);
    MxLog.a("MxFlutterFfi", paramString.toString());
    return "jsAppObj is null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.ffi.MxFlutterFfi
 * JD-Core Version:    0.7.0.1
 */