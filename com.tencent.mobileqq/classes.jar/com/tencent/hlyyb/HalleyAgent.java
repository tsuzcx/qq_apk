package com.tencent.hlyyb;

import android.content.Context;
import com.tencent.hlyyb.common.b.b;
import com.tencent.hlyyb.downloader.Downloader;

public class HalleyAgent
{
  private static volatile boolean a = false;
  private static a b;
  
  private static void a(a parama)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      String str = b.a(parama.a());
      com.tencent.hlyyb.common.a.a(parama.d(), parama.a(), parama.c(), parama.b(), str);
      a = true;
      return;
    }
    finally {}
  }
  
  public static Downloader getDownloader()
  {
    if (a) {
      return com.tencent.hlyyb.downloader.c.a.a();
    }
    throw new RuntimeException("halley not init");
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new a(paramContext, 2900, paramString2, paramString1);
    b = paramContext;
    a(paramContext);
  }
  
  public static void setFileLog(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.HalleyAgent
 * JD-Core Version:    0.7.0.1
 */