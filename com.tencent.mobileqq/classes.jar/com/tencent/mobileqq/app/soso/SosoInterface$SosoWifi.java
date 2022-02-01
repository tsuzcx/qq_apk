package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SosoInterface$SosoWifi
  implements Parcelable
{
  public static final Parcelable.Creator<SosoWifi> CREATOR = new SosoInterface.SosoWifi.1();
  public long mMac;
  public String mMacStr;
  public int mRssi;
  
  protected SosoInterface$SosoWifi(Parcel paramParcel)
  {
    this.mRssi = paramParcel.readInt();
    this.mMac = paramParcel.readLong();
    this.mMacStr = paramParcel.readString();
  }
  
  public SosoInterface$SosoWifi(String paramString, int paramInt)
  {
    this.mRssi = paramInt;
    this.mMacStr = paramString;
    this.mMac = macToLong(paramString);
  }
  
  public static long macToLong(String paramString)
  {
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int j = 40;
        int i = 0;
        long l1 = 0L;
        while (i < paramString.length)
        {
          long l2 = Long.parseLong(paramString[i], 16);
          long l3 = l2;
          if (j > 0) {
            l3 = l2 << j;
          }
          l1 += l3;
          j -= 8;
          i += 1;
        }
        return l1;
      }
    }
    catch (Exception paramString)
    {
      return 0L;
    }
    return 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRssi);
    paramParcel.writeLong(this.mMac);
    paramParcel.writeString(this.mMacStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi
 * JD-Core Version:    0.7.0.1
 */