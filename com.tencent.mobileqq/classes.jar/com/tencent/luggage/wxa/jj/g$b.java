package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class g$b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new g.b.1();
  public int a = 0;
  public ArrayList<String> b;
  public ArrayList<String> c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  
  public g$b() {}
  
  g$b(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.createStringArrayList();
    this.c = paramParcel.createStringArrayList();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeStringList(this.b);
    paramParcel.writeStringList(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.g.b
 * JD-Core Version:    0.7.0.1
 */