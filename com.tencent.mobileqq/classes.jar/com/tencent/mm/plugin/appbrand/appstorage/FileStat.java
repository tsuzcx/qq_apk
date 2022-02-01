package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.rt.k;

public class FileStat
{
  public static int a(String paramString, @NonNull FileStructStat paramFileStructStat)
  {
    return stat(k.c(paramString, false), paramFileStructStat);
  }
  
  public static native int stat(String paramString, @NonNull FileStructStat paramFileStructStat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.FileStat
 * JD-Core Version:    0.7.0.1
 */