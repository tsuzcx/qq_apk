package com.tencent.av.wtogether.callback;

import android.widget.SeekBar.OnSeekBarChangeListener;

public abstract interface WatchTogetherUIProxy
  extends WatchTogetherMediaPlayerStatusCallback
{
  public abstract void setImmersiveStatus(boolean paramBoolean);
  
  public abstract void setOrientationParams(int paramInt);
  
  public abstract void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener);
  
  public abstract void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy);
  
  public abstract void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.callback.WatchTogetherUIProxy
 * JD-Core Version:    0.7.0.1
 */