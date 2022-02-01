package com.mojitox.mxflutter.framework.js;

import com.mojitox.mxflutter.framework.executor.JsTask;
import com.mojitox.mxflutter.framework.utils.FileUtils;

class BaseJsExecutor$3
  extends JsTask
{
  public void a()
  {
    try
    {
      Object localObject = FileUtils.d(this.c);
      localObject = this.this$0.a(this.b, (String)localObject);
      BaseJsExecutor.a(this.this$0, this.a, localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      BaseJsExecutor.a(this.this$0, this.a, new Error("load bundle js failed", localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsExecutor.3
 * JD-Core Version:    0.7.0.1
 */