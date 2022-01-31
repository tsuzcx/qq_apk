package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Locale;
import lrq;

public class CG
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new lrq();
  public final int a;
  public final String a;
  public final String b;
  
  public CG(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  protected CG(String paramString)
  {
    paramString = paramString.split(":");
    this.jdField_a_of_type_Int = Integer.parseInt(paramString[0]);
    this.jdField_a_of_type_JavaLangString = paramString[1];
    this.b = paramString[2];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "%d:%s:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.CG
 * JD-Core Version:    0.7.0.1
 */