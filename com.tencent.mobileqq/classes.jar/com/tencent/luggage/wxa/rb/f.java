package com.tencent.luggage.wxa.rb;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class f<T, E>
{
  private static final s d = new s(Looper.getMainLooper());
  private int a = 0;
  private final Hashtable<T, Object> b = new Hashtable();
  private final HashSet<E> c = new HashSet();
  
  private Vector<T> c()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.b.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    Object localObject1 = c();
    if ((localObject1 != null) && (((Vector)localObject1).size() > 0)) {
      synchronized (this.c)
      {
        ArrayList localArrayList = new ArrayList(this.c);
        this.c.clear();
        a(localArrayList);
        HashMap localHashMap = new HashMap();
        Iterator localIterator1 = ((Vector)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          Object localObject4 = localIterator1.next();
          Object localObject5 = this.b.get(localObject4);
          Iterator localIterator2 = localArrayList.iterator();
          while (localIterator2.hasNext())
          {
            localObject1 = localIterator2.next();
            if ((localObject1 != null) && (localObject5 != null)) {
              if ((localObject5 instanceof f.a))
              {
                f.a locala = (f.a)localObject5;
                f.1 local1 = new f.1(this, localObject4, localObject1);
                if (locala.b != null)
                {
                  ??? = (s)localHashMap.get(locala.b);
                  localObject1 = ???;
                  if (??? == null)
                  {
                    localObject1 = new s(locala.b);
                    localHashMap.put(locala.b, localObject1);
                  }
                  ((s)localObject1).a(local1);
                }
                else if (locala.a != null)
                {
                  ??? = (s)localHashMap.get(locala.a);
                  localObject1 = ???;
                  if (??? == null)
                  {
                    localObject1 = new s(locala.a);
                    localHashMap.put(locala.a, localObject1);
                  }
                  ((s)localObject1).a(local1);
                }
                else
                {
                  d.a(local1);
                }
              }
              else
              {
                a(localObject4, localObject1);
              }
            }
          }
        }
        return;
      }
    }
    this.c.clear();
  }
  
  protected abstract void a(T paramT, E paramE);
  
  public void a(List<E> paramList) {}
  
  public boolean a()
  {
    return this.a > 0;
  }
  
  public boolean a(E paramE)
  {
    synchronized (this.c)
    {
      boolean bool = this.c.add(paramE);
      return bool;
    }
  }
  
  public void b()
  {
    if (!a()) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.f
 * JD-Core Version:    0.7.0.1
 */