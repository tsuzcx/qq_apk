package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.b;

public class p
  extends b
{
  public static final Parcelable.Creator<p> CREATOR = new p.1();
  public String a;
  public int b;
  public String c;
  
  public void a()
  {
    c localc;
    if (e.a(a.class) == null) {
      localc = null;
    } else {
      localc = ((a)e.a(a.class)).a();
    }
    if (localc == null) {
      return;
    }
    localc.b(this.b, this.a, this.c);
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.p
 * JD-Core Version:    0.7.0.1
 */