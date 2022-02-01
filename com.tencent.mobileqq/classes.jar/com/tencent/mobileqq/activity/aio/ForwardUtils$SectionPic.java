package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ForwardUtils$SectionPic
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator<SectionPic> CREATOR = new ForwardUtils.SectionPic.1();
  public String mBigURL;
  public String mThumbURL;
  
  public ForwardUtils$SectionPic()
  {
    this.mForwardType = 1;
  }
  
  protected ForwardUtils$SectionPic(Parcel paramParcel)
  {
    super(paramParcel);
    this.mThumbURL = paramParcel.readString();
    this.mBigURL = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mThumbURL);
    paramParcel.writeString(this.mBigURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionPic
 * JD-Core Version:    0.7.0.1
 */