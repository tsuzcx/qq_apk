package com.tencent.logcat;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogcatUtil$LogcatThread
  extends Thread
{
  Process a;
  Process b;
  
  public void run()
  {
    try
    {
      Object localObject1 = new SimpleDateFormat("MM-dd-HH").format(new Date());
      Object localObject2 = new File(LogcatUtil.a());
      if (!((File)localObject2).exists())
      {
        ((File)localObject2).mkdirs();
      }
      else
      {
        localObject3 = ((File)localObject2).listFiles();
        if (localObject3 != null)
        {
          int j = localObject3.length;
          int i = 0;
          while (i < j)
          {
            localObject3[i].delete();
            i += 1;
          }
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".log");
      localObject1 = new File((File)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logcat path :");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      QLog.d("LogcatUtil", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add("logcat");
      ((ArrayList)localObject2).add("-f");
      ((ArrayList)localObject2).add(((File)localObject1).getAbsolutePath());
      ((ArrayList)localObject2).add("-v");
      ((ArrayList)localObject2).add("threadtime");
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add("logcat");
      ((ArrayList)localObject1).add("-c");
      this.b = Runtime.getRuntime().exec((String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]));
      this.b.waitFor();
      this.a = Runtime.getRuntime().exec((String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]));
      this.a.waitFor();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil.LogcatThread
 * JD-Core Version:    0.7.0.1
 */