package com.tencent.av.abtest;

import com.tencent.av.abtest.api.IQavABTestApi;
import com.tencent.mobileqq.qroute.QRoute;

public final class QavABTestUtils
{
  public static boolean a(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.isExperiment()) {
      return false;
    }
    return paramString.isContrast();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1);
    return (paramString1 != null) && (paramString1.isExpHit(paramString2));
  }
  
  public static void b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return;
    }
    paramString.reportExpExposure();
  }
  
  private static IQavABTestApi c(String paramString)
  {
    return ((IQavABTestApi)QRoute.api(IQavABTestApi.class)).loadExperiment(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.QavABTestUtils
 * JD-Core Version:    0.7.0.1
 */