package com.tencent.luggage.wxa.iw;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class b
  implements a
{
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramArrayOfByte == null) {
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    if (paramInt2 == 4) {
      return paramArrayOfByte.getInt();
    }
    byte[] arrayOfByte = new byte[paramInt2];
    paramArrayOfByte.get(arrayOfByte);
    int i = 0;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      i |= arrayOfByte[paramInt1] << (paramInt2 - paramInt1 - 1) * 8;
      paramInt1 += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iw.b
 * JD-Core Version:    0.7.0.1
 */