import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bgir<K, V>
  implements Map<K, V>
{
  private final HashMap<K, V> a = new HashMap();
  private final HashMap<V, K> b = new HashMap();
  
  public K a(Object paramObject)
  {
    return this.b.get(paramObject);
  }
  
  public K b(Object paramObject)
  {
    paramObject = this.b.remove(paramObject);
    if (paramObject != null) {
      this.a.remove(paramObject);
    }
    return paramObject;
  }
  
  public void clear()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.b.containsKey(paramObject);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return this.a.entrySet();
  }
  
  public V get(Object paramObject)
  {
    return this.a.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return this.a.keySet();
  }
  
  public V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      return null;
    }
    Object localObject = remove(paramK);
    b(paramV);
    this.a.put(paramK, paramV);
    this.b.put(paramV, paramK);
    return localObject;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject2 != null)) {
        put(localObject1, localObject2);
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    paramObject = this.a.remove(paramObject);
    if (paramObject != null) {
      this.b.remove(paramObject);
    }
    return paramObject;
  }
  
  public int size()
  {
    return this.a.size();
  }
  
  public Collection<V> values()
  {
    return this.a.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgir
 * JD-Core Version:    0.7.0.1
 */