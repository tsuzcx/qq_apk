package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import java.util.LinkedHashMap;

public final class oi
{
  private static LinkedHashMap<String, oi.a> a = new LinkedHashMap();
  
  public static Bitmap a(String paramString)
  {
    try
    {
      LinkedHashMap localLinkedHashMap = a;
      if (localLinkedHashMap == null) {
        return null;
      }
      paramString = (oi.a)a.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.b;
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      if (a != null) {
        a.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      if (a == null) {
        a = new LinkedHashMap();
      }
      if (a.containsKey(paramString))
      {
        paramString = (oi.a)a.get(paramString);
        paramString.a += 1;
        return;
      }
      oi.a locala = new oi.a();
      locala.b = paramBitmap;
      locala.a = 1;
      a.put(paramString, locala);
      return;
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    try
    {
      Object localObject = a;
      if (localObject == null) {
        return;
      }
      localObject = (oi.a)a.get(paramString);
      if (localObject != null)
      {
        ((oi.a)localObject).a -= 1;
        if (((oi.a)localObject).a <= 0)
        {
          a.remove(paramString);
          if (Build.VERSION.SDK_INT <= 10)
          {
            paramString = ((oi.a)localObject).b;
            if ((paramString != null) && (!paramString.isRecycled())) {
              paramString.recycle();
            }
          }
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.oi
 * JD-Core Version:    0.7.0.1
 */