package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController$seekBarChangeListener$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoMaskController$seekBarChangeListener$1
  implements SeekBar.OnSeekBarChangeListener
{
  public void onProgressChanged(@Nullable SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    this.a.f();
    VideoMaskController.d(this.a, paramInt);
  }
  
  public void onStartTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    VideoMaskController.f(this.a);
    VideoMaskController.e(this.a);
    this.a.j();
  }
  
  public void onStopTrackingTouch(@Nullable SeekBar paramSeekBar)
  {
    VideoMaskController.a(this.a).setManualPause(false);
    VideoMaskController.g(this.a);
    VideoMaskController.h(this.a);
    VideoMaskController.a(this.a, VideoMaskController.a(this.a));
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.seekBarChangeListener.1
 * JD-Core Version:    0.7.0.1
 */