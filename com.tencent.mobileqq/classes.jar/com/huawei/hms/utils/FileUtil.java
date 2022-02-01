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
  public static boolean a = false;
  public static ScheduledExecutorService b = ;
  
  public static boolean verifyHash(String paramString, File paramFile)
  {
    paramFile = SHA256.digest(paramFile);
    return (paramFile != null) && (HEX.encodeHexString(paramFile, true).equalsIgnoreCase(paramString));
  }
  
  public static void writeFile(File paramFile, String paramString, long paramLong)
  {
    b.execute(new FileUtil.a(paramFile, paramLong, paramString));
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
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append("|");
      paramContext.append(paramLong);
      paramContext.append("|");
      paramContext.append(paramInt);
      writeFile(paramFile2, paramContext.toString(), 10240L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */