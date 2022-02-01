package com.tencent.gdtad.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;

public class GdtOriginalExposureReporter
{
  public static String a(String paramString1, int paramInt, Context paramContext, String paramString2)
  {
    return a(paramString1, paramInt, PackageUtil.a(paramContext, paramString2));
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, a(a(paramInt), paramBoolean), "1", "0");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString1.replace("__ACTION_TYPE__", paramString2).replace("__VIEW_PERCENT__", paramString3).replace("__VIEW_TIME__", paramString4);
    }
    return str;
  }
  
  private static String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return "2";
      }
      return "1";
    }
    return "0";
  }
  
  public static void a(GdtAd paramGdtAd, Context paramContext)
  {
    a(paramGdtAd, paramContext, -1);
  }
  
  public static void a(GdtAd paramGdtAd, Context paramContext, int paramInt)
  {
    if ((paramGdtAd != null) && (paramContext != null))
    {
      String str = paramGdtAd.getOriginalExposureUrl();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("GdtOriginalExposureReporter", 1, "original exposure url is empty");
        return;
      }
      boolean bool = PackageUtil.a(paramContext, paramGdtAd.getAppPackageName());
      paramContext = a(str, a(paramGdtAd.isAppProductType(), bool), "1", "0");
      paramGdtAd = paramContext;
      if (paramInt >= 0)
      {
        paramGdtAd = new StringBuilder();
        paramGdtAd.append(paramContext);
        paramGdtAd.append("&slot=");
        paramGdtAd.append(paramInt);
        paramGdtAd = paramGdtAd.toString();
      }
      GdtReporter.doCgiReport(paramGdtAd);
      paramContext = new StringBuilder();
      paramContext.append("original exposure report url: ");
      paramContext.append(paramGdtAd);
      QLog.d("GdtOriginalExposureReporter", 1, paramContext.toString());
      return;
    }
    QLog.e("GdtOriginalExposureReporter", 1, "gdtAd or context is null");
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtOriginalExposureReporter
 * JD-Core Version:    0.7.0.1
 */