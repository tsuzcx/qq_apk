package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class b
  implements Parcelable.Creator<RemoteMessage>
{
  public RemoteMessage createFromParcel(Parcel paramParcel)
  {
    return new RemoteMessage(paramParcel);
  }
  
  public RemoteMessage[] newArray(int paramInt)
  {
    return new RemoteMessage[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.push.b
 * JD-Core Version:    0.7.0.1
 */