package com.tencent.acstat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

class i
{
  static int a()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new j()).length;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 1;
  }
  
  static int b()
  {
    int j = 0;
    String str = "";
    int i;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(new String(arrayOfByte));
        str = localStringBuilder.toString();
      }
      localInputStream.close();
      str = str.trim();
      i = j;
      if (str.length() > 0) {
        i = Integer.valueOf(str).intValue();
      }
    }
    catch (Exception localException)
    {
      StatCommonHelper.a().e(localException);
      i = j;
    }
    return i * 1000;
  }
  
  static int c()
  {
    int j = 0;
    String str = "";
    int i;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(new String(arrayOfByte));
        str = localStringBuilder.toString();
      }
      localInputStream.close();
      str = str.trim();
      i = j;
      if (str.length() > 0) {
        i = Integer.valueOf(str).intValue();
      }
    }
    catch (Throwable localThrowable)
    {
      StatCommonHelper.a().e(localThrowable);
      i = j;
    }
    return i * 1000;
  }
  
  static String d()
  {
    int i = 2;
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "";
    arrayOfString1[1] = "";
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
      String[] arrayOfString2 = localBufferedReader.readLine().split("\\s+");
      while (i < arrayOfString2.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString1[0]);
        localStringBuilder.append(arrayOfString2[i]);
        localStringBuilder.append(" ");
        arrayOfString1[0] = localStringBuilder.toString();
        i += 1;
      }
      localBufferedReader.close();
    }
    catch (IOException localIOException)
    {
      label107:
      break label107;
    }
    return arrayOfString1[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.i
 * JD-Core Version:    0.7.0.1
 */