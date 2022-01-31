import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bhvv<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private int jdField_a_of_type_Int;
  private bhvy<K, V> jdField_a_of_type_Bhvy;
  private WeakHashMap<bhwb<K, V>, Boolean> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private bhvy<K, V> b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected bhvy<K, V> a(K paramK)
  {
    for (bhvy localbhvy = this.jdField_a_of_type_Bhvy;; localbhvy = localbhvy.jdField_a_of_type_Bhvy) {
      if ((localbhvy == null) || (localbhvy.jdField_a_of_type_JavaLangObject.equals(paramK))) {
        return localbhvy;
      }
    }
  }
  
  protected bhvy<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new bhvy(paramK, paramV);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_b_of_type_Bhvy == null)
    {
      this.jdField_a_of_type_Bhvy = paramK;
      this.jdField_b_of_type_Bhvy = this.jdField_a_of_type_Bhvy;
      return paramK;
    }
    this.jdField_b_of_type_Bhvy.jdField_a_of_type_Bhvy = paramK;
    paramK.jdField_b_of_type_Bhvy = this.jdField_b_of_type_Bhvy;
    this.jdField_b_of_type_Bhvy = paramK;
    return paramK;
  }
  
  public bhvv<K, V>.bhvz a()
  {
    bhvz localbhvz = new bhvz(this);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbhvz, Boolean.valueOf(false));
    return localbhvz;
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
        ((bhwb)localIterator.next()).a(paramK);
      }
    }
    if (paramK.jdField_b_of_type_Bhvy != null)
    {
      paramK.jdField_b_of_type_Bhvy.jdField_a_of_type_Bhvy = paramK.jdField_a_of_type_Bhvy;
      if (paramK.jdField_a_of_type_Bhvy == null) {
        break label134;
      }
      paramK.jdField_a_of_type_Bhvy.jdField_b_of_type_Bhvy = paramK.jdField_b_of_type_Bhvy;
    }
    for (;;)
    {
      paramK.jdField_a_of_type_Bhvy = null;
      paramK.jdField_b_of_type_Bhvy = null;
      return paramK.jdField_b_of_type_JavaLangObject;
      this.jdField_a_of_type_Bhvy = paramK.jdField_a_of_type_Bhvy;
      break;
      label134:
      this.jdField_b_of_type_Bhvy = paramK.jdField_b_of_type_Bhvy;
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bhvy localbhvy = a(paramK);
    if (localbhvy != null) {
      return localbhvy.jdField_b_of_type_JavaLangObject;
    }
    a(paramK, paramV);
    return null;
  }
  
  public Iterator<Map.Entry<K, V>> a()
  {
    bhvx localbhvx = new bhvx(this.jdField_b_of_type_Bhvy, this.jdField_a_of_type_Bhvy);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbhvx, Boolean.valueOf(false));
    return localbhvx;
  }
  
  public Map.Entry<K, V> a()
  {
    return this.jdField_a_of_type_Bhvy;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.jdField_b_of_type_Bhvy;
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
      } while (!(paramObject instanceof bhvv));
      localObject1 = (bhvv)paramObject;
      bool1 = bool2;
    } while (a() != ((bhvv)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((bhvv)localObject1).iterator();
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
    bhvw localbhvw = new bhvw(this.jdField_a_of_type_Bhvy, this.jdField_b_of_type_Bhvy);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbhvw, Boolean.valueOf(false));
    return localbhvw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvv
 * JD-Core Version:    0.7.0.1
 */