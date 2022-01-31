package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.util.Assertions;

@TargetApi(16)
public final class FrameworkMediaCrypto
  implements ExoMediaCrypto
{
  private final boolean forceAllowInsecureDecoderComponents;
  private final MediaCrypto mediaCrypto;
  
  public FrameworkMediaCrypto(MediaCrypto paramMediaCrypto)
  {
    this(paramMediaCrypto, false);
  }
  
  public FrameworkMediaCrypto(MediaCrypto paramMediaCrypto, boolean paramBoolean)
  {
    this.mediaCrypto = ((MediaCrypto)Assertions.checkNotNull(paramMediaCrypto));
    this.forceAllowInsecureDecoderComponents = paramBoolean;
  }
  
  public MediaCrypto getWrappedMediaCrypto()
  {
    return this.mediaCrypto;
  }
  
  public boolean requiresSecureDecoderComponent(String paramString)
  {
    return (!this.forceAllowInsecureDecoderComponents) && (this.mediaCrypto.requiresSecureDecoderComponent(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.FrameworkMediaCrypto
 * JD-Core Version:    0.7.0.1
 */