package com.tencent.luggage.wxa.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class b
{
  private b.e a = null;
  private b.t b = null;
  private boolean c = false;
  
  b()
  {
    this(b.e.h, b.t.a);
  }
  
  b(b.e parame, b.t paramt)
  {
    this.a = parame;
    this.b = paramt;
  }
  
  private static int a(List<h.aj> paramList, int paramInt, h.al paramal)
  {
    int i = 0;
    if (paramInt < 0) {
      return 0;
    }
    if (paramList.get(paramInt) != paramal.v) {
      return -1;
    }
    paramList = paramal.v.b().iterator();
    paramInt = i;
    while (paramList.hasNext())
    {
      if ((h.an)paramList.next() == paramal) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private static List<b.e> a(b.c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      if (!paramc.f())
      {
        str = paramc.p();
        if (str == null) {
          return localArrayList;
        }
      }
      try
      {
        localArrayList.add(b.e.valueOf(str));
        label35:
        if (paramc.h()) {
          continue;
        }
        return localArrayList;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label35;
      }
    }
  }
  
  private void a(b.q paramq, b.c paramc)
  {
    Object localObject1 = paramc.a();
    paramc.g();
    if (localObject1 != null)
    {
      if ((!this.c) && (((String)localObject1).equals("media")))
      {
        localObject1 = a(paramc);
        if (paramc.a('{'))
        {
          paramc.g();
          if (a((List)localObject1, this.a))
          {
            this.c = true;
            paramq.a(c(paramc));
            this.c = false;
          }
          else
          {
            c(paramc);
          }
          if ((!paramc.f()) && (!paramc.a('}'))) {
            throw new a("Invalid @media rule: expected '}' at end of rule set");
          }
        }
        else
        {
          throw new a("Invalid @media rule: missing rule set");
        }
      }
      else if ((!this.c) && (((String)localObject1).equals("import")))
      {
        Object localObject2 = paramc.d();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramc.c();
        }
        if (localObject1 != null)
        {
          paramc.g();
          localObject2 = a(paramc);
          if ((!paramc.f()) && (!paramc.a(';'))) {
            throw new a("Invalid @media rule: expected '}' at end of rule set");
          }
          if ((h.h() != null) && (a((List)localObject2, this.a)))
          {
            localObject1 = h.h().b((String)localObject1);
            if (localObject1 == null) {
              return;
            }
            paramq.a(a((String)localObject1));
          }
        }
        else
        {
          throw new a("Invalid @import rule: expected string or url()");
        }
      }
      else
      {
        a("Ignoring @%s rule", new Object[] { localObject1 });
        b(paramc);
      }
      paramc.g();
      return;
    }
    throw new a("Invalid '@' rule");
  }
  
  private static void a(String paramString, Object... paramVarArgs)
  {
    Log.w("CSSParser", String.format(paramString, paramVarArgs));
  }
  
  private static boolean a(b.p paramp, b.r paramr, int paramInt1, List<h.aj> paramList, int paramInt2)
  {
    b.s locals = paramr.a(paramInt1);
    h.al localal = (h.al)paramList.get(paramInt2);
    if (!a(paramp, locals, paramList, paramInt2, localal)) {
      return false;
    }
    if (locals.a == b.d.a)
    {
      if (paramInt1 == 0) {
        return true;
      }
      while (paramInt2 > 0)
      {
        i = paramInt2 - 1;
        paramInt2 = i;
        if (a(paramp, paramr, paramInt1 - 1, paramList, i)) {
          return true;
        }
      }
      return false;
    }
    if (locals.a == b.d.b) {
      return a(paramp, paramr, paramInt1 - 1, paramList, paramInt2 - 1);
    }
    int i = a(paramList, paramInt2, localal);
    if (i <= 0) {
      return false;
    }
    return a(paramp, paramr, paramInt1 - 1, paramList, paramInt2, (h.al)localal.v.b().get(i - 1));
  }
  
  private static boolean a(b.p paramp, b.r paramr, int paramInt1, List<h.aj> paramList, int paramInt2, h.al paramal)
  {
    b.s locals = paramr.a(paramInt1);
    if (!a(paramp, locals, paramList, paramInt2, paramal)) {
      return false;
    }
    if (locals.a == b.d.a)
    {
      if (paramInt1 == 0) {
        return true;
      }
      while (paramInt2 >= 0)
      {
        if (a(paramp, paramr, paramInt1 - 1, paramList, paramInt2)) {
          return true;
        }
        paramInt2 -= 1;
      }
      return false;
    }
    if (locals.a == b.d.b) {
      return a(paramp, paramr, paramInt1 - 1, paramList, paramInt2);
    }
    int i = a(paramList, paramInt2, paramal);
    if (i <= 0) {
      return false;
    }
    return a(paramp, paramr, paramInt1 - 1, paramList, paramInt2, (h.al)paramal.v.b().get(i - 1));
  }
  
  static boolean a(b.p paramp, b.r paramr, h.al paramal)
  {
    ArrayList localArrayList = new ArrayList();
    for (h.aj localaj = paramal.v; localaj != null; localaj = ((h.an)localaj).v) {
      localArrayList.add(0, localaj);
    }
    int i = localArrayList.size() - 1;
    if (paramr.a() == 1) {
      return a(paramp, paramr.a(0), localArrayList, i, paramal);
    }
    return a(paramp, paramr, paramr.a() - 1, localArrayList, i, paramal);
  }
  
  private static boolean a(b.p paramp, b.s params, List<h.aj> paramList, int paramInt, h.al paramal)
  {
    if ((params.b != null) && (!params.b.equals(paramal.a().toLowerCase(Locale.US)))) {
      return false;
    }
    if (params.c != null)
    {
      paramList = params.c.iterator();
      while (paramList.hasNext())
      {
        b.a locala = (b.a)paramList.next();
        String str = locala.a;
        paramInt = -1;
        int i = str.hashCode();
        if (i != 3355)
        {
          if ((i == 94742904) && (str.equals("class"))) {
            paramInt = 1;
          }
        }
        else if (str.equals("id")) {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          if (paramInt != 1) {
            return false;
          }
          if (paramal.t == null) {
            return false;
          }
          if (!paramal.t.contains(locala.c)) {
            return false;
          }
        }
        else if (!locala.c.equals(paramal.p))
        {
          return false;
        }
      }
    }
    if (params.d != null)
    {
      params = params.d.iterator();
      while (params.hasNext()) {
        if (!((b.f)params.next()).a(paramp, paramal)) {
          return false;
        }
      }
    }
    return true;
  }
  
  static boolean a(String paramString, b.e parame)
  {
    paramString = new b.c(paramString);
    paramString.g();
    return a(a(paramString), parame);
  }
  
  private static boolean a(List<b.e> paramList, b.e parame)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.e locale = (b.e)paramList.next();
      if ((locale == b.e.a) || (locale == parame)) {
        return true;
      }
    }
    return false;
  }
  
  public static List<String> b(String paramString)
  {
    b.c localc = new b.c(paramString);
    paramString = null;
    while (!localc.f())
    {
      String str = localc.o();
      if (str != null)
      {
        Object localObject = paramString;
        if (paramString == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(str);
        localc.g();
        paramString = (String)localObject;
      }
    }
    return paramString;
  }
  
  private void b(b.c paramc)
  {
    int i = 0;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          if (paramc.f()) {
            return;
          }
          j = paramc.k().intValue();
          if ((j == 59) && (i == 0)) {
            return;
          }
          if (j != 123) {
            break;
          }
          i += 1;
        }
      } while ((j != 125) || (i <= 0));
      j = i - 1;
      i = j;
    } while (j != 0);
  }
  
  private boolean b(b.q paramq, b.c paramc)
  {
    List localList = b.c.a(paramc);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramc.a('{'))
      {
        paramc.g();
        h.ae localae = d(paramc);
        paramc.g();
        paramc = localList.iterator();
        while (paramc.hasNext()) {
          paramq.a(new b.o((b.r)paramc.next(), localae, this.b));
        }
        return true;
      }
      throw new a("Malformed rule block: expected '{'");
    }
    return false;
  }
  
  private b.q c(b.c paramc)
  {
    localq = new b.q();
    try
    {
      boolean bool;
      do
      {
        for (;;)
        {
          if (paramc.f()) {
            return localq;
          }
          if ((!paramc.a("<!--")) && (!paramc.a("-->")))
          {
            if (!paramc.a('@')) {
              break;
            }
            a(localq, paramc);
          }
        }
        bool = b(localq, paramc);
      } while (bool);
      StringBuilder localStringBuilder;
      return localq;
    }
    catch (a paramc)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CSS parser terminated early due to error: ");
      localStringBuilder.append(paramc.getMessage());
      Log.e("CSSParser", localStringBuilder.toString());
    }
  }
  
  private h.ae d(b.c paramc)
  {
    h.ae localae = new h.ae();
    do
    {
      String str1 = paramc.a();
      paramc.g();
      if (!paramc.a(':')) {
        break label133;
      }
      paramc.g();
      String str2 = paramc.b();
      if (str2 == null) {
        break;
      }
      paramc.g();
      if (paramc.a('!'))
      {
        paramc.g();
        if (paramc.a("important")) {
          paramc.g();
        } else {
          throw new a("Malformed rule set: found unexpected '!'");
        }
      }
      paramc.a(';');
      l.a(localae, str1, str2);
      paramc.g();
    } while ((!paramc.f()) && (!paramc.a('}')));
    return localae;
    throw new a("Expected property value");
    label133:
    paramc = new a("Expected ':'");
    for (;;)
    {
      throw paramc;
    }
  }
  
  b.q a(String paramString)
  {
    paramString = new b.c(paramString);
    paramString.g();
    return c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b
 * JD-Core Version:    0.7.0.1
 */