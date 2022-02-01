import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class bpbk<K, V>
{
  private ReferenceQueue<V> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private HashMap<K, bpbk<K, V>.bpbl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  @Nullable
  public V a(K paramK)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK))
    {
      paramK = (bpbl)this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
      if (paramK.get() != null) {
        return paramK.get();
      }
    }
    return null;
  }
  
  public void a()
  {
    for (;;)
    {
      Reference localReference = this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localReference == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(((bpbl)localReference).a());
    }
  }
  
  public void a(@NonNull K paramK, @NonNull V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new IllegalArgumentException("key-value cannot be null");
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK)) && (((bpbl)this.jdField_a_of_type_JavaUtilHashMap.get(paramK)).get() != null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramK, new bpbl(this, paramK, paramV, this.jdField_a_of_type_JavaLangRefReferenceQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbk
 * JD-Core Version:    0.7.0.1
 */