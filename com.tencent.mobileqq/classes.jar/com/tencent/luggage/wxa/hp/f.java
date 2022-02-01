package com.tencent.luggage.wxa.hp;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hj.h;

public class f
{
  public static <T extends c<InputType, ResultType>, InputType, ResultType> void a(String paramString, InputType paramInputType, @NonNull Class<T> paramClass, e<ResultType> parame)
  {
    h.a(paramString, new f.c(paramClass.getName(), paramInputType), f.a.class, new f.1(parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.f
 * JD-Core Version:    0.7.0.1
 */