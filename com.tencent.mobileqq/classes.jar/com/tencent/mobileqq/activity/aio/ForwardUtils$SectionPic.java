package com.tencent.mobileqq.activity.aio;

import agij;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ForwardUtils$SectionPic
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator<SectionPic> CREATOR = new agij();
  public String a;
  public String b;
  
  public ForwardUtils$SectionPic()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public ForwardUtils$SectionPic(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionPic
 * JD-Core Version:    0.7.0.1
 */