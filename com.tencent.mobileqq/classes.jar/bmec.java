import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bmec<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private int jdField_a_of_type_Int;
  private bmef<K, V> jdField_a_of_type_Bmef;
  private WeakHashMap<bmei<K, V>, Boolean> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private bmef<K, V> b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected bmef<K, V> a(K paramK)
  {
    for (bmef localbmef = this.jdField_a_of_type_Bmef;; localbmef = localbmef.jdField_a_of_type_Bmef) {
      if ((localbmef == null) || (localbmef.jdField_a_of_type_JavaLangObject.equals(paramK))) {
        return localbmef;
      }
    }
  }
  
  protected bmef<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new bmef(paramK, paramV);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_b_of_type_Bmef == null)
    {
      this.jdField_a_of_type_Bmef = paramK;
      this.jdField_b_of_type_Bmef = this.jdField_a_of_type_Bmef;
      return paramK;
    }
    this.jdField_b_of_type_Bmef.jdField_a_of_type_Bmef = paramK;
    paramK.jdField_b_of_type_Bmef = this.jdField_b_of_type_Bmef;
    this.jdField_b_of_type_Bmef = paramK;
    return paramK;
  }
  
  public bmec<K, V>.bmeg a()
  {
    bmeg localbmeg = new bmeg(this);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbmeg, Boolean.valueOf(false));
    return localbmeg;
  }
  
  public V a(@NonNull K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.jdField_a_of_type_Int -= 1;
    if (!this.jdField_a_of_type_JavaUtilWeakHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        ((bmei)localIterator.next()).a(paramK);
      }
    }
    if (paramK.jdField_b_of_type_Bmef != null)
    {
      paramK.jdField_b_of_type_Bmef.jdField_a_of_type_Bmef = paramK.jdField_a_of_type_Bmef;
      if (paramK.jdField_a_of_type_Bmef == null) {
        break label134;
      }
      paramK.jdField_a_of_type_Bmef.jdField_b_of_type_Bmef = paramK.jdField_b_of_type_Bmef;
    }
    for (;;)
    {
      paramK.jdField_a_of_type_Bmef = null;
      paramK.jdField_b_of_type_Bmef = null;
      return paramK.jdField_b_of_type_JavaLangObject;
      this.jdField_a_of_type_Bmef = paramK.jdField_a_of_type_Bmef;
      break;
      label134:
      this.jdField_b_of_type_Bmef = paramK.jdField_b_of_type_Bmef;
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bmef localbmef = a(paramK);
    if (localbmef != null) {
      return localbmef.jdField_b_of_type_JavaLangObject;
    }
    a(paramK, paramV);
    return null;
  }
  
  public Iterator<Map.Entry<K, V>> a()
  {
    bmee localbmee = new bmee(this.jdField_b_of_type_Bmef, this.jdField_a_of_type_Bmef);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbmee, Boolean.valueOf(false));
    return localbmee;
  }
  
  public Map.Entry<K, V> a()
  {
    return this.jdField_a_of_type_Bmef;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.jdField_b_of_type_Bmef;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof bmec));
      localObject1 = (bmec)paramObject;
      bool1 = bool2;
    } while (a() != ((bmec)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((bmec)localObject1).iterator();
    for (;;)
    {
      if ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        Object localObject2 = ((Iterator)localObject1).next();
        if (localEntry == null)
        {
          bool1 = bool2;
          if (localObject2 != null) {
            break;
          }
        }
        if ((localEntry != null) && (!localEntry.equals(localObject2))) {
          return false;
        }
      }
    }
    if ((!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext())) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  @NonNull
  public Iterator<Map.Entry<K, V>> iterator()
  {
    bmed localbmed = new bmed(this.jdField_a_of_type_Bmef, this.jdField_b_of_type_Bmef);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbmed, Boolean.valueOf(false));
    return localbmed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmec
 * JD-Core Version:    0.7.0.1
 */