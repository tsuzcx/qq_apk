package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.device.AdDeviceInfo.Params;
import com.tencent.ad.tangram.device.AdDeviceInfo.Result;
import com.tencent.ad.tangram.device.AdDeviceInfoV2Adapter;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;

public class GdtDeviceInfoV2Adapter
  implements AdDeviceInfoV2Adapter
{
  public AdDeviceInfo.Result createV2(Context paramContext, AdDeviceInfo.Params paramParams, gdt_settings.Settings paramSettings)
  {
    return GdtDeviceInfoHelper.a(paramContext, paramParams, paramSettings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDeviceInfoV2Adapter
 * JD-Core Version:    0.7.0.1
 */