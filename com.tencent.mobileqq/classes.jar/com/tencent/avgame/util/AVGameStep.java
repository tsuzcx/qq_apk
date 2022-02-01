package com.tencent.avgame.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import nfw;

public class AVGameStep
  implements Parcelable
{
  public static final Parcelable.Creator<AVGameStep> CREATOR = new nfw();
  public int a;
  public long a;
  public String a;
  public long b;
  
  public AVGameStep(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.b = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public AVGameStep(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != 0L;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Long != 0L) && (this.b != 0L);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AVGameStep{" + this.jdField_a_of_type_JavaLangString + "," + this.jdField_a_of_type_Long + "," + this.b + "," + this.jdField_a_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.util.AVGameStep
 * JD-Core Version:    0.7.0.1
 */