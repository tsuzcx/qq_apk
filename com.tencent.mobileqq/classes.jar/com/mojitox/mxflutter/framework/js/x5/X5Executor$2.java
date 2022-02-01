package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.framework.utils.MxLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class X5Executor$2
  implements JsContext.ExceptionHandler
{
  X5Executor$2(X5Executor paramX5Executor) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    MxLog.b("X5Executor", paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor.2
 * JD-Core Version:    0.7.0.1
 */