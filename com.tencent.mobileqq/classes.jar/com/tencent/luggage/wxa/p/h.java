package com.tencent.luggage.wxa.p;

import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.ao.m;
import java.util.UUID;

public final class h
{
  public static UUID a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return null;
    }
    return (UUID)paramArrayOfByte.first;
  }
  
  private static Pair<UUID, byte[]> b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new m(paramArrayOfByte);
    if (paramArrayOfByte.c() < 32) {
      return null;
    }
    paramArrayOfByte.c(0);
    if (paramArrayOfByte.n() != paramArrayOfByte.b() + 4) {
      return null;
    }
    if (paramArrayOfByte.n() != a.U) {
      return null;
    }
    int i = a.a(paramArrayOfByte.n());
    if (i > 1)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unsupported pssh version: ");
      paramArrayOfByte.append(i);
      Log.w("PsshAtomUtil", paramArrayOfByte.toString());
      return null;
    }
    UUID localUUID = new UUID(paramArrayOfByte.p(), paramArrayOfByte.p());
    if (i == 1) {
      paramArrayOfByte.d(paramArrayOfByte.t() * 16);
    }
    i = paramArrayOfByte.t();
    if (i != paramArrayOfByte.b()) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    paramArrayOfByte.a(arrayOfByte, 0, i);
    return Pair.create(localUUID, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.h
 * JD-Core Version:    0.7.0.1
 */