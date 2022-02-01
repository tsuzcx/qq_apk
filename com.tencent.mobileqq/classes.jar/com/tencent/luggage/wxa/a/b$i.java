package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

 enum b$i
{
  private static final Map<String, i> z;
  
  static
  {
    int i1 = 0;
    a = new i("target", 0);
    b = new i("root", 1);
    c = new i("nth_child", 2);
    d = new i("nth_last_child", 3);
    e = new i("nth_of_type", 4);
    f = new i("nth_last_of_type", 5);
    g = new i("first_child", 6);
    h = new i("last_child", 7);
    i = new i("first_of_type", 8);
    j = new i("last_of_type", 9);
    k = new i("only_child", 10);
    l = new i("only_of_type", 11);
    m = new i("empty", 12);
    n = new i("not", 13);
    o = new i("lang", 14);
    p = new i("link", 15);
    q = new i("visited", 16);
    r = new i("hover", 17);
    s = new i("active", 18);
    t = new i("focus", 19);
    u = new i("enabled", 20);
    v = new i("disabled", 21);
    w = new i("checked", 22);
    x = new i("indeterminate", 23);
    y = new i("UNSUPPORTED", 24);
    A = new i[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y };
    z = new HashMap();
    i[] arrayOfi = values();
    int i2 = arrayOfi.length;
    while (i1 < i2)
    {
      i locali = arrayOfi[i1];
      if (locali != y)
      {
        String str = locali.name().replace('_', '-');
        z.put(str, locali);
      }
      i1 += 1;
    }
  }
  
  private b$i() {}
  
  public static i a(String paramString)
  {
    paramString = (i)z.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.i
 * JD-Core Version:    0.7.0.1
 */