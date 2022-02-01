package com.tencent.luggage.wxa.no;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.ja.d;
import com.tencent.luggage.wxa.ja.e;
import com.tencent.luggage.wxa.ja.e.a;
import com.tencent.luggage.wxa.jl.a;
import com.tencent.luggage.wxa.jl.b;

public class c
  implements e
{
  public Bitmap a(d paramd, String paramString)
  {
    return a(paramd, paramString, null);
  }
  
  public Bitmap a(d paramd, String paramString, Rect paramRect, e.a parama)
  {
    com.tencent.luggage.wxa.jx.c localc = paramd.i();
    String str = ((b)localc.a(b.class)).b(localc, paramString);
    return ((a)localc.a(a.class)).a(str, paramRect, new c.1(this, parama, paramd, paramString));
  }
  
  public Bitmap a(d paramd, String paramString, e.a parama)
  {
    return a(paramd, paramString, null, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.no.c
 * JD-Core Version:    0.7.0.1
 */