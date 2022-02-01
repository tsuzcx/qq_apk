package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.List;
import java.util.Map;

public abstract interface MediaPlayerInterface
{
  public static final int EXO_MEDIA_ERROR_EXTRA_CONN = -3;
  public static final int EXO_MEDIA_ERROR_EXTRA_NETWORK = -2;
  public static final int EXO_MEDIA_ERROR_EXTRA_UNKNOWN = -1;
  public static final int EXO_MEDIA_ERROR_LOADER = -4004;
  public static final int EXO_MEDIA_ERROR_RESPONSE_403 = -10;
  public static final int EXO_MEDIA_ERROR_RESPONSE_404 = -11;
  public static final int EXO_MEDIA_ERROR_RESPONSE_500 = -12;
  public static final int EXO_MEDIA_ERROR_RESPONSE_502 = -13;
  public static final int EXO_MEDIA_ERROR_RESPONSE_OTHER = -30;
  public static final int EXO_MEDIA_ERROR_WHAT_EXTRACTOR = -4001;
  public static final int EXO_MEDIA_ERROR_WHAT_IO = -4000;
  public static final int EXO_MEDIA_ERROR_WHAT_UNKNOWN = -4999;
  public static final int EXO_MEIDA_ERROR_ILLEGAL_STATE = -4002;
  public static final int EXO_MEIDA_ERROR_MEDIACODEC_DECODER_INIT = -4003;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
  public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
  
  public abstract long getCurrentPosition();
  
  public abstract long getDuration();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract boolean isLooping();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap);
  
  public abstract void setDataSource(Context paramContext, List<String> paramList);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDataSource(List<VideoMeta> paramList);
  
  public abstract void setDisplay(SurfaceHolder paramSurfaceHolder);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setNextMediaPlayer(MediaPlayerInterface paramMediaPlayerInterface);
  
  public abstract void setOnBufferingUpdateListener(MediaPlayerInterface.OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void setOnCompletionListener(MediaPlayerInterface.OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(MediaPlayerInterface.OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(MediaPlayerInterface.OnInfoListener paramOnInfoListener);
  
  public abstract void setOnLoopStartListener(MediaPlayerInterface.OnLoopStartListener paramOnLoopStartListener);
  
  public abstract void setOnPreparedListener(MediaPlayerInterface.OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(MediaPlayerInterface.OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setOnVideoSizeChangedListener(MediaPlayerInterface.OnVideoSizeChangedListener paramOnVideoSizeChangedListener);
  
  public abstract void setRate(float paramFloat);
  
  public abstract void setScreenOnWhilePlaying(boolean paramBoolean);
  
  public abstract void setSurface(Surface paramSurface);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  @Deprecated
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.MediaPlayerInterface
 * JD-Core Version:    0.7.0.1
 */