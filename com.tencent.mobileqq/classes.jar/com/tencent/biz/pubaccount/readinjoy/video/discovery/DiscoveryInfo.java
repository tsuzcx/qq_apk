package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import qwt;

public class DiscoveryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryInfo> CREATOR = new qwt();
  public int a;
  public long a;
  public String a;
  public ArrayList<DiscoveryInfo.TopicVideoCard> a;
  public boolean a;
  public int[] a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public DiscoveryInfo()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  public DiscoveryInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(DiscoveryInfo.TopicVideoCard.CREATOR);
      this.f = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DiscoveryInfo{topicId=" + this.jdField_a_of_type_Long + ", title='" + this.jdField_a_of_type_JavaLangString + '\'' + ", coverUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", subtitle='" + this.c + '\'' + ", playCounts=" + this.d + ", jumpUrl='" + this.e + '\'' + ", hasRecomment=" + this.jdField_a_of_type_Boolean + ", effectiveTime=" + this.jdField_a_of_type_Int + ", expiationTime=" + this.jdField_b_of_type_Int + ", commonData=" + this.f + ", topicVideoCards=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeString(this.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryInfo
 * JD-Core Version:    0.7.0.1
 */