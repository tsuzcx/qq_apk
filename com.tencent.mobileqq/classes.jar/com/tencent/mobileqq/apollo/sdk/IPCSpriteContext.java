package com.tencent.mobileqq.apollo.sdk;

import ajgt;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCSpriteContext
  implements Parcelable
{
  public static final Parcelable.Creator<IPCSpriteContext> CREATOR = new ajgt();
  public float a;
  public int a;
  public String a;
  public float b;
  public int b;
  public String b;
  public float c;
  public int c;
  public int d;
  public int e;
  
  public IPCSpriteContext()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = -2.147484E+009F;
    this.jdField_c_of_type_Float = -2.147484E+009F;
  }
  
  public IPCSpriteContext(Parcel paramParcel)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = -2.147484E+009F;
    this.jdField_c_of_type_Float = -2.147484E+009F;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    this.jdField_c_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeFloat(this.jdField_c_of_type_Float);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.IPCSpriteContext
 * JD-Core Version:    0.7.0.1
 */