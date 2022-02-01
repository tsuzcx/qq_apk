package com.qflutter.vistaplayer;

import io.flutter.view.TextureRegistry;

public abstract interface IVistaPlayer
{
  public abstract void clear();
  
  public abstract void dispose(long paramLong);
  
  public abstract boolean initialize();
  
  public abstract void loop(long paramLong, boolean paramBoolean);
  
  public abstract void pause(long paramLong);
  
  public abstract void playback(long paramLong);
  
  public abstract int position(long paramLong);
  
  public abstract long prepare(Object paramObject, TextureRegistry paramTextureRegistry);
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract void speed(long paramLong, double paramDouble);
  
  public abstract void stop(long paramLong);
  
  public abstract void volume(long paramLong, double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaplayer.IVistaPlayer
 * JD-Core Version:    0.7.0.1
 */