package com.tencent.luggage.wxa.h;

import java.io.IOException;

public final class e
  extends Exception
{
  public final int a;
  public final int b;
  
  private e(int paramInt1, String paramString, Throwable paramThrowable, int paramInt2)
  {
    super(paramString, paramThrowable);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static e a(IOException paramIOException)
  {
    return new e(0, null, paramIOException, -1);
  }
  
  public static e a(Exception paramException, int paramInt)
  {
    return new e(1, null, paramException, paramInt);
  }
  
  static e a(RuntimeException paramRuntimeException)
  {
    return new e(2, null, paramRuntimeException, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.e
 * JD-Core Version:    0.7.0.1
 */