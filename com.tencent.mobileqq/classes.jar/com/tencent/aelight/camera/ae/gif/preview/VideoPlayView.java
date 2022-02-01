package com.tencent.aelight.camera.ae.gif.preview;

import android.content.Context;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class VideoPlayView
  extends GLSurfaceView
{
  private static final String a = "VideoPlayView";
  private final VideoPlayerRenderer b;
  private MediaPlayer c;
  
  public VideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    this.b = new VideoPlayerRenderer(this);
    setRenderer(this.b);
    setRenderMode(0);
  }
  
  public VideoPlayView a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return this;
    }
    MediaPlayer localMediaPlayer = this.c;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.c = null;
    }
    this.c = paramMediaPlayer;
    this.b.a(paramMediaPlayer);
    return this;
  }
  
  public void a()
  {
    queueEvent(new VideoPlayView.1(this));
  }
  
  public void setFrameRenderCallback(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    VideoPlayerRenderer localVideoPlayerRenderer = this.b;
    if (localVideoPlayerRenderer != null) {
      localVideoPlayerRenderer.a(paramFrameRenderCallback);
    }
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    VideoPlayerRenderer localVideoPlayerRenderer = this.b;
    if (localVideoPlayerRenderer != null) {
      localVideoPlayerRenderer.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.preview.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */