package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ContentsSchemeResolver$SingletonCreator
  implements Parcelable.Creator<ContentsSchemeResolver>
{
  static final ContentsSchemeResolver INSTANCE = new ContentsSchemeResolver(null);
  
  public ContentsSchemeResolver createFromParcel(Parcel paramParcel)
  {
    return INSTANCE;
  }
  
  public ContentsSchemeResolver[] newArray(int paramInt)
  {
    return new ContentsSchemeResolver[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver.SingletonCreator
 * JD-Core Version:    0.7.0.1
 */