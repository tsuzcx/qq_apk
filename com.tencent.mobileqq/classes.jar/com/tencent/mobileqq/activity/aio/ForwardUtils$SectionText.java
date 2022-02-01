package com.tencent.mobileqq.activity.aio;

import agik;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ForwardUtils$SectionText
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator<SectionText> CREATOR = new agik();
  public String a;
  
  public ForwardUtils$SectionText()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public ForwardUtils$SectionText(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public ForwardUtils$SectionText(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionText
 * JD-Core Version:    0.7.0.1
 */