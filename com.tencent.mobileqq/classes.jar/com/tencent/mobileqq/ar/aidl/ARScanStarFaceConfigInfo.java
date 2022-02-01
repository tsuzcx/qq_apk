package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanStarFaceConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceConfigInfo> CREATOR = new ARScanStarFaceConfigInfo.1();
  public String a;
  public ARScanStarFaceActInfo[] a;
  
  public ARScanStarFaceConfigInfo() {}
  
  protected ARScanStarFaceConfigInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo = ((ARScanStarFaceActInfo[])paramParcel.createTypedArray(ARScanStarFaceActInfo.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeTypedArray(this.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo
 * JD-Core Version:    0.7.0.1
 */