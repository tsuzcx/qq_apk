package com.tencent.biz.pubaccount.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProfileParams$1
  implements Parcelable.Creator<ProfileParams>
{
  public ProfileParams a(Parcel paramParcel)
  {
    ProfileParams.Builder localBuilder = new ProfileParams.Builder();
    localBuilder.a(paramParcel.readString()).a(paramParcel.readInt()).b(paramParcel.readString()).c(paramParcel.readString()).d(paramParcel.readString()).a((ProfileParams.CurLoginUsr)paramParcel.readParcelable(ProfileParams.CurLoginUsr.CREATOR.getClass().getClassLoader()));
    return localBuilder.a();
  }
  
  public ProfileParams[] a(int paramInt)
  {
    return new ProfileParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProfileParams.1
 * JD-Core Version:    0.7.0.1
 */