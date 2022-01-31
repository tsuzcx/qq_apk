package com.tencent.gdtad.qqproxy;

import ampk;
import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.lang.ref.WeakReference;

public enum GdtLocationUtil
{
  INSTANCE;
  
  public final String TAG = "GdtLocationUtil";
  
  private GdtLocationUtil() {}
  
  @Deprecated
  public int[] getLocation(Context paramContext)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = ampk.a("gdt_tangram");
    boolean bool;
    AdAnalysis localAdAnalysis;
    WeakReference localWeakReference;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      bool = true;
      localAdAnalysis = AdAnalysis.INSTANCE;
      localWeakReference = new WeakReference(paramContext);
      if (!bool) {
        break label87;
      }
    }
    label87:
    for (long l = System.currentTimeMillis() - localSosoLbsInfo.a.jdField_a_of_type_Long;; l = -2147483648L)
    {
      localAdAnalysis.handleAsync(localWeakReference, AdReporterForAnalysis.createEventForLocation(paramContext, bool, l));
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
        break label94;
      }
      return null;
      bool = false;
      break;
    }
    label94:
    return new int[] { (int)(localSosoLbsInfo.a.jdField_a_of_type_Double * 1000000.0D), (int)(localSosoLbsInfo.a.b * 1000000.0D) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtLocationUtil
 * JD-Core Version:    0.7.0.1
 */