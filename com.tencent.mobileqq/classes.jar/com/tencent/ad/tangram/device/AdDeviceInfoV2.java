package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import java.lang.ref.WeakReference;

@Keep
public final class AdDeviceInfoV2
{
  private static final String TAG = "AdDeviceInfoV2";
  private static volatile AdDeviceInfoV2 instance;
  private volatile WeakReference<AdDeviceInfoV2Adapter> adapter;
  
  private AdDeviceInfoV2Adapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdDeviceInfoV2Adapter)this.adapter.get();
    }
    return null;
  }
  
  public static AdDeviceInfoV2 getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new AdDeviceInfoV2();
        }
      }
      finally {}
    }
    return instance;
  }
  
  public AdDeviceInfo.Result createV2(Context paramContext, AdDeviceInfo.Params paramParams, gdt_settings.Settings paramSettings)
  {
    AdDeviceInfoV2Adapter localAdDeviceInfoV2Adapter = getAdapter();
    if (localAdDeviceInfoV2Adapter == null)
    {
      AdLog.e("AdDeviceInfoV2", "createV2 error, adapter is null");
      return null;
    }
    return localAdDeviceInfoV2Adapter.createV2(paramContext, paramParams, paramSettings);
  }
  
  public void setAdapter(WeakReference<AdDeviceInfoV2Adapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfoV2
 * JD-Core Version:    0.7.0.1
 */