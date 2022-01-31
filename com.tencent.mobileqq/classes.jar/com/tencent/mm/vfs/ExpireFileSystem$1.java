package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ExpireFileSystem$1
  implements Parcelable.Creator<ExpireFileSystem>
{
  public ExpireFileSystem createFromParcel(Parcel paramParcel)
  {
    return new ExpireFileSystem(paramParcel);
  }
  
  public ExpireFileSystem[] newArray(int paramInt)
  {
    return new ExpireFileSystem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem.1
 * JD-Core Version:    0.7.0.1
 */