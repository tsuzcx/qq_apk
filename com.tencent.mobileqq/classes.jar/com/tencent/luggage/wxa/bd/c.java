package com.tencent.luggage.wxa.bd;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;

public class c
  extends a
{
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    return null;
  }
  
  public String a()
  {
    return "NetworkImageReader";
  }
  
  public void a(String paramString, a.c paramc) {}
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = paramString.toLowerCase();
      if (!paramString.startsWith("http://"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("https://")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bd.c
 * JD-Core Version:    0.7.0.1
 */