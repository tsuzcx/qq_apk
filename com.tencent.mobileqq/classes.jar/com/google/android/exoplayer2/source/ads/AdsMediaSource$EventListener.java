package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;

public abstract interface AdsMediaSource$EventListener
  extends MediaSourceEventListener
{
  public abstract void onAdClicked();
  
  public abstract void onAdLoadError(IOException paramIOException);
  
  public abstract void onAdTapped();
  
  public abstract void onInternalAdLoadError(RuntimeException paramRuntimeException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener
 * JD-Core Version:    0.7.0.1
 */