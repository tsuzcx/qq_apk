import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bmeb<K, V>
  extends bmec<K, V>
{
  private HashMap<K, bmef<K, V>> a = new HashMap();
  
  protected bmef<K, V> a(K paramK)
  {
    return (bmef)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK)
  {
    Object localObject = super.a(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bmef localbmef = a(paramK);
    if (localbmef != null) {
      return localbmef.jdField_b_of_type_JavaLangObject;
    }
    this.a.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public Map.Entry<K, V> a(K paramK)
  {
    if (a(paramK)) {
      return ((bmef)this.a.get(paramK)).jdField_b_of_type_Bmef;
    }
    return null;
  }
  
  public boolean a(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeb
 * JD-Core Version:    0.7.0.1
 */