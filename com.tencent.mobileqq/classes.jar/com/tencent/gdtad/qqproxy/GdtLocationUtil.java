package com.tencent.gdtad.qqproxy;

import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
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
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      bool = true;
    } else {
      bool = false;
    }
    AdAnalysis localAdAnalysis = AdAnalysis.INSTANCE;
    WeakReference localWeakReference = new WeakReference(paramContext);
    long l3 = System.currentTimeMillis();
    long l1;
    if (bool) {
      l1 = System.currentTimeMillis() - localSosoLbsInfo.mLocation.locationTime;
    } else {
      l1 = -2147483648L;
    }
    localAdAnalysis.handleAsync(localWeakReference, AdAnalysisHelperForUtil.createEventForLocation(paramContext, null, bool, l3 - l2, l1));
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      return new int[] { (int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D) };
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtLocationUtil
 * JD-Core Version:    0.7.0.1
 */