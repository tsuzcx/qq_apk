import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjog<K, V>
  extends bjoh<K, V>
{
  private HashMap<K, bjok<K, V>> a = new HashMap();
  
  protected bjok<K, V> a(K paramK)
  {
    return (bjok)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK)
  {
    Object localObject = super.a(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bjok localbjok = a(paramK);
    if (localbjok != null) {
      return localbjok.jdField_b_of_type_JavaLangObject;
    }
    this.a.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public Map.Entry<K, V> a(K paramK)
  {
    if (a(paramK)) {
      return ((bjok)this.a.get(paramK)).jdField_b_of_type_Bjok;
    }
    return null;
  }
  
  public boolean a(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjog
 * JD-Core Version:    0.7.0.1
 */