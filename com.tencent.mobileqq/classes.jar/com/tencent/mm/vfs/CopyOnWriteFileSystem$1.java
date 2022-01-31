package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CopyOnWriteFileSystem$1
  implements Parcelable.Creator<CopyOnWriteFileSystem>
{
  public CopyOnWriteFileSystem createFromParcel(Parcel paramParcel)
  {
    return new CopyOnWriteFileSystem(paramParcel);
  }
  
  public CopyOnWriteFileSystem[] newArray(int paramInt)
  {
    return new CopyOnWriteFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem.1
 * JD-Core Version:    0.7.0.1
 */