import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class bipc<K, V>
{
  private ReferenceQueue<V> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private HashMap<K, bipc<K, V>.bipd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  @Nullable
  public V a(K paramK)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK))
    {
      paramK = (bipd)this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
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
      this.jdField_a_of_type_JavaUtilHashMap.remove(((bipd)localReference).a());
    }
  }
  
  public void a(@NonNull K paramK, @NonNull V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new IllegalArgumentException("key-value cannot be null");
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK)) && (((bipd)this.jdField_a_of_type_JavaUtilHashMap.get(paramK)).get() != null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramK, new bipd(this, paramK, paramV, this.jdField_a_of_type_JavaLangRefReferenceQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipc
 * JD-Core Version:    0.7.0.1
 */