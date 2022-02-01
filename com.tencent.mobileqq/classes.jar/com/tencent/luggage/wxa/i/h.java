package com.tencent.luggage.wxa.i;

import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.k.a;
import java.nio.ByteBuffer;

public final class h
{
  private static final int[] a = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] b = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] c = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };
  
  public static int a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.get(i + 4);
    return (((paramByteBuffer.get(i + 5) & 0xFC) >> 2 | (j & 0x1) << 6) + 1) * 32;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[4];
    return (((paramArrayOfByte[5] & 0xFC) >> 2 | (i & 0x1) << 6) + 1) * 32;
  }
  
  public static k a(byte[] paramArrayOfByte, String paramString1, String paramString2, a parama)
  {
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.b(60);
    int i = paramArrayOfByte.c(6);
    int k = a[i];
    i = paramArrayOfByte.c(4);
    int m = b[i];
    i = paramArrayOfByte.c(5);
    int[] arrayOfInt = c;
    if (i >= arrayOfInt.length) {
      i = -1;
    } else {
      i = arrayOfInt[i] * 1000 / 2;
    }
    paramArrayOfByte.b(10);
    int j;
    if (paramArrayOfByte.c(2) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    return k.a(paramString1, "audio/vnd.dts", null, i, -1, k + j, m, null, parama, 0, paramString2);
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[5];
    int j = paramArrayOfByte[6];
    return ((paramArrayOfByte[7] & 0xF0) >> 4 | (i & 0x2) << 12 | (j & 0xFF) << 4) + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.h
 * JD-Core Version:    0.7.0.1
 */