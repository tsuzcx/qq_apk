package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import ruw;

public class LikeAnimationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LikeAnimationInfo> CREATOR = new ruw();
  public int a;
  public String[] a;
  
  public LikeAnimationInfo() {}
  
  public LikeAnimationInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramParcel.createStringArray();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "LikeAnimationInfo{icons=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + ", nextReqInterval=" + this.jdField_a_of_type_Int + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo
 * JD-Core Version:    0.7.0.1
 */