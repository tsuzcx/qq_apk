package com.tencent.biz.qqcircle.utils;

import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleABTestApiImpl;

public class QCircleABTestUtils
{
  private static QCircleABTestApiImpl a()
  {
    return new QCircleABTestApiImpl();
  }
  
  public static boolean a(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.isExperiment()) {
      return true;
    }
    if (paramString.isContrast()) {}
    return false;
  }
  
  public static void b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return;
    }
    paramString.reportExpExposure();
  }
  
  private static IQCircleABTestApi c(String paramString)
  {
    return a().loadExperiment(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleABTestUtils
 * JD-Core Version:    0.7.0.1
 */