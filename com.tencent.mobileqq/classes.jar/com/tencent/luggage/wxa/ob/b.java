package com.tencent.luggage.wxa.ob;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.ro.d;

public abstract interface b
  extends com.tencent.luggage.wxa.ba.b
{
  public abstract <Resp extends gu> Resp a(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass);
  
  public abstract <Resp extends gu> d<Resp> b(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ob.b
 * JD-Core Version:    0.7.0.1
 */