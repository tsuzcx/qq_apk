package com.tencent.luggage.wxa.km;

import android.bluetooth.BluetoothAdapter;
import android.os.ParcelUuid;

public final class f$a
{
  private String a;
  private String b;
  private ParcelUuid c;
  private ParcelUuid d;
  private ParcelUuid e;
  private byte[] f;
  private byte[] g;
  private int h = -1;
  private byte[] i;
  private byte[] j;
  
  public a a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramInt < 0)) {
      throw new IllegalArgumentException("invalid manufacture id");
    }
    this.h = paramInt;
    this.i = paramArrayOfByte;
    this.j = null;
    return this;
  }
  
  public a a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramInt < 0)) {
      throw new IllegalArgumentException("invalid manufacture id");
    }
    byte[] arrayOfByte1 = this.j;
    if (arrayOfByte1 != null)
    {
      byte[] arrayOfByte2 = this.i;
      if (arrayOfByte2 != null)
      {
        if (arrayOfByte2.length != arrayOfByte1.length) {
          throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
        }
      }
      else {
        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
      }
    }
    this.h = paramInt;
    this.i = paramArrayOfByte1;
    this.j = paramArrayOfByte2;
    return this;
  }
  
  public a a(ParcelUuid paramParcelUuid)
  {
    this.c = paramParcelUuid;
    this.d = null;
    return this;
  }
  
  public a a(ParcelUuid paramParcelUuid1, ParcelUuid paramParcelUuid2)
  {
    if ((this.d != null) && (this.c == null)) {
      throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
    }
    this.c = paramParcelUuid1;
    this.d = paramParcelUuid2;
    return this;
  }
  
  public a a(ParcelUuid paramParcelUuid, byte[] paramArrayOfByte)
  {
    if (paramParcelUuid != null)
    {
      this.e = paramParcelUuid;
      this.f = paramArrayOfByte;
      this.g = null;
      return this;
    }
    throw new IllegalArgumentException("serviceDataUuid is null");
  }
  
  public a a(ParcelUuid paramParcelUuid, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramParcelUuid != null)
    {
      byte[] arrayOfByte1 = this.g;
      if (arrayOfByte1 != null)
      {
        byte[] arrayOfByte2 = this.f;
        if (arrayOfByte2 != null)
        {
          if (arrayOfByte2.length != arrayOfByte1.length) {
            throw new IllegalArgumentException("size mismatch for service data and service data mask");
          }
        }
        else {
          throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
        }
      }
      this.e = paramParcelUuid;
      this.f = paramArrayOfByte1;
      this.g = paramArrayOfByte2;
      return this;
    }
    throw new IllegalArgumentException("serviceDataUuid is null");
  }
  
  public a a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public f a()
  {
    return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
  }
  
  public a b(String paramString)
  {
    if ((paramString != null) && (!BluetoothAdapter.checkBluetoothAddress(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid device address ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.f.a
 * JD-Core Version:    0.7.0.1
 */