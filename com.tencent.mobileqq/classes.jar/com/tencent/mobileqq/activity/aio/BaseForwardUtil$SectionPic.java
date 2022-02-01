package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class BaseForwardUtil$SectionPic
  extends BaseForwardUtil.SectionBase
{
  public static final Parcelable.Creator<SectionPic> CREATOR = new BaseForwardUtil.SectionPic.1();
  public String a;
  public String b;
  
  public BaseForwardUtil$SectionPic()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  protected BaseForwardUtil$SectionPic(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionPic
 * JD-Core Version:    0.7.0.1
 */