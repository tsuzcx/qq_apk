package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public final class Track
{
  public static final int TRANSFORMATION_CEA608_CDAT = 1;
  public static final int TRANSFORMATION_NONE = 0;
  public final long durationUs;
  @Nullable
  public final long[] editListDurations;
  @Nullable
  public final long[] editListMediaTimes;
  public final Format format;
  public final int id;
  public final long movieTimescale;
  public final int nalUnitLengthFieldLength;
  @Nullable
  private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
  public final int sampleTransformation;
  public final long timescale;
  public final int type;
  
  public Track(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, Format paramFormat, int paramInt3, @Nullable TrackEncryptionBox[] paramArrayOfTrackEncryptionBox, int paramInt4, @Nullable long[] paramArrayOfLong1, @Nullable long[] paramArrayOfLong2)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.timescale = paramLong1;
    this.movieTimescale = paramLong2;
    this.durationUs = paramLong3;
    this.format = paramFormat;
    this.sampleTransformation = paramInt3;
    this.sampleDescriptionEncryptionBoxes = paramArrayOfTrackEncryptionBox;
    this.nalUnitLengthFieldLength = paramInt4;
    this.editListDurations = paramArrayOfLong1;
    this.editListMediaTimes = paramArrayOfLong2;
  }
  
  public TrackEncryptionBox getSampleDescriptionEncryptionBox(int paramInt)
  {
    if (this.sampleDescriptionEncryptionBoxes == null) {
      return null;
    }
    return this.sampleDescriptionEncryptionBoxes[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.Track
 * JD-Core Version:    0.7.0.1
 */