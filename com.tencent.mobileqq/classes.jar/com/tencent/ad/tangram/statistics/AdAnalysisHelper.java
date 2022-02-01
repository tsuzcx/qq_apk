package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.device.AdCarrier;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;

@Keep
public final class AdAnalysisHelper
{
  public static gdt_analysis_event createEventForAd(Context paramContext, int paramInt, Ad paramAd)
  {
    String str2 = null;
    String str1;
    if (paramAd != null) {
      str1 = paramAd.getPosId();
    } else {
      str1 = null;
    }
    if (paramAd != null) {
      str2 = String.valueOf(paramAd.getAId());
    }
    int i;
    if (paramAd != null) {
      i = paramAd.getCreativeSize();
    } else {
      i = -2147483648;
    }
    paramAd = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, paramInt, paramAd);
    paramAd.posId = str1;
    paramAd.aid = str2;
    paramAd.carrierCode = AdCarrier.getCode(paramContext);
    paramAd.creativeSize = i;
    paramAd.netType = AdNet.getTypeWith5G(paramContext);
    paramAd.networkType = AdNet.getNetworkType(paramContext);
    return paramAd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdAnalysisHelper
 * JD-Core Version:    0.7.0.1
 */