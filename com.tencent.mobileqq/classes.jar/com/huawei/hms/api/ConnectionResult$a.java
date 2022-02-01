package com.huawei.hms.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ConnectionResult$a
  implements Parcelable.Creator<ConnectionResult>
{
  public ConnectionResult createFromParcel(Parcel paramParcel)
  {
    return new ConnectionResult(paramParcel, null);
  }
  
  public ConnectionResult[] newArray(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.ConnectionResult.a
 * JD-Core Version:    0.7.0.1
 */