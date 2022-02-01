package com.tencent.mobileqq.activity.shortvideo;

import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.video.IMediaPlayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$22
  implements SeekBar.OnSeekBarChangeListener
{
  ShortVideoPreviewActivity$22(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.seekBarMp.getProgress();
    if (this.a.updateBarHandler != null) {
      this.a.updateBarHandler.removeCallbacks(this.a.updateSeekBarThread);
    }
    this.a.pause();
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("onStartTrackingTouch: progress = ");
      paramSeekBar.append(i);
      QLog.d("ShortVideoPreviewActivity", 2, paramSeekBar.toString());
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = this.a.seekBarMp.getProgress();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStopTrackingTouch: 当前位置为 = ");
      localStringBuilder.append(i);
      QLog.d("ShortVideoPreviewActivity", 2, localStringBuilder.toString());
    }
    if (this.a.mMediaPlayer != null)
    {
      if (this.a.getPlayState() == 2) {
        this.a.resume();
      }
      this.a.operatorBtnSeekBar.setImageResource(2130847780);
      this.a.mMediaPlayer.a();
      this.a.mMediaPlayer.a(i);
      this.a.updateBarHandler.post(this.a.updateSeekBarThread);
      this.a.mSendBtn.setEnabled(false);
      this.a.mSendBtn.setTextColor(-2130706433);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.22
 * JD-Core Version:    0.7.0.1
 */