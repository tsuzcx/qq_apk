package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$Event
{
  public final boolean autoReturn;
  public final int availNum;
  public final int availsExpected;
  public final long breakDurationUs;
  public final List<SpliceScheduleCommand.ComponentSplice> componentSpliceList;
  public final boolean outOfNetworkIndicator;
  public final boolean programSpliceFlag;
  public final boolean spliceEventCancelIndicator;
  public final long spliceEventId;
  public final int uniqueProgramId;
  public final long utcSpliceTime;
  
  private SpliceScheduleCommand$Event(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<SpliceScheduleCommand.ComponentSplice> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.spliceEventId = paramLong1;
    this.spliceEventCancelIndicator = paramBoolean1;
    this.outOfNetworkIndicator = paramBoolean2;
    this.programSpliceFlag = paramBoolean3;
    this.componentSpliceList = Collections.unmodifiableList(paramList);
    this.utcSpliceTime = paramLong2;
    this.autoReturn = paramBoolean4;
    this.breakDurationUs = paramLong3;
    this.uniqueProgramId = paramInt1;
    this.availNum = paramInt2;
    this.availsExpected = paramInt3;
  }
  
  private SpliceScheduleCommand$Event(Parcel paramParcel)
  {
    this.spliceEventId = paramParcel.readLong();
    int i = paramParcel.readByte();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.spliceEventCancelIndicator = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.outOfNetworkIndicator = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.programSpliceFlag = bool1;
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceScheduleCommand.ComponentSplice.access$000(paramParcel));
      i += 1;
    }
    this.componentSpliceList = Collections.unmodifiableList(localArrayList);
    this.utcSpliceTime = paramParcel.readLong();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.autoReturn = bool1;
    this.breakDurationUs = paramParcel.readLong();
    this.uniqueProgramId = paramParcel.readInt();
    this.availNum = paramParcel.readInt();
    this.availsExpected = paramParcel.readInt();
  }
  
  private static Event createFromParcel(Parcel paramParcel)
  {
    return new Event(paramParcel);
  }
  
  private static Event parseFromSection(ParsableByteArray paramParsableByteArray)
  {
    long l3 = paramParsableByteArray.readUnsignedInt();
    boolean bool4;
    if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool1;
    boolean bool2;
    long l1;
    int k;
    int j;
    long l2;
    boolean bool3;
    if (!bool4)
    {
      i = paramParsableByteArray.readUnsignedByte();
      if ((i & 0x80) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((i & 0x40) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((i & 0x20) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (bool2) {
        l1 = paramParsableByteArray.readUnsignedInt();
      } else {
        l1 = -9223372036854775807L;
      }
      if (!bool2)
      {
        k = paramParsableByteArray.readUnsignedByte();
        localArrayList = new ArrayList(k);
        j = 0;
        while (j < k)
        {
          localArrayList.add(new SpliceScheduleCommand.ComponentSplice(paramParsableByteArray.readUnsignedByte(), paramParsableByteArray.readUnsignedInt(), null));
          j += 1;
        }
      }
      if (i != 0)
      {
        l2 = paramParsableByteArray.readUnsignedByte();
        if ((0x80 & l2) != 0L) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        l2 = ((l2 & 1L) << 32 | paramParsableByteArray.readUnsignedInt()) * 1000L / 90L;
      }
      else
      {
        bool3 = false;
        l2 = -9223372036854775807L;
      }
      i = paramParsableByteArray.readUnsignedShort();
      j = paramParsableByteArray.readUnsignedByte();
      k = paramParsableByteArray.readUnsignedByte();
    }
    else
    {
      bool1 = false;
      l1 = -9223372036854775807L;
      bool3 = false;
      l2 = -9223372036854775807L;
      i = 0;
      j = 0;
      k = 0;
      bool2 = false;
    }
    return new Event(l3, bool4, bool1, bool2, localArrayList, l1, bool3, l2, i, j, k);
  }
  
  private void writeToParcel(Parcel paramParcel)
  {
    paramParcel.writeLong(this.spliceEventId);
    paramParcel.writeByte((byte)this.spliceEventCancelIndicator);
    paramParcel.writeByte((byte)this.outOfNetworkIndicator);
    paramParcel.writeByte((byte)this.programSpliceFlag);
    int j = this.componentSpliceList.size();
    paramParcel.writeInt(j);
    int i = 0;
    while (i < j)
    {
      SpliceScheduleCommand.ComponentSplice.access$200((SpliceScheduleCommand.ComponentSplice)this.componentSpliceList.get(i), paramParcel);
      i += 1;
    }
    paramParcel.writeLong(this.utcSpliceTime);
    paramParcel.writeByte((byte)this.autoReturn);
    paramParcel.writeLong(this.breakDurationUs);
    paramParcel.writeInt(this.uniqueProgramId);
    paramParcel.writeInt(this.availNum);
    paramParcel.writeInt(this.availsExpected);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event
 * JD-Core Version:    0.7.0.1
 */