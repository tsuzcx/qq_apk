package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class i
  implements Parcelable
{
  public static final Parcelable.Creator<i> CREATOR = new i.1();
  private final int a;
  private final int b;
  private final long c;
  
  private i(int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
  }
  
  private i(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.c;
  }
  
  @TargetApi(21)
  ScanSettings c()
  {
    return new ScanSettings.Builder().setReportDelay(b()).setScanMode(a()).build();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.i
 * JD-Core Version:    0.7.0.1
 */