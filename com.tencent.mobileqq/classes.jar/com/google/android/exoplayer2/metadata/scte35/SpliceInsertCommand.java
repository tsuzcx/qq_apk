package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new SpliceInsertCommand.1();
  public final boolean autoReturn;
  public final int availNum;
  public final int availsExpected;
  public final long breakDurationUs;
  public final List<SpliceInsertCommand.ComponentSplice> componentSpliceList;
  public final boolean outOfNetworkIndicator;
  public final boolean programSpliceFlag;
  public final long programSplicePlaybackPositionUs;
  public final long programSplicePts;
  public final boolean spliceEventCancelIndicator;
  public final long spliceEventId;
  public final boolean spliceImmediateFlag;
  public final int uniqueProgramId;
  
  private SpliceInsertCommand(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<SpliceInsertCommand.ComponentSplice> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.spliceEventId = paramLong1;
    this.spliceEventCancelIndicator = paramBoolean1;
    this.outOfNetworkIndicator = paramBoolean2;
    this.programSpliceFlag = paramBoolean3;
    this.spliceImmediateFlag = paramBoolean4;
    this.programSplicePts = paramLong2;
    this.programSplicePlaybackPositionUs = paramLong3;
    this.componentSpliceList = Collections.unmodifiableList(paramList);
    this.autoReturn = paramBoolean5;
    this.breakDurationUs = paramLong4;
    this.uniqueProgramId = paramInt1;
    this.availNum = paramInt2;
    this.availsExpected = paramInt3;
  }
  
  private SpliceInsertCommand(Parcel paramParcel)
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
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.spliceImmediateFlag = bool1;
    this.programSplicePts = paramParcel.readLong();
    this.programSplicePlaybackPositionUs = paramParcel.readLong();
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    i = 0;
    while (i < j)
    {
      localArrayList.add(SpliceInsertCommand.ComponentSplice.createFromParcel(paramParcel));
      i += 1;
    }
    this.componentSpliceList = Collections.unmodifiableList(localArrayList);
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
  
  static SpliceInsertCommand parseFromSection(ParsableByteArray paramParsableByteArray, long paramLong, TimestampAdjuster paramTimestampAdjuster)
  {
    long l3 = paramParsableByteArray.readUnsignedInt();
    boolean bool5;
    if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    Object localObject = Collections.emptyList();
    int j;
    boolean bool1;
    boolean bool2;
    int i;
    boolean bool3;
    long l1;
    int k;
    boolean bool4;
    if (!bool5)
    {
      j = paramParsableByteArray.readUnsignedByte();
      if ((j & 0x80) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((j & 0x40) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((j & 0x20) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((j & 0x10) != 0) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if ((bool2) && (!bool3)) {
        l1 = TimeSignalCommand.parseSpliceTime(paramParsableByteArray, paramLong);
      } else {
        l1 = -9223372036854775807L;
      }
      if (!bool2)
      {
        k = paramParsableByteArray.readUnsignedByte();
        ArrayList localArrayList = new ArrayList(k);
        j = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (j >= k) {
            break;
          }
          int m = paramParsableByteArray.readUnsignedByte();
          long l2;
          if (!bool3) {
            l2 = TimeSignalCommand.parseSpliceTime(paramParsableByteArray, paramLong);
          } else {
            l2 = -9223372036854775807L;
          }
          localArrayList.add(new SpliceInsertCommand.ComponentSplice(m, l2, paramTimestampAdjuster.adjustTsTimestamp(l2), null));
          j += 1;
        }
      }
      if (i != 0)
      {
        paramLong = paramParsableByteArray.readUnsignedByte();
        if ((0x80 & paramLong) != 0L) {
          bool4 = true;
        } else {
          bool4 = false;
        }
        paramLong = ((paramLong & 1L) << 32 | paramParsableByteArray.readUnsignedInt()) * 1000L / 90L;
      }
      else
      {
        paramLong = -9223372036854775807L;
        bool4 = false;
      }
      k = paramParsableByteArray.readUnsignedShort();
      i = paramParsableByteArray.readUnsignedByte();
      j = paramParsableByteArray.readUnsignedByte();
    }
    else
    {
      bool1 = false;
      bool3 = false;
      l1 = -9223372036854775807L;
      bool4 = false;
      paramLong = -9223372036854775807L;
      k = 0;
      i = 0;
      j = 0;
      bool2 = false;
    }
    return new SpliceInsertCommand(l3, bool5, bool1, bool2, bool3, l1, paramTimestampAdjuster.adjustTsTimestamp(l1), (List)localObject, bool4, paramLong, k, i, j);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.spliceEventId);
    paramParcel.writeByte((byte)this.spliceEventCancelIndicator);
    paramParcel.writeByte((byte)this.outOfNetworkIndicator);
    paramParcel.writeByte((byte)this.programSpliceFlag);
    paramParcel.writeByte((byte)this.spliceImmediateFlag);
    paramParcel.writeLong(this.programSplicePts);
    paramParcel.writeLong(this.programSplicePlaybackPositionUs);
    int i = this.componentSpliceList.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      ((SpliceInsertCommand.ComponentSplice)this.componentSpliceList.get(paramInt)).writeToParcel(paramParcel);
      paramInt += 1;
    }
    paramParcel.writeByte((byte)this.autoReturn);
    paramParcel.writeLong(this.breakDurationUs);
    paramParcel.writeInt(this.uniqueProgramId);
    paramParcel.writeInt(this.availNum);
    paramParcel.writeInt(this.availsExpected);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.7.0.1
 */