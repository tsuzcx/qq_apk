package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;

public final class SpliceInsertCommand$ComponentSplice
{
  public final long componentSplicePlaybackPositionUs;
  public final long componentSplicePts;
  public final int componentTag;
  
  private SpliceInsertCommand$ComponentSplice(int paramInt, long paramLong1, long paramLong2)
  {
    this.componentTag = paramInt;
    this.componentSplicePts = paramLong1;
    this.componentSplicePlaybackPositionUs = paramLong2;
  }
  
  public static ComponentSplice createFromParcel(Parcel paramParcel)
  {
    return new ComponentSplice(paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong());
  }
  
  public void writeToParcel(Parcel paramParcel)
  {
    paramParcel.writeInt(this.componentTag);
    paramParcel.writeLong(this.componentSplicePts);
    paramParcel.writeLong(this.componentSplicePlaybackPositionUs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.ComponentSplice
 * JD-Core Version:    0.7.0.1
 */