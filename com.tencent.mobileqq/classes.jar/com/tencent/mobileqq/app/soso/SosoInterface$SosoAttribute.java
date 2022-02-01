package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apcr;

public final class SosoInterface$SosoAttribute
  implements Parcelable
{
  public static final Parcelable.Creator<SosoAttribute> CREATOR = new apcr();
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public SosoInterface$SosoAttribute(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public SosoInterface$SosoAttribute(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public SosoAttribute a()
  {
    return new SosoAttribute(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_Boolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute
 * JD-Core Version:    0.7.0.1
 */