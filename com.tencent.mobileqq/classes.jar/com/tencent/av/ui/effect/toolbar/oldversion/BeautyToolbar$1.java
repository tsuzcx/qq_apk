package com.tencent.av.ui.effect.toolbar.oldversion;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BeautyToolbar$1
  implements SeekBar.OnSeekBarChangeListener
{
  BeautyToolbar$1(BeautyToolbar paramBeautyToolbar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.mBeautyValue != paramInt)
    {
      this.a.updateTip(paramInt);
      if ((paramInt == 0) && (this.a.mBeautyValue > 0)) {
        this.a.mSeek.setThumb(this.a.mThumb_0);
      } else if ((paramInt > 0) && (paramInt <= 30) && ((this.a.mBeautyValue <= 0) || (this.a.mBeautyValue > 30))) {
        this.a.mSeek.setThumb(this.a.mThumb_30);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.a.mBeautyValue <= 30) || (this.a.mBeautyValue > 60))) {
        this.a.mSeek.setThumb(this.a.mThumb_60);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.a.mBeautyValue <= 60) || (this.a.mBeautyValue > 100))) {
        this.a.mSeek.setThumb(this.a.mThumb_100);
      }
      if (paramBoolean)
      {
        paramSeekBar = this.a.mSeek;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("%");
        paramSeekBar.setContentDescription(localStringBuilder.toString());
      }
      paramSeekBar = this.a;
      paramSeekBar.mBeautyValue = paramInt;
      BeautyToolbar.access$000(paramSeekBar).a("BEAUTY_SKIN", this.a.mBeautyValue, false);
    }
    BaseToolbar.keepInToolbar(BeautyToolbar.access$100(this.a), -1003L);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BaseToolbar.keepInToolbar(BeautyToolbar.access$200(this.a), -1004L);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BeautyToolbar.access$300(this.a).a("BEAUTY_SKIN", this.a.mBeautyValue, true);
    BaseToolbar.keepInToolbar(BeautyToolbar.access$400(this.a), -1005L);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar.1
 * JD-Core Version:    0.7.0.1
 */