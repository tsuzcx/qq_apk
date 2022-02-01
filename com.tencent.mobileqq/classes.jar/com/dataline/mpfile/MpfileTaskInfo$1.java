package com.dataline.mpfile;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MpfileTaskInfo$1
  implements Parcelable.Creator<MpfileTaskInfo>
{
  public MpfileTaskInfo a(Parcel paramParcel)
  {
    MpfileTaskInfo localMpfileTaskInfo = new MpfileTaskInfo();
    localMpfileTaskInfo.f = paramParcel.readInt();
    localMpfileTaskInfo.g = paramParcel.readInt();
    localMpfileTaskInfo.h = paramParcel.readString();
    localMpfileTaskInfo.i = paramParcel.readString();
    localMpfileTaskInfo.j = paramParcel.readString();
    localMpfileTaskInfo.k = paramParcel.readString();
    localMpfileTaskInfo.l = paramParcel.readString();
    localMpfileTaskInfo.m = paramParcel.readString();
    localMpfileTaskInfo.n = paramParcel.readString();
    localMpfileTaskInfo.o = paramParcel.readString();
    localMpfileTaskInfo.p = paramParcel.readLong();
    localMpfileTaskInfo.q = paramParcel.readLong();
    localMpfileTaskInfo.r = paramParcel.readLong();
    localMpfileTaskInfo.s = paramParcel.readLong();
    localMpfileTaskInfo.t = paramParcel.readLong();
    localMpfileTaskInfo.u = paramParcel.readLong();
    localMpfileTaskInfo.v = paramParcel.readLong();
    return localMpfileTaskInfo;
  }
  
  public MpfileTaskInfo[] a(int paramInt)
  {
    return new MpfileTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskInfo.1
 * JD-Core Version:    0.7.0.1
 */