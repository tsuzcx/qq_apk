package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

final class DefaultMediaClock
  implements MediaClock
{
  private final DefaultMediaClock.PlaybackParameterListener listener;
  @Nullable
  private MediaClock rendererClock;
  @Nullable
  private Renderer rendererClockSource;
  private final StandaloneMediaClock standaloneMediaClock;
  
  public DefaultMediaClock(DefaultMediaClock.PlaybackParameterListener paramPlaybackParameterListener, Clock paramClock)
  {
    this.listener = paramPlaybackParameterListener;
    this.standaloneMediaClock = new StandaloneMediaClock(paramClock);
  }
  
  private void ensureSynced()
  {
    long l = this.rendererClock.getPositionUs();
    this.standaloneMediaClock.resetPosition(l);
    PlaybackParameters localPlaybackParameters = this.rendererClock.getPlaybackParameters();
    if (!localPlaybackParameters.equals(this.standaloneMediaClock.getPlaybackParameters()))
    {
      this.standaloneMediaClock.setPlaybackParameters(localPlaybackParameters);
      this.listener.onPlaybackParametersChanged(localPlaybackParameters);
    }
  }
  
  private boolean isUsingRendererClock()
  {
    return (this.rendererClockSource != null) && (!this.rendererClockSource.isEnded()) && ((this.rendererClockSource.isReady()) || (!this.rendererClockSource.hasReadStreamToEnd()));
  }
  
  public PlaybackParameters getPlaybackParameters()
  {
    if (this.rendererClock != null) {
      return this.rendererClock.getPlaybackParameters();
    }
    return this.standaloneMediaClock.getPlaybackParameters();
  }
  
  public long getPositionUs()
  {
    if (isUsingRendererClock()) {
      return this.rendererClock.getPositionUs();
    }
    return this.standaloneMediaClock.getPositionUs();
  }
  
  public void onRendererDisabled(Renderer paramRenderer)
  {
    if (paramRenderer == this.rendererClockSource)
    {
      this.rendererClock = null;
      this.rendererClockSource = null;
    }
  }
  
  public void onRendererEnabled(Renderer paramRenderer)
  {
    MediaClock localMediaClock = paramRenderer.getMediaClock();
    if ((localMediaClock != null) && (localMediaClock != this.rendererClock))
    {
      if (this.rendererClock != null) {
        throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
      }
      this.rendererClock = localMediaClock;
      this.rendererClockSource = paramRenderer;
      this.rendererClock.setPlaybackParameters(this.standaloneMediaClock.getPlaybackParameters());
      ensureSynced();
    }
  }
  
  public void resetPosition(long paramLong)
  {
    this.standaloneMediaClock.resetPosition(paramLong);
  }
  
  public PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters)
  {
    PlaybackParameters localPlaybackParameters = paramPlaybackParameters;
    if (this.rendererClock != null) {
      localPlaybackParameters = this.rendererClock.setPlaybackParameters(paramPlaybackParameters);
    }
    this.standaloneMediaClock.setPlaybackParameters(localPlaybackParameters);
    this.listener.onPlaybackParametersChanged(localPlaybackParameters);
    return localPlaybackParameters;
  }
  
  public void start()
  {
    this.standaloneMediaClock.start();
  }
  
  public void stop()
  {
    this.standaloneMediaClock.stop();
  }
  
  public long syncAndGetPositionUs()
  {
    if (isUsingRendererClock())
    {
      ensureSynced();
      return this.rendererClock.getPositionUs();
    }
    return this.standaloneMediaClock.getPositionUs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.DefaultMediaClock
 * JD-Core Version:    0.7.0.1
 */