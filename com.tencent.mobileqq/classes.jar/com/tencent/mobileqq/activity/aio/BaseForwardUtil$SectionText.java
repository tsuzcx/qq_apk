package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class BaseForwardUtil$SectionText
  extends BaseForwardUtil.SectionBase
{
  public static final Parcelable.Creator<SectionText> CREATOR = new BaseForwardUtil.SectionText.1();
  public String a;
  
  public BaseForwardUtil$SectionText()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  protected BaseForwardUtil$SectionText(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public BaseForwardUtil$SectionText(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionText
 * JD-Core Version:    0.7.0.1
 */