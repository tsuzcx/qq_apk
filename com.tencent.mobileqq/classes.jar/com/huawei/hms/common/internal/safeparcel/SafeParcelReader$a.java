package com.huawei.hms.common.internal.safeparcel;

import android.os.Parcel;

public class SafeParcelReader$a
  extends RuntimeException
{
  public SafeParcelReader$a(String paramString, Parcel paramParcel)
  {
    super(String.valueOf(paramString).length() + 41 + paramString + " Parcel: pos=" + paramParcel.dataPosition() + " size=" + paramParcel.dataSize());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.SafeParcelReader.a
 * JD-Core Version:    0.7.0.1
 */