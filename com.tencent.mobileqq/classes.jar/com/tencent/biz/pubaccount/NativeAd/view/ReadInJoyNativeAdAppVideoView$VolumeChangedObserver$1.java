package com.tencent.biz.pubaccount.NativeAd.view;

import android.media.AudioManager;
import android.widget.ImageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ReadInJoyNativeAdAppVideoView$VolumeChangedObserver$1
  implements Runnable
{
  ReadInJoyNativeAdAppVideoView$VolumeChangedObserver$1(ReadInJoyNativeAdAppVideoView.VolumeChangedObserver paramVolumeChangedObserver) {}
  
  public void run()
  {
    if (ReadInJoyNativeAdAppVideoView.x(this.a.a).getStreamVolume(3) > 0)
    {
      ReadInJoyNativeAdAppVideoView.y(this.a.a).setImageResource(2130842579);
      ReadInJoyNativeAdAppVideoView.f(this.a.a).setOutputMute(false);
      return;
    }
    ReadInJoyNativeAdAppVideoView.y(this.a.a).setImageResource(2130842578);
    ReadInJoyNativeAdAppVideoView.f(this.a.a).setOutputMute(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.VolumeChangedObserver.1
 * JD-Core Version:    0.7.0.1
 */