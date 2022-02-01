package com.tencent.comic;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public class PluginPreloadReportUtils
{
  private static final int a = new Random().nextInt(1000) + 1;
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, String... paramVarArgs)
  {
    if ((paramInt1 != 0) && (a > 1)) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt1);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt2);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt3);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt4);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(paramInt5);
    paramString = new String[6];
    paramInt2 = Math.min(6, paramVarArgs.length);
    paramInt1 = 0;
    System.arraycopy(paramVarArgs, 0, paramString, 0, paramInt2);
    while (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null)
      {
        localStringBuilder1.append("|");
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("|");
        paramVarArgs.append(paramString[paramInt1]);
        localStringBuilder1.append(paramVarArgs.toString());
      }
      paramInt1 += 1;
    }
    paramString = null;
    if ((paramAppRuntime instanceof BaseQQAppInterface)) {
      paramString = (BaseQQAppInterface)paramAppRuntime;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("preload: ");
      paramAppRuntime.append(localStringBuilder1.toString());
      QLog.d("PluginPreloadReportUtils", 2, paramAppRuntime.toString());
    }
    DcReportUtil.a(paramString, "sendtdbank|b_sng_qqvip_qqcomic|preload", localStringBuilder1.toString(), true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, String... paramVarArgs)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt1);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt2);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt3);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramInt4);
    localStringBuilder2.append("|");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(paramString);
    paramString = new String[6];
    paramInt2 = Math.min(6, paramVarArgs.length);
    paramInt1 = 0;
    System.arraycopy(paramVarArgs, 0, paramString, 0, paramInt2);
    while (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null)
      {
        localStringBuilder1.append("|");
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("|");
        paramVarArgs.append(paramString[paramInt1]);
        localStringBuilder1.append(paramVarArgs.toString());
      }
      paramInt1 += 1;
    }
    paramString = null;
    if ((paramAppRuntime instanceof BaseQQAppInterface)) {
      paramString = (BaseQQAppInterface)paramAppRuntime;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("hitrate: ");
      paramAppRuntime.append(localStringBuilder1.toString());
      QLog.d("PluginPreloadReportUtils", 2, paramAppRuntime.toString());
    }
    DcReportUtil.a(paramString, "sendtdbank|b_sng_qqvip_qqcomic|preloadhitrate", localStringBuilder1.toString(), true);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("|");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("|");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("|");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(paramLong);
    localObject = new String[6];
    paramInt2 = Math.min(6, paramVarArgs.length);
    paramInt1 = 0;
    System.arraycopy(paramVarArgs, 0, localObject, 0, paramInt2);
    while (paramInt1 < localObject.length)
    {
      if (localObject[paramInt1] == null)
      {
        localStringBuilder.append("|");
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("|");
        paramVarArgs.append(localObject[paramInt1]);
        localStringBuilder.append(paramVarArgs.toString());
      }
      paramInt1 += 1;
    }
    paramVarArgs = null;
    if ((paramAppRuntime instanceof BaseQQAppInterface)) {
      paramVarArgs = (BaseQQAppInterface)paramAppRuntime;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("procbekilled: ");
      paramAppRuntime.append(localStringBuilder.toString());
      QLog.d("PluginPreloadReportUtils", 2, paramAppRuntime.toString());
    }
    DcReportUtil.a(paramVarArgs, "sendtdbank|b_sng_qqvip_qqcomic|procbekilled", localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.PluginPreloadReportUtils
 * JD-Core Version:    0.7.0.1
 */