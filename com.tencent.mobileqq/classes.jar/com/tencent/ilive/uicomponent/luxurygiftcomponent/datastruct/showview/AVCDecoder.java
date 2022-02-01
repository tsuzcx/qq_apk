package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.os.Build.VERSION;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.AVConfig;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

public class AVCDecoder
{
  public static final String AVCVideoType = "video/avc";
  private static final String AVHelperTAG = "AVCDecoderHelper";
  
  public static final boolean isSupportAVCCodec(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    if (!AVConfig.isSupportHardwareDecoder())
    {
      paramLuxuryGiftAdapter.getLogger().i("AVCDecoderHelper", "disable hardwareDecoder from Config.isSupportHardwareDecoder", new Object[0]);
      return false;
    }
    paramLuxuryGiftAdapter.getLogger().i("AVCDecoderHelper", "isSupportAVCCodec in", new Object[0]);
    return Build.VERSION.SDK_INT >= 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.AVCDecoder
 * JD-Core Version:    0.7.0.1
 */