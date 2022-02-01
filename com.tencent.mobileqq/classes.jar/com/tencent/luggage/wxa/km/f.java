package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanFilter.Builder;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class f
  implements Parcelable
{
  public static final Parcelable.Creator<f> CREATOR = new f.1();
  private static final f k = new f.a().a();
  @Nullable
  private final String a;
  @Nullable
  private final String b;
  @Nullable
  private final ParcelUuid c;
  @Nullable
  private final ParcelUuid d;
  @Nullable
  private final ParcelUuid e;
  @Nullable
  private final byte[] f;
  @Nullable
  private final byte[] g;
  private final int h;
  @Nullable
  private final byte[] i;
  @Nullable
  private final byte[] j;
  
  private f(@Nullable String paramString1, @Nullable String paramString2, @Nullable ParcelUuid paramParcelUuid1, @Nullable ParcelUuid paramParcelUuid2, @Nullable ParcelUuid paramParcelUuid3, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, int paramInt, @Nullable byte[] paramArrayOfByte3, @Nullable byte[] paramArrayOfByte4)
  {
    this.a = paramString1;
    this.c = paramParcelUuid1;
    this.d = paramParcelUuid2;
    this.b = paramString2;
    this.e = paramParcelUuid3;
    this.f = paramArrayOfByte1;
    this.g = paramArrayOfByte2;
    this.h = paramInt;
    this.i = paramArrayOfByte3;
    this.j = paramArrayOfByte4;
  }
  
  private boolean a(ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2, List<ParcelUuid> paramList)
  {
    if (paramParcelUuid1 == null) {
      return true;
    }
    if (paramList == null) {
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ParcelUuid localParcelUuid = (ParcelUuid)localIterator.next();
      if (paramParcelUuid2 == null) {
        paramList = null;
      } else {
        paramList = paramParcelUuid2.getUuid();
      }
      if (a(paramParcelUuid1.getUuid(), paramList, localParcelUuid.getUuid())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(UUID paramUUID1, UUID paramUUID2, UUID paramUUID3)
  {
    if (paramUUID2 == null) {
      return paramUUID1.equals(paramUUID3);
    }
    long l1 = paramUUID1.getLeastSignificantBits();
    long l2 = paramUUID2.getLeastSignificantBits();
    long l3 = paramUUID3.getLeastSignificantBits();
    long l4 = paramUUID2.getLeastSignificantBits();
    boolean bool = false;
    if ((l1 & l2) != (l3 & l4)) {
      return false;
    }
    l1 = paramUUID1.getMostSignificantBits();
    l2 = paramUUID2.getMostSignificantBits();
    l3 = paramUUID3.getMostSignificantBits();
    if ((l1 & l2) == (paramUUID2.getMostSignificantBits() & l3)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte3 != null)
    {
      if (paramArrayOfByte3.length < paramArrayOfByte1.length) {
        return false;
      }
      if (paramArrayOfByte2 == null)
      {
        m = 0;
        while (m < paramArrayOfByte1.length)
        {
          if (paramArrayOfByte3[m] != paramArrayOfByte1[m]) {
            return false;
          }
          m += 1;
        }
        return true;
      }
      int m = 0;
      while (m < paramArrayOfByte1.length)
      {
        if ((paramArrayOfByte2[m] & paramArrayOfByte3[m]) != (paramArrayOfByte2[m] & paramArrayOfByte1[m])) {
          return false;
        }
        m += 1;
      }
      return true;
    }
    return false;
  }
  
  @TargetApi(21)
  public ScanFilter a()
  {
    ScanFilter.Builder localBuilder = new ScanFilter.Builder();
    Object localObject = this.a;
    if (localObject != null) {
      localBuilder.setDeviceName((String)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      localBuilder.setServiceUuid((ParcelUuid)localObject, this.d);
    }
    localObject = this.b;
    if (localObject != null) {
      localBuilder.setDeviceAddress((String)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      localBuilder.setServiceData((ParcelUuid)localObject, this.f, this.g);
    }
    int m = this.h;
    if (m < 0) {
      localBuilder.setManufacturerData(m, this.i, this.j);
    }
    return localBuilder.build();
  }
  
  public boolean a(h paramh)
  {
    if (paramh == null) {
      return false;
    }
    Object localObject = paramh.a();
    String str = this.b;
    if ((str != null) && ((localObject == null) || (!str.equals(((BluetoothDevice)localObject).getAddress())))) {
      return false;
    }
    paramh = paramh.b();
    if ((paramh == null) && ((this.a != null) || (this.c != null) || (this.i != null) || (this.f != null) || (this.e != null) || (this.h >= 0))) {
      return false;
    }
    localObject = this.a;
    if ((localObject != null) && (!((String)localObject).equals(paramh.d()))) {
      return false;
    }
    localObject = this.c;
    if ((localObject != null) && (!a((ParcelUuid)localObject, this.d, paramh.a()))) {
      return false;
    }
    localObject = this.e;
    if ((localObject != null) && (!a(this.f, this.g, paramh.a((ParcelUuid)localObject)))) {
      return false;
    }
    int m = this.h;
    return (m < 0) || (paramh == null) || (a(this.i, this.j, paramh.a(m)));
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
      paramObject = (f)paramObject;
      return (d.a(this.a, paramObject.a)) && (d.a(this.b, paramObject.b)) && (this.h == paramObject.h) && (d.b(this.i, paramObject.i)) && (d.b(this.j, paramObject.j)) && (d.b(this.e, paramObject.e)) && (d.b(this.f, paramObject.f)) && (d.b(this.g, paramObject.g)) && (d.a(this.c, paramObject.c)) && (d.a(this.d, paramObject.d));
    }
    return false;
  }
  
  public int hashCode()
  {
    return d.a(new Object[] { this.a, this.b, Integer.valueOf(this.h), this.i, this.j, this.e, this.f, this.g, this.c, this.d });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BluetoothLeScanFilter [mDeviceName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mDeviceAddress=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mUuid=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mUuidMask=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mServiceDataUuid=");
    localStringBuilder.append(d.a(this.e));
    localStringBuilder.append(", mServiceData=");
    localStringBuilder.append(Arrays.toString(this.f));
    localStringBuilder.append(", mServiceDataMask=");
    localStringBuilder.append(Arrays.toString(this.g));
    localStringBuilder.append(", mManufacturerId=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mManufacturerData=");
    localStringBuilder.append(Arrays.toString(this.i));
    localStringBuilder.append(", mManufacturerDataMask=");
    localStringBuilder.append(Arrays.toString(this.j));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.a;
    int n = 0;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = 1;
    }
    paramParcel.writeInt(m);
    localObject = this.a;
    if (localObject != null) {
      paramParcel.writeString((String)localObject);
    }
    if (this.b == null) {
      m = 0;
    } else {
      m = 1;
    }
    paramParcel.writeInt(m);
    localObject = this.b;
    if (localObject != null) {
      paramParcel.writeString((String)localObject);
    }
    if (this.c == null) {
      m = 0;
    } else {
      m = 1;
    }
    paramParcel.writeInt(m);
    localObject = this.c;
    if (localObject != null)
    {
      paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      if (this.d == null) {
        m = 0;
      } else {
        m = 1;
      }
      paramParcel.writeInt(m);
      localObject = this.d;
      if (localObject != null) {
        paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      }
    }
    if (this.e == null) {
      m = 0;
    } else {
      m = 1;
    }
    paramParcel.writeInt(m);
    localObject = this.e;
    if (localObject != null)
    {
      paramParcel.writeParcelable((Parcelable)localObject, paramInt);
      if (this.f == null) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
      localObject = this.f;
      if (localObject != null)
      {
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray(this.f);
        if (this.g == null) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        paramParcel.writeInt(paramInt);
        localObject = this.g;
        if (localObject != null)
        {
          paramParcel.writeInt(localObject.length);
          paramParcel.writeByteArray(this.g);
        }
      }
    }
    paramParcel.writeInt(this.h);
    if (this.i == null) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
    localObject = this.i;
    if (localObject != null)
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray(this.i);
      if (this.j == null) {
        paramInt = n;
      } else {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
      localObject = this.j;
      if (localObject != null)
      {
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray(this.j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.f
 * JD-Core Version:    0.7.0.1
 */