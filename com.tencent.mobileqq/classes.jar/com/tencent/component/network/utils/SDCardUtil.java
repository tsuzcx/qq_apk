package com.tencent.component.network.utils;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class SDCardUtil
{
  private static final String NO_SDCARD_TIPS = "无SD Card";
  private static final long UNIT = 1048576L;
  private static final String UNIT_NAME = "MB";
  
  private static String calcCapUnit(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
      localStringBuilder.append(countToUnit(paramInt));
      return localStringBuilder.toString();
    }
    return calcCapUnit(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static String calcCapUnit(long paramLong)
  {
    return calcCapUnit(0, (float)paramLong);
  }
  
  private static String countToUnit(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  public static long getSDCardCapability()
  {
    if (!isSDCardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static String getSDCardCapabilityForDisplay()
  {
    long l = getSDCardCapability();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static long getSDCardRemain()
  {
    if (!isSDCardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l1;
    if (Build.VERSION.SDK_INT > 17) {
      l1 = localStatFs.getBlockSizeLong();
    } else {
      l1 = localStatFs.getBlockSize();
    }
    long l2;
    if (Build.VERSION.SDK_INT > 17) {
      l2 = localStatFs.getAvailableBlocksLong();
    } else {
      l2 = localStatFs.getAvailableBlocks();
    }
    return l2 * l1;
  }
  
  public static String getSDCardRemainForDisplay()
  {
    long l = getSDCardRemain();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static String getSDCardState()
  {
    return Environment.getExternalStorageState();
  }
  
  public static boolean isSDCardMounted()
  {
    return getSDCardState().equals("mounted");
  }
  
  public static boolean isSdCardHasEnoughCapability()
  {
    long l = 10485760;
    return getSDCardRemain() > l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.SDCardUtil
 * JD-Core Version:    0.7.0.1
 */