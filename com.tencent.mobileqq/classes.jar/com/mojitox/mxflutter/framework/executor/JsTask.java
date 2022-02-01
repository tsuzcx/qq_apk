package com.mojitox.mxflutter.framework.executor;

import android.os.Process;
import com.mojitox.mxflutter.framework.utils.MxLog;

public abstract class JsTask
  implements Runnable
{
  private long a;
  private String b;
  
  private void c() {}
  
  public JsTask a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  protected abstract void a();
  
  public String b()
  {
    return this.b;
  }
  
  public void run()
  {
    try
    {
      Process.setThreadPriority(0);
      long l = System.currentTimeMillis();
      a();
      this.a = (System.currentTimeMillis() - l);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:JSMessage:");
      localStringBuilder.append(localThrowable.getMessage());
      localStringBuilder.append("__taskName:");
      localStringBuilder.append(this.b);
      MxLog.b("MXJsTask", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.JsTask
 * JD-Core Version:    0.7.0.1
 */