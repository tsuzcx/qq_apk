package com.tencent.luggage.wxa.rm;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c<_Target extends a>
  implements a, b<_Target>
{
  private List<WeakReference<_Target>> a = new ArrayList();
  private boolean b = true;
  
  public void a()
  {
    try
    {
      boolean bool = this.b;
      if (!bool) {
        return;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          locala.a();
        }
      }
      this.a.clear();
      this.b = false;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(_Target param_Target)
  {
    try
    {
      if (!this.b)
      {
        junit.framework.a.a(param_Target);
        param_Target.a();
        return;
      }
      this.a.add(new WeakReference(param_Target));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rm.c
 * JD-Core Version:    0.7.0.1
 */