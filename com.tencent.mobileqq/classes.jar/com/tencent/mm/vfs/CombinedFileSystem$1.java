package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CombinedFileSystem$1
  implements Parcelable.Creator<CombinedFileSystem>
{
  public CombinedFileSystem createFromParcel(Parcel paramParcel)
  {
    return new CombinedFileSystem(paramParcel, null);
  }
  
  public CombinedFileSystem[] newArray(int paramInt)
  {
    return new CombinedFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem.1
 * JD-Core Version:    0.7.0.1
 */