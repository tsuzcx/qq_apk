package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class fc$18
  extends ee<dt>
{
  private void a(fg paramfg, dt paramdt)
  {
    if ((paramdt == null) || ((paramdt instanceof dv)))
    {
      paramfg.e();
      return;
    }
    if ((paramdt instanceof dy))
    {
      paramdt = paramdt.k();
      if ((paramdt.a instanceof Number))
      {
        paramfg.a(paramdt.b());
        return;
      }
      if ((paramdt.a instanceof Boolean))
      {
        paramfg.a(paramdt.h());
        return;
      }
      paramfg.b(paramdt.c());
      return;
    }
    if ((paramdt instanceof dq))
    {
      paramfg.a();
      paramdt = paramdt.j().iterator();
      while (paramdt.hasNext()) {
        a(paramfg, (dt)paramdt.next());
      }
      paramfg.b();
      return;
    }
    if ((paramdt instanceof dw))
    {
      paramfg.c();
      paramdt = paramdt.i().a.entrySet().iterator();
      while (paramdt.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramdt.next();
        paramfg.a((String)localEntry.getKey());
        a(paramfg, (dt)localEntry.getValue());
      }
      paramfg.d();
      return;
    }
    throw new IllegalArgumentException("Couldn't write " + paramdt.getClass());
  }
  
  private dt b(fe paramfe)
  {
    switch (fc.26.a[paramfe.f().ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 3: 
      return new dy(paramfe.i());
    case 1: 
      return new dy(new el(paramfe.i()));
    case 2: 
      return new dy(Boolean.valueOf(paramfe.j()));
    case 4: 
      paramfe.k();
      return dv.a;
    case 5: 
      localObject = new dq();
      paramfe.a();
      while (paramfe.e()) {
        ((dq)localObject).a(b(paramfe));
      }
      paramfe.b();
      return localObject;
    }
    Object localObject = new dw();
    paramfe.c();
    while (paramfe.e()) {
      ((dw)localObject).a(paramfe.h(), b(paramfe));
    }
    paramfe.d();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.18
 * JD-Core Version:    0.7.0.1
 */