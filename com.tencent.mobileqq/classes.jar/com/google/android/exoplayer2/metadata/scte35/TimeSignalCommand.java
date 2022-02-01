package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new TimeSignalCommand.1();
  public final long playbackPositionUs;
  public final long ptsTime;
  
  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.ptsTime = paramLong1;
    this.playbackPositionUs = paramLong2;
  }
  
  static TimeSignalCommand parseFromSection(ParsableByteArray paramParsableByteArray, long paramLong, TimestampAdjuster paramTimestampAdjuster)
  {
    paramLong = parseSpliceTime(paramParsableByteArray, paramLong);
    return new TimeSignalCommand(paramLong, paramTimestampAdjuster.adjustTsTimestamp(paramLong));
  }
  
  static long parseSpliceTime(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    long l = paramParsableByteArray.readUnsignedByte();
    if ((0x80 & l) != 0L) {
      return 0xFFFFFFFF & ((l & 1L) << 32 | paramParsableByteArray.readUnsignedInt()) + paramLong;
    }
    return -9223372036854775807L;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.ptsTime);
    paramParcel.writeLong(this.playbackPositionUs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand
 * JD-Core Version:    0.7.0.1
 */