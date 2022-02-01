package com.tencent.luggage.wxa.bl;

import android.graphics.Typeface;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.magicbrush.handler.glfont.b;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.lang.ref.WeakReference;

class a$1
  implements b
{
  a$1(a parama, WeakReference paramWeakReference) {}
  
  private String a(d paramd, String paramString)
  {
    try
    {
      paramd = paramd.z().g(paramString);
      if (paramd != null) {
        return paramd.l();
      }
      com.tencent.luggage.wxa.qz.o.b("MBFontManagerRegistry", "Read [%s] from filesystem failed, no file", new Object[] { paramString });
      return null;
    }
    catch (Exception paramd)
    {
      label37:
      break label37;
    }
    com.tencent.luggage.wxa.qz.o.b("MBFontManagerRegistry", "Read [%s] from filesystem failed", new Object[] { paramString });
    return null;
  }
  
  private String b(d paramd, String paramString)
  {
    try
    {
      paramd = ad.e(paramd, paramString);
      return paramd;
    }
    catch (Exception paramd)
    {
      label8:
      break label8;
    }
    com.tencent.luggage.wxa.qz.o.b("MBFontManagerRegistry", "Read [%s] from WxaPkgRuntimeReader failed", new Object[] { paramString });
    return null;
  }
  
  public Typeface a(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MBFontManagerRegistry", "loadFont at path[%s]", new Object[] { paramString });
    if (paramString != null) {
      if (paramString.length() == 0) {
        return null;
      }
    }
    try
    {
      Typeface localTypeface = Typeface.createFromFile(paramString);
      return localTypeface;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    com.tencent.luggage.wxa.qz.o.b("MBFontManagerRegistry", "Create typeface from file failed. fontPath = [%s]", new Object[] { paramString });
    return null;
  }
  
  public String b(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MBFontManagerRegistry", "getFontPath at path[%s]", new Object[] { paramString });
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      d locald = (d)this.a.get();
      if (locald == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MBFontManagerRegistry", "hy: runtime released");
        return null;
      }
      if (paramString.startsWith("wxfile://")) {
        paramString = a(locald, paramString);
      } else {
        paramString = b(locald, paramString);
      }
      if (paramString == null) {
        return null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.a.1
 * JD-Core Version:    0.7.0.1
 */