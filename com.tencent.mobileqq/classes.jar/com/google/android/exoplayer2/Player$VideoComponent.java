package com.google.android.exoplayer2;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.video.VideoListener;

public abstract interface Player$VideoComponent
{
  public abstract void addVideoListener(VideoListener paramVideoListener);
  
  public abstract void clearVideoSurface();
  
  public abstract void clearVideoSurface(Surface paramSurface);
  
  public abstract void clearVideoSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void clearVideoSurfaceView(SurfaceView paramSurfaceView);
  
  public abstract void clearVideoTextureView(TextureView paramTextureView);
  
  public abstract int getVideoScalingMode();
  
  public abstract void removeVideoListener(VideoListener paramVideoListener);
  
  public abstract void setVideoScalingMode(int paramInt);
  
  public abstract void setVideoSurface(Surface paramSurface);
  
  public abstract void setVideoSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setVideoSurfaceView(SurfaceView paramSurfaceView);
  
  public abstract void setVideoTextureView(TextureView paramTextureView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.Player.VideoComponent
 * JD-Core Version:    0.7.0.1
 */