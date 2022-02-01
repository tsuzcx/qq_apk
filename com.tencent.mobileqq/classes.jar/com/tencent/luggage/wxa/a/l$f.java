package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

 enum l$f
{
  private static final Map<String, f> aO;
  
  static
  {
    int i1 = 0;
    a = new f("CLASS", 0);
    b = new f("clip", 1);
    c = new f("clip_path", 2);
    d = new f("clipPathUnits", 3);
    e = new f("clip_rule", 4);
    f = new f("color", 5);
    g = new f("cx", 6);
    h = new f("cy", 7);
    i = new f("direction", 8);
    j = new f("dx", 9);
    k = new f("dy", 10);
    l = new f("fx", 11);
    m = new f("fy", 12);
    n = new f("d", 13);
    o = new f("display", 14);
    p = new f("fill", 15);
    q = new f("fill_rule", 16);
    r = new f("fill_opacity", 17);
    s = new f("font", 18);
    t = new f("font_family", 19);
    u = new f("font_size", 20);
    v = new f("font_weight", 21);
    w = new f("font_style", 22);
    x = new f("gradientTransform", 23);
    y = new f("gradientUnits", 24);
    z = new f("height", 25);
    A = new f("href", 26);
    B = new f("image_rendering", 27);
    C = new f("marker", 28);
    D = new f("marker_start", 29);
    E = new f("marker_mid", 30);
    F = new f("marker_end", 31);
    G = new f("markerHeight", 32);
    H = new f("markerUnits", 33);
    I = new f("markerWidth", 34);
    J = new f("mask", 35);
    K = new f("maskContentUnits", 36);
    L = new f("maskUnits", 37);
    M = new f("media", 38);
    N = new f("offset", 39);
    O = new f("opacity", 40);
    P = new f("orient", 41);
    Q = new f("overflow", 42);
    R = new f("pathLength", 43);
    S = new f("patternContentUnits", 44);
    T = new f("patternTransform", 45);
    U = new f("patternUnits", 46);
    V = new f("points", 47);
    W = new f("preserveAspectRatio", 48);
    X = new f("r", 49);
    Y = new f("refX", 50);
    Z = new f("refY", 51);
    aa = new f("requiredFeatures", 52);
    ab = new f("requiredExtensions", 53);
    ac = new f("requiredFormats", 54);
    ad = new f("requiredFonts", 55);
    ae = new f("rx", 56);
    af = new f("ry", 57);
    ag = new f("solid_color", 58);
    ah = new f("solid_opacity", 59);
    ai = new f("spreadMethod", 60);
    aj = new f("startOffset", 61);
    ak = new f("stop_color", 62);
    al = new f("stop_opacity", 63);
    am = new f("stroke", 64);
    an = new f("stroke_dasharray", 65);
    ao = new f("stroke_dashoffset", 66);
    ap = new f("stroke_linecap", 67);
    aq = new f("stroke_linejoin", 68);
    ar = new f("stroke_miterlimit", 69);
    as = new f("stroke_opacity", 70);
    at = new f("stroke_width", 71);
    au = new f("style", 72);
    av = new f("systemLanguage", 73);
    aw = new f("text_anchor", 74);
    ax = new f("text_decoration", 75);
    ay = new f("transform", 76);
    az = new f("type", 77);
    aA = new f("vector_effect", 78);
    aB = new f("version", 79);
    aC = new f("viewBox", 80);
    aD = new f("width", 81);
    aE = new f("x", 82);
    aF = new f("y", 83);
    aG = new f("x1", 84);
    aH = new f("y1", 85);
    aI = new f("x2", 86);
    aJ = new f("y2", 87);
    aK = new f("viewport_fill", 88);
    aL = new f("viewport_fill_opacity", 89);
    aM = new f("visibility", 90);
    aN = new f("UNSUPPORTED", 91);
    aP = new f[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN };
    aO = new HashMap();
    f[] arrayOff = values();
    int i2 = arrayOff.length;
    while (i1 < i2)
    {
      f localf = arrayOff[i1];
      if (localf == a)
      {
        aO.put("class", localf);
      }
      else if (localf != aN)
      {
        String str = localf.name().replace('_', '-');
        aO.put(str, localf);
      }
      i1 += 1;
    }
  }
  
  private l$f() {}
  
  public static f a(String paramString)
  {
    paramString = (f)aO.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return aN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.f
 * JD-Core Version:    0.7.0.1
 */