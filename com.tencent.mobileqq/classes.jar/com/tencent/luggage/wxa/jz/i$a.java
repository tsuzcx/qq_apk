package com.tencent.luggage.wxa.jz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ig.a;
import com.tencent.luggage.wxa.ig.c;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class i$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new i.a.1();
  public String a = "";
  public double b = 0.0D;
  public double c;
  public int d;
  public double e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public int m;
  public String n;
  public double o;
  public String p = null;
  public boolean q = false;
  public String r;
  
  public i$a() {}
  
  public i$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a()
  {
    Object localObject = com.tencent.luggage.wxa.nr.b.b().c();
    if ((!af.c((String)localObject)) && (!((String)localObject).equals(this.a)))
    {
      o.d("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[] { localObject, this.a });
      this.q = true;
      this.r = "appid not match cannot get background audio state";
      e();
      return;
    }
    localObject = a.f();
    if (localObject != null)
    {
      c localc = a.g();
      int i1 = -1;
      int i2;
      if (localc != null)
      {
        i1 = localc.a();
        i2 = localc.b();
      }
      else
      {
        i2 = -1;
      }
      if ((localc != null) && (i1 >= 0) && (i2 >= 0))
      {
        double d1 = i1;
        Double.isNaN(d1);
        this.b = (d1 / 1000.0D);
        d1 = i2;
        Double.isNaN(d1);
        this.c = (d1 / 1000.0D);
        i1 = localc.c();
        i2 = localc.d();
        double d2 = this.b;
        d1 = 0.0D;
        if (d2 > 0.0D)
        {
          d1 = i2;
          Double.isNaN(d1);
          d1 = d1 * d2 / 100.0D;
        }
        this.e = d1;
        if (i1 == 1) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        this.d = i1;
        this.f = ((e)localObject).i;
        this.g = ((e)localObject).e;
        this.h = ((e)localObject).g;
        this.i = ((e)localObject).f;
        this.j = ((e)localObject).h;
        this.k = ((e)localObject).k;
        this.l = ((e)localObject).w;
        this.m = ((e)localObject).u;
        this.n = ((e)localObject).l;
        this.o = ((e)localObject).A;
        this.p = ((e)localObject).D;
        o.e("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", new Object[] { Double.valueOf(this.b), Double.valueOf(this.c), Integer.valueOf(this.d), Double.valueOf(this.e), this.f, Integer.valueOf(this.m), this.g, this.i, this.k, this.j, this.l, Double.valueOf(this.o), this.p });
      }
      else
      {
        o.b("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
        this.q = true;
        this.r = "return parameter is invalid";
        e();
      }
    }
    else
    {
      o.b("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
      this.q = true;
      this.r = "currentWrapper is null";
    }
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readDouble();
    this.c = paramParcel.readDouble();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readDouble();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.n = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.o = paramParcel.readDouble();
    this.p = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeDouble(this.b);
    paramParcel.writeDouble(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeDouble(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.m);
    paramParcel.writeDouble(this.o);
    paramParcel.writeString(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.i.a
 * JD-Core Version:    0.7.0.1
 */