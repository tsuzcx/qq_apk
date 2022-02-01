package com.tencent.luggage.wxa.lw;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.b;
import java.util.ArrayList;

public class j
  extends b
{
  public static final Parcelable.Creator<j> CREATOR = new j.1();
  public String a;
  public int b;
  public ArrayList<String> c;
  public int d;
  public int e;
  public Runnable f;
  
  public void a()
  {
    Object localObject1;
    if (e.a(a.class) == null) {
      localObject1 = null;
    } else {
      localObject1 = ((a)e.a(a.class)).a();
    }
    if (localObject1 == null)
    {
      e();
      return;
    }
    try
    {
      localObject1 = ((c)localObject1).b(this.b, this.a);
      this.c = ((ArrayList)localObject1[0]);
      this.d = ((int)Math.ceil(((Integer)localObject1[1]).doubleValue() / 1000.0D));
      this.e = ((int)Math.ceil(((Integer)localObject1[2]).doubleValue() / 1000.0D));
      e();
      return;
    }
    finally {}
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.createStringArrayList();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
  }
  
  public void b()
  {
    Runnable localRunnable = this.f;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeStringList(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.j
 * JD-Core Version:    0.7.0.1
 */