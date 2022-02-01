package com.tencent.mm.plugin.appbrand.widget.music;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MusicSeekBar$1
  implements SeekBar.OnSeekBarChangeListener
{
  MusicSeekBar$1(MusicSeekBar paramMusicSeekBar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.b = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MusicSeekBar localMusicSeekBar = this.a;
    localMusicSeekBar.b = false;
    if (MusicSeekBar.a(localMusicSeekBar) != null) {
      MusicSeekBar.a(this.a).a(paramSeekBar.getProgress());
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.1
 * JD-Core Version:    0.7.0.1
 */