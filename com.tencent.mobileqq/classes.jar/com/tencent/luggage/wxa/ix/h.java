package com.tencent.luggage.wxa.ix;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ra.c;

public abstract class h
  extends c
{
  protected h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
  }
  
  protected void a(String paramString)
  {
    o.e(q(), paramString);
  }
  
  protected void a(String paramString, Object... paramVarArgs)
  {
    o.b(q(), paramString, paramVarArgs);
  }
  
  protected void b(String paramString)
  {
    o.f(q(), paramString);
  }
  
  protected void c(String paramString)
  {
    o.d(q(), paramString);
  }
  
  protected void d(String paramString)
  {
    o.b(q(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.h
 * JD-Core Version:    0.7.0.1
 */