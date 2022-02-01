package com.tencent.ad.tangram.device;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

abstract class f
{
  public AdDeviceIdentifier build(Context paramContext, boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    AdDeviceIdentifier localAdDeviceIdentifier = new AdDeviceIdentifier();
    String str1 = getIdCache(paramContext);
    String str2 = getIdHash(str1);
    int i;
    if (!TextUtils.isEmpty(str2))
    {
      localAdDeviceIdentifier.id = str1;
      localAdDeviceIdentifier.idHash = str2;
      i = 1;
    }
    for (;;)
    {
      int k = getEventId();
      if (!TextUtils.isEmpty(localAdDeviceIdentifier.idHash)) {}
      for (int j = 0;; j = 1)
      {
        localAdDeviceIdentifier.event = AdReporterForAnalysis.createEventForDeviceIdentifier(paramContext, k, j, System.currentTimeMillis() - l, i);
        return localAdDeviceIdentifier;
        str1 = getId(paramContext, paramBoolean);
        str2 = getIdHash(str1);
        if (!TextUtils.isEmpty(str2))
        {
          localAdDeviceIdentifier.id = str1;
          localAdDeviceIdentifier.idHash = str2;
          i = 0;
          break;
        }
        if (TextUtils.isEmpty(paramString)) {
          break label167;
        }
        i = 2;
        localAdDeviceIdentifier.idHash = paramString;
        break;
      }
      label167:
      i = 0;
    }
  }
  
  protected abstract int getEventId();
  
  protected abstract String getId(Context paramContext, boolean paramBoolean);
  
  protected abstract String getIdCache(Context paramContext);
  
  protected abstract String getIdHash(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.f
 * JD-Core Version:    0.7.0.1
 */