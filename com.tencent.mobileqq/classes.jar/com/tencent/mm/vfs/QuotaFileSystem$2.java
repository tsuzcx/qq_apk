package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QuotaFileSystem$2
  implements Parcelable.Creator<QuotaFileSystem>
{
  public QuotaFileSystem createFromParcel(Parcel paramParcel)
  {
    return new QuotaFileSystem(paramParcel);
  }
  
  public QuotaFileSystem[] newArray(int paramInt)
  {
    return new QuotaFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem.2
 * JD-Core Version:    0.7.0.1
 */