package com.tencent.ad.tangram.device;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

final class b
{
  public AdDeviceIdentifier build(Context paramContext, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    AdDeviceIdentifier localAdDeviceIdentifier = new AdDeviceIdentifier();
    localAdDeviceIdentifier.id = AdNet.getBSSID(paramContext, paramBoolean);
    localAdDeviceIdentifier.idHash = g.getMacAddressMD5Digest(localAdDeviceIdentifier.id);
    if (!TextUtils.isEmpty(localAdDeviceIdentifier.idHash)) {}
    for (int i = 0;; i = 1)
    {
      localAdDeviceIdentifier.event = AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, 1123, i, System.currentTimeMillis() - l, 0);
      return localAdDeviceIdentifier;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.b
 * JD-Core Version:    0.7.0.1
 */