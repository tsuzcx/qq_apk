package com.tencent.luggage.wxa.nr;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class a$c
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<c> CREATOR = new a.c.1();
  public String a;
  
  public a$c() {}
  
  public a$c(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a()
  {
    o.d("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
    String str = b.b().c();
    if ((!af.c(str)) && (!str.equals(this.a)))
    {
      o.d("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.a });
      e();
      return;
    }
    if (!b.b().d(this.a))
    {
      o.d("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.a });
      e();
      return;
    }
    if (com.tencent.luggage.wxa.ig.b.c()) {
      o.d("MicroMsg.AppBrandMusicClientService", "stop music ok");
    } else {
      o.b("MicroMsg.AppBrandMusicClientService", "stop music fail");
    }
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nr.a.c
 * JD-Core Version:    0.7.0.1
 */