package com.tencent.device.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;

public class LightAppSettingInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<LightAppSettingInfo> CREATOR = new LightAppSettingInfo.1();
  public int a;
  public int b;
  public int c;
  public long d;
  public ArrayList<Integer> e;
  public String f;
  public String g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public int n;
  public HashMap<Integer, String> o;
  public String p;
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int hashCode()
  {
    long l1 = this.d;
    if (l1 != 0L) {
      return Long.valueOf(l1).hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeMap(this.o);
    paramParcel.writeString(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.LightAppSettingInfo
 * JD-Core Version:    0.7.0.1
 */