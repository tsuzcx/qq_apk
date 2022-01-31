package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TimeSignalCommand$1
  implements Parcelable.Creator<TimeSignalCommand>
{
  public TimeSignalCommand createFromParcel(Parcel paramParcel)
  {
    return new TimeSignalCommand(paramParcel.readLong(), paramParcel.readLong(), null);
  }
  
  public TimeSignalCommand[] newArray(int paramInt)
  {
    return new TimeSignalCommand[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.1
 * JD-Core Version:    0.7.0.1
 */