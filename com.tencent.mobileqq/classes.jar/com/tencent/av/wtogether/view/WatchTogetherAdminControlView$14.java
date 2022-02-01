package com.tencent.av.wtogether.view;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;

class WatchTogetherAdminControlView$14
  implements SeekBar.OnSeekBarChangeListener
{
  WatchTogetherAdminControlView$14(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    VideoController.f().aA().c(paramInt);
    paramSeekBar = this.a;
    WatchTogetherAdminControlView.b(paramSeekBar, WatchTogetherAdminControlView.r(paramSeekBar), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    WatchTogetherAdminControlView.s(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.14
 * JD-Core Version:    0.7.0.1
 */