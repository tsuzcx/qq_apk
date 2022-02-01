package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener;
import java.io.IOException;

final class AdsMediaSource$AdPrepareErrorListener
  implements DeferredMediaPeriod.PrepareErrorListener
{
  private final int adGroupIndex;
  private final int adIndexInAdGroup;
  
  public AdsMediaSource$AdPrepareErrorListener(AdsMediaSource paramAdsMediaSource, int paramInt1, int paramInt2)
  {
    this.adGroupIndex = paramInt1;
    this.adIndexInAdGroup = paramInt2;
  }
  
  public void onPrepareError(IOException paramIOException)
  {
    AdsMediaSource.access$800(this.this$0).post(new AdsMediaSource.AdPrepareErrorListener.1(this, paramIOException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareErrorListener
 * JD-Core Version:    0.7.0.1
 */