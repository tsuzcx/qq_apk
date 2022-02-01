package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FileUtil
{
  public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
  public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
  public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240L;
  private static boolean a = false;
  private static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
  
  public static boolean verifyHash(String paramString, File paramFile)
  {
    paramFile = SHA256.digest(paramFile);
    return (paramFile != null) && (HEX.encodeHexString(paramFile, true).equalsIgnoreCase(paramString));
  }
  
  public static void writeFile(File paramFile, String paramString, long paramLong)
  {
    b.execute(new FileUtil.1(paramFile, paramLong, paramString));
  }
  
  public static void writeFileReport(Context paramContext, File paramFile1, File paramFile2, String paramString, long paramLong, int paramInt)
  {
    if ((paramFile1 != null) && (paramFile1.isFile()) && (paramFile1.exists()))
    {
      if (!a)
      {
        if ((paramFile2 != null) && (paramFile2.exists()) && (!paramFile2.delete())) {
          HMSLog.e("FileUtil", "file delete failed.");
        }
        a = true;
      }
      writeFile(paramFile2, paramString + "|" + paramLong + "|" + paramInt, 10240L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */