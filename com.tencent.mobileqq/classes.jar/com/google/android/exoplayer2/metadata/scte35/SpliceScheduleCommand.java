package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new SpliceScheduleCommand.1();
  public final List<SpliceScheduleCommand.Event> events;
  
  private SpliceScheduleCommand(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceScheduleCommand.Event.access$300(paramParcel));
      i += 1;
    }
    this.events = Collections.unmodifiableList(localArrayList);
  }
  
  private SpliceScheduleCommand(List<SpliceScheduleCommand.Event> paramList)
  {
    this.events = Collections.unmodifiableList(paramList);
  }
  
  static SpliceScheduleCommand parseFromSection(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedByte();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceScheduleCommand.Event.access$400(paramParsableByteArray));
      i += 1;
    }
    return new SpliceScheduleCommand(localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.events.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      SpliceScheduleCommand.Event.access$500((SpliceScheduleCommand.Event)this.events.get(paramInt), paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand
 * JD-Core Version:    0.7.0.1
 */