package com.huawei.hms.support.api.client;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Status$a
  implements Parcelable.Creator
{
  public Status createFromParcel(Parcel paramParcel)
  {
    return new Status(paramParcel.readInt(), paramParcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(paramParcel));
  }
  
  public Status[] newArray(int paramInt)
  {
    return new Status[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.client.Status.a
 * JD-Core Version:    0.7.0.1
 */