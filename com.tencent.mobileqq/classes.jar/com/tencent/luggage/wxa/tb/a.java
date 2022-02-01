package com.tencent.luggage.wxa.tb;

import com.tencent.luggage.wxa.qu.b;
import java.io.UnsupportedEncodingException;

public final class a
{
  private final byte[] a;
  private final int b;
  private int c;
  
  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  public static int a(int paramInt)
  {
    return c(com.tencent.luggage.wxa.sz.a.a(paramInt, 0));
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void a(byte paramByte)
  {
    byte[] arrayOfByte = this.a;
    int i = this.c;
    this.c = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return a(paramInt) + 8;
  }
  
  public static int b(int paramInt, float paramFloat)
  {
    return a(paramInt) + 4;
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return a(paramInt) + b(paramLong);
  }
  
  public static int b(int paramInt, b paramb)
  {
    if (paramb == null) {
      return 0;
    }
    return a(paramInt) + c(paramb.a()) + paramb.a();
  }
  
  public static int b(int paramInt, String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramInt = a(paramInt);
      int i = c(paramString.length);
      int j = paramString.length;
      return paramInt + i + j;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label33:
      break label33;
    }
    throw new IllegalStateException("UTF-8 not supported.");
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return a(paramInt) + 1;
  }
  
  public static int b(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x0) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i = this.b;
    int j = this.c;
    if (i - j >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.a, j, paramInt2);
      this.c += paramInt2;
      return;
    }
    i -= j;
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, j, i);
    paramInt2 -= i;
    j = this.b;
    this.c = j;
    if (paramInt2 <= j)
    {
      System.arraycopy(paramArrayOfByte, paramInt1 + i, this.a, 0, paramInt2);
      this.c = paramInt2;
    }
  }
  
  public static int c(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      return a(paramInt1) + c(paramInt2);
    }
    return a(paramInt1) + 10;
  }
  
  private void c(long paramLong)
  {
    d((int)paramLong & 0xFF);
    d((int)(paramLong >> 8) & 0xFF);
    d((int)(paramLong >> 16) & 0xFF);
    d((int)(paramLong >> 24) & 0xFF);
    d((int)(paramLong >> 32) & 0xFF);
    d((int)(paramLong >> 40) & 0xFF);
    d((int)(paramLong >> 48) & 0xFF);
    d((int)(paramLong >> 56) & 0xFF);
  }
  
  private void d(int paramInt)
  {
    a((byte)paramInt);
  }
  
  private void e(int paramInt)
  {
    d(paramInt & 0xFF);
    d(paramInt >> 8 & 0xFF);
    d(paramInt >> 16 & 0xFF);
    d(paramInt >> 24 & 0xFF);
  }
  
  public void a(int paramInt, double paramDouble)
  {
    d(paramInt, 1);
    c(Double.doubleToLongBits(paramDouble));
  }
  
  public void a(int paramInt, float paramFloat)
  {
    d(paramInt, 5);
    e(Float.floatToIntBits(paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    d(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      b(paramInt2);
      return;
    }
    a(paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    d(paramInt, 0);
    a(paramLong);
  }
  
  public void a(int paramInt, b paramb)
  {
    if (paramb == null) {
      return;
    }
    d(paramInt, 2);
    paramb = paramb.b();
    b(paramb.length);
    b(paramb);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    d(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    b(paramString.length);
    b(paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        d((int)paramLong);
        return;
      }
      d((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        d(paramInt);
        return;
      }
      d(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    d(paramInt1, 2);
    b(paramInt2);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    b(com.tencent.luggage.wxa.sz.a.a(paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.tb.a
 * JD-Core Version:    0.7.0.1
 */