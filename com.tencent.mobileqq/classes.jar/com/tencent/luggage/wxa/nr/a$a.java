package com.tencent.luggage.wxa.nr;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class a$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new a.a.1();
  private String a = null;
  private boolean b = false;
  
  a$a() {}
  
  a$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a()
  {
    this.b = b.b().d(this.a);
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeByte((byte)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nr.a.a
 * JD-Core Version:    0.7.0.1
 */