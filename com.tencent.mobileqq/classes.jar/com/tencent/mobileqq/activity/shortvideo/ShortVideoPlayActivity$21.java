package com.tencent.mobileqq.activity.shortvideo;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortVideoPlayActivity$21
  implements SeekBar.OnSeekBarChangeListener
{
  ShortVideoPlayActivity$21(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("onProgressChanged: progress = ");
      paramSeekBar.append(paramInt);
      paramSeekBar.append(",fromUser=");
      paramSeekBar.append(paramBoolean);
      QLog.d("ShortVideoPlayActivity", 2, paramSeekBar.toString());
    }
    paramSeekBar = this.a;
    paramSeekBar.hasSeeked = true;
    if (paramBoolean)
    {
      paramSeekBar.mSeekTimes += 1;
      ShortVideoPlayActivity.access$602(this.a, true);
      ShortVideoPlayActivity.access$402(this.a, true);
    }
    paramSeekBar = this.a;
    paramSeekBar.setProgressTime(paramInt * paramSeekBar.mDuration / 10000L);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.mSeekBar.getProgress();
    ShortVideoPlayActivity.access$602(this.a, true);
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("onStartTrackingTouch: progress = ");
      paramSeekBar.append(i);
      QLog.d("ShortVideoPlayActivity", 2, paramSeekBar.toString());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.showAnimation();
    Object localObject = this.a;
    ((ShortVideoPlayActivity)localObject).mNewSeekTimes += 1;
    localObject = this.a;
    ((ShortVideoPlayActivity)localObject).seekFlagForCacheProgress = true;
    int i = ((ShortVideoPlayActivity)localObject).mSeekBar.getProgress();
    int j = (int)(i * this.a.mDuration / 10000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStopTrackingTouch: seekProgress = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", mCacheProgress= ");
      ((StringBuilder)localObject).append(ShortVideoPlayActivity.access$800(this.a));
      ((StringBuilder)localObject).append(", timestamp = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("ShortVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.mMediaPlayer != null)
    {
      if (this.a.mPlayState == 2) {
        this.a.resume();
      }
      this.a.play(j);
    }
    ShortVideoPlayActivity.access$602(this.a, false);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.21
 * JD-Core Version:    0.7.0.1
 */