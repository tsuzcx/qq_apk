package com.tencent.luggage.wxa.ou;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class d
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public int a;
  public String b;
  public int c;
  public String d;
  public int e;
  public int f;
  public String g;
  public String h;
  public c i;
  public Bundle j;
  public transient int k;
  
  public d() {}
  
  protected d(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.i = ((c)paramParcel.readParcelable(c.class.getClassLoader()));
    this.h = paramParcel.readString();
    this.j = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandStatObject{preScene=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", preSceneNote='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sceneNote='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", usedState=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeParcelable(this.i, paramInt);
    paramParcel.writeString(this.h);
    paramParcel.writeBundle(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.d
 * JD-Core Version:    0.7.0.1
 */