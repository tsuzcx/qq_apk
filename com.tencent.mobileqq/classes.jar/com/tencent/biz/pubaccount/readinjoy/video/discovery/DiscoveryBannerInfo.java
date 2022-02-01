package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import sgb;

public class DiscoveryBannerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryBannerInfo> CREATOR = new sgb();
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  
  public DiscoveryBannerInfo() {}
  
  public DiscoveryBannerInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DiscoveryBannerInfo{bannerId=" + this.jdField_a_of_type_Long + ", coverUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", coverTitle='" + this.b + '\'' + ", jumpType=" + this.jdField_a_of_type_Int + ", jumpDataJson='" + this.c + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryBannerInfo
 * JD-Core Version:    0.7.0.1
 */