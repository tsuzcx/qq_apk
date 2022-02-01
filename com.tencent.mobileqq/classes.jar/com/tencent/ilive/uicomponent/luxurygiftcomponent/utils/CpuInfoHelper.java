package com.tencent.ilive.uicomponent.luxurygiftcomponent.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public class CpuInfoHelper
{
  private double aCpu = 0.0D;
  private CpuInfoHelper.CpuProcessInfo cpuProcessInfo;
  private String[] cpuRateResult = new String[2];
  private CpuInfoHelper.CpuSystemInfo cpuSystemInfo;
  private DecimalFormat df = new DecimalFormat("#.00%");
  private CpuInfoHelper.CpuProcessInfo lastCpuProcessInfo;
  private long lastCpuRateTime = 0L;
  private CpuInfoHelper.CpuSystemInfo lastCpuSystemInfo;
  private double o_aCpu = 0.0D;
  private double o_pCpu = 0.0D;
  private double pCpu = 0.0D;
  private double p_jif = 0.0D;
  
  public CpuInfoHelper()
  {
    initCpuData();
  }
  
  public static double div(double paramDouble1, double paramDouble2, int paramInt)
  {
    BigDecimal localBigDecimal1 = new BigDecimal(Double.toString(paramDouble1));
    BigDecimal localBigDecimal2 = new BigDecimal(Double.toString(paramDouble2));
    try
    {
      paramDouble1 = localBigDecimal1.divide(localBigDecimal2, paramInt, 1).doubleValue();
      return paramDouble1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0.0D;
  }
  
  public static String[] getCpuAction()
  {
    String[] arrayOfString2 = new String[7];
    Object localObject4 = new File("/proc/stat");
    Object localObject1 = arrayOfString2;
    if (((File)localObject4).exists())
    {
      if (((File)localObject4).canRead()) {
        break label36;
      }
      localObject1 = arrayOfString2;
    }
    for (;;)
    {
      return localObject1;
      label36:
      String[] arrayOfString1 = null;
      try
      {
        localObject1 = new BufferedReader(new FileReader((File)localObject4), 8192);
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          try
          {
            String str = ((BufferedReader)localObject1).readLine();
            arrayOfString1 = arrayOfString2;
            localObject4 = localObject1;
            if (str != null)
            {
              arrayOfString1 = str.split(" ");
              localObject4 = localObject1;
            }
            localObject1 = arrayOfString1;
            if (localObject4 == null) {
              break;
            }
            try
            {
              ((BufferedReader)localObject4).close();
              return arrayOfString1;
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
              return arrayOfString1;
            }
            localFileNotFoundException1 = localFileNotFoundException1;
            localObject2 = null;
          }
          catch (IOException localIOException2)
          {
            Object localObject2;
            Object localObject3;
            Object localObject5;
            continue;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            continue;
          }
          localFileNotFoundException1.printStackTrace();
          localObject3 = arrayOfString2;
          localObject4 = localObject2;
        }
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localObject2 = localObject3;
          localObject3 = localIOException3;
          ((IOException)localObject3).printStackTrace();
          localObject3 = arrayOfString2;
          localObject5 = localObject2;
        }
      }
    }
  }
  
  public static int getPid(Context paramContext, String paramString)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.trim().equals(paramString)) {
        return localRunningAppProcessInfo.pid;
      }
    }
    return 0;
  }
  
  /* Error */
  public static String[] getProcessCpuAction(int paramInt)
  {
    // Byte code:
    //   0: new 174	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   7: ldc 177
    //   9: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: iload_0
    //   13: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc 186
    //   18: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_1
    //   25: iconst_5
    //   26: anewarray 38	java/lang/String
    //   29: astore_3
    //   30: new 87	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 94	java/io/File:exists	()Z
    //   43: ifeq +10 -> 53
    //   46: aload_1
    //   47: invokevirtual 97	java/io/File:canRead	()Z
    //   50: ifne +5 -> 55
    //   53: aload_3
    //   54: areturn
    //   55: new 99	java/io/BufferedReader
    //   58: dup
    //   59: new 101	java/io/FileReader
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 104	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   67: sipush 8192
    //   70: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 111	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore 4
    //   80: aload_1
    //   81: astore_2
    //   82: aload 4
    //   84: ifnull +47 -> 131
    //   87: aload 4
    //   89: ldc 113
    //   91: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   94: astore_2
    //   95: aload_3
    //   96: iconst_0
    //   97: aload_2
    //   98: iconst_1
    //   99: aaload
    //   100: aastore
    //   101: aload_3
    //   102: iconst_1
    //   103: aload_2
    //   104: bipush 13
    //   106: aaload
    //   107: aastore
    //   108: aload_3
    //   109: iconst_2
    //   110: aload_2
    //   111: bipush 14
    //   113: aaload
    //   114: aastore
    //   115: aload_3
    //   116: iconst_3
    //   117: aload_2
    //   118: bipush 15
    //   120: aaload
    //   121: aastore
    //   122: aload_3
    //   123: iconst_4
    //   124: aload_2
    //   125: bipush 16
    //   127: aaload
    //   128: aastore
    //   129: aload_1
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull -79 -> 53
    //   135: aload_2
    //   136: invokevirtual 120	java/io/BufferedReader:close	()V
    //   139: aload_3
    //   140: areturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   146: aload_3
    //   147: areturn
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_2
    //   152: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   155: aload_1
    //   156: astore_2
    //   157: goto -26 -> 131
    //   160: astore_2
    //   161: goto -10 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInt	int
    //   24	106	1	localObject1	Object
    //   141	2	1	localIOException1	IOException
    //   150	6	1	localObject2	Object
    //   81	55	2	localObject3	Object
    //   148	4	2	localIOException2	IOException
    //   156	1	2	localObject4	Object
    //   160	1	2	localIOException3	IOException
    //   29	118	3	arrayOfString	String[]
    //   78	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   135	139	141	java/io/IOException
    //   55	74	148	java/io/IOException
    //   74	80	160	java/io/IOException
    //   87	95	160	java/io/IOException
  }
  
  public static double[] getSystemCpuTime()
  {
    String[] arrayOfString = getCpuAction();
    try
    {
      double d1 = Double.parseDouble(arrayOfString[2]);
      double d2 = Double.parseDouble(arrayOfString[3]);
      double d3 = Double.parseDouble(arrayOfString[4]);
      double d4 = Double.parseDouble(arrayOfString[5]);
      double d5 = Double.parseDouble(arrayOfString[6]);
      double d6 = Double.parseDouble(arrayOfString[7]);
      double d7 = Double.parseDouble(arrayOfString[8]);
      double d8 = Double.parseDouble(arrayOfString[9]);
      double d9 = Double.parseDouble(arrayOfString[10]);
      return new double[] { d4, d1 + d3 + d4 + d2 + d5 + d6 + d7 + d8 + d9 };
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  public static String[] getTotalGpuUsage()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 38	java/lang/String
    //   4: astore_2
    //   5: new 87	java/io/File
    //   8: dup
    //   9: ldc 199
    //   11: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 94	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 97	java/io/File:canRead	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: new 99	java/io/BufferedReader
    //   34: dup
    //   35: new 101	java/io/FileReader
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 104	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   43: sipush 8192
    //   46: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 111	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_0
    //   56: astore_1
    //   57: aload_3
    //   58: ifnull +40 -> 98
    //   61: aload_3
    //   62: invokevirtual 162	java/lang/String:trim	()Ljava/lang/String;
    //   65: ldc 201
    //   67: ldc 113
    //   69: invokevirtual 205	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: ldc 113
    //   74: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   77: astore_1
    //   78: aload_1
    //   79: arraylength
    //   80: iconst_2
    //   81: if_icmplt -52 -> 29
    //   84: aload_2
    //   85: iconst_0
    //   86: aload_1
    //   87: iconst_0
    //   88: aaload
    //   89: aastore
    //   90: aload_2
    //   91: iconst_1
    //   92: aload_1
    //   93: iconst_1
    //   94: aaload
    //   95: aastore
    //   96: aload_0
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 120	java/io/BufferedReader:close	()V
    //   106: aload_2
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_1
    //   112: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   115: aload_0
    //   116: astore_1
    //   117: goto -19 -> 98
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_1
    //   124: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: astore_1
    //   129: goto -31 -> 98
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   137: goto -31 -> 106
    //   140: astore_1
    //   141: goto -18 -> 123
    //   144: astore_1
    //   145: goto -34 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	114	0	localObject1	Object
    //   132	2	0	localIOException1	IOException
    //   56	47	1	localObject2	Object
    //   108	4	1	localIOException2	IOException
    //   116	1	1	localObject3	Object
    //   120	4	1	localException1	Exception
    //   128	1	1	localObject4	Object
    //   140	1	1	localException2	Exception
    //   144	1	1	localIOException3	IOException
    //   4	103	2	arrayOfString	String[]
    //   54	8	3	str	String
    // Exception table:
    //   from	to	target	type
    //   31	50	108	java/io/IOException
    //   31	50	120	java/lang/Exception
    //   102	106	132	java/io/IOException
    //   50	55	140	java/lang/Exception
    //   61	84	140	java/lang/Exception
    //   50	55	144	java/io/IOException
    //   61	84	144	java/io/IOException
  }
  
  private void initCpuData()
  {
    this.o_pCpu = 0.0D;
    this.pCpu = 0.0D;
    this.o_aCpu = 0.0D;
    this.aCpu = 0.0D;
    this.cpuSystemInfo = new CpuInfoHelper.CpuSystemInfo(this);
    this.lastCpuSystemInfo = new CpuInfoHelper.CpuSystemInfo(this);
    this.cpuProcessInfo = new CpuInfoHelper.CpuProcessInfo(this);
    this.lastCpuProcessInfo = new CpuInfoHelper.CpuProcessInfo(this);
  }
  
  public String[] getCpuRateLikeNative(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.lastCpuRateTime == 0L) {}
    for (this.lastCpuRateTime = l;; this.lastCpuRateTime += 2000L)
    {
      String[] arrayOfString = getCpuAction();
      try
      {
        this.cpuSystemInfo.utime = Double.parseDouble(arrayOfString[2]);
        this.cpuSystemInfo.ntime = Double.parseDouble(arrayOfString[3]);
        this.cpuSystemInfo.stime = Double.parseDouble(arrayOfString[4]);
        this.cpuSystemInfo.itime = Double.parseDouble(arrayOfString[5]);
        this.cpuSystemInfo.iowait_time = Double.parseDouble(arrayOfString[6]);
        this.cpuSystemInfo.irq_time = Double.parseDouble(arrayOfString[7]);
        this.cpuSystemInfo.softirq_time = Double.parseDouble(arrayOfString[8]);
        this.cpuSystemInfo.stealstolen_time = Double.parseDouble(arrayOfString[9]);
        this.cpuSystemInfo.guest_time = Double.parseDouble(arrayOfString[10]);
        arrayOfString = getProcessCpuAction(paramInt);
      }
      catch (Exception localException1)
      {
        int i;
        double d1;
        double d3;
        double d2;
        return null;
      }
      try
      {
        this.cpuProcessInfo.utime = Double.parseDouble(arrayOfString[1]);
        this.cpuProcessInfo.stime = Double.parseDouble(arrayOfString[2]);
        this.cpuProcessInfo.cutime = Double.parseDouble(arrayOfString[3]);
        this.cpuProcessInfo.cstime = Double.parseDouble(arrayOfString[4]);
        i = (int)(this.cpuSystemInfo.utime + this.cpuSystemInfo.stime + this.cpuSystemInfo.itime + this.cpuSystemInfo.ntime + this.cpuSystemInfo.iowait_time + this.cpuSystemInfo.irq_time + this.cpuSystemInfo.softirq_time + this.cpuSystemInfo.stealstolen_time + this.cpuSystemInfo.guest_time - (this.lastCpuSystemInfo.utime + this.lastCpuSystemInfo.stime + this.lastCpuSystemInfo.itime + this.lastCpuSystemInfo.ntime + this.lastCpuSystemInfo.iowait_time + this.lastCpuSystemInfo.irq_time + this.lastCpuSystemInfo.softirq_time + this.lastCpuSystemInfo.stealstolen_time + this.lastCpuSystemInfo.guest_time));
        paramInt = i;
        if (i == 0) {
          paramInt = 1;
        }
        d1 = this.cpuSystemInfo.itime;
        d3 = this.lastCpuSystemInfo.itime;
        d2 = (this.cpuProcessInfo.utime + this.cpuProcessInfo.stime + this.cpuProcessInfo.cutime + this.cpuProcessInfo.cstime - (this.lastCpuProcessInfo.utime + this.lastCpuProcessInfo.stime + this.lastCpuProcessInfo.cutime + this.lastCpuProcessInfo.cstime)) / paramInt;
        d3 = (paramInt - (d1 - d3)) / paramInt;
        d1 = d2;
        if (d2 < 0.0D) {
          d1 = 1.0D;
        }
        d2 = d1;
        if (d1 > 100.0D) {
          d2 = 100.0D;
        }
        d1 = d3;
        if (d3 < 0.0D) {
          d1 = 1.0D;
        }
        d3 = d1;
        if (d1 > 100.0D) {
          d3 = 100.0D;
        }
        this.lastCpuSystemInfo.utime = this.cpuSystemInfo.utime;
        this.lastCpuSystemInfo.ntime = this.cpuSystemInfo.ntime;
        this.lastCpuSystemInfo.stime = this.cpuSystemInfo.stime;
        this.lastCpuSystemInfo.itime = this.cpuSystemInfo.itime;
        this.lastCpuSystemInfo.iowait_time = this.cpuSystemInfo.iowait_time;
        this.lastCpuSystemInfo.irq_time = this.cpuSystemInfo.irq_time;
        this.lastCpuSystemInfo.softirq_time = this.cpuSystemInfo.softirq_time;
        this.lastCpuSystemInfo.stealstolen_time = this.cpuSystemInfo.stealstolen_time;
        this.lastCpuSystemInfo.guest_time = this.cpuSystemInfo.guest_time;
        this.lastCpuProcessInfo.utime = this.cpuProcessInfo.utime;
        this.lastCpuProcessInfo.stime = this.cpuProcessInfo.stime;
        this.lastCpuProcessInfo.cutime = this.cpuProcessInfo.cutime;
        this.lastCpuProcessInfo.cstime = this.cpuProcessInfo.cstime;
        this.cpuRateResult = new String[] { this.df.format(d2), this.df.format(d3) };
        return this.cpuRateResult;
      }
      catch (Exception localException2) {}
      if (l < this.lastCpuRateTime + 2000L) {
        return this.cpuRateResult;
      }
    }
    return null;
  }
  
  public double getCpuUsagebyPid(int paramInt)
  {
    double d2;
    double d1;
    if (paramInt >= 0)
    {
      String[] arrayOfString = getProcessCpuAction(paramInt);
      if ((arrayOfString != null) && (arrayOfString[1] != null) && (arrayOfString[2] != null)) {
        this.pCpu = (Double.parseDouble(arrayOfString[1]) + Double.parseDouble(arrayOfString[2]));
      }
      arrayOfString = getCpuAction();
      if (arrayOfString != null)
      {
        this.aCpu = 0.0D;
        paramInt = 2;
        while (paramInt < arrayOfString.length)
        {
          if (arrayOfString[paramInt] != null) {
            this.aCpu += Double.parseDouble(arrayOfString[paramInt]);
          }
          paramInt += 1;
        }
      }
      if (this.aCpu - this.o_aCpu != 0.0D)
      {
        d2 = div((this.pCpu - this.o_pCpu) * 100.0D, this.aCpu - this.o_aCpu, 2);
        if (d2 < 0.0D)
        {
          d1 = 0.0D;
          this.o_pCpu = this.pCpu;
          this.o_aCpu = this.aCpu;
        }
      }
    }
    for (;;)
    {
      this.p_jif = this.pCpu;
      return d1;
      d1 = d2;
      if (d2 <= 100.0D) {
        break;
      }
      d1 = 100.0D;
      break;
      d1 = 0.0D;
      break;
      d1 = 0.0D;
    }
  }
  
  public double getGpuUsage()
  {
    double d2 = 0.0D;
    String[] arrayOfString = getTotalGpuUsage();
    double d1 = d2;
    if (arrayOfString != null)
    {
      d1 = d2;
      if (arrayOfString[0] != null)
      {
        d1 = d2;
        if (arrayOfString[1] != null) {
          d1 = div(Double.parseDouble(arrayOfString[0]) * 100.0D, Double.parseDouble(arrayOfString[1]), 2);
        }
      }
    }
    return d1;
  }
  
  public long getJif()
  {
    return this.p_jif;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.utils.CpuInfoHelper
 * JD-Core Version:    0.7.0.1
 */