package com.tencent.biz.webviewplugin;

import aadt;
import bgve;
import com.tencent.qphone.base.util.QLog;

class WebSoPlugin$2$1
  implements Runnable
{
  WebSoPlugin$2$1(WebSoPlugin.2 param2) {}
  
  public void run()
  {
    if ((this.a.this$0.mRuntime != null) && (this.a.this$0.mRuntime.a() != null)) {}
    try
    {
      this.a.this$0.a(this.a.this$0.mRuntime.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebSoPlugin", 1, "asynJudgmentDynamicCover, useSoftwareMode err, ExceptionMsg = " + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */