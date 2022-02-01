package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new RecvMsg.1();
  static String a = "RecvMsg";
  int b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  public int i;
  public int j;
  public int k;
  public long l;
  public int m;
  public int n;
  public boolean o = false;
  
  public RecvMsg()
  {
    this.b = 0;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.c = null;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0L;
    this.h = "";
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.b = paramParcel.readInt();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      this.c = paramParcel.readString();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readInt();
      this.k = paramParcel.readInt();
      this.l = paramParcel.readLong();
      this.h = paramParcel.readString();
      this.m = paramParcel.readInt();
      this.n = paramParcel.readInt();
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
  }
  
  public String b()
  {
    return this.g;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(", mVipBubbleId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mAccountUin:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mFriendUin:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mSenderUin:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mSenderName:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mMsg:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", msgType:");
    localStringBuilder.append(this.m);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.b);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.c);
      paramParcel.writeInt(this.i);
      paramParcel.writeInt(this.j);
      paramParcel.writeInt(this.k);
      paramParcel.writeLong(this.l);
      paramParcel.writeString(this.h);
      paramParcel.writeInt(this.m);
      paramParcel.writeInt(this.n);
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
 * Qualified Name:     com.tencent.av.service.RecvMsg
 * JD-Core Version:    0.7.0.1
 */