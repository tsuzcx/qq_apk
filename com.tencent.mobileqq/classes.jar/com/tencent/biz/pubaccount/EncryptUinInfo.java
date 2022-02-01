package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EncryptUinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EncryptUinInfo> CREATOR = new EncryptUinInfo.1();
  public long a;
  public int b;
  public String c;
  
  public EncryptUinInfo() {}
  
  protected EncryptUinInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinInfo
 * JD-Core Version:    0.7.0.1
 */