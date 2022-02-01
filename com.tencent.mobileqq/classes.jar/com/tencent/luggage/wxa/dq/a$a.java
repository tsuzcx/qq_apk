package com.tencent.luggage.wxa.dq;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class a$a<Component extends c>
{
  @Nullable
  private Component c;
  private final Map<Class, Object> d = new HashMap(2);
  
  public a$a(@NonNull Component paramComponent)
  {
    this.c = paramComponent;
  }
  
  public <T> T a(Class<T> paramClass)
  {
    synchronized (this.d)
    {
      Object localObject1 = paramClass.cast(this.d.get(paramClass));
      if (localObject1 == null)
      {
        localObject1 = this.d.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (paramClass.isInstance(localObject2))
          {
            paramClass = paramClass.cast(localObject2);
            return paramClass;
          }
        }
        return null;
      }
      return localObject1;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  protected void a(a parama)
  {
    synchronized (this.d)
    {
      this.d.putAll(parama.d);
      return;
    }
  }
  
  protected final <T> void a(@NonNull Class<T> paramClass, @NonNull T paramT)
  {
    synchronized (this.d)
    {
      this.d.put(paramClass, paramT);
      return;
    }
  }
  
  protected final void x()
  {
    synchronized (this.d)
    {
      this.d.clear();
      try
      {
        o.c("Luggage.AppBrandLogicFactory", "cleanup stack:%s", new Object[] { Log.getStackTraceString(new Throwable()) });
        this.c = null;
        return;
      }
      finally {}
    }
  }
  
  @Nullable
  public final Component y()
  {
    try
    {
      c localc = this.c;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final Collection<Object> z()
  {
    synchronized (this.d)
    {
      LinkedList localLinkedList = new LinkedList(this.d.values());
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.a.a
 * JD-Core Version:    0.7.0.1
 */