package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apct;
import java.util.ArrayList;

public class SosoInterface$SosoLbsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SosoLbsInfo> CREATOR = new apct();
  public long a;
  public SosoInterface.SosoAttribute a;
  public SosoInterface.SosoLocation a;
  public String a;
  public ArrayList<SosoInterface.SosoCell> a;
  public byte[] a;
  public String b;
  public ArrayList<SosoInterface.SosoWifi> b;
  
  public SosoInterface$SosoLbsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public SosoInterface$SosoLbsInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfByte = paramParcel.createByteArray();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = ((SosoInterface.SosoAttribute)paramParcel.readParcelable(SosoInterface.SosoAttribute.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = ((SosoInterface.SosoLocation)paramParcel.readParcelable(SosoInterface.SosoLocation.class.getClassLoader()));
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(SosoInterface.SosoCell.CREATOR);
    this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(SosoInterface.SosoWifi.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.jdField_a_of_type_ArrayOfByte);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramInt);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeTypedList(this.jdField_b_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo
 * JD-Core Version:    0.7.0.1
 */