package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod.Callback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.SimpleHandlerThread;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

final class ExoPlayerImplInternal
  implements Handler.Callback, DefaultMediaClock.PlaybackParameterListener, PlayerMessage.Sender, MediaPeriod.Callback, MediaSource.Listener, TrackSelector.InvalidationListener
{
  private static final int IDLE_INTERVAL_MS = 1000;
  private static final int MSG_DO_SOME_WORK = 2;
  public static final int MSG_ERROR = 2;
  private static final int MSG_PERIOD_PREPARED = 9;
  public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
  public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
  private static final int MSG_PREPARE = 0;
  private static final int MSG_REFRESH_SOURCE_INFO = 8;
  private static final int MSG_RELEASE = 7;
  private static final int MSG_SEEK_TO = 3;
  private static final int MSG_SEND_MESSAGE = 14;
  private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
  private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
  private static final int MSG_SET_PLAY_WHEN_READY = 1;
  private static final int MSG_SET_REPEAT_MODE = 12;
  private static final int MSG_SET_SEEK_PARAMETERS = 5;
  private static final int MSG_SET_SHUFFLE_ENABLED = 13;
  private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
  private static final int MSG_STOP = 6;
  private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
  private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
  private static final int RENDERER_TIMESTAMP_OFFSET_US = 60000000;
  private static final int RENDERING_INTERVAL_MS = 10;
  private static final String TAG = "ExoPlayerImplInternal";
  private final long backBufferDurationUs;
  private final Clock clock;
  private final TrackSelectorResult emptyTrackSelectorResult;
  private Renderer[] enabledRenderers;
  private final Handler eventHandler;
  private final HandlerWrapper handler;
  private final HandlerThread internalPlaybackThread;
  private final LoadControl loadControl;
  private HashMap<Renderer, SimpleHandlerThread> mRenderHandlerThreadMap = null;
  private final DefaultMediaClock mediaClock;
  private MediaSource mediaSource;
  private int nextPendingMessageIndex;
  private boolean parallelRender = true;
  private ExoPlayerImplInternal.SeekPosition pendingInitialSeekPosition;
  private final ArrayList<ExoPlayerImplInternal.PendingMessageInfo> pendingMessages;
  private int pendingPrepareCount;
  private final Timeline.Period period;
  private boolean playWhenReady;
  private PlaybackInfo playbackInfo;
  private final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate;
  private final ExoPlayer player;
  private final MediaPeriodQueue queue;
  private boolean rebuffering;
  private boolean released;
  private final RendererCapabilities[] rendererCapabilities;
  private long rendererPositionUs;
  private final Renderer[] renderers;
  private int repeatMode;
  private final boolean retainBackBufferFromKeyframe;
  private SeekParameters seekParameters;
  private boolean shuffleModeEnabled;
  private final TrackSelector trackSelector;
  private final Timeline.Window window;
  
  public ExoPlayerImplInternal(Renderer[] paramArrayOfRenderer, TrackSelector paramTrackSelector, TrackSelectorResult paramTrackSelectorResult, LoadControl paramLoadControl, boolean paramBoolean1, int paramInt, boolean paramBoolean2, Handler paramHandler, ExoPlayer paramExoPlayer, Clock paramClock)
  {
    this.renderers = paramArrayOfRenderer;
    this.trackSelector = paramTrackSelector;
    this.emptyTrackSelectorResult = paramTrackSelectorResult;
    this.loadControl = paramLoadControl;
    this.playWhenReady = paramBoolean1;
    this.repeatMode = paramInt;
    this.shuffleModeEnabled = paramBoolean2;
    this.eventHandler = paramHandler;
    this.player = paramExoPlayer;
    this.clock = paramClock;
    this.queue = new MediaPeriodQueue();
    this.backBufferDurationUs = paramLoadControl.getBackBufferDurationUs();
    this.retainBackBufferFromKeyframe = paramLoadControl.retainBackBufferFromKeyframe();
    this.seekParameters = SeekParameters.DEFAULT;
    this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, -9223372036854775807L, paramTrackSelectorResult);
    this.playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(null);
    this.rendererCapabilities = new RendererCapabilities[paramArrayOfRenderer.length];
    paramInt = 0;
    while (paramInt < paramArrayOfRenderer.length)
    {
      paramArrayOfRenderer[paramInt].setIndex(paramInt);
      this.rendererCapabilities[paramInt] = paramArrayOfRenderer[paramInt].getCapabilities();
      paramInt += 1;
    }
    this.mediaClock = new DefaultMediaClock(this, paramClock);
    this.pendingMessages = new ArrayList();
    this.enabledRenderers = new Renderer[0];
    this.window = new Timeline.Window();
    this.period = new Timeline.Period();
    paramTrackSelector.init(this);
    this.internalPlaybackThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.internalPlaybackThread.start();
    this.handler = paramClock.createHandler(this.internalPlaybackThread.getLooper(), this);
  }
  
  private void deliverMessage(PlayerMessage paramPlayerMessage)
  {
    try
    {
      paramPlayerMessage.getTarget().handleMessage(paramPlayerMessage.getType(), paramPlayerMessage.getPayload());
      return;
    }
    finally
    {
      paramPlayerMessage.markAsProcessed(true);
    }
  }
  
  private void disableParallelRender()
  {
    if (this.parallelRender)
    {
      this.parallelRender = false;
      Iterator localIterator = this.mRenderHandlerThreadMap.values().iterator();
      while (localIterator.hasNext()) {
        ((SimpleHandlerThread)localIterator.next()).quit();
      }
      this.mRenderHandlerThreadMap.clear();
    }
  }
  
  private void disableRenderer(Renderer paramRenderer)
  {
    this.mediaClock.onRendererDisabled(paramRenderer);
    ensureStopped(paramRenderer);
    paramRenderer.disable();
  }
  
  private void doSomeWork()
  {
    long l1 = this.clock.uptimeMillis();
    updatePeriods();
    if (!this.queue.hasPlayingPeriod())
    {
      maybeThrowPeriodPrepareError();
      scheduleNextWork(l1, 10L);
      return;
    }
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    TraceUtil.beginSection("doSomeWork");
    updatePlaybackPositions();
    long l2 = SystemClock.elapsedRealtime() * 1000L;
    localMediaPeriodHolder.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
    SimpleHandlerThread localSimpleHandlerThread;
    label372:
    boolean bool;
    if ((this.parallelRender) && (this.playbackInfo.playbackState != 3))
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(this.enabledRenderers.length);
      ExoPlayerImplInternal.RendererRunnable[] arrayOfRendererRunnable = new ExoPlayerImplInternal.RendererRunnable[this.enabledRenderers.length];
      Renderer[] arrayOfRenderer2 = this.enabledRenderers;
      k = arrayOfRenderer2.length;
      j = 0;
      i = 0;
      Object localObject;
      while (j < k)
      {
        Renderer localRenderer = arrayOfRenderer2[j];
        ExoPlayerImplInternal.RendererRunnable localRendererRunnable = new ExoPlayerImplInternal.RendererRunnable(this, localRenderer, this.rendererPositionUs, l2, localCountDownLatch);
        arrayOfRendererRunnable[i] = localRendererRunnable;
        if (this.mRenderHandlerThreadMap == null) {
          this.mRenderHandlerThreadMap = new HashMap();
        }
        localSimpleHandlerThread = (SimpleHandlerThread)this.mRenderHandlerThreadMap.get(localRenderer);
        localObject = localSimpleHandlerThread;
        if (localSimpleHandlerThread == null)
        {
          localObject = new SimpleHandlerThread("TrackRender-" + localRenderer.getTrackType(), -16);
          ((SimpleHandlerThread)localObject).start();
          this.mRenderHandlerThreadMap.put(localRenderer, localObject);
        }
        ((SimpleHandlerThread)localObject).postJob(localRendererRunnable);
        j += 1;
        i += 1;
      }
      try
      {
        localCountDownLatch.await();
        i1 = arrayOfRendererRunnable.length;
        k = 0;
        i = 1;
        j = 1;
        m = j;
        n = i;
        if (k >= i1) {
          break label568;
        }
        localObject = arrayOfRendererRunnable[k];
        if (((ExoPlayerImplInternal.RendererRunnable)localObject).getExceptionThrown() != null) {
          throw ((ExoPlayerImplInternal.RendererRunnable)localObject).getExceptionThrown();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
        }
        if (j == 0) {
          break label412;
        }
      }
      if (localInterruptedException.isEnded())
      {
        j = 1;
        bool = localInterruptedException.rendererReadyOrEnded();
        if (!bool) {
          localInterruptedException.getRenderer().maybeThrowStreamError();
        }
        if ((i == 0) || (!bool)) {
          break label417;
        }
      }
      label412:
      label417:
      for (i = 1;; i = 0)
      {
        k += 1;
        break;
        j = 0;
        break label372;
      }
    }
    disableParallelRender();
    Renderer[] arrayOfRenderer1 = this.enabledRenderers;
    int i1 = arrayOfRenderer1.length;
    int k = 0;
    int i = 1;
    int j = 1;
    int m = j;
    int n = i;
    if (k < i1)
    {
      localSimpleHandlerThread = arrayOfRenderer1[k];
      localSimpleHandlerThread.render(this.rendererPositionUs, l2);
      if ((j != 0) && (localSimpleHandlerThread.isEnded()))
      {
        j = 1;
        label490:
        if ((!localSimpleHandlerThread.isReady()) && (!localSimpleHandlerThread.isEnded()) && (!rendererWaitingForNextStream(localSimpleHandlerThread))) {
          break label557;
        }
        m = 1;
        label522:
        if (m == 0) {
          localSimpleHandlerThread.maybeThrowStreamError();
        }
        if ((i == 0) || (m == 0)) {
          break label563;
        }
      }
      label557:
      label563:
      for (i = 1;; i = 0)
      {
        k += 1;
        break;
        j = 0;
        break label490;
        m = 0;
        break label522;
      }
    }
    label568:
    if (n == 0) {
      maybeThrowPeriodPrepareError();
    }
    l2 = localMediaPeriodHolder.info.durationUs;
    if ((m != 0) && ((l2 == -9223372036854775807L) || (l2 <= this.playbackInfo.positionUs)) && (localMediaPeriodHolder.info.isFinal))
    {
      setState(4);
      stopRenderers();
    }
    while (this.playbackInfo.playbackState == 2)
    {
      arrayOfRenderer1 = this.enabledRenderers;
      j = arrayOfRenderer1.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          arrayOfRenderer1[i].maybeThrowStreamError();
          i += 1;
          continue;
          if (this.playbackInfo.playbackState == 2)
          {
            if ((this.parallelRender) || (n != 0)) {}
            for (bool = true;; bool = false)
            {
              if (!shouldTransitionToReadyState(bool)) {
                break label738;
              }
              setState(3);
              if (!this.playWhenReady) {
                break;
              }
              startRenderers();
              break;
            }
          }
          label738:
          if (this.playbackInfo.playbackState != 3) {
            break;
          }
          if (this.enabledRenderers.length == 0) {
            if (isTimelineReady()) {
              break;
            }
          }
          for (;;)
          {
            this.rebuffering = this.playWhenReady;
            setState(2);
            stopRenderers();
            break;
            if (n != 0) {
              break;
            }
          }
        }
      }
    }
    if (((this.playWhenReady) && (this.playbackInfo.playbackState == 3)) || (this.playbackInfo.playbackState == 2)) {
      scheduleNextWork(l1, 10L);
    }
    for (;;)
    {
      TraceUtil.endSection();
      return;
      if ((this.enabledRenderers.length != 0) && (this.playbackInfo.playbackState != 4)) {
        scheduleNextWork(l1, 1000L);
      } else {
        this.handler.removeMessages(2);
      }
    }
  }
  
  private void enableRenderer(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    boolean bool = true;
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    Renderer localRenderer = this.renderers[paramInt1];
    this.enabledRenderers[paramInt2] = localRenderer;
    RendererConfiguration localRendererConfiguration;
    Format[] arrayOfFormat;
    if (localRenderer.getState() == 0)
    {
      localRendererConfiguration = localMediaPeriodHolder.trackSelectorResult.rendererConfigurations[paramInt1];
      arrayOfFormat = getFormats(localMediaPeriodHolder.trackSelectorResult.selections.get(paramInt1));
      if ((!this.playWhenReady) || (this.playbackInfo.playbackState != 3)) {
        break label147;
      }
      paramInt2 = 1;
      if ((paramBoolean) || (paramInt2 == 0)) {
        break label152;
      }
    }
    label147:
    label152:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localRenderer.enable(localRendererConfiguration, arrayOfFormat, localMediaPeriodHolder.sampleStreams[paramInt1], this.rendererPositionUs, paramBoolean, localMediaPeriodHolder.getRendererOffset());
      this.mediaClock.onRendererEnabled(localRenderer);
      if (paramInt2 != 0) {
        localRenderer.start();
      }
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  private void enableRenderers(boolean[] paramArrayOfBoolean, int paramInt)
  {
    int j = 0;
    this.enabledRenderers = new Renderer[paramInt];
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    int i = 0;
    paramInt = j;
    while (paramInt < this.renderers.length)
    {
      j = i;
      if (localMediaPeriodHolder.trackSelectorResult.renderersEnabled[paramInt] != 0)
      {
        enableRenderer(paramInt, paramArrayOfBoolean[paramInt], i);
        j = i + 1;
      }
      paramInt += 1;
      i = j;
    }
  }
  
  private void ensureStopped(Renderer paramRenderer)
  {
    if (paramRenderer.getState() == 2) {
      paramRenderer.stop();
    }
  }
  
  private int getFirstPeriodIndex()
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    if (localTimeline.isEmpty()) {
      return 0;
    }
    return localTimeline.getWindow(localTimeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
  }
  
  @NonNull
  private static Format[] getFormats(TrackSelection paramTrackSelection)
  {
    int j = 0;
    if (paramTrackSelection != null) {}
    Format[] arrayOfFormat;
    for (int i = paramTrackSelection.length();; i = 0)
    {
      arrayOfFormat = new Format[i];
      while (j < i)
      {
        arrayOfFormat[j] = paramTrackSelection.getFormat(j);
        j += 1;
      }
    }
    return arrayOfFormat;
  }
  
  private Pair<Integer, Long> getPeriodPosition(Timeline paramTimeline, int paramInt, long paramLong)
  {
    return paramTimeline.getPeriodPosition(this.window, this.period, paramInt, paramLong);
  }
  
  private void handleContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    if (!this.queue.isLoading(paramMediaPeriod)) {
      return;
    }
    this.queue.reevaluateBuffer(this.rendererPositionUs);
    maybeContinueLoading();
  }
  
  private void handlePeriodPrepared(MediaPeriod paramMediaPeriod)
  {
    if (!this.queue.isLoading(paramMediaPeriod)) {
      return;
    }
    updateLoadControlTrackSelection(this.queue.handleLoadingPeriodPrepared(this.mediaClock.getPlaybackParameters().speed));
    if (!this.queue.hasPlayingPeriod())
    {
      resetRendererPosition(this.queue.advancePlayingPeriod().info.startPositionUs);
      updatePlayingPeriodRenderers(null);
    }
    maybeContinueLoading();
  }
  
  private void handleSourceInfoRefreshEndedPlayback()
  {
    setState(4);
    resetInternal(false, true, false);
  }
  
  private void handleSourceInfoRefreshed(ExoPlayerImplInternal.MediaSourceRefreshInfo paramMediaSourceRefreshInfo)
  {
    long l1 = 0L;
    if (paramMediaSourceRefreshInfo.source != this.mediaSource) {}
    label654:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return;
          localObject3 = this.playbackInfo.timeline;
          localObject2 = paramMediaSourceRefreshInfo.timeline;
          paramMediaSourceRefreshInfo = paramMediaSourceRefreshInfo.manifest;
          this.queue.setTimeline((Timeline)localObject2);
          this.playbackInfo = this.playbackInfo.copyWithTimeline((Timeline)localObject2, paramMediaSourceRefreshInfo);
          resolvePendingMessagePositions();
          if (this.pendingPrepareCount <= 0) {
            break;
          }
          this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount);
          this.pendingPrepareCount = 0;
          if (this.pendingInitialSeekPosition != null)
          {
            paramMediaSourceRefreshInfo = resolveSeekPosition(this.pendingInitialSeekPosition, true);
            this.pendingInitialSeekPosition = null;
            if (paramMediaSourceRefreshInfo == null)
            {
              handleSourceInfoRefreshEndedPlayback();
              return;
            }
            i = ((Integer)paramMediaSourceRefreshInfo.first).intValue();
            l2 = ((Long)paramMediaSourceRefreshInfo.second).longValue();
            paramMediaSourceRefreshInfo = this.queue.resolveMediaPeriodIdForAds(i, l2);
            localObject1 = this.playbackInfo;
            if (paramMediaSourceRefreshInfo.isAd()) {}
            for (;;)
            {
              this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
              return;
              l1 = l2;
            }
          }
        } while (this.playbackInfo.startPositionUs != -9223372036854775807L);
        if (((Timeline)localObject2).isEmpty())
        {
          handleSourceInfoRefreshEndedPlayback();
          return;
        }
        paramMediaSourceRefreshInfo = getPeriodPosition((Timeline)localObject2, ((Timeline)localObject2).getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        i = ((Integer)paramMediaSourceRefreshInfo.first).intValue();
        l2 = ((Long)paramMediaSourceRefreshInfo.second).longValue();
        paramMediaSourceRefreshInfo = this.queue.resolveMediaPeriodIdForAds(i, l2);
        localObject1 = this.playbackInfo;
        if (paramMediaSourceRefreshInfo.isAd()) {}
        for (;;)
        {
          this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
          return;
          l1 = l2;
        }
        i = this.playbackInfo.periodId.periodIndex;
        l2 = this.playbackInfo.contentPositionUs;
        if (!((Timeline)localObject3).isEmpty()) {
          break;
        }
      } while (((Timeline)localObject2).isEmpty());
      paramMediaSourceRefreshInfo = this.queue.resolveMediaPeriodIdForAds(i, l2);
      Object localObject1 = this.playbackInfo;
      if (paramMediaSourceRefreshInfo.isAd()) {}
      for (;;)
      {
        this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
        return;
        l1 = l2;
      }
      localObject1 = this.queue.getFrontPeriod();
      if (localObject1 == null) {}
      int j;
      for (paramMediaSourceRefreshInfo = ((Timeline)localObject3).getPeriod(i, this.period, true).uid;; paramMediaSourceRefreshInfo = ((MediaPeriodHolder)localObject1).uid)
      {
        j = ((Timeline)localObject2).getIndexOfPeriod(paramMediaSourceRefreshInfo);
        if (j != -1) {
          break label654;
        }
        i = resolveSubsequentPeriod(i, (Timeline)localObject3, (Timeline)localObject2);
        if (i != -1) {
          break;
        }
        handleSourceInfoRefreshEndedPlayback();
        return;
      }
      paramMediaSourceRefreshInfo = getPeriodPosition((Timeline)localObject2, ((Timeline)localObject2).getPeriod(i, this.period).windowIndex, -9223372036854775807L);
      int i = ((Integer)paramMediaSourceRefreshInfo.first).intValue();
      long l2 = ((Long)paramMediaSourceRefreshInfo.second).longValue();
      Object localObject3 = this.queue.resolveMediaPeriodIdForAds(i, l2);
      ((Timeline)localObject2).getPeriod(i, this.period, true);
      if (localObject1 != null)
      {
        localObject2 = this.period.uid;
        ((MediaPeriodHolder)localObject1).info = ((MediaPeriodHolder)localObject1).info.copyWithPeriodIndex(-1);
        paramMediaSourceRefreshInfo = (ExoPlayerImplInternal.MediaSourceRefreshInfo)localObject1;
        while (paramMediaSourceRefreshInfo.next != null)
        {
          paramMediaSourceRefreshInfo = paramMediaSourceRefreshInfo.next;
          if (paramMediaSourceRefreshInfo.uid.equals(localObject2)) {
            paramMediaSourceRefreshInfo.info = this.queue.getUpdatedMediaPeriodInfo(paramMediaSourceRefreshInfo.info, i);
          } else {
            paramMediaSourceRefreshInfo.info = paramMediaSourceRefreshInfo.info.copyWithPeriodIndex(-1);
          }
        }
      }
      if (((MediaSource.MediaPeriodId)localObject3).isAd()) {}
      for (;;)
      {
        l1 = seekToPeriodPosition((MediaSource.MediaPeriodId)localObject3, l1);
        this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject3, l1, l2);
        return;
        l1 = l2;
      }
      if (j != i) {
        this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(j);
      }
      paramMediaSourceRefreshInfo = this.playbackInfo.periodId;
      if (paramMediaSourceRefreshInfo.isAd())
      {
        localObject1 = this.queue.resolveMediaPeriodIdForAds(j, l2);
        if (!((MediaSource.MediaPeriodId)localObject1).equals(paramMediaSourceRefreshInfo))
        {
          if (((MediaSource.MediaPeriodId)localObject1).isAd()) {}
          for (;;)
          {
            l1 = seekToPeriodPosition((MediaSource.MediaPeriodId)localObject1, l1);
            this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject1, l1, l2);
            return;
            l1 = l2;
          }
        }
      }
    } while (this.queue.updateQueuedPeriods(paramMediaSourceRefreshInfo, this.rendererPositionUs));
    seekToCurrentPosition(false);
  }
  
  private boolean isTimelineReady()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    long l = localMediaPeriodHolder.info.durationUs;
    return (l == -9223372036854775807L) || (this.playbackInfo.positionUs < l) || ((localMediaPeriodHolder.next != null) && ((localMediaPeriodHolder.next.prepared) || (localMediaPeriodHolder.next.info.id.isAd())));
  }
  
  private void maybeContinueLoading()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getLoadingPeriod();
    long l1 = localMediaPeriodHolder.getNextLoadPositionUs();
    if (l1 == -9223372036854775808L) {
      setIsLoading(false);
    }
    boolean bool;
    do
    {
      return;
      long l2 = localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs);
      bool = this.loadControl.shouldContinueLoading(l1 - l2, this.mediaClock.getPlaybackParameters().speed);
      setIsLoading(bool);
    } while (!bool);
    localMediaPeriodHolder.continueLoading(this.rendererPositionUs);
  }
  
  private void maybeNotifyPlaybackInfoChanged()
  {
    Handler localHandler;
    int j;
    if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo))
    {
      localHandler = this.eventHandler;
      j = ExoPlayerImplInternal.PlaybackInfoUpdate.access$100(this.playbackInfoUpdate);
      if (!ExoPlayerImplInternal.PlaybackInfoUpdate.access$200(this.playbackInfoUpdate)) {
        break label71;
      }
    }
    label71:
    for (int i = ExoPlayerImplInternal.PlaybackInfoUpdate.access$300(this.playbackInfoUpdate);; i = -1)
    {
      localHandler.obtainMessage(0, j, i, this.playbackInfo).sendToTarget();
      this.playbackInfoUpdate.reset(this.playbackInfo);
      return;
    }
  }
  
  private void maybeThrowPeriodPrepareError()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getLoadingPeriod();
    Object localObject = this.queue.getReadingPeriod();
    int j;
    int i;
    if ((localMediaPeriodHolder != null) && (!localMediaPeriodHolder.prepared) && ((localObject == null) || (((MediaPeriodHolder)localObject).next == localMediaPeriodHolder)))
    {
      localObject = this.enabledRenderers;
      j = localObject.length;
      i = 0;
    }
    while (i < j)
    {
      if (!localObject[i].hasReadStreamToEnd()) {
        return;
      }
      i += 1;
    }
    localMediaPeriodHolder.mediaPeriod.maybeThrowPrepareError();
  }
  
  private void maybeTriggerPendingMessages(long paramLong1, long paramLong2)
  {
    if ((this.pendingMessages.isEmpty()) || (this.playbackInfo.periodId.isAd())) {
      return;
    }
    long l = paramLong1;
    if (this.playbackInfo.startPositionUs == paramLong1) {
      l = paramLong1 - 1L;
    }
    int i = this.playbackInfo.periodId.periodIndex;
    ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo1;
    if (this.nextPendingMessageIndex > 0) {
      localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex - 1);
    }
    while ((localPendingMessageInfo1 != null) && ((localPendingMessageInfo1.resolvedPeriodIndex > i) || ((localPendingMessageInfo1.resolvedPeriodIndex == i) && (localPendingMessageInfo1.resolvedPeriodTimeUs > l))))
    {
      this.nextPendingMessageIndex -= 1;
      if (this.nextPendingMessageIndex > 0)
      {
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex - 1);
        continue;
        localPendingMessageInfo1 = null;
      }
      else
      {
        localPendingMessageInfo1 = null;
      }
    }
    if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
      localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
    }
    ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo2;
    for (;;)
    {
      localPendingMessageInfo2 = localPendingMessageInfo1;
      if (localPendingMessageInfo1 == null) {
        break;
      }
      localPendingMessageInfo2 = localPendingMessageInfo1;
      if (localPendingMessageInfo1.resolvedPeriodUid == null) {
        break;
      }
      if (localPendingMessageInfo1.resolvedPeriodIndex >= i)
      {
        localPendingMessageInfo2 = localPendingMessageInfo1;
        if (localPendingMessageInfo1.resolvedPeriodIndex != i) {
          break;
        }
        localPendingMessageInfo2 = localPendingMessageInfo1;
        if (localPendingMessageInfo1.resolvedPeriodTimeUs > l) {
          break;
        }
      }
      this.nextPendingMessageIndex += 1;
      if (this.nextPendingMessageIndex < this.pendingMessages.size())
      {
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
        continue;
        localPendingMessageInfo1 = null;
      }
      else
      {
        localPendingMessageInfo1 = null;
      }
    }
    label424:
    label435:
    for (;;)
    {
      localPendingMessageInfo2 = null;
      label315:
      if ((localPendingMessageInfo2 != null) && (localPendingMessageInfo2.resolvedPeriodUid != null) && (localPendingMessageInfo2.resolvedPeriodIndex == i) && (localPendingMessageInfo2.resolvedPeriodTimeUs > l) && (localPendingMessageInfo2.resolvedPeriodTimeUs <= paramLong2))
      {
        sendMessageToTarget(localPendingMessageInfo2.message);
        if (!localPendingMessageInfo2.message.getDeleteAfterDelivery()) {
          break label424;
        }
        this.pendingMessages.remove(this.nextPendingMessageIndex);
      }
      for (;;)
      {
        if (this.nextPendingMessageIndex >= this.pendingMessages.size()) {
          break label435;
        }
        localPendingMessageInfo2 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
        break label315;
        break;
        this.nextPendingMessageIndex += 1;
      }
    }
  }
  
  private void maybeUpdateLoadingPeriod()
  {
    this.queue.reevaluateBuffer(this.rendererPositionUs);
    MediaPeriodInfo localMediaPeriodInfo;
    if (this.queue.shouldLoadNextMediaPeriod())
    {
      localMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
      if (localMediaPeriodInfo == null) {
        this.mediaSource.maybeThrowSourceInfoRefreshError();
      }
    }
    else
    {
      return;
    }
    Object localObject = this.playbackInfo.timeline.getPeriod(localMediaPeriodInfo.id.periodIndex, this.period, true).uid;
    this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, 60000000L, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, localObject, localMediaPeriodInfo).prepare(this, localMediaPeriodInfo.startPositionUs);
    setIsLoading(true);
  }
  
  private void prepareInternal(MediaSource paramMediaSource, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.pendingPrepareCount += 1;
    resetInternal(true, paramBoolean1, paramBoolean2);
    this.loadControl.onPrepared();
    this.mediaSource = paramMediaSource;
    setState(2);
    paramMediaSource.prepareSource(this.player, true, this);
    this.handler.sendEmptyMessage(2);
  }
  
  private void releaseInternal()
  {
    resetInternal(true, true, true);
    this.loadControl.onReleased();
    setState(1);
    this.internalPlaybackThread.quit();
    try
    {
      this.released = true;
      notifyAll();
      return;
    }
    finally {}
  }
  
  private boolean rendererWaitingForNextStream(Renderer paramRenderer)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getReadingPeriod();
    return (localMediaPeriodHolder.next != null) && (localMediaPeriodHolder.next.prepared) && (paramRenderer.hasReadStreamToEnd());
  }
  
  private void reselectTracksInternal()
  {
    if (!this.queue.hasPlayingPeriod()) {}
    for (;;)
    {
      return;
      float f = this.mediaClock.getPlaybackParameters().speed;
      MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
      Object localObject = this.queue.getReadingPeriod();
      int i = 1;
      label42:
      boolean bool;
      boolean[] arrayOfBoolean;
      int j;
      label202:
      Renderer localRenderer;
      label232:
      int k;
      if ((localMediaPeriodHolder != null) && (localMediaPeriodHolder.prepared)) {
        if (localMediaPeriodHolder.selectTracks(f))
        {
          if (i == 0) {
            break label395;
          }
          localMediaPeriodHolder = this.queue.getPlayingPeriod();
          bool = this.queue.removeAfter(localMediaPeriodHolder);
          localObject = new boolean[this.renderers.length];
          long l = localMediaPeriodHolder.applyTrackSelection(this.playbackInfo.positionUs, bool, (boolean[])localObject);
          updateLoadControlTrackSelection(localMediaPeriodHolder.trackSelectorResult);
          if ((this.playbackInfo.playbackState != 4) && (l != this.playbackInfo.positionUs))
          {
            this.playbackInfo = this.playbackInfo.fromNewPosition(this.playbackInfo.periodId, l, this.playbackInfo.contentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(4);
            resetRendererPosition(l);
          }
          arrayOfBoolean = new boolean[this.renderers.length];
          i = 0;
          j = 0;
          if (i >= this.renderers.length) {
            break label341;
          }
          localRenderer = this.renderers[i];
          if (localRenderer.getState() == 0) {
            break label314;
          }
          bool = true;
          arrayOfBoolean[i] = bool;
          SampleStream localSampleStream = localMediaPeriodHolder.sampleStreams[i];
          k = j;
          if (localSampleStream != null) {
            k = j + 1;
          }
          if (arrayOfBoolean[i] != 0)
          {
            if (localSampleStream == localRenderer.getStream()) {
              break label320;
            }
            disableRenderer(localRenderer);
          }
        }
      }
      for (;;)
      {
        i += 1;
        j = k;
        break label202;
        if (localMediaPeriodHolder == localObject) {
          i = 0;
        }
        localMediaPeriodHolder = localMediaPeriodHolder.next;
        break label42;
        break;
        label314:
        bool = false;
        break label232;
        label320:
        if (localObject[i] != 0) {
          localRenderer.resetPosition(this.rendererPositionUs);
        }
      }
      label341:
      this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(localMediaPeriodHolder.trackSelectorResult);
      enableRenderers(arrayOfBoolean, j);
      while (this.playbackInfo.playbackState != 4)
      {
        maybeContinueLoading();
        updatePlaybackPositions();
        this.handler.sendEmptyMessage(2);
        return;
        label395:
        this.queue.removeAfter(localMediaPeriodHolder);
        if (localMediaPeriodHolder.prepared)
        {
          localMediaPeriodHolder.applyTrackSelection(Math.max(localMediaPeriodHolder.info.startPositionUs, localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs)), false);
          updateLoadControlTrackSelection(localMediaPeriodHolder.trackSelectorResult);
        }
      }
    }
  }
  
  private void resetInternal(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l2 = -9223372036854775807L;
    this.handler.removeMessages(2);
    this.rebuffering = false;
    this.mediaClock.stop();
    this.rendererPositionUs = 60000000L;
    Object localObject2 = this.enabledRenderers;
    int j = localObject2.length;
    int i = 0;
    for (;;)
    {
      Renderer localRenderer;
      if (i < j) {
        localRenderer = localObject2[i];
      }
      try
      {
        disableRenderer(localRenderer);
        i += 1;
      }
      catch (ExoPlaybackException localExoPlaybackException)
      {
        for (;;)
        {
          Log.e("ExoPlayerImplInternal", "Stop failed.", localExoPlaybackException);
        }
        this.enabledRenderers = new Renderer[0];
        this.queue.clear();
        setIsLoading(false);
        if (paramBoolean2) {
          this.pendingInitialSeekPosition = null;
        }
        Object localObject1;
        if (paramBoolean3)
        {
          this.queue.setTimeline(Timeline.EMPTY);
          localObject1 = this.pendingMessages.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((ExoPlayerImplInternal.PendingMessageInfo)((Iterator)localObject1).next()).message.markAsProcessed(false);
          }
          this.pendingMessages.clear();
          this.nextPendingMessageIndex = 0;
        }
        label203:
        MediaSource.MediaPeriodId localMediaPeriodId;
        long l1;
        if (paramBoolean3)
        {
          localObject1 = Timeline.EMPTY;
          if (!paramBoolean3) {
            break label316;
          }
          localObject2 = null;
          if (!paramBoolean2) {
            break label328;
          }
          localMediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
          if (!paramBoolean2) {
            break label340;
          }
          l1 = -9223372036854775807L;
          if (!paramBoolean2) {
            break label352;
          }
          i = this.playbackInfo.playbackState;
          if (!paramBoolean3) {
            break label364;
          }
        }
        for (TrackSelectorResult localTrackSelectorResult = this.emptyTrackSelectorResult;; localTrackSelectorResult = this.playbackInfo.trackSelectorResult)
        {
          this.playbackInfo = new PlaybackInfo((Timeline)localObject1, localObject2, localMediaPeriodId, l1, l2, i, false, localTrackSelectorResult);
          if ((paramBoolean1) && (this.mediaSource != null))
          {
            this.mediaSource.releaseSource();
            this.mediaSource = null;
          }
          return;
          localObject1 = this.playbackInfo.timeline;
          break;
          label316:
          localObject2 = this.playbackInfo.manifest;
          break label203;
          label328:
          localMediaPeriodId = this.playbackInfo.periodId;
          break label220;
          label340:
          l1 = this.playbackInfo.positionUs;
          break label229;
          label352:
          l2 = this.playbackInfo.contentPositionUs;
          break label233;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        label79:
        label220:
        label229:
        label233:
        label364:
        break label79;
      }
    }
  }
  
  private void resetRendererPosition(long paramLong)
  {
    if (!this.queue.hasPlayingPeriod()) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.queue.getPlayingPeriod().toRendererTime(paramLong))
    {
      this.rendererPositionUs = paramLong;
      this.mediaClock.resetPosition(this.rendererPositionUs);
      Renderer[] arrayOfRenderer = this.enabledRenderers;
      int j = arrayOfRenderer.length;
      int i = 0;
      while (i < j)
      {
        arrayOfRenderer[i].resetPosition(this.rendererPositionUs);
        i += 1;
      }
    }
  }
  
  private boolean resolvePendingMessagePosition(ExoPlayerImplInternal.PendingMessageInfo paramPendingMessageInfo)
  {
    if (paramPendingMessageInfo.resolvedPeriodUid == null)
    {
      Pair localPair = resolveSeekPosition(new ExoPlayerImplInternal.SeekPosition(paramPendingMessageInfo.message.getTimeline(), paramPendingMessageInfo.message.getWindowIndex(), C.msToUs(paramPendingMessageInfo.message.getPositionMs())), false);
      if (localPair == null) {
        return false;
      }
      paramPendingMessageInfo.setResolvedPosition(((Integer)localPair.first).intValue(), ((Long)localPair.second).longValue(), this.playbackInfo.timeline.getPeriod(((Integer)localPair.first).intValue(), this.period, true).uid);
    }
    for (;;)
    {
      return true;
      int i = this.playbackInfo.timeline.getIndexOfPeriod(paramPendingMessageInfo.resolvedPeriodUid);
      if (i == -1) {
        break;
      }
      paramPendingMessageInfo.resolvedPeriodIndex = i;
    }
  }
  
  private void resolvePendingMessagePositions()
  {
    int i = this.pendingMessages.size() - 1;
    while (i >= 0)
    {
      if (!resolvePendingMessagePosition((ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(i)))
      {
        ((ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(i)).message.markAsProcessed(false);
        this.pendingMessages.remove(i);
      }
      i -= 1;
    }
    Collections.sort(this.pendingMessages);
  }
  
  private Pair<Integer, Long> resolveSeekPosition(ExoPlayerImplInternal.SeekPosition paramSeekPosition, boolean paramBoolean)
  {
    Timeline localTimeline = this.playbackInfo.timeline;
    Object localObject2 = paramSeekPosition.timeline;
    if (localTimeline.isEmpty()) {
      return null;
    }
    Object localObject1 = localObject2;
    if (((Timeline)localObject2).isEmpty()) {
      localObject1 = localTimeline;
    }
    try
    {
      localObject2 = ((Timeline)localObject1).getPeriodPosition(this.window, this.period, paramSeekPosition.windowIndex, paramSeekPosition.windowPositionUs);
      if (localTimeline == localObject1) {
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new IllegalSeekPositionException(localTimeline, paramSeekPosition.windowIndex, paramSeekPosition.windowPositionUs);
    }
    int i = localTimeline.getIndexOfPeriod(localIndexOutOfBoundsException.getPeriod(((Integer)((Pair)localObject2).first).intValue(), this.period, true).uid);
    if (i != -1) {
      return Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
    }
    if (paramBoolean)
    {
      i = resolveSubsequentPeriod(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, localTimeline);
      if (i != -1) {
        return getPeriodPosition(localTimeline, localTimeline.getPeriod(i, this.period).windowIndex, -9223372036854775807L);
      }
    }
    return null;
  }
  
  private int resolveSubsequentPeriod(int paramInt, Timeline paramTimeline1, Timeline paramTimeline2)
  {
    int m = paramTimeline1.getPeriodCount();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    for (;;)
    {
      if ((paramInt < m) && (i == -1))
      {
        j = paramTimeline1.getNextPeriodIndex(j, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
        if (j != -1) {}
      }
      else
      {
        return i;
      }
      i = paramTimeline2.getIndexOfPeriod(paramTimeline1.getPeriod(j, this.period, true).uid);
      paramInt += 1;
    }
  }
  
  private void scheduleNextWork(long paramLong1, long paramLong2)
  {
    this.handler.removeMessages(2);
    this.handler.sendEmptyMessageAtTime(2, paramLong1 + paramLong2);
  }
  
  private void seekToCurrentPosition(boolean paramBoolean)
  {
    MediaSource.MediaPeriodId localMediaPeriodId = this.queue.getPlayingPeriod().info.id;
    long l = seekToPeriodPosition(localMediaPeriodId, this.playbackInfo.positionUs, true);
    if (l != this.playbackInfo.positionUs)
    {
      this.playbackInfo = this.playbackInfo.fromNewPosition(localMediaPeriodId, l, this.playbackInfo.contentPositionUs);
      if (paramBoolean) {
        this.playbackInfoUpdate.setPositionDiscontinuity(4);
      }
    }
  }
  
  private void seekToInternal(ExoPlayerImplInternal.SeekPosition paramSeekPosition)
  {
    this.playbackInfoUpdate.incrementPendingOperationAcks(1);
    Pair localPair = resolveSeekPosition(paramSeekPosition, true);
    MediaSource.MediaPeriodId localMediaPeriodId;
    long l1;
    long l3;
    int i;
    if (localPair == null)
    {
      localMediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
      l1 = -9223372036854775807L;
      l3 = -9223372036854775807L;
      i = 1;
    }
    try
    {
      if ((this.mediaSource == null) || (this.pendingPrepareCount > 0)) {
        this.pendingInitialSeekPosition = paramSeekPosition;
      }
      for (;;)
      {
        label94:
        return;
        i = ((Integer)localPair.first).intValue();
        l3 = ((Long)localPair.second).longValue();
        localMediaPeriodId = this.queue.resolveMediaPeriodIdForAds(i, l3);
        if (localMediaPeriodId.isAd())
        {
          l1 = 0L;
          i = 1;
          break;
        }
        l1 = ((Long)localPair.second).longValue();
        if (paramSeekPosition.windowPositionUs == -9223372036854775807L) {}
        for (i = 1;; i = 0) {
          break;
        }
        if (l1 != -9223372036854775807L) {
          break label238;
        }
        setState(4);
        resetInternal(false, true, false);
      }
      if (!localMediaPeriodId.equals(this.playbackInfo.periodId)) {
        break label351;
      }
    }
    finally
    {
      this.playbackInfo = this.playbackInfo.fromNewPosition(localMediaPeriodId, l1, l3);
      if (i != 0) {
        this.playbackInfoUpdate.setPositionDiscontinuity(2);
      }
    }
    label238:
    paramSeekPosition = this.queue.getPlayingPeriod();
    if ((paramSeekPosition != null) && (l1 != 0L)) {}
    for (long l2 = paramSeekPosition.mediaPeriod.getAdjustedSeekPositionUs(l1, this.seekParameters);; l2 = l1)
    {
      long l4 = l2;
      if (C.usToMs(l2) == C.usToMs(this.playbackInfo.positionUs))
      {
        l2 = this.playbackInfo.positionUs;
        this.playbackInfo = this.playbackInfo.fromNewPosition(localMediaPeriodId, l2, l3);
        if (i == 0) {
          break label94;
        }
        this.playbackInfoUpdate.setPositionDiscontinuity(2);
        return;
        label351:
        l4 = l1;
      }
      l2 = seekToPeriodPosition(localMediaPeriodId, l4);
      if (l1 != l2) {}
      for (int j = 1;; j = 0)
      {
        i = j | i;
        l1 = l2;
        break;
      }
    }
  }
  
  private long seekToPeriodPosition(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    if (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {}
    for (boolean bool = true;; bool = false) {
      return seekToPeriodPosition(paramMediaPeriodId, paramLong, bool);
    }
  }
  
  private long seekToPeriodPosition(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong, boolean paramBoolean)
  {
    stopRenderers();
    this.rebuffering = false;
    setState(2);
    MediaPeriodHolder localMediaPeriodHolder2 = this.queue.getPlayingPeriod();
    for (MediaPeriodHolder localMediaPeriodHolder1 = localMediaPeriodHolder2;; localMediaPeriodHolder1 = this.queue.advancePlayingPeriod()) {
      if (localMediaPeriodHolder1 != null)
      {
        if (shouldKeepPeriodHolder(paramMediaPeriodId, paramLong, localMediaPeriodHolder1)) {
          this.queue.removeAfter(localMediaPeriodHolder1);
        }
      }
      else
      {
        if ((localMediaPeriodHolder2 == localMediaPeriodHolder1) && (!paramBoolean)) {
          break label124;
        }
        paramMediaPeriodId = this.enabledRenderers;
        int j = paramMediaPeriodId.length;
        int i = 0;
        while (i < j)
        {
          disableRenderer(paramMediaPeriodId[i]);
          i += 1;
        }
      }
    }
    this.enabledRenderers = new Renderer[0];
    localMediaPeriodHolder2 = null;
    label124:
    if (localMediaPeriodHolder1 != null)
    {
      updatePlayingPeriodRenderers(localMediaPeriodHolder2);
      long l = paramLong;
      if (localMediaPeriodHolder1.hasEnabledTracks)
      {
        l = localMediaPeriodHolder1.mediaPeriod.seekToUs(paramLong);
        localMediaPeriodHolder1.mediaPeriod.discardBuffer(l - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
      }
      resetRendererPosition(l);
      maybeContinueLoading();
      paramLong = l;
    }
    for (;;)
    {
      this.handler.sendEmptyMessage(2);
      return paramLong;
      this.queue.clear();
      resetRendererPosition(paramLong);
    }
  }
  
  private void sendMessageInternal(PlayerMessage paramPlayerMessage)
  {
    if (paramPlayerMessage.getPositionMs() == -9223372036854775807L)
    {
      sendMessageToTarget(paramPlayerMessage);
      return;
    }
    if ((this.mediaSource == null) || (this.pendingPrepareCount > 0))
    {
      this.pendingMessages.add(new ExoPlayerImplInternal.PendingMessageInfo(paramPlayerMessage));
      return;
    }
    ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo = new ExoPlayerImplInternal.PendingMessageInfo(paramPlayerMessage);
    if (resolvePendingMessagePosition(localPendingMessageInfo))
    {
      this.pendingMessages.add(localPendingMessageInfo);
      Collections.sort(this.pendingMessages);
      return;
    }
    paramPlayerMessage.markAsProcessed(false);
  }
  
  private void sendMessageToTarget(PlayerMessage paramPlayerMessage)
  {
    if (paramPlayerMessage.getHandler().getLooper() == this.handler.getLooper())
    {
      deliverMessage(paramPlayerMessage);
      if ((this.playbackInfo.playbackState == 3) || (this.playbackInfo.playbackState == 2)) {
        this.handler.sendEmptyMessage(2);
      }
      return;
    }
    this.handler.obtainMessage(15, paramPlayerMessage).sendToTarget();
  }
  
  private void sendMessageToTargetThread(PlayerMessage paramPlayerMessage)
  {
    paramPlayerMessage.getHandler().post(new ExoPlayerImplInternal.1(this, paramPlayerMessage));
  }
  
  private void setIsLoading(boolean paramBoolean)
  {
    if (this.playbackInfo.isLoading != paramBoolean) {
      this.playbackInfo = this.playbackInfo.copyWithIsLoading(paramBoolean);
    }
  }
  
  private void setPlayWhenReadyInternal(boolean paramBoolean)
  {
    this.rebuffering = false;
    this.playWhenReady = paramBoolean;
    if (!paramBoolean)
    {
      stopRenderers();
      updatePlaybackPositions();
    }
    do
    {
      return;
      if (this.playbackInfo.playbackState == 3)
      {
        startRenderers();
        this.handler.sendEmptyMessage(2);
        return;
      }
    } while (this.playbackInfo.playbackState != 2);
    this.handler.sendEmptyMessage(2);
  }
  
  private void setPlaybackParametersInternal(PlaybackParameters paramPlaybackParameters)
  {
    this.mediaClock.setPlaybackParameters(paramPlaybackParameters);
  }
  
  private void setRepeatModeInternal(int paramInt)
  {
    this.repeatMode = paramInt;
    if (!this.queue.updateRepeatMode(paramInt)) {
      seekToCurrentPosition(true);
    }
  }
  
  private void setSeekParametersInternal(SeekParameters paramSeekParameters)
  {
    this.seekParameters = paramSeekParameters;
  }
  
  private void setShuffleModeEnabledInternal(boolean paramBoolean)
  {
    this.shuffleModeEnabled = paramBoolean;
    if (!this.queue.updateShuffleModeEnabled(paramBoolean)) {
      seekToCurrentPosition(true);
    }
  }
  
  private void setState(int paramInt)
  {
    if (this.playbackInfo.playbackState != paramInt) {
      this.playbackInfo = this.playbackInfo.copyWithPlaybackState(paramInt);
    }
  }
  
  private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong, MediaPeriodHolder paramMediaPeriodHolder)
  {
    if ((paramMediaPeriodId.equals(paramMediaPeriodHolder.info.id)) && (paramMediaPeriodHolder.prepared))
    {
      this.playbackInfo.timeline.getPeriod(paramMediaPeriodHolder.info.id.periodIndex, this.period);
      int i = this.period.getAdGroupIndexAfterPositionUs(paramLong);
      if ((i == -1) || (this.period.getAdGroupTimeUs(i) == paramMediaPeriodHolder.info.endPositionUs)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean shouldTransitionToReadyState(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.enabledRenderers.length == 0) {
      bool1 = isTimelineReady();
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!paramBoolean);
    if (!this.playbackInfo.isLoading) {
      return true;
    }
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getLoadingPeriod();
    if (!localMediaPeriodHolder.info.isFinal) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      long l = localMediaPeriodHolder.getBufferedPositionUs(paramBoolean);
      if (l != -9223372036854775808L)
      {
        bool1 = bool2;
        if (!this.loadControl.shouldStartPlayback(l - localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed, this.rebuffering)) {
          break;
        }
      }
      return true;
    }
  }
  
  private void startRenderers()
  {
    int i = 0;
    this.rebuffering = false;
    this.mediaClock.start();
    Renderer[] arrayOfRenderer = this.enabledRenderers;
    int j = arrayOfRenderer.length;
    while (i < j)
    {
      arrayOfRenderer[i].start();
      i += 1;
    }
  }
  
  private void stopInternal(boolean paramBoolean1, boolean paramBoolean2)
  {
    resetInternal(true, paramBoolean1, paramBoolean1);
    ExoPlayerImplInternal.PlaybackInfoUpdate localPlaybackInfoUpdate = this.playbackInfoUpdate;
    int j = this.pendingPrepareCount;
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localPlaybackInfoUpdate.incrementPendingOperationAcks(i + j);
      this.pendingPrepareCount = 0;
      this.loadControl.onStopped();
      setState(1);
      return;
    }
  }
  
  private void stopRenderers()
  {
    this.mediaClock.stop();
    Renderer[] arrayOfRenderer = this.enabledRenderers;
    int j = arrayOfRenderer.length;
    int i = 0;
    while (i < j)
    {
      ensureStopped(arrayOfRenderer[i]);
      i += 1;
    }
  }
  
  private void updateLoadControlTrackSelection(TrackSelectorResult paramTrackSelectorResult)
  {
    this.loadControl.onTracksSelected(this.renderers, paramTrackSelectorResult.groups, paramTrackSelectorResult.selections);
  }
  
  private void updatePeriods()
  {
    int j = 0;
    if (this.mediaSource == null) {}
    label58:
    label88:
    label225:
    label227:
    label232:
    do
    {
      for (;;)
      {
        return;
        if (this.pendingPrepareCount > 0)
        {
          this.mediaSource.maybeThrowSourceInfoRefreshError();
          return;
        }
        maybeUpdateLoadingPeriod();
        localObject1 = this.queue.getLoadingPeriod();
        if ((localObject1 == null) || (((MediaPeriodHolder)localObject1).isFullyBuffered()))
        {
          setIsLoading(false);
          if (!this.queue.hasPlayingPeriod()) {
            break label225;
          }
          localObject1 = this.queue.getPlayingPeriod();
          localObject3 = this.queue.getReadingPeriod();
          i = 0;
          if ((!this.playWhenReady) || (localObject1 == localObject3) || (this.rendererPositionUs < ((MediaPeriodHolder)localObject1).next.rendererPositionOffsetUs)) {
            break label232;
          }
          if (i != 0) {
            maybeNotifyPlaybackInfoChanged();
          }
          if (!((MediaPeriodHolder)localObject1).info.isLastInTimelinePeriod) {
            break label227;
          }
        }
        for (i = 0;; i = 3)
        {
          localObject2 = this.queue.advancePlayingPeriod();
          updatePlayingPeriodRenderers((MediaPeriodHolder)localObject1);
          this.playbackInfo = this.playbackInfo.fromNewPosition(((MediaPeriodHolder)localObject2).info.id, ((MediaPeriodHolder)localObject2).info.startPositionUs, ((MediaPeriodHolder)localObject2).info.contentPositionUs);
          this.playbackInfoUpdate.setPositionDiscontinuity(i);
          updatePlaybackPositions();
          i = 1;
          localObject1 = localObject2;
          break label88;
          if (this.playbackInfo.isLoading) {
            break label58;
          }
          maybeContinueLoading();
          break label58;
          break;
        }
        if (!((MediaPeriodHolder)localObject3).info.isFinal) {
          break;
        }
        i = j;
        while (i < this.renderers.length)
        {
          localObject1 = this.renderers[i];
          localObject2 = localObject3.sampleStreams[i];
          if ((localObject2 != null) && (((Renderer)localObject1).getStream() == localObject2) && (((Renderer)localObject1).hasReadStreamToEnd())) {
            ((Renderer)localObject1).setCurrentStreamFinal();
          }
          i += 1;
        }
      }
    } while ((((MediaPeriodHolder)localObject3).next == null) || (!((MediaPeriodHolder)localObject3).next.prepared));
    int i = 0;
    for (;;)
    {
      if (i >= this.renderers.length) {
        break label393;
      }
      localObject1 = this.renderers[i];
      localObject2 = localObject3.sampleStreams[i];
      if ((((Renderer)localObject1).getStream() != localObject2) || ((localObject2 != null) && (!((Renderer)localObject1).hasReadStreamToEnd()))) {
        break;
      }
      i += 1;
    }
    label393:
    Object localObject1 = ((MediaPeriodHolder)localObject3).trackSelectorResult;
    Object localObject2 = this.queue.advanceReadingPeriod();
    Object localObject3 = ((MediaPeriodHolder)localObject2).trackSelectorResult;
    label435:
    label437:
    Renderer localRenderer;
    if (((MediaPeriodHolder)localObject2).mediaPeriod.readDiscontinuity() != -9223372036854775807L)
    {
      i = 1;
      j = 0;
      if (j < this.renderers.length)
      {
        localRenderer = this.renderers[j];
        if (localObject1.renderersEnabled[j] != 0) {
          break label476;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label437;
      break;
      i = 0;
      break label435;
      label476:
      if (i != 0)
      {
        localRenderer.setCurrentStreamFinal();
      }
      else if (!localRenderer.isCurrentStreamFinal())
      {
        TrackSelection localTrackSelection = ((TrackSelectorResult)localObject3).selections.get(j);
        int m = localObject3.renderersEnabled[j];
        if (this.rendererCapabilities[j].getTrackType() == 5) {}
        for (int k = 1;; k = 0)
        {
          RendererConfiguration localRendererConfiguration1 = localObject1.rendererConfigurations[j];
          RendererConfiguration localRendererConfiguration2 = localObject3.rendererConfigurations[j];
          if ((m == 0) || (!localRendererConfiguration2.equals(localRendererConfiguration1)) || (k != 0)) {
            break label606;
          }
          localRenderer.replaceStream(getFormats(localTrackSelection), localObject2.sampleStreams[j], ((MediaPeriodHolder)localObject2).getRendererOffset());
          break;
        }
        label606:
        localRenderer.setCurrentStreamFinal();
      }
    }
  }
  
  private void updatePlaybackPositions()
  {
    if (!this.queue.hasPlayingPeriod()) {
      return;
    }
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    long l = localMediaPeriodHolder.mediaPeriod.readDiscontinuity();
    PlaybackInfo localPlaybackInfo;
    if (l != -9223372036854775807L)
    {
      resetRendererPosition(l);
      if (l != this.playbackInfo.positionUs)
      {
        this.playbackInfo = this.playbackInfo.fromNewPosition(this.playbackInfo.periodId, l, this.playbackInfo.contentPositionUs);
        this.playbackInfoUpdate.setPositionDiscontinuity(4);
      }
      localPlaybackInfo = this.playbackInfo;
      if (this.enabledRenderers.length != 0) {
        break label160;
      }
    }
    label160:
    for (l = localMediaPeriodHolder.info.durationUs;; l = localMediaPeriodHolder.getBufferedPositionUs(true))
    {
      localPlaybackInfo.bufferedPositionUs = l;
      return;
      this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs();
      l = localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs);
      maybeTriggerPendingMessages(this.playbackInfo.positionUs, l);
      this.playbackInfo.positionUs = l;
      break;
    }
  }
  
  private void updatePlayingPeriodRenderers(@Nullable MediaPeriodHolder paramMediaPeriodHolder)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    if ((localMediaPeriodHolder == null) || (paramMediaPeriodHolder == localMediaPeriodHolder)) {
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.renderers.length];
    int i = 0;
    int j = 0;
    if (i < this.renderers.length)
    {
      Renderer localRenderer = this.renderers[i];
      if (localRenderer.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        int k = j;
        if (localMediaPeriodHolder.trackSelectorResult.renderersEnabled[i] != 0) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localMediaPeriodHolder.trackSelectorResult.renderersEnabled[i] == 0) || ((localRenderer.isCurrentStreamFinal()) && (localRenderer.getStream() == paramMediaPeriodHolder.sampleStreams[i])))) {
          disableRenderer(localRenderer);
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(localMediaPeriodHolder.trackSelectorResult);
    enableRenderers(arrayOfBoolean, j);
  }
  
  private void updateTrackSelectionPlaybackSpeed(float paramFloat)
  {
    for (MediaPeriodHolder localMediaPeriodHolder = this.queue.getFrontPeriod(); localMediaPeriodHolder != null; localMediaPeriodHolder = localMediaPeriodHolder.next) {
      if (localMediaPeriodHolder.trackSelectorResult != null)
      {
        TrackSelection[] arrayOfTrackSelection = localMediaPeriodHolder.trackSelectorResult.selections.getAll();
        int j = arrayOfTrackSelection.length;
        int i = 0;
        while (i < j)
        {
          TrackSelection localTrackSelection = arrayOfTrackSelection[i];
          if (localTrackSelection != null) {
            localTrackSelection.onPlaybackSpeed(paramFloat);
          }
          i += 1;
        }
      }
    }
  }
  
  public Looper getPlaybackLooper()
  {
    return this.internalPlaybackThread.getLooper();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2;
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 0: 
          MediaSource localMediaSource = (MediaSource)paramMessage.obj;
          if (paramMessage.arg1 == 0) {
            break label449;
          }
          bool1 = true;
          if (paramMessage.arg2 == 0) {
            break label454;
          }
          bool2 = true;
          label111:
          prepareInternal(localMediaSource, bool1, bool2);
        }
      }
      catch (ExoPlaybackException paramMessage)
      {
        Log.e("ExoPlayerImplInternal", "Playback error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, paramMessage).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
        break;
        bool1 = false;
        continue;
        setRepeatModeInternal(paramMessage.arg1);
        continue;
      }
      catch (IOException paramMessage)
      {
        Log.e("ExoPlayerImplInternal", "Source error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(paramMessage)).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
        break;
        if (paramMessage.arg1 == 0) {
          break label290;
        }
        bool1 = true;
        setShuffleModeEnabledInternal(bool1);
        continue;
      }
      catch (RuntimeException paramMessage)
      {
        label119:
        Log.e("ExoPlayerImplInternal", "Internal runtime error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, ExoPlaybackException.createForUnexpected(paramMessage)).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
      }
      maybeNotifyPlaybackInfoChanged();
      break;
      if (paramMessage.arg1 != 0)
      {
        bool1 = true;
        setPlayWhenReadyInternal(bool1);
      }
      else
      {
        label290:
        bool1 = false;
        continue;
        doSomeWork();
        continue;
        seekToInternal((ExoPlayerImplInternal.SeekPosition)paramMessage.obj);
        continue;
        setPlaybackParametersInternal((PlaybackParameters)paramMessage.obj);
        continue;
        setSeekParametersInternal((SeekParameters)paramMessage.obj);
      }
    }
    if (paramMessage.arg1 != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      stopInternal(bool1, true);
      break label119;
      handlePeriodPrepared((MediaPeriod)paramMessage.obj);
      break label119;
      handleSourceInfoRefreshed((ExoPlayerImplInternal.MediaSourceRefreshInfo)paramMessage.obj);
      break label119;
      handleContinueLoadingRequested((MediaPeriod)paramMessage.obj);
      break label119;
      reselectTracksInternal();
      break label119;
      sendMessageInternal((PlayerMessage)paramMessage.obj);
      break label119;
      sendMessageToTargetThread((PlayerMessage)paramMessage.obj);
      break label119;
      releaseInternal();
      return true;
      return false;
      return true;
      label449:
      bool1 = false;
      break;
      label454:
      bool2 = false;
      break label111;
    }
  }
  
  public void onContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    this.handler.obtainMessage(10, paramMediaPeriod).sendToTarget();
  }
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters)
  {
    this.eventHandler.obtainMessage(1, paramPlaybackParameters).sendToTarget();
    updateTrackSelectionPlaybackSpeed(paramPlaybackParameters.speed);
  }
  
  public void onPrepared(MediaPeriod paramMediaPeriod)
  {
    this.handler.obtainMessage(9, paramMediaPeriod).sendToTarget();
  }
  
  public void onSourceInfoRefreshed(MediaSource paramMediaSource, Timeline paramTimeline, Object paramObject)
  {
    this.handler.obtainMessage(8, new ExoPlayerImplInternal.MediaSourceRefreshInfo(paramMediaSource, paramTimeline, paramObject)).sendToTarget();
  }
  
  public void onTrackSelectionsInvalidated()
  {
    this.handler.sendEmptyMessage(11);
  }
  
  public void prepare(MediaSource paramMediaSource, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    HandlerWrapper localHandlerWrapper = this.handler;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label43;
      }
    }
    for (;;)
    {
      localHandlerWrapper.obtainMessage(0, i, j, paramMediaSource).sendToTarget();
      return;
      i = 0;
      break;
      label43:
      j = 0;
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 949	com/google/android/exoplayer2/ExoPlayerImplInternal:released	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 264	com/google/android/exoplayer2/ExoPlayerImplInternal:handler	Lcom/google/android/exoplayer2/util/HandlerWrapper;
    //   18: bipush 7
    //   20: invokeinterface 942 2 0
    //   25: pop
    //   26: iconst_0
    //   27: istore_1
    //   28: aload_0
    //   29: getfield 949	com/google/android/exoplayer2/ExoPlayerImplInternal:released	Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +16 -> 50
    //   37: aload_0
    //   38: invokevirtual 1325	java/lang/Object:wait	()V
    //   41: goto -13 -> 28
    //   44: astore_3
    //   45: iconst_1
    //   46: istore_1
    //   47: goto -19 -> 28
    //   50: iload_1
    //   51: ifeq -40 -> 11
    //   54: invokestatic 459	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   57: invokevirtual 462	java/lang/Thread:interrupt	()V
    //   60: goto -49 -> 11
    //   63: astore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ExoPlayerImplInternal
    //   27	24	1	i	int
    //   6	28	2	bool	boolean
    //   44	1	3	localInterruptedException	InterruptedException
    //   63	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	44	java/lang/InterruptedException
    //   2	7	63	finally
    //   14	26	63	finally
    //   28	33	63	finally
    //   37	41	63	finally
    //   54	60	63	finally
  }
  
  public void seekTo(Timeline paramTimeline, int paramInt, long paramLong)
  {
    this.handler.obtainMessage(3, new ExoPlayerImplInternal.SeekPosition(paramTimeline, paramInt, paramLong)).sendToTarget();
  }
  
  /* Error */
  public void sendMessage(PlayerMessage paramPlayerMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 949	com/google/android/exoplayer2/ExoPlayerImplInternal:released	Z
    //   6: ifeq +20 -> 26
    //   9: ldc 62
    //   11: ldc_w 1329
    //   14: invokestatic 1333	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 301	com/google/android/exoplayer2/PlayerMessage:markAsProcessed	(Z)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 264	com/google/android/exoplayer2/ExoPlayerImplInternal:handler	Lcom/google/android/exoplayer2/util/HandlerWrapper;
    //   30: bipush 14
    //   32: aload_1
    //   33: invokeinterface 1124 3 0
    //   38: invokevirtual 855	android/os/Message:sendToTarget	()V
    //   41: goto -18 -> 23
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	ExoPlayerImplInternal
    //   0	49	1	paramPlayerMessage	PlayerMessage
    // Exception table:
    //   from	to	target	type
    //   2	23	44	finally
    //   26	41	44	finally
  }
  
  public void setPlayWhenReady(boolean paramBoolean)
  {
    HandlerWrapper localHandlerWrapper = this.handler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandlerWrapper.obtainMessage(1, i, 0).sendToTarget();
      return;
    }
  }
  
  public void setPlaybackParameters(PlaybackParameters paramPlaybackParameters)
  {
    this.handler.obtainMessage(4, paramPlaybackParameters).sendToTarget();
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.handler.obtainMessage(12, paramInt, 0).sendToTarget();
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    this.handler.obtainMessage(5, paramSeekParameters).sendToTarget();
  }
  
  public void setShuffleModeEnabled(boolean paramBoolean)
  {
    HandlerWrapper localHandlerWrapper = this.handler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandlerWrapper.obtainMessage(13, i, 0).sendToTarget();
      return;
    }
  }
  
  public void stop(boolean paramBoolean)
  {
    HandlerWrapper localHandlerWrapper = this.handler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandlerWrapper.obtainMessage(6, i, 0).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal
 * JD-Core Version:    0.7.0.1
 */