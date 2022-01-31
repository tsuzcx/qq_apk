package com.google.android.exoplayer2.source.ads;

import java.io.IOException;

class AdsMediaSource$ComponentListener$4
  implements Runnable
{
  AdsMediaSource$ComponentListener$4(AdsMediaSource.ComponentListener paramComponentListener, IOException paramIOException) {}
  
  public void run()
  {
    if (!AdsMediaSource.ComponentListener.access$200(this.this$1)) {
      AdsMediaSource.access$500(this.this$1.this$0).onAdLoadError(this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.4
 * JD-Core Version:    0.7.0.1
 */