package com.google.android.exoplayer2.ext.mediaplayer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;

class ExoMediaPlayer$SurfaceListener
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener
{
  private ExoMediaPlayer$SurfaceListener(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    ExoMediaPlayer.access$800(this.this$0, new Surface(paramSurfaceTexture), true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    ExoMediaPlayer.access$800(this.this$0, null, true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    ExoMediaPlayer.access$800(this.this$0, paramSurfaceHolder.getSurface(), false);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    ExoMediaPlayer.access$800(this.this$0, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.SurfaceListener
 * JD-Core Version:    0.7.0.1
 */