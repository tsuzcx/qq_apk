package com.tencent.luggage.wxa.ss;

import com.tencent.xweb.util.c;
import com.tencent.xweb.util.d;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class b
  implements e
{
  public String a(String paramString)
  {
    return d.a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return c.a(paramString1, paramString2);
  }
  
  public InputStream b(String paramString)
  {
    return new FileInputStream(paramString);
  }
  
  public OutputStream c(String paramString)
  {
    return new FileOutputStream(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ss.b
 * JD-Core Version:    0.7.0.1
 */