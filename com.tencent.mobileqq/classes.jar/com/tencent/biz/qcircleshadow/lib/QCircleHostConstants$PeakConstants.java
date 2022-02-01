package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleHostConstants$PeakConstants
{
  public static String TIMESTAMP_LAST_ACTIVITY()
  {
    return ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).TIMESTAMP_LAST_ACTIVITY();
  }
  
  public static String TIME_STAMP()
  {
    return ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).TIMESTAMP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.PeakConstants
 * JD-Core Version:    0.7.0.1
 */