package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.util.Log;
import java.io.IOException;

final class AdsMediaSource$ComponentListener
  implements AdsLoader.EventListener
{
  private final Handler playerHandler = new Handler();
  private volatile boolean released;
  
  public AdsMediaSource$ComponentListener(AdsMediaSource paramAdsMediaSource) {}
  
  public void onAdClicked()
  {
    if (this.released) {}
    while ((AdsMediaSource.access$400(this.this$0) == null) || (AdsMediaSource.access$500(this.this$0) == null)) {
      return;
    }
    AdsMediaSource.access$400(this.this$0).post(new AdsMediaSource.ComponentListener.2(this));
  }
  
  public void onAdLoadError(IOException paramIOException)
  {
    if (this.released) {}
    do
    {
      return;
      Log.w("AdsMediaSource", "Ad load error", paramIOException);
    } while ((AdsMediaSource.access$400(this.this$0) == null) || (AdsMediaSource.access$500(this.this$0) == null));
    AdsMediaSource.access$400(this.this$0).post(new AdsMediaSource.ComponentListener.4(this, paramIOException));
  }
  
  public void onAdPlaybackState(AdPlaybackState paramAdPlaybackState)
  {
    if (this.released) {
      return;
    }
    this.playerHandler.post(new AdsMediaSource.ComponentListener.1(this, paramAdPlaybackState));
  }
  
  public void onAdTapped()
  {
    if (this.released) {}
    while ((AdsMediaSource.access$400(this.this$0) == null) || (AdsMediaSource.access$500(this.this$0) == null)) {
      return;
    }
    AdsMediaSource.access$400(this.this$0).post(new AdsMediaSource.ComponentListener.3(this));
  }
  
  public void onInternalAdLoadError(RuntimeException paramRuntimeException)
  {
    if (this.released) {}
    do
    {
      return;
      Log.w("AdsMediaSource", "Internal ad load error", paramRuntimeException);
    } while ((AdsMediaSource.access$400(this.this$0) == null) || (AdsMediaSource.access$500(this.this$0) == null));
    AdsMediaSource.access$400(this.this$0).post(new AdsMediaSource.ComponentListener.5(this, paramRuntimeException));
  }
  
  public void release()
  {
    this.released = true;
    this.playerHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener
 * JD-Core Version:    0.7.0.1
 */