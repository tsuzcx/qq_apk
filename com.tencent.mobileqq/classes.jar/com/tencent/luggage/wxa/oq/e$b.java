package com.tencent.luggage.wxa.oq;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.qz.o;
import org.apache.commons.lang.ArrayUtils;

public enum e$b
{
  public static final b[] h;
  public final int g;
  
  static
  {
    b localb1 = a;
    b localb2 = b;
    b localb3 = c;
    b localb4 = d;
    b localb5 = e;
    b localb6 = f;
    i = new b[] { localb1, localb2, localb3, localb4, localb5, localb6 };
    h = new b[] { localb5, localb6, localb4, localb3 };
  }
  
  private e$b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static b a(int paramInt)
  {
    b[] arrayOfb = values();
    int k = arrayOfb.length;
    int j = 0;
    while (j < k)
    {
      b localb = arrayOfb[j];
      if (localb.g == paramInt) {
        return localb;
      }
      j += 1;
    }
    return b;
  }
  
  @NonNull
  public static b a(h paramh)
  {
    if (paramh != null) {
      paramh = a(paramh.H);
    } else {
      paramh = null;
    }
    Object localObject = paramh;
    if (paramh == null) {
      localObject = a;
    }
    return localObject;
  }
  
  @Nullable
  public static b a(@Nullable String paramString)
  {
    b localb = b(paramString);
    String str;
    if (localb == null) {
      str = null;
    } else {
      str = localb.name();
    }
    int j;
    if (localb == null) {
      j = -1;
    } else {
      j = localb.g;
    }
    o.d("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", new Object[] { paramString, str, Integer.valueOf(j) });
    return localb;
  }
  
  @Nullable
  private static b b(@Nullable String paramString)
  {
    if ("landscape".equals(paramString)) {
      return c;
    }
    if ("portrait".equals(paramString)) {
      return a;
    }
    if ("landscapeLeft".equals(paramString)) {
      return e;
    }
    if ("landscapeRight".equals(paramString)) {
      return f;
    }
    if ((!"auto".equals(paramString)) && (!b.name().equalsIgnoreCase(paramString)))
    {
      b[] arrayOfb = values();
      int k = arrayOfb.length;
      int j = 0;
      while (j < k)
      {
        b localb = arrayOfb[j];
        if (localb.name().equalsIgnoreCase(paramString)) {
          return localb;
        }
        j += 1;
      }
      return null;
    }
    return b;
  }
  
  public static boolean b(b paramb)
  {
    return ArrayUtils.contains(h, paramb);
  }
  
  public boolean a(b paramb)
  {
    return (this == paramb) || ((this == c) && (paramb == d)) || ((this == d) && (paramb == c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.e.b
 * JD-Core Version:    0.7.0.1
 */