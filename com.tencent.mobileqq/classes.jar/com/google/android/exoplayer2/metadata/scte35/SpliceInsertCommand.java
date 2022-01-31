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
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.spliceEventCancelIndicator = bool1;
      if (paramParcel.readByte() != 1) {
        break label146;
      }
      bool1 = true;
      label43:
      this.outOfNetworkIndicator = bool1;
      if (paramParcel.readByte() != 1) {
        break label152;
      }
      bool1 = true;
      label60:
      this.programSpliceFlag = bool1;
      if (paramParcel.readByte() != 1) {
        break label158;
      }
    }
    ArrayList localArrayList;
    label146:
    label152:
    label158:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.spliceImmediateFlag = bool1;
      this.programSplicePts = paramParcel.readLong();
      this.programSplicePlaybackPositionUs = paramParcel.readLong();
      int j = paramParcel.readInt();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(SpliceInsertCommand.ComponentSplice.createFromParcel(paramParcel));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label43;
      bool1 = false;
      break label60;
    }
    this.componentSpliceList = Collections.unmodifiableList(localArrayList);
    if (paramParcel.readByte() == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.autoReturn = bool1;
      this.breakDurationUs = paramParcel.readLong();
      this.uniqueProgramId = paramParcel.readInt();
      this.availNum = paramParcel.readInt();
      this.availsExpected = paramParcel.readInt();
      return;
    }
  }
  
  static SpliceInsertCommand parseFromSection(ParsableByteArray paramParsableByteArray, long paramLong, TimestampAdjuster paramTimestampAdjuster)
  {
    long l3 = paramParsableByteArray.readUnsignedInt();
    boolean bool5;
    boolean bool1;
    boolean bool2;
    Object localObject;
    int i;
    int j;
    int k;
    label63:
    label74:
    label85:
    boolean bool3;
    if ((paramParsableByteArray.readUnsignedByte() & 0x80) != 0)
    {
      bool5 = true;
      bool1 = false;
      bool2 = false;
      localObject = Collections.emptyList();
      i = 0;
      j = 0;
      k = 0;
      if (bool5) {
        break label360;
      }
      j = paramParsableByteArray.readUnsignedByte();
      if ((j & 0x80) == 0) {
        break label213;
      }
      bool1 = true;
      if ((j & 0x40) == 0) {
        break label219;
      }
      bool2 = true;
      if ((j & 0x20) == 0) {
        break label225;
      }
      i = 1;
      if ((j & 0x10) == 0) {
        break label231;
      }
      bool3 = true;
    }
    long l1;
    label213:
    label219:
    label225:
    label231:
    boolean bool4;
    for (;;)
    {
      if ((bool2) && (!bool3))
      {
        l1 = TimeSignalCommand.parseSpliceTime(paramParsableByteArray, paramLong);
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
            long l2 = -9223372036854775807L;
            if (!bool3) {
              l2 = TimeSignalCommand.parseSpliceTime(paramParsableByteArray, paramLong);
            }
            localArrayList.add(new SpliceInsertCommand.ComponentSplice(m, l2, paramTimestampAdjuster.adjustTsTimestamp(l2), null));
            j += 1;
          }
          bool5 = false;
          break;
          bool1 = false;
          break label63;
          bool2 = false;
          break label74;
          i = 0;
          break label85;
          bool3 = false;
          continue;
        }
        if (i != 0)
        {
          paramLong = paramParsableByteArray.readUnsignedByte();
          if ((0x80 & paramLong) != 0L)
          {
            bool4 = true;
            label261:
            paramLong = ((paramLong & 1L) << 32 | paramParsableByteArray.readUnsignedInt()) * 1000L / 90L;
            label281:
            i = paramParsableByteArray.readUnsignedShort();
            j = paramParsableByteArray.readUnsignedByte();
            k = paramParsableByteArray.readUnsignedByte();
          }
        }
      }
    }
    for (;;)
    {
      return new SpliceInsertCommand(l3, bool5, bool1, bool2, bool3, l1, paramTimestampAdjuster.adjustTsTimestamp(l1), (List)localObject, bool4, paramLong, i, j, k);
      bool4 = false;
      break label261;
      paramLong = -9223372036854775807L;
      bool4 = false;
      break label281;
      l1 = -9223372036854775807L;
      break;
      label360:
      paramLong = -9223372036854775807L;
      bool4 = false;
      l1 = -9223372036854775807L;
      bool3 = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.spliceEventId);
    if (this.spliceEventCancelIndicator)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.outOfNetworkIndicator) {
        break label140;
      }
      paramInt = 1;
      label34:
      paramParcel.writeByte((byte)paramInt);
      if (!this.programSpliceFlag) {
        break label145;
      }
      paramInt = 1;
      label49:
      paramParcel.writeByte((byte)paramInt);
      if (!this.spliceImmediateFlag) {
        break label150;
      }
    }
    label140:
    label145:
    label150:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.programSplicePts);
      paramParcel.writeLong(this.programSplicePlaybackPositionUs);
      int j = this.componentSpliceList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        ((SpliceInsertCommand.ComponentSplice)this.componentSpliceList.get(paramInt)).writeToParcel(paramParcel);
        paramInt += 1;
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label34;
      paramInt = 0;
      break label49;
    }
    if (this.autoReturn) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.breakDurationUs);
      paramParcel.writeInt(this.uniqueProgramId);
      paramParcel.writeInt(this.availNum);
      paramParcel.writeInt(this.availsExpected);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand
 * JD-Core Version:    0.7.0.1
 */