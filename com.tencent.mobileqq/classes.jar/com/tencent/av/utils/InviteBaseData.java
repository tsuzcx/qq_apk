package com.tencent.av.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InviteBaseData
  implements Parcelable
{
  public static final Parcelable.Creator<InviteBaseData> CREATOR = new InviteBaseData.1();
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d = "-1";
  
  public InviteBaseData()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  protected InviteBaseData(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[uin=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",type=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",phone=").append(this.c).append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.InviteBaseData
 * JD-Core Version:    0.7.0.1
 */