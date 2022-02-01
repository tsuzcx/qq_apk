package com.tencent.aelight.camera.ae.gif.preview;

import android.content.Context;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class VideoPlayView
  extends GLSurfaceView
{
  private static final String jdField_a_of_type_JavaLangString = "VideoPlayView";
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final VideoPlayerRenderer jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer;
  
  public VideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer = new VideoPlayerRenderer(this);
    setRenderer(this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer);
    setRenderMode(0);
  }
  
  public VideoPlayView a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return this;
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = paramMediaPlayer;
    this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer.a(paramMediaPlayer);
    return this;
  }
  
  public void a()
  {
    queueEvent(new VideoPlayView.1(this));
  }
  
  public void setFrameRenderCallback(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    VideoPlayerRenderer localVideoPlayerRenderer = this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer;
    if (localVideoPlayerRenderer != null) {
      localVideoPlayerRenderer.a(paramFrameRenderCallback);
    }
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    VideoPlayerRenderer localVideoPlayerRenderer = this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayerRenderer;
    if (localVideoPlayerRenderer != null) {
      localVideoPlayerRenderer.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.preview.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */