package com.tencent.mobileqq.activity.selectmember;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import yab;

public class ResultRecord
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new yab();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public ResultRecord() {}
  
  private ResultRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
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
    localStringBuilder.append(", name:").append(this.b);
    localStringBuilder.append(", type:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", groupUin:").append(this.c);
    localStringBuilder.append(", phone:").append(this.d).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ResultRecord
 * JD-Core Version:    0.7.0.1
 */