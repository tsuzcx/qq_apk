package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;

public class HostRouteUtils
{
  public static String decodeRemoteCode(long paramLong)
  {
    return ((IQQBaseService)QRoute.api(IQQBaseService.class)).decodeRemoteCode(paramLong);
  }
  
  public static int encodeLocCode(String paramString)
  {
    return ((IQQBaseService)QRoute.api(IQQBaseService.class)).encodeLocCode(paramString);
  }
  
  public static void openBottomTabSwitchActivity()
  {
    ((IQQBaseService)QRoute.api(IQQBaseService.class)).openBottomTabSwitchActivity();
  }
  
  public static void openLocationSelectActivity(Context paramContext, Bundle paramBundle)
  {
    ((IQQBaseService)QRoute.api(IQQBaseService.class)).openLocationSelectActivity(paramContext, paramBundle);
  }
  
  public static void openTroopInfoActivity(Context paramContext, Bundle paramBundle)
  {
    ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(paramContext, paramBundle, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils
 * JD-Core Version:    0.7.0.1
 */