package com.tencent.biz.pubaccount.readinjoy.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import pks;

public class AladdinConfigServlet$ConfigResult
  implements Parcelable
{
  public static final Parcelable.Creator<ConfigResult> CREATOR = new pks();
  private final int a;
  private final int b;
  private final int c;
  
  AladdinConfigServlet$ConfigResult(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public AladdinConfigServlet$ConfigResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ConfigResult{id=" + this.a + ", version=" + this.b + ", retCode=" + this.c + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet.ConfigResult
 * JD-Core Version:    0.7.0.1
 */