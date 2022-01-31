package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NativeFileSystem$2
  implements Parcelable.Creator<NativeFileSystem>
{
  public NativeFileSystem createFromParcel(Parcel paramParcel)
  {
    return new NativeFileSystem(paramParcel);
  }
  
  public NativeFileSystem[] newArray(int paramInt)
  {
    return new NativeFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.2
 * JD-Core Version:    0.7.0.1
 */