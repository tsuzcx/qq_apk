package com.tencent.map.sdk.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class dt
{
  public Number b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public float e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int g()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean h()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public final dw i()
  {
    if ((this instanceof dw)) {
      return (dw)this;
    }
    throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(this)));
  }
  
  public final dq j()
  {
    if ((this instanceof dq)) {
      return (dq)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public final dy k()
  {
    if ((this instanceof dy)) {
      return (dy)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      fg localfg = new fg((Writer)localObject);
      localfg.c = true;
      ep.a(this, localfg);
      localObject = ((StringWriter)localObject).toString();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dt
 * JD-Core Version:    0.7.0.1
 */