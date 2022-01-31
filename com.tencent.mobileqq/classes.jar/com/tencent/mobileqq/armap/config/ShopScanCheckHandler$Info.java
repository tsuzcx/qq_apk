package com.tencent.mobileqq.armap.config;

import abms;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ShopScanCheckHandler$Info
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new abms();
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public ShopScanCheckHandler$Info() {}
  
  public ShopScanCheckHandler$Info(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Info{taskType=" + this.jdField_a_of_type_Int + ", taskId=" + this.jdField_b_of_type_Long + ", poiId=" + this.jdField_a_of_type_Long + ", xmlUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", xmlMd5='" + this.jdField_b_of_type_JavaLangString + '\'' + ", picUrl='" + this.c + '\'' + ", picMD5='" + this.d + '\'' + ", picPath='" + this.e + '\'' + ", iconUrl='" + this.f + '\'' + ", iconMd5='" + this.g + '\'' + ", iconPath='" + this.h + '\'' + ", title='" + this.i + '\'' + ", shopName='" + this.j + '\'' + ", shopLocation='" + this.k + '\'' + ", xmlContent='" + this.l + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info
 * JD-Core Version:    0.7.0.1
 */