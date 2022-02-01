package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;

@Keep
public abstract interface AdDeviceInfoV2Adapter
{
  public abstract AdDeviceInfo.Result createV2(Context paramContext, AdDeviceInfo.Params paramParams, gdt_settings.Settings paramSettings);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfoV2Adapter
 * JD-Core Version:    0.7.0.1
 */