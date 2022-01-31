package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DrmInitData$1
  implements Parcelable.Creator<DrmInitData>
{
  public DrmInitData createFromParcel(Parcel paramParcel)
  {
    return new DrmInitData(paramParcel);
  }
  
  public DrmInitData[] newArray(int paramInt)
  {
    return new DrmInitData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData.1
 * JD-Core Version:    0.7.0.1
 */