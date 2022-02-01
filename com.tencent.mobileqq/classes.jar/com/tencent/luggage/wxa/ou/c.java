package com.tencent.luggage.wxa.ou;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class c
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public String h;
  public int i;
  public float j;
  public float k;
  public long l;
  
  public c() {}
  
  public c(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readFloat();
    this.k = paramParcel.readFloat();
    this.l = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandRecommendStatObj{username=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", recommend_id='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", strategy_info=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appid='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", page_path=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", page_param=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", card_type=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", pass_str=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", sessionId=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeFloat(this.j);
    paramParcel.writeFloat(this.k);
    paramParcel.writeLong(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.c
 * JD-Core Version:    0.7.0.1
 */