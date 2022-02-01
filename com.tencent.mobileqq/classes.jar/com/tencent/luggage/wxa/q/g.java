package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class g
  extends h
{
  private static final int a = x.f("Opus");
  private static final byte[] b = { 79, 112, 117, 115, 72, 101, 97, 100 };
  private boolean c;
  
  private long a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte[0] & 0xFF;
    int m = k & 0x3;
    int i = 2;
    int j;
    if (m != 0)
    {
      j = i;
      if (m != 1)
      {
        j = i;
        if (m != 2) {
          j = paramArrayOfByte[1] & 0x3F;
        }
      }
    }
    else
    {
      j = 1;
    }
    i = k >> 3;
    k = i & 0x3;
    if (i >= 16) {
      i = 2500 << k;
    } else if (i >= 12) {
      i = 10000 << (k & 0x1);
    } else if (k == 3) {
      i = 60000;
    } else {
      i = 10000 << k;
    }
    return j * i;
  }
  
  private void a(List<byte[]> paramList, int paramInt)
  {
    long l = paramInt * 1000000000L / 48000L;
    paramList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array());
  }
  
  public static boolean a(m paramm)
  {
    int i = paramm.b();
    byte[] arrayOfByte1 = b;
    if (i < arrayOfByte1.length) {
      return false;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    paramm.a(arrayOfByte2, 0, arrayOfByte1.length);
    return Arrays.equals(arrayOfByte2, b);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      this.c = false;
    }
  }
  
  protected boolean a(m paramm, long paramLong, h.a parama)
  {
    boolean bool2 = this.c;
    boolean bool1 = true;
    if (!bool2)
    {
      paramm = Arrays.copyOf(paramm.a, paramm.c());
      int i = paramm[9];
      int j = paramm[11];
      int k = paramm[10];
      ArrayList localArrayList = new ArrayList(3);
      localArrayList.add(paramm);
      a(localArrayList, (j & 0xFF) << 8 | k & 0xFF);
      a(localArrayList, 3840);
      parama.a = k.a(null, "audio/opus", null, -1, -1, i & 0xFF, 48000, localArrayList, null, 0, null);
      this.c = true;
      return true;
    }
    if (paramm.n() != a) {
      bool1 = false;
    }
    paramm.c(0);
    return bool1;
  }
  
  protected long b(m paramm)
  {
    return b(a(paramm.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.g
 * JD-Core Version:    0.7.0.1
 */