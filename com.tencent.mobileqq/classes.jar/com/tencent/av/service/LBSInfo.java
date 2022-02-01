package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class LBSInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LBSInfo> CREATOR = new LBSInfo.1();
  static String a = "LBSInfo";
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  String f = "";
  String g = "";
  String h = "";
  String i = "";
  double j = 0.0D;
  double k = 0.0D;
  double l = 0.0D;
  String[] m = null;
  
  public LBSInfo() {}
  
  public LBSInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public LBSInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, double paramDouble1, double paramDouble2, double paramDouble3, String[] paramArrayOfString)
  {
    this.b = paramString6;
    this.c = paramString5;
    this.d = paramString8;
    this.e = paramString7;
    this.f = paramString2;
    this.g = paramString4;
    this.h = paramString1;
    this.i = paramString3;
    this.j = paramDouble1;
    this.k = paramDouble2;
    this.l = paramDouble3;
    this.m = paramArrayOfString;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.h = paramParcel.readString();
      this.f = paramParcel.readString();
      this.i = paramParcel.readString();
      this.g = paramParcel.readString();
      this.c = paramParcel.readString();
      this.b = paramParcel.readString();
      this.e = paramParcel.readString();
      this.d = paramParcel.readString();
      this.j = paramParcel.readDouble();
      this.k = paramParcel.readDouble();
      this.l = paramParcel.readDouble();
      this.m = paramParcel.createStringArray();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
  }
  
  public String[] a()
  {
    return this.m;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof LBSInfo)) {
        return false;
      }
      paramObject = (LBSInfo)paramObject;
      return (this.h.equals(paramObject.h)) && (this.f.equals(paramObject.f)) && (this.i.equals(paramObject.i)) && (this.g.equals(paramObject.g)) && (this.c.equals(paramObject.c)) && (this.b.equals(paramObject.b)) && (this.e.equals(paramObject.e)) && (this.d.equals(paramObject.d)) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.d);
      paramParcel.writeDouble(this.j);
      paramParcel.writeDouble(this.k);
      paramParcel.writeDouble(this.l);
      paramParcel.writeArray(this.m);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "writeToParcel RuntimeException", paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.LBSInfo
 * JD-Core Version:    0.7.0.1
 */