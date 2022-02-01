package com.tencent.av.ui.beauty;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BeautySeekView$3
  implements SeekBar.OnSeekBarChangeListener
{
  BeautySeekView$3(BeautySeekView paramBeautySeekView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (BeautySeekView.a(this.a) != paramInt)
    {
      BeautySeekView.a(this.a, paramInt);
      if ((paramBoolean) && (BeautySeekView.a(this.a) != null)) {
        BeautySeekView.a(this.a).setContentDescription(paramInt + "%");
      }
      BeautySeekView.a(this.a, paramInt);
      BeautySeekView.b(this.a, BeautySeekView.a(this.a));
    }
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 2, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.a).removeCallbacks(this.a.a);
    BeautySeekView.a(this.a).setVisibility(0);
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 1, BeautySeekView.a(this.a));
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.a(this.a).postDelayed(this.a.a, 300L);
    if (BeautySeekView.a(this.a) != null) {
      BeautySeekView.a(this.a).a(BeautySeekView.a(this.a), 3, BeautySeekView.a(this.a));
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView.3
 * JD-Core Version:    0.7.0.1
 */