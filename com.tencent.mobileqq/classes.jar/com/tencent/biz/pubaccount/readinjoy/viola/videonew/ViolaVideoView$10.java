package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaVideoView$10
  implements SeekBar.OnSeekBarChangeListener
{
  ViolaVideoView$10(ViolaVideoView paramViolaVideoView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!ViolaVideoView.a(this.a).a()) {
      return;
    }
    long l = ViolaVideoView.a(this.a).a();
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    VideoFeedsHelper.a(ViolaVideoView.a(this.a), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    ViolaVideoView.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (!ViolaVideoView.a(this.a).a()) {}
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      ViolaVideoView.a(this.a, false);
      int i = paramSeekBar.getProgress();
      long l = ViolaVideoView.a(this.a).a();
      i = (int)(i / 100.0D * l);
      ViolaVideoView.a(this.a).d(i);
      if (ViolaVideoView.a(this.a) != null) {
        ViolaVideoView.a(this.a).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView.10
 * JD-Core Version:    0.7.0.1
 */