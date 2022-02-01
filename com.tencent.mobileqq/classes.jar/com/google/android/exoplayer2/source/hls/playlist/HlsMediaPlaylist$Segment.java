package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;

public final class HlsMediaPlaylist$Segment
  implements Comparable<Long>
{
  public final long byterangeLength;
  public final long byterangeOffset;
  public final long durationUs;
  public final String encryptionIV;
  public final String fullSegmentEncryptionKeyUri;
  public final boolean hasGapTag;
  public final int relativeDiscontinuitySequence;
  public final long relativeStartTimeUs;
  public final String url;
  
  public HlsMediaPlaylist$Segment(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, String paramString3, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    this.url = paramString1;
    this.durationUs = paramLong1;
    this.relativeDiscontinuitySequence = paramInt;
    this.relativeStartTimeUs = paramLong2;
    this.fullSegmentEncryptionKeyUri = paramString2;
    this.encryptionIV = paramString3;
    this.byterangeOffset = paramLong3;
    this.byterangeLength = paramLong4;
    this.hasGapTag = paramBoolean;
  }
  
  public HlsMediaPlaylist$Segment(String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, 0L, -1, -9223372036854775807L, null, null, paramLong1, paramLong2, false);
  }
  
  public int compareTo(@NonNull Long paramLong)
  {
    if (this.relativeStartTimeUs > paramLong.longValue()) {
      return 1;
    }
    if (this.relativeStartTimeUs < paramLong.longValue()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment
 * JD-Core Version:    0.7.0.1
 */