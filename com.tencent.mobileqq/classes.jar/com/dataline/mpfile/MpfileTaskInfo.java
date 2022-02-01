package com.dataline.mpfile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MpfileTaskInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MpfileTaskInfo> CREATOR = new MpfileTaskInfo.1();
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public int f;
  public int g = 0;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t = System.currentTimeMillis();
  public long u = 0L;
  public long v;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeLong(this.p);
    paramParcel.writeLong(this.q);
    paramParcel.writeLong(this.r);
    paramParcel.writeLong(this.s);
    paramParcel.writeLong(this.t);
    paramParcel.writeLong(this.u);
    paramParcel.writeLong(this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskInfo
 * JD-Core Version:    0.7.0.1
 */