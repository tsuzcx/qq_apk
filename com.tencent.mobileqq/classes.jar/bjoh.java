import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjoh<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private int jdField_a_of_type_Int;
  private bjok<K, V> jdField_a_of_type_Bjok;
  private WeakHashMap<bjon<K, V>, Boolean> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private bjok<K, V> b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected bjok<K, V> a(K paramK)
  {
    for (bjok localbjok = this.jdField_a_of_type_Bjok;; localbjok = localbjok.jdField_a_of_type_Bjok) {
      if ((localbjok == null) || (localbjok.jdField_a_of_type_JavaLangObject.equals(paramK))) {
        return localbjok;
      }
    }
  }
  
  protected bjok<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new bjok(paramK, paramV);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_b_of_type_Bjok == null)
    {
      this.jdField_a_of_type_Bjok = paramK;
      this.jdField_b_of_type_Bjok = this.jdField_a_of_type_Bjok;
      return paramK;
    }
    this.jdField_b_of_type_Bjok.jdField_a_of_type_Bjok = paramK;
    paramK.jdField_b_of_type_Bjok = this.jdField_b_of_type_Bjok;
    this.jdField_b_of_type_Bjok = paramK;
    return paramK;
  }
  
  public bjoh<K, V>.bjol a()
  {
    bjol localbjol = new bjol(this);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjol, Boolean.valueOf(false));
    return localbjol;
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
        ((bjon)localIterator.next()).a(paramK);
      }
    }
    if (paramK.jdField_b_of_type_Bjok != null)
    {
      paramK.jdField_b_of_type_Bjok.jdField_a_of_type_Bjok = paramK.jdField_a_of_type_Bjok;
      if (paramK.jdField_a_of_type_Bjok == null) {
        break label134;
      }
      paramK.jdField_a_of_type_Bjok.jdField_b_of_type_Bjok = paramK.jdField_b_of_type_Bjok;
    }
    for (;;)
    {
      paramK.jdField_a_of_type_Bjok = null;
      paramK.jdField_b_of_type_Bjok = null;
      return paramK.jdField_b_of_type_JavaLangObject;
      this.jdField_a_of_type_Bjok = paramK.jdField_a_of_type_Bjok;
      break;
      label134:
      this.jdField_b_of_type_Bjok = paramK.jdField_b_of_type_Bjok;
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bjok localbjok = a(paramK);
    if (localbjok != null) {
      return localbjok.jdField_b_of_type_JavaLangObject;
    }
    a(paramK, paramV);
    return null;
  }
  
  public Iterator<Map.Entry<K, V>> a()
  {
    bjoj localbjoj = new bjoj(this.jdField_b_of_type_Bjok, this.jdField_a_of_type_Bjok);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjoj, Boolean.valueOf(false));
    return localbjoj;
  }
  
  public Map.Entry<K, V> a()
  {
    return this.jdField_a_of_type_Bjok;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.jdField_b_of_type_Bjok;
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
      } while (!(paramObject instanceof bjoh));
      localObject1 = (bjoh)paramObject;
      bool1 = bool2;
    } while (a() != ((bjoh)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((bjoh)localObject1).iterator();
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
    bjoi localbjoi = new bjoi(this.jdField_a_of_type_Bjok, this.jdField_b_of_type_Bjok);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjoi, Boolean.valueOf(false));
    return localbjoi;
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
 * Qualified Name:     bjoh
 * JD-Core Version:    0.7.0.1
 */