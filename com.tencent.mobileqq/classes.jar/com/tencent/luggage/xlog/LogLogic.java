package com.tencent.luggage.xlog;

import android.os.Debug;
import android.os.Process;

public class LogLogic
{
  public static String appendMemLog(String paramString)
  {
    return paramString;
  }
  
  /* Error */
  public static String convertStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 15	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: new 18	java/io/BufferedReader
    //   13: dup
    //   14: new 20	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 23	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 26	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 30	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +19 -> 51
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: bipush 10
    //   44: invokevirtual 37	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: goto -22 -> 26
    //   51: aload_0
    //   52: invokevirtual 40	java/io/BufferedReader:close	()V
    //   55: aload_1
    //   56: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: areturn
    //   60: astore_1
    //   61: goto +6 -> 67
    //   64: astore_1
    //   65: aload_2
    //   66: astore_0
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 40	java/io/BufferedReader:close	()V
    //   75: goto +5 -> 80
    //   78: aload_1
    //   79: athrow
    //   80: goto -2 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramInputStream	java.io.InputStream
    //   7	49	1	localStringBuilder	StringBuilder
    //   60	1	1	localObject1	Object
    //   64	15	1	localObject2	Object
    //   9	57	2	str	String
    // Exception table:
    //   from	to	target	type
    //   26	31	60	finally
    //   35	48	60	finally
    //   10	26	64	finally
  }
  
  public static native int getAppenderModeFromCfg();
  
  public static long getDalvikHeap()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1024L;
  }
  
  public static native int getIPxxLogLevel();
  
  public static native int getLogLevelFromCfg();
  
  public static long getNativeHeap()
  {
    return Debug.getNativeHeapAllocatedSize() / 1024L;
  }
  
  public static String getStringFromFile(String paramString)
  {
    return "";
  }
  
  public static String getVmSize()
  {
    int j = Process.myPid();
    int i = 0;
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(j) });
    try
    {
      localObject = getStringFromFile((String)localObject).trim().split("\n");
      j = localObject.length;
      if (i < j)
      {
        String str = localObject[i];
        if (str.startsWith("VmSize")) {
          return str;
        }
      }
      else
      {
        localObject = localObject[12];
        return localObject;
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        i += 1;
      }
    }
  }
  
  public static String getVmStatus()
  {
    String str = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(getStringFromFile(str).trim());
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      label44:
      break label44;
    }
    return localStringBuilder.toString();
  }
  
  public static native void initIPxxLogInfo();
  
  public static native void setIPxxLogML(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xlog.LogLogic
 * JD-Core Version:    0.7.0.1
 */