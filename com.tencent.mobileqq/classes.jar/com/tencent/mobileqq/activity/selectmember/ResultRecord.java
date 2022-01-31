package com.tencent.mobileqq.activity.selectmember;

import ahrh;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator<ResultRecord> CREATOR = new ahrh();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public ResultRecord()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  private ResultRecord(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
  }
  
  public ResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.jdField_b_of_type_Int = -1;
    a(paramString1, paramString2, paramInt, paramString3, paramString4);
  }
  
  public static ResultRecord a(ResultRecord paramResultRecord)
  {
    ResultRecord localResultRecord = null;
    if (paramResultRecord != null)
    {
      localResultRecord = new ResultRecord();
      localResultRecord.jdField_a_of_type_JavaLangString = paramResultRecord.jdField_a_of_type_JavaLangString;
      localResultRecord.jdField_b_of_type_JavaLangString = paramResultRecord.jdField_b_of_type_JavaLangString;
      localResultRecord.jdField_a_of_type_Int = paramResultRecord.jdField_a_of_type_Int;
      localResultRecord.c = paramResultRecord.c;
      localResultRecord.d = paramResultRecord.d;
      localResultRecord.jdField_b_of_type_Int = paramResultRecord.jdField_b_of_type_Int;
    }
    return localResultRecord;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ResultRecord))
    {
      paramObject = (ResultRecord)paramObject;
      if ((paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(paramObject.d)) && (this.d.equals(paramObject.d))) || ((TextUtils.isEmpty(this.d)) && (TextUtils.isEmpty(paramObject.d))))) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", name:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", type:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", groupUin:").append(this.c);
    localStringBuilder.append(", uinType:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", phone:").append(this.d).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */