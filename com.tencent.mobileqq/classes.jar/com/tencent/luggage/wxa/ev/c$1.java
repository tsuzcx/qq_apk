package com.tencent.luggage.wxa.ev;

import android.content.Context;
import android.content.ContextWrapper;

final class c$1
  extends ContextWrapper
{
  c$1(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public Context getApplicationContext()
  {
    Context localContext2 = super.getApplicationContext();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = this.a;
    }
    return localContext1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.c.1
 * JD-Core Version:    0.7.0.1
 */