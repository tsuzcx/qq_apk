package com.tencent.beacon.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class d
{
  private int a;
  private int b;
  private int c;
  private List<e> d = Collections.synchronizedList(new ArrayList());
  
  public final int a()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int b()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(int paramInt)
  {
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<e> c()
  {
    return this.d;
  }
  
  public final void c(int paramInt)
  {
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof d)) || (((d)paramObject).a != this.a)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.c.d
 * JD-Core Version:    0.7.0.1
 */