package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ToService$1
  implements Parcelable.Creator<ToService>
{
  public ToService a(Parcel paramParcel)
  {
    ToService localToService = new ToService();
    localToService.a = paramParcel.readInt();
    localToService.b = paramParcel.readInt();
    localToService.c = paramParcel.readInt();
    localToService.d = paramParcel.readInt();
    localToService.e = paramParcel.readLong();
    localToService.f = paramParcel.readString();
    localToService.g = paramParcel.readBundle();
    return localToService;
  }
  
  public ToService[] a(int paramInt)
  {
    return new ToService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.ToService.1
 * JD-Core Version:    0.7.0.1
 */