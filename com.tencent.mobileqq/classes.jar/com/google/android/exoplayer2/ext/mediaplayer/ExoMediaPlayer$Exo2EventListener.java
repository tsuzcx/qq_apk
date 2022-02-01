package com.google.android.exoplayer2.ext.mediaplayer;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException;
import java.util.ArrayList;

class ExoMediaPlayer$Exo2EventListener
  implements ExoPlayer.EventListener
{
  private ExoMediaPlayer$Exo2EventListener(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public void onLoadingChanged(boolean paramBoolean)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadingChanged ");
    localStringBuilder.append(paramBoolean);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
    if (paramBoolean) {
      ExoMediaPlayer.access$2100(this.this$0, true);
    }
  }
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlaybackParametersChanged [");
    localStringBuilder.append(paramPlaybackParameters.speed);
    localStringBuilder.append(",");
    localStringBuilder.append(paramPlaybackParameters.pitch);
    localStringBuilder.append("]");
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    if (ExoMediaPlayer.access$700(this.this$0) != null) {
      ExoMediaPlayer.access$2100(this.this$0, false);
    }
    Object localObject = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExoPlaybackException ");
    localStringBuilder.append(paramExoPlaybackException);
    localStringBuilder.append("\n");
    localStringBuilder.append(ExoMediaPlayerUtils.getPrintableStackTrace(paramExoPlaybackException));
    ((ILogger)localObject).e("ExoMediaPlayer", localStringBuilder.toString());
    int k = -4999;
    int i = k;
    if (paramExoPlaybackException != null)
    {
      localStringBuilder = null;
      int j = 0;
      localObject = paramExoPlaybackException;
      paramExoPlaybackException = localStringBuilder;
      while ((localObject instanceof ExoPlaybackException))
      {
        paramExoPlaybackException = ((Throwable)localObject).getCause();
        localObject = (ExoPlaybackException)localObject;
        j = ((ExoPlaybackException)localObject).type + 100;
        i = j;
        if (j == 1) {
          i = j + ((ExoPlaybackException)localObject).rendererIndex;
        }
        localObject = paramExoPlaybackException;
        j = i;
      }
      i = k;
      if (paramExoPlaybackException != null) {
        if ((paramExoPlaybackException instanceof HttpDataSource.HttpDataSourceException))
        {
          j -= 4000;
          if (paramExoPlaybackException.toString().contains("Unable to connect"))
          {
            boolean bool = ExoMediaPlayerUtils.isNetworkAvailable(ExoMediaPlayer.access$2700(this.this$0));
            localObject = ExoMediaPlayer.getLogger();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ExoPlaybackException hasNetwork=");
            localStringBuilder.append(bool);
            localStringBuilder.append(" caused by:\n");
            localStringBuilder.append(paramExoPlaybackException.toString());
            ((ILogger)localObject).e("ExoMediaPlayer", localStringBuilder.toString());
            if (!bool)
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -2);
              return;
            }
            ExoMediaPlayer.access$2800(this.this$0, j, -3);
            return;
          }
          i = j;
          if ((paramExoPlaybackException instanceof HttpDataSource.InvalidResponseCodeException))
          {
            paramExoPlaybackException = paramExoPlaybackException.toString();
            if (paramExoPlaybackException.contains("403"))
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -10);
              return;
            }
            if (paramExoPlaybackException.contains("404"))
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -11);
              return;
            }
            if (paramExoPlaybackException.contains("500"))
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -12);
              return;
            }
            if (paramExoPlaybackException.contains("502"))
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -13);
              return;
            }
            ExoMediaPlayer.access$2800(this.this$0, j, -30);
          }
        }
        else
        {
          if ((paramExoPlaybackException instanceof UnrecognizedInputFormatException))
          {
            ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
            ExoMediaPlayer.access$2800(this.this$0, j - 4001, -1);
            return;
          }
          if ((paramExoPlaybackException instanceof IllegalStateException))
          {
            ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
            ExoMediaPlayer.access$2800(this.this$0, j - 4002, -1);
            return;
          }
          if ((paramExoPlaybackException instanceof MediaCodecRenderer.DecoderInitializationException))
          {
            ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
            ExoMediaPlayer.access$2800(this.this$0, j - 4003, -1);
            return;
          }
          i = k;
          if ((paramExoPlaybackException instanceof Loader.UnexpectedLoaderException))
          {
            ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
            ExoMediaPlayer.access$2800(this.this$0, j - 4004, -1);
            return;
          }
        }
      }
    }
    ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent(0, null, 30));
    ExoMediaPlayer.access$2800(this.this$0, i, -1);
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayerStateChanged playWhenReady=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",playbackState=");
    localStringBuilder.append(paramInt);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
    ExoMediaPlayer.access$2600(this.this$0);
  }
  
  public void onPositionDiscontinuity(int paramInt)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPositionDiscontinuity reason=");
    localStringBuilder.append(paramInt);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void onRepeatModeChanged(int paramInt)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRepeatModeChanged ");
    localStringBuilder.append(paramInt);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void onSeekProcessed()
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onSeekProcessed");
  }
  
  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
    ILogger localILogger = ExoMediaPlayer.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShuffleModeEnabledChanged shuffleModeEnabled=");
    localStringBuilder.append(paramBoolean);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt)
  {
    paramTimeline = ExoMediaPlayer.getLogger();
    paramObject = new StringBuilder();
    paramObject.append("onTimelineChanged reason=");
    paramObject.append(paramInt);
    paramTimeline.d("ExoMediaPlayer", paramObject.toString());
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onTracksChanged");
    if (ExoMediaPlayer.access$2500(this.this$0).size() > 0)
    {
      paramTrackGroupArray = ExoMediaPlayer.getLogger();
      paramTrackSelectionArray = new StringBuilder();
      paramTrackSelectionArray.append("update duration idx=");
      paramTrackSelectionArray.append(ExoMediaPlayer.access$700(this.this$0).getCurrentWindowIndex());
      paramTrackSelectionArray.append(",duration=");
      paramTrackSelectionArray.append(ExoMediaPlayer.access$700(this.this$0).getDuration());
      paramTrackGroupArray.d("ExoMediaPlayer", paramTrackSelectionArray.toString());
      ExoMediaPlayer.access$2500(this.this$0).set(ExoMediaPlayer.access$700(this.this$0).getCurrentWindowIndex(), Long.valueOf(ExoMediaPlayer.access$700(this.this$0).getDuration()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.Exo2EventListener
 * JD-Core Version:    0.7.0.1
 */