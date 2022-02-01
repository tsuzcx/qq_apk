package com.tencent.gdtad.qqproxy;

import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.lang.ref.WeakReference;

public final class GdtLocationUtil
{
  public final String a = "GdtLocationUtil";
  
  @Deprecated
  public static int[] a(Context paramContext)
  {
    long l2 = System.currentTimeMillis();
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("gdt_tangram");
    boolean bool;
    AdAnalysis localAdAnalysis;
    WeakReference localWeakReference;
    long l3;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      bool = true;
      localAdAnalysis = AdAnalysis.INSTANCE;
      localWeakReference = new WeakReference(paramContext);
      l3 = System.currentTimeMillis();
      if (!bool) {
        break label114;
      }
    }
    label114:
    for (long l1 = System.currentTimeMillis() - localSosoLbsInfo.mLocation.locationTime;; l1 = -2147483648L)
    {
      localAdAnalysis.handleAsync(localWeakReference, AdReporterForAnalysis.createEventForLocation(paramContext, bool, l3 - l2, l1));
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
        break label121;
      }
      return null;
      bool = false;
      break;
    }
    label121:
    return new int[] { (int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtLocationUtil
 * JD-Core Version:    0.7.0.1
 */