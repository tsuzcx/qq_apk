package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ForwardUtils$SectionBase
  implements Parcelable
{
  public static final Parcelable.Creator<SectionBase> CREATOR = new ForwardUtils.SectionBase.1();
  public int mForwardType;
  
  protected ForwardUtils$SectionBase() {}
  
  protected ForwardUtils$SectionBase(Parcel paramParcel)
  {
    this.mForwardType = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mForwardType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase
 * JD-Core Version:    0.7.0.1
 */