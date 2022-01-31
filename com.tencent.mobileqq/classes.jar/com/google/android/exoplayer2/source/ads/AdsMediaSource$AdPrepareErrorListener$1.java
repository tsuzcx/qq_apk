package com.google.android.exoplayer2.source.ads;

import java.io.IOException;

class AdsMediaSource$AdPrepareErrorListener$1
  implements Runnable
{
  AdsMediaSource$AdPrepareErrorListener$1(AdsMediaSource.AdPrepareErrorListener paramAdPrepareErrorListener, IOException paramIOException) {}
  
  public void run()
  {
    AdsMediaSource.access$100(this.this$1.this$0).handlePrepareError(AdsMediaSource.AdPrepareErrorListener.access$600(this.this$1), AdsMediaSource.AdPrepareErrorListener.access$700(this.this$1), this.val$exception);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareErrorListener.1
 * JD-Core Version:    0.7.0.1
 */