package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProfileParams$CurLoginUsr$1
  implements Parcelable.Creator<ProfileParams.CurLoginUsr>
{
  public ProfileParams.CurLoginUsr a(Parcel paramParcel)
  {
    return new ProfileParams.CurLoginUsr(paramParcel.readString(), paramParcel.readString());
  }
  
  public ProfileParams.CurLoginUsr[] a(int paramInt)
  {
    return new ProfileParams.CurLoginUsr[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr.1
 * JD-Core Version:    0.7.0.1
 */