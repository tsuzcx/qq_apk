package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecvGVideoLevelInfo
  implements Parcelable, Cloneable, Comparable<RecvGVideoLevelInfo>
{
  public static final Parcelable.Creator<RecvGVideoLevelInfo> CREATOR = new RecvGVideoLevelInfo.1();
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public String j;
  public List<RecvGVideoLevelInfo.Medal> k;
  public long l = 0L;
  
  public RecvGVideoLevelInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString, List<RecvGVideoLevelInfo.Medal> paramList)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
    this.i = paramInt8;
    this.j = paramString;
    this.k = paramList;
  }
  
  public RecvGVideoLevelInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public int a()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return 0;
      }
      int m = 0;
      while (m < this.k.size())
      {
        localObject = (RecvGVideoLevelInfo.Medal)this.k.get(m);
        if (((RecvGVideoLevelInfo.Medal)localObject).c == 1) {
          return ((RecvGVideoLevelInfo.Medal)localObject).b;
        }
        m += 1;
      }
    }
    return 0;
  }
  
  public int a(RecvGVideoLevelInfo paramRecvGVideoLevelInfo)
  {
    int m = a();
    int n = paramRecvGVideoLevelInfo.a();
    if (m != n) {
      return m - n;
    }
    m = this.i;
    n = paramRecvGVideoLevelInfo.i;
    if (m != n) {
      return m - n;
    }
    return 0;
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.a = paramParcel.readLong();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.i = paramParcel.readInt();
      this.j = paramParcel.readString();
      this.k = new ArrayList();
      paramParcel.readTypedList(this.k, RecvGVideoLevelInfo.Medal.CREATOR);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecvGVideoLevelInfo", 2, "readFromParcel RuntimeException", paramParcel);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeLong(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h);
      paramParcel.writeInt(this.i);
      paramParcel.writeString(this.j);
      paramParcel.writeTypedList(this.k);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecvGVideoLevelInfo", 2, "writeToParcel RuntimeException", paramParcel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.RecvGVideoLevelInfo
 * JD-Core Version:    0.7.0.1
 */