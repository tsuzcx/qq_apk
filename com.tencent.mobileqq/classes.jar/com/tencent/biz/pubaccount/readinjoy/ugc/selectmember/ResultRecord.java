package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import pvo;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new pvo();
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public ResultRecord() {}
  
  public ResultRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  private ResultRecord(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private ResultRecord(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static ResultRecord a(String paramString1, String paramString2)
  {
    return new ResultRecord(paramString1, paramString2);
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt)
  {
    return new ResultRecord(paramString1, paramString2, paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (ResultRecord)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "ResultRecord{uin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */