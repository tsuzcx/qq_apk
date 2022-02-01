package com.tencent.luggage.wxa.lh;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.b;

class d$b
  extends b
{
  public static final Parcelable.Creator<b> CREATOR = new d.b.1();
  private d a = null;
  private int b;
  private String c;
  
  public d$b(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public d$b(d paramd)
  {
    this.a = paramd;
  }
  
  public void a()
  {
    if (!com.tencent.luggage.wxa.li.d.c())
    {
      this.b = 13000;
      this.c = "not support NFC";
    }
    else if (!com.tencent.luggage.wxa.li.d.b())
    {
      this.b = 13002;
      this.c = "not support HCE";
    }
    else
    {
      this.b = 0;
      this.c = "support HCE and system NFC switch is opened";
    }
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public void b()
  {
    super.b();
    i();
    d locald = this.a;
    if (locald != null) {
      d.a(locald, this.b, this.c);
    }
  }
  
  public int describeContents()
  {
    return super.describeContents();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.d.b
 * JD-Core Version:    0.7.0.1
 */