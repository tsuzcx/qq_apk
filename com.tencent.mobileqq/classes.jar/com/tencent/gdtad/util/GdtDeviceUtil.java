package com.tencent.gdtad.util;

import android.content.Context;
import com.tencent.ad.tangram.device.AdCarrier;
import com.tencent.ad.tangram.device.AdDeviceIdBuilder;
import com.tencent.ad.tangram.device.AdDeviceIdentifier;

public class GdtDeviceUtil
{
  private static String a = "GdtDeviceUtil";
  
  @Deprecated
  public static String a(Context paramContext)
  {
    return new AdDeviceIdBuilder().build(paramContext, false, null).idHash;
  }
  
  @Deprecated
  public static final int b(Context paramContext)
  {
    return AdCarrier.getType(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceUtil
 * JD-Core Version:    0.7.0.1
 */