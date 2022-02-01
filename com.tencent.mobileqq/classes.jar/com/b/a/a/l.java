package com.b.a.a;

import com.b.a.j;
import com.b.a.m;
import com.b.a.o;
import com.b.a.o.a;
import com.b.a.o.b;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class l
  extends m<String>
{
  private final o.b<String> a;
  
  public l(int paramInt, String paramString, o.b<String> paramb, o.a parama)
  {
    super(paramInt, paramString, parama);
    this.a = paramb;
  }
  
  private static o<String> b(j paramj)
  {
    try
    {
      str = new String(paramj.a, d.a(paramj.b));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str;
      label22:
      break label22;
    }
    str = new String(paramj.a);
    return o.a(str, d.a(paramj));
  }
  
  private static o<String> c(j paramj)
  {
    try
    {
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(paramj.a));
      InputStreamReader localInputStreamReader = new InputStreamReader(localGZIPInputStream);
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      StringBuilder localStringBuilder;
      for (String str1 = "";; str1 = localStringBuilder.toString())
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
      }
      localInputStreamReader.close();
      localBufferedReader.close();
      localGZIPInputStream.close();
      paramj = o.a(str1, d.a(paramj));
      return paramj;
    }
    catch (IOException paramj) {}
    return o.a(new com.b.a.l(paramj));
  }
  
  protected final o<String> a(j paramj)
  {
    String str = (String)paramj.b.get("Content-Encoding");
    if ((str != null) && (str.equals("gzip"))) {
      return c(paramj);
    }
    return b(paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */