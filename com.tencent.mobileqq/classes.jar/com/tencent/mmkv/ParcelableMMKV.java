package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;

public final class ParcelableMMKV
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new ParcelableMMKV.1();
  private int jdField_a_of_type_Int = -1;
  private final String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = null;
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    this.jdField_a_of_type_JavaLangString = paramMMKV.mmapID();
    this.jdField_a_of_type_Int = paramMMKV.ashmemFD();
    this.jdField_b_of_type_Int = paramMMKV.ashmemMetaFD();
    this.jdField_b_of_type_JavaLangString = paramMMKV.cryptKey();
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public MMKV a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i >= 0)
    {
      int j = this.jdField_b_of_type_Int;
      if (j >= 0) {
        return MMKV.a(this.jdField_a_of_type_JavaLangString, i, j, this.jdField_b_of_type_JavaLangString);
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.jdField_a_of_type_Int);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.jdField_b_of_type_Int);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    catch (IOException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mmkv.ParcelableMMKV
 * JD-Core Version:    0.7.0.1
 */