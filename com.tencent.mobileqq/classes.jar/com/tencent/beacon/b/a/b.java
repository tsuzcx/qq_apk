package com.tencent.beacon.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.beacon.a.c.c;
import java.nio.charset.Charset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class b
{
  private static b a;
  private static byte[] b = { 33, 94, 120, 74, 111, 43, 35 };
  private SharedPreferences c;
  private SharedPreferences.Editor d;
  private Lock e = new ReentrantLock();
  private Runnable f = new a(this);
  
  public b()
  {
    Context localContext = c.d().c();
    if (localContext != null) {
      this.c = localContext.getSharedPreferences("DENGTA_META", 0);
    }
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    paramString = Base64.decode(paramString, 2);
    int i = 0;
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return new String(paramString, Charset.defaultCharset());
  }
  
  private static String b(String paramString)
  {
    paramString = paramString.getBytes(Charset.defaultCharset());
    int i = 0;
    int j = 0;
    while (i < paramString.length)
    {
      int k = paramString[i];
      byte[] arrayOfByte = b;
      paramString[i] = ((byte)(k ^ arrayOfByte[j]));
      j = (j + 1) % arrayOfByte.length;
      i += 1;
    }
    return Base64.encodeToString(paramString, 2);
  }
  
  private void b()
  {
    try
    {
      if (this.e.tryLock())
      {
        this.d.commit();
        this.e.unlock();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.c.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.c;
      String str = localSharedPreferences.getString(paramString1, "");
      if ((str != null) && (!str.trim().equals("")))
      {
        paramString3 = b(str);
        localSharedPreferences.edit().remove(paramString1).putString(paramString2, paramString3).commit();
        return str;
      }
      paramString1 = localSharedPreferences.getString(paramString2, "");
      if ((paramString1 != null) && (!paramString1.trim().equals("")))
      {
        paramString1 = a(paramString1);
        return paramString1;
      }
      return paramString3;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.b.a.b
 * JD-Core Version:    0.7.0.1
 */