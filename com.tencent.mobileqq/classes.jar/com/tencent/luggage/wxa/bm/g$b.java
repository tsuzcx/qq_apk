package com.tencent.luggage.wxa.bm;

import com.tencent.luggage.wxa.rc.d;
import java.io.InputStream;

public abstract class g$b
{
  public static String b = "WAGameVConsole.html";
  
  public abstract void a();
  
  public abstract boolean a(String paramString);
  
  public abstract InputStream b(String paramString);
  
  public g.b.a c(String paramString)
  {
    InputStream localInputStream = b(paramString);
    if (localInputStream == null) {
      return null;
    }
    return new g.b.a(this, d.b(paramString), "UTF-8", localInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.g.b
 * JD-Core Version:    0.7.0.1
 */