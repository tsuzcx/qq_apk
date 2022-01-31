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
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    Object localObject2 = localObject1;
    if (localIterator.hasNext())
    {
      ny localny = (ny)localIterator.next();
      localObject2 = localObject1;
      if (localny != null) {
        if (!(localny instanceof oh)) {
          break label115;
        }
      }
      label115:
      for (localObject1 = ((oh)localny).f().b(paramString, paramClass);; localObject1 = localny.a(paramString, paramClass))
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label128;
        }
        localObject2 = localObject1;
        if (this.b)
        {
          localArrayList.add(localny);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        break;
      }
    }
    label128:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ob
 * JD-Core Version:    0.7.0.1
 */