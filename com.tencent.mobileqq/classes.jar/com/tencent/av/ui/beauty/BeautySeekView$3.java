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
    if (BeautySeekView.c(this.a) != paramInt)
    {
      BeautySeekView.a(this.a, paramInt);
      if ((paramBoolean) && (BeautySeekView.a(this.a) != null))
      {
        paramSeekBar = BeautySeekView.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("%");
        paramSeekBar.setContentDescription(localStringBuilder.toString());
      }
      BeautySeekView.b(this.a, paramInt);
      paramSeekBar = this.a;
      BeautySeekView.c(paramSeekBar, BeautySeekView.c(paramSeekBar));
    }
    if (BeautySeekView.d(this.a) != null) {
      BeautySeekView.d(this.a).a(BeautySeekView.e(this.a), 2, paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.f(this.a).removeCallbacks(this.a.b);
    BeautySeekView.b(this.a).setVisibility(0);
    if (BeautySeekView.d(this.a) != null) {
      BeautySeekView.d(this.a).a(BeautySeekView.e(this.a), 1, BeautySeekView.c(this.a));
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BeautySeekView.f(this.a).postDelayed(this.a.b, 300L);
    if (BeautySeekView.d(this.a) != null) {
      BeautySeekView.d(this.a).a(BeautySeekView.e(this.a), 3, BeautySeekView.c(this.a));
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView.3
 * JD-Core Version:    0.7.0.1
 */