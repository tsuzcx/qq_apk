package com.tencent.luggage.wxa.b;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

public abstract class h
  implements Serializable
{
  @Deprecated
  public static final h a = a.b;
  @Deprecated
  public static final h b = a.c;
  @Deprecated
  public static final h c = a.a;
  
  public String a(l paraml)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      a(localStringWriter, paraml);
      return localStringWriter.toString();
    }
    catch (IOException paraml)
    {
      throw new RuntimeException(paraml);
    }
  }
  
  abstract void a(i parami);
  
  public void a(Writer paramWriter, l paraml)
  {
    if (paramWriter != null)
    {
      if (paraml != null)
      {
        paramWriter = new m(paramWriter, 128);
        a(paraml.a(paramWriter));
        paramWriter.flush();
        return;
      }
      throw new NullPointerException("config is null");
    }
    throw new NullPointerException("writer is null");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public b c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not an array: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public boolean d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a boolean: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public int f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a number: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public long g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a number: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public double h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a number: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean i()
  {
    return false;
  }
  
  public String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a string: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public boolean k()
  {
    return false;
  }
  
  public e l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not an object: ");
    localStringBuilder.append(toString());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    return a(l.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.h
 * JD-Core Version:    0.7.0.1
 */