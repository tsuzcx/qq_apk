package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public class h
  implements Parcelable
{
  public static final Parcelable.Creator<h> CREATOR = new h.1();
  private BluetoothDevice a;
  @Nullable
  private g b;
  private int c;
  private long d;
  
  public h(BluetoothDevice paramBluetoothDevice, @Nullable g paramg, int paramInt, long paramLong)
  {
    this.a = paramBluetoothDevice;
    this.b = paramg;
    this.c = paramInt;
    this.d = paramLong;
  }
  
  @TargetApi(21)
  h(ScanResult paramScanResult)
  {
    this.a = paramScanResult.getDevice();
    this.b = new g(paramScanResult.getScanRecord());
    this.c = paramScanResult.getRssi();
    this.d = System.currentTimeMillis();
  }
  
  private h(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  private void a(Parcel paramParcel)
  {
    if (paramParcel.readInt() == 1) {
      this.a = ((BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(paramParcel));
    }
    if (paramParcel.readInt() == 1) {
      this.b = g.a(paramParcel.createByteArray());
    }
    this.c = paramParcel.readInt();
    this.d = paramParcel.readLong();
  }
  
  public BluetoothDevice a()
  {
    BluetoothDevice localBluetoothDevice = this.a;
    if (localBluetoothDevice != null) {
      return localBluetoothDevice;
    }
    return null;
  }
  
  @Nullable
  public g b()
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
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (h)paramObject;
      return (d.a(this.a, paramObject.a)) && (this.c == paramObject.c) && (d.a(this.b, paramObject.b)) && (this.d == paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return d.a(new Object[] { this.a, Integer.valueOf(this.c), this.b, Long.valueOf(this.d) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScanResult{mDevice=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mScanRecord=");
    localStringBuilder.append(d.a(this.b));
    localStringBuilder.append(", mRssi=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mTimestampNanos=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.a != null)
    {
      paramParcel.writeInt(1);
      this.a.writeToParcel(paramParcel, paramInt);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    if (this.b != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeByteArray(this.b.e());
    }
    else
    {
      paramParcel.writeInt(0);
    }
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.h
 * JD-Core Version:    0.7.0.1
 */