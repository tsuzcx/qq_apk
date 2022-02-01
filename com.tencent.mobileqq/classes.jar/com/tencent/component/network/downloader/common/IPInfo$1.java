package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class IPInfo$1
  implements Parcelable.Creator<IPInfo>
{
  public IPInfo createFromParcel(Parcel paramParcel)
  {
    return new IPInfo(paramParcel);
  }
  
  public IPInfo[] newArray(int paramInt)
  {
    return new IPInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.IPInfo.1
 * JD-Core Version:    0.7.0.1
 */