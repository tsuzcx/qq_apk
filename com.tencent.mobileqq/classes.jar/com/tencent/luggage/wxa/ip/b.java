package com.tencent.luggage.wxa.ip;

import android.content.Context;
import com.tencent.luggage.wxa.iq.a;
import com.tencent.luggage.wxa.ir.e;
import com.tencent.luggage.wxa.ir.f;
import com.tencent.luggage.wxa.it.c;
import java.util.Calendar;

public class b
{
  private a a = new a(2);
  
  public b(Context paramContext, f paramf)
  {
    a locala = this.a;
    locala.E = paramContext;
    locala.b = paramf;
  }
  
  public b a(int paramInt)
  {
    this.a.P = paramInt;
    return this;
  }
  
  public b a(e parame)
  {
    this.a.c = parame;
    return this;
  }
  
  public b a(Calendar paramCalendar)
  {
    this.a.k = paramCalendar;
    return this;
  }
  
  public b a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    a locala = this.a;
    locala.l = paramCalendar1;
    locala.m = paramCalendar2;
    return this;
  }
  
  public b a(boolean paramBoolean)
  {
    this.a.h = paramBoolean;
    return this;
  }
  
  public b a(boolean[] paramArrayOfBoolean)
  {
    this.a.j = paramArrayOfBoolean;
    return this;
  }
  
  public void a(c paramc)
  {
    paramc.a(this.a);
  }
  
  public b b(int paramInt)
  {
    this.a.X = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ip.b
 * JD-Core Version:    0.7.0.1
 */