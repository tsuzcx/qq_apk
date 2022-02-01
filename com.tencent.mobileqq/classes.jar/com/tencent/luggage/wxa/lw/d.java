package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.b;

public class d
  extends b
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public String a;
  public int b;
  
  public d() {}
  
  public d(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
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
    localc.a(this.b, this.a);
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.d
 * JD-Core Version:    0.7.0.1
 */