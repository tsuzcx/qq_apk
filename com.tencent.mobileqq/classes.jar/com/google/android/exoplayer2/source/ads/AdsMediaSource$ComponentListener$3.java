package com.google.android.exoplayer2.source.ads;

class AdsMediaSource$ComponentListener$3
  implements Runnable
{
  AdsMediaSource$ComponentListener$3(AdsMediaSource.ComponentListener paramComponentListener) {}
  
  public void run()
  {
    if (!AdsMediaSource.ComponentListener.access$200(this.this$1)) {
      AdsMediaSource.access$500(this.this$1.this$0).onAdTapped();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.3
 * JD-Core Version:    0.7.0.1
 */