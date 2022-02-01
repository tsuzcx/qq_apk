package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b$s
{
  b.d a = null;
  String b = null;
  List<b.a> c = null;
  List<b.f> d = null;
  
  b$s(b.d paramd, String paramString)
  {
    if (paramd == null) {
      paramd = b.d.a;
    }
    this.a = paramd;
    this.b = paramString;
  }
  
  void a(b.f paramf)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramf);
  }
  
  void a(String paramString1, b.b paramb, String paramString2)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(new b.a(paramString1, paramb, paramString2));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a == b.d.b) {
      localStringBuilder.append("> ");
    } else if (this.a == b.d.c) {
      localStringBuilder.append("+ ");
    }
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "*";
    }
    localStringBuilder.append((String)localObject1);
    localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b.a)((Iterator)localObject1).next();
        localStringBuilder.append('[');
        localStringBuilder.append(((b.a)localObject2).a);
        int i = b.1.a[localObject2.b.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localStringBuilder.append("|=");
              localStringBuilder.append(((b.a)localObject2).c);
            }
          }
          else
          {
            localStringBuilder.append("~=");
            localStringBuilder.append(((b.a)localObject2).c);
          }
        }
        else
        {
          localStringBuilder.append('=');
          localStringBuilder.append(((b.a)localObject2).c);
        }
        localStringBuilder.append(']');
      }
    }
    localObject1 = this.d;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b.f)((Iterator)localObject1).next();
        localStringBuilder.append(':');
        localStringBuilder.append(localObject2);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.s
 * JD-Core Version:    0.7.0.1
 */