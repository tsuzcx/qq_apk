package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger
  implements Player.EventListener, AudioRendererEventListener, DefaultDrmSessionManager.EventListener, MetadataOutput, MediaSourceEventListener, AdsMediaSource.EventListener, VideoRendererEventListener
{
  private static final int MAX_TIMELINE_ITEM_LINES = 3;
  private static final String TAG = "EventLogger";
  private static final NumberFormat TIME_FORMAT = NumberFormat.getInstance(Locale.US);
  private final Timeline.Period period;
  private final long startTimeMs;
  private final MappingTrackSelector trackSelector;
  private final Timeline.Window window;
  
  static
  {
    TIME_FORMAT.setMinimumFractionDigits(2);
    TIME_FORMAT.setMaximumFractionDigits(2);
    TIME_FORMAT.setGroupingUsed(false);
  }
  
  public EventLogger(MappingTrackSelector paramMappingTrackSelector)
  {
    this.trackSelector = paramMappingTrackSelector;
    this.window = new Timeline.Window();
    this.period = new Timeline.Period();
    this.startTimeMs = SystemClock.elapsedRealtime();
  }
  
  private static String getAdaptiveSupportString(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 2) {
      return "N/A";
    }
    switch (paramInt2)
    {
    default: 
      return "?";
    case 16: 
      return "YES";
    case 8: 
      return "YES_NOT_SEAMLESS";
    }
    return "NO";
  }
  
  private static String getDiscontinuityReasonString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 0: 
      return "PERIOD_TRANSITION";
    case 1: 
      return "SEEK";
    case 2: 
      return "SEEK_ADJUSTMENT";
    case 3: 
      return "AD_INSERTION";
    }
    return "INTERNAL";
  }
  
  private static String getFormatSupportString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 4: 
      return "YES";
    case 3: 
      return "NO_EXCEEDS_CAPABILITIES";
    case 2: 
      return "NO_UNSUPPORTED_DRM";
    case 1: 
      return "NO_UNSUPPORTED_TYPE";
    }
    return "NO";
  }
  
  private static String getRepeatModeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 0: 
      return "OFF";
    case 1: 
      return "ONE";
    }
    return "ALL";
  }
  
  private String getSessionTimeString()
  {
    return getTimeString(SystemClock.elapsedRealtime() - this.startTimeMs);
  }
  
  private static String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 2: 
      return "B";
    case 4: 
      return "E";
    case 1: 
      return "I";
    }
    return "R";
  }
  
  private static String getTimeString(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return "?";
    }
    return TIME_FORMAT.format((float)paramLong / 1000.0F);
  }
  
  private static String getTimelineChangeReasonString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 0: 
      return "PREPARED";
    case 1: 
      return "RESET";
    }
    return "DYNAMIC";
  }
  
  private static String getTrackStatusString(TrackSelection paramTrackSelection, TrackGroup paramTrackGroup, int paramInt)
  {
    if ((paramTrackSelection != null) && (paramTrackSelection.getTrackGroup() == paramTrackGroup) && (paramTrackSelection.indexOf(paramInt) != -1)) {}
    for (boolean bool = true;; bool = false) {
      return getTrackStatusString(bool);
    }
  }
  
  private static String getTrackStatusString(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "[X]";
    }
    return "[ ]";
  }
  
  private void printInternalError(String paramString, Exception paramException)
  {
    Log.e("EventLogger", "internalError [" + getSessionTimeString() + ", " + paramString + "]", paramException);
  }
  
  private void printMetadata(Metadata paramMetadata, String paramString)
  {
    int i = 0;
    if (i < paramMetadata.length())
    {
      Object localObject = paramMetadata.get(i);
      if ((localObject instanceof TextInformationFrame))
      {
        localObject = (TextInformationFrame)localObject;
        Log.d("EventLogger", paramString + String.format("%s: value=%s", new Object[] { ((TextInformationFrame)localObject).id, ((TextInformationFrame)localObject).value }));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof UrlLinkFrame))
        {
          localObject = (UrlLinkFrame)localObject;
          Log.d("EventLogger", paramString + String.format("%s: url=%s", new Object[] { ((UrlLinkFrame)localObject).id, ((UrlLinkFrame)localObject).url }));
        }
        else if ((localObject instanceof PrivFrame))
        {
          localObject = (PrivFrame)localObject;
          Log.d("EventLogger", paramString + String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).owner }));
        }
        else if ((localObject instanceof GeobFrame))
        {
          localObject = (GeobFrame)localObject;
          Log.d("EventLogger", paramString + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((GeobFrame)localObject).id, ((GeobFrame)localObject).mimeType, ((GeobFrame)localObject).filename, ((GeobFrame)localObject).description }));
        }
        else if ((localObject instanceof ApicFrame))
        {
          localObject = (ApicFrame)localObject;
          Log.d("EventLogger", paramString + String.format("%s: mimeType=%s, description=%s", new Object[] { ((ApicFrame)localObject).id, ((ApicFrame)localObject).mimeType, ((ApicFrame)localObject).description }));
        }
        else if ((localObject instanceof CommentFrame))
        {
          localObject = (CommentFrame)localObject;
          Log.d("EventLogger", paramString + String.format("%s: language=%s, description=%s", new Object[] { ((CommentFrame)localObject).id, ((CommentFrame)localObject).language, ((CommentFrame)localObject).description }));
        }
        else if ((localObject instanceof Id3Frame))
        {
          localObject = (Id3Frame)localObject;
          Log.d("EventLogger", paramString + String.format("%s", new Object[] { ((Id3Frame)localObject).id }));
        }
        else if ((localObject instanceof EventMessage))
        {
          localObject = (EventMessage)localObject;
          Log.d("EventLogger", paramString + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).schemeIdUri, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        }
        else if ((localObject instanceof SpliceCommand))
        {
          localObject = String.format("SCTE-35 splice command: type=%s.", new Object[] { localObject.getClass().getSimpleName() });
          Log.d("EventLogger", paramString + (String)localObject);
        }
      }
    }
  }
  
  public boolean isNeedAudioData()
  {
    return false;
  }
  
  public void onAdClicked() {}
  
  public void onAdLoadError(IOException paramIOException)
  {
    printInternalError("adLoadError", paramIOException);
  }
  
  public void onAdTapped() {}
  
  public void onAudioDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    Log.d("EventLogger", "audioDecoderInitialized [" + getSessionTimeString() + ", " + paramString + "]");
  }
  
  public void onAudioDisabled(DecoderCounters paramDecoderCounters)
  {
    Log.d("EventLogger", "audioDisabled [" + getSessionTimeString() + "]");
  }
  
  public void onAudioEnabled(DecoderCounters paramDecoderCounters)
  {
    Log.d("EventLogger", "audioEnabled [" + getSessionTimeString() + "]");
  }
  
  public void onAudioInputFormatChanged(Format paramFormat)
  {
    Log.d("EventLogger", "audioFormatChanged [" + getSessionTimeString() + ", " + Format.toLogString(paramFormat) + "]");
  }
  
  public void onAudioSessionId(int paramInt)
  {
    Log.d("EventLogger", "audioSessionId [" + paramInt + "]");
  }
  
  public void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    printInternalError("audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
  }
  
  public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
  
  public void onDrmKeysLoaded()
  {
    Log.d("EventLogger", "drmKeysLoaded [" + getSessionTimeString() + "]");
  }
  
  public void onDrmKeysRemoved()
  {
    Log.d("EventLogger", "drmKeysRemoved [" + getSessionTimeString() + "]");
  }
  
  public void onDrmKeysRestored()
  {
    Log.d("EventLogger", "drmKeysRestored [" + getSessionTimeString() + "]");
  }
  
  public void onDrmSessionManagerError(Exception paramException)
  {
    printInternalError("drmSessionManagerError", paramException);
  }
  
  public void onDroppedFrames(int paramInt, long paramLong)
  {
    Log.d("EventLogger", "droppedFrames [" + getSessionTimeString() + ", " + paramInt + "]");
  }
  
  public void onInternalAdLoadError(RuntimeException paramRuntimeException)
  {
    printInternalError("internalAdLoadError", paramRuntimeException);
  }
  
  public void onLoadCanceled(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadCompleted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadError(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    printInternalError("loadError", paramIOException);
  }
  
  public void onLoadStarted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onLoadingChanged(boolean paramBoolean)
  {
    Log.d("EventLogger", "loading [" + paramBoolean + "]");
  }
  
  public void onMetadata(Metadata paramMetadata)
  {
    Log.d("EventLogger", "onMetadata [");
    printMetadata(paramMetadata, "  ");
    Log.d("EventLogger", "]");
  }
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters)
  {
    Log.d("EventLogger", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramPlaybackParameters.speed), Float.valueOf(paramPlaybackParameters.pitch) }));
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    Log.e("EventLogger", "playerFailed [" + getSessionTimeString() + "]", paramExoPlaybackException);
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    Log.d("EventLogger", "state [" + getSessionTimeString() + ", " + paramBoolean + ", " + getStateString(paramInt) + "]");
  }
  
  public void onPositionDiscontinuity(int paramInt)
  {
    Log.d("EventLogger", "positionDiscontinuity [" + getDiscontinuityReasonString(paramInt) + "]");
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte) {}
  
  public void onRenderedFirstFrame(Surface paramSurface)
  {
    Log.d("EventLogger", "renderedFirstFrame [" + paramSurface + "]");
  }
  
  public void onRepeatModeChanged(int paramInt)
  {
    Log.d("EventLogger", "repeatMode [" + getRepeatModeString(paramInt) + "]");
  }
  
  public void onSeekProcessed()
  {
    Log.d("EventLogger", "seekProcessed");
  }
  
  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
    Log.d("EventLogger", "shuffleModeEnabled [" + paramBoolean + "]");
  }
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt)
  {
    int i = 0;
    int k = paramTimeline.getPeriodCount();
    int j = paramTimeline.getWindowCount();
    Log.d("EventLogger", "timelineChanged [periodCount=" + k + ", windowCount=" + j + ", reason=" + getTimelineChangeReasonString(paramInt));
    paramInt = 0;
    while (paramInt < Math.min(k, 3))
    {
      paramTimeline.getPeriod(paramInt, this.period);
      Log.d("EventLogger", "  period [" + getTimeString(this.period.getDurationMs()) + "]");
      paramInt += 1;
    }
    paramInt = i;
    if (k > 3)
    {
      Log.d("EventLogger", "  ...");
      paramInt = i;
    }
    while (paramInt < Math.min(j, 3))
    {
      paramTimeline.getWindow(paramInt, this.window);
      Log.d("EventLogger", "  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
      paramInt += 1;
    }
    if (j > 3) {
      Log.d("EventLogger", "  ...");
    }
    Log.d("EventLogger", "]");
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    paramTrackGroupArray = this.trackSelector.getCurrentMappedTrackInfo();
    if (paramTrackGroupArray == null)
    {
      Log.d("EventLogger", "Tracks []");
      return;
    }
    Log.d("EventLogger", "Tracks [");
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < paramTrackGroupArray.length)
    {
      localObject2 = paramTrackGroupArray.getTrackGroups(i);
      localObject1 = paramTrackSelectionArray.get(i);
      if (((TrackGroupArray)localObject2).length > 0)
      {
        Log.d("EventLogger", "  Renderer:" + i + " [");
        j = 0;
        while (j < ((TrackGroupArray)localObject2).length)
        {
          TrackGroup localTrackGroup = ((TrackGroupArray)localObject2).get(j);
          String str1 = getAdaptiveSupportString(localTrackGroup.length, paramTrackGroupArray.getAdaptiveSupport(i, j, false));
          Log.d("EventLogger", "    Group:" + j + ", adaptive_supported=" + str1 + " [");
          int k = 0;
          while (k < localTrackGroup.length)
          {
            str1 = getTrackStatusString((TrackSelection)localObject1, localTrackGroup, k);
            String str2 = getFormatSupportString(paramTrackGroupArray.getTrackFormatSupport(i, j, k));
            Log.d("EventLogger", "      " + str1 + " Track:" + k + ", " + Format.toLogString(localTrackGroup.getFormat(k)) + ", supported=" + str2);
            k += 1;
          }
          Log.d("EventLogger", "    ]");
          j += 1;
        }
        if (localObject1 != null) {
          j = 0;
        }
      }
      for (;;)
      {
        if (j < ((TrackSelection)localObject1).length())
        {
          localObject2 = ((TrackSelection)localObject1).getFormat(j).metadata;
          if (localObject2 != null)
          {
            Log.d("EventLogger", "    Metadata [");
            printMetadata((Metadata)localObject2, "      ");
            Log.d("EventLogger", "    ]");
          }
        }
        else
        {
          Log.d("EventLogger", "  ]");
          i += 1;
          break;
        }
        j += 1;
      }
    }
    paramTrackGroupArray = paramTrackGroupArray.getUnassociatedTrackGroups();
    if (paramTrackGroupArray.length > 0)
    {
      Log.d("EventLogger", "  Renderer:None [");
      i = 0;
      while (i < paramTrackGroupArray.length)
      {
        Log.d("EventLogger", "    Group:" + i + " [");
        paramTrackSelectionArray = paramTrackGroupArray.get(i);
        j = 0;
        while (j < paramTrackSelectionArray.length)
        {
          localObject1 = getTrackStatusString(false);
          localObject2 = getFormatSupportString(0);
          Log.d("EventLogger", "      " + (String)localObject1 + " Track:" + j + ", " + Format.toLogString(paramTrackSelectionArray.getFormat(j)) + ", supported=" + (String)localObject2);
          j += 1;
        }
        Log.d("EventLogger", "    ]");
        i += 1;
      }
      Log.d("EventLogger", "  ]");
    }
    Log.d("EventLogger", "]");
  }
  
  public void onUpstreamDiscarded(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onVideoDecoderInitialized(String paramString, long paramLong1, long paramLong2)
  {
    Log.d("EventLogger", "videoDecoderInitialized [" + getSessionTimeString() + ", " + paramString + "]");
  }
  
  public void onVideoDisabled(DecoderCounters paramDecoderCounters)
  {
    Log.d("EventLogger", "videoDisabled [" + getSessionTimeString() + "]");
  }
  
  public void onVideoEnabled(DecoderCounters paramDecoderCounters)
  {
    Log.d("EventLogger", "videoEnabled [" + getSessionTimeString() + "]");
  }
  
  public void onVideoInputFormatChanged(Format paramFormat)
  {
    Log.d("EventLogger", "videoFormatChanged [" + getSessionTimeString() + ", " + Format.toLogString(paramFormat) + "]");
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Log.d("EventLogger", "videoSizeChanged [" + paramInt1 + ", " + paramInt2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.EventLogger
 * JD-Core Version:    0.7.0.1
 */