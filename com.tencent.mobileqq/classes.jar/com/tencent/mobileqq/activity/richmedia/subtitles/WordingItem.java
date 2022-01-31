package com.tencent.mobileqq.activity.richmedia.subtitles;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import xtm;

public class WordingItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new xtm();
  public long a;
  public String a;
  public byte[] a;
  public long b;
  public String b;
  public long c;
  
  public WordingItem() {}
  
  public WordingItem(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      paramParcel.readByteArray(this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramInt = 0;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      paramInt = this.jdField_a_of_type_ArrayOfByte.length;
    }
    paramParcel.writeInt(paramInt);
    if (paramInt > 0) {
      paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem
 * JD-Core Version:    0.7.0.1
 */