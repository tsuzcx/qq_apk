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
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      for (;;)
      {
        localObject2 = new File((File)localObject2, (String)localObject1 + ".log");
        QLog.d("LogcatUtil", 1, "logcat path :" + ((File)localObject2).getAbsolutePath());
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add("logcat");
        ((ArrayList)localObject1).add("-f");
        ((ArrayList)localObject1).add(((File)localObject2).getAbsolutePath());
        ((ArrayList)localObject1).add("-v");
        ((ArrayList)localObject1).add("threadtime");
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add("logcat");
        ((ArrayList)localObject2).add("-c");
        this.b = Runtime.getRuntime().exec((String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]));
        this.b.waitFor();
        this.a = Runtime.getRuntime().exec((String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]));
        this.a.waitFor();
        return;
        File[] arrayOfFile = ((File)localObject2).listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil.LogcatThread
 * JD-Core Version:    0.7.0.1
 */