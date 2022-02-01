package com.tencent.av.wtogether.callback;

import androidx.annotation.NonNull;
import com.tencent.av.wtogether.gles.WatchTogetherSurfaceTextureHolder;

public abstract interface VideoSink
{
  public abstract boolean a();
  
  public abstract boolean a(@NonNull WatchTogetherSurfaceTextureHolder paramWatchTogetherSurfaceTextureHolder, int paramInt1, int paramInt2);
  
  public abstract boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.callback.VideoSink
 * JD-Core Version:    0.7.0.1
 */