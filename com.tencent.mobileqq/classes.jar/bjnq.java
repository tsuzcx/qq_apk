import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjnq<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private int jdField_a_of_type_Int;
  private bjnt<K, V> jdField_a_of_type_Bjnt;
  private WeakHashMap<bjnw<K, V>, Boolean> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private bjnt<K, V> b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected bjnt<K, V> a(K paramK)
  {
    for (bjnt localbjnt = this.jdField_a_of_type_Bjnt;; localbjnt = localbjnt.jdField_a_of_type_Bjnt) {
      if ((localbjnt == null) || (localbjnt.jdField_a_of_type_JavaLangObject.equals(paramK))) {
        return localbjnt;
      }
    }
  }
  
  protected bjnt<K, V> a(@NonNull K paramK, @NonNull V paramV)
  {
    paramK = new bjnt(paramK, paramV);
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_b_of_type_Bjnt == null)
    {
      this.jdField_a_of_type_Bjnt = paramK;
      this.jdField_b_of_type_Bjnt = this.jdField_a_of_type_Bjnt;
      return paramK;
    }
    this.jdField_b_of_type_Bjnt.jdField_a_of_type_Bjnt = paramK;
    paramK.jdField_b_of_type_Bjnt = this.jdField_b_of_type_Bjnt;
    this.jdField_b_of_type_Bjnt = paramK;
    return paramK;
  }
  
  public bjnq<K, V>.bjnu a()
  {
    bjnu localbjnu = new bjnu(this);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjnu, Boolean.valueOf(false));
    return localbjnu;
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
        ((bjnw)localIterator.next()).a(paramK);
      }
    }
    if (paramK.jdField_b_of_type_Bjnt != null)
    {
      paramK.jdField_b_of_type_Bjnt.jdField_a_of_type_Bjnt = paramK.jdField_a_of_type_Bjnt;
      if (paramK.jdField_a_of_type_Bjnt == null) {
        break label134;
      }
      paramK.jdField_a_of_type_Bjnt.jdField_b_of_type_Bjnt = paramK.jdField_b_of_type_Bjnt;
    }
    for (;;)
    {
      paramK.jdField_a_of_type_Bjnt = null;
      paramK.jdField_b_of_type_Bjnt = null;
      return paramK.jdField_b_of_type_JavaLangObject;
      this.jdField_a_of_type_Bjnt = paramK.jdField_a_of_type_Bjnt;
      break;
      label134:
      this.jdField_b_of_type_Bjnt = paramK.jdField_b_of_type_Bjnt;
    }
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bjnt localbjnt = a(paramK);
    if (localbjnt != null) {
      return localbjnt.jdField_b_of_type_JavaLangObject;
    }
    a(paramK, paramV);
    return null;
  }
  
  public Iterator<Map.Entry<K, V>> a()
  {
    bjns localbjns = new bjns(this.jdField_b_of_type_Bjnt, this.jdField_a_of_type_Bjnt);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjns, Boolean.valueOf(false));
    return localbjns;
  }
  
  public Map.Entry<K, V> a()
  {
    return this.jdField_a_of_type_Bjnt;
  }
  
  public Map.Entry<K, V> b()
  {
    return this.jdField_b_of_type_Bjnt;
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
      } while (!(paramObject instanceof bjnq));
      localObject1 = (bjnq)paramObject;
      bool1 = bool2;
    } while (a() != ((bjnq)localObject1).a());
    paramObject = iterator();
    Object localObject1 = ((bjnq)localObject1).iterator();
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
    bjnr localbjnr = new bjnr(this.jdField_a_of_type_Bjnt, this.jdField_b_of_type_Bjnt);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(localbjnr, Boolean.valueOf(false));
    return localbjnr;
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
 * Qualified Name:     bjnq
 * JD-Core Version:    0.7.0.1
 */