package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ARScanAR
  implements Parcelable
{
  public static final Parcelable.Creator<ARScanAR> CREATOR = new ARScanAR.1();
  public int a;
  public long b;
  public long c;
  public long d;
  public long e;
  public int f;
  public int g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  
  public ARScanAR() {}
  
  public ARScanAR(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ScanAR{");
    localStringBuffer.append("EntryType='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRBegin=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", aREnd=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", userGuideBeginTime=");
    localStringBuffer.append(this.d);
    localStringBuffer.append(", userGuideEndTime=");
    localStringBuffer.append(this.e);
    localStringBuffer.append(", actType=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", userGuideShowCount=");
    localStringBuffer.append(this.g);
    localStringBuffer.append(", scanIconImg='");
    localStringBuffer.append(this.h);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanIconPressed='");
    localStringBuffer.append(this.j);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanIconText='");
    localStringBuffer.append(this.l);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLine1='");
    localStringBuffer.append(this.m);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLine2='");
    localStringBuffer.append(this.n);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLineLink='");
    localStringBuffer.append(this.o);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLinkUrl='");
    localStringBuffer.append(this.p);
    localStringBuffer.append('\'');
    localStringBuffer.append(", what2scanUrl='");
    localStringBuffer.append(this.q);
    localStringBuffer.append('\'');
    localStringBuffer.append(", userGuideWording='");
    localStringBuffer.append(this.r);
    localStringBuffer.append('\'');
    localStringBuffer.append(", userGuideType='");
    localStringBuffer.append(this.s);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
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
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARScanAR
 * JD-Core Version:    0.7.0.1
 */