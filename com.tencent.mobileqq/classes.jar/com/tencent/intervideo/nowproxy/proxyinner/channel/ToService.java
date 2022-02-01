package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ToService
  implements Parcelable
{
  public static final Parcelable.Creator<ToService> CREATOR = new ToService.1();
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public String f;
  public Bundle g;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeBundle(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.ToService
 * JD-Core Version:    0.7.0.1
 */