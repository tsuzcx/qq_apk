package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AssetsSchemeResolver$SingletonCreator
  implements Parcelable.Creator<AssetsSchemeResolver>
{
  static final AssetsSchemeResolver INSTANCE = new AssetsSchemeResolver(null);
  
  public AssetsSchemeResolver createFromParcel(Parcel paramParcel)
  {
    return INSTANCE;
  }
  
  public AssetsSchemeResolver[] newArray(int paramInt)
  {
    return new AssetsSchemeResolver[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver.SingletonCreator
 * JD-Core Version:    0.7.0.1
 */