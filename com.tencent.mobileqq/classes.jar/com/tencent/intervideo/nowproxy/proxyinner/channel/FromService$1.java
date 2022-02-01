package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FromService$1
  implements Parcelable.Creator<FromService>
{
  public FromService a(Parcel paramParcel)
  {
    FromService localFromService = new FromService();
    localFromService.a = paramParcel.readInt();
    localFromService.b = paramParcel.readInt();
    localFromService.c = paramParcel.readInt();
    localFromService.d = paramParcel.readBundle();
    return localFromService;
  }
  
  public FromService[] a(int paramInt)
  {
    return new FromService[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.FromService.1
 * JD-Core Version:    0.7.0.1
 */