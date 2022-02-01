package com.tencent.luggage.wxa.a;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class l
{
  private h a = null;
  private h.aj b = null;
  private boolean c = false;
  private int d;
  private boolean e = false;
  private l.g f = null;
  private StringBuilder g = null;
  private boolean h = false;
  private StringBuilder i = null;
  
  private static Boolean A(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 466743410: 
      if (paramString.equals("visible")) {
        j = 0;
      }
      break;
    case 3005871: 
      if (paramString.equals("auto")) {
        j = 1;
      }
      break;
    case -907680051: 
      if (paramString.equals("scroll")) {
        j = 3;
      }
      break;
    case -1217487446: 
      if (paramString.equals("hidden")) {
        j = 2;
      }
      break;
    }
    int j = -1;
    if ((j != 0) && (j != 1))
    {
      if ((j != 2) && (j != 3)) {
        return null;
      }
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  private void A(Attributes paramAttributes)
  {
    a("<view>", new Object[0]);
    if (this.b != null)
    {
      h.bf localbf = new h.bf();
      localbf.u = this.a;
      localbf.v = this.b;
      a(localbf, paramAttributes);
      a(localbf, paramAttributes);
      a(localbf, paramAttributes);
      this.b.a(localbf);
      this.b = localbf;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.c B(String paramString)
  {
    if ("auto".equals(paramString)) {
      return null;
    }
    if (!paramString.startsWith("rect(")) {
      return null;
    }
    paramString = new l.h(paramString.substring(5));
    paramString.g();
    h.p localp1 = b(paramString);
    paramString.h();
    h.p localp2 = b(paramString);
    paramString.h();
    h.p localp3 = b(paramString);
    paramString.h();
    h.p localp4 = b(paramString);
    paramString.g();
    if ((!paramString.a(')')) && (!paramString.f())) {
      return null;
    }
    return new h.c(localp1, localp2, localp3, localp4);
  }
  
  private void B(Attributes paramAttributes)
  {
    a("<mask>", new Object[0]);
    if (this.b != null)
    {
      h.s locals = new h.s();
      locals.u = this.a;
      locals.v = this.b;
      a(locals, paramAttributes);
      b(locals, paramAttributes);
      a(locals, paramAttributes);
      a(locals, paramAttributes);
      this.b.a(locals);
      this.b = locals;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.i C(String paramString)
  {
    int j = paramString.hashCode();
    if (j != 3387192)
    {
      if ((j == 1629199934) && (paramString.equals("non-scaling-stroke")))
      {
        j = 1;
        break label50;
      }
    }
    else if (paramString.equals("none"))
    {
      j = 0;
      break label50;
    }
    j = -1;
    label50:
    if (j != 0)
    {
      if (j != 1) {
        return null;
      }
      return h.ae.i.b;
    }
    return h.ae.i.a;
  }
  
  private void C(Attributes paramAttributes)
  {
    int j = 0;
    a("<style>", new Object[0]);
    if (this.b != null)
    {
      Object localObject = "all";
      boolean bool = true;
      while (j < paramAttributes.getLength())
      {
        String str = paramAttributes.getValue(j).trim();
        int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
        if (k != 88)
        {
          if (k == 89) {
            localObject = str;
          }
        }
        else {
          bool = str.equals("text/css");
        }
        j += 1;
      }
      if ((bool) && (b.a((String)localObject, b.e.h)))
      {
        this.h = true;
        return;
      }
      this.c = true;
      this.d = 1;
      return;
    }
    paramAttributes = new k("Invalid document. Root element must be <svg>");
    for (;;)
    {
      throw paramAttributes;
    }
  }
  
  private static h.ae.e D(String paramString)
  {
    int j = paramString.hashCode();
    if (j != -933002398)
    {
      if (j != 3005871)
      {
        if ((j == 362741610) && (paramString.equals("optimizeSpeed")))
        {
          j = 2;
          break label70;
        }
      }
      else if (paramString.equals("auto"))
      {
        j = 0;
        break label70;
      }
    }
    else if (paramString.equals("optimizeQuality"))
    {
      j = 1;
      break label70;
    }
    j = -1;
    label70:
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return null;
        }
        return h.ae.e.c;
      }
      return h.ae.e.b;
    }
    return h.ae.e.a;
  }
  
  private static Set<String> E(String paramString)
  {
    paramString = new l.h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.f())
    {
      String str = paramString.o();
      if (str.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
        localHashSet.add(str.substring(35));
      } else {
        localHashSet.add("UNSUPPORTED");
      }
      paramString.g();
    }
    return localHashSet;
  }
  
  private static Set<String> F(String paramString)
  {
    l.h localh = new l.h(paramString);
    HashSet localHashSet = new HashSet();
    while (!localh.f())
    {
      String str = localh.o();
      int j = str.indexOf('-');
      paramString = str;
      if (j != -1) {
        paramString = str.substring(0, j);
      }
      localHashSet.add(new Locale(paramString, "", "").getLanguage());
      localh.g();
    }
    return localHashSet;
  }
  
  private static Set<String> G(String paramString)
  {
    paramString = new l.h(paramString);
    HashSet localHashSet = new HashSet();
    while (!paramString.f())
    {
      localHashSet.add(paramString.o());
      paramString.g();
    }
    return localHashSet;
  }
  
  private void H(String paramString)
  {
    b localb = new b(b.e.h, b.t.a);
    this.a.a(localb.a(paramString));
  }
  
  private static float a(String paramString, int paramInt1, int paramInt2)
  {
    float f1 = new e().a(paramString, paramInt1, paramInt2);
    if (!Float.isNaN(f1)) {
      return f1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid float value: ");
    localStringBuilder.append(paramString);
    throw new k(localStringBuilder.toString());
  }
  
  private static int a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return 0;
    }
    if (paramFloat > 255.0F) {
      return 255;
    }
    return Math.round(paramFloat);
  }
  
  private static int a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= 0.0F) {
      paramFloat1 %= 360.0F;
    } else {
      paramFloat1 = paramFloat1 % 360.0F + 360.0F;
    }
    float f1 = paramFloat1 / 60.0F;
    paramFloat2 /= 100.0F;
    paramFloat3 /= 100.0F;
    if (paramFloat2 < 0.0F)
    {
      paramFloat1 = 0.0F;
    }
    else
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
    if (paramFloat3 < 0.0F)
    {
      paramFloat2 = 0.0F;
    }
    else
    {
      paramFloat2 = paramFloat3;
      if (paramFloat3 > 1.0F) {
        paramFloat2 = 1.0F;
      }
    }
    if (paramFloat2 <= 0.5F) {
      paramFloat1 = (paramFloat1 + 1.0F) * paramFloat2;
    } else {
      paramFloat1 = paramFloat2 + paramFloat1 - paramFloat1 * paramFloat2;
    }
    float f2 = paramFloat2 * 2.0F - paramFloat1;
    paramFloat2 = b(f2, paramFloat1, f1 + 2.0F);
    paramFloat3 = b(f2, paramFloat1, f1);
    paramFloat1 = b(f2, paramFloat1, f1 - 2.0F);
    int j = a(paramFloat2 * 256.0F);
    int k = a(paramFloat3 * 256.0F);
    return a(paramFloat1 * 256.0F) | j << 16 | k << 8;
  }
  
  static h.p a(String paramString)
  {
    Object localObject2;
    int j;
    if (paramString.length() != 0)
    {
      int k = paramString.length();
      localObject2 = h.bd.a;
      char c1 = paramString.charAt(k - 1);
      if (c1 == '%')
      {
        j = k - 1;
        localObject1 = h.bd.i;
      }
      else
      {
        j = k;
        localObject1 = localObject2;
        if (k > 2)
        {
          j = k;
          localObject1 = localObject2;
          if (Character.isLetter(c1))
          {
            j = k;
            localObject1 = localObject2;
            if (Character.isLetter(paramString.charAt(k - 2)))
            {
              j = k - 2;
              localObject1 = paramString.substring(j);
            }
          }
        }
      }
    }
    try
    {
      localObject1 = h.bd.valueOf(((String)localObject1).toLowerCase(Locale.US));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label113:
      break label113;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid length unit specifier: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new k(((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new h.p(a(paramString, 0, j), (h.bd)localObject1);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Invalid length value: ");
      ((StringBuilder)localObject2).append(paramString);
      throw new k(((StringBuilder)localObject2).toString(), localNumberFormatException);
    }
    throw new k("Invalid length value (empty string)");
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1.equals("none")) {
      return null;
    }
    if (!paramString1.startsWith("url(")) {
      return null;
    }
    if (paramString1.endsWith(")")) {
      return paramString1.substring(4, paramString1.length() - 1).trim();
    }
    return paramString1.substring(4).trim();
  }
  
  private Map<String, String> a(l.h paramh)
  {
    HashMap localHashMap = new HashMap();
    paramh.g();
    for (String str = paramh.b('='); str != null; str = paramh.b('='))
    {
      paramh.a('=');
      localHashMap.put(str, paramh.u());
      paramh.g();
    }
    return localHashMap;
  }
  
  private void a()
  {
    this.a = new h();
  }
  
  private void a(h.a parama, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      if ((l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()] == 6) && (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j))))) {
        parama.a = str;
      }
      j += 1;
    }
  }
  
  private void a(h.ab paramab, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k != 10)
              {
                if (k == 11)
                {
                  paramab.g = a(str);
                  if (paramab.g.c()) {
                    throw new k("Invalid <rect> element. ry cannot be negative");
                  }
                }
              }
              else
              {
                paramab.f = a(str);
                if (paramab.f.c()) {
                  throw new k("Invalid <rect> element. rx cannot be negative");
                }
              }
            }
            else
            {
              paramab.d = a(str);
              if (paramab.d.c()) {
                throw new k("Invalid <rect> element. height cannot be negative");
              }
            }
          }
          else
          {
            paramab.c = a(str);
            if (paramab.c.c()) {
              throw new k("Invalid <rect> element. width cannot be negative");
            }
          }
        }
        else {
          paramab.b = a(str);
        }
      }
      else {
        paramab.a = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.ad paramad, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      if (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()] == 37) {
        paramad.a = f(str);
      }
      j += 1;
    }
  }
  
  private static void a(h.ae paramae, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append('|');
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append('|');
    if (!"|caption|icon|menu|message-box|small-caption|status-bar|".contains(((StringBuilder)localObject1).toString())) {
      return;
    }
    l.h localh = new l.h(paramString);
    localObject1 = null;
    paramString = null;
    Object localObject3 = paramString;
    String str;
    Object localObject4;
    Object localObject2;
    for (;;)
    {
      str = localh.b('/');
      localh.g();
      if (str == null) {
        return;
      }
      if ((localObject1 != null) && (paramString != null))
      {
        localObject4 = localObject1;
        break;
      }
      if (!str.equals("normal"))
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = l.d.a(str);
          localObject2 = localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = paramString;
          if (paramString == null)
          {
            paramString = s(str);
            localObject1 = paramString;
            if (paramString != null)
            {
              localObject1 = localObject2;
              continue;
            }
          }
          paramString = (String)localObject1;
          localObject4 = localObject2;
          if (localObject3 != null) {
            break;
          }
          paramString = (String)localObject1;
          localObject4 = localObject2;
          if (!str.equals("small-caps")) {
            break;
          }
          localObject3 = str;
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
      }
    }
    localObject1 = q(str);
    if (localh.a('/'))
    {
      localh.g();
      localObject2 = localh.o();
      if (localObject2 == null) {}
    }
    try
    {
      a((String)localObject2);
      localh.g();
      paramae.o = p(localh.v());
      paramae.p = ((h.p)localObject1);
      int j;
      if (localObject4 == null) {
        j = 400;
      } else {
        j = localObject4.intValue();
      }
      paramae.q = Integer.valueOf(j);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = h.ae.b.a;
      }
      paramae.r = ((h.ae.b)localObject1);
      paramae.a |= 0x1E000;
      return;
    }
    catch (k paramae) {}
  }
  
  static void a(h.ae paramae, String paramString1, String paramString2)
  {
    if (paramString2.length() == 0) {
      return;
    }
    if (paramString2.equals("inherit")) {
      return;
    }
    switch (l.1.b[l.f.a(paramString1).ordinal()])
    {
    default: 
      return;
    case 86: 
      paramae.M = D(paramString2);
      if (paramae.M != null)
      {
        paramae.a |= 0x0;
        return;
      }
      break;
    case 85: 
      paramae.L = C(paramString2);
      if (paramae.L != null)
      {
        paramae.a |= 0x0;
        return;
      }
      break;
    case 84: 
      paramae.K = j(paramString2);
      paramae.a |= 0x0;
      return;
    case 83: 
      if (paramString2.equals("currentColor")) {
        paramae.J = h.g.a();
      }
      try
      {
        paramae.J = n(paramString2);
        paramae.a |= 0x0;
        return;
      }
      catch (k paramae)
      {
        Log.w("SVGParser", paramae.getMessage());
        return;
      }
    case 82: 
      paramae.I = j(paramString2);
      paramae.a |= 0x0;
      return;
    case 81: 
      if (paramString2.equals("currentColor")) {
        paramae.H = h.g.a();
      }
      try
      {
        paramae.H = n(paramString2);
        paramae.a |= 0x80000000;
        return;
      }
      catch (k paramae)
      {
        Log.w("SVGParser", paramae.getMessage());
        return;
      }
    case 80: 
      paramae.G = a(paramString2, paramString1);
      paramae.a |= 0x40000000;
      return;
    case 79: 
      paramae.F = v(paramString2);
      paramae.a |= 0x20000000;
      return;
    case 78: 
      paramae.E = a(paramString2, paramString1);
      paramae.a |= 0x10000000;
      return;
    case 77: 
      paramae.w = B(paramString2);
      if (paramae.w != null)
      {
        paramae.a |= 0x100000;
        return;
      }
      break;
    case 76: 
      paramae.D = j(paramString2);
      paramae.a |= 0x8000000;
      return;
    case 75: 
      if (paramString2.equals("currentColor")) {
        paramae.C = h.g.a();
      }
      try
      {
        paramae.C = n(paramString2);
        paramae.a |= 0x4000000;
        return;
      }
      catch (k paramae)
      {
        Log.w("SVGParser", paramae.getMessage());
        return;
      }
    case 74: 
      if (paramString2.indexOf('|') < 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append('|');
        paramString1.append(paramString2);
        paramString1.append('|');
        if (!"|visible|hidden|collapse|".contains(paramString1.toString())) {
          return;
        }
        paramae.B = Boolean.valueOf(paramString2.equals("visible"));
        paramae.a |= 0x2000000;
        return;
      }
      break;
    case 73: 
      if (paramString2.indexOf('|') < 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append('|');
        paramString1.append(paramString2);
        paramString1.append('|');
        if (!"|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains(paramString1.toString())) {
          return;
        }
        paramae.A = Boolean.valueOf(paramString2.equals("none") ^ true);
        paramae.a |= 0x1000000;
        return;
      }
      break;
    case 72: 
      paramae.z = a(paramString2, paramString1);
      paramae.a |= 0x800000;
      return;
    case 71: 
      paramae.y = a(paramString2, paramString1);
      paramae.a |= 0x400000;
      return;
    case 70: 
      paramae.x = a(paramString2, paramString1);
      paramae.a |= 0x200000;
      return;
    case 69: 
      paramae.x = a(paramString2, paramString1);
      paramae.y = paramae.x;
      paramae.z = paramae.x;
      paramae.a |= 0xE00000;
      return;
    case 68: 
      paramae.v = A(paramString2);
      if (paramae.v != null)
      {
        paramae.a |= 0x80000;
        return;
      }
      break;
    case 67: 
      paramae.u = z(paramString2);
      if (paramae.u != null)
      {
        paramae.a |= 0x40000;
        return;
      }
      break;
    case 66: 
      paramae.t = u(paramString2);
      if (paramae.t != null)
      {
        paramae.a |= 0x0;
        return;
      }
      break;
    case 65: 
      paramae.s = t(paramString2);
      if (paramae.s != null)
      {
        paramae.a |= 0x20000;
        return;
      }
      break;
    case 64: 
      paramae.r = s(paramString2);
      if (paramae.r != null)
      {
        paramae.a |= 0x10000;
        return;
      }
      break;
    case 63: 
      paramae.q = r(paramString2);
      if (paramae.q != null)
      {
        paramae.a |= 0x8000;
        return;
      }
      break;
    case 62: 
      paramae.p = q(paramString2);
      if (paramae.p != null)
      {
        paramae.a |= 0x4000;
        return;
      }
      break;
    case 61: 
      paramae.o = p(paramString2);
      if (paramae.o != null)
      {
        paramae.a |= 0x2000;
        return;
      }
      break;
    case 60: 
      a(paramae, paramString2);
      return;
    }
    try
    {
      paramae.n = n(paramString2);
      paramae.a |= 0x1000;
      return;
    }
    catch (k paramae) {}
    paramae.m = j(paramString2);
    paramae.a |= 0x800;
    return;
    paramae.l = a(paramString2);
    paramae.a |= 0x400;
    return;
    if ("none".equals(paramString2))
    {
      paramae.k = null;
      paramae.a |= 0x200;
      return;
    }
    paramae.k = y(paramString2);
    if (paramae.k != null)
    {
      paramae.a |= 0x200;
      return;
      paramae.j = Float.valueOf(i(paramString2));
      paramae.a |= 0x100;
      return;
      paramae.i = x(paramString2);
      if (paramae.i != null)
      {
        paramae.a |= 0x80;
        return;
        paramae.h = w(paramString2);
        if (paramae.h != null)
        {
          paramae.a |= 0x40;
          return;
          paramae.g = a(paramString2);
          paramae.a |= 0x20;
          return;
          paramae.f = j(paramString2);
          if (paramae.f != null)
          {
            paramae.a |= 0x10;
            return;
            paramae.e = l(paramString2);
            if (paramae.e != null)
            {
              paramae.a |= 0x8;
              return;
              paramae.d = j(paramString2);
              if (paramae.d != null)
              {
                paramae.a |= 0x4;
                return;
                paramae.c = v(paramString2);
                if (paramae.c != null)
                {
                  paramae.a |= 0x2;
                  return;
                  paramae.b = l(paramString2);
                  if (paramae.b != null) {
                    paramae.a |= 1L;
                  }
                }
              }
            }
          }
        }
      }
    }
    return;
  }
  
  private void a(h.af paramaf, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k == 5) {
                paramaf.e = str;
              }
            }
            else
            {
              paramaf.d = a(str);
              if (paramaf.d.c()) {
                throw new k("Invalid <svg> element. height cannot be negative");
              }
            }
          }
          else
          {
            paramaf.c = a(str);
            if (paramaf.c.c()) {
              throw new k("Invalid <svg> element. width cannot be negative");
            }
          }
        }
        else {
          paramaf.b = a(str);
        }
      }
      else {
        paramaf.a = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.ag paramag, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      Object localObject = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 25: 
        localObject = p((String)localObject);
        if (localObject != null) {
          localObject = new HashSet((Collection)localObject);
        } else {
          localObject = new HashSet(0);
        }
        paramag.d((Set)localObject);
        break;
      case 24: 
        paramag.c(G((String)localObject));
        break;
      case 23: 
        paramag.b(F((String)localObject));
        break;
      case 22: 
        paramag.a((String)localObject);
        break;
      case 21: 
        paramag.a(E((String)localObject));
      }
      j += 1;
    }
  }
  
  private static void a(h.al paramal, String paramString)
  {
    paramString = new b.c(paramString.replaceAll("/\\*.*?\\*/", ""));
    while (!paramString.f())
    {
      paramString.g();
      String str1 = paramString.a();
      paramString.g();
      if (!paramString.a(';'))
      {
        if (!paramString.a(':')) {
          return;
        }
        paramString.g();
        String str2 = paramString.b();
        if (str2 != null)
        {
          paramString.g();
          if ((paramString.f()) || (paramString.a(';')))
          {
            if (paramal.s == null) {
              paramal.s = new h.ae();
            }
            a(paramal.s, str1, str2);
            paramString.g();
          }
        }
      }
    }
  }
  
  private void a(h.al paramal, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getQName(j);
      if ((!str.equals("id")) && (!str.equals("xml:id")))
      {
        if (str.equals("xml:space"))
        {
          paramAttributes = paramAttributes.getValue(j).trim();
          if ("default".equals(paramAttributes))
          {
            paramal.q = Boolean.FALSE;
            return;
          }
          if ("preserve".equals(paramAttributes))
          {
            paramal.q = Boolean.TRUE;
            return;
          }
          paramal = new StringBuilder();
          paramal.append("Invalid value for \"xml:space\" attribute: ");
          paramal.append(paramAttributes);
          throw new k(paramal.toString());
        }
        j += 1;
      }
      else
      {
        paramal.p = paramAttributes.getValue(j).trim();
      }
    }
  }
  
  private void a(h.am paramam, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 18: 
        paramam.i = a(str);
        break;
      case 17: 
        paramam.h = a(str);
        break;
      case 16: 
        paramam.g = a(str);
        break;
      case 15: 
        paramam.f = a(str);
      }
      j += 1;
    }
  }
  
  private static void a(h.ap paramap, String paramString)
  {
    paramap.w = b(paramString);
  }
  
  private void a(h.aq paramaq, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 35)
      {
        if (k != 36) {
          switch (k)
          {
          default: 
            break;
          case 14: 
            paramaq.h = a(str);
            if (!paramaq.h.c()) {
              break;
            }
            throw new k("Invalid <radialGradient> element. r cannot be negative");
          case 13: 
            paramaq.g = a(str);
            break;
          case 12: 
            paramaq.f = a(str);
            break;
          }
        } else {
          paramaq.j = a(str);
        }
      }
      else {
        paramaq.i = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.ar paramar, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 7)
      {
        if (k == 87) {
          paramar.x = k(str);
        }
      }
      else {
        a(paramar, str);
      }
      j += 1;
    }
  }
  
  private void a(h.au paramau, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      if ((l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()] == 6) && (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j))))) {
        paramau.a = str;
      }
      j += 1;
    }
  }
  
  private void a(h.az paramaz, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 6)
      {
        if (k == 39) {
          paramaz.b = a(str);
        }
      }
      else if (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j)))) {
        paramaz.a = str;
      }
      j += 1;
    }
  }
  
  private void a(h.ba paramba, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 19)
          {
            if (k == 20) {
              paramba.e = h(str);
            }
          }
          else {
            paramba.d = h(str);
          }
        }
        else {
          paramba.c = h(str);
        }
      }
      else {
        paramba.b = h(str);
      }
      j += 1;
    }
  }
  
  private void a(h.be parambe, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if ((k == 6) && (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j))))) {
                parambe.a = str;
              }
            }
            else
            {
              parambe.f = a(str);
              if (parambe.f.c()) {
                throw new k("Invalid <use> element. height cannot be negative");
              }
            }
          }
          else
          {
            parambe.e = a(str);
            if (parambe.e.c()) {
              throw new k("Invalid <use> element. width cannot be negative");
            }
          }
        }
        else {
          parambe.d = a(str);
        }
      }
      else {
        parambe.c = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.d paramd, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 14: 
        paramd.c = a(str);
        if (paramd.c.c()) {
          throw new k("Invalid <circle> element. r cannot be negative");
        }
        break;
      case 13: 
        paramd.b = a(str);
        break;
      case 12: 
        paramd.a = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.e parame, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      if (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()] == 38) {
        if ("objectBoundingBox".equals(str))
        {
          parame.a = Boolean.valueOf(false);
        }
        else
        {
          if (!"userSpaceOnUse".equals(str)) {
            break label97;
          }
          parame.a = Boolean.valueOf(true);
        }
      }
      j += 1;
      continue;
      label97:
      throw new k("Invalid value for attribute clipPathUnits");
    }
  }
  
  private void a(h.i parami, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 13: 
        parami.b = a(str);
        break;
      case 12: 
        parami.a = a(str);
        break;
      case 11: 
        parami.d = a(str);
        if (parami.d.c()) {
          throw new k("Invalid <ellipse> element. ry cannot be negative");
        }
        break;
      case 10: 
        parami.c = a(str);
        if (parami.c.c()) {
          throw new k("Invalid <ellipse> element. rx cannot be negative");
        }
        break;
      }
      j += 1;
    }
  }
  
  private void a(h.j paramj, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 6) {
        switch (k)
        {
        default: 
          break;
        }
      }
      try
      {
        paramj.d = h.k.valueOf(str);
      }
      catch (IllegalArgumentException paramj)
      {
        label95:
        break label95;
      }
      paramj = new StringBuilder();
      paramj.append("Invalid spreadMethod attribute. \"");
      paramj.append(str);
      paramj.append("\" is not a valid value.");
      throw new k(paramj.toString());
      paramj.c = g(str);
      break label244;
      if ("objectBoundingBox".equals(str))
      {
        paramj.b = Boolean.valueOf(false);
      }
      else if ("userSpaceOnUse".equals(str))
      {
        paramj.b = Boolean.valueOf(true);
      }
      else
      {
        throw new k("Invalid value for attribute gradientUnits");
        if (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j)))) {
          paramj.e = str;
        }
      }
      label244:
      j += 1;
    }
  }
  
  private void a(h.n paramn, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      if (l.f.a(paramAttributes.getLocalName(j)) == l.f.ay) {
        paramn.a(g(paramAttributes.getValue(j)));
      }
      j += 1;
    }
  }
  
  private void a(h.o paramo, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k != 6)
              {
                if (k == 7) {
                  a(paramo, str);
                }
              }
              else if (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j)))) {
                paramo.a = str;
              }
            }
            else
            {
              paramo.e = a(str);
              if (paramo.e.c()) {
                throw new k("Invalid <use> element. height cannot be negative");
              }
            }
          }
          else
          {
            paramo.d = a(str);
            if (paramo.d.c()) {
              throw new k("Invalid <use> element. width cannot be negative");
            }
          }
        }
        else {
          paramo.c = a(str);
        }
      }
      else {
        paramo.b = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.q paramq, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 18: 
        paramq.d = a(str);
        break;
      case 17: 
        paramq.c = a(str);
        break;
      case 16: 
        paramq.b = a(str);
        break;
      case 15: 
        paramq.a = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.r paramr, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      switch (l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()])
      {
      default: 
        break;
      case 31: 
        if ("auto".equals(str)) {
          paramr.f = Float.valueOf((0.0F / 0.0F));
        } else {
          paramr.f = Float.valueOf(i(str));
        }
        break;
      case 30: 
        if ("strokeWidth".equals(str)) {
          paramr.a = false;
        } else if ("userSpaceOnUse".equals(str)) {
          paramr.a = true;
        } else {
          throw new k("Invalid value for attribute markerUnits");
        }
        break;
      case 29: 
        paramr.e = a(str);
        if (paramr.e.c()) {
          throw new k("Invalid <marker> element. markerHeight cannot be negative");
        }
        break;
      case 28: 
        paramr.d = a(str);
        if (paramr.d.c()) {
          throw new k("Invalid <marker> element. markerWidth cannot be negative");
        }
        break;
      case 27: 
        paramr.c = a(str);
        break;
      case 26: 
        paramr.b = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.s params, Attributes paramAttributes)
  {
    int j = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k != 43)
              {
                if (k == 44) {
                  if ("objectBoundingBox".equals(str)) {
                    params.b = localBoolean;
                  } else if ("userSpaceOnUse".equals(str)) {
                    params.b = Boolean.valueOf(true);
                  } else {
                    throw new k("Invalid value for attribute maskContentUnits");
                  }
                }
              }
              else if ("objectBoundingBox".equals(str)) {
                params.a = localBoolean;
              } else if ("userSpaceOnUse".equals(str)) {
                params.a = Boolean.valueOf(true);
              } else {
                throw new k("Invalid value for attribute maskUnits");
              }
            }
            else
            {
              params.f = a(str);
              if (params.f.c()) {
                throw new k("Invalid <mask> element. height cannot be negative");
              }
            }
          }
          else
          {
            params.e = a(str);
            if (params.e.c()) {
              throw new k("Invalid <mask> element. width cannot be negative");
            }
          }
        }
        else {
          params.d = a(str);
        }
      }
      else {
        params.c = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.v paramv, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 8)
      {
        if (k == 9)
        {
          paramv.b = Float.valueOf(i(str));
          if (paramv.b.floatValue() < 0.0F) {
            throw new k("Invalid <path> element. pathLength cannot be negative");
          }
        }
      }
      else {
        paramv.a = c(str);
      }
      j += 1;
    }
  }
  
  private void a(h.y paramy, Attributes paramAttributes)
  {
    int j = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k != 6) {
                switch (k)
                {
                default: 
                  break;
                case 42: 
                  paramy.c = g(str);
                  break;
                case 41: 
                  if ("objectBoundingBox".equals(str))
                  {
                    paramy.b = localBoolean;
                    break;
                  }
                  if ("userSpaceOnUse".equals(str))
                  {
                    paramy.b = Boolean.valueOf(true);
                    break;
                  }
                  throw new k("Invalid value for attribute patternContentUnits");
                case 40: 
                  if ("objectBoundingBox".equals(str))
                  {
                    paramy.a = localBoolean;
                    break;
                  }
                  if ("userSpaceOnUse".equals(str))
                  {
                    paramy.a = Boolean.valueOf(true);
                    break;
                  }
                  throw new k("Invalid value for attribute patternUnits");
                }
              } else if (("".equals(paramAttributes.getURI(j))) || ("http://www.w3.org/1999/xlink".equals(paramAttributes.getURI(j)))) {
                paramy.h = str;
              }
            }
            else
            {
              paramy.g = a(str);
              if (paramy.g.c()) {
                throw new k("Invalid <pattern> element. height cannot be negative");
              }
            }
          }
          else
          {
            paramy.f = a(str);
            if (paramy.f.c()) {
              throw new k("Invalid <pattern> element. width cannot be negative");
            }
          }
        }
        else {
          paramy.e = a(str);
        }
      }
      else {
        paramy.d = a(str);
      }
      j += 1;
    }
  }
  
  private void a(h.z paramz, Attributes paramAttributes, String paramString)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      if (l.f.a(paramAttributes.getLocalName(j)) == l.f.V)
      {
        Object localObject = new l.h(paramAttributes.getValue(j));
        ArrayList localArrayList = new ArrayList();
        ((l.h)localObject).g();
        float f1;
        while (!((l.h)localObject).f())
        {
          f1 = ((l.h)localObject).i();
          if (!Float.isNaN(f1))
          {
            ((l.h)localObject).h();
            float f2 = ((l.h)localObject).i();
            if (!Float.isNaN(f2))
            {
              ((l.h)localObject).h();
              localArrayList.add(Float.valueOf(f1));
              localArrayList.add(Float.valueOf(f2));
            }
            else
            {
              paramz = new StringBuilder();
              paramz.append("Invalid <");
              paramz.append(paramString);
              paramz.append("> points attribute. There should be an even number of coordinates.");
              throw new k(paramz.toString());
            }
          }
          else
          {
            paramz = new StringBuilder();
            paramz.append("Invalid <");
            paramz.append(paramString);
            paramz.append("> points attribute. Non-coordinate content found in list.");
            throw new k(paramz.toString());
          }
        }
        paramz.a = new float[localArrayList.size()];
        localObject = localArrayList.iterator();
        int k = 0;
        while (((Iterator)localObject).hasNext())
        {
          f1 = ((Float)((Iterator)localObject).next()).floatValue();
          paramz.a[k] = f1;
          k += 1;
        }
      }
      j += 1;
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    try
    {
      localXmlPullParser = Xml.newPullParser();
      locali = new l.i(this, localXmlPullParser);
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      localXmlPullParser.setInput(paramInputStream, null);
      j = localXmlPullParser.getEventType();
    }
    catch (IOException paramInputStream)
    {
      XmlPullParser localXmlPullParser;
      l.i locali;
      String str;
      throw new k("Stream error", paramInputStream);
    }
    catch (XmlPullParserException paramInputStream)
    {
      for (;;)
      {
        int j;
        label295:
        paramInputStream = new k("XML parser problem", paramInputStream);
        for (;;)
        {
          throw paramInputStream;
        }
        label345:
        if (j != 1) {
          if (j != 0) {
            if (j != 8) {
              if (j != 2) {
                if (j != 3) {
                  if (j != 4) {
                    if (j == 5) {}
                  }
                }
              }
            }
          }
        }
      }
    }
    d(localXmlPullParser.getText());
    break label295;
    paramInputStream = new int[2];
    a(localXmlPullParser.getTextCharacters(paramInputStream), paramInputStream[0], paramInputStream[1]);
    break label295;
    str = localXmlPullParser.getName();
    paramInputStream = str;
    if (localXmlPullParser.getPrefix() != null)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append(localXmlPullParser.getPrefix());
      paramInputStream.append(':');
      paramInputStream.append(str);
      paramInputStream = paramInputStream.toString();
    }
    a(localXmlPullParser.getNamespace(), localXmlPullParser.getName(), paramInputStream);
    break label295;
    str = localXmlPullParser.getName();
    paramInputStream = str;
    if (localXmlPullParser.getPrefix() != null)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append(localXmlPullParser.getPrefix());
      paramInputStream.append(':');
      paramInputStream.append(str);
      paramInputStream = paramInputStream.toString();
    }
    a(localXmlPullParser.getNamespace(), localXmlPullParser.getName(), paramInputStream, locali);
    break label295;
    paramInputStream = new l.h(localXmlPullParser.getText());
    a(paramInputStream.o(), a(paramInputStream));
    break label295;
    a();
    j = localXmlPullParser.nextToken();
    break label345;
    b();
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.c)
    {
      j = this.d - 1;
      this.d = j;
      if (j == 0) {
        this.c = false;
      }
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1))) {
      return;
    }
    if (paramString2.length() <= 0) {
      paramString2 = paramString3;
    }
    int j = l.1.a[l.g.a(paramString2).ordinal()];
    if ((j != 1) && (j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 13) && (j != 14)) {}
    switch (j)
    {
    default: 
      return;
    case 30: 
      paramString1 = this.i;
      if (paramString1 != null)
      {
        this.h = false;
        H(paramString1.toString());
        this.i.setLength(0);
        return;
      }
      break;
    case 22: 
    case 23: 
      this.e = false;
      if (this.g != null)
      {
        if (this.f == l.g.A) {
          this.a.b(this.g.toString());
        } else if (this.f == l.g.f) {
          this.a.c(this.g.toString());
        }
        this.g.setLength(0);
      }
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 31: 
      paramString1 = this.b;
      if (paramString1 == null) {
        break label329;
      }
      this.b = ((h.an)paramString1).v;
    }
    return;
    label329:
    throw new k(String.format("Unbalanced end element </%s> found", new Object[] { paramString2 }));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (this.c)
    {
      this.d += 1;
      return;
    }
    if ((!"http://www.w3.org/2000/svg".equals(paramString1)) && (!"".equals(paramString1))) {
      return;
    }
    if (paramString2.length() <= 0) {
      paramString2 = paramString3;
    }
    paramString1 = l.g.a(paramString2);
    switch (l.1.a[paramString1.ordinal()])
    {
    default: 
      this.c = true;
      this.d = 1;
      return;
    case 31: 
      w(paramAttributes);
      return;
    case 30: 
      C(paramAttributes);
      return;
    case 29: 
      B(paramAttributes);
      return;
    case 28: 
      A(paramAttributes);
      return;
    case 27: 
      f(paramAttributes);
      return;
    case 26: 
      z(paramAttributes);
      return;
    case 25: 
      y(paramAttributes);
      return;
    case 24: 
      x(paramAttributes);
      return;
    case 22: 
    case 23: 
      this.e = true;
      this.f = paramString1;
      return;
    case 21: 
      v(paramAttributes);
      return;
    case 20: 
      u(paramAttributes);
      return;
    case 19: 
      t(paramAttributes);
      return;
    case 18: 
      s(paramAttributes);
      return;
    case 17: 
      r(paramAttributes);
      return;
    case 16: 
      q(paramAttributes);
      return;
    case 15: 
      p(paramAttributes);
      return;
    case 14: 
      o(paramAttributes);
      return;
    case 13: 
      n(paramAttributes);
      return;
    case 12: 
      m(paramAttributes);
      return;
    case 11: 
      l(paramAttributes);
      return;
    case 10: 
      k(paramAttributes);
      return;
    case 9: 
      j(paramAttributes);
      return;
    case 8: 
      i(paramAttributes);
      return;
    case 7: 
      h(paramAttributes);
      return;
    case 6: 
      g(paramAttributes);
      return;
    case 5: 
      e(paramAttributes);
      return;
    case 4: 
      d(paramAttributes);
      return;
    case 3: 
      c(paramAttributes);
      return;
    case 2: 
      b(paramAttributes);
      return;
    }
    a(paramAttributes);
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    if ((paramString.equals("xml-stylesheet")) && (h.h() != null))
    {
      if (((String)paramMap.get("type") != null) && (!"text/css".equals(paramMap.get("type")))) {
        return;
      }
      if (((String)paramMap.get("alternate") != null) && (!"no".equals(paramMap.get("alternate")))) {
        return;
      }
      paramString = (String)paramMap.get("href");
      if (paramString != null)
      {
        String str = h.h().b(paramString);
        if (str == null) {
          return;
        }
        paramMap = (String)paramMap.get("media");
        paramString = str;
        if (paramMap != null)
        {
          paramString = str;
          if (!"all".equals(paramMap.trim()))
          {
            paramString = new StringBuilder();
            paramString.append("@media ");
            paramString.append(paramMap);
            paramString.append(" { ");
            paramString.append(str);
            paramString.append("}");
            paramString = paramString.toString();
          }
        }
        H(paramString);
      }
    }
  }
  
  private void a(String paramString, Object... paramVarArgs) {}
  
  private void a(Attributes paramAttributes)
  {
    a("<svg>", new Object[0]);
    h.af localaf = new h.af();
    localaf.u = this.a;
    localaf.v = this.b;
    a(localaf, paramAttributes);
    b(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    a(localaf, paramAttributes);
    paramAttributes = this.b;
    if (paramAttributes == null) {
      this.a.a(localaf);
    } else {
      paramAttributes.a(localaf);
    }
    this.b = localaf;
  }
  
  private void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.c) {
      return;
    }
    if (this.e)
    {
      if (this.g == null) {
        this.g = new StringBuilder(paramInt2);
      }
      this.g.append(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    if (this.h)
    {
      if (this.i == null) {
        this.i = new StringBuilder(paramInt2);
      }
      this.i.append(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    if ((this.b instanceof h.ay)) {
      e(new String(paramArrayOfChar, paramInt1, paramInt2));
    }
  }
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat3;
    if (paramFloat3 < 0.0F) {
      f1 = paramFloat3 + 6.0F;
    }
    paramFloat3 = f1;
    if (f1 >= 6.0F) {
      paramFloat3 = f1 - 6.0F;
    }
    if (paramFloat3 < 1.0F) {}
    for (paramFloat2 = (paramFloat2 - paramFloat1) * paramFloat3;; paramFloat2 = (paramFloat2 - paramFloat1) * (4.0F - paramFloat3))
    {
      return paramFloat2 + paramFloat1;
      if (paramFloat3 < 3.0F) {
        return paramFloat2;
      }
      if (paramFloat3 >= 4.0F) {
        break;
      }
    }
    return paramFloat1;
  }
  
  static f b(String paramString)
  {
    l.h localh = new l.h(paramString);
    localh.g();
    Object localObject2 = localh.o();
    Object localObject1 = localObject2;
    if ("defer".equals(localObject2))
    {
      localh.g();
      localObject1 = localh.o();
    }
    localObject2 = l.a.a((String)localObject1);
    localObject1 = null;
    localh.g();
    if (!localh.f())
    {
      localObject1 = localh.o();
      int j = -1;
      int k = ((String)localObject1).hashCode();
      if (k != 3347527)
      {
        if ((k == 109526418) && (((String)localObject1).equals("slice"))) {
          j = 1;
        }
      }
      else if (((String)localObject1).equals("meet")) {
        j = 0;
      }
      if (j != 0)
      {
        if (j == 1)
        {
          localObject1 = f.b.b;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Invalid preserveAspectRatio definition: ");
          ((StringBuilder)localObject1).append(paramString);
          throw new k(((StringBuilder)localObject1).toString());
        }
      }
      else {
        localObject1 = f.b.a;
      }
    }
    return new f((f.a)localObject2, (f.b)localObject1);
  }
  
  private static h.p b(l.h paramh)
  {
    if (paramh.a("auto")) {
      return new h.p(0.0F);
    }
    return paramh.l();
  }
  
  private void b() {}
  
  private void b(h.al paramal, Attributes paramAttributes)
  {
    int j = 0;
    while (j < paramAttributes.getLength())
    {
      String str = paramAttributes.getValue(j).trim();
      if (str.length() != 0)
      {
        int k = l.1.b[l.f.a(paramAttributes.getLocalName(j)).ordinal()];
        if (k != 45)
        {
          if (k != 46)
          {
            if (paramal.r == null) {
              paramal.r = new h.ae();
            }
            a(paramal.r, paramAttributes.getLocalName(j), paramAttributes.getValue(j).trim());
          }
          else
          {
            paramal.t = b.b(str);
          }
        }
        else {
          a(paramal, str);
        }
      }
      j += 1;
    }
  }
  
  private void b(InputStream paramInputStream)
  {
    try
    {
      Object localObject = SAXParserFactory.newInstance();
      ((SAXParserFactory)localObject).setFeature("http://xml.org/sax/features/external-general-entities", false);
      ((SAXParserFactory)localObject).setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      localObject = ((SAXParserFactory)localObject).newSAXParser().getXMLReader();
      l.e locale = new l.e(this, null);
      ((XMLReader)localObject).setContentHandler(locale);
      ((XMLReader)localObject).setProperty("http://xml.org/sax/properties/lexical-handler", locale);
      ((XMLReader)localObject).parse(new InputSource(paramInputStream));
      return;
    }
    catch (IOException paramInputStream)
    {
      throw new k("Stream error", paramInputStream);
    }
    catch (SAXException paramInputStream)
    {
      throw new k("SVG parse error", paramInputStream);
    }
    catch (ParserConfigurationException paramInputStream)
    {
      throw new k("XML parser problem", paramInputStream);
    }
  }
  
  private void b(Attributes paramAttributes)
  {
    a("<g>", new Object[0]);
    if (this.b != null)
    {
      h.m localm = new h.m();
      localm.u = this.a;
      localm.v = this.b;
      a(localm, paramAttributes);
      b(localm, paramAttributes);
      a(localm, paramAttributes);
      a(localm, paramAttributes);
      this.b.a(localm);
      this.b = localm;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  protected static h.w c(String paramString)
  {
    Object localObject = new l.h(paramString);
    paramString = new h.w();
    if (((l.h)localObject).f()) {
      return paramString;
    }
    int j = ((l.h)localObject).k().intValue();
    if ((j != 77) && (j != 109)) {
      return paramString;
    }
    float f7 = 0.0F;
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    float f6 = 0.0F;
    for (;;)
    {
      ((l.h)localObject).g();
      int k = 108;
      switch (j)
      {
      default: 
        return paramString;
      case 90: 
      case 122: 
        paramString.b();
        f1 = f5;
        f2 = f1;
        f3 = f6;
        f4 = f3;
      case 86: 
      case 118: 
      case 84: 
      case 116: 
      case 83: 
      case 115: 
      case 81: 
      case 113: 
      case 77: 
      case 109: 
      case 76: 
      case 108: 
      case 72: 
      case 104: 
      case 67: 
      case 99: 
        for (;;)
        {
          f7 = f1;
          f1 = f2;
          break;
          f2 = ((l.h)localObject).i();
          if (Float.isNaN(f2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f4 = f2;
          if (j == 118) {
            f4 = f2 + f3;
          }
          paramString.b(f7, f4);
          f2 = f1;
          break label1095;
          f8 = f7 * 2.0F - f1;
          f4 = 2.0F * f3 - f4;
          f10 = ((l.h)localObject).i();
          f9 = ((l.h)localObject).a(f10);
          if (Float.isNaN(f9))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f2 = f10;
          f1 = f9;
          if (j == 116)
          {
            f2 = f10 + f7;
            f1 = f9 + f3;
          }
          paramString.a(f8, f4, f2, f1);
          f3 = f1;
          f7 = f8;
          f1 = f2;
          f2 = f7;
          continue;
          float f12 = ((l.h)localObject).i();
          f11 = ((l.h)localObject).a(f12);
          float f14 = ((l.h)localObject).a(f11);
          float f13 = ((l.h)localObject).a(f14);
          if (Float.isNaN(f13))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f10 = f12;
          f8 = f11;
          f9 = f14;
          f2 = f13;
          if (j == 115)
          {
            f9 = f14 + f7;
            f2 = f13 + f3;
            f10 = f12 + f7;
            f8 = f11 + f3;
          }
          paramString.a(f7 * 2.0F - f1, 2.0F * f3 - f4, f10, f8, f9, f2);
          f7 = f10;
          f4 = f8;
          f3 = f9;
          f1 = f2;
          break label1391;
          f10 = ((l.h)localObject).i();
          f9 = ((l.h)localObject).a(f10);
          f12 = ((l.h)localObject).a(f9);
          f11 = ((l.h)localObject).a(f12);
          if (Float.isNaN(f11))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f2 = f10;
          f4 = f9;
          f8 = f12;
          f1 = f11;
          if (j == 113)
          {
            f8 = f12 + f7;
            f1 = f11 + f3;
            f2 = f10 + f7;
            f4 = f9 + f3;
          }
          paramString.a(f2, f4, f8, f1);
          f3 = f1;
          f1 = f8;
          continue;
          f5 = ((l.h)localObject).i();
          f1 = ((l.h)localObject).a(f5);
          if (Float.isNaN(f1))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f2 = f5;
          f4 = f1;
          if (j == 109)
          {
            f2 = f5;
            f4 = f1;
            if (!paramString.a())
            {
              f2 = f5 + f7;
              f4 = f1 + f3;
            }
          }
          paramString.a(f2, f4);
          if (j == 109) {
            j = k;
          } else {
            j = 76;
          }
          f1 = f2;
          f5 = f1;
          f3 = f4;
          f6 = f3;
          continue;
          f8 = ((l.h)localObject).i();
          f2 = ((l.h)localObject).a(f8);
          if (Float.isNaN(f2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f1 = f8;
          f4 = f2;
          if (j == 108)
          {
            f1 = f8 + f7;
            f4 = f2 + f3;
          }
          paramString.b(f1, f4);
          f7 = f1;
          f2 = f1;
          label1095:
          f3 = f4;
          f1 = f7;
          continue;
          f1 = ((l.h)localObject).i();
          if (Float.isNaN(f1))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f2 = f1;
          if (j == 104) {
            f2 = f1 + f7;
          }
          paramString.b(f2, f3);
          f1 = f2;
          continue;
          f14 = ((l.h)localObject).i();
          f13 = ((l.h)localObject).a(f14);
          f12 = ((l.h)localObject).a(f13);
          f11 = ((l.h)localObject).a(f12);
          float f16 = ((l.h)localObject).a(f11);
          float f15 = ((l.h)localObject).a(f16);
          if (Float.isNaN(f15))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad path coords for ");
            ((StringBuilder)localObject).append((char)j);
            ((StringBuilder)localObject).append(" path segment");
            Log.e("SVGParser", ((StringBuilder)localObject).toString());
            return paramString;
          }
          f10 = f14;
          f9 = f13;
          f8 = f12;
          f2 = f11;
          f4 = f16;
          f1 = f15;
          if (j == 99)
          {
            f4 = f16 + f7;
            f1 = f15 + f3;
            f10 = f14 + f7;
            f9 = f13 + f3;
            f8 = f12 + f7;
            f2 = f11 + f3;
          }
          f7 = f8;
          f3 = f4;
          paramString.a(f10, f9, f7, f2, f3, f1);
          f4 = f2;
          label1391:
          f2 = f7;
          f7 = f3;
          f3 = f1;
          f1 = f7;
        }
      }
      float f9 = ((l.h)localObject).i();
      float f10 = ((l.h)localObject).a(f9);
      float f11 = ((l.h)localObject).a(f10);
      Boolean localBoolean1 = ((l.h)localObject).a(Float.valueOf(f11));
      Boolean localBoolean2 = ((l.h)localObject).a(localBoolean1);
      float f8 = ((l.h)localObject).a(localBoolean2);
      f4 = ((l.h)localObject).a(f8);
      if ((Float.isNaN(f4)) || (f9 < 0.0F) || (f10 < 0.0F)) {
        break;
      }
      float f2 = f8;
      f1 = f4;
      if (j == 97)
      {
        f2 = f8 + f7;
        f1 = f4 + f3;
      }
      paramString.a(f9, f10, f11, localBoolean1.booleanValue(), localBoolean2.booleanValue(), f2, f1);
      f7 = f2;
      f4 = f1;
      f3 = f1;
      f1 = f7;
      f7 = f2;
      ((l.h)localObject).h();
      if (((l.h)localObject).f()) {
        return paramString;
      }
      if (((l.h)localObject).t()) {
        j = ((l.h)localObject).k().intValue();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad path coords for ");
    ((StringBuilder)localObject).append((char)j);
    ((StringBuilder)localObject).append(" path segment");
    Log.e("SVGParser", ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  private void c(Attributes paramAttributes)
  {
    a("<defs>", new Object[0]);
    if (this.b != null)
    {
      h.h localh = new h.h();
      localh.u = this.a;
      localh.v = this.b;
      a(localh, paramAttributes);
      b(localh, paramAttributes);
      a(localh, paramAttributes);
      this.b.a(localh);
      this.b = localh;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private void d(String paramString)
  {
    if (this.c) {
      return;
    }
    if (this.e)
    {
      if (this.g == null) {
        this.g = new StringBuilder(paramString.length());
      }
      this.g.append(paramString);
      return;
    }
    if (this.h)
    {
      if (this.i == null) {
        this.i = new StringBuilder(paramString.length());
      }
      this.i.append(paramString);
      return;
    }
    if ((this.b instanceof h.ay)) {
      e(paramString);
    }
  }
  
  private void d(Attributes paramAttributes)
  {
    a("<a>", new Object[0]);
    if (this.b != null)
    {
      h.a locala = new h.a();
      locala.u = this.a;
      locala.v = this.b;
      a(locala, paramAttributes);
      b(locala, paramAttributes);
      a(locala, paramAttributes);
      a(locala, paramAttributes);
      a(locala, paramAttributes);
      this.b.a(locala);
      this.b = locala;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private void e(String paramString)
  {
    Object localObject = (h.ah)this.b;
    int j = ((h.ah)localObject).i.size();
    if (j == 0) {
      localObject = null;
    } else {
      localObject = (h.an)((h.ah)localObject).i.get(j - 1);
    }
    if ((localObject instanceof h.bc))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = (h.bc)localObject;
      localStringBuilder.append(((h.bc)localObject).a);
      localStringBuilder.append(paramString);
      ((h.bc)localObject).a = localStringBuilder.toString();
      return;
    }
    this.b.a(new h.bc(paramString));
  }
  
  private void e(Attributes paramAttributes)
  {
    a("<use>", new Object[0]);
    if (this.b != null)
    {
      h.be localbe = new h.be();
      localbe.u = this.a;
      localbe.v = this.b;
      a(localbe, paramAttributes);
      b(localbe, paramAttributes);
      a(localbe, paramAttributes);
      a(localbe, paramAttributes);
      a(localbe, paramAttributes);
      this.b.a(localbe);
      this.b = localbe;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private Float f(String paramString)
  {
    int j;
    int k;
    if (paramString.length() != 0)
    {
      j = paramString.length();
      int m = paramString.length();
      k = 1;
      if (paramString.charAt(m - 1) == '%') {
        j -= 1;
      } else {
        k = 0;
      }
    }
    for (;;)
    {
      float f2;
      float f1;
      try
      {
        f2 = a(paramString, 0, j);
        f1 = f2;
        if (k == 0) {
          break label129;
        }
        f1 = f2 / 100.0F;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid offset value in <stop>: ");
        localStringBuilder.append(paramString);
        throw new k(localStringBuilder.toString(), localNumberFormatException);
      }
      return Float.valueOf(f2);
      throw new k("Invalid offset value in <stop> (empty string)");
      label129:
      if (f1 < 0.0F)
      {
        f2 = 0.0F;
      }
      else
      {
        f2 = f1;
        if (f1 > 100.0F) {
          f2 = 100.0F;
        }
      }
    }
  }
  
  private void f(Attributes paramAttributes)
  {
    a("<image>", new Object[0]);
    if (this.b != null)
    {
      h.o localo = new h.o();
      localo.u = this.a;
      localo.v = this.b;
      a(localo, paramAttributes);
      b(localo, paramAttributes);
      a(localo, paramAttributes);
      a(localo, paramAttributes);
      a(localo, paramAttributes);
      this.b.a(localo);
      this.b = localo;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private Matrix g(String paramString)
  {
    Object localObject1 = new Matrix();
    l.h localh = new l.h(paramString);
    localh.g();
    while (!localh.f())
    {
      Object localObject2 = localh.q();
      if (localObject2 != null)
      {
        int j = -1;
        switch (((String)localObject2).hashCode())
        {
        default: 
          break;
        case 1052832078: 
          if (((String)localObject2).equals("translate")) {
            j = 1;
          }
          break;
        case 109493391: 
          if (((String)localObject2).equals("skewY")) {
            j = 5;
          }
          break;
        case 109493390: 
          if (((String)localObject2).equals("skewX")) {
            j = 4;
          }
          break;
        case 109250890: 
          if (((String)localObject2).equals("scale")) {
            j = 2;
          }
          break;
        case -925180581: 
          if (((String)localObject2).equals("rotate")) {
            j = 3;
          }
          break;
        case -1081239615: 
          if (((String)localObject2).equals("matrix")) {
            j = 0;
          }
          break;
        }
        float f1;
        float f2;
        float f3;
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j != 4)
                {
                  if (j == 5)
                  {
                    localh.g();
                    f1 = localh.i();
                    localh.g();
                    if ((!Float.isNaN(f1)) && (localh.a(')')))
                    {
                      ((Matrix)localObject1).preSkew(0.0F, (float)Math.tan(Math.toRadians(f1)));
                    }
                    else
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("Invalid transform list: ");
                      ((StringBuilder)localObject1).append(paramString);
                      throw new k(((StringBuilder)localObject1).toString());
                    }
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append("Invalid transform list fn: ");
                    paramString.append((String)localObject2);
                    paramString.append(")");
                    throw new k(paramString.toString());
                  }
                }
                else
                {
                  localh.g();
                  f1 = localh.i();
                  localh.g();
                  if ((!Float.isNaN(f1)) && (localh.a(')')))
                  {
                    ((Matrix)localObject1).preSkew((float)Math.tan(Math.toRadians(f1)), 0.0F);
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Invalid transform list: ");
                    ((StringBuilder)localObject1).append(paramString);
                    throw new k(((StringBuilder)localObject1).toString());
                  }
                }
              }
              else
              {
                localh.g();
                f1 = localh.i();
                f2 = localh.j();
                f3 = localh.j();
                localh.g();
                if ((!Float.isNaN(f1)) && (localh.a(')')))
                {
                  if (Float.isNaN(f2))
                  {
                    ((Matrix)localObject1).preRotate(f1);
                  }
                  else if (!Float.isNaN(f3))
                  {
                    ((Matrix)localObject1).preRotate(f1, f2, f3);
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Invalid transform list: ");
                    ((StringBuilder)localObject1).append(paramString);
                    throw new k(((StringBuilder)localObject1).toString());
                  }
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Invalid transform list: ");
                  ((StringBuilder)localObject1).append(paramString);
                  throw new k(((StringBuilder)localObject1).toString());
                }
              }
            }
            else
            {
              localh.g();
              f1 = localh.i();
              f2 = localh.j();
              localh.g();
              if ((!Float.isNaN(f1)) && (localh.a(')')))
              {
                if (Float.isNaN(f2)) {
                  ((Matrix)localObject1).preScale(f1, f1);
                } else {
                  ((Matrix)localObject1).preScale(f1, f2);
                }
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Invalid transform list: ");
                ((StringBuilder)localObject1).append(paramString);
                throw new k(((StringBuilder)localObject1).toString());
              }
            }
          }
          else
          {
            localh.g();
            f1 = localh.i();
            f2 = localh.j();
            localh.g();
            if ((!Float.isNaN(f1)) && (localh.a(')')))
            {
              if (Float.isNaN(f2)) {
                ((Matrix)localObject1).preTranslate(f1, 0.0F);
              } else {
                ((Matrix)localObject1).preTranslate(f1, f2);
              }
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Invalid transform list: ");
              ((StringBuilder)localObject1).append(paramString);
              throw new k(((StringBuilder)localObject1).toString());
            }
          }
        }
        else
        {
          localh.g();
          f1 = localh.i();
          localh.h();
          f2 = localh.i();
          localh.h();
          f3 = localh.i();
          localh.h();
          float f4 = localh.i();
          localh.h();
          float f5 = localh.i();
          localh.h();
          float f6 = localh.i();
          localh.g();
          if ((Float.isNaN(f6)) || (!localh.a(')'))) {
            break label1031;
          }
          localObject2 = new Matrix();
          ((Matrix)localObject2).setValues(new float[] { f1, f3, f5, f2, f4, f6, 0.0F, 0.0F, 1.0F });
          ((Matrix)localObject1).preConcat((Matrix)localObject2);
        }
        if (localh.f()) {
          return localObject1;
        }
        localh.h();
        continue;
        label1031:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid transform list: ");
        ((StringBuilder)localObject1).append(paramString);
        throw new k(((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Bad transform function encountered in transform list: ");
        ((StringBuilder)localObject1).append(paramString);
        throw new k(((StringBuilder)localObject1).toString());
      }
    }
    return localObject1;
  }
  
  private void g(Attributes paramAttributes)
  {
    a("<path>", new Object[0]);
    if (this.b != null)
    {
      h.v localv = new h.v();
      localv.u = this.a;
      localv.v = this.b;
      a(localv, paramAttributes);
      b(localv, paramAttributes);
      a(localv, paramAttributes);
      a(localv, paramAttributes);
      a(localv, paramAttributes);
      this.b.a(localv);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static List<h.p> h(String paramString)
  {
    if (paramString.length() != 0)
    {
      ArrayList localArrayList = new ArrayList(1);
      l.h localh = new l.h(paramString);
      localh.g();
      while (!localh.f())
      {
        float f1 = localh.i();
        if (!Float.isNaN(f1))
        {
          h.bd localbd = localh.s();
          paramString = localbd;
          if (localbd == null) {
            paramString = h.bd.a;
          }
          localArrayList.add(new h.p(f1, paramString));
          localh.h();
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("Invalid length list value: ");
          paramString.append(localh.r());
          throw new k(paramString.toString());
        }
      }
      return localArrayList;
    }
    paramString = new k("Invalid length list (empty string)");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void h(Attributes paramAttributes)
  {
    a("<rect>", new Object[0]);
    if (this.b != null)
    {
      h.ab localab = new h.ab();
      localab.u = this.a;
      localab.v = this.b;
      a(localab, paramAttributes);
      b(localab, paramAttributes);
      a(localab, paramAttributes);
      a(localab, paramAttributes);
      a(localab, paramAttributes);
      this.b.a(localab);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static float i(String paramString)
  {
    int j = paramString.length();
    if (j != 0) {
      return a(paramString, 0, j);
    }
    throw new k("Invalid float value (empty string)");
  }
  
  private void i(Attributes paramAttributes)
  {
    a("<circle>", new Object[0]);
    if (this.b != null)
    {
      h.d locald = new h.d();
      locald.u = this.a;
      locald.v = this.b;
      a(locald, paramAttributes);
      b(locald, paramAttributes);
      a(locald, paramAttributes);
      a(locald, paramAttributes);
      a(locald, paramAttributes);
      this.b.a(locald);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static Float j(String paramString)
  {
    try
    {
      f2 = i(paramString);
      if (f2 >= 0.0F) {
        break label27;
      }
      f1 = 0.0F;
    }
    catch (k paramString)
    {
      for (;;)
      {
        float f2;
        continue;
        label27:
        float f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
      }
    }
    return Float.valueOf(f1);
    return null;
  }
  
  private void j(Attributes paramAttributes)
  {
    a("<ellipse>", new Object[0]);
    if (this.b != null)
    {
      h.i locali = new h.i();
      locali.u = this.a;
      locali.v = this.b;
      a(locali, paramAttributes);
      b(locali, paramAttributes);
      a(locali, paramAttributes);
      a(locali, paramAttributes);
      a(locali, paramAttributes);
      this.b.a(locali);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.b k(String paramString)
  {
    paramString = new l.h(paramString);
    paramString.g();
    float f1 = paramString.i();
    paramString.h();
    float f2 = paramString.i();
    paramString.h();
    float f3 = paramString.i();
    paramString.h();
    float f4 = paramString.i();
    if ((!Float.isNaN(f1)) && (!Float.isNaN(f2)) && (!Float.isNaN(f3)) && (!Float.isNaN(f4)))
    {
      if (f3 >= 0.0F)
      {
        if (f4 >= 0.0F) {
          return new h.b(f1, f2, f3, f4);
        }
        throw new k("Invalid viewBox. height cannot be negative");
      }
      throw new k("Invalid viewBox. width cannot be negative");
    }
    throw new k("Invalid viewBox definition - should have four numbers");
  }
  
  private void k(Attributes paramAttributes)
  {
    a("<line>", new Object[0]);
    if (this.b != null)
    {
      h.q localq = new h.q();
      localq.u = this.a;
      localq.v = this.b;
      a(localq, paramAttributes);
      b(localq, paramAttributes);
      a(localq, paramAttributes);
      a(localq, paramAttributes);
      a(localq, paramAttributes);
      this.b.a(localq);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ao l(String paramString)
  {
    if (paramString.startsWith("url("))
    {
      int j = paramString.indexOf(")");
      Object localObject = null;
      if (j != -1)
      {
        String str1 = paramString.substring(4, j).trim();
        String str2 = paramString.substring(j + 1).trim();
        paramString = localObject;
        if (str2.length() > 0) {
          paramString = m(str2);
        }
        return new h.u(str1, paramString);
      }
      return new h.u(paramString.substring(4).trim(), null);
    }
    return m(paramString);
  }
  
  private void l(Attributes paramAttributes)
  {
    a("<polyline>", new Object[0]);
    if (this.b != null)
    {
      h.z localz = new h.z();
      localz.u = this.a;
      localz.v = this.b;
      a(localz, paramAttributes);
      b(localz, paramAttributes);
      a(localz, paramAttributes);
      a(localz, paramAttributes);
      a(localz, paramAttributes, "polyline");
      this.b.a(localz);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ao m(String paramString)
  {
    int j = paramString.hashCode();
    if (j != 3387192)
    {
      if ((j == 1442907498) && (paramString.equals("currentColor")))
      {
        j = 1;
        break label52;
      }
    }
    else if (paramString.equals("none"))
    {
      j = 0;
      break label52;
    }
    j = -1;
    label52:
    if ((j == 0) || (j != 1)) {}
    try
    {
      paramString = n(paramString);
      return paramString;
    }
    catch (k paramString)
    {
      label68:
      break label68;
    }
    return null;
    return h.g.a();
    return h.f.c;
  }
  
  private void m(Attributes paramAttributes)
  {
    a("<polygon>", new Object[0]);
    if (this.b != null)
    {
      h.aa localaa = new h.aa();
      localaa.u = this.a;
      localaa.v = this.b;
      a(localaa, paramAttributes);
      b(localaa, paramAttributes);
      a(localaa, paramAttributes);
      a(localaa, paramAttributes);
      a(localaa, paramAttributes, "polygon");
      this.b.a(localaa);
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.f n(String paramString)
  {
    int k = paramString.charAt(0);
    int j = 5;
    if (k == 35)
    {
      localObject = d.a(paramString, 1, paramString.length());
      if (localObject != null)
      {
        j = ((d)localObject).a();
        if (j != 4)
        {
          if (j != 5)
          {
            if (j != 7)
            {
              if (j == 9)
              {
                j = ((d)localObject).b();
                return new h.f(((d)localObject).b() >>> 8 | j << 24);
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Bad hex colour value: ");
              ((StringBuilder)localObject).append(paramString);
              throw new k(((StringBuilder)localObject).toString());
            }
            return new h.f(((d)localObject).b() | 0xFF000000);
          }
          int n = ((d)localObject).b();
          j = 0xF000 & n;
          k = n & 0xF00;
          m = n & 0xF0;
          n &= 0xF;
          return new h.f(n << 24 | n << 28 | j << 8 | j << 4 | k << 4 | k | m | m >> 4);
        }
        int m = ((d)localObject).b();
        j = m & 0xF00;
        k = m & 0xF0;
        m &= 0xF;
        return new h.f(m | j << 8 | 0xFF000000 | j << 12 | k << 8 | k << 4 | m << 4);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad hex colour value: ");
      ((StringBuilder)localObject).append(paramString);
      throw new k(((StringBuilder)localObject).toString());
    }
    Object localObject = paramString.toLowerCase(Locale.US);
    boolean bool = ((String)localObject).startsWith("rgba(");
    if ((!bool) && (!((String)localObject).startsWith("rgb(")))
    {
      bool = ((String)localObject).startsWith("hsla(");
      if ((!bool) && (!((String)localObject).startsWith("hsl("))) {
        return o((String)localObject);
      }
      if (!bool) {
        j = 4;
      }
      localObject = new l.h(paramString.substring(j));
      ((l.h)localObject).g();
      f1 = ((l.h)localObject).i();
      f2 = ((l.h)localObject).a(f1);
      if (!Float.isNaN(f2)) {
        ((l.h)localObject).a('%');
      }
      f3 = ((l.h)localObject).a(f2);
      if (!Float.isNaN(f3)) {
        ((l.h)localObject).a('%');
      }
      if (bool)
      {
        f4 = ((l.h)localObject).a(f3);
        ((l.h)localObject).g();
        if ((!Float.isNaN(f4)) && (((l.h)localObject).a(')'))) {
          return new h.f(a(f4 * 256.0F) << 24 | a(f1, f2, f3));
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Bad hsla() colour value: ");
        ((StringBuilder)localObject).append(paramString);
        throw new k(((StringBuilder)localObject).toString());
      }
      ((l.h)localObject).g();
      if ((!Float.isNaN(f3)) && (((l.h)localObject).a(')'))) {
        return new h.f(a(f1, f2, f3) | 0xFF000000);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad hsl() colour value: ");
      ((StringBuilder)localObject).append(paramString);
      throw new k(((StringBuilder)localObject).toString());
    }
    if (!bool) {
      j = 4;
    }
    localObject = new l.h(paramString.substring(j));
    ((l.h)localObject).g();
    float f2 = ((l.h)localObject).i();
    float f1 = f2;
    if (!Float.isNaN(f2))
    {
      f1 = f2;
      if (((l.h)localObject).a('%')) {
        f1 = f2 * 256.0F / 100.0F;
      }
    }
    float f3 = ((l.h)localObject).a(f1);
    f2 = f3;
    if (!Float.isNaN(f3))
    {
      f2 = f3;
      if (((l.h)localObject).a('%')) {
        f2 = f3 * 256.0F / 100.0F;
      }
    }
    float f4 = ((l.h)localObject).a(f2);
    f3 = f4;
    if (!Float.isNaN(f4))
    {
      f3 = f4;
      if (((l.h)localObject).a('%')) {
        f3 = f4 * 256.0F / 100.0F;
      }
    }
    if (bool)
    {
      f4 = ((l.h)localObject).a(f3);
      ((l.h)localObject).g();
      if ((!Float.isNaN(f4)) && (((l.h)localObject).a(')'))) {
        return new h.f(a(f4 * 256.0F) << 24 | a(f1) << 16 | a(f2) << 8 | a(f3));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad rgba() colour value: ");
      ((StringBuilder)localObject).append(paramString);
      throw new k(((StringBuilder)localObject).toString());
    }
    ((l.h)localObject).g();
    if ((!Float.isNaN(f3)) && (((l.h)localObject).a(')'))) {
      return new h.f(a(f1) << 16 | 0xFF000000 | a(f2) << 8 | a(f3));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad rgb() colour value: ");
    ((StringBuilder)localObject).append(paramString);
    throw new k(((StringBuilder)localObject).toString());
  }
  
  private void n(Attributes paramAttributes)
  {
    a("<text>", new Object[0]);
    if (this.b != null)
    {
      h.aw localaw = new h.aw();
      localaw.u = this.a;
      localaw.v = this.b;
      a(localaw, paramAttributes);
      b(localaw, paramAttributes);
      a(localaw, paramAttributes);
      a(localaw, paramAttributes);
      a(localaw, paramAttributes);
      this.b.a(localaw);
      this.b = localaw;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.f o(String paramString)
  {
    Object localObject = l.b.a(paramString);
    if (localObject != null) {
      return new h.f(((Integer)localObject).intValue());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid colour keyword: ");
    ((StringBuilder)localObject).append(paramString);
    throw new k(((StringBuilder)localObject).toString());
  }
  
  private void o(Attributes paramAttributes)
  {
    a("<tspan>", new Object[0]);
    Object localObject = this.b;
    if (localObject != null)
    {
      if ((localObject instanceof h.ay))
      {
        localObject = new h.av();
        ((h.av)localObject).u = this.a;
        ((h.av)localObject).v = this.b;
        a((h.al)localObject, paramAttributes);
        b((h.al)localObject, paramAttributes);
        a((h.ag)localObject, paramAttributes);
        a((h.ba)localObject, paramAttributes);
        this.b.a((h.an)localObject);
        this.b = ((h.aj)localObject);
        if ((((h.av)localObject).v instanceof h.bb))
        {
          ((h.av)localObject).a((h.bb)((h.av)localObject).v);
          return;
        }
        ((h.av)localObject).a(((h.ax)((h.av)localObject).v).h());
        return;
      }
      throw new k("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static List<String> p(String paramString)
  {
    l.h localh = new l.h(paramString);
    paramString = null;
    Object localObject2;
    do
    {
      localObject2 = localh.u();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localh.c(',');
      }
      if (localObject1 == null) {
        return paramString;
      }
      localObject2 = paramString;
      if (paramString == null) {
        localObject2 = new ArrayList();
      }
      ((List)localObject2).add(localObject1);
      localh.h();
      paramString = (String)localObject2;
    } while (!localh.f());
    return localObject2;
  }
  
  private void p(Attributes paramAttributes)
  {
    a("<tref>", new Object[0]);
    Object localObject = this.b;
    if (localObject != null)
    {
      if ((localObject instanceof h.ay))
      {
        localObject = new h.au();
        ((h.au)localObject).u = this.a;
        ((h.au)localObject).v = this.b;
        a((h.al)localObject, paramAttributes);
        b((h.al)localObject, paramAttributes);
        a((h.ag)localObject, paramAttributes);
        a((h.au)localObject, paramAttributes);
        this.b.a((h.an)localObject);
        if ((((h.au)localObject).v instanceof h.bb))
        {
          ((h.au)localObject).a((h.bb)((h.au)localObject).v);
          return;
        }
        ((h.au)localObject).a(((h.ax)((h.au)localObject).v).h());
        return;
      }
      throw new k("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.p q(String paramString)
  {
    try
    {
      h.p localp2 = l.c.a(paramString);
      h.p localp1 = localp2;
      if (localp2 == null) {
        localp1 = a(paramString);
      }
      return localp1;
    }
    catch (k paramString)
    {
      label18:
      break label18;
    }
    return null;
  }
  
  private void q(Attributes paramAttributes)
  {
    a("<switch>", new Object[0]);
    if (this.b != null)
    {
      h.as localas = new h.as();
      localas.u = this.a;
      localas.v = this.b;
      a(localas, paramAttributes);
      b(localas, paramAttributes);
      a(localas, paramAttributes);
      a(localas, paramAttributes);
      this.b.a(localas);
      this.b = localas;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static Integer r(String paramString)
  {
    return l.d.a(paramString);
  }
  
  private void r(Attributes paramAttributes)
  {
    a("<symbol>", new Object[0]);
    if (this.b != null)
    {
      h.at localat = new h.at();
      localat.u = this.a;
      localat.v = this.b;
      a(localat, paramAttributes);
      b(localat, paramAttributes);
      a(localat, paramAttributes);
      a(localat, paramAttributes);
      this.b.a(localat);
      this.b = localat;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.b s(String paramString)
  {
    int j = paramString.hashCode();
    if (j != -1657669071)
    {
      if (j != -1178781136)
      {
        if ((j == -1039745817) && (paramString.equals("normal")))
        {
          j = 1;
          break label76;
        }
      }
      else if (paramString.equals("italic"))
      {
        j = 0;
        break label76;
      }
    }
    else if (paramString.equals("oblique"))
    {
      j = 2;
      break label76;
    }
    j = -1;
    label76:
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return null;
        }
        return h.ae.b.c;
      }
      return h.ae.b.a;
    }
    return h.ae.b.b;
  }
  
  private void s(Attributes paramAttributes)
  {
    a("<marker>", new Object[0]);
    if (this.b != null)
    {
      h.r localr = new h.r();
      localr.u = this.a;
      localr.v = this.b;
      a(localr, paramAttributes);
      b(localr, paramAttributes);
      a(localr, paramAttributes);
      a(localr, paramAttributes);
      a(localr, paramAttributes);
      this.b.a(localr);
      this.b = localr;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.g t(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 529818312: 
      if (paramString.equals("overline")) {
        j = 2;
      }
      break;
    case 93826908: 
      if (paramString.equals("blink")) {
        j = 4;
      }
      break;
    case 3387192: 
      if (paramString.equals("none")) {
        j = 0;
      }
      break;
    case -1026963764: 
      if (paramString.equals("underline")) {
        j = 1;
      }
      break;
    case -1171789332: 
      if (paramString.equals("line-through")) {
        j = 3;
      }
      break;
    }
    int j = -1;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4) {
              return null;
            }
            return h.ae.g.e;
          }
          return h.ae.g.d;
        }
        return h.ae.g.c;
      }
      return h.ae.g.b;
    }
    return h.ae.g.a;
  }
  
  private void t(Attributes paramAttributes)
  {
    a("<linearGradient>", new Object[0]);
    if (this.b != null)
    {
      h.am localam = new h.am();
      localam.u = this.a;
      localam.v = this.b;
      a(localam, paramAttributes);
      b(localam, paramAttributes);
      a(localam, paramAttributes);
      a(localam, paramAttributes);
      this.b.a(localam);
      this.b = localam;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.h u(String paramString)
  {
    int j = paramString.hashCode();
    if (j != 107498)
    {
      if ((j == 113258) && (paramString.equals("rtl")))
      {
        j = 1;
        break label54;
      }
    }
    else if (paramString.equals("ltr"))
    {
      j = 0;
      break label54;
    }
    j = -1;
    label54:
    if (j != 0)
    {
      if (j != 1) {
        return null;
      }
      return h.ae.h.b;
    }
    return h.ae.h.a;
  }
  
  private void u(Attributes paramAttributes)
  {
    a("<radialGradient>", new Object[0]);
    if (this.b != null)
    {
      h.aq localaq = new h.aq();
      localaq.u = this.a;
      localaq.v = this.b;
      a(localaq, paramAttributes);
      b(localaq, paramAttributes);
      a(localaq, paramAttributes);
      a(localaq, paramAttributes);
      this.b.a(localaq);
      this.b = localaq;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.a v(String paramString)
  {
    if ("nonzero".equals(paramString)) {
      return h.ae.a.a;
    }
    if ("evenodd".equals(paramString)) {
      return h.ae.a.b;
    }
    return null;
  }
  
  private void v(Attributes paramAttributes)
  {
    a("<stop>", new Object[0]);
    Object localObject = this.b;
    if (localObject != null)
    {
      if ((localObject instanceof h.j))
      {
        localObject = new h.ad();
        ((h.ad)localObject).u = this.a;
        ((h.ad)localObject).v = this.b;
        a((h.al)localObject, paramAttributes);
        b((h.al)localObject, paramAttributes);
        a((h.ad)localObject, paramAttributes);
        this.b.a((h.an)localObject);
        this.b = ((h.aj)localObject);
        return;
      }
      throw new k("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.c w(String paramString)
  {
    if ("butt".equals(paramString)) {
      return h.ae.c.a;
    }
    if ("round".equals(paramString)) {
      return h.ae.c.b;
    }
    if ("square".equals(paramString)) {
      return h.ae.c.c;
    }
    return null;
  }
  
  private void w(Attributes paramAttributes)
  {
    a("<solidColor>", new Object[0]);
    if (this.b != null)
    {
      h.ac localac = new h.ac();
      localac.u = this.a;
      localac.v = this.b;
      a(localac, paramAttributes);
      b(localac, paramAttributes);
      this.b.a(localac);
      this.b = localac;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.ae.d x(String paramString)
  {
    if ("miter".equals(paramString)) {
      return h.ae.d.a;
    }
    if ("round".equals(paramString)) {
      return h.ae.d.b;
    }
    if ("bevel".equals(paramString)) {
      return h.ae.d.c;
    }
    return null;
  }
  
  private void x(Attributes paramAttributes)
  {
    a("<clipPath>", new Object[0]);
    if (this.b != null)
    {
      h.e locale = new h.e();
      locale.u = this.a;
      locale.v = this.b;
      a(locale, paramAttributes);
      b(locale, paramAttributes);
      a(locale, paramAttributes);
      a(locale, paramAttributes);
      a(locale, paramAttributes);
      this.b.a(locale);
      this.b = locale;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private void y(Attributes paramAttributes)
  {
    a("<textPath>", new Object[0]);
    if (this.b != null)
    {
      h.az localaz = new h.az();
      localaz.u = this.a;
      localaz.v = this.b;
      a(localaz, paramAttributes);
      b(localaz, paramAttributes);
      a(localaz, paramAttributes);
      a(localaz, paramAttributes);
      this.b.a(localaz);
      this.b = localaz;
      if ((localaz.v instanceof h.bb))
      {
        localaz.a((h.bb)localaz.v);
        return;
      }
      localaz.a(((h.ax)localaz.v).h());
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  private static h.p[] y(String paramString)
  {
    paramString = new l.h(paramString);
    paramString.g();
    if (paramString.f()) {
      return null;
    }
    h.p localp = paramString.l();
    if (localp == null) {
      return null;
    }
    if (localp.c()) {
      return null;
    }
    float f1 = localp.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localp);
    while (!paramString.f())
    {
      paramString.h();
      localp = paramString.l();
      if (localp == null) {
        return null;
      }
      if (localp.c()) {
        return null;
      }
      localArrayList.add(localp);
      f1 += localp.a();
    }
    if (f1 == 0.0F) {
      return null;
    }
    return (h.p[])localArrayList.toArray(new h.p[localArrayList.size()]);
  }
  
  private static h.ae.f z(String paramString)
  {
    int j = paramString.hashCode();
    if (j != -1074341483)
    {
      if (j != 100571)
      {
        if ((j == 109757538) && (paramString.equals("start")))
        {
          j = 0;
          break label76;
        }
      }
      else if (paramString.equals("end"))
      {
        j = 2;
        break label76;
      }
    }
    else if (paramString.equals("middle"))
    {
      j = 1;
      break label76;
    }
    j = -1;
    label76:
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return null;
        }
        return h.ae.f.c;
      }
      return h.ae.f.b;
    }
    return h.ae.f.a;
  }
  
  private void z(Attributes paramAttributes)
  {
    a("<pattern>", new Object[0]);
    if (this.b != null)
    {
      h.y localy = new h.y();
      localy.u = this.a;
      localy.v = this.b;
      a(localy, paramAttributes);
      b(localy, paramAttributes);
      a(localy, paramAttributes);
      a(localy, paramAttributes);
      a(localy, paramAttributes);
      this.b.a(localy);
      this.b = localy;
      return;
    }
    throw new k("Invalid document. Root element must be <svg>");
  }
  
  /* Error */
  h a(InputStream paramInputStream, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: invokevirtual 1925	java/io/InputStream:markSupported	()Z
    //   7: ifne +13 -> 20
    //   10: new 1927	java/io/BufferedInputStream
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 1928	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore 5
    //   20: aload 5
    //   22: iconst_3
    //   23: invokevirtual 1931	java/io/InputStream:mark	(I)V
    //   26: aload 5
    //   28: invokevirtual 1934	java/io/InputStream:read	()I
    //   31: istore_3
    //   32: aload 5
    //   34: invokevirtual 1934	java/io/InputStream:read	()I
    //   37: istore 4
    //   39: aload 5
    //   41: invokevirtual 1937	java/io/InputStream:reset	()V
    //   44: aload 5
    //   46: astore_1
    //   47: iload_3
    //   48: iload 4
    //   50: bipush 8
    //   52: ishl
    //   53: iadd
    //   54: ldc_w 1938
    //   57: if_icmpne +20 -> 77
    //   60: new 1927	java/io/BufferedInputStream
    //   63: dup
    //   64: new 1940	java/util/zip/GZIPInputStream
    //   67: dup
    //   68: aload 5
    //   70: invokespecial 1941	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   73: invokespecial 1928	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_1
    //   77: iload_2
    //   78: ifeq +91 -> 169
    //   81: aload_1
    //   82: sipush 4096
    //   85: invokevirtual 1931	java/io/InputStream:mark	(I)V
    //   88: sipush 4096
    //   91: newarray byte
    //   93: astore 5
    //   95: new 44	java/lang/String
    //   98: dup
    //   99: aload 5
    //   101: iconst_0
    //   102: aload_1
    //   103: aload 5
    //   105: invokevirtual 1944	java/io/InputStream:read	([B)I
    //   108: invokespecial 1947	java/lang/String:<init>	([BII)V
    //   111: astore 5
    //   113: aload_1
    //   114: invokevirtual 1937	java/io/InputStream:reset	()V
    //   117: aload 5
    //   119: ldc_w 1949
    //   122: invokevirtual 1629	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   125: iflt +44 -> 169
    //   128: ldc_w 555
    //   131: ldc_w 1951
    //   134: invokestatic 1953	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial 1955	com/tencent/luggage/wxa/a/l:b	(Ljava/io/InputStream;)V
    //   143: aload_0
    //   144: getfield 25	com/tencent/luggage/wxa/a/l:a	Lcom/tencent/luggage/wxa/a/h;
    //   147: astore 5
    //   149: aload_1
    //   150: invokevirtual 1958	java/io/InputStream:close	()V
    //   153: aload 5
    //   155: areturn
    //   156: ldc_w 555
    //   159: ldc_w 1960
    //   162: invokestatic 1439	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   165: pop
    //   166: aload 5
    //   168: areturn
    //   169: aload_0
    //   170: aload_1
    //   171: invokespecial 1962	com/tencent/luggage/wxa/a/l:a	(Ljava/io/InputStream;)V
    //   174: aload_0
    //   175: getfield 25	com/tencent/luggage/wxa/a/l:a	Lcom/tencent/luggage/wxa/a/h;
    //   178: astore 5
    //   180: aload_1
    //   181: invokevirtual 1958	java/io/InputStream:close	()V
    //   184: aload 5
    //   186: areturn
    //   187: ldc_w 555
    //   190: ldc_w 1960
    //   193: invokestatic 1439	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   196: pop
    //   197: aload 5
    //   199: areturn
    //   200: astore 5
    //   202: goto +48 -> 250
    //   205: astore 5
    //   207: ldc_w 555
    //   210: ldc_w 1964
    //   213: aload 5
    //   215: invokestatic 1967	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   218: pop
    //   219: aload_0
    //   220: aload_1
    //   221: invokespecial 1962	com/tencent/luggage/wxa/a/l:a	(Ljava/io/InputStream;)V
    //   224: aload_0
    //   225: getfield 25	com/tencent/luggage/wxa/a/l:a	Lcom/tencent/luggage/wxa/a/h;
    //   228: astore 5
    //   230: aload_1
    //   231: invokevirtual 1958	java/io/InputStream:close	()V
    //   234: aload 5
    //   236: areturn
    //   237: ldc_w 555
    //   240: ldc_w 1960
    //   243: invokestatic 1439	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: aload 5
    //   249: areturn
    //   250: aload_1
    //   251: invokevirtual 1958	java/io/InputStream:close	()V
    //   254: goto +13 -> 267
    //   257: ldc_w 555
    //   260: ldc_w 1960
    //   263: invokestatic 1439	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   266: pop
    //   267: aload 5
    //   269: athrow
    //   270: astore_1
    //   271: aload 5
    //   273: astore_1
    //   274: goto -197 -> 77
    //   277: astore_1
    //   278: goto -122 -> 156
    //   281: astore_1
    //   282: goto -95 -> 187
    //   285: astore_1
    //   286: goto -49 -> 237
    //   289: astore_1
    //   290: goto -33 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	l
    //   0	293	1	paramInputStream	InputStream
    //   0	293	2	paramBoolean	boolean
    //   31	23	3	j	int
    //   37	16	4	k	int
    //   1	197	5	localObject1	Object
    //   200	1	5	localObject2	Object
    //   205	9	5	localIOException	IOException
    //   228	44	5	localh	h
    // Exception table:
    //   from	to	target	type
    //   81	149	200	finally
    //   169	180	200	finally
    //   207	230	200	finally
    //   81	149	205	java/io/IOException
    //   169	180	205	java/io/IOException
    //   20	44	270	java/io/IOException
    //   60	77	270	java/io/IOException
    //   149	153	277	java/io/IOException
    //   180	184	281	java/io/IOException
    //   230	234	285	java/io/IOException
    //   250	254	289	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l
 * JD-Core Version:    0.7.0.1
 */