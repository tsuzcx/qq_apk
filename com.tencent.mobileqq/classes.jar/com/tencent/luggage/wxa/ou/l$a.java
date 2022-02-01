package com.tencent.luggage.wxa.ou;

public class l$a
{
  private static l a;
  private static l.a.a b;
  
  public static l a()
  {
    try
    {
      if (a == null)
      {
        if (b == null)
        {
          localObject1 = b.a;
          a = (l)localObject1;
          return localObject1;
        }
        a = b.a();
        if (a == null) {
          a = b.a;
        }
        localObject1 = a;
        return localObject1;
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.l.a
 * JD-Core Version:    0.7.0.1
 */