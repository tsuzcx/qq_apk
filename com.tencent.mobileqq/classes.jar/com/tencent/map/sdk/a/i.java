package com.tencent.map.sdk.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  private StringBuilder a;
  private int b = 0;
  
  public i(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private i a(char paramChar, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramChar);
    paramString.append('\n');
    return this;
  }
  
  private i a(double paramDouble, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramDouble);
    paramString.append('\n');
    return this;
  }
  
  private i a(double paramDouble, boolean paramBoolean)
  {
    this.a.append(paramDouble);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(float paramFloat, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramFloat);
    paramString.append('\n');
    return this;
  }
  
  private i a(float paramFloat, boolean paramBoolean)
  {
    this.a.append(paramFloat);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private <T> i a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
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
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof n))
    {
      a((n)paramT, paramString);
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
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new j("write object error: unsupport type.");
  }
  
  private <T> i a(T paramT, boolean paramBoolean)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof n))
    {
      a((n)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramBoolean);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramBoolean);
      return this;
    }
    throw new j("write object error: unsupport type.");
  }
  
  private <K, V> i a(Map<K, V> paramMap, boolean paramBoolean)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.a.append("{");
      i locali = new i(this.a, this.b + 2);
      paramMap = paramMap.entrySet().iterator();
      for (int i = 1; paramMap.hasNext(); i = 0)
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (i == 0) {
          this.a.append(",");
        }
        locali.a(localEntry.getKey(), true);
        locali.a(localEntry.getValue(), false);
      }
      this.a.append("}");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("{}");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(boolean paramBoolean, String paramString)
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
  
  private i a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = this.a;
    char c;
    if (paramBoolean1) {
      c = 'T';
    } else {
      c = 'F';
    }
    localStringBuilder.append(c);
    if (paramBoolean2) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfDouble.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfDouble.length);
    paramString.append(", [\n");
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private i a(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if ((paramArrayOfDouble != null) && (paramArrayOfDouble.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfDouble.length)
      {
        double d = paramArrayOfDouble[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(d, false);
        i += 1;
      }
      this.a.append("[");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfFloat.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfFloat.length);
    paramString.append(", [\n");
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private i a(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        float f = paramArrayOfFloat[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(f, false);
        i += 1;
      }
      this.a.append("]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfInt.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfInt.length);
    paramString.append(", [\n");
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private i a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(j, false);
        i += 1;
      }
      this.a.append("]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfLong.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfLong.length);
    paramString.append(", [\n");
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private i a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        long l = paramArrayOfLong[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(l, false);
        i += 1;
      }
      this.a.append("]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private <T> i a(T[] paramArrayOfT, String paramString)
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
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private <T> i a(T[] paramArrayOfT, boolean paramBoolean)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfT.length)
      {
        T ? = paramArrayOfT[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(?, false);
        i += 1;
      }
      this.a.append("]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  private i a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      paramString = this.a;
      paramString.append(paramArrayOfShort.length);
      paramString.append(", []\n");
      return this;
    }
    paramString = this.a;
    paramString.append(paramArrayOfShort.length);
    paramString.append(", [\n");
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  private i a(short[] paramArrayOfShort, boolean paramBoolean)
  {
    if ((paramArrayOfShort != null) && (paramArrayOfShort.length != 0))
    {
      this.a.append("[");
      i locali = new i(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfShort.length)
      {
        short s = paramArrayOfShort[i];
        if (i != 0) {
          this.a.append("|");
        }
        locali.a(s, false);
        i += 1;
      }
      this.a.append("]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    this.a.append("[]");
    if (paramBoolean) {
      this.a.append("|");
    }
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
  
  public final i a(byte paramByte, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramByte);
    paramString.append('\n');
    return this;
  }
  
  public final i a(byte paramByte, boolean paramBoolean)
  {
    this.a.append(paramByte);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final i a(int paramInt, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramInt);
    paramString.append('\n');
    return this;
  }
  
  public final i a(int paramInt, boolean paramBoolean)
  {
    this.a.append(paramInt);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final i a(long paramLong, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramLong);
    paramString.append('\n');
    return this;
  }
  
  public final i a(long paramLong, boolean paramBoolean)
  {
    this.a.append(paramLong);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final i a(n paramn, String paramString)
  {
    a('{', paramString);
    if (paramn == null)
    {
      paramn = this.a;
      paramn.append('\t');
      paramn.append("null");
    }
    else
    {
      paramn.display(this.a, this.b + 1);
    }
    a('}', null);
    return this;
  }
  
  public final i a(n paramn, boolean paramBoolean)
  {
    this.a.append("{");
    if (paramn == null)
    {
      paramn = this.a;
      paramn.append('\t');
      paramn.append("null");
    }
    else
    {
      paramn.displaySimple(this.a, this.b + 1);
    }
    this.a.append("}");
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final i a(String paramString1, String paramString2)
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
  
  public final i a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      this.a.append("null");
    } else {
      this.a.append(paramString);
    }
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final <T> i a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public final <T> i a(Collection<T> paramCollection, boolean paramBoolean)
  {
    if (paramCollection == null)
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    return a(paramCollection.toArray(), paramBoolean);
  }
  
  public final <K, V> i a(Map<K, V> paramMap, String paramString)
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
    paramString = new i(this.a, this.b + 1);
    i locali = new i(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      locali.a(localEntry.getKey(), null);
      locali.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public final i a(short paramShort, String paramString)
  {
    a(paramString);
    paramString = this.a;
    paramString.append(paramShort);
    paramString.append('\n');
    return this;
  }
  
  public final i a(short paramShort, boolean paramBoolean)
  {
    this.a.append(paramShort);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final i a(byte[] paramArrayOfByte, String paramString)
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
    paramString = new i(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final i a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      this.a.append(g.a(paramArrayOfByte));
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.i
 * JD-Core Version:    0.7.0.1
 */