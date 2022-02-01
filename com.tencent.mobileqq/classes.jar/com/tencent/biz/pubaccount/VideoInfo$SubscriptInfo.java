package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import omp;

public class VideoInfo$SubscriptInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SubscriptInfo> CREATOR = new omp();
  public int a;
  public String a;
  public int b;
  public int c;
  
  public VideoInfo$SubscriptInfo() {}
  
  public VideoInfo$SubscriptInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SubscriptInfo{subscriptText='" + this.jdField_a_of_type_JavaLangString + '\'' + ", subscriptColor=" + this.jdField_a_of_type_Int + ", backgroundColor=" + this.b + ", subscriptType=" + this.c + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo.SubscriptInfo
 * JD-Core Version:    0.7.0.1
 */