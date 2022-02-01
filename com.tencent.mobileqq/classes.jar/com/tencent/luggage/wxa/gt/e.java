package com.tencent.luggage.wxa.gt;

import com.tencent.luggage.wxa.gw.b;

public class e<T>
{
  private T a;
  
  public e(T paramT)
  {
    this.a = paramT;
  }
  
  public T a()
  {
    try
    {
      Object localObject1 = this.a;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public T a(T paramT)
  {
    try
    {
      Object localObject = this.a;
      this.a = paramT;
      paramT = new StringBuilder();
      paramT.append(localObject.toString());
      paramT.append(" -> ");
      paramT.append(this.a.toString());
      b.b("StateRunner", paramT.toString());
      return localObject;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public boolean a(T... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        T ? = paramVarArgs[i];
        boolean bool = this.a.equals(?);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.e
 * JD-Core Version:    0.7.0.1
 */