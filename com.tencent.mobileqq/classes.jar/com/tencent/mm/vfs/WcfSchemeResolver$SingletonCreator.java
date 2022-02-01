package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WcfSchemeResolver$SingletonCreator
  implements Parcelable.Creator<WcfSchemeResolver>
{
  static final WcfSchemeResolver INSTANCE = new WcfSchemeResolver(null);
  
  public WcfSchemeResolver createFromParcel(Parcel paramParcel)
  {
    return INSTANCE;
  }
  
  public WcfSchemeResolver[] newArray(int paramInt)
  {
    return new WcfSchemeResolver[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver.SingletonCreator
 * JD-Core Version:    0.7.0.1
 */