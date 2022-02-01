package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import com.mojitox.mxflutter.framework.utils.MxLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;

class X5Executor$1
  extends JsTask
{
  X5Executor$1(X5Executor paramX5Executor) {}
  
  public void a()
  {
    if (!QbSdk.isTbsCoreInited())
    {
      MxLog.b("X5Executor", "start init isTbsCore init");
      WebAccelerator.initTbsEnvironment(JsEngineLoader.a().a(), 2);
    }
    UiThread.a(new X5Executor.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Executor.1
 * JD-Core Version:    0.7.0.1
 */