package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  private StringBuilder a;
  private int b = 0;
  
  public h(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private <T> h a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      i = ((Byte)paramT).byteValue();
      a(paramString);
      paramT = this.a;
      paramT.append(i);
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      bool = ((Boolean)paramT).booleanValue();
      a(paramString);
      paramT = this.a;
      char c;
      if (bool) {
        c = 'T';
      } else {
        c = 'F';
      }
      paramT.append(c);
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof Short))
    {
      i = ((Short)paramT).shortValue();
      a(paramString);
      paramT = this.a;
      paramT.append(i);
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof Integer))
    {
      i = ((Integer)paramT).intValue();
      a(paramString);
      paramT = this.a;
      paramT.append(i);
      paramT.append('\n');
      return this;
    }
    long l;
    if ((paramT instanceof Long))
    {
      l = ((Long)paramT).longValue();
      a(paramString);
      paramT = this.a;
      paramT.append(l);
      paramT.append('\n');
      return this;
    }
    float f;
    if ((paramT instanceof Float))
    {
      f = ((Float)paramT).floatValue();
      a(paramString);
      paramT = this.a;
      paramT.append(f);
      paramT.append('\n');
      return this;
    }
    double d;
    if ((paramT instanceof Double))
    {
      d = ((Double)paramT).doubleValue();
      a(paramString);
      paramT = this.a;
      paramT.append(d);
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      paramT = (List)paramT;
      if (paramT == null)
      {
        a(paramString);
        this.a.append("null\t");
        return this;
      }
      a(paramT.toArray(), paramString);
      return this;
    }
    if ((paramT instanceof k))
    {
      a((k)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    boolean bool = paramT instanceof short[];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    StringBuilder localStringBuilder;
    if (bool)
    {
      paramT = (short[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        paramString = this.a;
        paramString.append(paramT.length);
        paramString.append(", []\n");
        return this;
      }
      paramString = this.a;
      paramString.append(paramT.length);
      paramString.append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      while (i < j)
      {
        k = paramT[i];
        paramString.a(null);
        localStringBuilder = paramString.a;
        localStringBuilder.append(k);
        localStringBuilder.append('\n');
        i += 1;
      }
      a(null);
      paramT = this.a;
      paramT.append(']');
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof int[]))
    {
      paramT = (int[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        paramString = this.a;
        paramString.append(paramT.length);
        paramString.append(", []\n");
        return this;
      }
      paramString = this.a;
      paramString.append(paramT.length);
      paramString.append(", [\n");
      paramString = new h(this.a, this.b + 1);
      k = paramT.length;
      i = j;
      while (i < k)
      {
        j = paramT[i];
        paramString.a(null);
        localStringBuilder = paramString.a;
        localStringBuilder.append(j);
        localStringBuilder.append('\n');
        i += 1;
      }
      a(null);
      paramT = this.a;
      paramT.append(']');
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof long[]))
    {
      paramT = (long[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        paramString = this.a;
        paramString.append(paramT.length);
        paramString.append(", []\n");
        return this;
      }
      paramString = this.a;
      paramString.append(paramT.length);
      paramString.append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = k;
      while (i < j)
      {
        l = paramT[i];
        paramString.a(null);
        localStringBuilder = paramString.a;
        localStringBuilder.append(l);
        localStringBuilder.append('\n');
        i += 1;
      }
      a(null);
      paramT = this.a;
      paramT.append(']');
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof float[]))
    {
      paramT = (float[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        paramString = this.a;
        paramString.append(paramT.length);
        paramString.append(", []\n");
        return this;
      }
      paramString = this.a;
      paramString.append(paramT.length);
      paramString.append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = m;
      while (i < j)
      {
        f = paramT[i];
        paramString.a(null);
        localStringBuilder = paramString.a;
        localStringBuilder.append(f);
        localStringBuilder.append('\n');
        i += 1;
      }
      a(null);
      paramT = this.a;
      paramT.append(']');
      paramT.append('\n');
      return this;
    }
    if ((paramT instanceof double[]))
    {
      paramT = (double[])paramT;
      a(paramString);
      if (paramT == null)
      {
        this.a.append("null\n");
        return this;
      }
      if (paramT.length == 0)
      {
        paramString = this.a;
        paramString.append(paramT.length);
        paramString.append(", []\n");
        return this;
      }
      paramString = this.a;
      paramString.append(paramT.length);
      paramString.append(", [\n");
      paramString = new h(this.a, this.b + 1);
      j = paramT.length;
      i = n;
      while (i < j)
      {
        d = paramT[i];
        paramString.a(null);
        localStringBuilder = paramString.a;
        localStringBuilder.append(d);
        localStringBuilder.append('\n');
        i += 1;
      }
      a(null);
      paramT = this.a;
      paramT.append(']');
      paramT.append('\n');
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    paramT = new b("write object error: unsupport type.");
    for (;;)
    {
      throw paramT;
    }
  }
  
  private <T> h a(T[] paramArrayOfT, String paramString)
  {
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfT.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfT.length);
    paramString.append(", [\n");
    paramString = new h(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(null);
    paramArrayOfT = this.a;
    paramArrayOfT.append(']');
    paramArrayOfT.append('\n');
    return this;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null)
    {
      StringBuilder localStringBuilder = this.a;
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
    }
  }
  
  public final h a(byte paramByte, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramByte);
    paramString.append('\n');
    return this;
  }
  
  public final h a(int paramInt, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramInt);
    paramString.append('\n');
    return this;
  }
  
  public final h a(long paramLong, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramLong);
    paramString.append('\n');
    return this;
  }
  
  public final h a(k paramk, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append('{');
    paramString.append('\n');
    if (paramk == null)
    {
      paramk = this.a;
      paramk.append('\t');
      paramk.append("null");
    }
    else
    {
      paramk.a(this.a, this.b + 1);
    }
    a(null);
    paramk = this.a;
    paramk.append('}');
    paramk.append('\n');
    return this;
  }
  
  public final h a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    paramString2 = this.a;
    paramString2.append(paramString1);
    paramString2.append('\n');
    return this;
  }
  
  public final <K, V> h a(Map<K, V> paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      paramString = this.a;
      paramString.append(paramMap.size());
      paramString.append(", {}\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramMap.size());
    paramString.append(", {\n");
    paramString = new h(this.a, this.b + 1);
    h localh = new h(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramString.a(null);
      StringBuilder localStringBuilder = paramString.a;
      localStringBuilder.append('(');
      localStringBuilder.append('\n');
      localh.a(((Map.Entry)localObject).getKey(), null);
      localh.a(((Map.Entry)localObject).getValue(), null);
      paramString.a(null);
      localObject = paramString.a;
      ((StringBuilder)localObject).append(')');
      ((StringBuilder)localObject).append('\n');
    }
    a(null);
    paramMap = this.a;
    paramMap.append('}');
    paramMap.append('\n');
    return this;
  }
  
  public final h a(short paramShort, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramShort);
    paramString.append('\n');
    return this;
  }
  
  public final h a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    char c;
    if (paramBoolean) {
      c = 'T';
    } else {
      c = 'F';
    }
    paramString.append(c);
    paramString.append('\n');
    return this;
  }
  
  public final h a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfByte.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfByte.length);
    paramString.append(", [\n");
    paramString = new h(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      paramString.a(null);
      StringBuilder localStringBuilder = paramString.a;
      localStringBuilder.append(k);
      localStringBuilder.append('\n');
      i += 1;
    }
    a(null);
    paramArrayOfByte = this.a;
    paramArrayOfByte.append(']');
    paramArrayOfByte.append('\n');
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.h
 * JD-Core Version:    0.7.0.1
 */