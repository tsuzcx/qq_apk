package com.tencent.ad.tangram.video;

import android.support.annotation.Keep;

@Keep
public final class AdVideo$CodecCapability
{
  public int framerateForLumaSamples;
  public int lumaSamples;
  
  public boolean isValid()
  {
    return (this.lumaSamples > 0) && (this.framerateForLumaSamples > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.video.AdVideo.CodecCapability
 * JD-Core Version:    0.7.0.1
 */