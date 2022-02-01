package com.tencent.luggage.wxa.by;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.pc.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.HashMap;

public class a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new a.2();
  private static final HashMap<String, a> i = new HashMap();
  private static final h<String, a.c> j = new h();
  public int a;
  public String b;
  public int c;
  private String d;
  private c e;
  private int f;
  private String g;
  private Object h;
  
  private a() {}
  
  private a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public static void a(c paramc)
  {
    if (paramc == null) {
      return;
    }
    a locala = new a();
    i.put(paramc.getAppId(), locala);
    locala.a = 1;
    locala.b = paramc.getAppId();
    locala.e = paramc;
    locala.g();
  }
  
  public static void a(String paramString, a.c paramc)
  {
    if (paramc != null) {
      j.a(paramString, paramc);
    }
  }
  
  public static void b(c paramc)
  {
    if (paramc == null) {
      return;
    }
    a locala = (a)i.remove(paramc.getAppId());
    if (locala == null) {
      return;
    }
    j.b(paramc.getAppId());
    locala.a = 2;
    locala.b = paramc.getAppId();
    locala.e = null;
    locala.f();
  }
  
  private void j()
  {
    b.a(this);
  }
  
  private void k()
  {
    b.b(this);
  }
  
  private void l()
  {
    String str = this.b;
    if (str != null)
    {
      Object localObject = this.h;
      if (localObject == null) {
        return;
      }
      f.a.a(new a.1(this, str, localObject), "MicroMsg.WMPFToClientEvent");
    }
  }
  
  private void m()
  {
    if (this.e == null) {
      return;
    }
    a.a locala = new a.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", Integer.valueOf(this.c));
    localHashMap.put("data", this.d);
    locala.a(this.e).a(localHashMap).a();
  }
  
  private void n()
  {
    a.b localb = new a.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("count", Integer.valueOf(this.f));
    localHashMap.put("data", this.d);
    localb.a(this.e).a(localHashMap).a();
  }
  
  public void a()
  {
    int k = this.a;
    if (k != 1)
    {
      if (k != 2) {
        return;
      }
      k();
      return;
    }
    j();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.f = paramParcel.readInt();
    try
    {
      this.g = paramParcel.readString();
      if (!af.c(this.g))
      {
        Class localClass = Class.forName(this.g);
        if (localClass != null)
        {
          this.h = paramParcel.readParcelable(localClass.getClassLoader());
          return;
        }
      }
    }
    catch (Exception paramParcel)
    {
      o.f("MicroMsg.WMPFToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
    }
  }
  
  <T extends Parcelable> void a(T paramT)
  {
    if (paramT == null) {
      return;
    }
    try
    {
      this.a = 5;
      this.g = paramT.getClass().getName();
      this.h = paramT;
      e();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    int k = this.a;
    if (k != 3)
    {
      if (k != 4)
      {
        if (k != 5) {
          return;
        }
        l();
        return;
      }
      n();
      return;
    }
    m();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.f);
    if ((!af.c(this.g)) && (this.h != null))
    {
      paramParcel.writeString(this.g);
      paramParcel.writeParcelable((Parcelable)this.h, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.by.a
 * JD-Core Version:    0.7.0.1
 */