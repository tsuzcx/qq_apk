package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BaseForwardUtil$SectionBase
  implements Parcelable
{
  public static final Parcelable.Creator<SectionBase> CREATOR = new BaseForwardUtil.SectionBase.1();
  public int a = 0;
  
  protected BaseForwardUtil$SectionBase() {}
  
  protected BaseForwardUtil$SectionBase(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseForwardUtil.SectionBase
 * JD-Core Version:    0.7.0.1
 */