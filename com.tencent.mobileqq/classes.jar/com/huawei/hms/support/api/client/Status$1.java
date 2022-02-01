package com.huawei.hms.support.api.client;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Status$1
  implements Parcelable.Creator
{
  public Status a(Parcel paramParcel)
  {
    return new Status(paramParcel.readInt(), paramParcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(paramParcel));
  }
  
  public Status[] a(int paramInt)
  {
    return new Status[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.Status.1
 * JD-Core Version:    0.7.0.1
 */