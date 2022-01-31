package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import qdd;

public class SocializeFeedsInfo$UGCVoiceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UGCVoiceInfo> CREATOR = new qdd();
  public int a;
  public String a;
  public boolean a;
  public int b;
  
  protected SocializeFeedsInfo$UGCVoiceInfo() {}
  
  public SocializeFeedsInfo$UGCVoiceInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo
 * JD-Core Version:    0.7.0.1
 */