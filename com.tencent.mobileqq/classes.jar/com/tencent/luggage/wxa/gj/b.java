package com.tencent.luggage.wxa.gj;

import android.util.Base64;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.d.d;
import com.tencent.luggage.wxa.d.d.a;
import com.tencent.luggage.wxa.gk.h;
import java.io.ByteArrayInputStream;

public class b
  implements d
{
  private static String[] a = { "jpeg", "png", "gif", "svg+xml" };
  
  private int a(String paramString)
  {
    if (h.a(paramString)) {
      return 0;
    }
    if (!paramString.startsWith("data:image/")) {
      return 0;
    }
    int k = 11;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (paramString.startsWith(str, 11))
      {
        i = 11 + str.length();
        j = 1;
        break label83;
      }
      i += 1;
    }
    j = 0;
    i = k;
    label83:
    if (j == 0) {
      return 0;
    }
    if (!paramString.startsWith(";base64,", i)) {
      return 0;
    }
    return i + 8;
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    paramObject = (String)paramObject;
    return new d.a(new ByteArrayInputStream(Base64.decode(paramObject.substring(a(paramObject)), 2)));
  }
  
  public String a()
  {
    return "base64";
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = paramObject instanceof String;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (a((String)paramObject) > 0) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gj.b
 * JD-Core Version:    0.7.0.1
 */