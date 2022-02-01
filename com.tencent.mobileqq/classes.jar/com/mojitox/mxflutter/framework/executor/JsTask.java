package com.mojitox.mxflutter.framework.executor;

import android.os.Process;
import com.mojitox.mxflutter.framework.utils.MxLog;

public abstract class JsTask
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  private void b() {}
  
  public JsTask a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected abstract void a();
  
  public void run()
  {
    try
    {
      Process.setThreadPriority(0);
      long l = System.currentTimeMillis();
      a();
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:JSMessage:");
      localStringBuilder.append(localThrowable.getMessage());
      localStringBuilder.append("__taskName:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      MxLog.b("MXJsTask", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.JsTask
 * JD-Core Version:    0.7.0.1
 */