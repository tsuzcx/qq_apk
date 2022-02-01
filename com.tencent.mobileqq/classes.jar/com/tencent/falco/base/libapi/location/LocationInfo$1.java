package com.tencent.falco.base.libapi.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LocationInfo$1
  implements Parcelable.Creator<LocationInfo>
{
  public LocationInfo createFromParcel(Parcel paramParcel)
  {
    return new LocationInfo(paramParcel);
  }
  
  public LocationInfo[] newArray(int paramInt)
  {
    return new LocationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.location.LocationInfo.1
 * JD-Core Version:    0.7.0.1
 */