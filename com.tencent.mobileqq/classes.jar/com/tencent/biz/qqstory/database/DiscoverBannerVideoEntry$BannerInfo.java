package com.tencent.biz.qqstory.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DiscoverBannerVideoEntry$BannerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BannerInfo> CREATOR = new DiscoverBannerVideoEntry.BannerInfo.1();
  public String a;
  public String b;
  
  public DiscoverBannerVideoEntry$BannerInfo() {}
  
  protected DiscoverBannerVideoEntry$BannerInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo
 * JD-Core Version:    0.7.0.1
 */