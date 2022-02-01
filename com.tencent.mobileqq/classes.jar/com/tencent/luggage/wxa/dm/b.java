package com.tencent.luggage.wxa.dm;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.bb.a.c;
import com.tencent.luggage.wxa.du.b.b;
import com.tencent.luggage.wxa.du.i;
import com.tencent.luggage.wxa.qz.o;

public class b
  extends c
{
  protected void a()
  {
    o.d("Luggage.FullSdkLuggageInitDelegate", "hy: trigger registerServiceLogicImp");
    com.tencent.luggage.wxa.du.d.a().a(new b.b(), com.tencent.luggage.wxa.du.b.class);
    com.tencent.luggage.wxa.du.d.a().a(i.a, i.class);
  }
  
  public void a(@NonNull a.c paramc)
  {
    com.tencent.luggage.wxa.ef.d.a("NanoSdkLuggageInitDelegate", new b.1(this, paramc));
    com.tencent.luggage.wxa.ef.d.a("FullSdkLuggageInitDelegate", new b.2(this, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dm.b
 * JD-Core Version:    0.7.0.1
 */