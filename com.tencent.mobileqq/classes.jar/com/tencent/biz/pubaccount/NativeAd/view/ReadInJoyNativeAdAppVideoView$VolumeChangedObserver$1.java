package com.tencent.biz.pubaccount.NativeAd.view;

import android.media.AudioManager;
import android.widget.ImageView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import npm;

public class ReadInJoyNativeAdAppVideoView$VolumeChangedObserver$1
  implements Runnable
{
  public ReadInJoyNativeAdAppVideoView$VolumeChangedObserver$1(npm paramnpm) {}
  
  public void run()
  {
    if (ReadInJoyNativeAdAppVideoView.a(this.a.a).getStreamVolume(3) > 0)
    {
      ReadInJoyNativeAdAppVideoView.b(this.a.a).setImageResource(2130841276);
      ReadInJoyNativeAdAppVideoView.a(this.a.a).setOutputMute(false);
      return;
    }
    ReadInJoyNativeAdAppVideoView.b(this.a.a).setImageResource(2130841275);
    ReadInJoyNativeAdAppVideoView.a(this.a.a).setOutputMute(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView.VolumeChangedObserver.1
 * JD-Core Version:    0.7.0.1
 */