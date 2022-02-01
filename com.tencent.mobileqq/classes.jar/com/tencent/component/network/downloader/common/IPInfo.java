package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPInfo
  implements Parcelable
{
  public static final Parcelable.Creator<IPInfo> CREATOR = new IPInfo.1();
  public String ip;
  public int port;
  
  public IPInfo() {}
  
  public IPInfo(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.ip = paramParcel.readString();
    this.port = paramParcel.readInt();
  }
  
  public IPInfo(String paramString, int paramInt)
  {
    this.ip = paramString;
    this.port = paramInt;
  }
  
  public IPInfo clone()
  {
    return new IPInfo(this.ip, this.port);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equalWith(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return paramString2 == null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof IPInfo))) {
        break;
      }
      paramObject = (IPInfo)paramObject;
    } while ((equalWith(paramObject.ip, this.ip)) && (paramObject.port == this.port));
    return false;
    return false;
  }
  
  public String toString()
  {
    return new String(this.ip + ":" + this.port);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.ip);
    paramParcel.writeInt(this.port);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.IPInfo
 * JD-Core Version:    0.7.0.1
 */