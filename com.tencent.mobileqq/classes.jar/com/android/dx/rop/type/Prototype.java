package com.android.dx.rop.type;

import java.util.HashMap;

public final class Prototype
  implements Comparable<Prototype>
{
  private static final HashMap<String, Prototype> internTable = new HashMap(500);
  private final String descriptor;
  private StdTypeList parameterFrameTypes;
  private final StdTypeList parameterTypes;
  private final Type returnType;
  
  private Prototype(String paramString, Type paramType, StdTypeList paramStdTypeList)
  {
    if (paramString == null) {
      throw new NullPointerException("descriptor == null");
    }
    if (paramType == null) {
      throw new NullPointerException("returnType == null");
    }
    if (paramStdTypeList == null) {
      throw new NullPointerException("parameterTypes == null");
    }
    this.descriptor = paramString;
    this.returnType = paramType;
    this.parameterTypes = paramStdTypeList;
    this.parameterFrameTypes = null;
  }
  
  public static Prototype intern(String paramString)
  {
    int n = 0;
    if (paramString == null) {
      throw new NullPointerException("descriptor == null");
    }
    Object localObject2;
    synchronized (internTable)
    {
      localObject2 = (Prototype)internTable.get(paramString);
      if (localObject2 != null) {
        return localObject2;
      }
    }
    ??? = makeParameterArray(paramString);
    int i = 1;
    int k = 0;
    int j = paramString.charAt(i);
    StdTypeList localStdTypeList;
    if (j == 41)
    {
      localObject2 = Type.internReturnType(paramString.substring(i + 1));
      localStdTypeList = new StdTypeList(k);
      i = n;
      while (i < k)
      {
        localStdTypeList.set(i, ???[i]);
        i += 1;
      }
    }
    for (;;)
    {
      int m;
      if (j == 91)
      {
        m += 1;
        j = paramString.charAt(m);
      }
      else
      {
        if (j == 76)
        {
          j = paramString.indexOf(';', m);
          if (j == -1) {
            throw new IllegalArgumentException("bad descriptor");
          }
          j += 1;
        }
        for (;;)
        {
          ???[k] = Type.intern(paramString.substring(i, j));
          k += 1;
          i = j;
          break;
          j = m + 1;
        }
        return putIntern(new Prototype(paramString, (Type)localObject2, localStdTypeList));
        m = i;
      }
    }
  }
  
  public static Prototype intern(String paramString, Type paramType, boolean paramBoolean1, boolean paramBoolean2)
  {
    Prototype localPrototype = intern(paramString);
    if (paramBoolean1) {
      return localPrototype;
    }
    paramString = paramType;
    if (paramBoolean2) {
      paramString = paramType.asUninitialized(2147483647);
    }
    return localPrototype.withFirstParameter(paramString);
  }
  
  public static Prototype internInts(Type paramType, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append('(');
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append('I');
      i += 1;
    }
    localStringBuffer.append(')');
    localStringBuffer.append(paramType.getDescriptor());
    return intern(localStringBuffer.toString());
  }
  
  private static Type[] makeParameterArray(String paramString)
  {
    int m = paramString.length();
    if (paramString.charAt(0) != '(') {
      throw new IllegalArgumentException("bad descriptor");
    }
    int i = 1;
    int j = 0;
    int n;
    if (i < m)
    {
      n = paramString.charAt(i);
      if (n != 41) {}
    }
    for (;;)
    {
      if ((i == 0) || (i == m - 1))
      {
        throw new IllegalArgumentException("bad descriptor");
        int k = j;
        if (n >= 65)
        {
          k = j;
          if (n <= 90) {
            k = j + 1;
          }
        }
        i += 1;
        j = k;
        break;
      }
      if (paramString.indexOf(')', i + 1) != -1) {
        throw new IllegalArgumentException("bad descriptor");
      }
      return new Type[j];
      i = 0;
    }
  }
  
  private static Prototype putIntern(Prototype paramPrototype)
  {
    synchronized (internTable)
    {
      String str = paramPrototype.getDescriptor();
      Prototype localPrototype = (Prototype)internTable.get(str);
      if (localPrototype != null) {
        return localPrototype;
      }
      internTable.put(str, paramPrototype);
      return paramPrototype;
    }
  }
  
  public int compareTo(Prototype paramPrototype)
  {
    if (this == paramPrototype) {}
    int j;
    int k;
    do
    {
      return 0;
      int i = this.returnType.compareTo(paramPrototype.returnType);
      if (i != 0) {
        return i;
      }
      j = this.parameterTypes.size();
      k = paramPrototype.parameterTypes.size();
      int m = Math.min(j, k);
      i = 0;
      while (i < m)
      {
        int n = this.parameterTypes.get(i).compareTo(paramPrototype.parameterTypes.get(i));
        if (n != 0) {
          return n;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Prototype)) {
      return false;
    }
    return this.descriptor.equals(((Prototype)paramObject).descriptor);
  }
  
  public String getDescriptor()
  {
    return this.descriptor;
  }
  
  public StdTypeList getParameterFrameTypes()
  {
    StdTypeList localStdTypeList;
    if (this.parameterFrameTypes == null)
    {
      int k = this.parameterTypes.size();
      localStdTypeList = new StdTypeList(k);
      int i = 0;
      int j = 0;
      while (i < k)
      {
        Type localType = this.parameterTypes.get(i);
        localObject = localType;
        if (localType.isIntlike())
        {
          j = 1;
          localObject = Type.INT;
        }
        localStdTypeList.set(i, (Type)localObject);
        i += 1;
      }
      if (j == 0) {
        break label97;
      }
    }
    label97:
    for (Object localObject = localStdTypeList;; localObject = this.parameterTypes)
    {
      this.parameterFrameTypes = ((StdTypeList)localObject);
      return this.parameterFrameTypes;
    }
  }
  
  public StdTypeList getParameterTypes()
  {
    return this.parameterTypes;
  }
  
  public Type getReturnType()
  {
    return this.returnType;
  }
  
  public int hashCode()
  {
    return this.descriptor.hashCode();
  }
  
  public String toString()
  {
    return this.descriptor;
  }
  
  public Prototype withFirstParameter(Type paramType)
  {
    String str = "(" + paramType.getDescriptor() + this.descriptor.substring(1);
    paramType = this.parameterTypes.withFirst(paramType);
    paramType.setImmutable();
    return putIntern(new Prototype(str, this.returnType, paramType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.type.Prototype
 * JD-Core Version:    0.7.0.1
 */