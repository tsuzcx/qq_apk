package com.tencent.luggage.wxa.ao;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class k
{
  public static final byte[] a = { 0, 0, 0, 1 };
  public static final float[] b = { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
  private static final Object c = new Object();
  private static int[] d = new int[10];
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = c;
    int i = 0;
    int j = 0;
    if (i < paramInt) {}
    for (;;)
    {
      int k;
      try
      {
        k = c(paramArrayOfByte, i, paramInt);
        i = k;
        if (k >= paramInt) {
          break;
        }
        if (d.length <= j) {
          d = Arrays.copyOf(d, d.length * 2);
        }
        d[j] = k;
        i = k + 3;
        j += 1;
      }
      finally
      {
        int n;
        int i1;
        continue;
      }
      if (paramInt < j)
      {
        n = d[paramInt] - i;
        System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, k, n);
        k += n;
        i1 = k + 1;
        paramArrayOfByte[k] = 0;
        k = i1 + 1;
        paramArrayOfByte[i1] = 0;
        i += n + 3;
        paramInt += 1;
      }
      else
      {
        System.arraycopy(paramArrayOfByte, i, paramArrayOfByte, k, m - k);
        return m;
        continue;
        throw paramArrayOfByte;
        continue;
        int m = paramInt - j;
        paramInt = 0;
        k = 0;
        i = 0;
      }
    }
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    int i = paramInt2 - paramInt1;
    boolean bool2 = false;
    boolean bool1;
    if (i >= 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.b(bool1);
    if (i == 0) {
      return paramInt2;
    }
    if (paramArrayOfBoolean != null)
    {
      if (paramArrayOfBoolean[0] != 0)
      {
        a(paramArrayOfBoolean);
        return paramInt1 - 3;
      }
      if ((i > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
      {
        a(paramArrayOfBoolean);
        return paramInt1 - 2;
      }
      if ((i > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
      {
        a(paramArrayOfBoolean);
        return paramInt1 - 1;
      }
    }
    int j = paramInt2 - 1;
    paramInt1 += 2;
    while (paramInt1 < j)
    {
      if ((paramArrayOfByte[paramInt1] & 0xFE) == 0)
      {
        int k = paramInt1 - 2;
        if ((paramArrayOfByte[k] == 0) && (paramArrayOfByte[(paramInt1 - 1)] == 0) && (paramArrayOfByte[paramInt1] == 1))
        {
          if (paramArrayOfBoolean != null) {
            a(paramArrayOfBoolean);
          }
          return k;
        }
        paramInt1 -= 2;
      }
      paramInt1 += 3;
    }
    if (paramArrayOfBoolean != null)
    {
      if (i > 2)
      {
        if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[j] == 1)) {}
      }
      else {
        while (i == 2 ? (paramArrayOfBoolean[2] == 0) || (paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[j] != 1) : (paramArrayOfBoolean[1] == 0) || (paramArrayOfByte[j] != 1))
        {
          bool1 = false;
          break;
        }
      }
      bool1 = true;
      paramArrayOfBoolean[0] = bool1;
      if (i > 1 ? (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[j] == 0) : (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[j] == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramArrayOfBoolean[1] = bool1;
      bool1 = bool2;
      if (paramArrayOfByte[j] == 0) {
        bool1 = true;
      }
      paramArrayOfBoolean[2] = bool1;
    }
    return paramInt2;
  }
  
  public static k.b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void a(n paramn, int paramInt)
  {
    int m = 8;
    int j = 0;
    int k = 8;
    while (j < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (paramn.e() + k + 256) % 256;
      }
      if (i != 0) {
        k = i;
      }
      j += 1;
      m = i;
    }
  }
  
  public static void a(ByteBuffer paramByteBuffer)
  {
    int n = paramByteBuffer.position();
    int k = 0;
    int i = 0;
    for (;;)
    {
      int m = k + 1;
      if (m >= n) {
        break;
      }
      int i1 = paramByteBuffer.get(k) & 0xFF;
      int j;
      if (i == 3)
      {
        j = i;
        if (i1 == 1)
        {
          j = i;
          if ((paramByteBuffer.get(m) & 0x1F) == 7)
          {
            ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
            localByteBuffer.position(k - 3);
            localByteBuffer.limit(n);
            paramByteBuffer.position(0);
            paramByteBuffer.put(localByteBuffer);
          }
        }
      }
      else
      {
        j = i;
        if (i1 == 0) {
          j = i + 1;
        }
      }
      i = j;
      if (i1 != 0) {
        i = 0;
      }
      k = m;
    }
    paramByteBuffer.clear();
  }
  
  public static void a(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static boolean a(String paramString, byte paramByte)
  {
    boolean bool2 = "video/avc".equals(paramString);
    boolean bool1 = true;
    if ((!bool2) || ((paramByte & 0x1F) != 6))
    {
      if (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static k.a b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new n(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.a(8);
    paramInt1 = paramArrayOfByte.d();
    paramInt2 = paramArrayOfByte.d();
    paramArrayOfByte.a();
    return new k.a(paramInt1, paramInt2, paramArrayOfByte.b());
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  private static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2 - 2)
    {
      if ((paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0) && (paramArrayOfByte[(paramInt1 + 2)] == 3)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.k
 * JD-Core Version:    0.7.0.1
 */