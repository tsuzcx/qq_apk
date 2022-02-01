package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanStarFaceConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanStarFaceConfigInfo> CREATOR = new ARScanStarFaceConfigInfo.1();
  public String a;
  public ARScanStarFaceActInfo[] b;
  
  public ARScanStarFaceConfigInfo() {}
  
  protected ARScanStarFaceConfigInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((ARScanStarFaceActInfo[])paramParcel.createTypedArray(ARScanStarFaceActInfo.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeTypedArray(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo
 * JD-Core Version:    0.7.0.1
 */