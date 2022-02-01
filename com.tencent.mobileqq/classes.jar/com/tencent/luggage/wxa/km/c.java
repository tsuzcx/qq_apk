package com.tencent.luggage.wxa.km;

import android.os.ParcelUuid;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

class c
{
  public static final ParcelUuid a = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid b = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid c = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid d = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid e = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid f = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid g = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid h = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid i = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid j = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid k = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid l = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
  public static final ParcelUuid m = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid n = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid o = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid p = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid q = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid r = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid s = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid t = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
  public static final ParcelUuid[] u = { a, b, c, d, f, h, i, j, m, n, q, r, s };
  
  public static ParcelUuid a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i1 = paramArrayOfByte.length;
      if ((i1 != 2) && (i1 != 4) && (i1 != 16))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("uuidBytes length invalid - ");
        paramArrayOfByte.append(i1);
        throw new IllegalArgumentException(paramArrayOfByte.toString());
      }
      if (i1 == 16)
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        return new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
      }
      long l1;
      if (i1 == 2)
      {
        l1 = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
      }
      else
      {
        l1 = paramArrayOfByte[0] & 0xFF;
        long l2 = (paramArrayOfByte[1] & 0xFF) << 8;
        long l3 = (paramArrayOfByte[2] & 0xFF) << 16;
        l1 = ((paramArrayOfByte[3] & 0xFF) << 24) + (l1 + l2 + l3);
      }
      return new ParcelUuid(new UUID(t.getUuid().getMostSignificantBits() + (l1 << 32), t.getUuid().getLeastSignificantBits()));
    }
    throw new IllegalArgumentException("uuidBytes cannot be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.c
 * JD-Core Version:    0.7.0.1
 */