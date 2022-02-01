package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import qys;

public class TagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TagInfo> CREATOR = new qys();
  private final double jdField_a_of_type_Double;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private final long b;
  
  public TagInfo(long paramLong1, String paramString, double paramDouble, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.b = paramLong2;
  }
  
  public TagInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Double = paramParcel.readDouble();
    this.b = paramParcel.readLong();
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (TagInfo)paramObject;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long);
        bool1 = bool2;
      } while (Double.compare(paramObject.jdField_a_of_type_Double, this.jdField_a_of_type_Double) != 0);
      bool1 = bool2;
    } while (this.b != paramObject.b);
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    int i = (int)(this.jdField_a_of_type_Long ^ this.jdField_a_of_type_Long >>> 32);
    int j = this.jdField_a_of_type_JavaLangString.hashCode();
    long l = Double.doubleToLongBits(this.jdField_a_of_type_Double);
    return ((i * 31 + j) * 31 + (int)(l ^ l >>> 32)) * 31 + (int)(this.b ^ this.b >>> 32);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeDouble(this.jdField_a_of_type_Double);
    paramParcel.writeLong(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TagInfo
 * JD-Core Version:    0.7.0.1
 */