package com.tencent.map.sdk.a;

import java.security.MessageDigest;

public final class oy
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final ot<String, String> b = new ot(1000);
  private final ow.f<ow.h<MessageDigest>> c = ow.a(10, new oy.1(this));
  
  public final String a(String paramString)
  {
    synchronized (this.b)
    {
      ??? = (String)this.b.b(paramString);
      ??? = ???;
      if (??? == null)
      {
        ??? = (ow.h)this.c.a();
        try
        {
          ((MessageDigest)((ow.h)???).a).update(paramString.getBytes());
          ??? = ((MessageDigest)((ow.h)???).a).digest();
          if ((??? != null) && (???.length != 0))
          {
            char[] arrayOfChar = new char[???.length * 2];
            int i = 0;
            while (i < ???.length)
            {
              int k = ???[i];
              int j = i * 2;
              arrayOfChar[(j + 1)] = a[(k & 0xF)];
              k = (byte)(k >>> 4);
              arrayOfChar[(j + 0)] = a[(k & 0xF)];
              i += 1;
            }
            ??? = new String(arrayOfChar);
          }
          else
          {
            ??? = null;
          }
        }
        finally
        {
          this.c.a(???);
        }
      }
      synchronized (this.b)
      {
        this.b.a(paramString, ???);
        return ???;
      }
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.oy
 * JD-Core Version:    0.7.0.1
 */