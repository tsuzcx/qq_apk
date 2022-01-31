package com.tencent.mobileqq.activity.richmedia.subtitles.resample;

import java.nio.ByteBuffer;

public class Resampler
{
  private static void a(int paramInt1, short[] paramArrayOfShort, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer)
  {
    int i = paramInt3 * 16000 / paramInt1;
    long l1 = 0L;
    long l2 = (paramInt3 - 2 << 16) / (i - 2);
    paramInt1 = 0;
    while (paramInt1 < i - 1)
    {
      long l3 = 0xFFFF & l1;
      int j = paramArrayOfShort[((int)(l1 >> 16) + paramInt2)];
      int k = paramArrayOfShort[((int)(l1 >> 16) + 1 + paramInt2)];
      long l4 = j;
      j = (int)(l3 * k + l4 * (65536L - l3) >> 16);
      paramByteBuffer.put((byte)(j & 0xFF));
      paramByteBuffer.put((byte)((j & 0xFF00) >> 8));
      l1 += l2;
      paramInt1 += 1;
    }
    paramByteBuffer.put((byte)(paramArrayOfShort[(paramInt3 - 1 + paramInt2)] & 0xFF));
    paramByteBuffer.put((byte)((paramArrayOfShort[(paramInt3 - 1 + paramInt2)] & 0xFF00) >> 8));
  }
  
  public static void a(int paramInt1, short[] paramArrayOfShort, int paramInt2, ByteBuffer paramByteBuffer)
  {
    int i = 0;
    int j = paramInt1 * 5 / 100;
    if (paramInt2 <= j) {
      a(paramInt1, paramArrayOfShort, 0, paramInt2, paramByteBuffer);
    }
    int k;
    do
    {
      return;
      k = paramInt2 / j;
      while (i < k)
      {
        a(paramInt1, paramArrayOfShort, i * j, j, paramByteBuffer);
        i += 1;
      }
    } while (paramInt2 - k * j <= 0);
    a(paramInt1, paramArrayOfShort, k * j, paramInt2 - j * k, paramByteBuffer);
  }
  
  public static void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfShort == null) || (paramInt2 <= 0)) {
      return;
    }
    int i = 0;
    label11:
    int j;
    if (i < paramInt2)
    {
      j = paramArrayOfShort[(paramInt1 + i)] * 10;
      if (j < 32767.0F) {
        break label50;
      }
      paramArrayOfShort[(paramInt1 + i)] = 32767;
    }
    for (;;)
    {
      i += 1;
      break label11;
      break;
      label50:
      if (j <= -32768.0F) {
        paramArrayOfShort[(paramInt1 + i)] = -32768;
      } else {
        paramArrayOfShort[(paramInt1 + i)] = ((short)j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.resample.Resampler
 * JD-Core Version:    0.7.0.1
 */