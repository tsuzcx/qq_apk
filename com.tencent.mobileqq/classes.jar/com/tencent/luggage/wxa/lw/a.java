package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.b;

public class a
  extends b
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public String a;
  public int b;
  public Runnable c;
  
  public a() {}
  
  protected a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a()
  {
    c localc;
    if (e.a(com.tencent.luggage.wxa.dp.a.class) == null) {
      localc = null;
    } else {
      localc = ((com.tencent.luggage.wxa.dp.a)e.a(com.tencent.luggage.wxa.dp.a.class)).a();
    }
    if (localc == null)
    {
      e();
      return;
    }
    this.b = localc.b(this.a);
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public void b()
  {
    Runnable localRunnable = this.c;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.a
 * JD-Core Version:    0.7.0.1
 */