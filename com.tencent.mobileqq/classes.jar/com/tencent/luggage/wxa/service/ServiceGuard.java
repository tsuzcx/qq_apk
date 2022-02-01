package com.tencent.luggage.wxa.service;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.fq.a;

public class ServiceGuard
{
  @Keep
  public static void guard(Context paramContext)
  {
    a.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.service.ServiceGuard
 * JD-Core Version:    0.7.0.1
 */