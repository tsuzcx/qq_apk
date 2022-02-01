package com.google.android.exoplayer2.source.ads;

import java.io.IOException;

public abstract interface AdsLoader$EventListener
{
  public abstract void onAdClicked();
  
  public abstract void onAdLoadError(IOException paramIOException);
  
  public abstract void onAdPlaybackState(AdPlaybackState paramAdPlaybackState);
  
  public abstract void onAdTapped();
  
  public abstract void onInternalAdLoadError(RuntimeException paramRuntimeException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
 * JD-Core Version:    0.7.0.1
 */