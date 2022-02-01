package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class RecvGVideoLevelInfo$Medal
  implements Parcelable
{
  public static final Parcelable.Creator<Medal> CREATOR = new RecvGVideoLevelInfo.Medal.1();
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  
  public RecvGVideoLevelInfo$Medal(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public RecvGVideoLevelInfo$Medal(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
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
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.c);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.e);
      paramParcel.writeString(this.f);
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
 * Qualified Name:     com.tencent.av.service.RecvGVideoLevelInfo.Medal
 * JD-Core Version:    0.7.0.1
 */