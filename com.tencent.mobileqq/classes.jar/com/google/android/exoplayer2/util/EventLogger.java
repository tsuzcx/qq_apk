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
    if (paramInt2 != 0)
    {
      if (paramInt2 != 8)
      {
        if (paramInt2 != 16) {
          return "?";
        }
        return "YES";
      }
      return "YES_NOT_SEAMLESS";
    }
    return "NO";
  }
  
  private static String getDiscontinuityReasonString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "?";
            }
            return "INTERNAL";
          }
          return "AD_INSERTION";
        }
        return "SEEK_ADJUSTMENT";
      }
      return "SEEK";
    }
    return "PERIOD_TRANSITION";
  }
  
  private static String getFormatSupportString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "?";
            }
            return "YES";
          }
          return "NO_EXCEEDS_CAPABILITIES";
        }
        return "NO_UNSUPPORTED_DRM";
      }
      return "NO_UNSUPPORTED_TYPE";
    }
    return "NO";
  }
  
  private static String getRepeatModeString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "?";
        }
        return "ALL";
      }
      return "ONE";
    }
    return "OFF";
  }
  
  private String getSessionTimeString()
  {
    return getTimeString(SystemClock.elapsedRealtime() - this.startTimeMs);
  }
  
  private static String getStateString(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "?";
          }
          return "E";
        }
        return "R";
      }
      return "B";
    }
    return "I";
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "?";
        }
        return "DYNAMIC";
      }
      return "RESET";
    }
    return "PREPARED";
  }
  
  private static String getTrackStatusString(TrackSelection paramTrackSelection, TrackGroup paramTrackGroup, int paramInt)
  {
    boolean bool;
    if ((paramTrackSelection != null) && (paramTrackSelection.getTrackGroup() == paramTrackGroup) && (paramTrackSelection.indexOf(paramInt) != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    return getTrackStatusString(bool);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("internalError [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.e("EventLogger", localStringBuilder.toString(), paramException);
  }
  
  private void printMetadata(Metadata paramMetadata, String paramString)
  {
    int i = 0;
    while (i < paramMetadata.length())
    {
      Object localObject = paramMetadata.get(i);
      StringBuilder localStringBuilder;
      if ((localObject instanceof TextInformationFrame))
      {
        localObject = (TextInformationFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: value=%s", new Object[] { ((TextInformationFrame)localObject).id, ((TextInformationFrame)localObject).value }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof UrlLinkFrame))
      {
        localObject = (UrlLinkFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: url=%s", new Object[] { ((UrlLinkFrame)localObject).id, ((UrlLinkFrame)localObject).url }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof PrivFrame))
      {
        localObject = (PrivFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: owner=%s", new Object[] { ((PrivFrame)localObject).id, ((PrivFrame)localObject).owner }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof GeobFrame))
      {
        localObject = (GeobFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[] { ((GeobFrame)localObject).id, ((GeobFrame)localObject).mimeType, ((GeobFrame)localObject).filename, ((GeobFrame)localObject).description }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof ApicFrame))
      {
        localObject = (ApicFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: mimeType=%s, description=%s", new Object[] { ((ApicFrame)localObject).id, ((ApicFrame)localObject).mimeType, ((ApicFrame)localObject).description }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof CommentFrame))
      {
        localObject = (CommentFrame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s: language=%s, description=%s", new Object[] { ((CommentFrame)localObject).id, ((CommentFrame)localObject).language, ((CommentFrame)localObject).description }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof Id3Frame))
      {
        localObject = (Id3Frame)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("%s", new Object[] { ((Id3Frame)localObject).id }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof EventMessage))
      {
        localObject = (EventMessage)localObject;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[] { ((EventMessage)localObject).schemeIdUri, Long.valueOf(((EventMessage)localObject).id), ((EventMessage)localObject).value }));
        Log.d("EventLogger", localStringBuilder.toString());
      }
      else if ((localObject instanceof SpliceCommand))
      {
        localObject = String.format("SCTE-35 splice command: type=%s.", new Object[] { localObject.getClass().getSimpleName() });
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        Log.d("EventLogger", localStringBuilder.toString());
      }
      i += 1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioDecoderInitialized [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onAudioDisabled(DecoderCounters paramDecoderCounters)
  {
    paramDecoderCounters = new StringBuilder();
    paramDecoderCounters.append("audioDisabled [");
    paramDecoderCounters.append(getSessionTimeString());
    paramDecoderCounters.append("]");
    Log.d("EventLogger", paramDecoderCounters.toString());
  }
  
  public void onAudioEnabled(DecoderCounters paramDecoderCounters)
  {
    paramDecoderCounters = new StringBuilder();
    paramDecoderCounters.append("audioEnabled [");
    paramDecoderCounters.append(getSessionTimeString());
    paramDecoderCounters.append("]");
    Log.d("EventLogger", paramDecoderCounters.toString());
  }
  
  public void onAudioInputFormatChanged(Format paramFormat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioFormatChanged [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(Format.toLogString(paramFormat));
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onAudioSessionId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioSessionId [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioTrackUnderrun [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("]");
    printInternalError(localStringBuilder.toString(), null);
  }
  
  public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
  
  public void onDrmKeysLoaded()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drmKeysLoaded [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onDrmKeysRemoved()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drmKeysRemoved [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onDrmKeysRestored()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drmKeysRestored [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onDrmSessionManagerError(Exception paramException)
  {
    printInternalError("drmSessionManagerError", paramException);
  }
  
  public void onDroppedFrames(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("droppedFrames [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loading [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onMetadata(Metadata paramMetadata)
  {
    Log.d("EventLogger", "onMetadata [");
    printMetadata(paramMetadata, "  ");
    Log.d("EventLogger", "]");
  }
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playbackParameters ");
    localStringBuilder.append(String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramPlaybackParameters.speed), Float.valueOf(paramPlaybackParameters.pitch) }));
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playerFailed [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append("]");
    Log.e("EventLogger", localStringBuilder.toString(), paramExoPlaybackException);
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(getStateString(paramInt));
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onPositionDiscontinuity(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("positionDiscontinuity [");
    localStringBuilder.append(getDiscontinuityReasonString(paramInt));
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onRenderAudioData(byte[] paramArrayOfByte) {}
  
  public void onRenderedFirstFrame(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("renderedFirstFrame [");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onRepeatModeChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("repeatMode [");
    localStringBuilder.append(getRepeatModeString(paramInt));
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onSeekProcessed()
  {
    Log.d("EventLogger", "seekProcessed");
  }
  
  public void onShuffleModeEnabledChanged(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shuffleModeEnabled [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt)
  {
    int k = paramTimeline.getPeriodCount();
    int j = paramTimeline.getWindowCount();
    paramObject = new StringBuilder();
    paramObject.append("timelineChanged [periodCount=");
    paramObject.append(k);
    paramObject.append(", windowCount=");
    paramObject.append(j);
    paramObject.append(", reason=");
    paramObject.append(getTimelineChangeReasonString(paramInt));
    Log.d("EventLogger", paramObject.toString());
    int i = 0;
    paramInt = 0;
    while (paramInt < Math.min(k, 3))
    {
      paramTimeline.getPeriod(paramInt, this.period);
      paramObject = new StringBuilder();
      paramObject.append("  period [");
      paramObject.append(getTimeString(this.period.getDurationMs()));
      paramObject.append("]");
      Log.d("EventLogger", paramObject.toString());
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
      paramObject = new StringBuilder();
      paramObject.append("  window [");
      paramObject.append(getTimeString(this.window.getDurationMs()));
      paramObject.append(", ");
      paramObject.append(this.window.isSeekable);
      paramObject.append(", ");
      paramObject.append(this.window.isDynamic);
      paramObject.append("]");
      Log.d("EventLogger", paramObject.toString());
      paramInt += 1;
    }
    if (j > 3) {
      Log.d("EventLogger", "  ...");
    }
    Log.d("EventLogger", "]");
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    paramTrackGroupArray = this;
    Object localObject3 = paramTrackGroupArray.trackSelector.getCurrentMappedTrackInfo();
    if (localObject3 == null)
    {
      Log.d("EventLogger", "Tracks []");
      return;
    }
    Log.d("EventLogger", "Tracks [");
    int i = 0;
    int j;
    Object localObject2;
    String str1;
    Object localObject1;
    for (;;)
    {
      j = ((MappingTrackSelector.MappedTrackInfo)localObject3).length;
      localObject2 = "  ]";
      str1 = " [";
      if (i >= j) {
        break;
      }
      localObject1 = ((MappingTrackSelector.MappedTrackInfo)localObject3).getTrackGroups(i);
      TrackSelection localTrackSelection = paramTrackSelectionArray.get(i);
      if (((TrackGroupArray)localObject1).length > 0)
      {
        paramTrackGroupArray = new StringBuilder();
        paramTrackGroupArray.append("  Renderer:");
        paramTrackGroupArray.append(i);
        paramTrackGroupArray.append(" [");
        Log.d("EventLogger", paramTrackGroupArray.toString());
        j = 0;
        paramTrackGroupArray = (TrackGroupArray)localObject2;
        while (j < ((TrackGroupArray)localObject1).length)
        {
          localObject2 = ((TrackGroupArray)localObject1).get(j);
          String str2 = getAdaptiveSupportString(((TrackGroup)localObject2).length, ((MappingTrackSelector.MappedTrackInfo)localObject3).getAdaptiveSupport(i, j, false));
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("    Group:");
          ((StringBuilder)localObject4).append(j);
          ((StringBuilder)localObject4).append(", adaptive_supported=");
          ((StringBuilder)localObject4).append(str2);
          ((StringBuilder)localObject4).append(str1);
          Log.d("EventLogger", ((StringBuilder)localObject4).toString());
          int k = 0;
          while (k < ((TrackGroup)localObject2).length)
          {
            str2 = getTrackStatusString(localTrackSelection, (TrackGroup)localObject2, k);
            localObject4 = getFormatSupportString(((MappingTrackSelector.MappedTrackInfo)localObject3).getTrackFormatSupport(i, j, k));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("      ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" Track:");
            localStringBuilder.append(k);
            localStringBuilder.append(", ");
            localStringBuilder.append(Format.toLogString(((TrackGroup)localObject2).getFormat(k)));
            localStringBuilder.append(", supported=");
            localStringBuilder.append((String)localObject4);
            Log.d("EventLogger", localStringBuilder.toString());
            k += 1;
          }
          Log.d("EventLogger", "    ]");
          j += 1;
        }
        if (localTrackSelection != null)
        {
          j = 0;
          while (j < localTrackSelection.length())
          {
            localObject1 = localTrackSelection.getFormat(j).metadata;
            if (localObject1 != null)
            {
              Log.d("EventLogger", "    Metadata [");
              printMetadata((Metadata)localObject1, "      ");
              Log.d("EventLogger", "    ]");
              break;
            }
            j += 1;
          }
        }
        localObject1 = this;
        Log.d("EventLogger", paramTrackGroupArray);
        paramTrackGroupArray = (TrackGroupArray)localObject1;
      }
      i += 1;
    }
    paramTrackGroupArray = " [";
    paramTrackSelectionArray = ((MappingTrackSelector.MappedTrackInfo)localObject3).getUnassociatedTrackGroups();
    if (paramTrackSelectionArray.length > 0)
    {
      Log.d("EventLogger", "  Renderer:None [");
      i = 0;
      while (i < paramTrackSelectionArray.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("    Group:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(paramTrackGroupArray);
        Log.d("EventLogger", ((StringBuilder)localObject1).toString());
        localObject1 = paramTrackSelectionArray.get(i);
        j = 0;
        while (j < ((TrackGroup)localObject1).length)
        {
          str1 = getTrackStatusString(false);
          localObject2 = getFormatSupportString(0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("      ");
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append(" Track:");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append(Format.toLogString(((TrackGroup)localObject1).getFormat(j)));
          ((StringBuilder)localObject3).append(", supported=");
          ((StringBuilder)localObject3).append((String)localObject2);
          Log.d("EventLogger", ((StringBuilder)localObject3).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoDecoderInitialized [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onVideoDisabled(DecoderCounters paramDecoderCounters)
  {
    paramDecoderCounters = new StringBuilder();
    paramDecoderCounters.append("videoDisabled [");
    paramDecoderCounters.append(getSessionTimeString());
    paramDecoderCounters.append("]");
    Log.d("EventLogger", paramDecoderCounters.toString());
  }
  
  public void onVideoEnabled(DecoderCounters paramDecoderCounters)
  {
    paramDecoderCounters = new StringBuilder();
    paramDecoderCounters.append("videoEnabled [");
    paramDecoderCounters.append(getSessionTimeString());
    paramDecoderCounters.append("]");
    Log.d("EventLogger", paramDecoderCounters.toString());
  }
  
  public void onVideoInputFormatChanged(Format paramFormat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoFormatChanged [");
    localStringBuilder.append(getSessionTimeString());
    localStringBuilder.append(", ");
    localStringBuilder.append(Format.toLogString(paramFormat));
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
  
  public void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoSizeChanged [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    Log.d("EventLogger", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.EventLogger
 * JD-Core Version:    0.7.0.1
 */