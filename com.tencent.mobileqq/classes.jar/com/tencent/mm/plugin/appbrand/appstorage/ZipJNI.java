package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.rt.k;

public class ZipJNI
{
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return unzip(k.c(paramString1, false), k.c(paramString2, true), paramString3);
  }
  
  public static native int unzip(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ZipJNI
 * JD-Core Version:    0.7.0.1
 */