package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b$c
  extends l.h
{
  b$c(String paramString)
  {
    super(paramString.replaceAll("(?s)/\\*.*?\\*/", ""));
  }
  
  private List<b.r> A()
  {
    if (f()) {
      return null;
    }
    int i = this.b;
    if (!a('(')) {
      return null;
    }
    g();
    List localList = x();
    if (localList == null)
    {
      this.b = i;
      return null;
    }
    if (!a(')'))
    {
      this.b = i;
      return null;
    }
    Iterator localIterator = localList.iterator();
    label68:
    if (localIterator.hasNext())
    {
      Object localObject1 = (b.r)localIterator.next();
      if (((b.r)localObject1).a == null) {
        return localList;
      }
      localObject1 = ((b.r)localObject1).a.iterator();
      Object localObject2;
      do
      {
        break label155;
        if (!((Iterator)localObject1).hasNext()) {
          break label68;
        }
        localObject2 = (b.s)((Iterator)localObject1).next();
        if (((b.s)localObject2).d == null) {
          break label68;
        }
        localObject2 = ((b.s)localObject2).d.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!((b.f)((Iterator)localObject2).next() instanceof b.j));
      return null;
    }
    label155:
    return localList;
  }
  
  private String B()
  {
    if (f()) {
      return null;
    }
    String str = u();
    if (str != null) {
      return str;
    }
    return a();
  }
  
  private void a(b.r paramr, b.s params)
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = b.i.a((String)localObject1);
      switch (b.1.b[localObject2.ordinal()])
      {
      default: 
        paramr = new StringBuilder();
        paramr.append("Unsupported pseudo class: ");
        paramr.append((String)localObject1);
        throw new a(paramr.toString());
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
        localObject1 = new b.k((String)localObject1);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 15: 
        z();
        localObject1 = new b.k((String)localObject1);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 14: 
        localObject1 = new b.n(null);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 13: 
        localObject2 = A();
        if (localObject2 != null)
        {
          localObject1 = new b.j((List)localObject2);
          paramr.b = ((b.j)localObject1).a();
          paramr = (b.r)localObject1;
        }
        else
        {
          paramr = new StringBuilder();
          paramr.append("Invalid or missing parameter section for pseudo class: ");
          paramr.append((String)localObject1);
          throw new a(paramr.toString());
        }
        break;
      case 9: 
      case 10: 
      case 11: 
      case 12: 
        boolean bool1;
        if ((localObject2 != b.i.c) && (localObject2 != b.i.e)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        boolean bool2;
        if ((localObject2 != b.i.e) && (localObject2 != b.i.f)) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        localObject2 = y();
        if (localObject2 != null)
        {
          localObject1 = new b.g(((b.c.a)localObject2).a, ((b.c.a)localObject2).b, bool1, bool2, params.b);
          paramr.d();
          paramr = (b.r)localObject1;
        }
        else
        {
          paramr = new StringBuilder();
          paramr.append("Invalid or missing parameter section for pseudo class: ");
          paramr.append((String)localObject1);
          throw new a(paramr.toString());
        }
        break;
      case 8: 
        localObject1 = new b.h(null);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 7: 
        localObject1 = new b.m(null);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 6: 
        localObject1 = new b.l(true, params.b);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 5: 
        localObject1 = new b.g(0, 1, false, true, params.b);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 4: 
        localObject1 = new b.g(0, 1, true, true, params.b);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 3: 
        localObject1 = new b.l(false, null);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 2: 
        localObject1 = new b.g(0, 1, false, false, null);
        paramr.d();
        paramr = (b.r)localObject1;
        break;
      case 1: 
        localObject1 = new b.g(0, 1, true, false, null);
        paramr.d();
        paramr = (b.r)localObject1;
      }
      params.a(paramr);
      return;
    }
    throw new a("Invalid pseudo class");
  }
  
  private int c(int paramInt)
  {
    if ((paramInt >= 48) && (paramInt <= 57)) {
      return paramInt - 48;
    }
    int i = 65;
    if ((paramInt >= 65) && (paramInt <= 70)) {}
    do
    {
      return paramInt - i + 10;
      i = 97;
    } while ((paramInt >= 97) && (paramInt <= 102));
    return -1;
  }
  
  private int w()
  {
    if (f()) {
      return this.b;
    }
    int m = this.b;
    int j = this.b;
    int k = this.a.charAt(this.b);
    int i = k;
    if (k == 45) {
      i = n();
    }
    if (((i >= 65) && (i <= 90)) || ((i >= 97) && (i <= 122)) || (i == 95)) {
      for (i = n();; i = n()) {
        if (((i < 65) || (i > 90)) && ((i < 97) || (i > 122)) && ((i < 48) || (i > 57)) && (i != 45) && (i != 95))
        {
          j = this.b;
          break;
        }
      }
    }
    this.b = m;
    return j;
  }
  
  private List<b.r> x()
  {
    if (f()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(1);
    b.r localr = new b.r(null);
    while ((!f()) && (a(localr))) {
      if (h())
      {
        localArrayList.add(localr);
        localr = new b.r(null);
      }
    }
    if (!localr.b()) {
      localArrayList.add(localr);
    }
    return localArrayList;
  }
  
  private b.c.a y()
  {
    if (f()) {
      return null;
    }
    int n = this.b;
    if (!a('(')) {
      return null;
    }
    g();
    boolean bool1 = a("odd");
    int m = 1;
    Object localObject1;
    if (bool1)
    {
      localObject1 = new b.c.a(2, 1);
    }
    else
    {
      bool1 = a("even");
      int k = 0;
      if (bool1)
      {
        localObject1 = new b.c.a(2, 0);
      }
      else
      {
        int i;
        if ((!a('+')) && (a('-'))) {
          i = -1;
        } else {
          i = 1;
        }
        localObject1 = d.a(this.a, this.b, this.c, false);
        if (localObject1 != null) {
          this.b = ((d)localObject1).a();
        }
        int j;
        Object localObject2;
        if ((!a('n')) && (!a('N')))
        {
          j = i;
          localObject2 = localObject1;
          i = 1;
          localObject1 = null;
        }
        else
        {
          if (localObject1 == null) {
            localObject1 = new d(1L, this.b);
          }
          g();
          boolean bool2 = a('+');
          bool1 = bool2;
          j = m;
          if (!bool2)
          {
            bool2 = a('-');
            bool1 = bool2;
            j = m;
            if (bool2)
            {
              j = -1;
              bool1 = bool2;
            }
          }
          if (bool1)
          {
            g();
            localObject2 = d.a(this.a, this.b, this.c, false);
            if (localObject2 != null)
            {
              this.b = ((d)localObject2).a();
            }
            else
            {
              this.b = n;
              return null;
            }
          }
          else
          {
            localObject2 = null;
          }
        }
        if (localObject1 == null) {
          i = 0;
        } else {
          i *= ((d)localObject1).b();
        }
        if (localObject2 == null) {
          j = k;
        } else {
          j *= ((d)localObject2).b();
        }
        localObject1 = new b.c.a(i, j);
      }
    }
    g();
    if (a(')')) {
      return localObject1;
    }
    this.b = n;
    return null;
  }
  
  private List<String> z()
  {
    if (f()) {
      return null;
    }
    int i = this.b;
    if (!a('(')) {
      return null;
    }
    g();
    Object localObject1 = null;
    Object localObject2;
    do
    {
      String str = a();
      if (str == null)
      {
        this.b = i;
        return null;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject2).add(str);
      g();
      localObject1 = localObject2;
    } while (h());
    if (a(')')) {
      return localObject2;
    }
    this.b = i;
    return null;
  }
  
  String a()
  {
    int i = w();
    if (i == this.b) {
      return null;
    }
    String str = this.a.substring(this.b, i);
    this.b = i;
    return str;
  }
  
  boolean a(b.r paramr)
  {
    if (f()) {
      return false;
    }
    int i = this.b;
    if (!paramr.b())
    {
      if (a('>'))
      {
        locald = b.d.b;
        g();
        break label66;
      }
      if (a('+'))
      {
        locald = b.d.c;
        g();
        break label66;
      }
    }
    b.d locald = null;
    label66:
    Object localObject1;
    if (a('*'))
    {
      localObject1 = new b.s(locald, null);
    }
    else
    {
      localObject1 = a();
      if (localObject1 != null)
      {
        localObject1 = new b.s(locald, (String)localObject1);
        paramr.e();
      }
      else
      {
        localObject1 = null;
      }
    }
    while (!f())
    {
      Object localObject2;
      if (a('.'))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new b.s(locald, null);
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          ((b.s)localObject2).a("class", b.b.b, (String)localObject1);
          paramr.d();
          localObject1 = localObject2;
        }
        else
        {
          throw new a("Invalid \".class\" simpleSelectors");
        }
      }
      else if (a('#'))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new b.s(locald, null);
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          ((b.s)localObject2).a("id", b.b.b, (String)localObject1);
          paramr.c();
          localObject1 = localObject2;
        }
        else
        {
          throw new a("Invalid \"#id\" simpleSelectors");
        }
      }
      else if (a('['))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new b.s(locald, null);
        }
        g();
        String str2 = a();
        if (str2 != null)
        {
          g();
          if (a('=')) {
            localObject1 = b.b.b;
          } else if (a("~=")) {
            localObject1 = b.b.c;
          } else if (a("|=")) {
            localObject1 = b.b.d;
          } else {
            localObject1 = null;
          }
          String str1;
          if (localObject1 != null)
          {
            g();
            str1 = B();
            if (str1 != null) {
              g();
            } else {
              throw new a("Invalid attribute simpleSelectors");
            }
          }
          else
          {
            str1 = null;
          }
          if (a(']'))
          {
            Object localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = b.b.a;
            }
            ((b.s)localObject2).a(str2, (b.b)localObject3, str1);
            paramr.d();
            localObject1 = localObject2;
          }
          else
          {
            throw new a("Invalid attribute simpleSelectors");
          }
        }
        else
        {
          throw new a("Invalid attribute simpleSelectors");
        }
      }
      else
      {
        if (!a(':')) {
          break;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new b.s(locald, null);
        }
        a(paramr, (b.s)localObject2);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      paramr.a((b.s)localObject1);
      return true;
    }
    this.b = i;
    return false;
  }
  
  String b()
  {
    if (f()) {
      return null;
    }
    int k = this.b;
    int j = this.b;
    for (int i = this.a.charAt(this.b); (i != -1) && (i != 59) && (i != 125) && (i != 33) && (!b(i)); i = n()) {
      if (!a(i)) {
        j = this.b + 1;
      }
    }
    if (this.b > k) {
      return this.a.substring(k, j);
    }
    this.b = k;
    return null;
  }
  
  String c()
  {
    if (f()) {
      return null;
    }
    int n = this.a.charAt(this.b);
    if ((n != 39) && (n != 34)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    this.b += 1;
    int i = k().intValue();
    while ((i != -1) && (i != n))
    {
      int j = i;
      if (i == 92)
      {
        i = k().intValue();
        if (i == -1) {
          continue;
        }
        if ((i != 10) && (i != 13) && (i != 12))
        {
          int k = c(i);
          j = i;
          if (k != -1)
          {
            int m = 1;
            j = k;
            k = m;
            while (k <= 5)
            {
              i = k().intValue();
              m = c(i);
              if (m == -1) {
                break;
              }
              j = j * 16 + m;
              k += 1;
            }
            localStringBuilder.append((char)j);
          }
        }
        else
        {
          i = k().intValue();
          continue;
        }
      }
      localStringBuilder.append((char)j);
      i = k().intValue();
    }
    return localStringBuilder.toString();
  }
  
  String d()
  {
    if (f()) {
      return null;
    }
    int i = this.b;
    if (!a("url(")) {
      return null;
    }
    g();
    String str2 = c();
    String str1 = str2;
    if (str2 == null) {
      str1 = e();
    }
    if (str1 == null)
    {
      this.b = i;
      return null;
    }
    g();
    if (!f())
    {
      if (a(")")) {
        return str1;
      }
      this.b = i;
      return null;
    }
    return str1;
  }
  
  String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (!f())
    {
      int j = this.a.charAt(this.b);
      if ((j == 39) || (j == 34) || (j == 40) || (j == 41) || (a(j)) || (Character.isISOControl(j))) {
        break;
      }
      this.b += 1;
      int i = j;
      if (j == 92)
      {
        if (f()) {
          continue;
        }
        String str = this.a;
        i = this.b;
        this.b = (i + 1);
        i = str.charAt(i);
        if ((i == 10) || (i == 13) || (i == 12)) {
          continue;
        }
        j = c(i);
        if (j != -1)
        {
          i = 1;
          while ((i <= 5) && (!f()))
          {
            int k = c(this.a.charAt(this.b));
            if (k == -1) {
              break;
            }
            this.b += 1;
            j = j * 16 + k;
            i += 1;
          }
          localStringBuilder.append((char)j);
          continue;
        }
      }
      localStringBuilder.append((char)i);
    }
    if (localStringBuilder.length() == 0) {
      return null;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.c
 * JD-Core Version:    0.7.0.1
 */