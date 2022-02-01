package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

 enum l$g
{
  private static final Map<String, g> G;
  
  static
  {
    int i1 = 0;
    a = new g("svg", 0);
    b = new g("a", 1);
    c = new g("circle", 2);
    d = new g("clipPath", 3);
    e = new g("defs", 4);
    f = new g("desc", 5);
    g = new g("ellipse", 6);
    h = new g("g", 7);
    i = new g("image", 8);
    j = new g("line", 9);
    k = new g("linearGradient", 10);
    l = new g("marker", 11);
    m = new g("mask", 12);
    n = new g("path", 13);
    o = new g("pattern", 14);
    p = new g("polygon", 15);
    q = new g("polyline", 16);
    r = new g("radialGradient", 17);
    s = new g("rect", 18);
    t = new g("solidColor", 19);
    u = new g("stop", 20);
    v = new g("style", 21);
    w = new g("SWITCH", 22);
    x = new g("symbol", 23);
    y = new g("text", 24);
    z = new g("textPath", 25);
    A = new g("title", 26);
    B = new g("tref", 27);
    C = new g("tspan", 28);
    D = new g("use", 29);
    E = new g("view", 30);
    F = new g("UNSUPPORTED", 31);
    H = new g[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F };
    G = new HashMap();
    g[] arrayOfg = values();
    int i2 = arrayOfg.length;
    while (i1 < i2)
    {
      g localg = arrayOfg[i1];
      if (localg == w)
      {
        G.put("switch", localg);
      }
      else if (localg != F)
      {
        String str = localg.name();
        G.put(str, localg);
      }
      i1 += 1;
    }
  }
  
  private l$g() {}
  
  public static g a(String paramString)
  {
    paramString = (g)G.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.g
 * JD-Core Version:    0.7.0.1
 */