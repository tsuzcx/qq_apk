package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;

public final class SpliceScheduleCommand$ComponentSplice
{
  public final int componentTag;
  public final long utcSpliceTime;
  
  private SpliceScheduleCommand$ComponentSplice(int paramInt, long paramLong)
  {
    this.componentTag = paramInt;
    this.utcSpliceTime = paramLong;
  }
  
  private static ComponentSplice createFromParcel(Parcel paramParcel)
  {
    return new ComponentSplice(paramParcel.readInt(), paramParcel.readLong());
  }
  
  private void writeToParcel(Parcel paramParcel)
  {
    paramParcel.writeInt(this.componentTag);
    paramParcel.writeLong(this.utcSpliceTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice
 * JD-Core Version:    0.7.0.1
 */