package com.tencent.luggage.wxa.bd;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jl.a;
import com.tencent.luggage.wxa.jl.a.a;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class b
  implements a
{
  private final List<a.a> a = new LinkedList();
  
  public b()
  {
    a(new c());
  }
  
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala.a(paramString)) {
          return locala.a(paramString, paramRect, paramb);
        }
      }
    }
    return null;
  }
  
  protected final void a(a.a parama)
  {
    if (parama == null) {
      return;
    }
    this.a.remove(parama);
    this.a.add(parama);
  }
  
  public void a(String paramString, @Nullable Map<String, String> paramMap, a.c paramc)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramc != null) {
        paramc.a(null);
      }
    }
    else
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala.a(paramString)) {
          locala.a(paramString, paramMap, paramc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bd.b
 * JD-Core Version:    0.7.0.1
 */