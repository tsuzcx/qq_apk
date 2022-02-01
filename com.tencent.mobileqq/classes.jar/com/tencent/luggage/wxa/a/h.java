package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import android.graphics.Picture;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class h
{
  private static j a;
  private static boolean b = true;
  private h.af c = null;
  private String d = "";
  private String e = "";
  private float f = 96.0F;
  private b.q g = new b.q();
  private Map<String, h.al> h = new HashMap();
  
  private h.al a(h.aj paramaj, String paramString)
  {
    Object localObject = (h.al)paramaj;
    if (paramString.equals(((h.al)localObject).p)) {
      return localObject;
    }
    paramaj = paramaj.b().iterator();
    while (paramaj.hasNext())
    {
      localObject = (h.an)paramaj.next();
      if ((localObject instanceof h.al))
      {
        h.al localal = (h.al)localObject;
        if (paramString.equals(localal.p)) {
          return localal;
        }
        if ((localObject instanceof h.aj))
        {
          localObject = a((h.aj)localObject, paramString);
          if (localObject != null) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  private h.b a(float paramFloat)
  {
    h.p localp1 = this.c.c;
    h.p localp2 = this.c.d;
    if ((localp1 != null) && (!localp1.b()) && (localp1.b != h.bd.i) && (localp1.b != h.bd.b) && (localp1.b != h.bd.c))
    {
      float f1 = localp1.a(paramFloat);
      if (localp2 != null)
      {
        if ((!localp2.b()) && (localp2.b != h.bd.i) && (localp2.b != h.bd.b) && (localp2.b != h.bd.c)) {
          paramFloat = localp2.a(paramFloat);
        } else {
          return new h.b(-1.0F, -1.0F, -1.0F, -1.0F);
        }
      }
      else if (this.c.x != null) {
        paramFloat = this.c.x.d * f1 / this.c.x.c;
      } else {
        paramFloat = f1;
      }
      return new h.b(0.0F, 0.0F, f1, paramFloat);
    }
    return new h.b(-1.0F, -1.0F, -1.0F, -1.0F);
  }
  
  public static h a(InputStream paramInputStream)
  {
    return new l().a(paramInputStream, b);
  }
  
  private String e(String paramString)
  {
    String str;
    if ((paramString.startsWith("\"")) && (paramString.endsWith("\"")))
    {
      str = paramString.substring(1, paramString.length() - 1).replace("\\\"", "\"");
    }
    else
    {
      str = paramString;
      if (paramString.startsWith("'"))
      {
        str = paramString;
        if (paramString.endsWith("'")) {
          str = paramString.substring(1, paramString.length() - 1).replace("\\'", "'");
        }
      }
    }
    return str.replace("\\\n", "").replace("\\A", "\n");
  }
  
  static j h()
  {
    return a;
  }
  
  public Picture a()
  {
    return a(null);
  }
  
  public Picture a(int paramInt1, int paramInt2, g paramg)
  {
    Picture localPicture = new Picture();
    Canvas localCanvas = localPicture.beginRecording(paramInt1, paramInt2);
    g localg;
    if (paramg != null)
    {
      localg = paramg;
      if (paramg.f != null) {}
    }
    else
    {
      if (paramg == null) {
        paramg = new g();
      } else {
        paramg = new g(paramg);
      }
      paramg.a(0.0F, 0.0F, paramInt1, paramInt2);
      localg = paramg;
    }
    new i(localCanvas, this.f).a(this, localg);
    localPicture.endRecording();
    return localPicture;
  }
  
  public Picture a(g paramg)
  {
    h.b localb;
    if ((paramg != null) && (paramg.d())) {
      localb = paramg.d;
    } else {
      localb = this.c.x;
    }
    float f1;
    float f2;
    if ((paramg != null) && (paramg.e()))
    {
      f1 = paramg.f.a();
      f2 = paramg.f.b();
      return a((int)Math.ceil(f1), (int)Math.ceil(f2), paramg);
    }
    if ((this.c.c != null) && (this.c.c.b != h.bd.i) && (this.c.d != null) && (this.c.d.b != h.bd.i))
    {
      f1 = this.c.c.a(this.f);
      f2 = this.c.d.a(this.f);
      return a((int)Math.ceil(f1), (int)Math.ceil(f2), paramg);
    }
    if ((this.c.c != null) && (localb != null))
    {
      f1 = this.c.c.a(this.f);
      f2 = localb.d * f1 / localb.c;
      return a((int)Math.ceil(f1), (int)Math.ceil(f2), paramg);
    }
    if ((this.c.d != null) && (localb != null))
    {
      f1 = this.c.d.a(this.f);
      return a((int)Math.ceil(localb.c * f1 / localb.d), (int)Math.ceil(f1), paramg);
    }
    return a(512, 512, paramg);
  }
  
  h.an a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = e(paramString);
    if ((paramString.length() > 1) && (paramString.startsWith("#"))) {
      return d(paramString.substring(1));
    }
    return null;
  }
  
  void a(b.q paramq)
  {
    this.g.a(paramq);
  }
  
  void a(h.af paramaf)
  {
    this.c = paramaf;
  }
  
  public float b()
  {
    if (this.c != null) {
      return a(this.f).c;
    }
    throw new IllegalArgumentException("SVG document is empty");
  }
  
  void b(String paramString)
  {
    this.d = paramString;
  }
  
  public float c()
  {
    if (this.c != null) {
      return a(this.f).d;
    }
    throw new IllegalArgumentException("SVG document is empty");
  }
  
  void c(String paramString)
  {
    this.e = paramString;
  }
  
  h.af d()
  {
    return this.c;
  }
  
  h.al d(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramString.equals(this.c.p)) {
        return this.c;
      }
      if (this.h.containsKey(paramString)) {
        return (h.al)this.h.get(paramString);
      }
      h.al localal = a(this.c, paramString);
      this.h.put(paramString, localal);
      return localal;
    }
    return null;
  }
  
  List<b.o> e()
  {
    return this.g.a();
  }
  
  boolean f()
  {
    return this.g.b() ^ true;
  }
  
  void g()
  {
    this.g.a(b.t.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h
 * JD-Core Version:    0.7.0.1
 */