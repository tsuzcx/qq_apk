package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public final class GdtLocationAdapter
  implements AdLocationAdapter
{
  public AdLocation getLocationCache()
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      AdLocation localAdLocation = new AdLocation();
      localAdLocation.latitude = localSosoLbsInfo.mLocation.mLat02;
      localAdLocation.longitude = localSosoLbsInfo.mLocation.mLon02;
      localAdLocation.timeMillis = localSosoLbsInfo.mLocation.locationTime;
      return localAdLocation;
    }
    GdtLog.b("GdtLocationAdapter", String.format("getLocationCache %s", new Object[] { null }));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtLocationAdapter
 * JD-Core Version:    0.7.0.1
 */