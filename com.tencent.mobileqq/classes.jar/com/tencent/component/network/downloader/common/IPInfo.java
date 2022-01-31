package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import pof;

public class IPInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new pof();
  public int a;
  public String a;
  
  public IPInfo() {}
  
  public IPInfo(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public IPInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public IPInfo a()
  {
    return new IPInfo(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof IPInfo))) {
        break;
      }
      paramObject = (IPInfo)paramObject;
    } while ((a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) && (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int));
    return false;
    return false;
  }
  
  public String toString()
  {
    return new String(this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.IPInfo
 * JD-Core Version:    0.7.0.1
 */