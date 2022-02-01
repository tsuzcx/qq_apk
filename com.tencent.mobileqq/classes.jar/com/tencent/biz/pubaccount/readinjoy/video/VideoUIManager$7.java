package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoUIManager$7
  implements SeekBar.OnSeekBarChangeListener
{
  VideoUIManager$7(VideoUIManager paramVideoUIManager) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = VideoUIManager.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onStopTrackingTouch(): progress=" + i + ", playState=" + VideoPlayUtils.a(j));
    }
    if (j == 3) {
      VideoUIManager.a(this.a).a(i * 1000, VideoUIManager.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
      return;
      if (j == 5) {
        VideoUIManager.a(this.a).c(i * 1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.7
 * JD-Core Version:    0.7.0.1
 */