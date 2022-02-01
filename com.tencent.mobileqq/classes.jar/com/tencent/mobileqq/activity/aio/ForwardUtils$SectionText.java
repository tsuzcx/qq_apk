package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ForwardUtils$SectionText
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator<SectionText> CREATOR = new ForwardUtils.SectionText.1();
  public String mTextString;
  
  public ForwardUtils$SectionText()
  {
    this.mForwardType = -1;
  }
  
  protected ForwardUtils$SectionText(Parcel paramParcel)
  {
    super(paramParcel);
    this.mTextString = paramParcel.readString();
  }
  
  public ForwardUtils$SectionText(String paramString)
  {
    this.mForwardType = -1;
    this.mTextString = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mTextString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionText
 * JD-Core Version:    0.7.0.1
 */