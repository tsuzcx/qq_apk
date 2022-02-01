package com.tencent.luggage.wxa.fa;

import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.qz.t;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/WxaRuntimeStore$runtimeMap$1", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/luggage/standalone_ext/Runtime;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$b
  extends LinkedHashMap<String, d>
{
  public d a(String paramString, d paramd)
  {
    return (d)super.getOrDefault(paramString, paramd);
  }
  
  public Set a()
  {
    return super.entrySet();
  }
  
  public boolean a(d paramd)
  {
    return super.containsValue(paramd);
  }
  
  public boolean a(String paramString)
  {
    return super.containsKey(paramString);
  }
  
  public d b(String paramString)
  {
    return (d)super.get(paramString);
  }
  
  public Set b()
  {
    return super.keySet();
  }
  
  public boolean b(String paramString, d paramd)
  {
    return super.remove(paramString, paramd);
  }
  
  public d c(String paramString)
  {
    return (d)super.remove(paramString);
  }
  
  public Collection c()
  {
    return super.values();
  }
  
  public final boolean containsKey(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return a((String)paramObject);
    }
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return a((d)paramObject);
    }
    return false;
  }
  
  public int d()
  {
    return super.size();
  }
  
  public final Set<Map.Entry<String, d>> entrySet()
  {
    return a();
  }
  
  public final Object get(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return b((String)paramObject);
    }
    return null;
  }
  
  public final Object getOrDefault(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof String)) {
      return a((String)paramObject1, (d)paramObject2);
    }
    return paramObject2;
  }
  
  public final Set<String> keySet()
  {
    return b();
  }
  
  public final Object remove(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return c((String)paramObject);
    }
    return null;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof d))) {
      return b((String)paramObject1, (d)paramObject2);
    }
    return false;
  }
  
  protected boolean removeEldestEntry(@Nullable Map.Entry<String, d> paramEntry)
  {
    if (size() > b.a.a())
    {
      if (paramEntry != null)
      {
        paramEntry = (d)paramEntry.getValue();
        if (paramEntry != null) {
          t.a((Runnable)new b.b.a(paramEntry));
        }
      }
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return d();
  }
  
  public final Collection<d> values()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fa.b.b
 * JD-Core Version:    0.7.0.1
 */