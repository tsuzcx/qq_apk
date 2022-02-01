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
    CountDownLatch localCountDownLatch;
    Renderer[] arrayOfRenderer;
    if ((this.parallelRender) && (this.playbackInfo.playbackState != 3))
    {
      localCountDownLatch = new CountDownLatch(this.enabledRenderers.length);
      arrayOfRenderer = this.enabledRenderers;
      localObject1 = new ExoPlayerImplInternal.RendererRunnable[arrayOfRenderer.length];
      i = arrayOfRenderer.length;
      j = 0;
      k = 0;
      while (j < i)
      {
        Renderer localRenderer = arrayOfRenderer[j];
        ExoPlayerImplInternal.RendererRunnable localRendererRunnable = new ExoPlayerImplInternal.RendererRunnable(this, localRenderer, this.rendererPositionUs, l2, localCountDownLatch);
        localObject1[k] = localRendererRunnable;
        if (this.mRenderHandlerThreadMap == null) {
          this.mRenderHandlerThreadMap = new HashMap();
        }
        SimpleHandlerThread localSimpleHandlerThread = (SimpleHandlerThread)this.mRenderHandlerThreadMap.get(localRenderer);
        Object localObject2 = localSimpleHandlerThread;
        if (localSimpleHandlerThread == null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TrackRender-");
          ((StringBuilder)localObject2).append(localRenderer.getTrackType());
          localObject2 = new SimpleHandlerThread(((StringBuilder)localObject2).toString(), -16);
          ((SimpleHandlerThread)localObject2).start();
          this.mRenderHandlerThreadMap.put(localRenderer, localObject2);
        }
        ((SimpleHandlerThread)localObject2).postJob(localRendererRunnable);
        k += 1;
        j += 1;
      }
      l2 = l1;
    }
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      label319:
      int i1;
      int n;
      int m;
      boolean bool;
      break label319;
    }
    Thread.currentThread().interrupt();
    i1 = localObject1.length;
    int k = 0;
    int j = 1;
    int i = 1;
    for (;;)
    {
      n = j;
      m = i;
      l1 = l2;
      if (k >= i1) {
        break label585;
      }
      arrayOfRenderer = localObject1[k];
      if (arrayOfRenderer.getExceptionThrown() != null) {
        break;
      }
      if ((j != 0) && (arrayOfRenderer.isEnded())) {
        j = 1;
      } else {
        j = 0;
      }
      bool = arrayOfRenderer.rendererReadyOrEnded();
      if (!bool) {
        arrayOfRenderer.getRenderer().maybeThrowStreamError();
      }
      if ((i != 0) && (bool)) {
        i = 1;
      } else {
        i = 0;
      }
      k += 1;
    }
    throw arrayOfRenderer.getExceptionThrown();
    disableParallelRender();
    Object localObject1 = this.enabledRenderers;
    n = localObject1.length;
    k = 0;
    j = 1;
    i = 1;
    while (k < n)
    {
      arrayOfRenderer = localObject1[k];
      arrayOfRenderer.render(this.rendererPositionUs, l2);
      if ((j != 0) && (arrayOfRenderer.isEnded())) {
        j = 1;
      } else {
        j = 0;
      }
      if ((!arrayOfRenderer.isReady()) && (!arrayOfRenderer.isEnded()) && (!rendererWaitingForNextStream(arrayOfRenderer))) {
        m = 0;
      } else {
        m = 1;
      }
      if (m == 0) {
        arrayOfRenderer.maybeThrowStreamError();
      }
      if ((i != 0) && (m != 0)) {
        i = 1;
      } else {
        i = 0;
      }
      k += 1;
    }
    m = i;
    n = j;
    label585:
    if (m == 0) {
      maybeThrowPeriodPrepareError();
    }
    l2 = localMediaPeriodHolder.info.durationUs;
    if ((n != 0) && ((l2 == -9223372036854775807L) || (l2 <= this.playbackInfo.positionUs)) && (localMediaPeriodHolder.info.isFinal))
    {
      setState(4);
      stopRenderers();
    }
    else
    {
      if (this.playbackInfo.playbackState == 2)
      {
        if ((!this.parallelRender) && (m == 0)) {
          bool = false;
        } else {
          bool = true;
        }
        if (shouldTransitionToReadyState(bool))
        {
          setState(3);
          if (!this.playWhenReady) {
            break label768;
          }
          startRenderers();
          break label768;
        }
      }
      if ((this.playbackInfo.playbackState == 3) && (this.enabledRenderers.length == 0 ? !isTimelineReady() : m == 0))
      {
        this.rebuffering = this.playWhenReady;
        setState(2);
        stopRenderers();
      }
    }
    label768:
    if (this.playbackInfo.playbackState == 2)
    {
      localObject1 = this.enabledRenderers;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject1[i].maybeThrowStreamError();
        i += 1;
      }
    }
    if (((this.playWhenReady) && (this.playbackInfo.playbackState == 3)) || (this.playbackInfo.playbackState == 2)) {
      scheduleNextWork(l1, 10L);
    } else if ((this.enabledRenderers.length != 0) && (this.playbackInfo.playbackState != 4)) {
      scheduleNextWork(l1, 1000L);
    } else {
      this.handler.removeMessages(2);
    }
    TraceUtil.endSection();
  }
  
  private void enableRenderer(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    Renderer localRenderer = this.renderers[paramInt1];
    this.enabledRenderers[paramInt2] = localRenderer;
    if (localRenderer.getState() == 0)
    {
      RendererConfiguration localRendererConfiguration = localMediaPeriodHolder.trackSelectorResult.rendererConfigurations[paramInt1];
      Format[] arrayOfFormat = getFormats(localMediaPeriodHolder.trackSelectorResult.selections.get(paramInt1));
      if ((this.playWhenReady) && (this.playbackInfo.playbackState == 3)) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if ((!paramBoolean) && (paramInt2 != 0)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localRenderer.enable(localRendererConfiguration, arrayOfFormat, localMediaPeriodHolder.sampleStreams[paramInt1], this.rendererPositionUs, paramBoolean, localMediaPeriodHolder.getRendererOffset());
      this.mediaClock.onRendererEnabled(localRenderer);
      if (paramInt2 != 0) {
        localRenderer.start();
      }
    }
  }
  
  private void enableRenderers(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.enabledRenderers = new Renderer[paramInt];
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    paramInt = 0;
    int j;
    for (int i = 0; paramInt < this.renderers.length; i = j)
    {
      j = i;
      if (localMediaPeriodHolder.trackSelectorResult.renderersEnabled[paramInt] != 0)
      {
        enableRenderer(paramInt, paramArrayOfBoolean[paramInt], i);
        j = i + 1;
      }
      paramInt += 1;
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
    int i;
    if (paramTrackSelection != null) {
      i = paramTrackSelection.length();
    } else {
      i = 0;
    }
    Format[] arrayOfFormat = new Format[i];
    while (j < i)
    {
      arrayOfFormat[j] = paramTrackSelection.getFormat(j);
      j += 1;
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
    if (paramMediaSourceRefreshInfo.source != this.mediaSource) {
      return;
    }
    Object localObject3 = this.playbackInfo.timeline;
    Object localObject2 = paramMediaSourceRefreshInfo.timeline;
    paramMediaSourceRefreshInfo = paramMediaSourceRefreshInfo.manifest;
    this.queue.setTimeline((Timeline)localObject2);
    this.playbackInfo = this.playbackInfo.copyWithTimeline((Timeline)localObject2, paramMediaSourceRefreshInfo);
    resolvePendingMessagePositions();
    int i = this.pendingPrepareCount;
    long l1 = 0L;
    if (i > 0)
    {
      this.playbackInfoUpdate.incrementPendingOperationAcks(i);
      this.pendingPrepareCount = 0;
      paramMediaSourceRefreshInfo = this.pendingInitialSeekPosition;
      if (paramMediaSourceRefreshInfo != null)
      {
        paramMediaSourceRefreshInfo = resolveSeekPosition(paramMediaSourceRefreshInfo, true);
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
        if (paramMediaSourceRefreshInfo.isAd()) {
          l1 = 0L;
        } else {
          l1 = l2;
        }
        this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
        return;
      }
      if (this.playbackInfo.startPositionUs == -9223372036854775807L)
      {
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
        if (paramMediaSourceRefreshInfo.isAd()) {
          l1 = 0L;
        } else {
          l1 = l2;
        }
        this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
      }
      return;
    }
    i = this.playbackInfo.periodId.periodIndex;
    long l2 = this.playbackInfo.contentPositionUs;
    if (((Timeline)localObject3).isEmpty())
    {
      if (!((Timeline)localObject2).isEmpty())
      {
        paramMediaSourceRefreshInfo = this.queue.resolveMediaPeriodIdForAds(i, l2);
        localObject1 = this.playbackInfo;
        if (!paramMediaSourceRefreshInfo.isAd()) {
          l1 = l2;
        }
        this.playbackInfo = ((PlaybackInfo)localObject1).fromNewPosition(paramMediaSourceRefreshInfo, l1, l2);
      }
      return;
    }
    Object localObject1 = this.queue.getFrontPeriod();
    if (localObject1 == null) {
      paramMediaSourceRefreshInfo = ((Timeline)localObject3).getPeriod(i, this.period, true).uid;
    } else {
      paramMediaSourceRefreshInfo = ((MediaPeriodHolder)localObject1).uid;
    }
    int j = ((Timeline)localObject2).getIndexOfPeriod(paramMediaSourceRefreshInfo);
    if (j == -1)
    {
      i = resolveSubsequentPeriod(i, (Timeline)localObject3, (Timeline)localObject2);
      if (i == -1)
      {
        handleSourceInfoRefreshEndedPlayback();
        return;
      }
      paramMediaSourceRefreshInfo = getPeriodPosition((Timeline)localObject2, ((Timeline)localObject2).getPeriod(i, this.period).windowIndex, -9223372036854775807L);
      i = ((Integer)paramMediaSourceRefreshInfo.first).intValue();
      l2 = ((Long)paramMediaSourceRefreshInfo.second).longValue();
      localObject3 = this.queue.resolveMediaPeriodIdForAds(i, l2);
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
      if (!((MediaSource.MediaPeriodId)localObject3).isAd()) {
        l1 = l2;
      }
      l1 = seekToPeriodPosition((MediaSource.MediaPeriodId)localObject3, l1);
      this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject3, l1, l2);
      return;
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
        if (!((MediaSource.MediaPeriodId)localObject1).isAd()) {
          l1 = l2;
        }
        l1 = seekToPeriodPosition((MediaSource.MediaPeriodId)localObject1, l1);
        this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject1, l1, l2);
        return;
      }
    }
    if (!this.queue.updateQueuedPeriods(paramMediaSourceRefreshInfo, this.rendererPositionUs)) {
      seekToCurrentPosition(false);
    }
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
    if (l1 == -9223372036854775808L)
    {
      setIsLoading(false);
      return;
    }
    long l2 = localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs);
    boolean bool = this.loadControl.shouldContinueLoading(l1 - l2, this.mediaClock.getPlaybackParameters().speed);
    setIsLoading(bool);
    if (bool) {
      localMediaPeriodHolder.continueLoading(this.rendererPositionUs);
    }
  }
  
  private void maybeNotifyPlaybackInfoChanged()
  {
    if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo))
    {
      Handler localHandler = this.eventHandler;
      int j = ExoPlayerImplInternal.PlaybackInfoUpdate.access$100(this.playbackInfoUpdate);
      int i;
      if (ExoPlayerImplInternal.PlaybackInfoUpdate.access$200(this.playbackInfoUpdate)) {
        i = ExoPlayerImplInternal.PlaybackInfoUpdate.access$300(this.playbackInfoUpdate);
      } else {
        i = -1;
      }
      localHandler.obtainMessage(0, j, i, this.playbackInfo).sendToTarget();
      this.playbackInfoUpdate.reset(this.playbackInfo);
    }
  }
  
  private void maybeThrowPeriodPrepareError()
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getLoadingPeriod();
    Object localObject = this.queue.getReadingPeriod();
    if ((localMediaPeriodHolder != null) && (!localMediaPeriodHolder.prepared) && ((localObject == null) || (((MediaPeriodHolder)localObject).next == localMediaPeriodHolder)))
    {
      localObject = this.enabledRenderers;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (!localObject[i].hasReadStreamToEnd()) {
          return;
        }
        i += 1;
      }
      localMediaPeriodHolder.mediaPeriod.maybeThrowPrepareError();
    }
  }
  
  private void maybeTriggerPendingMessages(long paramLong1, long paramLong2)
  {
    if (!this.pendingMessages.isEmpty())
    {
      if (this.playbackInfo.periodId.isAd()) {
        return;
      }
      long l = paramLong1;
      if (this.playbackInfo.startPositionUs == paramLong1) {
        l = paramLong1 - 1L;
      }
      int i = this.playbackInfo.periodId.periodIndex;
      int j = this.nextPendingMessageIndex;
      paramLong1 = l;
      ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo1;
      if (j > 0)
      {
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(j - 1);
      }
      else
      {
        localPendingMessageInfo1 = null;
        l = paramLong1;
      }
      for (;;)
      {
        if ((localPendingMessageInfo1 == null) || ((localPendingMessageInfo1.resolvedPeriodIndex <= i) && ((localPendingMessageInfo1.resolvedPeriodIndex != i) || (localPendingMessageInfo1.resolvedPeriodTimeUs <= l)))) {
          break label174;
        }
        this.nextPendingMessageIndex -= 1;
        j = this.nextPendingMessageIndex;
        paramLong1 = l;
        if (j <= 0) {
          break;
        }
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(j - 1);
      }
      label174:
      paramLong1 = l;
      if (this.nextPendingMessageIndex < this.pendingMessages.size())
      {
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
      }
      else
      {
        localPendingMessageInfo1 = null;
        l = paramLong1;
      }
      ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo2;
      for (;;)
      {
        localPendingMessageInfo2 = localPendingMessageInfo1;
        if (localPendingMessageInfo1 == null) {
          break label322;
        }
        localPendingMessageInfo2 = localPendingMessageInfo1;
        if (localPendingMessageInfo1.resolvedPeriodUid == null) {
          break label322;
        }
        if (localPendingMessageInfo1.resolvedPeriodIndex >= i)
        {
          localPendingMessageInfo2 = localPendingMessageInfo1;
          if (localPendingMessageInfo1.resolvedPeriodIndex != i) {
            break label322;
          }
          localPendingMessageInfo2 = localPendingMessageInfo1;
          if (localPendingMessageInfo1.resolvedPeriodTimeUs > l) {
            break label322;
          }
        }
        this.nextPendingMessageIndex += 1;
        paramLong1 = l;
        if (this.nextPendingMessageIndex >= this.pendingMessages.size()) {
          break;
        }
        localPendingMessageInfo1 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
      }
      label322:
      while ((localPendingMessageInfo2 != null) && (localPendingMessageInfo2.resolvedPeriodUid != null) && (localPendingMessageInfo2.resolvedPeriodIndex == i) && (localPendingMessageInfo2.resolvedPeriodTimeUs > l) && (localPendingMessageInfo2.resolvedPeriodTimeUs <= paramLong2))
      {
        sendMessageToTarget(localPendingMessageInfo2.message);
        if (localPendingMessageInfo2.message.getDeleteAfterDelivery()) {
          this.pendingMessages.remove(this.nextPendingMessageIndex);
        } else {
          this.nextPendingMessageIndex += 1;
        }
        if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
          localPendingMessageInfo2 = (ExoPlayerImplInternal.PendingMessageInfo)this.pendingMessages.get(this.nextPendingMessageIndex);
        } else {
          localPendingMessageInfo2 = null;
        }
      }
    }
  }
  
  private void maybeUpdateLoadingPeriod()
  {
    this.queue.reevaluateBuffer(this.rendererPositionUs);
    if (this.queue.shouldLoadNextMediaPeriod())
    {
      MediaPeriodInfo localMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
      if (localMediaPeriodInfo == null)
      {
        this.mediaSource.maybeThrowSourceInfoRefreshError();
        return;
      }
      Object localObject = this.playbackInfo.timeline.getPeriod(localMediaPeriodInfo.id.periodIndex, this.period, true).uid;
      this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, 60000000L, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, localObject, localMediaPeriodInfo).prepare(this, localMediaPeriodInfo.startPositionUs);
      setIsLoading(true);
    }
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
    if (!this.queue.hasPlayingPeriod()) {
      return;
    }
    float f = this.mediaClock.getPlaybackParameters().speed;
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    Object localObject1 = this.queue.getReadingPeriod();
    int i = 1;
    while (localMediaPeriodHolder != null)
    {
      if (!localMediaPeriodHolder.prepared) {
        return;
      }
      if (localMediaPeriodHolder.selectTracks(f))
      {
        if (i != 0)
        {
          localMediaPeriodHolder = this.queue.getPlayingPeriod();
          boolean bool = this.queue.removeAfter(localMediaPeriodHolder);
          localObject1 = new boolean[this.renderers.length];
          long l = localMediaPeriodHolder.applyTrackSelection(this.playbackInfo.positionUs, bool, (boolean[])localObject1);
          updateLoadControlTrackSelection(localMediaPeriodHolder.trackSelectorResult);
          if ((this.playbackInfo.playbackState != 4) && (l != this.playbackInfo.positionUs))
          {
            localObject2 = this.playbackInfo;
            this.playbackInfo = ((PlaybackInfo)localObject2).fromNewPosition(((PlaybackInfo)localObject2).periodId, l, this.playbackInfo.contentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(4);
            resetRendererPosition(l);
          }
          Object localObject2 = new boolean[this.renderers.length];
          i = 0;
          int k;
          for (int j = 0;; j = k)
          {
            Object localObject3 = this.renderers;
            if (i >= localObject3.length) {
              break;
            }
            localObject3 = localObject3[i];
            if (((Renderer)localObject3).getState() != 0) {
              bool = true;
            } else {
              bool = false;
            }
            localObject2[i] = bool;
            SampleStream localSampleStream = localMediaPeriodHolder.sampleStreams[i];
            k = j;
            if (localSampleStream != null) {
              k = j + 1;
            }
            if (localObject2[i] != 0) {
              if (localSampleStream != ((Renderer)localObject3).getStream()) {
                disableRenderer((Renderer)localObject3);
              } else if (localObject1[i] != 0) {
                ((Renderer)localObject3).resetPosition(this.rendererPositionUs);
              }
            }
            i += 1;
          }
          this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(localMediaPeriodHolder.trackSelectorResult);
          enableRenderers((boolean[])localObject2, j);
        }
        else
        {
          this.queue.removeAfter(localMediaPeriodHolder);
          if (localMediaPeriodHolder.prepared)
          {
            localMediaPeriodHolder.applyTrackSelection(Math.max(localMediaPeriodHolder.info.startPositionUs, localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs)), false);
            updateLoadControlTrackSelection(localMediaPeriodHolder.trackSelectorResult);
          }
        }
        if (this.playbackInfo.playbackState != 4)
        {
          maybeContinueLoading();
          updatePlaybackPositions();
          this.handler.sendEmptyMessage(2);
        }
        return;
      }
      if (localMediaPeriodHolder == localObject1) {
        i = 0;
      }
      localMediaPeriodHolder = localMediaPeriodHolder.next;
    }
  }
  
  private void resetInternal(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.handler.removeMessages(2);
    this.rebuffering = false;
    this.mediaClock.stop();
    this.rendererPositionUs = 60000000L;
    Object localObject2 = this.enabledRenderers;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Renderer localRenderer = localObject2[i];
      try
      {
        disableRenderer(localRenderer);
      }
      catch (RuntimeException localRuntimeException) {}catch (ExoPlaybackException localExoPlaybackException) {}
      Log.e("ExoPlayerImplInternal", "Stop failed.", localExoPlaybackException);
      i += 1;
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
    if (paramBoolean3) {
      localObject1 = Timeline.EMPTY;
    } else {
      localObject1 = this.playbackInfo.timeline;
    }
    if (paramBoolean3) {
      localObject2 = null;
    } else {
      localObject2 = this.playbackInfo.manifest;
    }
    MediaSource.MediaPeriodId localMediaPeriodId;
    if (paramBoolean2) {
      localMediaPeriodId = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
    } else {
      localMediaPeriodId = this.playbackInfo.periodId;
    }
    long l2 = -9223372036854775807L;
    long l1;
    if (paramBoolean2) {
      l1 = -9223372036854775807L;
    } else {
      l1 = this.playbackInfo.positionUs;
    }
    if (!paramBoolean2) {
      l2 = this.playbackInfo.contentPositionUs;
    }
    i = this.playbackInfo.playbackState;
    TrackSelectorResult localTrackSelectorResult;
    if (paramBoolean3) {
      localTrackSelectorResult = this.emptyTrackSelectorResult;
    } else {
      localTrackSelectorResult = this.playbackInfo.trackSelectorResult;
    }
    this.playbackInfo = new PlaybackInfo((Timeline)localObject1, localObject2, localMediaPeriodId, l1, l2, i, false, localTrackSelectorResult);
    if (paramBoolean1)
    {
      localObject1 = this.mediaSource;
      if (localObject1 != null)
      {
        ((MediaSource)localObject1).releaseSource();
        this.mediaSource = null;
      }
    }
  }
  
  private void resetRendererPosition(long paramLong)
  {
    if (!this.queue.hasPlayingPeriod()) {
      paramLong += 60000000L;
    } else {
      paramLong = this.queue.getPlayingPeriod().toRendererTime(paramLong);
    }
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
  
  private boolean resolvePendingMessagePosition(ExoPlayerImplInternal.PendingMessageInfo paramPendingMessageInfo)
  {
    if (paramPendingMessageInfo.resolvedPeriodUid == null)
    {
      Pair localPair = resolveSeekPosition(new ExoPlayerImplInternal.SeekPosition(paramPendingMessageInfo.message.getTimeline(), paramPendingMessageInfo.message.getWindowIndex(), C.msToUs(paramPendingMessageInfo.message.getPositionMs())), false);
      if (localPair == null) {
        return false;
      }
      paramPendingMessageInfo.setResolvedPosition(((Integer)localPair.first).intValue(), ((Long)localPair.second).longValue(), this.playbackInfo.timeline.getPeriod(((Integer)localPair.first).intValue(), this.period, true).uid);
      return true;
    }
    int i = this.playbackInfo.timeline.getIndexOfPeriod(paramPendingMessageInfo.resolvedPeriodUid);
    if (i == -1) {
      return false;
    }
    paramPendingMessageInfo.resolvedPeriodIndex = i;
    return true;
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
      int i = localTimeline.getIndexOfPeriod(((Timeline)localObject1).getPeriod(((Integer)((Pair)localObject2).first).intValue(), this.period, true).uid);
      if (i != -1) {
        return Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      }
      if (paramBoolean)
      {
        i = resolveSubsequentPeriod(((Integer)((Pair)localObject2).first).intValue(), (Timeline)localObject1, localTimeline);
        if (i != -1) {
          return getPeriodPosition(localTimeline, localTimeline.getPeriod(i, this.period).windowIndex, -9223372036854775807L);
        }
      }
      return null;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label176:
      break label176;
    }
    throw new IllegalSeekPositionException(localTimeline, paramSeekPosition.windowIndex, paramSeekPosition.windowPositionUs);
  }
  
  private int resolveSubsequentPeriod(int paramInt, Timeline paramTimeline1, Timeline paramTimeline2)
  {
    int k = paramTimeline1.getPeriodCount();
    int i = 0;
    int j = paramInt;
    paramInt = -1;
    while ((i < k) && (paramInt == -1))
    {
      j = paramTimeline1.getNextPeriodIndex(j, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
      if (j == -1) {
        return paramInt;
      }
      paramInt = paramTimeline2.getIndexOfPeriod(paramTimeline1.getPeriod(j, this.period, true).uid);
      i += 1;
    }
    return paramInt;
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
      PlaybackInfo localPlaybackInfo = this.playbackInfo;
      this.playbackInfo = localPlaybackInfo.fromNewPosition(localMediaPeriodId, l, localPlaybackInfo.contentPositionUs);
      if (paramBoolean) {
        this.playbackInfoUpdate.setPositionDiscontinuity(4);
      }
    }
  }
  
  private void seekToInternal(ExoPlayerImplInternal.SeekPosition paramSeekPosition)
  {
    localObject = this.playbackInfoUpdate;
    j = 1;
    ((ExoPlayerImplInternal.PlaybackInfoUpdate)localObject).incrementPendingOperationAcks(1);
    Pair localPair = resolveSeekPosition(paramSeekPosition, true);
    if (localPair == null)
    {
      localObject = new MediaSource.MediaPeriodId(getFirstPeriodIndex());
      l1 = -9223372036854775807L;
      l2 = l1;
    }
    for (;;)
    {
      i = 1;
      l3 = l2;
      break label156;
      i = ((Integer)localPair.first).intValue();
      l1 = ((Long)localPair.second).longValue();
      localObject = this.queue.resolveMediaPeriodIdForAds(i, l1);
      if (!((MediaSource.MediaPeriodId)localObject).isAd()) {
        break;
      }
      l3 = 0L;
      l2 = l1;
      l1 = l3;
    }
    l2 = ((Long)localPair.second).longValue();
    if (paramSeekPosition.windowPositionUs == -9223372036854775807L) {
      i = 1;
    } else {
      i = 0;
    }
    l3 = l1;
    l1 = l2;
    try
    {
      label156:
      if ((this.mediaSource == null) || (this.pendingPrepareCount > 0)) {
        break label338;
      }
      if (l1 == -9223372036854775807L)
      {
        setState(4);
        resetInternal(false, true, false);
        break label343;
      }
      if (!((MediaSource.MediaPeriodId)localObject).equals(this.playbackInfo.periodId)) {
        break label313;
      }
      paramSeekPosition = this.queue.getPlayingPeriod();
      if ((paramSeekPosition == null) || (l1 == 0L)) {
        break label411;
      }
      l2 = paramSeekPosition.mediaPeriod.getAdjustedSeekPositionUs(l1, this.seekParameters);
    }
    finally
    {
      for (;;)
      {
        long l4;
        this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject, l1, l3);
        if (i != 0) {
          this.playbackInfoUpdate.setPositionDiscontinuity(2);
        }
        for (;;)
        {
          throw paramSeekPosition;
        }
        l2 = l1;
        continue;
        j = 0;
        i |= j;
        l1 = l2;
      }
    }
    l4 = l2;
    if (C.usToMs(l2) == C.usToMs(this.playbackInfo.positionUs))
    {
      l2 = this.playbackInfo.positionUs;
      this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject, l2, l3);
      if (i != 0) {
        this.playbackInfoUpdate.setPositionDiscontinuity(2);
      }
      return;
      label313:
      l4 = l1;
    }
    l2 = seekToPeriodPosition((MediaSource.MediaPeriodId)localObject, l4);
    if (l1 != l2)
    {
      break label420;
      label338:
      this.pendingInitialSeekPosition = paramSeekPosition;
      label343:
      this.playbackInfo = this.playbackInfo.fromNewPosition((MediaSource.MediaPeriodId)localObject, l1, l3);
      if (i != 0) {
        this.playbackInfoUpdate.setPositionDiscontinuity(2);
      }
    }
  }
  
  private long seekToPeriodPosition(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong)
  {
    boolean bool;
    if (this.queue.getPlayingPeriod() != this.queue.getReadingPeriod()) {
      bool = true;
    } else {
      bool = false;
    }
    return seekToPeriodPosition(paramMediaPeriodId, paramLong, bool);
  }
  
  private long seekToPeriodPosition(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong, boolean paramBoolean)
  {
    stopRenderers();
    this.rebuffering = false;
    setState(2);
    MediaPeriodHolder localMediaPeriodHolder2 = this.queue.getPlayingPeriod();
    for (MediaPeriodHolder localMediaPeriodHolder1 = localMediaPeriodHolder2; localMediaPeriodHolder1 != null; localMediaPeriodHolder1 = this.queue.advancePlayingPeriod()) {
      if (shouldKeepPeriodHolder(paramMediaPeriodId, paramLong, localMediaPeriodHolder1))
      {
        this.queue.removeAfter(localMediaPeriodHolder1);
        break;
      }
    }
    if ((localMediaPeriodHolder2 != localMediaPeriodHolder1) || (paramBoolean))
    {
      paramMediaPeriodId = this.enabledRenderers;
      int j = paramMediaPeriodId.length;
      int i = 0;
      while (i < j)
      {
        disableRenderer(paramMediaPeriodId[i]);
        i += 1;
      }
      this.enabledRenderers = new Renderer[0];
      localMediaPeriodHolder2 = null;
    }
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
    else
    {
      this.queue.clear();
      resetRendererPosition(paramLong);
    }
    this.handler.sendEmptyMessage(2);
    return paramLong;
  }
  
  private void sendMessageInternal(PlayerMessage paramPlayerMessage)
  {
    if (paramPlayerMessage.getPositionMs() == -9223372036854775807L)
    {
      sendMessageToTarget(paramPlayerMessage);
      return;
    }
    if ((this.mediaSource != null) && (this.pendingPrepareCount <= 0))
    {
      ExoPlayerImplInternal.PendingMessageInfo localPendingMessageInfo = new ExoPlayerImplInternal.PendingMessageInfo(paramPlayerMessage);
      if (resolvePendingMessagePosition(localPendingMessageInfo))
      {
        this.pendingMessages.add(localPendingMessageInfo);
        Collections.sort(this.pendingMessages);
        return;
      }
      paramPlayerMessage.markAsProcessed(false);
      return;
    }
    this.pendingMessages.add(new ExoPlayerImplInternal.PendingMessageInfo(paramPlayerMessage));
  }
  
  private void sendMessageToTarget(PlayerMessage paramPlayerMessage)
  {
    if (paramPlayerMessage.getHandler().getLooper() == this.handler.getLooper())
    {
      deliverMessage(paramPlayerMessage);
      if ((this.playbackInfo.playbackState == 3) || (this.playbackInfo.playbackState == 2)) {
        this.handler.sendEmptyMessage(2);
      }
    }
    else
    {
      this.handler.obtainMessage(15, paramPlayerMessage).sendToTarget();
    }
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
      return;
    }
    if (this.playbackInfo.playbackState == 3)
    {
      startRenderers();
      this.handler.sendEmptyMessage(2);
      return;
    }
    if (this.playbackInfo.playbackState == 2) {
      this.handler.sendEmptyMessage(2);
    }
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
    if (this.enabledRenderers.length == 0) {
      return isTimelineReady();
    }
    boolean bool = false;
    if (!paramBoolean) {
      return false;
    }
    if (!this.playbackInfo.isLoading) {
      return true;
    }
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getLoadingPeriod();
    long l = localMediaPeriodHolder.getBufferedPositionUs(localMediaPeriodHolder.info.isFinal ^ true);
    if (l != -9223372036854775808L)
    {
      paramBoolean = bool;
      if (!this.loadControl.shouldStartPlayback(l - localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs), this.mediaClock.getPlaybackParameters().speed, this.rebuffering)) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    Object localObject1 = this.mediaSource;
    if (localObject1 == null) {
      return;
    }
    if (this.pendingPrepareCount > 0)
    {
      ((MediaSource)localObject1).maybeThrowSourceInfoRefreshError();
      return;
    }
    maybeUpdateLoadingPeriod();
    localObject1 = this.queue.getLoadingPeriod();
    int j = 0;
    if ((localObject1 != null) && (!((MediaPeriodHolder)localObject1).isFullyBuffered()))
    {
      if (!this.playbackInfo.isLoading) {
        maybeContinueLoading();
      }
    }
    else {
      setIsLoading(false);
    }
    if (!this.queue.hasPlayingPeriod()) {
      return;
    }
    localObject1 = this.queue.getPlayingPeriod();
    Object localObject3 = this.queue.getReadingPeriod();
    Object localObject2;
    for (int i = 0; (this.playWhenReady) && (localObject1 != localObject3) && (this.rendererPositionUs >= ((MediaPeriodHolder)localObject1).next.rendererPositionOffsetUs); i = 1)
    {
      if (i != 0) {
        maybeNotifyPlaybackInfoChanged();
      }
      if (((MediaPeriodHolder)localObject1).info.isLastInTimelinePeriod) {
        i = 0;
      } else {
        i = 3;
      }
      localObject2 = this.queue.advancePlayingPeriod();
      updatePlayingPeriodRenderers((MediaPeriodHolder)localObject1);
      this.playbackInfo = this.playbackInfo.fromNewPosition(((MediaPeriodHolder)localObject2).info.id, ((MediaPeriodHolder)localObject2).info.startPositionUs, ((MediaPeriodHolder)localObject2).info.contentPositionUs);
      this.playbackInfoUpdate.setPositionDiscontinuity(i);
      updatePlaybackPositions();
      localObject1 = localObject2;
    }
    if (((MediaPeriodHolder)localObject3).info.isFinal)
    {
      i = j;
      for (;;)
      {
        localObject1 = this.renderers;
        if (i >= localObject1.length) {
          break;
        }
        localObject1 = localObject1[i];
        localObject2 = localObject3.sampleStreams[i];
        if ((localObject2 != null) && (((Renderer)localObject1).getStream() == localObject2) && (((Renderer)localObject1).hasReadStreamToEnd())) {
          ((Renderer)localObject1).setCurrentStreamFinal();
        }
        i += 1;
      }
      return;
    }
    if (((MediaPeriodHolder)localObject3).next != null)
    {
      if (!((MediaPeriodHolder)localObject3).next.prepared) {
        return;
      }
      i = 0;
      for (;;)
      {
        localObject1 = this.renderers;
        if (i >= localObject1.length) {
          break label407;
        }
        localObject1 = localObject1[i];
        localObject2 = localObject3.sampleStreams[i];
        if (((Renderer)localObject1).getStream() != localObject2) {
          break;
        }
        if ((localObject2 != null) && (!((Renderer)localObject1).hasReadStreamToEnd())) {
          return;
        }
        i += 1;
      }
      return;
      label407:
      localObject1 = ((MediaPeriodHolder)localObject3).trackSelectorResult;
      localObject2 = this.queue.advanceReadingPeriod();
      localObject3 = ((MediaPeriodHolder)localObject2).trackSelectorResult;
      if (((MediaPeriodHolder)localObject2).mediaPeriod.readDiscontinuity() != -9223372036854775807L) {
        i = 1;
      } else {
        i = 0;
      }
      j = 0;
      for (;;)
      {
        Object localObject4 = this.renderers;
        if (j >= localObject4.length) {
          break;
        }
        localObject4 = localObject4[j];
        if (localObject1.renderersEnabled[j] != 0) {
          if (i != 0)
          {
            ((Renderer)localObject4).setCurrentStreamFinal();
          }
          else if (!((Renderer)localObject4).isCurrentStreamFinal())
          {
            TrackSelection localTrackSelection = ((TrackSelectorResult)localObject3).selections.get(j);
            int m = localObject3.renderersEnabled[j];
            int k;
            if (this.rendererCapabilities[j].getTrackType() == 5) {
              k = 1;
            } else {
              k = 0;
            }
            RendererConfiguration localRendererConfiguration1 = localObject1.rendererConfigurations[j];
            RendererConfiguration localRendererConfiguration2 = localObject3.rendererConfigurations[j];
            if ((m != 0) && (localRendererConfiguration2.equals(localRendererConfiguration1)) && (k == 0)) {
              ((Renderer)localObject4).replaceStream(getFormats(localTrackSelection), localObject2.sampleStreams[j], ((MediaPeriodHolder)localObject2).getRendererOffset());
            } else {
              ((Renderer)localObject4).setCurrentStreamFinal();
            }
          }
        }
        j += 1;
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
    if (l != -9223372036854775807L)
    {
      resetRendererPosition(l);
      if (l != this.playbackInfo.positionUs)
      {
        localPlaybackInfo = this.playbackInfo;
        this.playbackInfo = localPlaybackInfo.fromNewPosition(localPlaybackInfo.periodId, l, this.playbackInfo.contentPositionUs);
        this.playbackInfoUpdate.setPositionDiscontinuity(4);
      }
    }
    else
    {
      this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs();
      l = localMediaPeriodHolder.toPeriodTime(this.rendererPositionUs);
      maybeTriggerPendingMessages(this.playbackInfo.positionUs, l);
      this.playbackInfo.positionUs = l;
    }
    PlaybackInfo localPlaybackInfo = this.playbackInfo;
    if (this.enabledRenderers.length == 0) {
      l = localMediaPeriodHolder.info.durationUs;
    } else {
      l = localMediaPeriodHolder.getBufferedPositionUs(true);
    }
    localPlaybackInfo.bufferedPositionUs = l;
  }
  
  private void updatePlayingPeriodRenderers(@Nullable MediaPeriodHolder paramMediaPeriodHolder)
  {
    MediaPeriodHolder localMediaPeriodHolder = this.queue.getPlayingPeriod();
    if (localMediaPeriodHolder != null)
    {
      if (paramMediaPeriodHolder == localMediaPeriodHolder) {
        return;
      }
      boolean[] arrayOfBoolean = new boolean[this.renderers.length];
      int i = 0;
      int k;
      for (int j = 0;; j = k)
      {
        Object localObject = this.renderers;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        int m;
        if (((Renderer)localObject).getState() != 0) {
          m = 1;
        } else {
          m = 0;
        }
        arrayOfBoolean[i] = m;
        k = j;
        if (localMediaPeriodHolder.trackSelectorResult.renderersEnabled[i] != 0) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localMediaPeriodHolder.trackSelectorResult.renderersEnabled[i] == 0) || ((((Renderer)localObject).isCurrentStreamFinal()) && (((Renderer)localObject).getStream() == paramMediaPeriodHolder.sampleStreams[i])))) {
          disableRenderer((Renderer)localObject);
        }
        i += 1;
      }
      this.playbackInfo = this.playbackInfo.copyWithTrackSelectorResult(localMediaPeriodHolder.trackSelectorResult);
      enableRenderers(arrayOfBoolean, j);
    }
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
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 15: 
          sendMessageToTargetThread((PlayerMessage)paramMessage.obj);
          break;
        case 14: 
          sendMessageInternal((PlayerMessage)paramMessage.obj);
          break;
        case 13: 
          if (paramMessage.arg1 == 0) {
            break label448;
          }
          bool1 = true;
          setShuffleModeEnabledInternal(bool1);
          break;
        case 12: 
          setRepeatModeInternal(paramMessage.arg1);
          break;
        case 11: 
          reselectTracksInternal();
          break;
        case 10: 
          handleContinueLoadingRequested((MediaPeriod)paramMessage.obj);
          break;
        case 9: 
          handlePeriodPrepared((MediaPeriod)paramMessage.obj);
          break;
        case 8: 
          handleSourceInfoRefreshed((ExoPlayerImplInternal.MediaSourceRefreshInfo)paramMessage.obj);
          break;
        case 7: 
          releaseInternal();
          return true;
        case 6: 
          if (paramMessage.arg1 == 0) {
            break label453;
          }
          bool1 = true;
          stopInternal(bool1, true);
          break;
        case 5: 
          setSeekParametersInternal((SeekParameters)paramMessage.obj);
          break;
        case 4: 
          setPlaybackParametersInternal((PlaybackParameters)paramMessage.obj);
          break;
        case 3: 
          seekToInternal((ExoPlayerImplInternal.SeekPosition)paramMessage.obj);
          break;
        case 2: 
          doSomeWork();
          break;
        case 1: 
          if (paramMessage.arg1 == 0) {
            break label458;
          }
          bool1 = true;
          setPlayWhenReadyInternal(bool1);
          break;
        case 0: 
          MediaSource localMediaSource = (MediaSource)paramMessage.obj;
          if (paramMessage.arg1 == 0) {
            break label463;
          }
          bool1 = true;
          if (paramMessage.arg2 == 0) {
            break label468;
          }
          bool2 = true;
          prepareInternal(localMediaSource, bool1, bool2);
          maybeNotifyPlaybackInfoChanged();
          return true;
        }
      }
      catch (RuntimeException paramMessage)
      {
        Log.e("ExoPlayerImplInternal", "Internal runtime error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, ExoPlaybackException.createForUnexpected(paramMessage)).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
        return true;
      }
      catch (IOException paramMessage)
      {
        Log.e("ExoPlayerImplInternal", "Source error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(paramMessage)).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
        return true;
      }
      catch (ExoPlaybackException paramMessage)
      {
        Log.e("ExoPlayerImplInternal", "Playback error.", paramMessage);
        stopInternal(false, false);
        this.eventHandler.obtainMessage(2, paramMessage).sendToTarget();
        maybeNotifyPlaybackInfoChanged();
        return true;
      }
      return false;
      label448:
      boolean bool1 = false;
      continue;
      label453:
      bool1 = false;
      continue;
      label458:
      bool1 = false;
      continue;
      label463:
      bool1 = false;
      continue;
      label468:
      boolean bool2 = false;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void release()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.released;
        if (bool) {
          return;
        }
        this.handler.sendEmptyMessage(7);
        i = 0;
        bool = this.released;
        if (bool) {
          break;
        }
      }
      finally
      {
        int i;
        continue;
        throw localObject;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      i = 1;
    }
    if (i != 0) {
      Thread.currentThread().interrupt();
    }
  }
  
  public void seekTo(Timeline paramTimeline, int paramInt, long paramLong)
  {
    this.handler.obtainMessage(3, new ExoPlayerImplInternal.SeekPosition(paramTimeline, paramInt, paramLong)).sendToTarget();
  }
  
  public void sendMessage(PlayerMessage paramPlayerMessage)
  {
    try
    {
      if (this.released)
      {
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        paramPlayerMessage.markAsProcessed(false);
        return;
      }
      this.handler.obtainMessage(14, paramPlayerMessage).sendToTarget();
      return;
    }
    finally {}
  }
  
  public void setPlayWhenReady(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void stop(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal
 * JD-Core Version:    0.7.0.1
 */