package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.video.AdVideo.CodecCapability;
import com.tencent.ad.tangram.video.AdVideoAdapter;
import com.tencent.thumbplayer.api.capability.TPCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;

public final class GdtVideoAdapter
  implements AdVideoAdapter
{
  public AdVideo.CodecCapability getHEVCMaxCapability(int paramInt)
  {
    Object localObject = null;
    if (paramInt != 1) {
      return null;
    }
    try
    {
      TPVCodecCapabilityForGet localTPVCodecCapabilityForGet = TPCapability.getThumbPlayerVCodecMaxCapability(172);
      if (localTPVCodecCapabilityForGet == null) {
        return null;
      }
      AdVideo.CodecCapability localCodecCapability = new AdVideo.CodecCapability();
      localCodecCapability.lumaSamples = localTPVCodecCapabilityForGet.getMaxLumaSamples();
      localCodecCapability.framerateForLumaSamples = localTPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples();
      if (localCodecCapability.isValid()) {
        localObject = localCodecCapability;
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("GdtVideoAdapter", "getHEVCMaxCapability", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtVideoAdapter
 * JD-Core Version:    0.7.0.1
 */