package com.google.android.exoplayer2.source.ads;

class AdsMediaSource$ComponentListener$5
  implements Runnable
{
  AdsMediaSource$ComponentListener$5(AdsMediaSource.ComponentListener paramComponentListener, RuntimeException paramRuntimeException) {}
  
  public void run()
  {
    if (!AdsMediaSource.ComponentListener.access$200(this.this$1)) {
      AdsMediaSource.access$500(this.this$1.this$0).onInternalAdLoadError(this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.5
 * JD-Core Version:    0.7.0.1
 */