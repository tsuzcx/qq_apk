package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class BaseForwardUtil$SectionText
  extends BaseForwardUtil.SectionBase
{
  public static final Parcelable.Creator<SectionText> CREATOR = new BaseForwardUtil.SectionText.1();
  public String b;
  
  public BaseForwardUtil$SectionText()
  {
    this.a = -1;
  }
  
  protected BaseForwardUtil$SectionText(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = paramParcel.readString();
  }
  
  public BaseForwardUtil$SectionText(String paramString)
  {
    this.a = -1;
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionText
 * JD-Core Version:    0.7.0.1
 */