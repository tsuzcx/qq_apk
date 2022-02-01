package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class hl<T extends hl.a>
{
  public final ho a;
  private final int b;
  private Set<T> c;
  private List<hl<T>> d = null;
  
  private hl(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new ho(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
  }
  
  public hl(ho paramho)
  {
    this(paramho, 0);
  }
  
  private hl(ho paramho, int paramInt)
  {
    this.a = paramho;
    this.b = paramInt;
  }
  
  private void a()
  {
    this.d = new ArrayList(4);
    this.d.add(new hl(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.d.add(new hl(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.d.add(new hl(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.d.add(new hl(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
    Object localObject = this.c;
    this.c = null;
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      hl.a locala = (hl.a)((Iterator)localObject).next();
      a(locala.getItemPoint().x, locala.getItemPoint().y, locala);
    }
  }
  
  private void a(ho paramho, Collection<T> paramCollection)
  {
    if (!this.a.a(paramho)) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((hl)((Iterator)localObject).next()).a(paramho, paramCollection);
      }
      return;
    }
    if (this.c != null)
    {
      localObject = this.a;
      int i;
      if ((((ho)localObject).a >= paramho.a) && (((ho)localObject).c <= paramho.c) && (((ho)localObject).b >= paramho.b) && (((ho)localObject).d <= paramho.d)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramCollection.addAll(this.c);
        return;
      }
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        hl.a locala = (hl.a)((Iterator)localObject).next();
        DoublePoint localDoublePoint = locala.getItemPoint();
        if (paramho.a(localDoublePoint.x, localDoublePoint.y)) {
          paramCollection.add(locala);
        }
      }
    }
  }
  
  public final Collection<T> a(ho paramho)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramho, localArrayList);
    return localArrayList;
  }
  
  public final void a(double paramDouble1, double paramDouble2, T paramT)
  {
    hl localhl = this;
    while (localhl.d != null) {
      if (paramDouble2 < localhl.a.f)
      {
        if (paramDouble1 < localhl.a.e) {
          localhl = (hl)localhl.d.get(0);
        } else {
          localhl = (hl)localhl.d.get(1);
        }
      }
      else if (paramDouble1 < localhl.a.e) {
        localhl = (hl)localhl.d.get(2);
      } else {
        localhl = (hl)localhl.d.get(3);
      }
    }
    if (localhl.c == null) {
      localhl.c = new HashSet();
    }
    localhl.c.add(paramT);
    if ((localhl.c.size() > 50) && (localhl.b < 40)) {
      localhl.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hl
 * JD-Core Version:    0.7.0.1
 */