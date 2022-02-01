package com.tencent.luggage.wxa.rt;

import android.net.Uri;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class c
  extends h.a
{
  public static final c.a CREATOR = new c.a(null);
  
  public static c a()
  {
    return c.a.a;
  }
  
  private static String a(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      return str;
    }
    catch (IOException localIOException)
    {
      label16:
      break label16;
    }
    return paramString.getAbsolutePath();
  }
  
  private Pair<g.a, String> b(h.c paramc, Uri paramUri)
  {
    paramc = ((g)paramc).d;
    paramUri = paramUri.getPath();
    if (paramUri != null)
    {
      if (paramUri.isEmpty()) {
        return null;
      }
      String str = a(paramUri);
      int i = Collections.binarySearch(paramc, str);
      Object localObject;
      if (i >= 0)
      {
        localObject = (g.a)paramc.get(i);
        paramc = "";
      }
      for (i = -i - 2;; i = paramUri.a)
      {
        if (i < 0)
        {
          paramUri = null;
        }
        else
        {
          paramUri = (g.a)paramc.get(i);
          if ((!str.startsWith(paramUri.b)) || (str.charAt(paramUri.b.length()) != '/')) {
            continue;
          }
        }
        if (i >= 0)
        {
          paramc = str.substring(paramUri.b.length() + 1);
          localObject = paramUri;
        }
        else
        {
          localObject = paramUri;
          paramc = str;
          if (!str.isEmpty())
          {
            localObject = paramUri;
            paramc = str;
            if (str.charAt(0) == '/')
            {
              paramc = str.substring(1);
              localObject = paramUri;
            }
          }
        }
        return new Pair(localObject, paramc);
      }
    }
    return null;
  }
  
  public Pair<d, String> a(h.c paramc, Uri paramUri)
  {
    paramUri = b(paramc, paramUri);
    if (paramUri == null) {
      return null;
    }
    if (paramUri.first == null) {
      paramc = paramc.b();
    } else {
      paramc = ((g.a)paramUri.first).d;
    }
    return new Pair(paramc, paramUri.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.c
 * JD-Core Version:    0.7.0.1
 */