package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class c
{
  static final int a;
  private static final Method b;
  
  static
  {
    try
    {
      a = ((Integer)Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
      b = Canvas.class.getMethod("save", new Class[] { Integer.TYPE });
      return;
    }
    catch (Throwable localThrowable)
    {
      throw a(localThrowable);
    }
  }
  
  private static RuntimeException a(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      return (RuntimeException)b(paramThrowable);
    }
    throw new NullPointerException("t");
  }
  
  static void a(Canvas paramCanvas, int paramInt)
  {
    try
    {
      b.invoke(paramCanvas, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Throwable paramCanvas)
    {
      throw a(paramCanvas);
    }
  }
  
  private static <T extends Throwable> T b(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.c
 * JD-Core Version:    0.7.0.1
 */