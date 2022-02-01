package com.tencent.luggage.wxa.an;

import android.net.Uri;
import com.tencent.luggage.wxa.am.j;

public final class h
{
  public static String a(Uri paramUri)
  {
    return paramUri.toString();
  }
  
  public static String a(j paramj)
  {
    if (paramj.f != null) {
      return paramj.f;
    }
    return a(paramj.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.h
 * JD-Core Version:    0.7.0.1
 */