package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class BaseForwardUtil$SectionPic
  extends BaseForwardUtil.SectionBase
{
  public static final Parcelable.Creator<SectionPic> CREATOR = new BaseForwardUtil.SectionPic.1();
  public String b;
  public String c;
  
  public BaseForwardUtil$SectionPic()
  {
    this.a = 1;
  }
  
  protected BaseForwardUtil$SectionPic(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionPic
 * JD-Core Version:    0.7.0.1
 */