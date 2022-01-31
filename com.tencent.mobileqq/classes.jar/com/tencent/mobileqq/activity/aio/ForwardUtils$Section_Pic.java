package com.tencent.mobileqq.activity.aio;

import aclq;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ForwardUtils$Section_Pic
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator<Section_Pic> CREATOR = new aclq();
  public String a;
  public String b;
  
  public ForwardUtils$Section_Pic()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public ForwardUtils$Section_Pic(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Pic
 * JD-Core Version:    0.7.0.1
 */