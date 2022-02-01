package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SmsRawData$1
  implements Parcelable.Creator<SmsRawData>
{
  public SmsRawData a(Parcel paramParcel)
  {
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    return new SmsRawData(arrayOfByte);
  }
  
  public SmsRawData[] a(int paramInt)
  {
    return new SmsRawData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.android.internal.telephony.SmsRawData.1
 * JD-Core Version:    0.7.0.1
 */