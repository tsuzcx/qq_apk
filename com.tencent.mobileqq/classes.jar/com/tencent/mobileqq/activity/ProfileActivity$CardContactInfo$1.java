package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ProfileActivity$CardContactInfo$1
  implements Parcelable.Creator<ProfileActivity.CardContactInfo>
{
  public ProfileActivity.CardContactInfo a(Parcel paramParcel)
  {
    ProfileActivity.CardContactInfo localCardContactInfo = new ProfileActivity.CardContactInfo(null);
    localCardContactInfo.a = paramParcel.readString();
    localCardContactInfo.c = paramParcel.readString();
    localCardContactInfo.b = paramParcel.readString();
    return localCardContactInfo;
  }
  
  public ProfileActivity.CardContactInfo[] a(int paramInt)
  {
    return new ProfileActivity.CardContactInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo.1
 * JD-Core Version:    0.7.0.1
 */