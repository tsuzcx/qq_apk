package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class ExoPlayerImpl
  implements ExoPlayer
{
  private static final String TAG = "ExoPlayerImpl";
  private final TrackSelectorResult emptyTrackSelectorResult;
  private final Handler eventHandler;
  private boolean hasPendingPrepare;
  private boolean hasPendingSeek;
  private final ExoPlayerImplInternal internalPlayer;
  private final Handler internalPlayerHandler;
  private final CopyOnWriteArraySet<Player.EventListener> listeners;
  private int maskingPeriodIndex;
  private int maskingWindowIndex;
  private long maskingWindowPositionMs;
  private int pendingOperationAcks;
  private final Timeline.Period period;
  private boolean playWhenReady;
  private PlaybackInfo playbackInfo;
  private PlaybackParameters playbackParameters;
  private final Renderer[] renderers;
  private int repeatMode;
  private boolean shuffleModeEnabled;
  private final TrackSelector trackSelector;
  private final Timeline.Window window;
  
  @SuppressLint({"HandlerLeak"})
  public ExoPlayerImpl(Renderer[] paramArrayOfRenderer, TrackSelector paramTrackSelector, LoadControl paramLoadControl, Clock paramClock)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init ");
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" [");
    ((StringBuilder)localObject).append("ExoPlayerLib/2.7.1");
    ((StringBuilder)localObject).append("] [");
    ((StringBuilder)localObject).append(Util.DEVICE_DEBUG_INFO);
    ((StringBuilder)localObject).append("]");
    Log.i("ExoPlayerImpl", ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramArrayOfRenderer.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    this.renderers = ((Renderer[])Assertions.checkNotNull(paramArrayOfRenderer));
    this.trackSelector = ((TrackSelector)Assertions.checkNotNull(paramTrackSelector));
    this.playWhenReady = false;
    this.repeatMode = 0;
    this.shuffleModeEnabled = false;
    this.listeners = new CopyOnWriteArraySet();
    this.emptyTrackSelectorResult = new TrackSelectorResult(TrackGroupArray.EMPTY, new boolean[paramArrayOfRenderer.length], new TrackSelectionArray(new TrackSelection[paramArrayOfRenderer.length]), null, new RendererConfiguration[paramArrayOfRenderer.length]);
    this.window = new Timeline.Window();
    this.period = new Timeline.Period();
    this.playbackParameters = PlaybackParameters.DEFAULT;
    if (Looper.myLooper() != null) {
      localObject = Looper.myLooper();
    } else {
      localObject = Looper.getMainLooper();
    }
    this.eventHandler = new ExoPlayerImpl.1(this, (Looper)localObject);
    this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, 0L, this.emptyTrackSelectorResult);
    this.internalPlayer = new ExoPlayerImplInternal(paramArrayOfRenderer, paramTrackSelector, this.emptyTrackSelectorResult, paramLoadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, this.eventHandler, this, paramClock);
    this.internalPlayerHandler = new Handler(this.internalPlayer.getPlaybackLooper());
  }
  
  private PlaybackInfo getResetPlaybackInfo(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean1)
    {
      this.maskingWindowIndex = 0;
      this.maskingPeriodIndex = 0;
      this.maskingWindowPositionMs = 0L;
    }
    else
    {
      this.maskingWindowIndex = getCurrentWindowIndex();
      this.maskingPeriodIndex = getCurrentPeriodIndex();
      this.maskingWindowPositionMs = getCurrentPosition();
    }
    Timeline localTimeline;
    if (paramBoolean2) {
      localTimeline = Timeline.EMPTY;
    } else {
      localTimeline = this.playbackInfo.timeline;
    }
    Object localObject;
    if (paramBoolean2) {
      localObject = null;
    } else {
      localObject = this.playbackInfo.manifest;
    }
    MediaSource.MediaPeriodId localMediaPeriodId = this.playbackInfo.periodId;
    long l1 = this.playbackInfo.startPositionUs;
    long l2 = this.playbackInfo.contentPositionUs;
    TrackSelectorResult localTrackSelectorResult;
    if (paramBoolean2) {
      localTrackSelectorResult = this.emptyTrackSelectorResult;
    } else {
      localTrackSelectorResult = this.playbackInfo.trackSelectorResult;
    }
    return new PlaybackInfo(localTimeline, localObject, localMediaPeriodId, l1, l2, paramInt, false, localTrackSelectorResult);
  }
  
  private void handlePlaybackInfo(PlaybackInfo paramPlaybackInfo, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.pendingOperationAcks -= paramInt1;
    if (this.pendingOperationAcks == 0)
    {
      PlaybackInfo localPlaybackInfo = paramPlaybackInfo;
      if (paramPlaybackInfo.startPositionUs == -9223372036854775807L) {
        localPlaybackInfo = paramPlaybackInfo.fromNewPosition(paramPlaybackInfo.periodId, 0L, paramPlaybackInfo.contentPositionUs);
      }
      if (((!this.playbackInfo.timeline.isEmpty()) || (this.hasPendingPrepare)) && (localPlaybackInfo.timeline.isEmpty()))
      {
        this.maskingPeriodIndex = 0;
        this.maskingWindowIndex = 0;
        this.maskingWindowPositionMs = 0L;
      }
      if (this.hasPendingPrepare) {
        paramInt1 = 0;
      } else {
        paramInt1 = 2;
      }
      boolean bool = this.hasPendingSeek;
      this.hasPendingPrepare = false;
      this.hasPendingSeek = false;
      updatePlaybackInfo(localPlaybackInfo, paramBoolean, paramInt2, paramInt1, bool);
    }
  }
  
  private long playbackInfoPositionUsToWindowPositionMs(long paramLong)
  {
    long l = C.usToMs(paramLong);
    paramLong = l;
    if (!this.playbackInfo.periodId.isAd())
    {
      this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period);
      paramLong = l + this.period.getPositionInWindowMs();
    }
    return paramLong;
  }
  
  private boolean shouldMaskPosition()
  {
    return (this.playbackInfo.timeline.isEmpty()) || (this.pendingOperationAcks > 0);
  }
  
  private void updatePlaybackInfo(PlaybackInfo paramPlaybackInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    Timeline localTimeline1 = this.playbackInfo.timeline;
    Timeline localTimeline2 = paramPlaybackInfo.timeline;
    int m = 0;
    int i;
    if ((localTimeline1 == localTimeline2) && (this.playbackInfo.manifest == paramPlaybackInfo.manifest)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if (this.playbackInfo.playbackState != paramPlaybackInfo.playbackState) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (this.playbackInfo.isLoading != paramPlaybackInfo.isLoading) {
      k = 1;
    } else {
      k = 0;
    }
    if (this.playbackInfo.trackSelectorResult != paramPlaybackInfo.trackSelectorResult) {
      m = 1;
    }
    this.playbackInfo = paramPlaybackInfo;
    if ((i != 0) || (paramInt2 == 0))
    {
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onTimelineChanged(this.playbackInfo.timeline, this.playbackInfo.manifest, paramInt2);
      }
    }
    if (paramBoolean1)
    {
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onPositionDiscontinuity(paramInt1);
      }
    }
    if (m != 0)
    {
      this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onTracksChanged(this.playbackInfo.trackSelectorResult.groups, this.playbackInfo.trackSelectorResult.selections);
      }
    }
    if (k != 0)
    {
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onLoadingChanged(this.playbackInfo.isLoading);
      }
    }
    if (j != 0)
    {
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
      }
    }
    if (paramBoolean2)
    {
      paramPlaybackInfo = this.listeners.iterator();
      while (paramPlaybackInfo.hasNext()) {
        ((Player.EventListener)paramPlaybackInfo.next()).onSeekProcessed();
      }
    }
  }
  
  public void addListener(Player.EventListener paramEventListener)
  {
    this.listeners.add(paramEventListener);
  }
  
  public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... paramVarArgs)
  {
    Object localObject = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ExoPlayer.ExoPlayerMessage localExoPlayerMessage = paramVarArgs[i];
      ((List)localObject).add(createMessage(localExoPlayerMessage.target).setType(localExoPlayerMessage.messageType).setPayload(localExoPlayerMessage.message).send());
      i += 1;
    }
    paramVarArgs = ((List)localObject).iterator();
    i = 0;
    while (paramVarArgs.hasNext())
    {
      localObject = (PlayerMessage)paramVarArgs.next();
      j = 1;
      while (j != 0)
      {
        try
        {
          ((PlayerMessage)localObject).blockUntilDelivered();
          j = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          label114:
          break label114;
        }
        i = 1;
      }
    }
    if (i != 0) {
      Thread.currentThread().interrupt();
    }
  }
  
  public PlayerMessage createMessage(PlayerMessage.Target paramTarget)
  {
    return new PlayerMessage(this.internalPlayer, paramTarget, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
  }
  
  public int getBufferedPercentage()
  {
    long l1 = getBufferedPosition();
    long l2 = getDuration();
    if ((l1 != -9223372036854775807L) && (l2 != -9223372036854775807L))
    {
      if (l2 == 0L) {
        return 100;
      }
      return Util.constrainValue((int)(l1 * 100L / l2), 0, 100);
    }
    return 0;
  }
  
  public long getBufferedPosition()
  {
    if (shouldMaskPosition()) {
      return this.maskingWindowPositionMs;
    }
    return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
  }
  
  public long getContentPosition()
  {
    if (isPlayingAd())
    {
      this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period);
      return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
    }
    return getCurrentPosition();
  }
  
  public int getCurrentAdGroupIndex()
  {
    if (isPlayingAd()) {
      return this.playbackInfo.periodId.adGroupIndex;
    }
    return -1;
  }
  
  public int getCurrentAdIndexInAdGroup()
  {
    if (isPlayingAd()) {
      return this.playbackInfo.periodId.adIndexInAdGroup;
    }
    return -1;
  }
  
  public Object getCurrentManifest()
  {
    return this.playbackInfo.manifest;
  }
  
  public int getCurrentPeriodIndex()
  {
    if (shouldMaskPosition()) {
      return this.maskingPeriodIndex;
    }
    return this.playbackInfo.periodId.periodIndex;
  }
  
  public long getCurrentPosition()
  {
    if (shouldMaskPosition()) {
      return this.maskingWindowPositionMs;
    }
    return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
  }
  
  public Timeline getCurrentTimeline()
  {
    return this.playbackInfo.timeline;
  }
  
  public TrackGroupArray getCurrentTrackGroups()
  {
    return this.playbackInfo.trackSelectorResult.groups;
  }
  
  public TrackSelectionArray getCurrentTrackSelections()
  {
    return this.playbackInfo.trackSelectorResult.selections;
  }
  
  public int getCurrentWindowIndex()
  {
    if (shouldMaskPosition()) {
      return this.maskingWindowIndex;
    }
    return this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period).windowIndex;
  }
  
  public long getDuration()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    if (localTimeline.isEmpty()) {
      return -9223372036854775807L;
    }
    if (isPlayingAd())
    {
      MediaSource.MediaPeriodId localMediaPeriodId = this.playbackInfo.periodId;
      localTimeline.getPeriod(localMediaPeriodId.periodIndex, this.period);
      return C.usToMs(this.period.getAdDurationUs(localMediaPeriodId.adGroupIndex, localMediaPeriodId.adIndexInAdGroup));
    }
    return localTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
  }
  
  public int getNextWindowIndex()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    if (localTimeline.isEmpty()) {
      return -1;
    }
    return localTimeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
  }
  
  public boolean getPlayWhenReady()
  {
    return this.playWhenReady;
  }
  
  public Looper getPlaybackLooper()
  {
    return this.internalPlayer.getPlaybackLooper();
  }
  
  public PlaybackParameters getPlaybackParameters()
  {
    return this.playbackParameters;
  }
  
  public int getPlaybackState()
  {
    return this.playbackInfo.playbackState;
  }
  
  public int getPreviousWindowIndex()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    if (localTimeline.isEmpty()) {
      return -1;
    }
    return localTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
  }
  
  public int getRendererCount()
  {
    return this.renderers.length;
  }
  
  public int getRendererType(int paramInt)
  {
    return this.renderers[paramInt].getTrackType();
  }
  
  public int getRepeatMode()
  {
    return this.repeatMode;
  }
  
  public boolean getShuffleModeEnabled()
  {
    return this.shuffleModeEnabled;
  }
  
  public Player.TextComponent getTextComponent()
  {
    return null;
  }
  
  public Player.VideoComponent getVideoComponent()
  {
    return null;
  }
  
  void handleEvent(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = true;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          paramMessage = (ExoPlaybackException)paramMessage.obj;
          localObject = this.listeners.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Player.EventListener)((Iterator)localObject).next()).onPlayerError(paramMessage);
          }
        }
        throw new IllegalStateException();
      }
      paramMessage = (PlaybackParameters)paramMessage.obj;
      if (!this.playbackParameters.equals(paramMessage))
      {
        this.playbackParameters = paramMessage;
        localObject = this.listeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Player.EventListener)((Iterator)localObject).next()).onPlaybackParametersChanged(paramMessage);
        }
      }
    }
    else
    {
      localObject = (PlaybackInfo)paramMessage.obj;
      i = paramMessage.arg1;
      if (paramMessage.arg2 == -1) {
        bool = false;
      }
      handlePlaybackInfo((PlaybackInfo)localObject, i, bool, paramMessage.arg2);
    }
  }
  
  public boolean isCurrentWindowDynamic()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    return (!localTimeline.isEmpty()) && (localTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic);
  }
  
  public boolean isCurrentWindowSeekable()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    return (!localTimeline.isEmpty()) && (localTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable);
  }
  
  public boolean isLoading()
  {
    return this.playbackInfo.isLoading;
  }
  
  public boolean isPlayingAd()
  {
    return (!shouldMaskPosition()) && (this.playbackInfo.periodId.isAd());
  }
  
  public void prepare(MediaSource paramMediaSource)
  {
    prepare(paramMediaSource, true, true);
  }
  
  public void prepare(MediaSource paramMediaSource, boolean paramBoolean1, boolean paramBoolean2)
  {
    PlaybackInfo localPlaybackInfo = getResetPlaybackInfo(paramBoolean1, paramBoolean2, 2);
    this.hasPendingPrepare = true;
    this.pendingOperationAcks += 1;
    this.internalPlayer.prepare(paramMediaSource, paramBoolean1, paramBoolean2);
    updatePlaybackInfo(localPlaybackInfo, false, 4, 1, false);
  }
  
  public void release()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Release ");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" [");
    localStringBuilder.append("ExoPlayerLib/2.7.1");
    localStringBuilder.append("] [");
    localStringBuilder.append(Util.DEVICE_DEBUG_INFO);
    localStringBuilder.append("] [");
    localStringBuilder.append(ExoPlayerLibraryInfo.registeredModules());
    localStringBuilder.append("]");
    Log.i("ExoPlayerImpl", localStringBuilder.toString());
    this.internalPlayer.release();
    this.eventHandler.removeCallbacksAndMessages(null);
  }
  
  public void removeListener(Player.EventListener paramEventListener)
  {
    this.listeners.remove(paramEventListener);
  }
  
  public void seekTo(int paramInt, long paramLong)
  {
    Object localObject = this.playbackInfo.timeline;
    if ((paramInt >= 0) && ((((Timeline)localObject).isEmpty()) || (paramInt < ((Timeline)localObject).getWindowCount())))
    {
      this.hasPendingSeek = true;
      this.pendingOperationAcks += 1;
      if (isPlayingAd())
      {
        Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
        this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
        return;
      }
      this.maskingWindowIndex = paramInt;
      long l;
      if (((Timeline)localObject).isEmpty())
      {
        if (paramLong == -9223372036854775807L) {
          l = 0L;
        } else {
          l = paramLong;
        }
        this.maskingWindowPositionMs = l;
        this.maskingPeriodIndex = 0;
      }
      else
      {
        if (paramLong == -9223372036854775807L) {
          l = ((Timeline)localObject).getWindow(paramInt, this.window).getDefaultPositionUs();
        } else {
          l = C.msToUs(paramLong);
        }
        Pair localPair = ((Timeline)localObject).getPeriodPosition(this.window, this.period, paramInt, l);
        this.maskingWindowPositionMs = C.usToMs(l);
        this.maskingPeriodIndex = ((Integer)localPair.first).intValue();
      }
      this.internalPlayer.seekTo((Timeline)localObject, paramInt, C.msToUs(paramLong));
      localObject = this.listeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Player.EventListener)((Iterator)localObject).next()).onPositionDiscontinuity(1);
      }
      return;
    }
    localObject = new IllegalSeekPositionException((Timeline)localObject, paramInt, paramLong);
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void seekTo(long paramLong)
  {
    seekTo(getCurrentWindowIndex(), paramLong);
  }
  
  public void seekToDefaultPosition()
  {
    seekToDefaultPosition(getCurrentWindowIndex());
  }
  
  public void seekToDefaultPosition(int paramInt)
  {
    seekTo(paramInt, -9223372036854775807L);
  }
  
  public void sendMessages(ExoPlayer.ExoPlayerMessage... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ExoPlayer.ExoPlayerMessage localExoPlayerMessage = paramVarArgs[i];
      createMessage(localExoPlayerMessage.target).setType(localExoPlayerMessage.messageType).setPayload(localExoPlayerMessage.message).send();
      i += 1;
    }
  }
  
  public void setPlayWhenReady(boolean paramBoolean)
  {
    if (this.playWhenReady != paramBoolean)
    {
      this.playWhenReady = paramBoolean;
      this.internalPlayer.setPlayWhenReady(paramBoolean);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((Player.EventListener)localIterator.next()).onPlayerStateChanged(paramBoolean, this.playbackInfo.playbackState);
      }
    }
  }
  
  public void setPlaybackParameters(@Nullable PlaybackParameters paramPlaybackParameters)
  {
    PlaybackParameters localPlaybackParameters = paramPlaybackParameters;
    if (paramPlaybackParameters == null) {
      localPlaybackParameters = PlaybackParameters.DEFAULT;
    }
    this.internalPlayer.setPlaybackParameters(localPlaybackParameters);
  }
  
  public void setRepeatMode(int paramInt)
  {
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.internalPlayer.setRepeatMode(paramInt);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((Player.EventListener)localIterator.next()).onRepeatModeChanged(paramInt);
      }
    }
  }
  
  public void setSeekParameters(@Nullable SeekParameters paramSeekParameters)
  {
    SeekParameters localSeekParameters = paramSeekParameters;
    if (paramSeekParameters == null) {
      localSeekParameters = SeekParameters.DEFAULT;
    }
    this.internalPlayer.setSeekParameters(localSeekParameters);
  }
  
  public void setShuffleModeEnabled(boolean paramBoolean)
  {
    if (this.shuffleModeEnabled != paramBoolean)
    {
      this.shuffleModeEnabled = paramBoolean;
      this.internalPlayer.setShuffleModeEnabled(paramBoolean);
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext()) {
        ((Player.EventListener)localIterator.next()).onShuffleModeEnabledChanged(paramBoolean);
      }
    }
  }
  
  public void stop()
  {
    stop(false);
  }
  
  public void stop(boolean paramBoolean)
  {
    PlaybackInfo localPlaybackInfo = getResetPlaybackInfo(paramBoolean, paramBoolean, 1);
    this.pendingOperationAcks += 1;
    this.internalPlayer.stop(paramBoolean);
    updatePlaybackInfo(localPlaybackInfo, false, 4, 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImpl
 * JD-Core Version:    0.7.0.1
 */