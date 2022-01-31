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
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onLoadingChanged " + paramBoolean);
    if (paramBoolean) {
      ExoMediaPlayer.access$2100(this.this$0, true);
    }
  }
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onPlaybackParametersChanged [" + paramPlaybackParameters.speed + "," + paramPlaybackParameters.pitch + "]");
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    if (ExoMediaPlayer.access$700(this.this$0) != null) {
      ExoMediaPlayer.access$2100(this.this$0, false);
    }
    ExoMediaPlayer.getLogger().e("ExoMediaPlayer", "ExoPlaybackException " + paramExoPlaybackException + "\n" + ExoMediaPlayerUtils.getPrintableStackTrace(paramExoPlaybackException));
    if (paramExoPlaybackException != null)
    {
      i = 0;
      Throwable localThrowable = null;
      int j;
      while ((paramExoPlaybackException instanceof ExoPlaybackException))
      {
        localThrowable = paramExoPlaybackException.getCause();
        j = ((ExoPlaybackException)paramExoPlaybackException).type + 100;
        i = j;
        if (j == 1) {
          i = j + ((ExoPlaybackException)paramExoPlaybackException).rendererIndex;
        }
        paramExoPlaybackException = localThrowable;
      }
      if (localThrowable != null)
      {
        if ((localThrowable instanceof HttpDataSource.HttpDataSourceException))
        {
          j = i - 4000;
          if (localThrowable.toString().contains("Unable to connect"))
          {
            boolean bool = ExoMediaPlayerUtils.isNetworkAvailable(ExoMediaPlayer.access$2700(this.this$0));
            ExoMediaPlayer.getLogger().e("ExoMediaPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + localThrowable.toString());
            if (!bool)
            {
              ExoMediaPlayer.access$2800(this.this$0, j, -2);
              return;
            }
            ExoMediaPlayer.access$2800(this.this$0, j, -3);
            return;
          }
          i = j;
          if (!(localThrowable instanceof HttpDataSource.InvalidResponseCodeException)) {
            break label497;
          }
          paramExoPlaybackException = localThrowable.toString();
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
          return;
        }
        if ((localThrowable instanceof UnrecognizedInputFormatException))
        {
          ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
          ExoMediaPlayer.access$2800(this.this$0, i - 4001, -1);
          return;
        }
        if ((localThrowable instanceof IllegalStateException))
        {
          ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
          ExoMediaPlayer.access$2800(this.this$0, i - 4002, -1);
          return;
        }
        if ((localThrowable instanceof MediaCodecRenderer.DecoderInitializationException))
        {
          ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
          ExoMediaPlayer.access$2800(this.this$0, i - 4003, -1);
          return;
        }
        if ((localThrowable instanceof Loader.UnexpectedLoaderException))
        {
          ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent());
          ExoMediaPlayer.access$2800(this.this$0, i - 4004, -1);
          return;
        }
      }
    }
    int i = -4999;
    label497:
    ExoMediaPlayer.getLogger().i("ExoMediaPlayer", ExoMediaPlayerUtils.getLogcatContent(0, null, 30));
    ExoMediaPlayer.access$2800(this.this$0, i, -1);
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onPlayerStateChanged playWhenReady=" + paramBoolean + ",playbackState=" + paramInt);
    ExoMediaPlayer.access$2600(this.this$0);
  }
  
  public void onPositionDiscontinuity(int paramInt)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onPositionDiscontinuity reason=" + paramInt);
  }
  
  public void onRepeatModeChanged(int paramInt)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onRepeatModeChanged " + paramInt);
  }
  
  public void onSeekProcessed()
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onSeekProcessed");
  }
  
  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onShuffleModeEnabledChanged shuffleModeEnabled=" + paramBoolean);
  }
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onTimelineChanged reason=" + paramInt);
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "onTracksChanged");
    if (ExoMediaPlayer.access$2500(this.this$0).size() > 0)
    {
      ExoMediaPlayer.getLogger().d("ExoMediaPlayer", "update duration idx=" + ExoMediaPlayer.access$700(this.this$0).getCurrentWindowIndex() + ",duration=" + ExoMediaPlayer.access$700(this.this$0).getDuration());
      ExoMediaPlayer.access$2500(this.this$0).set(ExoMediaPlayer.access$700(this.this$0).getCurrentWindowIndex(), Long.valueOf(ExoMediaPlayer.access$700(this.this$0).getDuration()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.Exo2EventListener
 * JD-Core Version:    0.7.0.1
 */