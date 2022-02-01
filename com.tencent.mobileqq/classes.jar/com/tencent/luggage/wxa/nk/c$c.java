package com.tencent.luggage.wxa.nk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class c$c
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new c.c.1();
  public long a;
  public String b;
  public String c;
  public boolean d;
  public String e;
  public String f;
  public long g = -1L;
  
  public c$c() {}
  
  public c$c(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readLong();
  }
  
  public boolean a()
  {
    return "Start".equals(this.c);
  }
  
  public boolean b()
  {
    return "END".equals(this.c);
  }
  
  public boolean c()
  {
    return "CollectKeyInfo".equals(this.c);
  }
  
  public boolean d()
  {
    return "stepStart".equals(this.e);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeLong(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nk.c.c
 * JD-Core Version:    0.7.0.1
 */