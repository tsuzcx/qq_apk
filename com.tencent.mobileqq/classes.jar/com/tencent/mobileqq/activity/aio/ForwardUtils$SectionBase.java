package com.tencent.mobileqq.activity.aio;

import aesd;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ForwardUtils$SectionBase
  implements Parcelable
{
  public static final Parcelable.Creator<SectionBase> CREATOR = new aesd();
  public int a;
  
  protected ForwardUtils$SectionBase() {}
  
  public ForwardUtils$SectionBase(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.SectionBase
 * JD-Core Version:    0.7.0.1
 */