package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ob<D extends nz>
  extends oj<D>
{
  ArrayList<ny<D>> a = new ArrayList();
  private boolean b = true;
  
  private static void a(String paramString, D paramD, List<ny<D>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ny localny = (ny)paramList.next();
      if ((localny instanceof oh)) {
        ((oh)localny).f().b(paramString, paramD);
      } else {
        localny.a(paramString, paramD);
      }
    }
  }
  
  public final ny<D> a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (ny)this.a.get(paramInt);
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      ny localny = (ny)localIterator.next();
      if (localny != null)
      {
        nz localnz;
        if ((localny instanceof oh)) {
          localnz = ((oh)localny).f().b(paramString, paramClass);
        } else {
          localnz = localny.a(paramString, paramClass);
        }
        localObject2 = localnz;
        if (localnz != null) {
          break;
        }
        localObject1 = localnz;
        if (this.b)
        {
          localArrayList.add(localny);
          localObject1 = localnz;
        }
      }
    }
    if ((localObject2 != null) && (!localArrayList.isEmpty())) {
      a(paramString, localObject2, localArrayList);
    }
    return localObject2;
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ny localny = (ny)localIterator.next();
      if (localny != null) {
        if ((localny instanceof oh)) {
          ((oh)localny).f().e();
        } else {
          localny.a();
        }
      }
    }
  }
  
  public final void a(String paramString, D paramD)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ny localny = (ny)localIterator.next();
      if (localny != null) {
        if ((localny instanceof oh)) {
          ((oh)localny).f().b(paramString, paramD);
        } else {
          localny.a(paramString, paramD);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ob
 * JD-Core Version:    0.7.0.1
 */