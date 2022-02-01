package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MigrationFileSystem$1
  implements Parcelable.Creator<MigrationFileSystem>
{
  public MigrationFileSystem createFromParcel(Parcel paramParcel)
  {
    return new MigrationFileSystem(paramParcel);
  }
  
  public MigrationFileSystem[] newArray(int paramInt)
  {
    return new MigrationFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem.1
 * JD-Core Version:    0.7.0.1
 */