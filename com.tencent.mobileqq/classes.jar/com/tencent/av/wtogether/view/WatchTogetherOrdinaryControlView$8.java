package com.tencent.av.wtogether.view;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;

class WatchTogetherOrdinaryControlView$8
  implements SeekBar.OnSeekBarChangeListener
{
  WatchTogetherOrdinaryControlView$8(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    VideoController.f().aA().c(paramInt);
    paramSeekBar = this.a;
    WatchTogetherOrdinaryControlView.b(paramSeekBar, WatchTogetherOrdinaryControlView.o(paramSeekBar), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    WatchTogetherOrdinaryControlView.p(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.8
 * JD-Core Version:    0.7.0.1
 */