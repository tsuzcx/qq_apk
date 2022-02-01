package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.rt.k;

public final class FileUnlink
{
  public static int a(String paramString)
  {
    return unlink(k.c(paramString, true));
  }
  
  public static native int unlink(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.FileUnlink
 * JD-Core Version:    0.7.0.1
 */