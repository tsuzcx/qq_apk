package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qz.o;

class b$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new b.a.1();
  private int a;
  private String b;
  private Bundle c;
  
  protected b$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  private b$a(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramBundle;
  }
  
  public void a()
  {
    o.d("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a.a(this.a, this.b, this.c);
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readBundle();
  }
  
  public void b()
  {
    super.b();
    i();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeBundle(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.b.a
 * JD-Core Version:    0.7.0.1
 */