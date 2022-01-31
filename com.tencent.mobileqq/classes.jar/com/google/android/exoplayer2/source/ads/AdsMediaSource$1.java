package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.ExoPlayer;

class AdsMediaSource$1
  implements Runnable
{
  AdsMediaSource$1(AdsMediaSource paramAdsMediaSource, ExoPlayer paramExoPlayer, AdsMediaSource.ComponentListener paramComponentListener) {}
  
  public void run()
  {
    AdsMediaSource.access$100(this.this$0).attachPlayer(this.val$player, this.val$componentListener, AdsMediaSource.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.1
 * JD-Core Version:    0.7.0.1
 */