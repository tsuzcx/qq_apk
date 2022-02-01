package com.tencent.luggage.wxa.rr;

public class a
{
  private Object[] a;
  
  public static <$1> b<$1> a($1 param$1)
  {
    return (b)new b().a(new Object[] { param$1 });
  }
  
  public static <$1, $2> c<$1, $2> a($1 param$1, $2 param$2)
  {
    return (c)new c().a(new Object[] { param$1, param$2 });
  }
  
  public static <$1, $2, $3> d<$1, $2, $3> a($1 param$1, $2 param$2, $3 param$3)
  {
    return (d)new d().a(new Object[] { param$1, param$2, param$3 });
  }
  
  public static <$1, $2, $3, $4, $5, $6> g<$1, $2, $3, $4, $5, $6> a($1 param$1, $2 param$2, $3 param$3, $4 param$4, $5 param$5, $6 param$6)
  {
    return (g)new g().a(new Object[] { param$1, param$2, param$3, param$4, param$5, param$6 });
  }
  
  public int a()
  {
    Object[] arrayOfObject = this.a;
    if (arrayOfObject == null) {
      return 0;
    }
    return arrayOfObject.length;
  }
  
  public <T> T a(int paramInt)
  {
    Object[] arrayOfObject = this.a;
    if (arrayOfObject.length <= paramInt) {
      return null;
    }
    return arrayOfObject[paramInt];
  }
  
  <T> T a(Object... paramVarArgs)
  {
    this.a = paramVarArgs;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject = this.a;
    int k = arrayOfObject.length;
    int i = 0;
    int j = 1;
    while (i < k)
    {
      Object localObject = arrayOfObject[i];
      if (j != 0) {
        j = 0;
      } else {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(localObject);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rr.a
 * JD-Core Version:    0.7.0.1
 */