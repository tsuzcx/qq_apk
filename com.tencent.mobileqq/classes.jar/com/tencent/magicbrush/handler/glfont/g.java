package com.tencent.magicbrush.handler.glfont;

import android.annotation.SuppressLint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import com.tencent.luggage.wxa.gi.a;
import com.tencent.luggage.wxa.gi.a.a;
import com.tencent.luggage.wxa.gi.c.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"LongLogTag"})
class g
{
  g.a a;
  private h b = new h(parame, this);
  private HashMap<String, k> c;
  private FloatBuffer d;
  private List<k> e;
  private j f;
  private StringBuilder g = new StringBuilder();
  
  g(e parame, c paramc)
  {
    this.b.a(paramc);
    this.c = new HashMap();
    this.a = new g.a();
    this.e = new ArrayList();
  }
  
  private int a(String paramString, int paramInt)
  {
    if (a.a() == null) {
      return 0;
    }
    return a.a().a(paramString, paramInt);
  }
  
  private k a(char paramChar, int paramInt)
  {
    if (this.f == null) {
      return null;
    }
    Object localObject = a(paramChar);
    k localk = (k)this.c.get(localObject);
    if (localk != null) {
      return localk;
    }
    localk = this.b.a(paramChar, paramInt);
    if (localk == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Load glyph failed. glyph == null [");
      ((StringBuilder)localObject).append(paramChar);
      ((StringBuilder)localObject).append("]");
      c.c.a("MagicBrush.MBFontGlyphManager", ((StringBuilder)localObject).toString(), new Object[0]);
      return null;
    }
    this.c.put(localObject, localk);
    return localk;
  }
  
  private k a(String paramString, int paramInt1, int paramInt2)
  {
    String str = b(paramString, paramInt1, paramInt2);
    k localk = (k)this.c.get(str);
    if (localk != null) {
      return localk;
    }
    if (a.a() != null)
    {
      paramString = a.a().b(paramString, paramInt1);
      if (paramString == null) {
        return null;
      }
      paramInt1 = (int)this.f.c;
      int i = (int)this.f.c;
      if (paramInt1 > 0)
      {
        if (i <= 0) {
          return null;
        }
        paramString = this.b.a(paramString, paramInt1, i);
        if (paramString == null)
        {
          c.c.a("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
          return null;
        }
        paramString.k = paramInt2;
        this.c.put(str, paramString);
        return paramString;
      }
      return null;
    }
    throw new IllegalStateException("FontDrawableProvider must support");
  }
  
  private String a(char paramChar)
  {
    if (this.f == null) {
      return null;
    }
    this.g.setLength(0);
    StringBuilder localStringBuilder = this.g;
    localStringBuilder.append(paramChar);
    localStringBuilder.append("|");
    localStringBuilder.append(this.f.c);
    localStringBuilder.append("|");
    Object localObject;
    if (this.f.a == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(this.f.a.hashCode());
    }
    localStringBuilder.append(localObject);
    if (this.f.d)
    {
      localStringBuilder.append("|");
      localStringBuilder.append(this.f.e);
    }
    if (this.f.f != null)
    {
      localStringBuilder.append("|");
      localStringBuilder.append(this.f.f.e);
    }
    return localStringBuilder.toString();
  }
  
  private FloatBuffer a(int paramInt)
  {
    paramInt = Math.max(paramInt, 10) * 40 + 16;
    FloatBuffer localFloatBuffer = this.d;
    if ((localFloatBuffer == null) || (localFloatBuffer.capacity() * 4 < paramInt)) {
      this.d = ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.d.clear();
    return this.d;
  }
  
  private String b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      this.g.setLength(0);
      while (paramInt2 > 0)
      {
        this.g.append(paramString.charAt(paramInt1));
        paramInt1 += 1;
        paramInt2 -= 1;
      }
      paramString = this.g;
      paramString.append("|");
      paramString.append(this.f.c);
      return this.g.toString();
    }
    paramString = new IllegalStateException("There is no font drawable");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private List<k> d(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      this.e.clear();
      int i = 0;
      while (i < paramString.length())
      {
        int j = a(paramString, i);
        k localk;
        if (j > 0)
        {
          localk = a(paramString, i, j);
          i += j;
        }
        else
        {
          localk = a(paramString.charAt(i), i);
          i += 1;
        }
        if (localk == null)
        {
          this.e.clear();
          return null;
        }
        this.e.add(localk);
      }
      return this.e;
    }
    return null;
  }
  
  FloatBuffer a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      List localList = d(paramString);
      if (localList != null)
      {
        if (localList.size() == 0) {
          return null;
        }
        paramString = a(paramString.length());
        float f1 = this.b.a(localList);
        Paint.FontMetrics localFontMetrics = this.b.a();
        paramString.put(f1).put(localFontMetrics.ascent).put(localFontMetrics.bottom).put(localFontMetrics.bottom - localFontMetrics.ascent);
        k.a(paramString, localList);
        paramString.flip();
        this.e.clear();
        return paramString;
      }
    }
    return null;
  }
  
  void a()
  {
    h localh = this.b;
    if (localh != null)
    {
      localh.b();
      this.b = null;
    }
  }
  
  void a(j paramj)
  {
    this.f = paramj;
    this.b.a(paramj);
  }
  
  float b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = d(paramString);
      if ((paramString != null) && (paramString.size() != 0)) {
        return this.b.a(paramString);
      }
      return -1.0F;
    }
    return 0.0F;
  }
  
  void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        k localk = (k)((Iterator)localObject).next();
        this.a.a(localk);
      }
      this.c.clear();
    }
  }
  
  float c(String paramString)
  {
    return this.b.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.g
 * JD-Core Version:    0.7.0.1
 */