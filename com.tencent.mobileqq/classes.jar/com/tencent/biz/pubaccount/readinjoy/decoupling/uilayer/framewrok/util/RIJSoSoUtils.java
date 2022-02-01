package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class RIJSoSoUtils
{
  private static long jdField_a_of_type_Long = 300000L;
  private static SosoLbsInfo jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
  private static long b = 0L;
  
  public static SosoLbsInfo a()
  {
    long l = System.currentTimeMillis();
    if (l - b > jdField_a_of_type_Long)
    {
      jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
      b = l;
    }
    return jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSoSoUtils
 * JD-Core Version:    0.7.0.1
 */