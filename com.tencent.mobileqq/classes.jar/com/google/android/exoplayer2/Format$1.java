package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Format$1
  implements Parcelable.Creator<Format>
{
  public Format createFromParcel(Parcel paramParcel)
  {
    return new Format(paramParcel);
  }
  
  public Format[] newArray(int paramInt)
  {
    return new Format[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.Format.1
 * JD-Core Version:    0.7.0.1
 */