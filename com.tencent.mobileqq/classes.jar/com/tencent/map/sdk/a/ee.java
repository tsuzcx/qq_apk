package com.tencent.map.sdk.a;

import java.io.IOException;
import java.util.List;

public abstract class ee<T>
{
  public final dt a(T paramT)
  {
    try
    {
      ev localev = new ev();
      a(localev, paramT);
      if (localev.a.isEmpty()) {
        return localev.b;
      }
      paramT = new StringBuilder("Expected one JSON element but was ");
      paramT.append(localev.a);
      throw new IllegalStateException(paramT.toString());
    }
    catch (IOException paramT)
    {
      throw new du(paramT);
    }
  }
  
  public abstract T a(fe paramfe);
  
  public abstract void a(fg paramfg, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ee
 * JD-Core Version:    0.7.0.1
 */