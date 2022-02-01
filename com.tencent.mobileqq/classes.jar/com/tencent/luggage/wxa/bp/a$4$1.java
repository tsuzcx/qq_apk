package com.tencent.luggage.wxa.bp;

import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.gi.a.a;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.pr.a;
import com.tencent.luggage.wxa.pr.b;
import com.tencent.luggage.wxa.pr.b.a;

class a$4$1
  implements a.a
{
  a$4$1(a.4 param4) {}
  
  private int a(String paramString, int paramInt, i<b.a> parami)
  {
    if ((paramString != null) && (paramInt >= 0))
    {
      if (paramInt >= paramString.length()) {
        return 0;
      }
      int j = paramString.codePointAt(paramInt);
      b.a locala = a.a().a(j);
      if (locala != null)
      {
        if (parami != null) {
          parami.a = locala;
        }
        return Character.charCount(j);
      }
      int k = Character.charCount(j) + paramInt;
      int i;
      if (k < paramString.length()) {
        i = paramString.codePointAt(k);
      } else {
        i = 0;
      }
      paramString = a.a().a(j, i);
      if (paramString == null) {
        return 0;
      }
      j = k;
      if (paramString.b != 0) {
        j = k + Character.charCount(i);
      }
      if (parami != null) {
        parami.a = paramString;
      }
      return j - paramInt;
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public Drawable b(String paramString, int paramInt)
  {
    i locali = new i();
    a(paramString, paramInt, locali);
    return a.a().a((b.a)locali.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.4.1
 * JD-Core Version:    0.7.0.1
 */