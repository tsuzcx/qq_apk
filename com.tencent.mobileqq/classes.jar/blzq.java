import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class blzq<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private int jdField_a_of_type_Int;
  private blzt<K, V> jdField_a_of_type_Blzt;
  private WeakHashMap<blzw<K, V>, Boolean> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private blzt<K, V> b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected blzt<K, V> a(K paramK)
  {
    for (blzt localblzt = this.jdField_a_of_type_Blzt;; localblzt = localblzt.jdField_a_of_type_Blzt) {
      if ((localblzt == null) || (localblzt.jdField_a_of_type_JavaLangObject.equals(paramK))) {
        return localblzt;
      }
    }
  }
  
  protected blzt<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new blzt(paramK, paramV);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_b_of_type_Blzt == null)
    {
      this.jdField_a_of_type_Blzt = paramK;
      this.jdField_b_of_type_Blzt = this.jdField_a_of_type_Blzt;
      return paramK;
    }
    this.jdField_b_of_type_Blzt.jdField_a_of_type_Blzt = paramK;
    paramK.jdField_b_of_type_Blzt = this.jdField_b_of_type_Blzt;
    this.jdField_b_of_type_Blzt = paramK;
    return paramK;
  }
  
  public blzq<K, V>.blzu a()
  {
    blzu localblzu = new blzu(this);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localblzu, Boolean.valueOf(false));
    return localblzu;
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
        ((blzw)localIterator.next()).a(paramK);
      }
    }
    if (paramK.jdField_b_of_type_Blzt != null)
    {
      paramK.jdField_b_of_type_Blzt.jdField_a_of_type_Blzt = paramK.jdField_a_of_type_Blzt;
      if (paramK.jdField_a_of_type_Blzt == null) {
        break label134;
      }
      paramK.jdField_a_of_type_Blzt.jdField_b_of_type_Blzt = paramK.jdField_b_of_type_Blzt;
    }
    for (;;)
    {
      paramK.jdField_a_of_type_Blzt = null;
      paramK.jdField_b_of_type_Blzt = null;
      return paramK.jdField_b_of_type_JavaLangObject;
      this.jdField_a_of_type_Blzt = paramK.jdField_a_of_type_Blzt;
      break;
      label134:
      this.jdField_b_of_type_Blzt = paramK.jdField_b_of_type_Blzt;
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    blzt localblzt = a(paramK);
    if (localblzt != null) {
      return localblzt.jdField_b_of_type_JavaLangObject;
    }
    a(paramK, paramV);
    return null;
  }
  
  public Iterator<Map.Entry<K, V>> a()
  {
    blzs localblzs = new blzs(this.jdField_b_of_type_Blzt, this.jdField_a_of_type_Blzt);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localblzs, Boolean.valueOf(false));
    return localblzs;
  }
  
  public Map.Entry<K, V> a()
  {
    return this.jdField_a_of_type_Blzt;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.jdField_b_of_type_Blzt;
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
      } while (!(paramObject instanceof blzq));
      localObject1 = (blzq)paramObject;
      bool1 = bool2;
    } while (a() != ((blzq)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((blzq)localObject1).iterator();
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
    blzr localblzr = new blzr(this.jdField_a_of_type_Blzt, this.jdField_b_of_type_Blzt);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localblzr, Boolean.valueOf(false));
    return localblzr;
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
 * Qualified Name:     blzq
 * JD-Core Version:    0.7.0.1
 */