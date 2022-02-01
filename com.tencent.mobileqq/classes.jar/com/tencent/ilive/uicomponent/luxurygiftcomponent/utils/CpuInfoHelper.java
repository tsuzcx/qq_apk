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
    Object localObject1 = new String[7];
    Object localObject2 = new File("/proc/stat");
    Object localObject3 = localObject1;
    Object localObject5;
    if (((File)localObject2).exists())
    {
      if (!((File)localObject2).canRead()) {
        return localObject1;
      }
      String str = null;
      localObject3 = null;
      try
      {
        localObject2 = new BufferedReader(new FileReader((File)localObject2), 8192);
        try
        {
          str = ((BufferedReader)localObject2).readLine();
          localObject3 = localObject1;
          if (str != null) {
            localObject3 = str.split(" ");
          }
          localObject1 = localObject3;
        }
        catch (IOException localIOException2) {}catch (FileNotFoundException localFileNotFoundException1) {}
        Object localObject4;
        localFileNotFoundException2.printStackTrace();
      }
      catch (IOException localIOException3)
      {
        localObject2 = localFileNotFoundException1;
        localObject4 = localIOException3;
        localObject4.printStackTrace();
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        localObject2 = localIOException3;
      }
      localObject5 = localObject1;
      if (localObject2 != null) {
        try
        {
          ((BufferedReader)localObject2).close();
          return localObject1;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          localObject5 = localObject1;
        }
      }
    }
    return localObject5;
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
  
  public static String[] getProcessCpuAction(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/proc/");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("/stat");
    localObject1 = ((StringBuilder)localObject1).toString();
    String[] arrayOfString = new String[5];
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).canRead()) {
        return arrayOfString;
      }
      try
      {
        localObject1 = new BufferedReader(new FileReader((File)localObject1), 8192);
        try
        {
          String str = ((BufferedReader)localObject1).readLine();
          Object localObject2 = localObject1;
          if (str == null) {
            break label155;
          }
          localObject2 = str.split(" ");
          arrayOfString[0] = localObject2[1];
          arrayOfString[1] = localObject2[13];
          arrayOfString[2] = localObject2[14];
          arrayOfString[3] = localObject2[15];
          arrayOfString[4] = localObject2[16];
          localObject2 = localObject1;
        }
        catch (IOException localIOException2) {}
        localIOException3.printStackTrace();
      }
      catch (IOException localIOException3)
      {
        localObject1 = null;
      }
      Object localObject3 = localObject1;
      label155:
      if (localObject3 != null) {
        try
        {
          localObject3.close();
          return arrayOfString;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
    }
    return arrayOfString;
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
    catch (Exception localException)
    {
      label125:
      break label125;
    }
    return null;
  }
  
  public static String[] getTotalGpuUsage()
  {
    String[] arrayOfString = new String[2];
    Object localObject1 = new File("/sys/class/kgsl/kgsl-3d0/gpubusy");
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).canRead()) {
        return null;
      }
      try
      {
        localObject1 = new BufferedReader(new FileReader((File)localObject1), 8192);
        try
        {
          String str = ((BufferedReader)localObject1).readLine();
          Object localObject2 = localObject1;
          if (str == null) {
            break label132;
          }
          localObject2 = str.trim().replaceAll("\\s+", " ").split(" ");
          if (localObject2.length < 2) {
            return null;
          }
          arrayOfString[0] = localObject2[0];
          arrayOfString[1] = localObject2[1];
          localObject2 = localObject1;
        }
        catch (Exception localException1) {}catch (IOException localIOException2) {}
        Object localObject3;
        localIOException3.printStackTrace();
      }
      catch (Exception localException2)
      {
        localObject1 = null;
        localException2.printStackTrace();
        localObject3 = localObject1;
      }
      catch (IOException localIOException3)
      {
        localObject1 = null;
      }
      Object localObject4 = localObject1;
      label132:
      if (localObject4 != null) {
        try
        {
          localObject4.close();
          return arrayOfString;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
      return arrayOfString;
    }
    return null;
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
    long l1 = System.currentTimeMillis();
    long l2 = this.lastCpuRateTime;
    if (l2 == 0L)
    {
      this.lastCpuRateTime = l1;
    }
    else
    {
      if (l1 < l2 + 2000L) {
        return this.cpuRateResult;
      }
      this.lastCpuRateTime = (l2 + 2000L);
    }
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
      this.cpuProcessInfo.utime = Double.parseDouble(arrayOfString[1]);
      this.cpuProcessInfo.stime = Double.parseDouble(arrayOfString[2]);
      this.cpuProcessInfo.cutime = Double.parseDouble(arrayOfString[3]);
      this.cpuProcessInfo.cstime = Double.parseDouble(arrayOfString[4]);
      int i = (int)(this.cpuSystemInfo.utime + this.cpuSystemInfo.stime + this.cpuSystemInfo.itime + this.cpuSystemInfo.ntime + this.cpuSystemInfo.iowait_time + this.cpuSystemInfo.irq_time + this.cpuSystemInfo.softirq_time + this.cpuSystemInfo.stealstolen_time + this.cpuSystemInfo.guest_time - (this.lastCpuSystemInfo.utime + this.lastCpuSystemInfo.stime + this.lastCpuSystemInfo.itime + this.lastCpuSystemInfo.ntime + this.lastCpuSystemInfo.iowait_time + this.lastCpuSystemInfo.irq_time + this.lastCpuSystemInfo.softirq_time + this.lastCpuSystemInfo.stealstolen_time + this.lastCpuSystemInfo.guest_time));
      paramInt = i;
      if (i == 0) {
        paramInt = 1;
      }
      double d1 = this.cpuSystemInfo.itime;
      double d3 = this.lastCpuSystemInfo.itime;
      double d2 = this.cpuProcessInfo.utime;
      double d5 = this.cpuProcessInfo.stime;
      double d6 = this.cpuProcessInfo.cutime;
      double d7 = this.cpuProcessInfo.cstime;
      double d8 = this.lastCpuProcessInfo.utime;
      double d9 = this.lastCpuProcessInfo.stime;
      double d10 = this.lastCpuProcessInfo.cutime;
      double d11 = this.lastCpuProcessInfo.cstime;
      double d4 = paramInt;
      Double.isNaN(d4);
      d2 = (d2 + d5 + d6 + d7 - (d8 + d9 + d10 + d11)) / d4;
      Double.isNaN(d4);
      Double.isNaN(d4);
      d3 = (d4 - (d1 - d3)) / d4;
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
    catch (Exception localException) {}
    return null;
  }
  
  public double getCpuUsagebyPid(int paramInt)
  {
    double d2 = 0.0D;
    double d1 = d2;
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
      double d3 = this.aCpu;
      double d4 = this.o_aCpu;
      d1 = d2;
      if (d3 - d4 != 0.0D)
      {
        d1 = div((this.pCpu - this.o_pCpu) * 100.0D, d3 - d4, 2);
        if (d1 < 0.0D) {
          d1 = d2;
        } else if (d1 > 100.0D) {
          d1 = 100.0D;
        }
      }
      this.o_pCpu = this.pCpu;
      this.o_aCpu = this.aCpu;
    }
    this.p_jif = this.pCpu;
    return d1;
  }
  
  public double getGpuUsage()
  {
    String[] arrayOfString = getTotalGpuUsage();
    if ((arrayOfString != null) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
      return div(Double.parseDouble(arrayOfString[0]) * 100.0D, Double.parseDouble(arrayOfString[1]), 2);
    }
    return 0.0D;
  }
  
  public long getJif()
  {
    return this.p_jif;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.utils.CpuInfoHelper
 * JD-Core Version:    0.7.0.1
 */