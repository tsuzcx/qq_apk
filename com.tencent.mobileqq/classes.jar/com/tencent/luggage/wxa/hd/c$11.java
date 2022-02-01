package com.tencent.luggage.wxa.hd;

import android.content.Context;
import android.provider.Settings.Secure;
import com.tencent.luggage.wxa.qz.r;

final class c$11
  extends c.b
{
  c$11(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    return Settings.Secure.getString(r.a().getContentResolver(), "android_id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.11
 * JD-Core Version:    0.7.0.1
 */