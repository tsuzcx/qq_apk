package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qzonehub.api.IQZoneJustLocationApi;
import com.tencent.qzonehub.api.IQzoneLbsServiceApi;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;

public class QCircleHostLbsHelper
{
  public static void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList, boolean paramBoolean)
  {
    ((IQzoneLbsServiceApi)QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServer(paramArrayList, paramBoolean);
  }
  
  public static SosoLbsInfo getCachedLbsInfo(String paramString)
  {
    return ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
  }
  
  public static LbsDataV2.GpsInfo getCurrGps(String paramString)
  {
    return ((IQZoneJustLocationApi)QRoute.api(IQZoneJustLocationApi.class)).getCurrGps(paramString);
  }
  
  public static void refreshPoiList()
  {
    ((IQzoneLbsServiceApi)QRoute.api(IQzoneLbsServiceApi.class)).refreshPoiList();
  }
  
  public static void startLocation(LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(paramLbsManagerServiceOnLocationChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper
 * JD-Core Version:    0.7.0.1
 */