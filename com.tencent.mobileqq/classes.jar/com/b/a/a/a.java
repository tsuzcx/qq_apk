package com.b.a.a;

import com.a.g;
import com.a.i;
import com.a.k;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.conn.ConnectTimeoutException;

final class a
  extends f
{
  private final f a;
  
  a(f paramf)
  {
    this.a = paramf;
  }
  
  public final e a(com.b.a.m<?> paramm, Map<String, String> paramMap)
  {
    try
    {
      k localk = this.a.b(paramm, paramMap);
      int j = localk.b().a();
      g[] arrayOfg = localk.a();
      TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
      int k = arrayOfg.length;
      int i = 0;
      while (i < k)
      {
        g localg = arrayOfg[i];
        paramMap = (List)localTreeMap.get(localg.a());
        paramm = paramMap;
        if (paramMap == null)
        {
          paramm = new ArrayList();
          localTreeMap.put(localg.a(), paramm);
        }
        paramm.add(localg.b());
        i += 1;
      }
      if (localk.c() == null) {
        return new e(j, localTreeMap);
      }
      long l = localk.c().a();
      if ((int)l == l) {
        return new e(j, localTreeMap, (int)localk.c().a(), localk.c().b());
      }
      paramm = new StringBuilder("Response too large: ");
      paramm.append(l);
      throw new IOException(paramm.toString());
    }
    catch (ConnectTimeoutException paramm)
    {
      paramm = new SocketTimeoutException(paramm.getMessage());
    }
    for (;;)
    {
      throw paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */