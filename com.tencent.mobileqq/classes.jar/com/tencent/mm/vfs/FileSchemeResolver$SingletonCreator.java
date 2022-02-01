package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FileSchemeResolver$SingletonCreator
  implements Parcelable.Creator<FileSchemeResolver>
{
  static final FileSchemeResolver INSTANCE = new FileSchemeResolver(null);
  
  public FileSchemeResolver createFromParcel(Parcel paramParcel)
  {
    return INSTANCE;
  }
  
  public FileSchemeResolver[] newArray(int paramInt)
  {
    return new FileSchemeResolver[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver.SingletonCreator
 * JD-Core Version:    0.7.0.1
 */