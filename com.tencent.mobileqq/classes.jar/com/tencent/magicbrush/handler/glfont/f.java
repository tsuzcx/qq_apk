package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gi.d.a;
import com.tencent.luggage.wxa.gk.h;
import java.util.HashMap;

class f
{
  private HashMap<String, Typeface> a = new HashMap();
  private HashMap<String, Integer> b = new f.1(this);
  private b c;
  
  f(b paramb)
  {
    this.c = paramb;
  }
  
  Typeface a(String paramString1, j.a parama, String paramString2)
  {
    j.a locala = parama;
    if (parama == null) {
      locala = j.a.a;
    }
    if ((h.a(paramString2)) && (Build.VERSION.SDK_INT >= 28)) {
      return Typeface.create(Typeface.create(paramString1, locala.e), b(paramString2), locala.a());
    }
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      parama = (Typeface)this.a.get(paramString1);
      if (parama != null)
      {
        if (parama.getStyle() != locala.e) {
          return Typeface.create(parama, locala.e);
        }
        return parama;
      }
      return Typeface.create(paramString1, locala.e);
    }
    return Typeface.create((String)null, locala.e);
  }
  
  String a(String paramString)
  {
    if (h.a(paramString)) {
      return null;
    }
    if ((!paramString.endsWith("ttf")) && (a.a() != null)) {
      a.a().a(1);
    }
    m localm = new m();
    try
    {
      localm.a(paramString);
      return localm.a();
    }
    catch (Exception localException)
    {
      c.c.a("MicroMsg.MBFont", localException, "ttf parse error,path:%s", new Object[] { paramString });
    }
    return null;
  }
  
  void a()
  {
    HashMap localHashMap = this.a;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.a = null;
    }
  }
  
  void a(b paramb)
  {
    this.c = paramb;
  }
  
  int b(String paramString)
  {
    if ((h.a(paramString)) || (!this.b.containsKey(paramString))) {
      return 400;
    }
    return ((Integer)this.b.get(paramString)).intValue();
  }
  
  String c(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      Object localObject = this.c;
      if (localObject == null)
      {
        c.c.b("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
        return null;
      }
      paramString = ((b)localObject).b(paramString);
      Typeface localTypeface = this.c.a(paramString);
      if (localTypeface == null) {
        return null;
      }
      localObject = a(paramString);
      paramString = (String)localObject;
      if (h.a((String)localObject))
      {
        if (a.a() != null) {
          a.a().a(0);
        }
        paramString = new StringBuilder();
        paramString.append("font");
        paramString.append(localTypeface.hashCode());
        paramString = paramString.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("familyName:");
      ((StringBuilder)localObject).append(paramString);
      c.c.b("MicroMsg.MBFont", ((StringBuilder)localObject).toString(), new Object[0]);
      this.a.put(paramString, localTypeface);
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */