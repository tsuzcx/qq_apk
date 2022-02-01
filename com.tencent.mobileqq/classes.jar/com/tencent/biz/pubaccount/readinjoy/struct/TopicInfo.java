package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import rig;
import rih;

public class TopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TopicInfo> CREATOR = new rig();
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public TopicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.e = paramParcel.readString();
  }
  
  private TopicInfo(rih paramrih)
  {
    this.jdField_a_of_type_Long = rih.a(paramrih);
    this.jdField_a_of_type_JavaLangString = rih.a(paramrih);
    this.jdField_b_of_type_JavaLangString = rih.b(paramrih);
    this.c = rih.c(paramrih);
    this.d = rih.d(paramrih);
    this.jdField_b_of_type_Long = rih.b(paramrih);
    this.jdField_a_of_type_Boolean = rih.a(paramrih);
  }
  
  public static rih a()
  {
    return new rih(null);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "TopicInfo{topicId=" + this.jdField_a_of_type_Long + ", topicTitle='" + this.jdField_a_of_type_JavaLangString + '\'' + ", topicSummary='" + this.jdField_b_of_type_JavaLangString + '\'' + ", topicCoverUrl='" + this.c + '\'' + ", topicJumpUrl='" + this.d + '\'' + ", topicUin='" + this.jdField_b_of_type_Long + '\'' + ", topicBannerUrl='" + this.e + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo
 * JD-Core Version:    0.7.0.1
 */