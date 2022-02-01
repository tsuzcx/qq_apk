package com.google.android.exoplayer2.source.ads;

class AdsMediaSource$ComponentListener$2
  implements Runnable
{
  AdsMediaSource$ComponentListener$2(AdsMediaSource.ComponentListener paramComponentListener) {}
  
  public void run()
  {
    if (!AdsMediaSource.ComponentListener.access$200(this.this$1)) {
      AdsMediaSource.access$500(this.this$1.this$0).onAdClicked();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.2
 * JD-Core Version:    0.7.0.1
 */