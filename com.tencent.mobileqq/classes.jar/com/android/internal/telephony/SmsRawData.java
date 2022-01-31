package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import g;

public class SmsRawData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  byte[] a;
  
  public SmsRawData(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.length);
    paramParcel.writeByteArray(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.internal.telephony.SmsRawData
 * JD-Core Version:    0.7.0.1
 */