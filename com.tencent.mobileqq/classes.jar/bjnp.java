import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjnp<K, V>
  extends bjnq<K, V>
{
  private HashMap<K, bjnt<K, V>> a = new HashMap();
  
  protected bjnt<K, V> a(K paramK)
  {
    return (bjnt)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK)
  {
    Object localObject = super.a(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bjnt localbjnt = a(paramK);
    if (localbjnt != null) {
      return localbjnt.jdField_b_of_type_JavaLangObject;
    }
    this.a.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public Map.Entry<K, V> a(K paramK)
  {
    if (a(paramK)) {
      return ((bjnt)this.a.get(paramK)).jdField_b_of_type_Bjnt;
    }
    return null;
  }
  
  public boolean a(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnp
 * JD-Core Version:    0.7.0.1
 */