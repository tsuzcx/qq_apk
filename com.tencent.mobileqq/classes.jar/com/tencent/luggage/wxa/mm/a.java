package com.tencent.luggage.wxa.mm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mk.c;

public class a
  extends com.tencent.luggage.wxa.ml.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected b a()
  {
    return new c(new Handler(Looper.getMainLooper()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mm.a
 * JD-Core Version:    0.7.0.1
 */