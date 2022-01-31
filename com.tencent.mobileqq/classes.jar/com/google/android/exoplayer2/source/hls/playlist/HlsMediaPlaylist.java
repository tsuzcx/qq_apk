package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;

public final class HlsMediaPlaylist
  extends HlsPlaylist
{
  public static final int PLAYLIST_TYPE_EVENT = 2;
  public static final int PLAYLIST_TYPE_UNKNOWN = 0;
  public static final int PLAYLIST_TYPE_VOD = 1;
  public final int discontinuitySequence;
  public final DrmInitData drmInitData;
  public final long durationUs;
  public final boolean hasDiscontinuitySequence;
  public final boolean hasEndTag;
  public final boolean hasIndependentSegmentsTag;
  public final boolean hasProgramDateTime;
  public final HlsMediaPlaylist.Segment initializationSegment;
  public final long mediaSequence;
  public final int playlistType;
  public final List<HlsMediaPlaylist.Segment> segments;
  public final long startOffsetUs;
  public final long startTimeUs;
  public final long targetDurationUs;
  public final int version;
  
  public HlsMediaPlaylist(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, long paramLong3, int paramInt3, long paramLong4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, DrmInitData paramDrmInitData, HlsMediaPlaylist.Segment paramSegment, List<HlsMediaPlaylist.Segment> paramList1)
  {
    super(paramString, paramList);
    this.playlistType = paramInt1;
    this.startTimeUs = paramLong2;
    this.hasDiscontinuitySequence = paramBoolean1;
    this.discontinuitySequence = paramInt2;
    this.mediaSequence = paramLong3;
    this.version = paramInt3;
    this.targetDurationUs = paramLong4;
    this.hasIndependentSegmentsTag = paramBoolean2;
    this.hasEndTag = paramBoolean3;
    this.hasProgramDateTime = paramBoolean4;
    this.drmInitData = paramDrmInitData;
    this.initializationSegment = paramSegment;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (HlsMediaPlaylist.Segment)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.relativeStartTimeUs;
      this.durationUs = (paramString.durationUs + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label162;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.startOffsetUs = paramLong2;
      return;
      this.durationUs = 0L;
      break;
      label162:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.durationUs;
      }
    }
  }
  
  public HlsMediaPlaylist copyWith(long paramLong, int paramInt)
  {
    return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, paramLong, true, paramInt, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegmentsTag, this.hasEndTag, this.hasProgramDateTime, this.drmInitData, this.initializationSegment, this.segments);
  }
  
  public HlsMediaPlaylist copyWithEndTag()
  {
    if (this.hasEndTag) {
      return this;
    }
    return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegmentsTag, true, this.hasProgramDateTime, this.drmInitData, this.initializationSegment, this.segments);
  }
  
  public long getEndTimeUs()
  {
    return this.startTimeUs + this.durationUs;
  }
  
  public boolean isNewerThan(HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramHlsMediaPlaylist == null) || (this.mediaSequence > paramHlsMediaPlaylist.mediaSequence)) {
      bool1 = true;
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (this.mediaSequence < paramHlsMediaPlaylist.mediaSequence);
          i = this.segments.size();
          j = paramHlsMediaPlaylist.segments.size();
          if (i > j) {
            break;
          }
          bool1 = bool2;
        } while (i != j);
        bool1 = bool2;
      } while (!this.hasEndTag);
      bool1 = bool2;
    } while (paramHlsMediaPlaylist.hasEndTag);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist
 * JD-Core Version:    0.7.0.1
 */