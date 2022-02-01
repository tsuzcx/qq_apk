package com.b.a.a;

import com.b.a.b.a;
import com.b.a.u;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class d$a
{
  long a;
  final String b;
  final String c;
  final long d;
  final long e;
  final long f;
  final long g;
  final Map<String, String> h;
  
  d$a(String paramString, b.a parama)
  {
    this(paramString, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g);
    this.a = parama.a.length;
  }
  
  private d$a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Map<String, String> paramMap)
  {
    this.b = paramString1;
    paramString1 = paramString2;
    if ("".equals(paramString2)) {
      paramString1 = null;
    }
    this.c = paramString1;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramLong3;
    this.g = paramLong4;
    this.h = paramMap;
  }
  
  static a a(d.b paramb)
  {
    if (d.a(paramb) == 538247942) {
      return new a(d.a(paramb), d.a(paramb), d.b(paramb), d.b(paramb), d.b(paramb), d.b(paramb), d.b(paramb));
    }
    throw new IOException();
  }
  
  final boolean a(OutputStream paramOutputStream)
  {
    try
    {
      d.a(paramOutputStream, 538247942);
      d.a(paramOutputStream, this.b);
      if (this.c == null) {
        localObject = "";
      } else {
        localObject = this.c;
      }
      d.a(paramOutputStream, (String)localObject);
      d.a(paramOutputStream, this.d);
      d.a(paramOutputStream, this.e);
      d.a(paramOutputStream, this.f);
      d.a(paramOutputStream, this.g);
      Object localObject = this.h;
      if (localObject != null)
      {
        d.a(paramOutputStream, ((Map)localObject).size());
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          d.a(paramOutputStream, (String)localEntry.getKey());
          d.a(paramOutputStream, (String)localEntry.getValue());
        }
      }
      d.a(paramOutputStream, 0);
      paramOutputStream.flush();
      return true;
    }
    catch (IOException paramOutputStream)
    {
      u.b("%s", new Object[] { paramOutputStream.toString() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.d.a
 * JD-Core Version:    0.7.0.1
 */